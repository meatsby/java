package Precourse1.baseball;

import Precourse1.utils.RandomUtils;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        StringBuilder randNum = new StringBuilder();

        while (randNum.length() < 3) {
            String temp = Integer.toString(RandomUtils.nextInt(1, 9));

            if (!randNum.toString().contains(temp)) {
                randNum.append(temp);
            }
        }

        System.out.println(randNum);

        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            String userNum = scanner.nextLine();

            int ball = 0;
            int strike = 0;

            for (int i=0; i<3; i++) {
                char curNum = randNum.charAt(i);

                if (userNum.contains(Character.toString(curNum))) {
                    if (userNum.charAt(i) == curNum) {
                        strike++;
                        continue;
                    }
                    ball++;
                }
            }

            System.out.printf("%d볼 %d스트라이크%n", ball, strike);

            if (userNum.contentEquals(randNum)) {
                break;
            }
        }
    }
}
