public class NestedIf {
    public static void main(String[] args) {
        int age = 15;

        if (age >= 10 && age < 20) {
            System.out.println("10대");
        } else {
            System.out.println("10살 미만");
        }
        System.out.println(true && true);
        System.out.println(false && true);
        System.out.println(true && false);
        System.out.println(true && false);
        if (age < 10 || age >= 20) {
            System.out.println("10대 아님");
        } else {
            System.out.println("10대");
        }
    }
}