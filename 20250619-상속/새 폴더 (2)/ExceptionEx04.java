package com.excp; // 이 코드가 속한 패키지 이름이다.

/*
 * 예외처리 (Exception Handling):
 *    정의: 프로그램 실행 시 발생할 수 있는 '예외적인 상황(오류)'에 대비해서 코드를 미리 작성하는 것이다.
 *    목적: 프로그램이 갑자기 뻗는(비정상 종료) 것을 막고, 최대한 정상적인 실행 상태를 유지하는 것이다.
 *
 * `throw` 키워드: **프로그래머가 고의로 예외를 발생시킬 때 사용한다!**
 *  
 *   1. 먼저 `new` 연산자를 이용해서 발생시키려는 예외 클래스의 객체를 만든다.
 *       예: `Exception e = new Exception("고의로 예외를 발생시켰다!");`
 *   2. `throw` 키워드를 이용해서 예외 객체를 던져버린다!
 *       예: `throw e;` 또는 `throw new Exception("고의로 예외를 발생시켰다!");`
 *       이 순간 `try` 블록의 남은 코드는 실행 안 되고, 바로 `catch` 블록으로 점프한다!
 */

public class ExceptionEx04 {

	public static void main(String[] args) {
		
		System.out.println("--- 프로그램 시작 ---");
		System.out.println("1단계: 예외 발생 시도");

		try { // ★★★ 예외가 발생할 가능성이 있는 코드 블록 시작! ★★★
			System.out.println("2단계: `try` 블록 안");
			
			// 1. `Exception` 객체를 만든다. 이 객체에 예외 메시지를 담는다.
			Exception e = new Exception("고의로 예외를 발생시켰다, 씨발!!"); // ★★★ 여기에 세미콜론(;) 추가! ★★★
			
			// 2. `throw` 키워드를 사용해서 위에서 만든 'e' 예외 객체를 존나게 던져버린다!
			// 이 코드가 실행되는 순간, `try` 블록의 나머지 코드는 건너뛰고 바로 `catch` 블록으로 점프한다!
			throw e; 
			
			// 아래 코드는 `throw e;` 때문에 절대 실행되지 않는다!
			// System.out.println("3단계: 예외 발생 후 `try` 블록의 남은 코드"); 

		} catch (Exception e) { // ★★★ `try` 블록에서 발생한 `Exception` 타입의 예외를 여기서 잡는다! ★★★
			System.out.println("4단계: `catch` 블록 안");
			// 'e.getMessage()'는 예외 객체에 저장된 메시지("고의로 예외를 발생시켰다, 씨발!!")를 가져온다.
			System.out.println("잡은 예외 메시지: " + e.getMessage()); 
			// 'e.printStackTrace()'는 예외가 어디서, 왜 발생했는지 존나게 자세히 출력해준다. (디버깅할 때 존나 유용!)
			// e.printStackTrace(); 
		} // 'try-catch' 블록 끝 (불필요한 코드 및 중괄호 오류 수정 완료!)

		System.out.println("5단계: 예외 처리 후 프로그램 계속 진행");
		System.out.println("--- 프로그램 종료 ---");
	}

}