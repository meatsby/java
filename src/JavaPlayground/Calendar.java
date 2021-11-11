package JavaPlayground;

import java.util.Scanner;

public class Calendar {
    public static final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getDays(int month) {
        return days[month-1];
    }

    public void printCalendar(int month) {
        System.out.println(" S  M  T  W  R  F  S");
        System.out.println("--------------------");

        int maxDays = getDays(month);

        for (int i=1; i <= maxDays; i++) {
            System.out.printf("%3d", i);
            if (i % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
