package JavaStandard.ch04;

import java.util.Scanner;

public class Ex4_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (input == 0) {
            System.out.println(0);
        } else {
            System.out.println("no");
        }
    }
}
