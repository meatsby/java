package JavaStandard.ch06;

public class Ex6_4 {
	public static void main(String[] args) {
		MyMath mm = new MyMath();
		long result1 = mm.add(5L, 3L);
		long result2 = mm.subtract(5L, 3L);
		long result3 = mm.multiply(5L, 3L);
		long result4 = mm.divide(5L, 3L);

		System.out.println("add(5L, 3L) = " + result1);
		System.out.println("subtract(5L, 3L) = " + result2);
		System.out.println("multiply(5L, 3L) = " + result3);
		System.out.println("divide(5L, 3L) = " + result4);
	}

	static class MyMath {
		long add (long a, long b) {
			return a + b;
		}

		long subtract (long a, long b) {
			return a - b;
		}

		long multiply (long a, long b) {
			return a * b;
		}

		long divide (long a, long b) {
			return a / b;
		}
	}
}
