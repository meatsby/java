package racingcar.user;

import camp.nextstep.edu.missionutils.Console;
import racingcar.racinggame.Validation;

public class Input {
	private static final String CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String ROUND_INPUT = "시도할 횟수는 몇회인가요?";

	public static String[] inputCarNames() {
		while (true) {
			System.out.println(CAR_NAME_INPUT);
			try {
				String[] carNames = Console.readLine().split(",");
				Validation.isValid(carNames);
				return carNames;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static String inputRound() {
		while (true) {
			System.out.println(ROUND_INPUT);
			try {
				String round = Console.readLine();
				Validation.isValid(round);
				return round;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
