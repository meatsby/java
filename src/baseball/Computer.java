//package baseball;
//
//import static baseball.Materials.ANSWER;
//import static baseball.Materials.BALL;
//import static baseball.Materials.DIGIT;
//import static baseball.Materials.NOTHING;
//import static baseball.Materials.STRIKE;
//import static baseball.Materials.ballCnt;
//import static baseball.Materials.randNum;
//import static baseball.Materials.strikeCnt;
//import static baseball.Materials.userNum;
//
//import camp.nextstep.edu.missionutils.Randoms;
//
//public class Computer {
//
//    public String makeRandNum() {
//        StringBuilder randNum = new StringBuilder();
//
//        while (randNum.length() < DIGIT) {
//            String temp = Integer.toString(Randoms.pickNumberInRange(1, 9));
//
//            if (!randNum.toString().contains(temp)) {
//                randNum.append(temp);
//            }
//        }
//
//        return String.valueOf(randNum);
//    }
//
//    public String compareNumbs() {
//        ballCnt = 0;
//        strikeCnt = 0;
//
//        for (int i = 0; i < DIGIT; i++) {
//            parseNum(i, randNum.charAt(i));
//        }
//
//        return getHint();
//    }
//
//    private void parseNum(int i, char curNum) {
//        if (userNum.contains(Character.toString(curNum))) {
//            if (userNum.charAt(i) == curNum) {
//                strikeCnt++;
//                return;
//            }
//            ballCnt++;
//        }
//    }
//
//    private String getHint() {
//        if (strikeCnt == 3) {
//            return ANSWER;
//        }
//        if (strikeCnt == 0 && ballCnt == 0) {
//            return NOTHING;
//        }
//        if (strikeCnt == 0) {
//            return ballCnt + BALL;
//        }
//        if (ballCnt == 0) {
//            return strikeCnt + STRIKE;
//        }
//        return ballCnt + BALL + " " + strikeCnt + STRIKE;
//    }
//}
