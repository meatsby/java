package JavaPlayground;

import java.util.Arrays;
import java.util.Scanner;

public class Calendar {
    public static final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static final int[] leapDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public boolean isLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        }
        return false;
    }

    public int firstDay(int year, int month) {
        int firstDayOfYear = 0;

        for (int i = 1583; i < year; i++) {
            if (isLeapYear(i)) {
                firstDayOfYear += 2;
            } else {
                firstDayOfYear += 1;
            }
        }

        firstDayOfYear = (firstDayOfYear + 6) % 7;

        for (int i = 1; i < month; i++) {
            firstDayOfYear += getDays(year, i) % 7;
        }

        return firstDayOfYear % 7;
    }

    public int getDays(int year, int month) {
        if (isLeapYear(year)) {
            return leapDays[month-1];
        }
        return days[month-1];
    }

    public void printCalendar(int year, int month) {
        System.out.printf("    <<%4d년%3d월>>\n", year, month);
        System.out.println(" SU MO TU WE TR FR SA");
        System.out.println(" --------------------");

        int maxDays = getDays(year, month);
        int firstDay = firstDay(year, month);

        for (int i=0; i < firstDay; i++) {
            System.out.print("   ");
        }

        for (int i=1; i <= maxDays; i++) {
            System.out.printf("%3d", i);
            if ((i+firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }
}
