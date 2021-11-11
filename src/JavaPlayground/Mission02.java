package JavaPlayground;

import java.util.Scanner;

public class Mission02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("출력할 단을 입력하세요. : ");
        String[] numbers = s.nextLine().split(",");
        int first = Integer.parseInt(numbers[0]);
        int second = Integer.parseInt(numbers[1]);

        print(first, second);
    }

    public static void print(int first, int second) {
        for (int i=2; i < first+1; i++) {
            for (int j=1; j < second+1; j++) {
                System.out.println(i + "*" + j + "=" + i * j);
            }
        }
    }
}
