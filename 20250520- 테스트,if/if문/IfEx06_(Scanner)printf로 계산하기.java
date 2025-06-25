package com.condition;

import java.util.*; // Scanner 클래스 쓰려고 import 함

public class IfEx06 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위한 Scanner 객체 생성

		int a, b; // 첫번째, 두번째 정수를 저장할 변수
		char c; // 연산자를 저장할 변수

		System.out.print("첫번째 정수 입력: "); // 사용자에게 첫번째 정수 입력하라고 알려줌
		a = sc.nextInt(); // 사용자가 입력한 정수를 변수 'a'에 저장

		System.out.print("연산자 입력{+ - / *}: "); // 사용자에게 연산자 입력하라고 알려줌
		c = sc.next().charAt(0); // 사용자가 입력한 문자열의 첫 번째 글자를 연산자로 저장

		System.out.println("두번째 정수 입력: "); // 사용자에게 두번째 정수 입력하라고 알려줌
		b = sc.nextInt(); // 사용자가 입력한 정수를 변수 'b'에 저장

		// 연산자에 따라 다른 계산 수행
		if (c == '+') { // 연산자가 '+'면 덧셈
			System.out.printf("%d + %d = %d", a, b, (a + b));
		} else if (c == '-') { // 연산자가 '-'면 뺄셈
			System.out.printf("%d - %d = %d", a, b, (a - b));
		} else if (c == '*') { // 연산자가 '*'면 곱셈
			System.out.printf("%d * %d = %d", a, b, (a * b));
		} else if (c == '/') { // 연산자가 '/'면 나눗셈
			if (b == 0) { // !!! 중요: b가 0일 경우 0으로 나눌 수 없다고 알려줌
				System.out.println("0으로는 나눌 수 없습니다.");
			} else {
				System.out.printf("%d / %d = %d", a, b, (a / b));
			}
		} else { // 그 외의 연산자가 들어오면 잘못된 연산자라고 알려줌
			System.out.println("잘못된 연산자입니다.");
		}

		sc.close(); // !!! 중요: Scanner 사용이 끝났으면 반드시 닫아줘야 함
	}
}
