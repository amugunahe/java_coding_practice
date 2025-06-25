package com.condition;

/* 문] 사용자로부터 임의의 년도를 입력받아
 입력받은 년도가 윤년인지 평년인지를 판정하는 프로그램을 구현하시오.

 윤년의 판정 조건
 년도가 4의 배수이면서 100의 배수가 아니거나, 400의 배수이면 윤년
 그렇지 않으면 평년
 */

import java.util.*;

public class IfEx04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위한 Scanner 객체 생성

		int year; // 연도를 저장할 변수

		System.out.print("연도 입력: "); // 사용자에게 연도 입력하라고 알려줌
		year = sc.nextInt(); // 사용자가 입력한 연도를 변수 'year'에 저장

		// 윤년 판정 조건: (4의 배수이면서 100의 배수가 아니거나) 또는 (400의 배수)
		// 이 조건을 만족하면 윤년, 아니면 평년
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) { // 논리 연산자로 한 줄에 표현
			System.out.println(year + "는 윤년입니다."); // 윤년일 경우 출력
		} else {
			System.out.println(year + "는 평년입니다."); // 평년일 경우 출력
		}

		sc.close(); // Scanner 사용이 끝났으면 반드시 닫아줘야 함
	}
}
