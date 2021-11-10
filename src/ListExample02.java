import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListExample02 {
    public static void main(String[] args) {
        System.out.println("저장할 음식 이름 입력.(종료: 0)");
        List<String> foods = new ArrayList<>();
        Scanner s = new Scanner(System.in);

        while (true) {
            String food = s.nextLine();

            if (food.equals("0")) {
                break;
            }

            if (foods.contains(food)) {
                System.out.println("이미 목록에 있습니다.");
            }
            else {
                foods.add(food);
            }
        }

        Collections.sort(foods);
        Collections.reverse(foods);
        Collections.shuffle(foods);

        System.out.println(foods.get(0));
    }
}
