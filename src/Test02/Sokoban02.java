package Test02;

import java.util.HashMap;
import java.util.Scanner;

public class Sokoban02 {
	private static final String STAGE_NAME = "Stage 2";
	private static final String SOKOBAN_PROMPT = "SOKOBAN> ";
	private static final String QUIT_CMD = "q";
	private static final String END_MESSAGE = "Bye~";
	private static final String MOVE_MESSAGE = "%s: %s으로 이동합니다.%n";
	private static final String ERROR_MESSAGE = "%s: (경고!) 해당 명령을 수행할 수 없습니다!%n";

	private final Scanner sc;
	private final Map02 map;
	private int[] playerCo = {3, 5};
	private final HashMap<String, int[]> move;
	private final HashMap<String, String> message;

	public Sokoban02(Scanner sc) {
		this.sc = sc;

		this.map = new Map02();
		map.reset(playerCo[0], playerCo[1]);

		this.move = new HashMap<>();
		move.put("w", new int[] {-1, 0});
		move.put("a", new int[] {0, -1});
		move.put("s", new int[] {1, 0});
		move.put("d", new int[] {0, 1});

		this.message = new HashMap<>();
		message.put("w", "위쪽");
		message.put("a", "왼쪽");
		message.put("s", "아래쪽");
		message.put("d", "오른쪽");
	}

	public void play() {
		System.out.println(STAGE_NAME);
		map.print();
		while (true) {
			System.out.print(SOKOBAN_PROMPT);
			String input = sc.nextLine();

			if (input.equals(QUIT_CMD)) {
				System.out.println(END_MESSAGE);
				break;
			}

			printResult(input);
		}
	}

	private void printResult(String input) {
		for (int i = 0; i < input.length(); i++) {
			int nx, ny;
			String cmd = String.valueOf(input.charAt(i));

			try {
				nx = playerCo[0] + move.get(cmd)[0];
				ny = playerCo[1] + move.get(cmd)[1];
			} catch (NullPointerException e) {
				map.print();
				System.out.printf(ERROR_MESSAGE, cmd.toUpperCase());
				continue;
			}

			if (map.canMove(nx, ny)) {
				map.move(playerCo[0], playerCo[1], nx, ny);
				playerCo = new int[] {nx, ny};
				map.print();
				System.out.printf(MOVE_MESSAGE, cmd.toUpperCase(), message.get(cmd));
			} else {
				map.print();
				System.out.printf(ERROR_MESSAGE, cmd.toUpperCase());
			}
		}
	}
}
