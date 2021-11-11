package Chogandan;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOutput {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("src/output01.txt", true);
        } catch (IOException e) {
            System.out.println("파일 생성에 실패");
            System.exit(1);
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("")) {
                System.out.println("Ending");
                break;
            }
            try {
                writer.write(input);
            } catch (IOException e) {
                System.out.println("파일 생성에 실패");
                System.exit(2);
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("File close unsuccessful");
        }
    }
}
