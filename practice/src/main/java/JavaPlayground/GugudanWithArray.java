package JavaPlayground;

import java.util.Scanner;

public class GugudanWithArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        for (int k=2; k < n; k++) {
            int[] result = new int[9];

            for (int i=0; i < result.length; i++) {
                result[i] = k * (i+1);
            }

            for (int i=0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }
    }
}
