package com.loop;

/* 문] 1~10까지의 합계를 구하는 프로그램을 구현하시오.
 */

public class ForEx02_01 {

	public static void main(String[] args) {
		
		// 변수 선언: i는 반복에 쓸 숫자, sum은 합계를 저장할 변수 (0으로 초기화 중요!)
		int i, sum = 0; 
		
		// 1부터 10까지 반복하면서 sum에 더한다.
		for (i = 1; i <= 10; i++) { // i는 1부터 시작해서 10까지 1씩 증가
			sum += i; // 현재 i 값을 sum에 더한다. (핵심 연산!)
			// System.out.println("1부터 " + i + "까지의 합계: " + sum); // 각 단계별 합계 확인용
		}
        // System.out.println("1부터 10까지의 최종 합계: " + sum); // 최종 합계만 출력하려면 이걸 써라.
	}
}
