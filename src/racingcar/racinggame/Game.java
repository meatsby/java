package racingcar.racinggame;

import java.util.ArrayList;

import racingcar.Car;
import racingcar.user.Input;
import racingcar.user.Output;

public class Game {
	private int highScore;
	private final ArrayList<String> champion = new ArrayList<>();

	public void start() {
		String[] carNames = Input.inputCarNames();
		Car[] cars = createCars(carNames);

		String round = Input.inputRound();
		Output.startRound(round, cars);

		getHighScore(cars);
		getChampion(cars);
		Output.printChampionList(champion);
	}

	private Car[] createCars(String[] carNames) {
		Car[] cars = new Car[carNames.length];
		for (int i = 0; i < carNames.length; i++) {
			cars[i] = new Car(carNames[i]);
		}
		return cars;
	}

	private void getHighScore(Car[] cars) {
		for (Car car : cars) {
			isHighScore(car);
		}
	}

	private void isHighScore(Car car) {
		if (car.getPosition() > highScore) {
			highScore = car.getPosition();
		}
	}

	private void getChampion(Car[] cars) {
		for (Car car : cars) {
			isChampion(car);
		}
	}

	private void isChampion(Car car) {
		if (car.getPosition() == highScore) {
			champion.add(car.getName());
		}
	}
}
