package JavaPlayground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Planner {
    public Scanner s = new Scanner(System.in);
    public HashMap<String, ArrayList<String>> planner = new HashMap<>();

    public void registerCmd() {
        System.out.println("[일정 등록] 날짜를 입력하세요.");
        System.out.print("> ");
        String date = s.next();

        System.out.println("일정을 입력하세요.");
        System.out.print("> ");
        String plan = s.next();

        ArrayList<String> planList = new ArrayList<>();
        planList.add(plan);
        planner.put(date, planList);
        System.out.println("일정이 등록되었습니다.");

        System.out.println(planner);
    }

    public void searchCmd() {
        System.out.println("[일정 검색] 날짜를 입력하세요.");
        System.out.print("> ");
        String date = s.next();
        System.out.println(planner);
    }
}
