package com.switchex;

/* 문] 월을 입력 받아서 월에 해당하는 계절을 출력하는 프로그램을 구현하시오.
 단, switch ~case문 활용
*/

import java.util.*;

public class SwitchEx03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위한 Scanner 객체 생성

		int month; // 월을 저장할 변수

		System.out.print("숫자로 월을 입력하세요: "); // 사용자에게 월 입력 요청
		month = sc.nextInt(); // 월 입력받아 저장

		// switch-case 문을 이용하여 월에 해당하는 계절 출력
		switch (month) {
			case 3: // 3월이거나
			case 4: // 4월이거나
			case 5: // 5월일 경우
				System.out.println("봄입니다."); // "봄입니다." 출력
				break; // switch 문 종료
			case 6: // 6월이거나
			case 7: // 7월이거나
			case 8: // 8월일 경우
				System.out.println("여름입니다."); // "여름입니다." 출력
				break; // switch 문 종료
			case 9: // 9월이거나
			case 10: // 10월이거나
			case 11: // 11월일 경우
				System.out.println("가을입니다."); // "가을입니다." 출력
				break; // switch 문 종료
			case 12: // 12월이거나
			case 1:  // 1월이거나
			case 2:  // 2월일 경우
				System.out.println("겨울입니다"); // "겨울입니다" 출력
				break; // switch 문 종료
			default: // 1월부터 12월까지의 범위가 아닌 다른 숫자가 입력될 경우
				System.out.println("입력하신 수는 계절에 속하지 않습니다"); // 안내 메시지 출력
				break; // switch 문 종료
		}

		sc.close(); // 사용이 끝난 Scanner 객체 닫기 (리소스 해제)
	}
}
