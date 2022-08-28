package JavaStandard.ch07;

public class Ex7_4 {
    public static void main(String[] args) {
        Coordinate3D p = new Coordinate3D(1, 2, 3);
        System.out.println("x=" + p.x + ",y=" + p.y + ",z=" + p.z);
    }
}

class Coordinate {
    int x, y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Coordinate3D extends Coordinate {
    int z;

    Coordinate3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}
