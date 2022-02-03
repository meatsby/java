package JavaStandard.ch12;

class Parent {
	void parentMethod() {}
}

class Child extends Parent {
	@Override
	@Deprecated
	void parentMethod() {}
}

public class Ex12_7 {
	public static void main(String[] args) {
		Child c = new Child();

		c.parentMethod(); // deprecated 된 메서드 사용
	}
}
