package com.excp; // 이 코드가 속한 패키지 이름이다. (전에 본 `ExceptionEx01`이랑 같은 패키지!)

import java.util.Random; // 여기서는 안 쓰이는데, 원래는 난수(랜덤 숫자) 생성할 때 쓰는 놈이다. (지금 코드는 Math.random()을 쓴다!)

public class ExceptionEx02 {

	public static void main(String[] args) {
		int number = 100; // 나눠질 숫자다! 100으로 고정돼 있다.
		int result = 0;   // 계산 결과를 저장할 변수다.

		// for 문이 10번 존나게 반복된다!
		for(int i = 0; i < 10; i++) {
			try { // ★★★ 여기부터 '예외가 터질 수 있는 코드' 시작! ★★★
			    // `(int)(Math.random() * 10)`: 0.0부터 9.999... 사이의 숫자에 10을 곱하고 정수로 바꾼다.
			    // 즉, 0부터 9까지의 '랜덤 정수'가 된다!
			    // `number / (랜덤 정수)`: 100을 랜덤 정수로 나눈다.
			    // ★★★ 존나 중요! 만약 랜덤 정수가 '0'이 나오면 여기서 'ArithmeticException'이 터진다! ★★★
				result = number / (int)(Math.random() * 10);
				System.out.println(result); // 계산 결과 출력!
			} catch(ArithmeticException ae) { // ★★★ 'ArithmeticException'이라는 예외가 터지면 여기로 점프한다! ★★★
				// `ArithmeticException`은 '산술적인 계산' 관련 오류가 났을 때 터진다. 대표적인 게 '0으로 나누는 것'이다!
				// ae.printStackTrace(); // 이 주석을 풀면, 예외가 어디서, 왜 터졌는지 존나게 자세히 나온다. (디버깅할 때 존나 유용!)
				System.out.println("0으로 나눌 수 없다"); // 사용자에게 0으로 나눌 수 없다고 알려준다.
			} // 'try-catch' 블록 끝
			// 예외가 터지든 안 터지든, 프로그램은 여기서 멈추지 않고 계속 다음 반복을 실행한다! (이게 예외 처리의 핵심이다!)
		} // for 문 끝
	} // main 메소드 끝
}
