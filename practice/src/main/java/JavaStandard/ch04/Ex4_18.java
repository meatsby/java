package JavaStandard.ch04;

import java.util.*;

public class Ex4_18 {
	public static void main(String[] args) { 
		int menu = 0;
		int num  = 0;

		Scanner scanner = new Scanner(System.in);

		while(true) {
			System.out.println("(1) square");
			System.out.println("(2) square root");
			System.out.println("(3) log");

			String tmp = scanner.nextLine();
			menu = Integer.parseInt(tmp);

			if(menu==0) {
				System.out.println("no");
				break;
			} else if (!(1 <= menu && menu <= 3)) {
				System.out.println("go");
				continue;		
			}
			
			System.out.println(menu);
		}
	}
}
