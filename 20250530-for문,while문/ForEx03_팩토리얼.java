package com.exam;

/* 문] 
 * 임의의 정수를 입력받아 입력받은 수만큼의 
 * 팩토리얼 계산하는 프로그램을 구현하시오.
 * 
 * 정수 입력: 7 
 * 7의 팩토리얼은 5040입니다. 
 * 
 * 7*6*5*4*3*2*1 
 * 
 */

import java.util.*;

public class ForEx03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n, f;
		n=f=1;
		
		System.out.print("정수 입력: ");
		n= sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			f *= i;
			System.out.println(i+"의 팩토리얼은 "+ f+ " 입니다.");
		}
		if(n<=0)
			System.out.println("정수는 1 이상부터 입력하세요.");
		
	}

}
