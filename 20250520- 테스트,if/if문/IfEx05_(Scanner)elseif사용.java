package com.condition;

/*문] 사용자로부터 임의의 정수를 입력받아 입력받은 정수가
2의 배수인지, 3의 배수인지, 2와 3의 배수인지, 2와 3의 배수가 아닌지를
판정하는 프로그램을 구현하시오.
*/

import java.util.*; // Scanner 쓰려면 이거 필수

public class IfEx05 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력받을 준비 (Scanner 객체 생성)

		int a; // 입력받은 정수를 저장할 변수

		System.out.print("정수 입력:"); // 입력 안내 메시지
		a = sc.nextInt(); // 사용자가 입력한 숫자를 'a'에 저장

		// 핵심: 조건문 순서가 중요하다.
		// 1. 2와 3의 배수 (가장 먼저 체크해야 함)
		if (a % 2 == 0 && a % 3 == 0) { 
			System.out.println("2와 3의 배수입니다."); 
		} 
		// 2. 2의 배수 (위 조건이 아닐 때만 체크)
		else if (a % 2 == 0) { 
			System.out.println("2의 배수입니다"); 
		} 
		// 3. 3의 배수 (위 두 조건이 아닐 때만 체크)
		else if (a % 3 == 0) { 
			System.out.println("3의 배수입니다."); 
		} 
		// 4. 나머지 (모든 조건에 해당 안 될 때)
		else { 
			System.out.println("2와 3의 배수가 아닙니다."); 
		}

		sc.close(); // Scanner 다 썼으면 꼭 닫아라. (자원 해제)
	}
}
