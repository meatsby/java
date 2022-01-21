package JavaStandard.ch07;

public class Ex7_12 {
	class InstanceInner {
		int iv = 100;
		// static int cv = 100;       // 에러. static 변수를 선언할 수 없음
		final static int CONST = 100; // 상수는 허용
	}

	static class StaticInner {
		int iv = 200;
		static int cv = 200; // static 클래스만 static 멤버 정의 가능
	}

	void myMethod() {
		class LocalInner {
			int iv = 300;
			// static int cv = 300;       // 에러. static 변수를 선언할 수 없음
			final static int CONST = 300; // 상수는 허용
		}
	}
}
