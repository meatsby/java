package JavaStandard.ch11;

import java.util.ArrayList;
import java.util.Collections;

public class Ex11_1 {
	public static void main(String[] args) {
		// 기본 길이가 10인 ArrayList 생성
		ArrayList list1 = new ArrayList(10);
		// ArrayList에는 객체만 저장 가능
		// AutoBoxing 으로 기본형이 참조형으로 변환
		list1.add(5); // list1.add(new Integer(5));
		list1.add(4);
		list1.add(2);
		list1.add(0);
		list1.add(1);
		list1.add(3);

		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1, list2);

		Collections.sort(list1);
		Collections.sort(list2);
		print(list1, list2);

		System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2));

		list2.add("B");
		list2.add("C");
		list2.add(3, "A");
		print(list1, list2);

		list2.set(3, "AA");
		print(list1, list2);

		// list1 에서 list2 와 겹치는 부분만 남기고 나머지 삭제
		System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));
		print(list1, list2);

		// list2 에서 list1 에 포함된 객체들을 삭제
		for (int i = list2.size() - 1; i >= 0; i--) {
			if (list1.contains(list2.get(i))) {
				list2.remove(i);
			}
		}
		print(list1, list2);
	}

	private static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		System.out.println();
	}
}
