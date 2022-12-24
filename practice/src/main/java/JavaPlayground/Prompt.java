package JavaPlayground;

import java.util.Scanner;

public class Prompt {

    public Scanner s = new Scanner(System.in);
    public Calendar cal = new Calendar();
    public Planner plan = new Planner();

    private void runPrompt() {
        printHelp();
        label:
        while (true) {

            System.out.println("명령 (1, 2, 3, h, q)");
            System.out.print("> ");
            String cmd = s.next();

            switch (cmd) {
                case "1":
                    plan.registerCmd();
                    break;
                case "2":
                    plan.searchCmd();
                    break;
                case "3":
                    printCal();
                    break;
                case "h":
                    printHelp();
                    break;
                case "q":
                    System.out.println("Have a nice day!");
                    break label;
            }
        }
    }

    public void printCal() {
        System.out.println("년도을 입력하세요.");
        System.out.print("YEAR> ");
        int year = s.nextInt();

        if (year == -1) {
            System.out.println("Have a nice day!");
            return;
        }

        System.out.println("월을 입력하세요.");
        System.out.print("MONTH> ");
        int month = s.nextInt();

        cal.printCalendar(year, month);
    }

    public void printHelp() {
        System.out.println("+----------------------+");
        System.out.println("| 1. 일정 등록");
        System.out.println("| 2. 일정 검색");
        System.out.println("| 3. 달력 보기");
        System.out.println("| h. 도움말 q. 종료");
        System.out.println("+----------------------+");
    }

    public static void main(String[] args) {
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
