package Test02;

public class Map02 {
	private final String[][] map;

	public Map02() {
		this.map = new String[][] {
			{" ", " ", "#", "#", "#", "#", "#", "#", "#", " ", " "},
			{"#", "#", "#", " ", " ", "O", " ", " ", "#", "#", "#"},
			{"#", " ", " ", " ", " ", "o", " ", " ", " ", " ", "#"},
			{"#", " ", "O", "o", " ", " ", " ", "o", "O", " ", "#"},
			{"#", "#", "#", " ", " ", "o", " ", " ", "#", "#", "#"},
			{" ", "#", " ", " ", " ", "O", " ", " ", "#", " ", " "},
			{" ", "#", "#", "#", "#", "#", "#", "#", "#", " ", " "}
		};
	}

	public boolean canMove(int x, int y) {
		return 0 <= x && x < 7 && 0 <= y && y < 11 && map[x][y].equals(" ");
	}

	public void reset(int x, int y) {
		map[x][y] = "P";
	}

	public void move(int x, int y, int nx, int ny) {
		map[x][y] = " ";
		map[nx][ny] = "P";
	}

	public void print() {
		System.out.println();
		for (String[] strings : map) {
			for (String string : strings) {
				System.out.print(string);
			}
			System.out.println();
		}
		System.out.println();
	}
}
