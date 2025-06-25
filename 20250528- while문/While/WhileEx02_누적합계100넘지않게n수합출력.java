package com.loop;

/* 문] 1부터 몇까지 더하면 누적합계를 100을 넘지 않은지 
n까지의 수와 합계를 출력하시오.
*/

public class WhileEx02 {

	public static void main(String[] args) {

		int i = 0, sum = 0; // i는 더해나갈 숫자, sum은 누적 합계 (둘 다 0으로 초기화 필수!)

		// ★★★ 개핵심: while문 조건식 안에서 모든 계산과 조건 검사를 동시에 처리
		while ((sum += ++i) <= 100) { 
			/*
			 * 이 주석 처리된 코드가 원래 네가 생각했던 방식일 거다.
			 * sum += i;     // sum에 i를 더하고
			 * if (sum <= 100) { // 만약 sum이 100 이하면 출력
			 * System.out.printf("%d ==> %d%n", i, sum); 
			 * }
			 * i++; // i를 1 증가
			 * * 그런데 네 코드는 이걸 while문 조건식 한 줄로 압축한 거다.
			 */
			
			// while 조건이 참일 때만 실행되는 부분 (즉, sum이 100을 넘지 않았을 때만 출력)
			System.out.printf("%d ==> %d%n", i, sum); // 현재 i와 누적된 sum 출력
		}
	}
}
