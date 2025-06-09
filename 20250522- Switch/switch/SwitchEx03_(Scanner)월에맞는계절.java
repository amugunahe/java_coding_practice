package com.switchex;

/* 문] 월을 입력 받아서 월에 해당하는 계절을 출력하는 프로그램을 구현하시오.
 단, switch ~case문 활용 
*/

import java.util.*;

public class SwitchEx03 {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	int month;
	
	System.out.print("숫자로 월을 입력하세요: ");
	month = sc.nextInt();
	
	switch (month) {
	case 3: case 4: case 5:
		System.out.println("봄입니다.");
		break;
	case 6: case 7: case 8:
		System.out.println("여름입니다.");
		break;
	case 9: case 10: case 11:
		System.out.println("가을입니다.");
		break;
	case 12: case 1: case 2:
		System.out.println("겨울입니다");
		break;
	default:
		System.out.println("입력하신 수는 계절에 속하지 않습니다");
		break;
		}
	}
}
