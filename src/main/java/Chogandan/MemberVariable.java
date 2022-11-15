package Chogandan;

import java.util.Scanner;

public class MemberVariable {

    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        echoSomeInputs();
    }

    private static void echoSomeInputs() {
        echoInteger();
        echoString();
    }

    private static void echoInteger() {
        int input = s.nextInt();
        System.out.println(input);
    }

    private static void echoString() {
        String input = s.nextLine();
        System.out.println(input);
    }
}
