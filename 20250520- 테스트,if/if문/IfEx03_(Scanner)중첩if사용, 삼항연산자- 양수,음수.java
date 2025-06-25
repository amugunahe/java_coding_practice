package com.condition;

/* 문] 중첩 if를 사용
사용자로부터 임의의 정수를 입력받아 입력받은 정수가 양수인지, 음수인지, 0인지를
판정하는 프로그램을 구현하시오.

단, scanner 클래스로
또한 조건 삼항연산자도 구현하시오.
*/

import java.util.*;

public class IfEx03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위한 Scanner 객체 생성

		System.out.print("정수를 입력: "); // 사용자에게 정수 입력하라고 알려줌
		int userInput = sc.nextInt(); // 사용자가 입력한 정수를 변수 'userInput'에 저장

		// --- 중첩 if 문으로 판별 ---
		System.out.println("\n--- 중첩 if 문 결과 ---");
		if (userInput != 0) { // 입력값이 0이 아니면
			if (userInput > 0) { // 0이면서 양수면
				System.out.println(userInput + "은 양수입니다."); // 양수라고 출력
			} else { // 0이 아니면서 양수가 아니면 (즉, 음수면)
				System.out.println(userInput + "은 음수입니다."); // 음수라고 출력
			}
		} else { // 입력값이 0이면
			System.out.println(userInput + "은 0입니다."); // 0이라고 출력
		}

		// --- 삼항 연산자로 판별 ---
		System.out.println("\n--- 삼항 연산자 결과 ---");
		String result;
		// 삼항 연산자는 '조건 ? 참일 때 값 : 거짓일 때 값' 형태.
		// 여러 조건을 중첩할 수 있다.
		result = (userInput > 0) ? "양수" : // userInput이 0보다 크면 "양수"
				 (userInput < 0) ? "음수" : // 그게 아니면서 userInput이 0보다 작으면 "음수"
				 "0"; // 위에 두 조건 다 아니면 "0"
		System.out.println(userInput + "은 " + result + "입니다.");

		sc.close(); // Scanner 사용이 끝났으면 반드시 닫아줘야 함
	}
}
