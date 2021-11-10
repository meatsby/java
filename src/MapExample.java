import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();

        dictionary.put("chicken", "닭");
        dictionary.put("hippo", "하마");

        dictionary.remove("chicken");

        if (dictionary.isEmpty()) {
            System.out.println("단어가 없습니다.");
            System.exit(0);
        }
        else {
            System.out.println(dictionary.size());
        }

        Collection<String> keys = dictionary.keySet();
        Collection<String> values = dictionary.values();
        Set<Map.Entry<String, String>> entries = dictionary.entrySet();

        System.out.println(keys);
        System.out.println(values);
        System.out.println(entries);

        Scanner s = new Scanner(System.in);

        String eng = s.nextLine();
        String kor = dictionary.get(eng);

        if (kor == null) {
            System.out.println("사전에 존재하지 않음");
        }
        else {
            System.out.println(eng + "는 " + kor + "입니다.");
        }

        System.out.println(dictionary.get("chicken"));
    }
}
