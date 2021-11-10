import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<>();

        list.add("Chicken");
        list.add("Pizza");
        list.add("Chicken");

        boolean containsChicken = list.contains("Chicken");

        list.remove(0);

        list.set(1, "Chicken");

        System.out.println(containsChicken);
    }
}
