package Chogandan;

import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        String passcode = "abc123";
        Scanner s = new Scanner(System.in);
        String input;

        do {
            System.out.println("Enter Passcode");
            input = s.nextLine();
        } while (input.equals(passcode) != true);

        System.out.println("Correct Passcode");
    }
}
