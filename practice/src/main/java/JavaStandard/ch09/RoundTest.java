package JavaStandard.ch09;

public class RoundTest {
	public static void main(String[] args) {
		for (double d = 1.5; d <= 10.5; d++) {
			double d1 = Math.round(d);
			double d2 = Math.rint(d);

			System.out.printf("%4.1f %4.1f %4.1f%n", d, d1, d2);
		}
	}
}
