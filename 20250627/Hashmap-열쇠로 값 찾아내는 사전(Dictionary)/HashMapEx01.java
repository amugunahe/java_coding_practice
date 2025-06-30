package com.listex; // 이 코드 파일이 속한 폴더(패키지) 이름이다.

import java.util.*; // 'Map', 'HashMap', 'Set', 'Iterator' 같은 유용한 클래스들을 다 가져온다.

public class HashMapEx01 { // 'HashMapEx01'이라는 클래스 시작!

	public static void main(String[] args) { // 프로그램의 시작점, 메인 메소드다!
		// HashMap을 만든다.
		// <String, String>은 "키도 문자열, 값도 문자열"이라는 뜻이다.
		// Map은 인터페이스고, HashMap이 그 구현체다.
		Map<String, String> map = new HashMap<>(); 
		
		// map.put(키, 값); 형식으로 데이터를 추가한다.
		map.put("만화", "마녀딸배키키"); // "만화"라는 키에 "마녀딸배키키"라는 값을 저장
		map.put("호러", "스크림");       // "호러"라는 키에 "스크림"이라는 값을 저장
		map.put("영화", "황혼에서 새벽까지"); // "영화"라는 키에 "황혼에서 새벽까지"라는 값을 저장
	
		// 현재 HashMap에 저장된 모든 내용을 출력한다.
		// 순서는 보장되지 않는다. 실행할 때마다 다르게 나올 수 있다.
		System.out.println(map); 
		
		System.out.println(); // 한 줄 띄우기

		// HashMap의 모든 "키(Key)"들을 가져온다.
		// 키들은 중복이 안 되니까 Set 타입으로 리턴된다.
		Set<String> set = map.keySet(); 
		
		// Set에 있는 키들을 하나씩 꺼내기 위해 Iterator를 얻는다.
		Iterator<String> it = set.iterator(); 
		
		// Iterator에 다음 요소(키)가 있는 동안 반복한다.
		while(it.hasNext()) {
			// 다음 키를 가져온다.
			String key = it.next(); 
			// 가져온 "키(key)"를 이용해서 HashMap에서 "값(value)"을 가져와 출력한다.
			// map.get(키) 하면 해당 키에 연결된 값을 돌려준다.
			System.out.println(map.get(key)); 
		}
		System.out.println(); // 한 줄 띄우기
	
		// "영화"라는 기존 키에 새로운 값 "달마야 놀자~~"를 put 한다.
		// 그러면 기존의 "황혼에서 새벽까지" 값은 사라지고, "달마야 놀자~~"로 덮어씌워진다.
		// 이게 HashMap의 키는 중복될 수 없다는 핵심이다, 이 새끼야!
		map.put("영화","달마야 놀자~~"); 
		
		// 값이 덮어씌워진 후의 HashMap 내용을 다시 출력한다.
		System.out.println(map); 
	
	} // main 메소드 끝
} // HashMapEx01 클래스 끝
