package JavaStandard.ch13;

public class Ex13_2 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("-"));
		}
		System.out.println();
		System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime));

		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("|"));
		}
		System.out.println();
		System.out.println("소요시간 : " + (System.currentTimeMillis() - startTime));
	}
}
