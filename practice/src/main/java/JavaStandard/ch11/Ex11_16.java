package JavaStandard.ch11;

import java.util.HashMap;
import java.util.Scanner;

public class Ex11_16 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "1234");

		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.println("id 와 pw 입력");
			System.out.print("id : ");
			String id = s.nextLine().trim();

			System.out.print("pw : ");
			String pw = s.nextLine().trim();
			System.out.println();

			if (!map.containsKey(id)) {
				System.out.println("no such id found");
				continue;
			}

			if (!(map.get(id).equals(pw))) {
				System.out.println("wrong pw");
			} else {
				System.out.println("welcome");
				break;
			}
		}
	}
}
