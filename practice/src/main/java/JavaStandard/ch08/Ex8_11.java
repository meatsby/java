package JavaStandard.ch08;

public class Ex8_11 {
    public static void main(String args[]) {
        try {
            startInstall();
            copyFiles();
        } catch (SpaceException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (MemoryException me) {
            System.out.println(me.getMessage());
            me.printStackTrace();
            System.gc();
        } finally {
            deleteTempFiles();
        }
    }

    static void startInstall() throws SpaceException, MemoryException {
		if (!enoughSpace())
		{
			throw new SpaceException("SE");
		}
		if (!enoughMemory())
		{
			throw new MemoryException("ME");
		}
    }

    static void copyFiles() {}

    static void deleteTempFiles() {}

    static boolean enoughSpace() {
        return false;
    }

    static boolean enoughMemory() {
        return true;
    }
}

class SpaceException extends Exception {
    SpaceException(String msg) {
        super(msg);
    }
}

class MemoryException extends Exception {
    MemoryException(String msg) {
        super(msg);
    }
}
