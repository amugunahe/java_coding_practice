package com.operex; // 야, 이 코드가 여기 산다. 주소 박아놨으니까 딴 데서 헤매지 마라.

/* 복합대입연산자, 복합 연산자, 배정연산자 // 존나 귀찮게 길게 쓸 거 한 방에 줄여주는 연산자다.
+=, -=, ....  a = a + b => a += b // 이런 식으로 줄인다는 예시임.
*/

public class OperEx06 { // 야, OperEx06 이름으로 프로그램 시작한다. 이 파일 이름이랑 똑같으니까 틀리면 뒤진다.

	public static void main(String[] args) { // 여기가 진짜 시작점이다. 무조건 여기부터 실행된다고 보면 됨.

		int a = 10; // a라는 정수(int) 변수에 10 박아 넣었다. 얘가 기준값이다.
		int result = 0; // result라는 정수(int) 변수에 0 깔아줬다. 여기에 계산 결과 계속 쌓인다.

		// 1. += 연산자
		result += a; // result = result + a; 이거랑 똑같다.
					 // (0) + (10) = 10. 이 10이 result에 다시 들어간다.
		System.out.println("result: " + result); // result에 뭐 들어있는지 화면에 보여준다. (지금 10)

		// 2. *= 연산자
		result *= a; // result = result * a; 이거랑 똑같다.
					 // (10) * (10) = 100. 이 100이 result에 다시 들어간다.
		System.out.println("result: " + result); // result에 뭐 들어있는지 화면에 보여준다. (지금 100)

		// 3. -= 연산자
		result -= a; // result = result - a; 이거랑 똑같다.
					 // (100) - (10) = 90. 이 90이 result에 다시 들어간다.
		System.out.println("result: " + result); // result에 뭐 들어있는지 화면에 보여준다. (지금 90)

		// 4. /= 연산자
		result /= a; // result = result / a; 이거랑 똑같다.
					 // (90) / (10) = 9. 이 9가 result에 다시 들어간다.
		System.out.println("result: " + result); // result에 뭐 들어있는지 화면에 보여준다. (지금 9)

		// 5. %= 연산자
		result %= a; // result = result % a; 이거랑 똑같다.
					 // (9) % (10) = 9 (나머지 9임). 이 9가 result에 다시 들어간다.
		System.out.println("result: " + result); // result에 뭐 들어있는지 화면에 보여준다. (지금 9)
	}
}
