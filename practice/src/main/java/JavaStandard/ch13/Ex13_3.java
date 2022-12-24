package JavaStandard.ch13;

import static JavaStandard.ch13.Ex13_3.*;

public class Ex13_3 {
	static long startTime = 0;

	public static void main(String[] args) {
		ThreadEx3_1 th1 = new ThreadEx3_1();
		th1.start();
		startTime = System.currentTimeMillis();

		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("-"));
		}
		System.out.print("소요시간 : " + (System.currentTimeMillis() - startTime));
	}
}

class ThreadEx3_1 extends Thread {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("|"));
		}
		System.out.print("소요시간 : " + (System.currentTimeMillis() - startTime));
	}
}
