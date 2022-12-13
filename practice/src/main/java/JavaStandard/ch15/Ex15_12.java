package JavaStandard.ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex15_12 {
    public static void main(String[] args) {
        String line = "";

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.println(isr.getEncoding());

            do {
                line = br.readLine();
            } while (!line.equalsIgnoreCase("q"));

        } catch (IOException e) {
        }
    }
}
