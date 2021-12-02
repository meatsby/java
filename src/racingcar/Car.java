package racingcar;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;
    private static final Random random = new Random();

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void move() {
        if (random.nextInt(10) > 3) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
