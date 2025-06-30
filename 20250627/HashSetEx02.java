package com.listex; // 이 파일이 속한 패키지 이름

import java.util.HashSet; // HashSet 쓸 때 필요한 놈
import java.util.Iterator; // 집합 요소들 하나씩 돌려볼 때 필요한 놈

/*
 * 핵심 요약:
 * - 이 코드는 **HashSet을 이용해서 두 집합(setA, setB) 간의 연산(교집합, 합집합, 차집합)을 보여주는 예제**다.
 * - HashSet은 순서 상관없이 중복을 허용하지 않는 데이터 모음집이다.
 * - `retainAll()`로 교집합, `addAll()`로 합집합, `removeAll()`로 차집합을 구한다.
 * - **원본 집합이 변경될 수 있으니, 연산 전에 복사본을 만드는 게 중요**하다.
 */
public class HashSetEx02 {

	public static void main(String[] args) {

		// 집합들 만들 때 쓰는 변수들 미리 선언함
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		
		// Set A에 값 때려 박기
		setA.add("1"); setA.add("2");setA.add("3");
		setA.add("4");setA.add("5");
		System.out.println("Set A: " + setA);
		
		// Set B에 값 때려 박기
		setB.add("4"); setB.add("5"); setB.add("6");
		setB.add("7"); setB.add("8");
		System.out.println("Set B: " + setB);
		
		System.out.println("----- 집합 연산 시작 -----");
		
		// 1. 교집합 (Intersection)
		// setA랑 setB의 공통된 요소들만 남기는 거다.
		// **중요:** 원본 setA가 바뀌는 걸 막으려고 setA를 복사해서 setKyo 초기화함.
		HashSet setKyo = new HashSet(setA); // setA를 복사해서 교집합 만들 준비
		setKyo.retainAll(setB); // setKyo(현재 setA 복사본)에서 setB에 없는 요소는 다 지워버림
		System.out.println("A 교집합 B: " + setKyo);
		
		// 2. 합집합 (Union)
		// setA랑 setB의 모든 요소를 합치는 거다. (중복은 알아서 처리됨)
		// **중요:** 원본 setA가 바뀌는 걸 막으려고 setA를 복사해서 setHab 초기화함.
		HashSet setHab = new HashSet(setA); // setA를 복사해서 합집합 만들 준비
		setHab.addAll(setB); // setHab(현재 setA 복사본)에 setB의 모든 요소를 추가함
		System.out.println("A 합집합 B: " + setHab);
		
		// 3. 차집합 (Difference: A - B)
		// setA에만 있고 setB에는 없는 요소들만 남기는 거다.
		// **중요:** 원본 setA가 바뀌는 걸 막으려고 setA를 복사해서 setCha 초기화함.
		HashSet setCha = new HashSet(setA); // setA를 복사해서 차집합 만들 준비
		setCha.removeAll(setB); // setCha(현재 setA 복사본)에서 setB에 있는 요소는 다 지워버림
		System.out.println("A 차집합 B (A - B): " + setCha);
		
		System.out.println("----- 집합 연산 끝 -----");
		
		// 주석 처리된 부분: 원래 니 코드에 있던 부분인데,
		// 위에서 `retainAll`, `addAll`, `removeAll` 쓰면 아래처럼 Iterator 돌릴 필요 없이 깔끔하게 된다.
		// 그래서 주석 처리해 놓은 거다.
		/*
		// 이 부분은 잘못된 사용법이라 지움. setA.add(setB)는 집합 안에 집합을 넣으려는 시도임.
		// System.out.println(setA.add(setB));

		// 합집합 로직 (수동으로 Iterator 돌린 건데, addAll 쓰는 게 훨씬 간편함)
		// Iterator it; // Iterator 변수 선언
		// it = setA.iterator();
		// while(it.hasNext()) {
		// 	setHab.add(it.next());
		// }
		// it = setB.iterator();
		// while(it.hasNext()) {
		// 	setHab.add(it.next());
		// }
		// System.out.println(setHab);
		
		// 차집합 로직 (수동으로 Iterator 돌린 건데, removeAll 쓰는 게 훨씬 간편함)
		// it = setA.iterator();
		// while(it.hasNext()) {
		// 	Object tmp = it.next();
		// 	if(!setB.contains(tmp))
		// 		setCha.add(tmp);
		// }
		// System.out.println(setCha); // setCha -> setCha 오타 수정
		*/
	}
}


