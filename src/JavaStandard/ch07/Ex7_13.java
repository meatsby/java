package JavaStandard.ch07;

public class Ex7_13 {
	class InstanceInner {}
	static class StaticInner {}

	InstanceInner iv = new InstanceInner();    // 인스턴스멤버끼리는 직접 접근 가능
	static StaticInner cv = new StaticInner(); // static 멤버끼리는 직접 접근 가능

	static void staticMethod() { // static 멤버는 인스턴스 멤버에 직접 접근 불가
		// InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();

		Ex7_13 outer = new Ex7_13(); // 외부 클래스 생성 후 인스턴스 클래스 생성 가능
		InstanceInner obj1 = outer.new InstanceInner();
	}

	void instanceMethod() { // 인스턴스 메서드에서는 인스턴스멤버와 static 멤버 모두 접근 가능
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		// LocalInner lv = new LocalInner(); // 지역 내부 클래스는 외부에서 접근 불가
	}

	void myMethod() {
		class LocalInner {}
		LocalInner lv = new LocalInner();
	}
}
