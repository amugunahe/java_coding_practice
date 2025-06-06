package com.loop;

import java.util.Scanner;

/*
 * 문] 
 * 임의의 정수 두개를 입력받아 
 * 두 수 사이의 합계를 구하는 프로그램을 구현하시오.
 *
 *첫번째 정수: 10
 *두번째 정수: 1
 *
 *두 수의 합계: 55
 */

import java.util.*;

public class ForEx10 {

	public static void main(String[] args) {

		int a, b, sum = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수: ");
		a = sc.nextInt();
		
		System.out.print("두번째 정수: ");
		b = sc.nextInt();

		if (a > b) {
			a = a ^ b;
			b = a ^ b;
			a = a ^ b;
		}

		for (int i = a; i <= b; i++) {
			sum += i;
		}
		System.out.print("두 수의 합계: " + sum);
	}
}
