package Chogandan;

import java.util.Scanner;

public class WhileExample03 {
    public static void main(String[] args) {
        String passcode = "abc123";
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("Enter Passcode");
            String input = s.nextLine();

            if (input.equals(passcode)) {
                System.out.println("Correct Passcode");
                break;
            }

            System.out.println("Incorrect Passcode");
        }
    }
}
