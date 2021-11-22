package Precourse1.utils;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    public static int nextInt(final int startInclusive, final int endInclusive) {

        // 최소범위가 최대범위보다 클 경우
        // e.g. (9~1)
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException();
        }

        // 최소범위가 0보다 작을 경우
        // e.g. (-1, 9)
        if (startInclusive < 0) {
            throw new IllegalArgumentException();
        }

        // 최소범위와 최대범위가 같을 경우
        // e.g. (1~1) -> 1 반환
        if (startInclusive == endInclusive) {
            return startInclusive;
        }

        // 1 + (0~8) 반환
        return startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1);
    }
}
