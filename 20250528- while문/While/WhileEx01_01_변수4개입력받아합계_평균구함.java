package com.loop;

/*
 * 문] 
 * 반복 횟수를 알지 못할 경우 while문을 이용함
 * -1이 입력될때까지 정수를 계속 입력받아 합계를 구하고,
 *  평균을 구하여 출력하는 프로그램을 구현하시오.
 *	1, 2, 3, 4개 변수가 만들어져야한다 
 *	첫번째 변수: 정수를 입력받을 정수 n
 *  두번째 변수: 합계를 저장 sum	
 *  세번째 변수: 입력된 정수값의 개수를 저장할 변수 cnt
 *  네번째 변수: 합계를 이용하여 평균을 구해서 저장할 변수 avg(double)
 */
import java.util.*;

public class WhileEx01_01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n, cnt = 0, sum = 0;
		double avg;

		System.out.print("정수 입력하고 마지막에 -1를 입력: ");
		n = sc.nextInt();

		while (n != -1) { // 조건 => -1이 아니면 참
			sum += n;
			cnt++;
			System.out.print("정수 입력하고 마지막에 -1를 입력: ");
			n = sc.nextInt();
			// System.out.println("합계: " + sum);
			// System.out.println("카운트: " + cnt);
		}
		avg = sum / cnt;
		System.out.println("합계: " + sum + ", 평균: " + avg);
	}
}
