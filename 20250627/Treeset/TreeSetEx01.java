package com.listex; // 이 코드가 속한 패키지다. 대충 파일 위치라고 생각하면 된다.

import java.util.*; // java.util 패키지에 있는 모든 클래스를 불러온다. TreeSet 같은 거 쓰려면 이거 있어야 한다.

public class TreeSetEx01 { // TreeSetEx01이라는 이름의 공개 클래스 선언

	public static void main(String[] args) { // 프로그램 시작점, 메인 메소드다. 여기서부터 코드가 실행된다.
		
		// TreeSet 객체를 생성한다.
		// TreeSet은 데이터를 '자동으로 정렬'해서 저장하고, '중복을 허용하지 않는' Set 계열의 컬렉션이다.
		// 주로 검색, 정렬, 범위 검색에 존나 좋다. (이진 탐색 트리 기반이다, 이 새끼야!)
		TreeSet set = new TreeSet(); // 기본적으로 String은 사전 순으로 정렬된다. 대문자가 소문자보다 먼저 온다.
		
		String from = "b"; // 검색 시작 범위 (포함)
		String to ="d";   // 검색 끝 범위 (포함 안 됨! 이거 존나 중요하다!)
		
		// TreeSet에 문자열 요소들을 추가한다.
		// 추가되는 순간 지들끼리 알아서 정렬되고, 중복되는 건 안 들어간다.
		set.add("abc");set.add("alien");set.add("bat");
		set.add("car");set.add("Car");set.add("disc"); // "Car"는 "car"보다 먼저 정렬된다.
		set.add("dance");set.add("dZZZZ");set.add("dzzzz"); // 대문자가 소문자보다 먼저 정렬된다.
		set.add("elephant");set.add("elevator");set.add("fan");
		set.add("flower");
		
		// TreeSet 전체를 출력한다.
		// 저장된 순서가 아니라, '알아서 정렬된 순서'로 출력된다.
		// 예를 들어, "Car"가 "car"보다 먼저 나올 거다.
		System.out.println(set); 
		
		System.out.println(from + " to " + to); // 검색할 범위 메시지 출력 ("b to d")
		
		// set.subSet(from, to): 'from'부터 'to' 바로 앞까지의 요소들로 이루어진 새로운 Set을 반환한다.
		// 'from'은 포함되지만, 'to'는 포함되지 않는다! (이게 범위 검색할 때 존나 헷갈리는 부분이다!)
		// 여기서는 'b'로 시작하는 단어부터 'd'로 시작하는 단어 바로 앞까지를 뽑아낸다.
		System.out.println(set.subSet(from, to)); // "b"로 시작하는 것들만 나올 거다. "d"는 안 나온다.

		// set.subSet(from, to + "zzzzz"): 'from'부터 'to' 뒤에 "zzzzz"를 붙인 문자열 바로 앞까지의 요소를 반환한다.
		// "zzzzz"를 붙이는 이유는 'd'로 시작하는 모든 단어를 포함시키기 위함이다.
		// 예를 들어 'd' 다음에 'e'가 오기 때문에, 'd'로 시작하는 모든 단어('dance', 'dZZZZ', 'dzzzz')를 포함하려면
		// 'd' 다음으로 오는 모든 '알파벳 조합'보다 큰 값을 'to' 범위로 줘야 한다.
		// "dzzzzz"는 'd'로 시작하는 거의 모든 가능한 문자열을 포함시키기 위한 꼼수 같은 거다.
		// (실제로는 'd'로 시작하는 마지막 요소인 'dzzzz' 다음 순서까지 범위를 잡는다고 생각하면 편하다.)
		System.out.println(set.subSet(from, to + "zzzzz")); // "b"로 시작하는 것부터 "d"로 시작하는 모든 것까지 나올 거다.
	}
}
