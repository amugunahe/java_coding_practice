package com.switchex;

/* 문] 사용자로부터 두 정수와 연산자를 입력받아 해당 연산을 처리하는
프로그램을 구현하시오
출력 결과
첫번째 정수입력: 10
연산자 입력{+ - / *}: +
두번째 정수입력: 14

10+ 14 = 24
*/

import java.util.*;

public class SwitchEx02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위한 Scanner 객체 생성

		int a, b;   // 두 정수를 저장할 변수
		char op;    // 연산자를 저장할 변수

		System.out.print("첫번째 정수: "); // 첫 번째 정수 입력 요청
		a = sc.nextInt(); // 정수 입력받아 'a'에 저장

		System.out.print("연산자 입력{+ - / *}: "); // 연산자 입력 요청 (입력 가능한 연산자 안내)
		op = sc.next().charAt(0); // 사용자가 입력한 문자열의 첫 글자를 연산자로 저장

		System.out.print("두번째 정수: "); // 두 번째 정수 입력 요청
		b = sc.nextInt(); // 정수 입력받아 'b'에 저장

		// switch-case 문을 이용한 연산 처리
		switch (op) {
			case '+': // 연산자가 '+'일 경우
				System.out.printf("%d + %d = %d%n", a, b, a + b); // 덧셈 결과 출력
				break; // switch 문 종료
			case '-': // 연산자가 '-'일 경우
				System.out.printf("%d - %d = %d%n", a, b, a - b); // 뺄셈 결과 출력
				break; // switch 문 종료
			case '*': // 연산자가 '*'일 경우
				System.out.printf("%d * %d = %d%n", a, b, a * b); // 곱셈 결과 출력
				break; // switch 문 종료
			case '/': // 연산자가 '/'일 경우
				if (b == 0) { // !!! 중요: 두 번째 숫자가 0인지 체크 (0으로 나누는 것 방지)
					System.out.println("0으로는 나눌 수 없습니다.%n");
				} else {
					System.out.printf("%d / %d = %d%n", a, b, a / b); // 나눗셈 결과 출력
				}
				break; // switch 문 종료
			default: // 위의 어떤 case에도 해당하지 않을 경우
				System.out.println("잘못된 연산자입니다.%n"); // 잘못된 연산자 입력 메시지 출력
				break; // switch 문 종료
		}

		sc.close(); // 사용이 끝난 Scanner 객체 닫기 (리소스 해제)
	}
}
