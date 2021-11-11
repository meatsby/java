package Chogandan;

import java.util.Arrays;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        String[][] days = {
                {"Mon", "Tues", "Wednes", "Thurs", "Fri", "Satur", "Sun"},
                {"Mon", "Tues", "Wednes", "Thurs", "Fri", "Satur", "Sun"},
                {"Mon", "Tues", "Wednes", "Thurs", "Fri", "Satur", "Sun"}
        };

        System.out.println(Arrays.toString(days[0]));
        System.out.println(Arrays.toString(days[1]));
        System.out.println(Arrays.toString(days[2]));
    }
}
