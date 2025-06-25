package com.objectex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  VariableEx 클래스: **자바의 '가변 인자(Variable Arguments)' 기능을 존나게 명확하게 보여주는 예제다!**
 
  핵심:
  - **가변 인자(Variable Arguments)란?**
  - 메소드를 호출할 때 매개변수의 개수를 **0개 이상으로 존나게 자유롭게 지정할 수 있게 해주는 기능이다!** (존나 유연함!)
  - **선언 방법:** `자료형 ...변수명` (예: `String ...n`) 이렇게 점 세 개(`...`)를 붙여서 선언한다.
  - **메소드 내부에서의 처리:** 가변 인자로 넘어온 값들은 메소드 안에서 **해당 자료형의 '배열'처럼** 사용된다!
  (예: `String ...n`으로 받으면 메소드 안에서 `String[] n` 배열처럼 `n.length`, `n[i]` 등으로 쓸 수 있다!)
  - **장점:**
  - 똑같은 기능을 하는 메소드를 매개변수 개수만 다르게 해서 여러 개 오버로딩할 필요가 없다! (코드 중복 제거!)
  - 인자를 0개 넘겨도 에러 없이 존나게 잘 돌아간다!
 */

public class VariableEx { // 'VariableEx'라는 이름의 공개(public) 클래스를 정의한다.

	// ★★★ 1. 가변 인자(Variable Arguments) 받는 메소드: `argsTest` ★★★
	// 'public'이라 다른 클래스에서도 호출 가능.
	// 'void'라 반환값 없음.
	// 'String ...n' ← 여기가 바로 **★가변 인자 선언★** 부분이다! (존나 중요!)
	// 뜻: "String 타입의 인자를 **★0개 이상★** 받을 수 있다!"
	// 그리고 이 인자들은 메소드 안에서 'String[] n'이라는 **★배열★**처럼 사용된다.
	public void argsTest(String ...n) { // `...`: 자바가 알아서 배열로 만들어준다.
		
		System.out.println("--- argsTest() 호출 (넘어온 인자 개수: " + n.length + ") ---");
		for (int i = 0; i < n.length; i++) { // `n.length`는 가변 인자로 받은 요소들의 개수(배열 길이)를 알려준다.
			System.out.println("n[" + i + "]: " + n[i]); // 배열의 인덱스랑 값 출력.
		}
		System.out.println("======================"); // 구분선.
	}

	// ★★★ 2. 메인 메소드: 프로그램의 시작점! ★★★
	public static void main(String[] args) { // 'main' 메소드는 항상 'public static void'로 선언된다.
		
		// `argsTest` 메소드가 `static`이 아니라서, `VariableEx` 클래스의 객체를 먼저 만들어야 호출할 수 있다.
		VariableEx ve = new VariableEx(); // 'VariableEx' 타입의 've'라는 객체를 생성한다.

		// ★★★ 3. `argsTest` 메소드 호출 예시 (가변 인자의 위엄!) ★★★

		// 3-1. 인자 2개 전달
		System.out.println(">> 인자 2개 전달:");
		ve.argsTest("java", "DataBase"); // "java", "DataBase" 두 개 문자열을 넘겨준다.
										 // `argsTest` 안에서 `String[] n` 배열의 n[0]은 "java", n[1]은 "DataBase"가 된다.

		// 3-2. 인자 4개 전달
		System.out.println(">> 인자 4개 전달:");
		ve.argsTest("100", "200", "300", "400"); // 4개 문자열을 넘겨준다.
												 // `argsTest` 안에서 n[0]부터 n[3]까지 저장된다.

		// 3-3. 인자 없이 호출 (★이것도 존나게 가능함!)
		System.out.println(">> 인자 0개 전달 (가능!):");
		ve.argsTest(); // 인자 0개를 넘겨준다. `n.length`는 0이 돼서 반복문은 안 돌고 바로 구분선만 출력된다.
					   // 이게 가변 인자의 장점 중 하나다!

		// 3-4. 인자 여러 개 호출 (더 넣어 봐라)
		System.out.println(">> 인자 존나게 많이 전달:");
		ve.argsTest("첫째", "둘째", "셋째", "넷째", "다섯째", "여섯째", "일곱째", "여덟째", "아홉째", "열째", "씨발!");
	}
}
