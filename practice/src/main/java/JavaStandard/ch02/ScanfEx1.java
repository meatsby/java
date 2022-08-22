package JavaStandard.ch02;

import java.util.Scanner;

public class ScanfEx1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int num = Integer.parseInt(input);

        System.out.println(num);
    }
}
