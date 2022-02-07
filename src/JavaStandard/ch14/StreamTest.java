package JavaStandard.ch14;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		// List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		// Stream<Integer> intStream = list.stream(); // list를 스트림으로 변환
		//
		// // 스트림의 모든 요소를 출력
		// intStream.forEach(System.out::print); // forEach의 최종 연산
		//
		// intStream = list.stream(); // list로부터 stream을 다시 생성
		// intStream.forEach(System.out::println);
		// System.out.println();

		// Stream<String> strStream = Stream.of("a", "b", "c");
		// Stream<String> strStream = Arrays.stream(new String[] {"a", "b", "c"});
		// strStream.forEach(System.out::println);

		// int[] intArr = {1, 2, 3, 4, 5};
		// Stream<Integer> intStream = Arrays.stream(intArr);
		// IntStream intStream = Arrays.stream(intArr);
		// intStream.forEach(System.out::println);
		// System.out.println("count = " + intStream.count());
		// System.out.println("sum = " + intStream.sum());
		// System.out.println("average = " + intStream.average());

		IntStream intStream = new Random().ints(10, 5, 10);
		intStream
			// .limit(10)
			.forEach(System.out::println);
	}
}
