package JavaStandard.ch13;

import javax.swing.*;

public class Ex13_5 {
	public static void main(String[] args) {
		ThreadEx5_1 th1 = new ThreadEx5_1();
		th1.start();

		String input = JOptionPane.showInputDialog("아무거나 입력");
		System.out.println("입력 : " + input);
	}
}

class ThreadEx5_1 extends Thread {
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
	}
}
