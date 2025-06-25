package com.switchex;

/* 문] 사용자로부터 두 정수와 연산자를 입력받아 해당 연산을 처리하는
프로그램을 구현하시오
출력 결과
첫번째 정수입력: 10
연산자 입력{+ - / *}: +
두번째 정수입력: 14

10+ 14 = 24
*/

import java.util.*; // Scanner 클래스를 쓰기 위해 import 하는 거. 이거 없으면 입력 못 받음.

public class SwitchEx02 { // SwitchEx02 이라는 클래스 선언. 자바는 모든 코드를 클래스 안에 넣어야 함.

	public static void main(String[] args) { // 프로그램 시작점. 무조건 여기부터 실행됨.

		Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위한 객체 생성. 키보드 입력은 얘로 받는다 생각해라.

		int a, b;   // 정수형 변수 2개 선언. 첫 번째, 두 번째 숫자를 저장할 거임.
		char op;    // 문자형 변수 1개 선언. 연산자(+, -, *, /)를 저장할 거임.

		System.out.print("첫번째 정수: "); // "첫번째 정수: " 출력. 사용자한테 뭐 입력할지 알려주는 글자임.
		a = sc.nextInt(); // 사용자가 입력한 정수를 변수 'a'에 저장.

		System.out.print("연산자 입력{+ - / *}: "); // "연산자 입력: " 출력. 입력 가능한 연산자도 알려줌.
		op = sc.next().charAt(0); // 사용자가 입력한 문자열(예: "+", "하이")에서 첫 글자만 뽑아서 'op'에 저장.

		System.out.print("두번째 정수: "); // "두번째 정수: " 출력.
		b = sc.nextInt(); // 사용자가 입력한 정수를 변수 'b'에 저장.

		// switch-case 문을 이용한 연산 처리: 'op' 변수 값에 따라 다른 코드를 실행함.
		switch (op) {
			case '+': // 만약 'op'가 '+'면 이 아래 코드를 실행.
				System.out.printf("%d + %d = %d%n", a, b, a + b); // 덧셈 결과 출력. %d는 정수, %n은 줄바꿈.
				break; // 여기서 멈춰서 switch 문 밖으로 나감. 이거 없으면 아래 case까지 다 실행됨 (주의!).
			case '-': // 만약 'op'가 '-'면 이 아래 코드를 실행.
				System.out.printf("%d - %d = %d%n", a, b, a - b); // 뺄셈 결과 출력.
				break; // 여기서 멈춰서 switch 문 밖으로 나감.
			case '*': // 만약 'op'가 '*'면 이 아래 코드를 실행.
				System.out.printf("%d * %d = %d%n", a, b, a * b); // 곱셈 결과 출력.
				break; // 여기서 멈춰서 switch 문 밖으로 나감.
			case '/': // 만약 'op'가 '/'면 이 아래 코드를 실행.
				if (b == 0) { // 만약 두 번째 숫자 'b'가 0이면
					System.out.println("0으로는 나눌 수 없습니다.%n"); // 0으로 못 나눈다고 출력.
				} else { // 그게 아니면 (b가 0이 아니면)
					System.out.printf("%d / %d = %d%n", a, b, a / b); // 나눗셈 결과 출력.
				}
				break; // 여기서 멈춰서 switch 문 밖으로 나감.
			default: // 위에 어떤 case에도 해당하지 않는다면 (이상한 연산자 입력 시)
				System.out.println("잘못된 연산자입니다.%n"); // 잘못된 연산자라고 출력.
				break; // 여기서 멈춰서 switch 문 밖으로 나감.
		}

		sc.close(); // Scanner 객체 사용 끝났으니까 닫아주는 거. 리소스 낭비 막아줌. (중요!)
	}
}
