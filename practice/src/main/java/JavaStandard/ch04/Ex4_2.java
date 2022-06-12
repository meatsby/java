package JavaStandard.ch04;

public class Ex4_2 {
    public static void main(String[] args) {
        int x = 0;
        System.out.println(x);

		if (x == 0) {
			System.out.println("x==0");
		}
		if (x != 0) {
			System.out.println("x!=0");
		}
		if (!(x == 0)) {
			System.out.println("!(x==0)");
		}
		if (!(x != 0)) {
			System.out.println("!(x!=0)");
		}

        x = 1;
        System.out.println(x);

		if (x == 0) {
			System.out.println("x==0");
		}
		if (x != 0) {
			System.out.println("x!=0");
		}
		if (!(x == 0)) {
			System.out.println("!(x==0)");
		}
		if (!(x != 0)) {
			System.out.println("!(x!=0)");
		}
    }
}
