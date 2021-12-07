package Test01;

import java.util.List;

public class Map {
	private static final Character HALL = 'O';
	private static final Character BALL = 'o';
	private static final Character PLAYER = 'P';

	private final String stageName;
	private final List<List<Character>> map;
	private int horSize;
	private int verSize;
	private int numberOfHalls;
	private int numberOfBalls;
	private int playerX;
	private int playerY;

	public Map(String stageName, List<List<Character>> map) {
		this.stageName = stageName;
		this.map = map;
		maximize();
		init();
	}

	private void maximize() {
		for (List<Character> row : map) {
			horSize = Math.max(row.size(), horSize);
		}

		for (List<Character> row : map) {
			while (row.size() < horSize) {
				row.add(' ');
			}
		}
	}

	private void init() {
		verSize = map.size();
		for (int i = 0; i < verSize; i++) {
			for (int j = 0; j < horSize; j++) {
				parse(i, j);
			}
		}
	}

	private void parse(int i, int j) {
		Character coordinate = map.get(i).get(j);
		if (coordinate == HALL) {
			numberOfHalls++;
		} else if (coordinate == BALL) {
			numberOfBalls++;
		} else if (coordinate == PLAYER) {
			playerX = i+1;
			playerY = j+1;
		}
	}

	public void print() {
		System.out.println();
		System.out.println(stageName);
		System.out.println();
		printMap();
		System.out.println();
		System.out.println("가로크기: " + horSize);
		System.out.println("세로크기: " + verSize);
		System.out.println("구멍의 수: " + numberOfHalls);
		System.out.println("공의 수: " + numberOfBalls);
		System.out.println("플레이어 위치: (" + playerX + ", " + playerY + ")");
	}

	private void printMap() {
		for (List<Character> row : map) {
			StringBuilder sb = new StringBuilder();
			for (Character c : row) {
				sb.append(c);
			}
			System.out.println(sb);
		}
	}
}
