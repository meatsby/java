public class StringExample {
    public static void main(String[] args) {
        System.out.println("나는 문자열");
        System.out.println('나');

        System.out.println("안녕 나는 \"자바\"야.");

        System.out.println("치킨은 살 안 쪄요.\n살은 내가 쪄요.");

        String chicken = "치킨은 살 안 쪄요.";
        String me = "살은 내가 쪄요.";

        System.out.println(chicken);
        System.out.println(me);

        String chickenAndMe = chicken + me;
        System.out.println(chickenAndMe);

        System.out.println(me.length());
        System.out.println(me.replaceAll("내가", "치킨이"));

        String birthday = "1997/09/14";
        String year = birthday.substring(0, 4);
        String day = birthday.substring(8);
        System.out.println(year);
        System.out.println(day);
    }
}
