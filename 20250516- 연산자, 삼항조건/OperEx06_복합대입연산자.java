package com.operex; // 이 코드가 속한 폴더(패키지)를 나타내요. (패키지는 관련된 클래스들을 모아두는 일종의 폴더입니다.)

/* 복합대입연산자, 복합 연산자, 배정연산자 // 이 연산자들을 부르는 다양한 이름들이에요.
+=, -=, ....  a= a+b => a+=b // +=, -= 등이 있고, 'a = a + b'를 'a += b'처럼 줄여 쓸 수 있다는 예시입니다.
*/ 

public class OperEx06 { // 'OperEx06'이라는 이름의 프로그램을 시작하는 클래스입니다.

	public static void main(String[] args) { // 프로그램이 실제로 시작되는 부분이에요. 자바 프로그램은 항상 이 'main' 메서드부터 실행됩니다.
			
			int a = 10; // 'a'라는 이름의 'int' (정수) 타입 변수를 만들고 '10'이라는 값을 넣어줬어요. 이 값은 연산에 계속 사용될 기준값이 됩니다.
			int result = 0; // 'result'라는 이름의 'int' 타입 변수를 만들고 '0'으로 초기화했어요. 이 변수에 연산 결과가 계속 누적될 거예요.
			
			// 1. += 연산자
			result += a; // 이 코드는 'result = result + a;'와 같아요.
			             // 현재 result (0) + a (10) = 10. 이 10을 다시 result에 저장합니다.
			System.out.println("result: " + result); // 'result' 변수에 저장된 값을 화면에 출력해요.
			// 예상 출력: 10
			
			// 2. *= 연산자
			result *= a; // 이 코드는 'result = result * a;'와 같아요.
			             // 현재 result (10) * a (10) = 100. 이 100을 다시 result에 저장합니다.
			System.out.println("result: " + result); // 'result' 변수에 저장된 값을 화면에 출력해요.
			// 예상 출력: 100
		
			// 3. -= 연산자
			result -= a; // 이 코드는 'result = result - a;'와 같아요.
			             // 현재 result (100) - a (10) = 90. 이 90을 다시 result에 저장합니다.
			System.out.println("result: " + result); // 'result' 변수에 저장된 값을 화면에 출력해요.
			// 예상 출력: 90
		
			// 4. /= 연산자
			result /= a; // 이 코드는 'result = result / a;'와 같아요.
			             // 현재 result (90) / a (10) = 9. 이 9를 다시 result에 저장합니다.
			System.out.println("result: " + result); // 'result' 변수에 저장된 값을 화면에 출력해요.
			// 예상 출력: 9
		
			// 5. %= 연산자
			result %= a; // 이 코드는 'result = result % a;'와 같아요.
			             // 현재 result (9) % a (10) = 9 (9를 10으로 나눈 나머지는 9입니다). 이 9를 다시 result에 저장합니다.
			System.out.println("result: " + result); // 'result' 변수에 저장된 값을 화면에 출력해요.
			// 예상 출력: 9
	}
}
