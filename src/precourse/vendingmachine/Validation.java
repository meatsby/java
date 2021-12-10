package precourse.vendingmachine;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import precourse.vendingmachine.domain.Items;

public class Validation {
	private static final String REGEX = "\\[[a-zA-Z0-9가-힣]+,\\d{3,},\\d+\\]";
	private static final String ERROR = "[ERROR] ";
	private static final String NOT_DIGIT_ERROR = "금액은 숫자여야 합니다.";
	private static final String NOT_DIVIDABLE_ERROR = "금액은 10원 단위로 나누어져야 합니다.";
	private static final String NOT_POSITIVE_ERROR = "금액은 자연수여야 합니다.";
	private static final String NO_ITEMS_ERROR = "상품이 입력되지 않았습니다.";
	private static final String NOT_VALID_FORMAT = "입력 형식이 잘못되었습니다.";
	private static final String NOT_VALID_PRICE = "상품가격은 10원 단위로 나누어져야 합니다.";
	private static final String NOT_SUCH_ITEMS = "상품이 존재하지 않습니다.";
	private static final String NOT_ENOUGH_ITEMS = "해당 상품이 부족합니다.";

	public static int isValid(String input) {
		int balance = isDigit(input);
		isDividable(balance);
		isPositive(balance);
		return balance;
	}

	private static int isDigit(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ERROR + NOT_DIGIT_ERROR);
		}
	}

	private static void isDividable(int changeBalance) {
		if (changeBalance % 10 != 0) {
			throw new IllegalArgumentException(ERROR + NOT_DIVIDABLE_ERROR);
		}
	}

	private static void isPositive(int changeBalance) {
		if (changeBalance < 0) {
			throw new IllegalArgumentException(ERROR + NOT_POSITIVE_ERROR);
		}
	}

	public static List<String> isValidItems(String input) {
		if (input.equals("")) {
			throw new IllegalArgumentException(ERROR + NO_ITEMS_ERROR);
		}
		List<String> items = Arrays.asList(input.split(";"));
		if (items.size() == 0) {
			throw new IllegalArgumentException(ERROR + NO_ITEMS_ERROR);
		}
		return items;
	}

	public static List<String> isValidItem(String item) {
		if (!Pattern.matches(REGEX, item)) {
			throw new IllegalArgumentException(ERROR + NOT_VALID_FORMAT);
		}
		List<String> itemInfo = Arrays.asList(item.substring(1, item.length() - 1).split(","));
		if (Integer.parseInt(itemInfo.get(1)) % 10 != 0) {
			throw new IllegalArgumentException(ERROR + NOT_VALID_PRICE);
		}
		if (Integer.parseInt(itemInfo.get(2)) <= 0) {
			throw new IllegalArgumentException(ERROR + NOT_ENOUGH_ITEMS);
		}
		return itemInfo;
	}

	public static void isValidPurchase(String itemName, Items items) {
		if (items.noSuchItem(itemName)) {
			throw new IllegalArgumentException(ERROR + NOT_SUCH_ITEMS);
		}
		if (items.notEnoughItem(itemName)) {
			throw new IllegalArgumentException(ERROR + NOT_ENOUGH_ITEMS);
		}
	}
}
