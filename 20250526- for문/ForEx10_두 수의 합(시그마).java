package com.loop;

/* 문] 
임의의 정수 두개를 입력받아 
두 수 사이의 합계를 구하는 프로그램을 구현하시오.

첫번째 정수: 10
두번째 정수: 1

두 수의 합계: 55
*/

import java.util.*; // Scanner 쓰려면 무조건 이거 임포트

public class ForEx10 {

	public static void main(String[] args) {

		// 변수 선언: a, b는 입력받을 숫자, sum은 합계 (0으로 초기화 필수!)
		int a, b, sum = 0; 
		
		Scanner sc = new Scanner(System.in); // 사용자 입력받을 준비 (Scanner 객체 생성)
		
		System.out.print("첫번째 정수: "); // 첫 번째 숫자 입력 안내
		a = sc.nextInt(); // 첫 번째 숫자 입력받아 a에 저장
		
		System.out.print("두번째 정수: "); // 두 번째 숫자 입력 안내
		b = sc.nextInt(); // 두 번째 숫자 입력받아 b에 저장

		// 핵심 1: a가 b보다 크면 두 숫자의 값을 서로 바꾼다.
		// 이렇게 해야 for문(a부터 b까지)이 항상 작은 수부터 큰 수까지 돌 수 있음.
		if (a > b) { 
			// 비트 XOR 연산자를 이용한 변수 값 교환 (똑똑하네!)
			a = a ^ b; 
			b = a ^ b;
			a = a ^ b;
		}

		// 핵심 2: a부터 b까지 반복하면서 합계를 구한다.
		// i를 a로 시작해서 b까지 1씩 증가시키며 sum에 더함.
		for (int i = a; i <= b; i++) { 
			sum += i; // sum = sum + i 와 같음.
		}
		
		System.out.print("두 수의 합계: " + sum); // 최종 합계 출력
        sc.close(); // Scanner 다 썼으면 자원 해제 필수!
	}
}
