package Chogandan;

import java.util.Scanner;

public class WhileExample02 {
    public static void main(String[] args) {
        String password = "abc123";
        Scanner s = new Scanner(System.in);

        System.out.println("Enter Password");
        String input = s.nextLine();

        while (input.equals(password) != true) {
            System.out.println("Enter Password");
            input = s.nextLine();
        }

        System.out.println("Correct Password");
    }
}
