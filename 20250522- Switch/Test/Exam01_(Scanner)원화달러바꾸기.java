package com.exam;

/* 원화를 입력받아 달러로 바꾸는 프로그램을 구현하시오.
1$ = 1400
원화 입력: 2800
2800원은 $2.0입니다

*/

import java.util.*;

public class Exam01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위한 Scanner 객체 생성

		int won; // 원화를 입력받을 변수 (정수로 받음)
		// 환율은 변하지 않는 값이므로 final로 선언하고, 소수점 계산을 위해 double 타입으로 명시
		final double EXCHANGE_RATE = 1400.0; // 1$ = 1400 (상수명은 대문자로 쓰는 게 관례)

		System.out.print("원화 입력(숫자만 기입): "); // 사용자에게 원화 입력하라고 알려줌
		won = sc.nextInt(); // 사용자가 입력한 정수를 변수 'won'에 저장

		// 달러로 변환 (won을 double로 형변환해서 정확한 소수점 계산이 되도록 함)
		double dollar = (double)won / EXCHANGE_RATE;

		// 결과 출력 (소수점 둘째 자리까지 표시하도록 % .2f 사용)
		System.out.printf("%d원은 $%.2f입니다%n", won, dollar); // %n은 줄바꿈 문자

		sc.close(); // Scanner 사용이 끝났으면 반드시 닫아줘야 함
	}
}
