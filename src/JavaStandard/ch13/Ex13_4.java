package JavaStandard.ch13;

import javax.swing.*;

public class Ex13_4 {
	public static void main(String[] args) throws Exception{
		String input = JOptionPane.showInputDialog("아무거나 입력");
		System.out.println("입력 : " + input);

		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
	}
}
