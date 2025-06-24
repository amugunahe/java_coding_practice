package com.objectex; // 이 코드는 'com.objectex' 패키지에 있음.

/*
  ★★★ 메소드(Method) 형식 ★★★
  접근제한자 반환타입 메소드이름(자료형 변수명, ...) // <- ★선언부★ (메서드가 어떤 놈인지 정의)
  { // <- ★구현부★ (메서드가 실제로 뭘 할지 코드 작성)
  메소드 호출 시 수행되는 코드
  }
 */

public class MethodClass02 { // 'MethodClass02'라는 클래스.

	// 1. 숫자 두 개 더하는 메서드: `add`
	// 선언부: `public` (어디서든 접근 가능), `int` (int형 값 반환), `add` (메서드 이름), `(int x, int y)` (int형 x, y를 매개변수로 받음)
   
	public int add(int x, int y) { // 선언부
		int result; // 'result'는 이 메서드 안에서만 쓰이는 '★지역 변수★'.
					// 메서드 실행될 때 생겼다가 끝나면 사라짐.

		return result = x + y; // 구현부.
							  // 1. `x + y` 계산해서 `result`에 넣고
							  // 2. 그 `result` 값을 메서드 호출한 곳으로 ★`return` (반환)★함.
							  // 반환 타입이 `int`니까 `int`형 값을 돌려줘야 함.
	}

	// 2. 이름 받아서 처리하는 메서드 (지금은 비어있음): `name`
	public String name(String na) {
		return ""; // 지금은 아무 내용 없이 빈 문자열 반환. (나중에 기능 추가 가능)
	}

	// 이 `int i;`는 클래스의 멤버 변수임. 아래 `print99dan()` 메서드 안의 `i`랑은 ★완전히 다른 변수★.
	int i;

	/*
	  ★★★ `void` 란? ★★★
	  - "아무것도 없음"을 뜻함.
	  - 메서드가 ★반환값 없을 때★ 반환 타입으로 `void`를 씀.
	 */

	// 3. 구구단 출력하는 메서드: `print99dan`
	// 선언부: `void` (반환값 없음), `print99dan` (메서드 이름), `()` (매개변수 없음)
	void print99dan() { // 접근 제한자 생략됨 = `default` 접근 제한자. 같은 패키지 안에서만 접근 가능.
		for (int i = 1; i <= 9; i++) { // 첫 번째 for문: 1단부터 9단까지 (여기서 `i`는 지역 변수임!)
			for (int j = 2; j <= 9; j++) { // 두 번째 for문: 각 단의 2부터 9까지 곱셈
				System.out.print(j + "*" + i + "=" + (j * i) + " ");
			}
			System.out.println(); // 한 단 끝나면 줄바꿈.
		}
		return; // `void` 메서드에서는 `return;` 써도 되고 생략해도 됨. 메서드 실행 종료 의미.
	}

	/*
	  ★★★ `return` 이란? ★★★
	  - 메서드 수행 결과를 ★호출한 곳으로 돌려주는 역할★.
	  - 반환하는 값의 타입은 선언부의 반환 타입이랑 같거나 자동으로 형변환 가능해야 함.
	 */

	/*
	  ★★★ 지역 변수 (Local variable) 특징 ★★★
	  - 메서드 내에 선언된 변수는 그 메서드 안에서만 쓸 수 있음.
	  - 그래서 서로 다른 메서드라면 같은 이름의 변수를 선언해도 상관 없음. (예: `add`의 `result`랑 `print99dan`의 `i`)
	 */

	/*
	 * ★★★ 인자 (Argument) vs 매개변수 (Parameter) ★★★
	 * - 메서드 호출할 때 괄호() 안에 넘겨주는 값들 → **인자 (Arguments)**
	 * - 메서드 선언부에 괄호() 안에 정의된 변수들 → **매개변수 (Parameters)**
	 * - `add(10, 2)`: `10`, `2`는 인자.
	 * - `public int add(int x, int y)`: `int x`, `int y`는 매개변수.
	 * - 인자로 넘겨준 값이 매개변수에 복사돼서 메서드 안에서 사용됨.
	 * - 인자의 개수, 순서, 타입은 매개변수랑 일치해야 함.
	 */

	// ★★★ 프로그램 시작점 (메인 메서드) ★★★
	public static void main(String[] args) {

		// 'static'이 안 붙은 메서드(`add`, `name`, `print99dan`)를 쓰려면
		// 먼저 이 클래스의 객체를 만들어야 함.
		MethodClass02 m = new MethodClass02();

		// 1. `print99dan` 메서드 호출
		m.print99dan(); // m 객체의 `print99dan()` 호출. 반환값 없어서 그냥 호출만 함. 구구단 출력될 거임.

		// 2. `add` 메서드 호출
		System.out.println(m.add(2, 3)); // m 객체의 `add(2, 3)` 호출.
										// `2`와 `3`이 인자로 넘어가서 `add` 메서드의 `x`와 `y`에 대입됨.
										// `add` 메서드는 2+3=5를 계산해서 `5`를 반환함.
										// `System.out.println()`이 그 반환된 값 `5`를 화면에 출력함.
	}
}
