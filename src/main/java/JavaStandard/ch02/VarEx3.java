package JavaStandard.ch02;

public class VarEx3 {
    public static void main(String[] args) {
        final int score = 100;
        // score = 200;
        boolean power = true;

        byte b = 127;

        int oct = 010;
        int hex = 0x10;

        long l = 10_000_000_000L;

        float f = 3.14f;
        double d = 3.14f;

        char ch = 'A';
        int i = 'A';

        String str = "";
        String str2 = "ABCD";
        String str3 = "123";
        String str4 = str2 + str3;
        System.out.println(str4);
        System.out.println(""+7+7);
        System.out.println(7+7+"");
    }
}
