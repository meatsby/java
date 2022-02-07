package JavaStandard.ch14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> intStream = list.stream(); // list를 스트림으로 변환

		// 스트림의 모든 요소를 출력
		intStream.forEach(System.out::print); // forEach의 최종 연산

		intStream = list.stream(); // list로부터 stream을 다시 생성
		intStream.forEach(System.out::print);
	}
}
