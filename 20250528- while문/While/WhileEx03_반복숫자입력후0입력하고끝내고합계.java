package com.loop;

/* 문] 사용자로부터 반복해서 숫자를 입력받다가 0을 입력하면 끝마치고
  합계를 출력하는 프로그램
 */

import java.util.*; // Scanner 쓰려면 이거 필수 임포트

public class WhileEx03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // 사용자 입력받을 준비 완료!

		// 변수 선언:
		// n: 사용자로부터 입력받을 정수
		// sum: 합계 (0으로 초기화 필수!)
		// flag: 반복문의 실행 여부를 제어할 boolean 변수 (true로 초기화)
		int n, sum = 0;
		boolean flag = true; // ★ 핵심1: 반복을 계속할지 말지 결정하는 '깃발' 변수

		// 핵심2: `while (flag)`는 `flag` 변수가 `true`인 동안 계속 반복한다.
		while (flag) { 
			System.out.print("정수 입력: "); // 숫자 입력 안내
			n = sc.nextInt(); // 사용자로부터 정수 n을 입력받는다.

			// 핵심3: 입력받은 n이 0이 아니면 sum에 더하고, 0이면 반복을 멈춘다.
			if (n != 0) { // n이 0이 아니면
				sum += n; // sum에 n을 더한다.
			} else { // n이 0이면
				flag = false; // flag를 false로 바꿔서 다음 while 반복에서 조건이 거짓이 되게 한다.
			}
		}
		// 반복문이 끝나면 (즉, flag가 false가 되면) 최종 합계를 출력
		System.out.println("합계: " + sum);

        sc.close(); // Scanner 다 썼으면 자원 해제 필수!
	}
}
