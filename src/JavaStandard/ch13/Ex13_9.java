package JavaStandard.ch13;

import javax.swing.*;

public class Ex13_9 {
	public static void main(String[] args) throws Exception {
		ThreadEx9_1 th1 = new ThreadEx9_1();
		th1.start();

		String input = JOptionPane.showInputDialog("아무 값 입력");
		System.out.println("입력 값 : " + input);
		th1.interrupt();
		System.out.println("isInterrupted() : " + th1.isInterrupted());
	}
}

class ThreadEx9_1 extends Thread {
	public void run() {
		int i = 10;

		while (i != 0 && !isInterrupted()) {
			System.out.println(i--);
			for (long x = 0; x < 2500000000L; x++);
		}
		System.out.println("isInterrupted() : " + this.isInterrupted());
		System.out.println("interrupted() : " + Thread.interrupted());
		System.out.println("isInterrupted() : " + this.isInterrupted());
		System.out.println("카운트 종료");
	}
}
