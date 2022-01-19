package JavaStandard.ch07;

class Car {
	String color;
	int door;

	void drive() {
		System.out.println("drive");
	}

	void stop() {
		System.out.println("stop");
	}
}

class FireEngine extends Car {
	void water() {
		System.out.println("water");
	}
}

public class Ex7_7 {
	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;

		fe.water();
		car = fe;              // 업캐스팅. 형변황 생략
		// car.water();        // 에러
		fe2 = (FireEngine)car; // 다운캐스팅. 형변환 생략 불가
		fe2.water();
	}
}
