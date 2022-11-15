package JavaStandard.ch12;

import java.util.ArrayList;

class Product {}
class MyTv extends Product {}
class MyAudio extends Product {}

public class Ex12_1 {
	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<>();
		ArrayList<MyTv> tvList = new ArrayList<>();

		products.add(new MyTv());
		products.add(new MyAudio());

		tvList.add(new MyTv());
		tvList.add(new MyTv());

		printAll(products);
	}

	private static void printAll(ArrayList<Product> products) {
		for (Product p : products) {
			System.out.println(p);
		}
	}
}
