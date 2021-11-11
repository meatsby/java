package JavaPlayground;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("두 수를 입력하세요.");
        String[] numbers = s.nextLine().split(" ");

        int first = Integer.parseInt(numbers[0]);
        int second = Integer.parseInt(numbers[1]);

        int sum = first + second;

        System.out.println("두 수의 합은 " + sum + "입니다.");
        s.close();
    }
}
