package com.listex; // 이 코드 파일이 속한 폴더(패키지) 이름이다.

import java.util.*; // 'Set', 'HashSet', 'List', 'LinkedList', 'Collections' 같은 유용한 클래스들을 다 가져온다.

public class HashSetLotto { // 'HashSetLotto'라는 클래스 시작!

	public static void main(String[] args) { // 프로그램의 시작점, 메인 메소드다!

		// Integer 타입의 데이터를 저장할 HashSet을 만든다.
		// 로또 번호는 중복되면 안 되니까 HashSet이 딱이다! 순서는 중요하지 않으니 HashSet 쓴다.
		Set<Integer> set = new HashSet(); 

		// HashSet에 로또 번호 6개를 채울 때까지 반복한다.
		// set.size()가 6보다 작을 때까지 계속 돈다. HashSet은 중복된 걸 넣으면 사이즈가 안 늘어나니까,
		// 중복 없는 6개의 번호가 채워질 때까지 자동으로 반복하게 된다. 이게 핵심이다
		for (int i = 0; set.size() < 6; i++) { 
			// 1부터 45까지의 랜덤 숫자를 만든다. (Math.random()은 0.0 이상 1.0 미만, 거기에 45를 곱하고 +1)
			int num = (int) (Math.random() * 45) + 1; 
			set.add(num); // HashSet에 랜덤 숫자를 추가한다. 중복된 숫자는 자동으로 걸러진다!
		}

		// HashSet은 순서가 없어서 정렬이 안 된다. 그래서 순서가 있는 List로 변환해준다.
		// LinkedList는 List 인터페이스의 한 종류다.
		List list = new LinkedList(set); 
		
		// List에 담긴 로또 번호들을 오름차순으로 정렬한다.
		Collections.sort(list); // 'Collections' 유틸리티 클래스의 'sort()' 메소드를 쓴다.
		
		// 최종 로또 번호 6개를 출력한다!
		System.out.println(list); 
	} // main 메소드 끝
} // HashSetLotto 클래스 끝
