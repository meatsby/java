package Test02;

import java.util.HashMap;
import java.util.Scanner;

public class Sokoban02 {
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
		System.out.println("Stage 2");
		map.print();
		while (true) {
			System.out.print("SOKOBAN> ");
			String input = sc.nextLine();

			if (input.equals("q")) {
				System.out.println("Bye~");
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
				System.out.println(cmd.toUpperCase() + ": (경고!) 해당 명령을 수행할 수 없습니다!");
				continue;
			}

			if (map.canMove(nx, ny)) {
				map.move(playerCo[0], playerCo[1], nx, ny);
				playerCo = new int[] {nx, ny};
				map.print();
				System.out.println(cmd.toUpperCase() + ": " + message.get(cmd) + "으로 이동합니다.");
			} else {
				map.print();
				System.out.println(cmd.toUpperCase() + ": (경고!) 해당 명령을 수행할 수 없습니다!");
			}
		}
	}
}
