package Test01;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Sokoban {
	private static final int numberOfLines = 13;
	private static final String stageIndicator = "Stage";
	private static final String stageSplitter = "=";

	private final Scanner sc;
	private String stageName;
	private List<List<Character>> board;

	public Sokoban(Scanner sc) {
		this.sc = sc;
	}

	public void play() {
		for (int i = 0; i < numberOfLines; i++) {
			String line = sc.nextLine();

			if (line.contains(stageIndicator)) {
				stageName = line;
				board = new LinkedList<>();
				continue;
			}

			if (line.contains(stageSplitter)) {
				Map map1 = new Map(stageName, board);
				map1.print();
				continue;
			}

			List<Character> row = new LinkedList<>();
			for (int j = 0; j < line.length(); j++) {
				row.add(line.charAt(j));
			}
			board.add(row);
		}

		Map map2 = new Map(stageName, board);
		map2.print();
	}
}
