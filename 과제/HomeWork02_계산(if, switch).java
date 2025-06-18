package com.test;

/*
 * 문2]
     사칙연산자를 입력받아 계산하는 프로그램을 구현하시오.
    연산자는 +,-, *, / 네가지로 하고, 피연산자는 모두 실수로 함
    
     0으로 나누기 연산시에는 -> 0으로 나눌수 없습니다.를 출력하라.
 */

import java.util.*; // Scanner 클래스를 사용하기 위해 java.util 패키지를 임포트합니다.

public class HomeWork02 {

	public static void main(String[] args) {

		// 사용자 입력을 받기 위한 Scanner 객체를 생성합니다.
		Scanner sc = new Scanner(System.in);

		// 첫 번째 숫자, 두 번째 숫자를 저장할 double형 변수를 선언합니다.
		double num1, num2;

		// 연산 기호를 저장할 char형 변수를 선언합니다.
		char cal;

		// 첫 번째 숫자를 입력받도록 사용자에게 메시지를 출력합니다.
		System.out.print("첫번째 수 입력: ");
		// 사용자로부터 첫 번째 double형 숫자를 입력받아 num1 변수에 저장합니다.
		num1 = sc.nextDouble();

		// 연산 기호를 입력받도록 사용자에게 메시지를 출력합니다.
		System.out.print("연산기호 입력(+, -, *, /): ");
		// 사용자로부터 문자열을 입력받은 후, 그 문자열의 첫 번째 문자를 추출하여 cal 변수에 저장합니다.
		cal = sc.next().charAt(0);

		// 두 번째 숫자를 입력받도록 사용자에게 메시지를 출력합니다.
		System.out.print("두번째수 입력:");
		// 사용자로부터 두 번째 double형 숫자를 입력받아 num2 변수에 저장합니다.
		num2 = sc.nextDouble();

		// 입력받은 연산 기호(cal)에 따라 다른 연산을 수행하기 위해 switch 문을 사용합니다.
		switch (cal) {
		case '+':
			// 연산 기호가 '+'인 경우 덧셈을 수행하고 결과를 출력합니다.
			System.out.printf("%f + %f = %f%n", num1, num2, num1 + num2);
			break; // 해당 case 실행 후 switch 문을 종료합니다.
		case '-':
			// 연산 기호가 '-'인 경우 뺄셈을 수행하고 결과를 출력합니다.
			System.out.printf("%f - %f = %f%n", num1, num2, num1 - num2);
			break; // 해당 case 실행 후 switch 문을 종료합니다.
		case '*':
			// 연산 기호가 '*'인 경우 곱셈을 수행하고 결과를 출력합니다.
			System.out.printf("%f * %f = %f%n", num1, num2, num1 * num2);
			break; // 해당 case 실행 후 switch 문을 종료합니다.
		case '/':
			// 연산 기호가 '/'인 경우 나눗셈을 수행합니다.
			// 두 번째 숫자가 0인지 확인하여 0으로 나누는 경우를 처리합니다.
			if (num2 == 0) {
				// 두 번째 숫자가 0이면 "0으로 나눌 수 없습니다." 메시지를 출력합니다.
				System.out.println("0으로 나눌 수 없습니다.");
			} else {
				// 두 번째 숫자가 0이 아니면 나눗셈을 수행하고 결과를 출력합니다.
				System.out.printf("%f / %f = %f%n", num1, num2, num1 / num2);
			}
			break; // 해당 case 실행 후 switch 문을 종료합니다.
		default:
			// 위의 어떤 연산 기호에도 해당하지 않는 경우 (잘못된 연산자 입력 시)
			// "잘못된 연산자입니다." 메시지를 출력합니다.
			System.out.println("잘못된 연산자입니다.");
		}

		// 더 이상 Scanner 객체를 사용하지 않을 때, 리소스를 해제합니다.
		sc.close();
	}
}
