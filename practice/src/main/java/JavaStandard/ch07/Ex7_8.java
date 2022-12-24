package JavaStandard.ch07;

class Product {
	int price;
	int bonusPoint;

	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}

class Tv1 extends Product {
	Tv1() {
		// 조상타입 Product 의 생성자를 불러옴
		super(100);
	}

	// Object 클래스의 toString() 오버라이딩
	@Override
	public String toString() {
		return "Tv";
	}
}

class Computer extends Product {
	Computer() {
		super(200);
	}

	public String toString() {
		return "Computer";
	}
}

class Buyer {
	int money = 1000;
	int bonusPoint = 0;

	void buy(Product p) {
		if (money < p.price) {
			System.out.println("잔액이 부족합니다.");
			return;
		}

		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p + " 을/를 구입하셨습니다.");
	}
}

public class Ex7_8 {
	public static void main(String[] args) {
		Buyer b = new Buyer();

		b.buy(new Tv1());
		b.buy(new Computer());

		System.out.println("남은 돈 : " + b.money + "만원");
		System.out.println("보너스점수 : " + b.bonusPoint + "점");
	}
}
