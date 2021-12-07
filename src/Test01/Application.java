package Test01;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		Sokoban sokoban = new Sokoban(sc);
		sokoban.play();
		sc.close();
	}
}
