package com.objectex; // 이 코드는 'com.objectex' 패키지에 있음.

public class VariableEx { // 'VariableEx'라는 클래스.

	// 1. ★★★ 가변 인자(Variable Arguments) 받는 메서드: `argsTest` ★★★
	// 'public'이라 다른 클래스에서도 호출 가능.
	// 'void'라 반환값 없음.
	// 'String ...n' ← 이게 바로 ★가변 인자 선언★ 부분임.
	// 뜻: "String 타입 인자를 ★0개 이상★ 받을 수 있다!"
	// 그리고 이 인자들은 메서드 안에서 'String[] n'이라는 ★배열★처럼 사용됨.
    
	public void argsTest(String ...n) { // `...`: 자바가 알아서 배열로 만들어줌.
		
		for (int i = 0; i < n.length; i++) { // `n.length`는 가변 인자로 받은 요소들의 개수(배열 길이)
			System.out.println("n[" + i + "]:" + n[i]); // 배열의 인덱스랑 값 출력.
		}
		System.out.println("======================"); // 구분선.
	}

	// 2. 메인 메서드: 프로그램 시작점
	public static void main(String[] args) {
		
		// `argsTest` 메서드가 `static`이 아니라서, `VariableEx` 객체를 먼저 만들어야 호출할 수 있음.
		VariableEx ve = new VariableEx();

		// 3. `argsTest` 메서드 호출 예시 (가변 인자의 위엄!)

		// 3-1. 인자 2개 전달
		ve.argsTest("java", "DataBase"); // "java", "DataBase" 두 개 넘겨줌.
										 // `argsTest` 안에서 `String[] n` 배열의 n[0]은 "java", n[1]은 "DataBase" 됨.

		// 3-2. 인자 4개 전달
		ve.argsTest("100", "200", "300", "400"); // 4개 문자열 넘겨줌.
												 // `argsTest` 안에서 n[0]~n[3]으로 저장됨.

		// 3-3. 인자 없이 호출 (★이것도 가능함!)
		ve.argsTest(); // 인자 0개 넘겨줌. `n.length`는 0이 돼서 반복문은 안 돌고 바로 구분선 출력됨.
					   // 이게 가변 인자의 장점 중 하나임!

		// 3-4. 인자 여러 개 호출 (더 넣어 봐라 이기!)
		ve.argsTest("첫째", "둘째", "셋째", "넷째", "다섯째", "여섯째", "일곱째");
	}
}
