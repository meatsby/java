package JavaStandard.ch11;

import java.util.HashSet;
import java.util.Objects;

public class Ex11_11 {
	public static void main(String[] args) {
		HashSet set = new HashSet();

		set.add("abc");
		set.add("abc");
		set.add(new Person("David", 10));
		set.add(new Person("David", 10));

		System.out.println(set);
	}
}

// equals()와 hashCode()를 오버라이딩해야 HashSet이 바르게 동작
class Person {
	String name;
	int age;

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Person)) {
			return false;
		}

		Person tmp = (Person)obj;

		return name.equals(tmp.name) && age == tmp.age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return name + ":" + age;
	}
}
