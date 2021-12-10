package precourse.vendingmachine.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Items {
	private static final int EMPTY = 0;

	private final List<Item> itemList = new ArrayList<>();

	public void add(Item item) {
		itemList.add(item);
	}

	public int getCheapest() {
		List<Integer> priceList = new ArrayList<>();
		for (Item item : itemList) {
			priceList.add(item.getPrice());
		}
		return Collections.min(priceList);
	}

	public boolean soldOut() {
		int totalQuantity = 0;
		for (Item item : itemList) {
			totalQuantity += item.getQuantity();
		}
		return totalQuantity == EMPTY;
	}

	public boolean noSuchItem(String itemName) {
		List<String> nameList = new ArrayList<>();
		for (Item item : itemList) {
			nameList.add(item.getName());
		}
		return !nameList.contains(itemName);
	}

	public boolean notEnoughItem(String itemName) {
		for (Item item : itemList) {
			if (item.getName().equals(itemName) && item.getQuantity() == 0) {
				return true;
			}
		}
		return false;
	}

	public List<Item> getItemList() {
		return itemList;
	}
}
