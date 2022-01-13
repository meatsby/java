package JavaStandard.ch04;

import java.util.Scanner;

public class Ex4_15 {
	public static void main(String[] args) {
		int input = 0;
		int answer = (int)(Math.random() * 100) + 1;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("1~100 사이의 정수>");
			input = sc.nextInt();

			if (input > answer) {
				System.out.println("더 작음");
			} else if (input < answer) {
				System.out.println("더 큼");
			}
		} while (input != answer);

		System.out.println("정답");
	}
}
