package precourse.vendingmachine.view;

import java.util.Map;

import precourse.vendingmachine.domain.Coin;
import precourse.vendingmachine.domain.VendingMachine;

public class OutputView {
	private static final String CHANGE_ACQUIRED = "자판기가 보유한 동전";
	private static final String COIN_LIST = "%s원 - %d개%n";
	private static final String BALANCE_MESSAGE = "투입 금액: %d원%n";
	private static final String CHANGE_MESSAGE = "잔돈";
	private static final String NOTHING_TO_REFUND = "잔돈이 없습니다.";
	private static final int NO_CHANGE = 0;

	public static void showCoins(VendingMachine vendingMachine) {
		System.out.println();
		System.out.println(CHANGE_ACQUIRED);
		for (Map.Entry<Coin, Integer> change : vendingMachine.getChanges().entrySet()) {
			System.out.printf(COIN_LIST, change.getKey().name().substring(5), change.getValue());
		}
	}

	public static void showBalance(VendingMachine vendingMachine) {
		System.out.println();
		System.out.printf(BALANCE_MESSAGE, vendingMachine.getBalance());
	}

	public static void showChange(VendingMachine vendingMachine) {
		System.out.println(CHANGE_MESSAGE);
		if (vendingMachine.getBalance() == NO_CHANGE) {
			System.out.println(NOTHING_TO_REFUND);
			return;
		}
		for (Map.Entry<Coin, Integer> change : vendingMachine.getChangeable().entrySet()) {
			System.out.printf(COIN_LIST, change.getKey().name().substring(5), change.getValue());
		}
	}

	public static void showError(String error) {
		System.out.println(error);
		System.out.println();
	}
}
