package JavaPlayground;

import java.util.Scanner;

public class Prompt {

    public void runPrompt() {
        Scanner s = new Scanner(System.in);
        Calendar cal = new Calendar();

        while (true) {
            System.out.println("년도을 입력하세요.");
            System.out.print("YEAR> ");
            int year = s.nextInt();

            if (year == -1) {
                System.out.println("Have a nice day!");
                break;
            }

            System.out.println("월을 입력하세요.");
            System.out.print("MONTH> ");
            int month = s.nextInt();

            cal.printCalendar(year, month);
        }
        s.close();
    }

    public static void main(String[] args) {
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
