package com.listex;

import java.util.*;

public class ArrayListEx02 {

	public static void main(String[] args) {

		// 문자열을 자를 기준 길이다.
		final int LIMIT = 10;

		// int 배열은 이 코드에서 안 쓴다. (삭제해도 됨)
		int[] arr = { 1, 2, 3, 4, 5 };
		
		// 쪼갤 원본 문자열이다.
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		
		// source 문자열의 길이를 저장한다.
		int len1 = source.length();
		
		// arr 배열의 길이를 저장한다. (이것도 안 쓴다. 지워라.)
		int len2 = arr.length;

		// System.out.println(length);  <<< 이 부분은 주석 처리했으니 상관 없지만, length라는 변수가 없어서 에러나는 부분이다.

		// List 인터페이스를 사용하고 구현체로 ArrayList를 생성한다.
		// <String> 제네릭을 명시해서 String 타입만 담을 거라고 알려줘야 한다. (존나 중요!)
		// 초기 용량은 `len1 / LIMIT + 1` 정도로 잡으면 좋다. 뒤에 +10은 너무 크게 잡는 거다.
		// `length` 변수가 없으니 `len1`으로 바꿔야 한다.
		List<String> list = new ArrayList<>(len1 / LIMIT + (len1 % LIMIT != 0 ? 1 : 0)); // <<< 이 부분 틀린 거 수정 및 최적화
		// 아니면 그냥 new ArrayList<>() 로 시작해도 된다. 어차피 알아서 공간 늘어난다.
		
		// ArrayList의 초기 size는 0이다. 출력해보면 0이 나올 거다.
		System.out.println(list.size()); // 출력: 0

		// for 문에서 length 변수가 없으니 len1으로 바꿔야 한다.
		// 문자열을 LIMIT(10) 단위로 끊어서 ArrayList에 추가하는 반복문이다.
		for (int i = 0; i < len1; i += LIMIT) { // <<< length -> len1으로 수정

			// 현재 인덱스(i)에서 LIMIT만큼 더한 값이 전체 길이(len1)보다 작으면
			// 즉, LIMIT만큼 온전히 자를 수 있으면
			if (i + LIMIT < len1) { // <<< length -> len1으로 수정
				// source.substring(시작인덱스, 끝인덱스) : 시작인덱스부터 끝인덱스 전까지 자른다.
				// 예를 들어 i가 0이면 0부터 10 전까지 (0~9) 잘라서 추가.
				list.add(source.substring(i, i + LIMIT));
			} else {
				// LIMIT만큼 온전히 자를 수 없을 때 (즉, 남은 부분이 LIMIT보다 짧을 때)
				// source.substring(시작인덱스) : 시작인덱스부터 문자열 끝까지 모두 자른다.
				// 마지막 남은 'ZZZ' 같은 부분이 여기에 해당한다.
				list.add(source.substring(i));
			}
		}

		// ArrayList에 담긴 모든 문자열 조각들을 하나씩 꺼내서 출력한다.
		for (int i = 0; i< list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}

}
