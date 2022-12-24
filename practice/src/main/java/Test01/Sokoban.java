package Test01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sokoban {
	private static final int NUMBER_OF_LINES = 13;
	private static final String STAGE_INDICATOR = "Stage";
	private static final String STAGE_SPLITTER = "=";

	private final Scanner sc;
	private String stageName;
	private List<List<Character>> board;

	public Sokoban(Scanner sc) {
		this.sc = sc;
	}

	public void play() {
		for (int i = 0; i < NUMBER_OF_LINES; i++) {
			String line = sc.nextLine();

			if (line.contains(STAGE_INDICATOR)) {
				stageName = line;
				board = new ArrayList<>();
				continue;
			}

			if (line.contains(STAGE_SPLITTER)) {
				Map map1 = new Map(stageName, board);
				map1.print();
				continue;
			}

			List<Character> row = new ArrayList<>();
			for (int j = 0; j < line.length(); j++) {
				row.add(line.charAt(j));
			}
			board.add(row);
		}

		Map map2 = new Map(stageName, board);
		map2.print();
	}
}
