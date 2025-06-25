package com.condition;

/* 문] 사용자로부터 임의의 년도를 입력받아
 입력받은 년도가 윤년인지 평년인지를 판정하는 프로그램을 구현하시오.

 윤년의 판정 조건
 년도가 4의 배수이면서 100의 배수가 아니거나, 400의 배수이면 윤년
 그렇지 않으면 평년
 */

import java.util.*; // Scanner 쓰려면 이거 필수. 무조건 임포트 해라.

public class IfEx04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력 받으려고 Scanner 객체 만든다. (기본)

		int year; // 연도 저장할 변수 미리 선언해두고.

		System.out.print("연도 입력: "); // 사용자에게 '연도 입력해라' 메시지 띄우고.
		year = sc.nextInt(); // 사용자가 입력한 숫자를 year 변수에 넣어준다. (정수 입력 핵심!)

		// 윤년 판정 조건: (4의 배수 && 100의 배수 아님) || (400의 배수)
		// 핵심은 이 조건식이다. 이 조건이 참이면 윤년, 거짓이면 평년.
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) { 
			System.out.println(year + "는 윤년입니다."); // 조건 참이면 이거 출력.
		} else {
			System.out.println(year + "는 평년입니다."); // 조건 거짓이면 이거 출력.
		}

		sc.close(); // Scanner 다 썼으면 자원 해제 필수! (안 해주면 나중에 문제 생길 수도 있음)
	}
}
