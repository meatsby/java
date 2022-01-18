package JavaStandard.ch07.pkg2;

import JavaStandard.ch07.pkg1.MyParent;

class MyChild extends MyParent {
	public void printMembers() {
		// System.out.println(prv); // 에러. 다른 클래스에 있기 때문에
		// System.out.println(dft); // 에러. 다른 패키지에 있기 때문에
		System.out.println(prt);
		System.out.println(pub);
	}
}

public class MyParentTest2 {
	public static void main(String[] args) {
		MyParent p = new MyParent();
		// System.out.println(p.prv); // 에러. 다른 클래스에 있기 때문에
		// System.out.println(p.dft); // 에러. 다른 패키지에 있기 때문에
		// System.out.println(p.prt); // 에러. 다른 패키지의 다른 클래스기 때문에
		System.out.println(p.pub);
	}
}
