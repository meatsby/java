package JavaPlayground;

import java.util.Scanner;

public class Gugudan {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("출력할 단은?");
            int n = s.nextInt();

            if (n < 2 || n > 9) {
                System.out.println("값을 잘못 입력했습니다.");
                continue;
            }

            for (int i = 1; i < 10; i++) {
                System.out.println(n * i);
            }
            break;
        }
    }
}
