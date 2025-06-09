package com.test;

/* 문2] 콜라, 사이다, 마운틴, 초코송이, 에이스, 웨하스 메뉴를 선택하여 선택한 메뉴가 출력되는
자판기프로그램을 작성하라.
단, 0번을 누르면 프로그램 종료
      
출력결과
콜라-1, 사이다-2, 마운틴-3, 초코송이-4, 에이스-5, 웨하스-6(0 종료)3
마운틴
콜라-1, 사이다-2, 마운틴-3, 초코송이-4, 에이스-5, 웨하스-6(0 종료)4
초코송이
콜라-1, 사이다-2, 마운틴-3, 초코송이-4, 에이스-5, 웨하스-6(0 종료)2
사이다
콜라-1, 사이다-2, 마운틴-3, 초코송이-4, 에이스-5, 웨하스-6(0 종료)5
에이스
콜라-1, 사이다-2, 마운틴-3, 초코송이-4, 에이스-5, 웨하스-6(0 종료)0
선택하신 상품이 없습니다.
*/

import java.util.*;

public class HomeWork05 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int m = 0;

		while (m < 0 || m >= 0) {
			System.out.print("메뉴 선택하세요=> 콜라-1, 사이다-2, 마운틴-3, 초코송이-4, 에이스-5, 웨하스-6(0 종료):");
			m = sc.nextInt();

			if (m == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			switch (m) {
			case (1):
				System.out.println("콜라");
				break;
			case (2):
				System.out.println("사이다");
				break;
			case (3):
				System.out.println("마운틴");
				break;
			case (4):
				System.out.println("초코송이");
				break;
			case (5):
				System.out.println("에이스");
				break;
			case (6):
				System.out.println("웨하스");
				break;
			default:
				System.out.println("선택하신 상품이 없습니다.");
				break;
			}
		}
	}
}
