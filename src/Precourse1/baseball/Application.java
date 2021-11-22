package Precourse1.baseball;

import Precourse1.utils.RandomUtils;

import java.util.*;

public class Application {

    public static StringBuilder randNum;
    public static String userNum;
    public static int ball;
    public static int strike;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        randNum = new StringBuilder();

        while (randNum.length() < 3) {
            String temp = Integer.toString(RandomUtils.nextInt(1, 9));

            if (!randNum.toString().contains(temp)) {
                randNum.append(temp);
            }
        }

        System.out.println(randNum);

        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            userNum = scanner.nextLine();


            ball = 0;
            strike = 0;

            for (int i=0; i<3; i++) {
                char curNum = randNum.charAt(i);
                hint(i, curNum);
            }

            if (strike == 3) {
                System.out.println("게임 크리어");
                break;
            } else if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike == 0) {
                System.out.println(ball + "볼");
            } else if (ball == 0) {
                System.out.println(strike + "스트라이크");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }
    }

    public static void hint(int i, char curNum) {
        if (userNum.contains(Character.toString(curNum))) {
            if (userNum.charAt(i) == curNum) {
                strike++;
                return;
            }
            ball++;
        }
    }
}
