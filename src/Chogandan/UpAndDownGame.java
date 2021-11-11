package Chogandan;

import java.util.Random;
import java.util.Scanner;

public class UpAndDownGame {
    public static void main(String[] args) {
        System.out.println("Predict 0~255");

        Random random = new Random();
        int randomNumber = random.nextInt(256);

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 8; i++) {
            System.out.println(8-i + "Chances left");
            System.out.println("Enter number");
            String input = scanner.nextLine();
            int guess = Integer.parseInt(input);

            if (randomNumber == guess) {
                System.out.println("Correct");
                break;
            }
            else if (randomNumber < guess) {
                System.out.println("Down");
            }
            else {
                System.out.println("Up");
            }
            if (i == 7) {
                System.out.println("No more Chance");
            }
        }
        System.out.println("Terminating");
    }
}
