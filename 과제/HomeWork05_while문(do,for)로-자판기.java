package com.test;

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

