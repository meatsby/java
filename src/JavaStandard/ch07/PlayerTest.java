package JavaStandard.ch07;

abstract class Player {
	abstract void play(int pos);
	abstract void stop();
}

class AudioPlayer extends Player {
	void play(int pos) {
		System.out.println(pos + "위치부터 play");
	}

	void stop() {
		System.out.println("정지");
	}
}

public class PlayerTest {
	public static void main(String[] args) {
		// Player p = new Player();
		Player ap = new AudioPlayer(); // 다형성
		ap.play(100);
		ap.stop();
	}
}
