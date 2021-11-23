package Precourse1.baseball;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        Prompt p = new Prompt(scanner);
        p.play();
        scanner.close();
    }
}
