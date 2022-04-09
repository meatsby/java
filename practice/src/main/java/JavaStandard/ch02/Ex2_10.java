package JavaStandard.ch02;

import java.util.Scanner;

public class Ex2_10 {
	public static void main(String[] args) { 
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		int num = Integer.parseInt(input);

		System.out.println(input);
		System.out.printf("num=%d%n", num);
	} 
}
