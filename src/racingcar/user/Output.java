package racingcar.user;

import java.util.ArrayList;

import racingcar.Car;

public class Output {
	private static final String DISTANCE = "-";
	private static final String ROUND_RESULT = "실행 결과";
	private static final String CHAMPION = "최종 우승자 : ";

	public static void startRound(String round, Car[] cars) {
		System.out.println();
		System.out.println(ROUND_RESULT);
		for (int i = 0; i < Integer.parseInt(round); i++) {
			moveCars(cars);
			System.out.println();
		}
	}

	private static void moveCars(Car[] cars) {
		for (Car car : cars) {
			car.move();
			printResult(car);
		}
	}

	private static void printResult(Car car) {
		System.out.print(car.getName() + " : ");
		printDistance(car.getPosition());
		System.out.println();
	}

	private static void printDistance(int result) {
		for (int i = 0; i < result; i++) {
			System.out.print(DISTANCE);
		}
	}

	public static void printChampionList(ArrayList<String> champion) {
		System.out.print(CHAMPION + champion.get(0));
		for (int i = 1; i < champion.size(); i++) {
			System.out.print(", " + champion.get(i));
		}
	}
}
