package JavaPlayground;

import java.util.Scanner;

public class CalculateDays {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        System.out.println("달을 입력하세요.");
        int month = s.nextInt();

        System.out.println(month + "월은 " + days[month-1] + "일까지 있습니다.");
        s.close();
    }
}
