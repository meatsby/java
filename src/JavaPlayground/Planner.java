package JavaPlayground;

import java.io.*;
import java.util.*;

public class Planner {
    public Scanner s = new Scanner(System.in);
    public HashMap<String, String> planner = new HashMap<>();
    private static final String SAVE_FILE = "calendar.dat";

    public void registerCmd() {
        System.out.println("[일정 등록] 날짜를 입력하세요.");
        System.out.print("> ");
        String date = s.next();

        System.out.println("일정을 입력하세요.");
        System.out.print("> ");
        String plan = s.next();

        planner.put(date, plan);
        System.out.println("일정이 등록되었습니다.");

        File f = new File(SAVE_FILE);
        try {
            FileWriter fw = new FileWriter(f, true);
            fw.write(date + "," + plan + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchCmd() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(SAVE_FILE));
            while (true) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (line == null) break;
                String date = line.split(",")[0];
                String detail = line.split(",")[1];
                planner.put(date, detail);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
