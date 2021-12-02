package racingcar.racinggame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Validation {
	private static final String ERROR = "[ERROR] ";

	public static void isValid(String[] carNames) {
		isEmpty(carNames);
		isUnique(carNames);
		for (String carName : carNames) {
			isLong(carName);
			isShort(carName);
			hasBlank(carName);
		}
	}

	public static void isValid(String round) {
		for (int i = 0; i < round.length(); i++) {
			notDigit(round, i);
		}
		lessThanOne(round);
	}

	private static void isEmpty(String[] carNames) {
		if (carNames.length < 1) {
			throw new IllegalArgumentException(ERROR + "자동차 이름은 빈칸일 수 없습니다.");
		}
	}

	private static void isUnique(String[] carNames) {
		ArrayList<String> names = new ArrayList<>(Arrays.asList(carNames));
		HashSet<String> unique = new HashSet<>(names);
		if (names.size() != unique.size()) {
			throw new IllegalArgumentException(ERROR + "자동차 이름은 중복될 수 없습니다.");
		}
	}

	private static void isLong(String carName) {
		if (carName.length() > 5) {
			throw new IllegalArgumentException(ERROR + "자동차 이름은 5자 이하여야 합니다.");
		}
	}

	private static void isShort(String carName) {
		if (carName.length() < 1) {
			throw new IllegalArgumentException(ERROR + "자동차 이름은 1자 이상이여야 합니다.");
		}
	}

	private static void hasBlank(String carName) {
		if (carName.contains(" ")) {
			throw new IllegalArgumentException(ERROR + "자동차 이름에 공백이 포함될 수 없습니다.");
		}
	}

	private static void notDigit(String round, int i) {
		if (!Character.isDigit(round.charAt(i))) {
			throw new IllegalArgumentException(ERROR + "라운드 횟수는 숫자여야 합니다.");
		}
	}

	private static void lessThanOne(String round) {
		if (Integer.parseInt(round) < 1) {
			throw new IllegalArgumentException(ERROR + "라운드 횟수는 1 이상의 정수여야 합니다.");
		}
	}
}
