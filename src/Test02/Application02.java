package Test02;

import java.util.Scanner;

public class Application02 {
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		Sokoban02 sokoban = new Sokoban02(sc);
		sokoban.play();
		sc.close();
	}
}
