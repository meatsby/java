package JavaPlayground;

import java.util.Scanner;

public class Mission01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("출력할 단을 입력하세요. : ");
        int number = s.nextInt();
        print(number);
    }

    public static void print(int number) {
        for (int i=2; i < number+1; i++) {
            for (int j=1; j < number+1; j++) {
                System.out.println(i + "*" + j + "=" + i * j);
            }
        }
    }
}
