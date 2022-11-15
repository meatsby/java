package JavaStandard.ch14;

import java.util.Optional;

public class OptionalTest {
	public static void main(String[] args) {
		// int[] arr = null;
		int[] arr = new int[0];
		System.out.println("arr.length = " + arr.length);

		// Optional<String> opt = null; // OK. 하지만 바람직 X
		Optional<String> opt = Optional.empty();
		System.out.println("opt = " + opt);
		// System.out.println("opt = " + opt.get());

		String str = "";

		// try {
		// 	str = opt.get();
		// } catch (Exception e) {
		// 	str = ""; // 예외 발생 시 빈문자열로 초기화
		// }

		// str = opt.orElse(""); // Optional 에 저장된 값이 null 이면 "" 반환
		str = opt.orElseGet(String::new);
		System.out.println("str = " + str);
	}
}
