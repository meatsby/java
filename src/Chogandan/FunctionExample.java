package Chogandan;

public class FunctionExample {
    public static void main(String[] args) {
        sayHello();
        sayHelloTo("Seokyoon");
        printSum(3, 5);

        int[] sumAndProduct = addAndMultiply(2, 3);
        System.out.println("sum: " + sumAndProduct[0]);
        System.out.println("product: " + sumAndProduct[1]);

        boolean saidHola = sayHola("Ediot");
        System.out.println(saidHola);
    }

    public static boolean sayHola(String name) {
        if (name.equals("Ediot")) {
            System.out.println("Inappropriate name");
            return false;
        }
        System.out.println("Hi, " + name);
        return true;
    }

    public static int[] addAndMultiply(int a, int b) {
        int sum = a + b;
        int product = a * b;

        int[] result = {sum, product};

        return result;
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    public static void printSum(int a, int b) {
        System.out.println(a + " + " + b + " = " + sum(a, b));
    }

    private static void sayHelloTo(String name) {
        System.out.println("Hello, " + name);
    }

    public static void sayHello() {
        System.out.println("Hello!");
    }
}
