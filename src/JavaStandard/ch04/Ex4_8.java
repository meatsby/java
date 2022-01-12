package JavaStandard.ch04;

public class Ex4_8 {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i+=2) {
			System.out.println(i);
		}

		for (int i = 1, j = 10; i <= 10; i++, j--) {
			System.out.printf("i = %d, j = %d%n", i, j);
		}
	}
}
