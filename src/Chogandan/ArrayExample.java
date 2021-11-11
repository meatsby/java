package Chogandan;

public class ArrayExample {
    public static void main(String[] args) {
        String[] days = {"Mon", "Tues", "Wednes", "Thurs", "Fri", "Satur", "Sun"};
        int length = days.length;
        System.out.println(days[0]);
        System.out.println(days[6]);
        System.out.println(length);

        days[0] = "Sun";

        for (int i = 0; i < days.length; i++) {
            System.out.println(days[i] + "day");
        }

        for (String day : days) {
            System.out.println(day + "day");
        }
    }
}
