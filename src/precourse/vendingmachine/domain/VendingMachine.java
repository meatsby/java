package precourse.vendingmachine.domain;

import java.util.List;
import java.util.Map;

import precourse.vendingmachine.Validation;

public class VendingMachine {
	private static final int NAME = 0;
	private static final int PRICE = 1;
	private static final int QUANTITY = 2;

	private Coins changes;
	private Items items;
	private Balance balance;

	public void initializeChanges(String input) {
		int changeBalance = Validation.isValid(input);
		this.changes = new Coins(changeBalance);
		changes.createRandomChanges();
	}

	public void initializeItems(String input) {
		this.items = new Items();
		List<String> itemsInfo = Validation.isValidItems(input);
		for (String itemInfo : itemsInfo) {
			List<String> detail = Validation.isValidItem(itemInfo);
			items.add(new Item(detail.get(NAME), detail.get(PRICE), detail.get(QUANTITY)));
		}
	}

	public void initializeBalance(String input) {
		int balance = Validation.isValid(input);
		this.balance = new Balance(balance);
	}

	public boolean isAvailable() {
		return balance.getBalance() >= items.getCheapest() && !items.soldOut();
	}

	public void executePurchase(String itemName) {
		Validation.isValidPurchase(itemName, items);
		for (Item item : items.getItemList()) {
			returnItem(item, itemName);
		}
	}

	private void returnItem(Item item, String itemName) {
		if (item.getName().equals(itemName) && item.getQuantity() != 0) {
			item.reduceQuantity();
			balance.reduceBalance(item.getPrice());
		}
	}

	public Map<Coin, Integer> getChanges() {
		return changes.getChangeCoins();
	}

	public Map<Coin, Integer> getChangeable() {
		return changes.getChangeableCoins(balance);
	}

	public int getBalance() {
		return balance.getBalance();
	}

}
