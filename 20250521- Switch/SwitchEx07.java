package com.switchex;


/*문] 
 * 커피 메뉴의 가격을 알려주는 프로그램을 작성하시오.
 * 커피 종류: 에스프레소, 카푸치노, 카페라떼 =>3500원
 *          아메리카노 => 2000원
 * 커피의 종류가 아닌 경우는 => 메뉴에 없습니다.를 출력하시오.
 * 
 * 출력 결과 
 * 무슨 커피: 에스프레소 
 * 에스프레소는 3500원입니다. 
 * 
 */

import java.util.*;
public class SwitchEx07 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		String str;
		System.out.print("커피 종류 입력(에스프레소, 카푸치노, 카페라떼, 아메리카노): ");
		str= sc.next();
		System.out.println("무슨 커피: "+ str);
		
 

		switch(str) {
		case "에스프레소": case "카푸치노": case "카페라떼":
				System.out.println("3500원 입니다.");
				break;
		case "아메리카노":
				System.out.println("2000원 입니다.");	
				break;
		default:
			System.out.println("메뉴에 없습니다.");
	}
}
}

