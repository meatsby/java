package precourse.vendingmachine.controller;

import precourse.vendingmachine.view.InputView;
import precourse.vendingmachine.view.OutputView;
import precourse.vendingmachine.domain.VendingMachine;

public class VendingMachineController {
	public void run() {
		VendingMachine vendingMachine = new VendingMachine();

		initializeChanges(vendingMachine);
		OutputView.showCoins(vendingMachine);
		initializeItems(vendingMachine);
		initializeBalance(vendingMachine);

		while (vendingMachine.isAvailable()) {
			OutputView.showBalance(vendingMachine);
			executePurchase(vendingMachine);
		}
		OutputView.showBalance(vendingMachine);
		OutputView.showChange(vendingMachine);
	}

	private void initializeChanges(VendingMachine vendingMachine) {
		String changeBalance = InputView.setChanges();
		try {
			vendingMachine.initializeChanges(changeBalance);
		} catch (IllegalArgumentException e) {
			OutputView.showError(e.getMessage());
			initializeChanges(vendingMachine);
		}
	}

	private void initializeItems(VendingMachine vendingMachine) {
		String items = InputView.setItems();
		try {
			vendingMachine.initializeItems(items);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			initializeItems(vendingMachine);
		}
	}

	private void initializeBalance(VendingMachine vendingMachine) {
		String balance = InputView.setBalance();
		try {
			vendingMachine.initializeBalance(balance);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			initializeBalance(vendingMachine);
		}
	}

	private void executePurchase(VendingMachine vendingMachine) {
		String item = InputView.purchaseItem();
		try {
			vendingMachine.executePurchase(item);
		} catch (IllegalArgumentException e) {
			OutputView.showError(e.getMessage());
			executePurchase(vendingMachine);
		}
	}
}
