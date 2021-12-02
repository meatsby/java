package baseball;

import static baseball.Materials.ANSWER;
import static baseball.Materials.CLEAR_MESSAGE;
import static baseball.Materials.INPUT_MESSAGE;
import static baseball.Materials.RESTART_MESSAGE;
import static baseball.Materials.randNum;
import static baseball.Materials.userNum;

import java.util.Scanner;

public class Game {

   private final Computer computer;
   private final Validation validation;
   private final Scanner scanner = new Scanner(System.in);

   public Game(Computer computer, Validation validation) {
       this.computer = computer;
       this.validation = validation;
   }

   public void startGame() {
       while (true) {
           startRound();

           if (!restart()) {
               return;
           }
       }
   }

   private void startRound() {
       randNum = computer.makeRandNum();

       while (true) {
           System.out.print(INPUT_MESSAGE);
           userNum = scanner.nextLine();
           validation.isValidInput();
           String result = computer.compareNumbs();
           System.out.println(result);
           if (result.equals(ANSWER)) {
               System.out.println(CLEAR_MESSAGE);
               return;
           }
       }
   }

   private boolean restart() {
       System.out.println(RESTART_MESSAGE);
       String input = scanner.nextLine();

       if (input.equals("1")) {
           return true;
       }
       if (input.equals("2")) {
           return false;
       }
       throw new IllegalArgumentException();
   }
}
