package JavaStandard.ch12;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex12_2 {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("자바왕", 1, 1));
		list.add(new Student("자바짱", 1, 2));
		list.add(new Student("홍길동", 2, 1));

		Iterator<Student> it = list.iterator();
		while (it.hasNext()) {
			Student s = it.next(); // 지네릭스 미사용 시 형변환 필요
			System.out.println(s.name);
		}
	}
}

class Student {
	String name;
	int ban;
	int no;

	Student (String name, int ban, int no) {
		this.name = name;
		this.ban = ban;
		this.no = no;
	}
}
