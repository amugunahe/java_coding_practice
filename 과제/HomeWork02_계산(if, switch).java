package com.test; // 이 코드 덩어리가 속한 폴더(패키지) 이름이다.

/*
  [문제 2] 간단한 사칙연산 계산기
  - 목표: 사칙연산자(+, -, *, /) 입력받아서 두 실수 계산.
  - 규칙:
  - 연산자: +, -, *, / 만 됨.
  - 숫자(피연산자): 무조건 소수점 있는 실수(double)로 처리.
  - ★★★ 존나 중요! 0으로 나누면 "0으로 나눌 수 없습니다." 출력. ★★★
 */

import java.util.*; // 사용자 입력받는 도구 'Scanner'가 들어있는 패키지 통째로 가져오기.

public class HomeWork02 {

	public static void main(String[] args) { // ★★★ 여.기.서.부.터. 프로그램 시작! ★★★

		Scanner sc = new Scanner(System.in); // 키보드 입력받을 준비!

		double num1, num2; // 첫 번째, 두 번째 숫자 (소수점 있는 실수) 저장용 변수.
		char cal;          // 연산 기호 (+, -, *, /) 저장용 변수.

		// 1. 첫 번째 숫자 입력받기
		System.out.print("첫번째 수 입력: ");
		num1 = sc.nextDouble(); // 사용자가 입력한 실수 'num1'에 저장.

		// 2. 연산 기호 입력받기
		System.out.print("연산기호 입력(+, -, *, /): ");
		cal = sc.next().charAt(0); // 사용자가 입력한 문자열 중 첫 글자만 가져와서 'cal'에 저장.

		// 3. 두 번째 숫자 입력받기
		System.out.print("두번째수 입력:");
		num2 = sc.nextDouble(); // 사용자가 입력한 실수 'num2'에 저장.

		// --- ★★★ 존나 중요! 연산 기호에 따라 계산 수행 (Switch 문) ★★★
		switch (cal) {
		case '+': // 연산 기호가 '+'면
			System.out.printf("%f + %f = %f%n", num1, num2, num1 + num2); // 덧셈 계산 후 출력.
			break; // 여기서 스위치문 탈출.

		case '-': // 연산 기호가 '-'면
			System.out.printf("%f - %f = %f%n", num1, num2, num1 - num2); // 뺄셈 계산 후 출력.
			break;

		case '*': // 연산 기호가 '*'면
			System.out.printf("%f * %f = %f%n", num1, num2, num1 * num2); // 곱셈 계산 후 출력.
			break;

		case '/': // 연산 기호가 '/'면 (★★★★ 나눗셈은 특히 주의 ★★★★)
			if (num2 == 0) { // ★★★ 존나 중요! 두 번째 숫자가 0이면 (0으로 나누기 시도!) ★★★
				System.out.println("0으로 나눌 수 없습니다."); // 에러 메시지 뱉어라!
			} else { // 0이 아니면 안전하게
				System.out.printf("%f / %f = %f%n", num1, num2, num1 / num2); // 나눗셈 계산 후 출력.
			}
			break; // 여기서 스위치문 탈출.

		default: // 위에 해당하는 연산 기호가 아니면 (잘못된 입력)
			System.out.println("잘못된 연산자입니다."); // 에러 메시지 뱉어라!
		}

		// 5. 사용했던 자원 깔끔하게 해제
		sc.close(); // 입력 도구 다 썼으면 시스템 자원 깔끔하게 닫아라.
	}
}
