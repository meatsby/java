package Test03;

import static Test03.Constants.*;

import java.util.List;

public class Stage {
	public Player player;
	private final String stageName;
	private final List<List<String>> stageMap;
	private final int height;
	private final int width;

	public Stage(String stageName, List<List<String>> stageMap) {
		this.stageName = stageName;
		this.stageMap = stageMap;

		this.height = stageMap.size();
		this.width = stageMap.get(0).size();

		for (int i = 0; i < stageMap.size(); i++) {
			for (int j = 0; j < stageMap.get(i).size(); j++) {
				if (stageMap.get(i).get(j).equals(PLAYER)) {
					this.player = new Player(i, j);
				}
			}
		}
	}

	public boolean move(String cmd, int[] oldLocation) {
		int[] newLocation = moves(cmd, oldLocation);
		if (inRange(newLocation)) {
			if (value(newLocation).equals(BLANK)) {
				movePlayer(oldLocation, newLocation);
			}
			if (value(newLocation).equals(BALL)) {
				moveWithBall(cmd, oldLocation, newLocation);
			}
			if (value(newLocation).equals(COMPLETE)) {
				moveCompleteBall(cmd, newLocation);
			}
		}
		if (clear()) {
			printMap();
			System.out.printf(STAGE_CLEAR_MESSAGE, stageName);
			return true;
		}
		return false;
	}

	private void moveWithBall(String cmd, int[] oldLocation, int[] newLocation) {
		int[] movedBall = moves(cmd, newLocation);
		if (inRange(movedBall)) {
			if (value(movedBall).equals(BLANK)) {
				movePlayer(oldLocation, newLocation);
				moveBall(movedBall);
			}
			if (value(movedBall).equals(HALL)) {
				movePlayer(oldLocation, newLocation);
				goalBall(movedBall);
			}
		}
	}

	private void moveCompleteBall(String cmd, int[] newLocation) {
		int[] movedBall = moves(cmd, newLocation);
		if (inRange(movedBall)) {
			if (value(movedBall).equals(BLANK)) {
				separate(newLocation, movedBall);
			}
		}
	}

	private boolean inRange(int[] coordinate) {
		return 0 <= coordinate[X] && coordinate[X] < height && 0 <= coordinate[Y] && coordinate[Y] < width;
	}

	private String value(int[] coordinate) {
		return stageMap.get(coordinate[X]).get(coordinate[Y]);
	}

	private void movePlayer(int[] oldLocation, int[] newLocation) {
		stageMap.get(oldLocation[X]).set(oldLocation[Y], BLANK);
		player.move(newLocation[X], newLocation[Y]);
		stageMap.get(newLocation[X]).set(newLocation[Y], PLAYER);
	}

	private void moveBall(int[] movedRock) {
		stageMap.get(movedRock[X]).set(movedRock[Y], BALL);
	}

	private void goalBall(int[] movedRock) {
		stageMap.get(movedRock[X]).set(movedRock[Y], COMPLETE);
	}

	private void separate(int[] newLocation, int[] movedRock) {
		stageMap.get(newLocation[X]).set(newLocation[Y], HALL);
		stageMap.get(movedRock[X]).set(movedRock[Y], BALL);
	}

	private int[] moves(String cmd, int[] coordinate) {
		int x = coordinate[X];
		int y = coordinate[Y];
		if (cmd.equals(UP)) {
			x--;
		}
		if (cmd.equals(LEFT)) {
			y--;
		}
		if (cmd.equals(DOWN)) {
			x++;
		}
		if (cmd.equals(RIGHT)) {
			y++;
		}
		return new int[] {x, y};
	}

	private boolean clear() {
		for (List<String> strings : stageMap) {
			for (String string : strings) {
				if (string.equals(HALL)) {
					return false;
				}
			}
		}
		return true;
	}

	public void printStageName() {
		System.out.println();
		System.out.println(stageName);
	}

	public void printMap() {
		System.out.println();
		StringBuilder sb = new StringBuilder();
		for (List<String> row : stageMap) {
			for (String point : row) {
				sb.append(point);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
