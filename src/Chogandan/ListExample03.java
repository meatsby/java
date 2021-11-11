package Chogandan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExample03 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("앙", "앙");
        List<String> names2 = new ArrayList<>();
        names2.add("김건부");
        names2.add("허수");
        names2.add("장용준");
        names2.add("이현우");

        System.out.println(names);
        System.out.println(names2);
    }
}
