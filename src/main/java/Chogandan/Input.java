package Chogandan;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String input = scanner.next();
//        String input1 = scanner.next();
//
//        System.out.println(input);
//        System.out.println(input1);

        System.out.println("숫자를 하나 입력해주세요.");
        String intInput = scanner.nextLine();
        try {
            int intValue = Integer.parseInt(intInput);
            System.out.println(intValue + 1);
        } catch (Exception e) {
            System.out.println("숫자를 입력해야 합니다.");
        }
    }
}
