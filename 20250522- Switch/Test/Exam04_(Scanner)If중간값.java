package com.exam;

/* 문] 정수 3개를 받고 3개의 정수 중 중간크기의 수를 출력하는 프로그램을 작성하시오.

출력
정수 3개 입력: 20 100 33
중간 값은: 33
단 if문을 사용해라
*/

import java.util.*;

public class Exam04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위한 Scanner 객체 생성

		int a, b, c; // 3개의 정수를 저장할 변수

		System.out.print("정수 3개 입력: "); // 사용자에게 정수 3개 입력 요청
		a = sc.nextInt(); // 첫 번째 정수 입력
		b = sc.nextInt(); // 두 번째 정수 입력
		c = sc.nextInt(); // 세 번째 정수 입력

		int median; // 중간값을 저장할 변수

		// 중간값 판별 로직
		// (a가 b와 c 사이) 또는 (a가 c와 b 사이)에 있다면 a가 중간값
		if ((a >= b && a <= c) || (a >= c && a <= b)) {
			median = a;
		}
		// (b가 a와 c 사이) 또는 (b가 c와 a 사이)에 있다면 b가 중간값
		else if ((b >= a && b <= c) || (b >= c && b <= a)) {
			median = b;
		}
		// 위의 모든 조건에 해당하지 않으면 c가 중간값 (나머지 경우)
		else {
			median = c;
		}

		System.out.println("중간 값은: " + median); // 계산된 중간값 출력

		sc.close(); // Scanner 사용이 끝났으면 반드시 닫아줘야 함
	}
}
