import java.util.Random;
import java.util.Scanner;

public class UpAndDownWithMethod {

    public static Scanner s = new Scanner(System.in);
    public static Random r = new Random();
    public static int randomNumber = r.nextInt(256);
    public static int attempt = 0;

    public static void main(String[] args) {
        while (attempt < 8) {
            boolean isCorrect = play();

            if (isCorrect) {
                break;
            }

            attempt++;
            System.out.println(attempt + " times guessed.");
        }

        System.out.println("Game Terminated.");
    }

    private static boolean play() {
        System.out.println("Enter your guess: ");
        int n = s.nextInt();

        if (n == randomNumber) {
            System.out.println("You are correct!");
            System.out.println("You've guessed " + attempt + " times.");
            return true;
        }
        else if (n > randomNumber) {
            System.out.println("Down");
        }
        else {
            System.out.println("Up");
        }
        return false;
    }
}
