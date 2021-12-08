package Test03;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		Game game = new Game(sc);
		game.play();
		sc.close();
	}
}
