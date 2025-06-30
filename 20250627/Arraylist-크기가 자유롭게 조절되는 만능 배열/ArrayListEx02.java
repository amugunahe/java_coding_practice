package com.listex; // 이 코드 파일이 속한 폴더(패키지) 이름이다.

import java.util.*; // 'ArrayList', 'List' 같은 유용한 클래스들을 다 가져온다.

public class ArrayListEx02 { // 'ArrayListEx02'라는 클래스 시작!

	public static void main(String[] args) { // 프로그램의 시작점, 메인 메소드다!

		// ★핵심★ 문자열을 자를 기준 길이다. 상수(final)로 박아버렸다.
		final int LIMIT = 10; 

		// int 배열은 여기서 안 쓴다, 이 새끼야! 그냥 지워버려라.
		// int[] arr = { 1, 2, 3, 4, 5 }; 
		
		// 쪼갤 원본 문자열이다. 존나 길게 넣어봤다.
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ"; 
		
		// source 문자열의 실제 길이를 저장한다.
		int sourceLength = source.length(); // 변수 이름을 'len1'에서 'sourceLength'로 바꿔서 더 명확하게 했다.
		
		// arr 배열 길이는 안 쓴다니까? 이것도 지워버려라.
		// int len2 = arr.length; 

		// System.out.println(length); // 이 부분 주석 처리 잘 했다. 'length' 변수 없어서 에러 났을 거다.

		// ★핵심★ List 인터페이스를 사용하고 구현체로 ArrayList를 생성한다.
		// <String> 제네릭을 명시해서 'String' 타입만 담을 거라고 분명히 알려줘야 한다! (존나 중요!)
		// 초기 용량은 대충 '원본 문자열 길이 / 자를 길이 + 1' 정도로 잡으면 메모리 효율에 좋다.
		// 남는 부분 때문에 +1을 해주는 게 정확하다.
		List<String> list = new ArrayList<>(sourceLength / LIMIT + (sourceLength % LIMIT != 0 ? 1 : 0)); 
		// (참고: 그냥 'new ArrayList<>()'로 시작해도 알아서 공간 늘어나니까 꼭 이렇게 복잡하게 할 필요는 없다.)
		
		// ArrayList의 초기 size는 당연히 0이다. 아무것도 안 넣었으니까.
		System.out.println("ArrayList 초기 크기: " + list.size()); // 출력: ArrayList 초기 크기: 0

		// ★핵심★ 문자열을 LIMIT(10) 단위로 끊어서 ArrayList에 추가하는 반복문이다.
		// 'i'는 현재 자르기 시작할 인덱스다.
		for (int i = 0; i < sourceLength; i += LIMIT) { // 'sourceLength' 변수 썼다!

			// 현재 인덱스(i)에서 LIMIT만큼 더한 값이 전체 길이(sourceLength)보다 작으면
			// 즉, LIMIT만큼 온전히 자를 수 있는 부분이면
			if (i + LIMIT < sourceLength) { 
				// source.substring(시작인덱스, 끝인덱스) : 시작인덱스부터 끝인덱스 '직전'까지 자른다.
				// 예를 들어 i가 0이면, 0부터 10 전까지 (인덱스 0~9) 잘라서 추가.
				list.add(source.substring(i, i + LIMIT));
			} else {
				// LIMIT만큼 온전히 자를 수 없을 때 (즉, 마지막 남은 부분이 LIMIT보다 짧을 때)
				// source.substring(시작인덱스) : 시작인덱스부터 문자열 '끝까지' 모두 자른다.
				// 예를 들어 남은 문자열이 'ZZZ' (3글자) 이면, 이걸 전부 잘라서 추가.
				list.add(source.substring(i));
			}
		}

		// ★핵심★ ArrayList에 담긴 모든 문자열 조각들을 하나씩 꺼내서 출력한다.
		// list.get(i)는 i번째 인덱스의 요소를 가져온다.
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	} // main 메소드 끝

} // ArrayListEx02 클래스 끝
