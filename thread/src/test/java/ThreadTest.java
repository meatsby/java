import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import org.junit.jupiter.api.Test;

public class ThreadTest {

    @Test
    void executorTest() {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("Hello World"));
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
