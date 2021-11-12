package JavaPlayground;

import java.util.*;

public class Planner {
    public Scanner s = new Scanner(System.in);
    public HashMap<String, String> planner = new HashMap<>();

    public void registerCmd() {
        System.out.println("[일정 등록] 날짜를 입력하세요.");
        System.out.print("> ");
        String date = s.next();

        System.out.println("일정을 입력하세요.");
        System.out.print("> ");
        String plan = s.next();

        ArrayList<String> planList = new ArrayList<>();
        planList.add(plan);
        planner.put(date, plan);
        System.out.println("일정이 등록되었습니다.");
    }

    public void searchCmd() {
        System.out.println("[일정 검색] 날짜를 입력하세요.");
        System.out.print("> ");
        String date = s.next();
        String detail = planner.get(date);
        if (detail == null) {
            System.out.println("등록된 일정이 존재하지 않습니다.");
        } else {
            System.out.println(detail);
        }
    }
}
