package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private static final int MIN_POWER = 0;
	private static final int MAX_POWER = 9;
	private static final int THRESHOLD = 4;

	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	// 추가 기능 구현
	public void move() {
		int randNum = Randoms.pickNumberInRange(MIN_POWER, MAX_POWER);
		if (randNum >= THRESHOLD) {
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
