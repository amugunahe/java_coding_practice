package com.exam;

/*
 * 문]
 * 정수 3개를 받고 3개의 정수 중 중간크기의 수를 출력하는 프로그램을 작성하시오.
 * 
 * 출력
 * 정수 3개 입력: 20 100 33
 * 중간 값은: 33
 * 
 * 단 if문을 사용해라 
 */

import java.util.*;
public class Exam04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		
		System.out.print("정수 3개 입력");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		int median = a;  //초기화
		if ((a >= b && a <= c) || (a >=c && a <= b))
			median = a;
		else if ((b >= a && b<=c) || (b >= c && b <= a))
			median = b;
		else
			median = c;
		
		System.out.println("중간값: " + median);
	}

}
