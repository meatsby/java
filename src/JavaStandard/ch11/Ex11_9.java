package JavaStandard.ch11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex11_9 {
	public static void main(String[] args) {
		Object[] objArr = {"1", new Integer(1), "2", "2", "3", "3", "3", "4", "4", "4"};
		Set set = new HashSet();

		for (Object o : objArr) {
			set.add(o);
		}

		System.out.println(set);

		Iterator it = set.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
