package JavaStandard.ch6;

public class CardTest {
    public static void main(String[] args) {
        // static 변수는 객체 생성 없이 사용 가능
        System.out.println("Card.width = " + Card.width);
        System.out.println("Card.height = " + Card.height);

        Card c1 = new Card();
        c1.kind = "Heart";
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "Spade";
        c2.number = 4;

        System.out.println("C1은 " + c1.kind + c1.number + ", 크기는 " + c1.width + ", " + c1.height);
        System.out.println("C2은 " + c2.kind + c2.number + ", 크기는 " + c2.width + ", " + c2.height);
    }
}

class Card {
    String kind;
    int number;
    static int width = 100;
    static int height = 250;
}
