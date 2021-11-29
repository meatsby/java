package racingcar.racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import racingcar.utils.RandomUtils;

public class Game {
    // 자동차 이름 입력
    // 시도할 횟수 입력
    // for 시도할 횟수
    // for 객체 인 자동차
    // move or stop
    // 현재 상황 출력

    private Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] input = scanner.nextLine().split(",");
        // 이름 길이가 적절한지

        Car[] cars = new Car[input.length];
        for (int i = 0; i < input.length; i++) {
            cars[i] = new Car(input[i]);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String round = scanner.nextLine();
        // 1 이상의 정수인지

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < Integer.parseInt(round); i++) {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + car.getPosition());
            }
            System.out.println();
        }

        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }

        ArrayList<String> champs = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == max) {
                champs.add(car.getName());
            }
        }

        System.out.println(champs);
    }
}
