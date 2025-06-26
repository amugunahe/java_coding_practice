package com.excp; // 이 코드가 속한 패키지 이름이다. (예외 처리 예제들을 모아두는 곳이다!)

/*
  ExceptionEx03 클래스: **'0으로 나누기' 예외(ArithmeticException)를 존나게 자세히 처리하는 예제다!**
 
  핵심:
  - **`try-catch` 블록의 실행 흐름 (존나 중요!):**
  - `try` 블록 안에서 예외가 터지면, 그 순간 `try` 블록의 나머지 코드는 실행 안 된다!
  - 터진 예외를 잡을 수 있는 **가장 적절한 `catch` 블록으로 바로 점프한다!**
  
  - **`ArithmeticException`:** 숫자를 0으로 나눴을 때 발생하는 예외다. (산술적인 문제!)
  
  - **다중 `catch` 블록:** 하나의 `try` 블록 뒤에 여러 개의 `catch` 블록을 붙일 수 있다.
  - 이 경우, **가장 구체적인 예외(`ArithmeticException`)부터 먼저 잡고,**
  그 다음에 **더 일반적인 예외(`Exception`)를 잡도록** 순서를 정해야 한다! (안 그러면 컴파일 에러난다)
  
  - **`instanceof` 연산자:** 객체가 특정 클래스나 인터페이스의 인스턴스인지 확인할 때 쓴다.
  여기서는 `ae instanceof ArithmeticException`이 `true`를 반환하는지 확인하는 거다. (당연히 `true`겠지?!)
  
  - **`e.printStackTrace()`:** 예외가 어디서, 왜 발생했는지 존나게 자세히! 출력해준다. (디버깅할 때 존나 유용!)
  
  - **`e.getMessage()`:** 예외 클래스 안에 저장된 간략한 오류 메시지만 가져온다.
 */

public class ExceptionEx03 {

	public static void main(String[] args) {
		System.out.println(1); // 1 출력
		System.out.println(2); // 2 출력

		try { // ★★★ 예외 발생 가능성이 있는 코드 블록 시작! ★★★
			System.out.println(3); // 3 출력

			// ★★★ 존나 중요! 여기서 '0으로 나누기' 예외(`ArithmeticException`)가 발생한다! ★★★
			// `System.out.println(0/0);`는 컴파일 오류가 아니라 런타임 오류(예외)다!
			System.out.println(0/0); 

			// ★★★ 이 코드는 실행되지 않는다! ★★★
			// 위에서 예외가 터졌기 때문에, `try` 블록의 남은 코드는 건너뛰고 바로 `catch` 블록으로 점프한다!
			System.out.println(4); 

		} catch(ArithmeticException ae) { // ★★★ 'ArithmeticException' 예외를 잡는 블록! ★★★
			// 위 `try` 블록에서 `0/0` 때문에 `ArithmeticException`이 터졌으므로, 이 `catch` 블록이 실행된다!
			System.out.println("0으로 나누는 산술 예외가 발생했다"); // 어떤 예외인지 메시지 출력.

			// 'ae instanceof ArithmeticException'은 'ae' 객체가 'ArithmeticException' 타입의 인스턴스인지 확인한다.
			// 당연히 `true`가 나올 거다. 이 조건문은 항상 `true`를 반환한다.
			if(ae instanceof ArithmeticException) {
				// if 문 안에 `System.out.println("true");`가 없어서 이 라인은 실행되지 않는다!
				// (니 코드 원본에서 `System.out.println("true");`가 if 문 밖에 있었기 때문)
			} 
			System.out.println("true"); // 'if'문 블록 밖에 있으므로, 'ArithmeticException'이 잡히면 무조건 실행된다.
			                            // 즉, 항상 "true"가 출력된다.
		
		} catch(Exception e) { // ★★★ 모든 종류의 예외를 잡는 일반적인 'Exception' 블록! ★★★
			// 이 블록은 위 `ArithmeticException`이 잡혔으므로 **실행되지 않는다.**
			// 만약 `try` 블록에서 `ArithmeticException`이 아닌 다른 종류의 예외(예: `NullPointerException`)가 터졌다면
			// 이 `catch(Exception e)` 블록이 그 예외를 잡을 것이다.
			
			// e.printStackTrace(); // 주석을 풀면 예외 발생 당시의 자세한 호출 스택 정보가 콘솔에 출력된다. (디버깅용!)
			
			/*
			  `e.printStackTrace();`
			  - 예외 발생 당시의 '메소드 호출 스택' 정보(어떤 메소드에서 어떤 메소드를 호출하다가 예외가 터졌는지)와
			     예외 메시지를 화면에 존나게 자세히 출력한다!
			  
			  `e.getMessage();`
			    	- 발생한 예외 클래스의 인스턴스에 저장된 '간략한' 예외 메시지만 가져온다. (예: "/ by zero")
			 */
			
			e.getMessage(); // 예외 메시지를 가져오지만, 이 메소드 호출 자체만으로는 콘솔에 아무것도 출력되지 않는다.
			// System.out.println(5); // 이 코드는 이 catch 블록이 실행될 때만 실행되므로, 여기서는 실행되지 않는다.
		} // 'try-catch' 블록 끝

		System.out.println(6); // ★★★ 예외 처리 후 마지막 코드! ★★★
		                       // 예외가 발생해서 처리됐기 때문에 프로그램이 뻗지 않고, 이 코드가 정상적으로 실행된다!
	}
}
