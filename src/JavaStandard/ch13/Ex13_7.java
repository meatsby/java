package JavaStandard.ch13;

class Ex13_7 implements Runnable {
	static boolean autoSave = false;

	public static void main(String[] args) {
		Thread t = new Thread(new Ex13_7());
		t.setDaemon(true);
		t.start();

		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println(i);

			if (i==5) {
				autoSave = true;
			}
		}
		System.out.println("종료");
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(3 * 1000);
			} catch(InterruptedException e) {}

			// autoSave 값이 true면 autoSave() 호출
			if (autoSave) {
				autoSave();
			}
		}
	}

	private void autoSave() {
		System.out.println("자동저장");
	}
}
