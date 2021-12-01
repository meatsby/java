package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class Game {

	private String[] carNames;
	private int numOfCars;
	private Car[] cars;
	private String round;

	public void start() {
		while (true) {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

			try {
				carNames = Console.readLine().split(",");
				isValid(carNames);
				numOfCars = carNames.length;

				cars = new Car[numOfCars];
				for (int i = 0; i < numOfCars; i++) {
					cars[i] = new Car(carNames[i]);
				}
				hasEnough(cars);
				// System.out.println(Arrays.toString(cars));
				break;

			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 자동차 이름의 길이는 5 이하여야 합니다.");
			}
		}

		while (true) {
			System.out.println("시도할 횟수는 몇회인가요?");

			try {
				round = Console.readLine();
				isValid(round);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 시도 횟수는 1 이상의 정수여야 합니다.");
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
		System.out.print("최종 우승자 : " + champs.get(0));
		for (int i = 1; i < champs.size(); i++) {
			System.out.print(", " + champs.get(i));
		}
	}

	private void isValid(String[] carNames) {
		for (String carName : carNames) {
			if (carName.length() > 5) {
				throw new IllegalArgumentException();
			}
		}
	}

	private void hasEnough(Car[] cars) {
		if (cars.length < 1) {
			throw new IllegalArgumentException();
		}
	}

	private void isValid(String round) {
		for (int i = 0; i < round.length(); i++) {
			if (!Character.isDigit(round.charAt(i))) {
				throw new IllegalArgumentException();
			}
		}
		if (Integer.parseInt(round) < 1) {
			throw new IllegalArgumentException();
		}
	}
}
