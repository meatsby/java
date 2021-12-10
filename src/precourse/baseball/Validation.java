package precourse.baseball;

public class Validation {

    public void isValidInput() {
        if (Materials.userNum.length() != Materials.DIGIT) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < Materials.DIGIT; i++) {
            inRange(i);
            noOverlap(i);
        }
    }

    private void inRange(int i) {
        if (Materials.userNum.charAt(i) < '1' || Materials.userNum.charAt(i) > '9') {
            throw new IllegalArgumentException();
        }
    }

    private void noOverlap(int i) {
        for (int j = i + 1; j < Materials.DIGIT; j++) {
            if (Materials.userNum.charAt(i) == Materials.userNum.charAt(j)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
