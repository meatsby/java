package JavaStandard.ch03;

public class Ex3_9 {
	public static void main(String[] args) {
		int a = 1_000_000;
		int b = 2_000_000;

		long c = a * b;  // a * b 는 int 형으로 계산되기 때문에 오버플로우 발생
		c = (long)a * b; // 오버플로우를 방지하기 위해 a 나 b 를 형변환 한 뒤 연산

		System.out.println(c);
	}
}
