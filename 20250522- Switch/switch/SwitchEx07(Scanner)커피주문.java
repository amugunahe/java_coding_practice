package com.switchex;

/* 문] 커피 메뉴의 가격을 알려주는 프로그램을 작성하시오.
커피 종류: 에스프레소, 카푸치노, 카페라떼 =>3500원
아메리카노 => 2000원
커피의 종류가 아닌 경우는 => 메뉴에 없습니다.를 출력하시오.

출력 결과
무슨 커피: 에스프레소
에스프레소는 3500원입니다.
*/

import java.util.*;

public class SwitchEx07 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위한 Scanner 객체 생성

		String str; // 커피 종류를 입력받을 변수

		System.out.print("커피 종류 입력(에스프레소, 카푸치노, 카페라떼, 아메리카노): "); // 사용자에게 입력 요청 및 안내
		str = sc.next(); // 사용자가 입력한 커피 종류를 'str' 변수에 저장

		System.out.println("무슨 커피: " + str); // 입력받은 커피 종류 다시 출력

		// switch-case 문을 이용하여 커피 종류에 따른 가격 출력
		switch (str) {
			case "에스프레소": // 입력값이 "에스프레소"이거나
			case "카푸치노":  // "카푸치노"이거나
			case "카페라떼":  // "카페라떼"일 경우
				System.out.println(str + "는 3500원 입니다."); // 3500원 출력
				break; // switch 문 종료
			case "아메리카노": // 입력값이 "아메리카노"일 경우
				System.out.println(str + "는 2000원 입니다."); // 2000원 출력
				break; // switch 문 종료
			default: // 위의 어떤 case에도 해당하지 않을 경우
				System.out.println("메뉴에 없습니다."); // "메뉴에 없습니다." 출력
				break; // switch 문 종료 (default에도 break를 명시하는 것이 일반적)
		}

		sc.close(); // 사용이 끝난 Scanner 객체 닫기 (리소스 해제)
	}
}
