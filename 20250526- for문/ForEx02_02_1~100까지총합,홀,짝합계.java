package com.loop;

/*
 * 문] 1~100까지의 수중 전체 합계, 홀수의 합, 짝수의 합을 구하는 프로그램을 구현하시오.
 * 
 */

public class ForEx02_02 {

	public static void main(String[] args) {
		int i, sum = 0;
		int odd = 0;   // 홀수의합
		int even = 0; // 짝수의 합

		for (i = 1; i <= 100; i++) {

			if (i % 2 == 0)
				even += i;  //짝수의 합
			else
				odd += i;  //홀수의 합 

			sum += i; // 전체 합계
		}

		System.out.println("1부터 100 까지의 합계: " + sum);
		System.out.println("1부터 100 까지의 홀수의 합계: " + odd);
		System.out.println("1부터 100 까지의 짝수의 합계: " + even);

	}

}
