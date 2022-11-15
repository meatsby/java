package JavaStandard.ch09;

class Person {
	long id;

	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) {
			return false;
		}
		return id == ((Person)obj).id;
	}

	Person(long id) {
		this.id = id;
	}
}

public class Ex9_2 {
	public static void main(String[] args) {
		Person p1 = new Person(8011081111222L);
		Person p2 = new Person(8011081111222L);

		System.out.println(p1.equals(p2));
	}
}
