package com.excp; // 이 코드가 속한 패키지 이름이다.

/*
  ExceptionEx05 클래스: **'예외를 다시 던지는(Re-throwing Exception)' 개념을 보여주는 예제다!**
 
  핵심:
  - **`RuntimeException` vs `Exception` (존나 중요!):**
  - `RuntimeException` (실행 예외): 컴파일러가 잡아주지 않는 예외다! (예: 0으로 나누기, 널 포인터)
  -> 개발자가 조심해서 안 터지게 해야 한다! (코드 실수로 주로 발생!)
  - `Exception` (일반 예외/검사 예외): 컴파일러가 잡아주는 예외다! (예: 파일 없는데 열기, 네트워크 오류)
  -> 반드시 `try-catch`로 잡거나, `throws`로 메소드 선언부에 명시해서 던져줘야 한다! (안 그러면 컴파일 에러!)
 
  - **`throw` 키워드:** 프로그래머가 고의로 예외를 발생시킬 때 쓴다!
  - **`try-catch` 블록:** 예외를 잡아서 처리하는 기본적인 문법이다.
  - **'예외 다시 던지기(Re-throwing Exception)' 개념:**
  -> `catch` 블록에서 예외를 잡았지만, 자기가 완전히 처리하지 못하고
  '야, 이 예외는 내 윗대가리(호출한 놈)가 처리해야 해!' 하면서 예외를 다시 던지는 거다!
  -> 보통 잡은 예외보다 **더 상위 타입의 예외를 새로 만들어서 던지거나,**
  **그냥 잡았던 예외를 그대로 다시 던질 수도 있다.**
 
  ★★★ 니 코드의 문제점 및 수정 사항: ★★★
  1. `catch` 괄호에 예외 타입이 없어서 문법 오류였다! -> `catch (RuntimeException e)`로 수정.
  2. `catch` 블록 안에서 `new Exception()`을 `throw` 할 경우, `Exception`은 '일반 예외'라서
  이걸 던지는 메소드(`main`)에 `throws Exception`을 붙여줘야 한다! (안 그러면 컴파일 에러!)
  -> 그래서 `main` 메소드 선언부에 `throws Exception`을 추가했다.
 */

public class ExceptionEx05 {

	// ★★★ 존나 중요! 'main' 메소드에서 'Exception'을 던질 수 있다고 선언했다! ★★★
	// `catch` 블록에서 'Exception'을 다시 던질 수도 있기 때문에,
	// 이걸 호출한 JVM에게 '나 이딴 예외 던질 수 있다!'고 미리 경고하는 거다.
	public static void main(String[] args) throws Exception { 
		
		System.out.println("--- 프로그램 시작 ---");
		System.out.println("1단계: `try` 블록 진입");

		try { // ★★★ 예외 발생 가능성이 있는 코드 블록 시작! ★★★
			System.out.println("2단계: `RuntimeException` 발생 시도");
			// 'RuntimeException'은 'unchecked exception'이라 `throws` 선언 안 해도 컴파일 에러 안 난다.
			throw new RuntimeException("고의로 런타임 예외를 발생시켰다"); 
			// 이 코드가 실행되는 순간, `try` 블록의 나머지 코드는 건너뛰고 바로 `catch` 블록으로 점프한다!
			// System.out.println("3단계: `RuntimeException` 발생 후 남은 코드 (실행 안 됨)"); // 실행 안 됨!

		} catch (RuntimeException re) { // ★★★ `RuntimeException`을 잡는 블록! ★★★
			System.out.println("4단계: `catch` 블록 안 - `RuntimeException` 잡았다!");
			// `re.getMessage()`는 예외 객체에 저장된 메시지를 가져온다.
			System.out.println("잡은 런타임 예외 메시지: " + re.getMessage()); 
			
			// ★★★ 여기서 새로운 '일반 예외(Exception)'를 만들어서 다시 던진다! ★★★
			// `Exception`은 'checked exception'이라, 이 메소드(`main`)가 이걸 던지려면
			// 반드시 `main` 메소드 선언부에 `throws Exception`을 명시해야 한다! (안 그러면 컴파일 에러난다!)
			System.out.println("5단계: 새로운 일반 예외를 만들어서 다시 던진다");
			throw new Exception("런타임 예외를 받아서 새로운 일반 예외로 다시 던진다!"); 

		} finally { // ★★★ `try`나 `catch` 블록 실행 여부와 상관없이 무조건 실행되는 블록! ★★★
		    // 위 `catch`에서 예외를 다시 던졌기 때문에, 이 `finally` 블록은 실행되지만
		    // `main` 메소드 밖으로 예외가 최종적으로 던져지기 전에 실행된다.
		    System.out.println("6단계: `finally` 블록 - 뒷정리한다");
		}

		// ★★★ 이 코드는 `catch` 블록에서 예외를 다시 던졌기 때문에 절대 실행되지 않는다! ★★★
		// 예외가 `main` 메소드 밖으로 던져지면서 프로그램이 비정상 종료되거나,
		// 이 `main` 메소드를 호출한 JVM이 그 예외를 처리하게 된다.
		// System.out.println("7단계: 예외 처리 후 프로그램 계속 진행 (실행 안 됨)");
		System.out.println("--- 프로그램 종료 (도달하지 않음) ---");
	}

}
