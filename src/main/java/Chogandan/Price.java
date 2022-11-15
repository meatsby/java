package Chogandan;

import java.util.Scanner;

public class Price {
    public static void main(String[] args) {
        System.out.println("Enter Food Name");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        switch (name) {
            case "Chicken":
                System.out.println("Chicken is 5$");
                break;
            case "Steak":
                System.out.println("Steak is 8$");
            default:
                System.out.println("Nothing");
        }
    }
}
