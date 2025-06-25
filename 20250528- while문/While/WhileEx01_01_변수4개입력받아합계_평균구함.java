package com.loop;

/* 문] 반복 횟수를 알지 못할 경우 while문을 이용함
  -1이 입력될때까지 정수를 계속 입력받아 합계를 구하고,
  평균을 구하여 출력하는 프로그램을 구현하시오.
 1, 2, 3, 4개 변수가 만들어져야한다 
 첫번째 변수: 정수를 입력받을 정수 n
 두번째 변수: 합계를 저장 sum	
 세번째 변수: 입력된 정수값의 개수를 저장할 변수 cnt
 네번째 변수: 합계를 이용하여 평균을 구해서 저장할 변수 avg(double)
 */

import java.util.*; // Scanner 쓰려면 필수 임포트

public class WhileEx01_01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력받을 준비 완료!

		// 변수 선언:
		// n: 사용자로부터 입력받을 정수
		// cnt: 입력된 정수의 개수 (0으로 초기화)
		// sum: 합계 (0으로 초기화)
		// avg: 평균 (double 타입으로 선언)
		int n, cnt = 0, sum = 0; 
		double avg; 

		System.out.print("정수 입력하고 마지막에 -1를 입력: "); // 첫 번째 숫자 입력 안내
		n = sc.nextInt(); // 첫 번째 숫자 입력받아 n에 저장

		// 핵심: n이 -1이 아닐 때만 반복. -1이면 반복 종료.
		while (n != -1) { 
			sum += n;   // n을 sum에 더한다.
			cnt++;      // 입력된 숫자의 개수를 1 증가시킨다.
			
			System.out.print("정수 입력하고 마지막에 -1를 입력: "); // 다음 숫자 입력 안내
			n = sc.nextInt(); // 다음 숫자 입력받아 n에 저장 (이 n 값이 다음 반복의 조건이 됨)
			
			// System.out.println("합계: " + sum);   // 개발 중 확인용 주석
			// System.out.println("카운트: " + cnt); // 개발 중 확인용 주석
		}
		
		// 반복이 끝나면 (즉, -1이 입력되면) 평균 계산 및 출력
		// ★ 중요: cnt가 0이면(아무 숫자도 입력 안 했으면) 0으로 나누기 오류 발생 가능성 있음.
		// 이 코드에서는 1개 이상은 입력한다고 가정.
		avg = (double)sum / cnt; // sum을 cnt로 나눈다. (sum을 double로 형변환해서 실수 나눗셈 유도)
		System.out.println("합계: " + sum + ", 평균: " + avg);

        sc.close(); // Scanner 다 썼으면 자원 해제 필수!
	}
}
