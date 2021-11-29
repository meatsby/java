package racingcar.racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private final Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startGame() {
        // 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] input = scanner.nextLine().split(",");

        // 예외처리 : 이름 길이가 적절한지
        for (String car : input) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        // Car 객체 생성
        Car[] cars = new Car[input.length];
        for (int i = 0; i < input.length; i++) {
            cars[i] = new Car(input[i]);
        }

        // 시도할 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        String round = scanner.nextLine();

        // 예외처리 : 1 이상의 정수인지
        if (Integer.parseInt(round) < 1) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < round.length(); i++) {
            if (!Character.isDigit(round.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }

        // 게임 진행 출력
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < Integer.parseInt(round); i++) {
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
}
