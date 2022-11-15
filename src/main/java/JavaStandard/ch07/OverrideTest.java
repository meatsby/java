package JavaStandard.ch07;

class Point {
	int x;
	int y;

	@Override
	public String toString() {
		return "x :" + x + ", y:" + y;
	}
}

class Point3D extends Point {
	int z;

	Point3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// 오버라이딩
	@Override
	public String toString() {
		return "x :" + x + ", y:" + y + ", z:" + z;
	}
}

public class OverrideTest {
	public static void main(String[] args) {
		Point3D p = new Point3D(3, 5, 7);
		System.out.println(p);
	}
}
