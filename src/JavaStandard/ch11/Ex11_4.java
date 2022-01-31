package JavaStandard.ch11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex11_4 {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;

	public static void main(String[] args) {
		System.out.println("도움말");

		while (true) {
			try {
				Scanner s = new Scanner(System.in);
				String input = s.nextLine().trim();

				if ("".equals(input)) {
					continue;
				}

				if (input.equalsIgnoreCase("q")) {
					System.exit(0);
				} else if (input.equalsIgnoreCase("help")) {
					System.out.println("help - 도움말");
					System.out.println("q 또는 Q - 프로그램 종료");
					System.out.println("history - 최근에 입력한 명령어");
				} else if (input.equalsIgnoreCase("history")) {
					save(input);

					LinkedList list = (LinkedList)q;

					for (int i = 0; i < list.size(); i++) {
						System.out.println((i + 1) + "." + list.get(i));
					}
				} else {
					save(input);
					System.out.println(input);
				}
			} catch (Exception e) {
				System.out.println("입력 오류");
			}
		}
	}

	private static void save(String input) {
		if (!"".equals(input)) {
			q.offer(input);
		}

		if (q.size() > MAX_SIZE) {
			q.remove();
		}
	}
}
