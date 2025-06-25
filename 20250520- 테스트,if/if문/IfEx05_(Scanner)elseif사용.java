package com.condition;

/*문] 사용자로부터 임의의 정수를 입력받아 입력받은 정수가
2의 배수인지, 3의 배수인지, 2와 3의 배수인지, 2와 3의 배수가 아닌지를
판정하는 프로그램을 구현하시오.
*/

import java.util.*;

public class IfEx05 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위한 Scanner 객체 생성

		int a; // 임의의 정수를 저장할 변수

		System.out.print("정수 입력:"); // 사용자에게 정수 입력하라고 알려줌
		a = sc.nextInt(); // 사용자가 입력한 정수를 변수 'a'에 저장

		// 2와 3의 배수, 2의 배수, 3의 배수, 둘 다 아닌 경우를 판정
		if (a % 2 == 0 && a % 3 == 0) { // !!! 중요: 2로도 나누어 떨어지고 3으로도 나누어 떨어지면
			System.out.println("2와 3의 배수입니다."); // 2와 3의 배수라고 출력
		} else if (a % 2 == 0) { // !!! 중요: 위에 조건이 거짓이고, 2로 나누어 떨어지면
			System.out.println("2의 배수입니다"); // 2의 배수라고 출력
		} else if (a % 3 == 0) { // !!! 중요: 위에 두 조건이 거짓이고, 3으로 나누어 떨어지면
			System.out.println("3의 배수입니다."); // 3의 배수라고 출력
		} else { // 위에 모든 조건이 거짓이면
			System.out.println("2와 3의 배수가 아닙니다."); // 2와 3의 배수가 아니라고 출력
		}

		sc.close(); // !!! 중요: Scanner 사용이 끝났으면 반드시 닫아줘야 함
	}
}
