package Chogandan;

public class ThreadSleep {
    public static void main(String[] args) {
        System.out.println("Wait for a sec");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Chicken");
    }
}
