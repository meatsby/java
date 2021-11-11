package Chogandan;

public class Number {
    public static void main(String[] args) {
        byte byteInteger = 10;
        short shortInteger = 20;
        int intInteger = 30;
        long longInteger = 40;

        int sum = byteInteger + shortInteger;
        int sum2 = shortInteger + intInteger;
        long sum3 = intInteger + longInteger;
        long sum4 = byteInteger + longInteger;

        System.out.println(byteInteger);
        System.out.println(shortInteger);
        System.out.println(intInteger);
        System.out.println(longInteger);

        float floatNumber = 1.2f;
        double doubleNumber = 4.3;

        System.out.println(floatNumber);
        System.out.println(doubleNumber);
    }
}
