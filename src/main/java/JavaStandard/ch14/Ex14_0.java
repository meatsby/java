package JavaStandard.ch14;

import java.util.function.Function;
import java.util.function.Supplier;

public class Ex14_0 {
	public static void main(String[] args) {
		// Supplier<MyClass> s = () -> new MyClass();
		// Supplier<MyClass> s = MyClass::new;

		// MyClass mc = s.get();
		// System.out.println(mc);
		// System.out.println(s.get());

		// Function<Integer, MyClass> f = (i) -> new MyClass(i);
		Function<Integer, MyClass> f = MyClass::new;

		MyClass mc = f.apply(100);
		System.out.println(mc.iv);
		System.out.println(f.apply(100).iv);

		// Function<Integer, int[]> f2 = (i) -> new int[i];
		Function<Integer, int[]> f2 = int[]::new;

		int[] arr = f2.apply(100);
		System.out.println(arr.length);
		System.out.println(f2.apply(100).length);
	}
}

class MyClass {
	int iv;

	MyClass(int iv) {
		this.iv = iv;
	}
}
