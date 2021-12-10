package precourse.baseball;

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
       Materials.randNum = computer.makeRandNum();

       while (true) {
           System.out.print(Materials.INPUT_MESSAGE);
           Materials.userNum = scanner.nextLine();
           validation.isValidInput();
           String result = computer.compareNumbs();
           System.out.println(result);
           if (result.equals(Materials.ANSWER)) {
               System.out.println(Materials.CLEAR_MESSAGE);
               return;
           }
       }
   }

   private boolean restart() {
       System.out.println(Materials.RESTART_MESSAGE);
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
