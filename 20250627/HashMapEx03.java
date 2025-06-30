package com.listex; // 이 파일이 속한 패키지 이름

import java.util.Collection; // 값들을 모아둔 컬렉션 쓸 때 필요한 놈
import java.util.Collections; // 컬렉션 정렬, 최대/최소 같은 기능 쓸 때 필요한 놈
import java.util.HashMap; // 키-값 쌍으로 데이터 저장할 때 필요한 놈
import java.util.Iterator; // 컬렉션 요소들 하나씩 돌려볼 때 필요한 놈
import java.util.Map; // Map 인터페이스, 특히 Map.Entry 쓸 때 필요한 놈 (java.util.*에 포함되지만 명시적으로 써줌)
import java.util.Set; // 중복 없는 요소 집합(키) 쓸 때 필요한 놈

/*
 * 핵심 요약:
 * - 이 코드는 **HashMap을 이용해서 학생 이름과 점수를 저장하고 관리하는 예제**다.
 * - HashMap은 '키(이름)'랑 '값(점수)'을 한 쌍으로 묶어서 저장한다. 키는 중복 안 되고, 값은 중복 돼도 된다.
 * - **이름(키), 점수(값)를 각각 꺼내서 보거나, 전체 점수 통계(총점, 평균, 최고점, 최저점)를 계산한다.**
 *
 * HashMapEx03 클래스: HashMap으로 점수 관리하고 통계 뽑는 거
 * - 이름(String)이랑 점수(Integer)를 `HashMap`에 저장하고, 이걸 가지고 이런저런 통계를 뽑아본다.
 * - **중요:** HashMap은 키(Key)와 값(Value)으로 이루어진 쌍을 저장하는 컬렉션이다.
 * - 키는 중복될 수 없다. (예: 이름)
 * - 값은 중복될 수 있다. (예: 점수)
 */
public class HashMapEx03 {

	public static void main(String[] args) {

		// HashMap<String, Integer> 타입으로 'map' 생성.
		// 키는 String(이름), 값은 Integer(점수)로 지정했다.
		HashMap<String, Integer> map = new HashMap<>(); 
		map.put("가길동", 100); // 이름 "가길동", 점수 100 추가
		map.put("나길동", 100); // 이름 "나길동", 점수 100 추가
		map.put("다길동", 80); // 이름 "다길동", 점수 80 추가
		map.put("라길동", 90); // 이름 "라길동", 점수 90 추가

		System.out.println("----- 이름과 점수 목록 -----");
		// 1. entrySet()으로 키-값 쌍(Entry) 전체 가져오기
		// **중요:** map.entrySet()은 Map.Entry 객체들을 Set 형태로 반환한다.
		Set set = map.entrySet(); 
		Iterator it = set.iterator(); // Set을 순회할 Iterator 생성
		
		while(it.hasNext()) { // 다음 요소가 있을 때까지 반복
			// **중요:** Iterator에서 꺼낸 Object를 Map.Entry로 형변환 해야 키와 값을 꺼낼 수 있다.
			Map.Entry e = (Map.Entry)it.next(); 
			System.out.println("이름: " + e.getKey() + ", 점수: " + e.getValue()); // 이름과 점수 출력
		}
		
		System.out.println("\n----- 모든 이름 목록 (keySet) -----");
		// 2. keySet()으로 모든 키(이름)만 가져오기
		set = map.keySet(); // map의 모든 키들을 Set 형태로 가져온다.
		System.out.println("이름들: " + set); // Set은 toString()이 구현되어 있어 바로 출력 가능
		
		System.out.println("\n----- 모든 점수 목록 (values) 및 통계 -----");
		// 3. values()로 모든 값(점수)만 가져오기
		// **중요:** map.values()는 Map의 모든 값들을 Collection 형태로 반환한다.
		Collection values = map.values(); 
		
		it = values.iterator(); // Collection을 순회할 Iterator 생성
		
		int sum = 0; // **중요:** 총점을 저장할 변수 'sum' 선언 및 초기화. (원래 코드에 없어서 추가함)
		
		while(it.hasNext()) { // 다음 요소가 있을 때까지 반복
			Integer i = (Integer)it.next(); // Iterator에서 꺼낸 Object를 Integer로 형변환
			sum += i; // 총점에 현재 점수를 더함
			System.out.print(i + "\t"); // 점수 출력 (탭으로 구분)
		}
		System.out.println(); // 줄바꿈
		
		System.out.println("총점: " + sum); // 계산된 총점 출력
		// **중요:** 평균은 총점 / 학생 수(키의 개수)로 계산한다.
		// set.size()는 keySet()에서 가져온 Set의 크기, 즉 학생 수를 의미한다.
		System.out.println("평균: " + (double)sum / set.size()); // 평균 출력 (정수 나눗셈 방지 위해 double로 형변환)
		System.out.println("최고 점수: " + Collections.max(values)); // **중요:** Collections.max()로 최대값 찾기
		System.out.println("최저 점수: " + Collections.min(values)); // **중요:** Collections.min()으로 최소값 찾기
	}

}
