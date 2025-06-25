package com.objectex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
 * ReferenceParamEx02 클래스: **배열을 '참조형 매개변수(Pass by Reference)'로 넘겼을 때, 메소드 안에서 원본 배열이 어떻게 바뀌는지 존나게 명확하게 보여주는 예제다!**
 *
 * 핵심:
 * - **배열은 '참조형'이다! (존나 중요!)**
 * - 메소드로 배열을 넘겨줄 때, 배열 자체가 아니라 '배열이 저장된 메모리 주소(참조값)'를 복사해서 넘겨준다.
 * - **`increase()` 메소드:** `int` 배열을 매개변수로 받아서 그 배열의 모든 요소들을 1씩 증가시킨다.
 * - **`main()` 메소드:** 배열을 만들고, `increase()` 메소드에 넘겨준 후, 배열의 값이 어떻게 변하는지 확인한다.
 * - **결과 예측:** `increase()` 메소드 안에서 배열의 요소 값이 바뀌면, `main()` 메소드에 있는 **원본 배열의 요소 값도 존나게 직접 바뀐다!**
 * (왜냐? 두 변수가 '같은 배열'을 가리키고 있으니까!)
 */

public class ReferenceParamEx02 { // 'ReferenceParamEx02'라는 이름의 공개(public) 클래스를 정의한다.

	// ★★★ 1. 배열의 각 요소를 1씩 증가시키는 메소드: `increase` (참조형 매개변수 테스트!) ★★★
	// `public`이라 다른 클래스에서도 호출 가능.
	// `void`라 반환값 없음.
	// 'int[] n' ← 여기가 바로 **★참조형 매개변수★** 부분이다!
	// 뜻: "int 배열의 '메모리 주소'를 복사해서 받을 거야!"
	public void increase(int[] n) { // 매개변수 `n`은 `main` 메소드의 `ref`와 **★같은 배열을 가리킨다!★**
		for (int i = 0; i < n.length; i++) { // 배열 `n`의 길이만큼 반복한다.
			n[i]++; // `n`이 가리키는 배열의 `i`번째 요소 값을 1 증가시킨다.
					// ★개중요★ `n`이랑 `ref`가 같은 메모리 주소(같은 배열)를 보고 있으니까,
					// 여기서 값을 바꾸면, `main` 메소드의 `ref` 배열 값이 **★직접 바뀐다!★**
		}
	}
	
	// ★★★ 2. 메인 메소드: 프로그램의 시작점! ★★★
	public static void main(String[] args) { // 'main' 메소드는 항상 'public static void'로 선언된다.
		
		// 1. int형 배열 선언 및 초기화
		int[] ref = {100, 800, 1000}; // 'ref'라는 이름의 int형 배열을 만들고 값들을 초기화한다.
									 // 'ref' 변수에는 이 배열이 저장된 메모리의 '★주소(참조값)★'가 담겨 있다.
		
		// 2. `ReferenceParamEx02` 객체 생성
		// `increase` 메소드가 `static`이 아니라서, 이 클래스의 객체를 먼저 만들어야 호출 가능하다.
		ReferenceParamEx02 rp = new ReferenceParamEx02(); // 'ReferenceParamEx02' 타입의 'rp'라는 객체를 생성한다.
		
		// 3. `increase` 메소드 호출 (핵심!)
		// `rp.increase(ref);` → `ref` 배열 (정확히는 배열의 주소)을 `increase` 메소드로 넘겨준다.
		// `increase` 메소드의 매개변수 `n`이 `ref`와 똑같은 배열을 가리키게 된다. (주소 복사!)
		rp.increase(ref);
		
		// 4. `increase()` 메소드 호출 후 `main` 메소드에서 배열 값 확인
		System.out.println("--- increase() 메소드 호출 후 ref 배열 값 ---");
		for (int i = 0; i < ref.length; i++) { // 'ref' 배열의 각 요소 값을 출력한다.
			// `increase` 메소드에서 `ref` 배열의 각 요소가 1씩 증가했으므로,
			// 여기서는 **★변경된 값 (101, 801, 1001)이 출력★**될 거다!
			System.out.println("ref[" + i + "]: " + ref[i]);
		}
	}
}
