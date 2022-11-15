import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadTest {

    private static final Logger log = LoggerFactory.getLogger(ThreadTest.class);

    @Test
    void executorTest() {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> log.info("Hello World"));
    }

    @Test
    void executorServiceTest() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> "Hello World");
        String result = future.get();

        assertThat(result).isEqualTo("Hello World");
    }

    @Test
    void newFixedThreadPoolTest() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executor.submit(sleepThread());
        executor.submit(sleepThread());
        executor.submit(sleepThread());

        assertAll(() -> {
            assertThat(executor.getPoolSize()).isEqualTo(2);
            assertThat(executor.getQueue().size()).isEqualTo(1);
        });
    }

    @Test
    void newCachedThreadPoolTest() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.submit(sleepThread());
        executor.submit(sleepThread());
        executor.submit(sleepThread());

        assertAll(() -> {
            assertThat(executor.getPoolSize()).isEqualTo(3);
            assertThat(executor.getQueue().size()).isEqualTo(0);
        });
    }

    @Test
    void newSingleThreadExecutorTest() {
        AtomicInteger counter = new AtomicInteger();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> counter.set(1));
        executor.submit(() -> counter.compareAndSet(1, 2));
    }

    @Test
    void scheduleTest() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.schedule(() -> {
            log.info("Hello World");
        }, 500, TimeUnit.MILLISECONDS);
    }

    @Test
    void scheduleAtFixedRateTest() throws InterruptedException {
        CountDownLatch lock = new CountDownLatch(3);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        ScheduledFuture<?> future = executor.scheduleAtFixedRate(() -> {
            log.info("Hello World");
            lock.countDown();
        }, 500, 100, TimeUnit.MILLISECONDS);

        lock.await(1000, TimeUnit.MILLISECONDS);
        future.cancel(true);
    }

    private Runnable sleepThread() {
        return () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
