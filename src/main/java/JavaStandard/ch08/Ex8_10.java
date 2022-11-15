package JavaStandard.ch08;

import java.io.File;

public class Ex8_10 {
	public static void main(String[] args) {
		try {
			File f = createFile("text.txt");
			System.out.println(f.getName() + "생성 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "다시 입력 바람");
		}
	}

	static File createFile(String fileName) throws Exception {
		if (fileName == null || fileName.equals("")) {
			throw new Exception("유효하지 않은 이름");
		}
		File f = new File(fileName);
		f.createNewFile();
		return f;
	}
}
