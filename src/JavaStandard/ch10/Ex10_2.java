package JavaStandard.ch10;

import java.util.Calendar;

public class Ex10_2 {
	public static void main(String[] args) {
		final String[] DAY_OF_WEEK = {"", "일", "월", "화", "수", "목", "금", "토"};

		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();

		date1.set(2021, 8, 27);
		System.out.println("전역일은 " + toString(date1));
		System.out.println("오늘은 " + toString(date2));

		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis())/1000;
		System.out.println("그 날부터 지금 까지 " + difference + "초가 지났음");
		System.out.println("그 날부터 지금 까지 " + difference/(24*60*60) + "일이 지났음");
	}

	private static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년 "
			+ (date.get(Calendar.MONTH) + 1) + "월 "
			+ date.get(Calendar.DATE) + "일";
	}
}
