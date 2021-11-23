package Prep.baseball;

import Prep.constants.SystemMessage;
import Prep.utils.RandomUtils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseBall {
    private static final int RADIX = 10;
    private static final int DIGIT_NUM = 3;
    private static final String RESTART = "1";
    private static final String END = "2";
    private final Scanner scanner;
    private String userNum;
    private String randNum;

    public BaseBall(Scanner scanner) {
        this.scanner = scanner;
        userNum = "";
        randNum = "";
    }

    public void init() {
        randNum = makeRandNum();
    }

    // prompt 게임진행
    public void playGame() {
        String result;

        do {
            System.out.print(SystemMessage.INPUT_MESSAGE);
            userNum = next();  // 사용자 입력
            result = umpire();
            System.out.println(result);
        } while (!result.equals(SystemMessage.GAME_CLEAR_MESSAGE));
    }

    // prompt 사용자 입력
    private String umpire() {
        int ballNum = 0;
        int strikeNum = 0;

        for (int i = 0; i < DIGIT_NUM; i++) {
            char digit = userNum.charAt(i);

            if (isStrike(digit, i)) {
                strikeNum++;
            } else if (isBall(digit)) {
                ballNum++;
            }
        }
        return getHint(ballNum, strikeNum);
    }

    // logic 힌트제공
    private String getHint(final int ballNum, final int strikeNum) {
        if (strikeNum == DIGIT_NUM) {
            return SystemMessage.GAME_CLEAR_MESSAGE;
        } else if (ballNum == 0 && strikeNum == 0) {
            return SystemMessage.NOTHING;
        } else if (ballNum == 0) {
            return strikeNum + SystemMessage.STRIKE;
        } else if (strikeNum == 0) {
            return ballNum + SystemMessage.BALL;
        }
        return ballNum + SystemMessage.BALL + " " + strikeNum + SystemMessage.STRIKE;
    }

    // logic 힌트검사(?)
    // strike 랑 ball 을 합치는 방향으로 구현했으면 좋았을 듯
    private boolean isStrike(final char digit, final int pos) {
        for (int i = 0; i < DIGIT_NUM; i++) {
            if (digit == randNum.charAt(i) && pos == i) {
                return true;
            }
        }
        return false;
    }
    private boolean isBall(final char digit) {
        for (int i = 0; i < DIGIT_NUM; i++) {
            if (digit == randNum.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    // logic 난수 생성
    private String makeRandNum() {
        Set<Character> randNumSet = new HashSet<>();
        int cnt = 0;
        StringBuilder result = new StringBuilder();

        while (cnt < BaseBall.DIGIT_NUM) {
            // (1~9) 까지의 10진수 숫자 중 하나를 char 타입으로 temp 에 저장
            char temp = Character.forDigit(RandomUtils.nextInt(1, 9), RADIX);

            // randNumSet 에 temp 가 이미 있다면 다시
            // Q. 왜 굳이 Set 을 사용? List 도 가능하지 않았을까?
            if (randNumSet.contains(temp)) {
                continue;
            }

            // randNumSet 에 temp 추가
            randNumSet.add(temp);
            // result 문자열에 추가
            result.append(temp);
            cnt++;
        }
        // 이렇게 되면 중복되지않는 숫자로 이루어진 임의의 3자리 수가 result 문자열로 반환됨
        return result.toString();
    }

    // prompt 재시작 여부
    public boolean isUserWantContinue() {
        System.out.println(SystemMessage.GAME_RESTART_OR_END_MESSAGE);
        String sel = scanner.next();

        if (sel.equals(RESTART)) {
            return true;
        } else if (sel.equals(END)) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    // exceptions 예외처리
    // 2번째랑 3번째가 같은지는 검사를 안함
    // 2중 for 문으로 검사 가능할 듯?
    private String next() {
        String input = scanner.next();

        if (input.length() != DIGIT_NUM) {
            throw new IllegalArgumentException();
        }

        char compare = input.charAt(0);

        if (compare == '0') {
            throw new IllegalArgumentException();
        }

        for (int i = 1; i < input.length(); i++) {
            if (compare == input.charAt(i)) {
                throw new IllegalArgumentException();
            }

            if (input.charAt(i) == '0') {
                throw new IllegalArgumentException();
            }
        }
        return input;
    }
}
