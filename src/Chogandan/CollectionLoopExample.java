package Chogandan;

import java.util.HashSet;
import java.util.Set;

public class CollectionLoopExample {
    public static void main(String[] args) {
        Set<String> foods = new HashSet<>();

        foods.add("치킨");
        foods.add("피자");
        foods.add("족발");

        for (String food : foods) {
            System.out.println(food);
        }

        if (foods.size() == 0) {
            System.out.println("목록이 비어있음");
        }
        else {
            System.out.println("총" + foods.size() + "개의 음식이 있음");
        }

        boolean isEmp = foods.isEmpty();

        System.out.println(isEmp);
    }
}
