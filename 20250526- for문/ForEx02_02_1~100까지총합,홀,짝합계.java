package com.loop;

/* 문] 1~100까지의 수중 전체 합계, 홀수의 합, 짝수의 합을 구하는 프로그램을 구현하시오.
 */

public class ForEx02_02 {

	public static void main(String[] args) {
		
		// 변수 선언:
		int i; // 반복에 사용할 카운터 변수
		int sum = 0; // 1부터 100까지 전체 합계를 저장할 변수 (0으로 초기화 필수)
		int odd = 0; // 홀수의 합을 저장할 변수 (0으로 초기화 필수)
		int even = 0; // 짝수의 합을 저장할 변수 (0으로 초기화 필수)

		// 핵심: 1부터 100까지 반복하면서 각 숫자를 홀수/짝수로 구분하여 합산
		for (i = 1; i <= 100; i++) { // i는 1부터 100까지 1씩 증가하며 반복
			// i가 짝수인지 홀수인지 판별
			if (i % 2 == 0) { // i를 2로 나눈 나머지가 0이면 (짝수이면)
				even += i; // even 변수에 i 값을 더한다.
			} else { // 짝수가 아니면 (홀수이면)
				odd += i; // odd 변수에 i 값을 더한다.
			}
			
			sum += i; // 이 부분은 홀짝 관계없이 무조건 전체 합계 sum에 더한다.
		}

		// 최종 결과 출력
		System.out.println("1부터 100 까지의 합계: " + sum);
		System.out.println("1부터 100 까지의 홀수의 합계: " + odd);
		System.out.println("1부터 100 까지의 짝수의 합계: " + even);
	}
}
