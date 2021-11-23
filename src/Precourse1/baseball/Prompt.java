package Precourse1.baseball;

import Precourse1.utils.RandomUtils;

import java.util.Scanner;

public class Prompt {

    private final Scanner s;

    private String randNum;
    private String userNum;
    private String hint;
    private int ball;
    private int strike;

    private final int DIGIT = 3;
    private final String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    // 생성자
    public Prompt(Scanner s) {
        this.s = s;
    }

    // 게임 시작 시 랜덤 숫자 생성
    public void play() {
        while (true) {
            randNum = makeRandNum();
            System.out.println(randNum);
            game();
            if (!askRestart()) {
                return;
            }
        }
    }

    // 임의의 세자리수 만들기
    private String makeRandNum() {
        StringBuilder Num = new StringBuilder();

        while (Num.length() < DIGIT) {
            String temp = Integer.toString(RandomUtils.nextInt(1, 9));

            if (!Num.toString().contains(temp)) {
                Num.append(temp);
            }
        }

        return String.valueOf(Num);
    }

    // 사용자입력 받고 힌트 출력
    private void game() {
        while (true) {
            guess();
            hint();
            if (hint.equals(GAME_CLEAR_MESSAGE)) {
                return;
            }
        }
    }

    // 사용자입력 받고 유효한지 검사
    private void guess() {
        System.out.print("숫자를 입력해 주세요 : ");
        userNum = s.nextLine();
        isValidInput();
    }

    // 힌트 출력
    private void hint() {
        ball = 0;
        strike = 0;

        for (int i=0; i<DIGIT; i++) {
            parseHint(i, randNum.charAt(i));
        }

        hint = getHint();
        System.out.println(hint);
    }

    // 사용자입력 분석
    private void parseHint(int i, char curNum) {
        if (userNum.contains(Character.toString(curNum))) {
            if (userNum.charAt(i) == curNum) {
                strike++;
                return;
            }
            ball++;
        }
    }

    // 힌트제공
    private String getHint() {
        if (strike == 3) {
            return GAME_CLEAR_MESSAGE;
        }
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    // 사용자입력 예외처리
    private void isValidInput() {
        if (userNum.length() != DIGIT) {
            throw new IllegalArgumentException();
        }

        for (int i=0; i<DIGIT; i++) {
            noZero(i);
            noOverlap(i);
        }
    }

    // 사용자입력에 0 이 포함되는지 확인
    private void noZero(int i) {
        if (userNum.charAt(i) == 0) {
            throw new IllegalArgumentException();
        }
    }

    // 사용자입력에 중복이 있는지 확인
    private void noOverlap(int i) {
        for (int j=i+1; j<DIGIT; j++) {
            if (userNum.charAt(i) == userNum.charAt(j)) {
                throw new IllegalArgumentException();
            }
        }
    }

    // 재시작 여부 확인
    private boolean askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = s.nextLine();

        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
