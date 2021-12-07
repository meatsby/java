package Test03;

public class Player {
	private int x;
	private int y;

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int[] location() {
		return new int[] {x, y};
	}

	public void move(int newX, int newY) {
		x = newX;
		y = newY;
	}
}
