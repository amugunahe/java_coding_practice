package com.listex; // 이 코드 파일이 속한 폴더(패키지) 이름이다.

import java.util.*; // 'Set', 'HashSet' 같은 유용한 클래스들을 다 가져온다.

public class HashSetEx01 { // 'HashSetEx01'이라는 클래스 시작!

	public static void main(String[] args) { // 프로그램의 시작점, 메인 메소드다!

		// 여러 종류의 데이터가 섞여있는 배열을 만든다.
		Object[] objArr = { 
			"1",           // 문자열 "1"
			new Integer(1), // 정수 1 (객체 형태)
			"2", "2",      // 문자열 "2", 중복
			"3", "3",      // 문자열 "3", 중복
			"4", "4", "4", "4" // 문자열 "4", 존나 많이 중복
		};
		
		// HashSet을 생성한다. 여기에 중복 없는 유일한 값들만 들어갈 거다.
		Set set = new HashSet(); // 'Set'은 인터페이스고, 'HashSet'이 그 구현체다.

		// 배열에 있는 모든 요소를 HashSet에 추가한다.
		for (int i = 0; i < objArr.length; i++) {
			set.add(objArr[i]); // add() 메소드로 요소 추가. 중복된 건 지가 알아서 걸러낸다.
		}
		
		// HashSet에 저장된 최종 결과물을 출력한다.
		System.out.println(set);	// 중복은 다 사라지고 유일한 값들만 남는다. 순서는 보장 안 됨.
		
	} // main 메소드 끝
} // HashSetEx01 클래스 끝
