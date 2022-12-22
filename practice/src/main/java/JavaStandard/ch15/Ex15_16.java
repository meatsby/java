package JavaStandard.ch15;

import java.io.File;

public class Ex15_16 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE : java Ex15_16 DIRECTORY");
            System.exit(0);
        }

        File f = new File(args[0]);

        if (!f.exists() || !f.isDirectory()) {
            System.exit(0);
        }

        File[] files = f.listFiles();

        for (int i = 0; i < files.length; i++) {
            String fileName = files[i].getName();
            System.out.println(
                    files[i].isDirectory() ? "[" + fileName + "]" : fileName);
        }
    }
}
