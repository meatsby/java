package racingcarTut.racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    private final Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startGame() {
        // 자동차 이름 입력
        // 예외처리 : 이름 길이가 적절한지
        String[] input;
        Car[] cars;
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                input = isValidCarNameLength(scanner.nextLine().split(","));
                System.out.println(Arrays.toString(input));
                // Car 객체 생성
                cars = new Car[input.length];
                for (int i = 0; i < input.length; i++) {
                    cars[i] = new Car(input[i]);
                }
                hasEnoughCars(cars);
                System.out.println(cars.length);
                break;
            } catch (CarNameLengthException e) {
                System.out.println("[ERROR] 자동차 이름의 길이는 5 이하여야 합니다.");
            } catch (NotEnoughCarsException e) {
                System.out.println("[ERROR] 자동차 갯수는 1 이상이여야 합니다.");
            }
        }

        // 시도할 횟수 입력
        // 예외처리 : 1 이상의 정수인지
        int round;
        while (true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                round = Integer.parseInt(scanner.nextLine());
                lessThanOne(round);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다.");
            } catch (LessThanOneException e) {
                System.out.println("[ERROR] 시도 횟수는 1 이상의 정수여야 합니다.");
            }
        }

        // 게임 진행 출력
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            for (Car car : cars) {
                car.move();
                System.out.print(car.getName() + " : ");
                for (int j = 0; j < car.getPosition(); j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        // 최고기록 저장
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }

        // 우승자 확인
        ArrayList<String> champs = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == max) {
                champs.add(car.getName());
            }
        }

        // 우승자 출력
        System.out.print("최종 우승자: " + champs.get(0));
        for (int i = 1; i < champs.size(); i++) {
            System.out.print(", " + champs.get(i));
        }
    }

    private void hasEnoughCars(Car[] cars) {
        if (cars.length < 1) {
            throw new NotEnoughCarsException();
        }
    }

    private void lessThanOne(int round) {
        if (round < 1) {
            throw new LessThanOneException();
        }
    }

    private String[] isValidCarNameLength(String[] input) {
        for (String car : input) {
            if (car.length() > 5 | car.length() < 1) {
                throw new CarNameLengthException();
            }
        }
        return input;
    }
}
