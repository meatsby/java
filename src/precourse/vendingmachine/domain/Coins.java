package precourse.vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Coins {
	private static final int EMPTY = 0;
	private static final int ADD_COUNT = 1;

	private int changeBalance;
	private final Map<Coin, Integer> changeCoins = new LinkedHashMap<>();
	private final Map<Coin, Integer> changeableCoins = new LinkedHashMap<>();

	public Coins(int changeBalance) {
		this.changeBalance = changeBalance;
		initChangeBalance();
	}

	private void initChangeBalance() {
		changeCoins.put(Coin.COIN_500, EMPTY);
		changeCoins.put(Coin.COIN_100, EMPTY);
		changeCoins.put(Coin.COIN_50, EMPTY);
		changeCoins.put(Coin.COIN_10, EMPTY);
	}

	public void createRandomChanges() {
		while (changeBalance != EMPTY) {
			int randCoin = Coin.getRandomCoin();
			if (randCoin > changeBalance) {
				continue;
			}
			changeBalance -= randCoin;
			Coin coinName = Coin.nameOf(randCoin);
			changeCoins.replace(coinName, changeCoins.get(coinName) + ADD_COUNT);
		}
	}

	public Map<Coin, Integer> getChangeCoins() {
		return changeCoins;
	}

	public Map<Coin, Integer> getChangeableCoins(Balance balance) {
		for (Map.Entry<Coin, Integer> coin : changeCoins.entrySet()) {
			updateCoinStatus(coin, balance);
		}
		return changeableCoins;
	}

	private void updateCoinStatus(Map.Entry<Coin, Integer> coin, Balance balance) {
		while (balance.getBalance() >= coin.getKey().getAmount() && coin.getValue() > 0) {
			balance.reduceBalance(coin.getKey().getAmount());
			if (changeableCoins.containsKey(coin.getKey())) {
				changeableCoins.replace(coin.getKey(), changeableCoins.get(coin.getKey()) + ADD_COUNT);
				changeCoins.replace(coin.getKey(), coin.getValue() - 1);
				continue;
			}
			changeableCoins.put(coin.getKey(), 1);
			changeCoins.replace(coin.getKey(), coin.getValue() - 1);
		}
	}
}
