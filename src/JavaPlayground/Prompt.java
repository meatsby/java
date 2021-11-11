package JavaPlayground;

import java.util.Scanner;

public class Prompt {

    private final static String PROMPT = "cal> ";

    public void runPrompt() {
        Scanner s = new Scanner(System.in);
        Calendar cal = new Calendar();

        while (true) {
            System.out.println("월을 입력하세요.");
            System.out.print(PROMPT);
            int month = s.nextInt();
            if (month == -1) {
                System.out.println("Have a nice day!");
                break;
            }
            cal.printCalendar(month);
        }
        s.close();
    }

    public static void main(String[] args) {
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
