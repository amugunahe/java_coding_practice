package com.objectex; // 이 코드는 'com.objectex' 패키지에 있음.

public class ReferenceParamEx02 { // 'ReferenceParamEx02'라는 클래스.

	// 1. 배열의 각 요소를 1씩 증가시키는 메서드: `increase`
	// 'public'이라 다른 클래스에서도 호출 가능.
	// 'void'라 반환값 없음.
	// 'int[] n' ← 여기가 바로 ★참조형 매개변수★ 부분임.
	// 뜻: "int 배열의 ★주소★를 복사해서 받을 거야!"
    
	public void increase(int[] n) { // 매개변수 `n`은 `main` 메서드의 `ref`와 ★같은 배열을 가리킴★.
		for (int i = 0; i < n.length; i++) { // 배열 `n`의 길이만큼 반복.
			n[i]++; // `n[i]` 값 1 증가시킴.
					// ★개중요★ 여기서 값을 바꾸면, `main` 메서드의 `ref` 배열 값이 ★직접 바뀜★.
					// 왜? `n`이랑 `ref`가 같은 메모리 주소를 보고 있으니까!
		}
	}
	
	// 2. 메인 메서드: 프로그램 시작점
	public static void main(String[] args) {
		
		// 1. int형 배열 선언 및 초기화
		int[] ref = {100, 800, 1000}; // `ref` 배열 만들고 값 초기화.
									 // `ref` 변수엔 이 배열이 저장된 메모리 '★주소★'가 담겨 있음.
		
		// 2. `ReferenceParamEx02` 객체 생성
		// `increase` 메서드가 `static`이 아니라서, 이 클래스 객체를 먼저 만들어야 호출 가능함.
		ReferenceParamEx02 rp = new ReferenceParamEx02();
		
		// 3. `increase` 메서드 호출
		// `rp.increase(ref);` → `ref` 배열 (정확히는 배열의 주소)을 `increase` 메서드로 넘겨줌.
		// `increase` 메서드의 매개변수 `n`이 `ref`와 똑같은 배열을 가리키게 됨.
		rp.increase(ref);
		
		// 4. `increase` 메서드 호출 후 배열 값 확인
		for (int i = 0; i < ref.length; i++) { // `ref` 배열 각 요소 값 출력.
			// `increase` 메서드에서 `ref` 배열의 각 요소가 1씩 증가했으므로,
			// 여기서는 ★변경된 값 (101, 801, 1001)이 출력★될 거임.
			System.out.println("ref[" + i + "]:" + ref[i]);
		}
	}
}
