package com.excp; // 이 코드가 속한 패키지 이름이다.

public class ExceptionEX06 { // 'ExceptionEX06'이라는 이름의 공개(public) 클래스를 정의한다.

	// ★★★ 메인 메소드: 프로그램의 시작점! 그리고 'Exception'을 던질 수 있다고 선언했다! ★★★
	// 'method1()'이 'Exception'을 던질 수 있으니, 그걸 여기서 받아 처리하거나 다시 던져야 하는데,
	// 여기서는 그냥 '나도 이 예외 못 잡으니 내 윗대가리(JVM)한테 던져버린다!'라고 선언하는 거다.
	public static void main(String[] args) throws Exception { 
		System.out.println("--- main 메소드 시작 ---");
		method1(); // 'method1()'을 호출한다.
		System.out.println("--- main 메소드 종료 (이 메시지는 예외가 처리되지 않으면 안 나온다!) ---");
	}

	// ★★★ `method1()`: 'method2()'가 던지는 'Exception'을 자기도 다시 던진다! ★★★
	static void method1() throws Exception { // 'method2()'가 던지는 'Exception' 때문에 여기에 `throws Exception`이 붙어야 한다!
		System.out.println("--- method1() 시작 ---");
		method2(); // 'method2()'를 호출한다.
		System.out.println("--- method1() 종료 (이 메시지는 예외가 처리되지 않으면 안 나온다!) ---");
	}

	// ★★★ `method2()`: 고의로 'Exception'을 던진다! (예외 발생 지점!) ★★★
	static void method2() throws Exception { // 이 메소드 안에서 'Exception'을 던지니까, 여기에 `throws Exception`이 붙어야 한다!
		System.out.println("--- method2() 시작 ---");
		// ★★★ 존나 중요! 여기서 'Exception' 예외가 발생한다! ★★★
		throw new Exception("method2에서 고의로 예외 발생시켰다, 씨발!"); 
		// 이 코드가 실행되는 순간, `method2()`는 더 이상 실행되지 않고,
		// 발생한 예외는 이 메소드를 호출한 `method1()`으로 존나게 던져진다!
		// System.out.println("--- method2() 종료 (이 메시지는 절대 안 나온다!) ---"); // 이 코드는 실행 안 됨!
	}

	/*
	 * 니가 작성한 주석을 보면서 실행 흐름을 다시 한번 정리해 보자, 씨발!
	 *  
	 *  1. 예외가 발생했을 때, 현재 '호출 스택'에는 몇 개의 메소드가 쌓여있을까?
	 *     - `main()`이 `method1()`을 호출했고, `method1()`이 `method2()`를 호출했다.
	 *     - 그래서 예외가 터지는 순간 호출 스택에는 **`main() -> method1() -> method2()` 이렇게 3개의 메소드**가 존나게 쌓여있다! (니 설명 존나 정확!)
	 *
	 *  2. 예외가 발생한 곳은 어디냐?
	 *     - 스택 트레이스를 보면 가장 위에 나오는 곳이다. 여기서는 **`method2()`가 예외를 직접 발생시켰다!** (니 설명 존나 정확!)
	 *  
	 *  3. 누가 누구를 호출했는지?
	 *     - `main` 메소드가 `method1()`을 호출했고,
	 *     - `method1()`은 `method2()`를 호출했다. (니 설명도 존나 정확하다, 씨발!)
	 *
	 * 최종적으로, `method2()`에서 던져진 예외는 `method1()`으로, 다시 `method1()`에서 `main()`으로,
	 * 그리고 `main()`에서도 처리하지 않고 `throws Exception`으로 던져버렸기 때문에,
	 * **JVM(자바 가상 머신)이 이 예외를 최종적으로 받아서 프로그램을 비정상 종료시킬 거다.**
	 * (이전 `ExceptionEx05_Fixed` Canvas 코드에서 본 것처럼 `Exception in thread "main"...` 메시지가 콘솔에 뜰 거다!)
	 */
}