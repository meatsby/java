package JavaStandard.ch09;

import java.util.Objects;

class Card {
	String kind;
	int number;

	Card() {
		this("SPADE", 1);
	}

	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	public int hashCode() {
		return Objects.hash(kind, number);
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Card)) {
			return false;
		}

		return this.kind.equals(((Card)obj).kind) && this.number == ((Card)obj).number;
	}

	@Override
	public String toString() {
		return "kind : " + kind + " number : " + number;
	}
}

public class Ex9_4 {
	public static void main(String[] args) {
		Card c1 = new Card();
		Card c2 = new Card();

		System.out.println(c1.equals(c2));

		System.out.println(c1.toString());
		System.out.println(c2.toString());

		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
	}
}
