package JavaStandard.ch07;

abstract class Unit2 {
	int x, y;
	abstract void move(int x, int y);
	void stop() {
		System.out.println("STOP");
	}
}

interface Fightable {
	void move(int x, int y);  // public abstract 생략
	void attack(Fightable f); // public abstract 생략
}

class Fighter extends Unit2 implements Fightable {
	// 오버라이딩 규칙 : 조상보다 접근제어자가 좁으면 안된다.
	public void move(int x, int y) {
		System.out.printf("[%d,%d]로 이동%n", x, y);
	}
	public void attack(Fightable f) {
		System.out.println(f + "를 공격");
	}

	Fightable getFightable() {
		return new Fighter();
	}
}

public class FighterTest {
	public static void main(String[] args) {
		Fighter f = new Fighter();
		Fightable f2 = f.getFightable();
		System.out.println(f2 instanceof Fighter);

		Unit2 u = new Fighter();
		u.move(100, 200);
		// u.attack(new Fighter()); // Unit2에는 attack()이 없어서 호출 불가
		u.stop();

		Fightable b = new Fighter();
		b.move(100, 200);
		b.attack(new Fighter());
		// f.stop(); // Fightable에는 stop()이 없어서 호출 불가
	}
}
