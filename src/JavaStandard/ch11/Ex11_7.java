package JavaStandard.ch11;

import java.util.Arrays;
import java.util.Comparator;

public class Ex11_7 {
	public static void main(String[] args) {
		String[] strArr = {"cat", "Dog", "lion", "tiger"};

		Arrays.sort(strArr); // String 의 Comparable 구현에 의한 정렬
		System.out.println("strArr = " + Arrays.toString(strArr));

		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분 안함
		System.out.println("strArr = " + Arrays.toString(strArr));

		Arrays.sort(strArr, new Descending()); // 역순 정렬
		System.out.println("strArr = " + Arrays.toString(strArr));
	}
}

class Descending implements Comparator {
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			return c1.compareTo(c2) * -1; // 부호를 바꿔 기본 정렬방식의 역으로 변경
			                              // 또는 c2.compareTo(c1)으로 순서 변경
		}
		return -1;
	}
}
