package precourse.baseball;

import java.util.Random;

public class Computer {

    private static final Random random = new Random();

   public String makeRandNum() {
       StringBuilder randNum = new StringBuilder();

       while (randNum.length() < Materials.DIGIT) {
           String temp = Integer.toString(random.nextInt(9) + 1);

           if (!randNum.toString().contains(temp)) {
               randNum.append(temp);
           }
       }

       return String.valueOf(randNum);
   }

   public String compareNumbs() {
       Materials.ballCnt = 0;
       Materials.strikeCnt = 0;

       for (int i = 0; i < Materials.DIGIT; i++) {
           parseNum(i, Materials.randNum.charAt(i));
       }

       return getHint();
   }

   private void parseNum(int i, char curNum) {
       if (Materials.userNum.contains(Character.toString(curNum))) {
           if (Materials.userNum.charAt(i) == curNum) {
               Materials.strikeCnt++;
               return;
           }
           Materials.ballCnt++;
       }
   }

   private String getHint() {
       if (Materials.strikeCnt == 3) {
           return Materials.ANSWER;
       }
       if (Materials.strikeCnt == 0 && Materials.ballCnt == 0) {
           return Materials.NOTHING;
       }
       if (Materials.strikeCnt == 0) {
           return Materials.ballCnt + Materials.BALL;
       }
       if (Materials.ballCnt == 0) {
           return Materials.strikeCnt + Materials.STRIKE;
       }
       return Materials.ballCnt + Materials.BALL + " " + Materials.strikeCnt + Materials.STRIKE;
   }
}
