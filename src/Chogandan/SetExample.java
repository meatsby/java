package Chogandan;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> myFav = new HashSet<>();
        myFav.add("Chicken");
        myFav.add("Chicken");
        myFav.add("Pizza");

        myFav.remove("Chicken");

        System.out.println(myFav);
    }
}
