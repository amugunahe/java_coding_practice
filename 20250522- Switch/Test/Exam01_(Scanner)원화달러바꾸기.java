package com.exam;

/*
 * 원화를 입력받아 달러로 바꾸는 프로그램을 구현하시오.
 * 1$ = 1400
 * 
 * 원화 입력: 2800
 * 2800원은 $2.0입니다
 * 
 * 2800/1400.0
 */


import java.util.*;
public class Exam01 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int won;   //원화를 입력받을 변수
		
		final double rate = 1400.0;  // 1$=1400
		double dollar = 0;  //달러로 변환하여 저장할 변수
		
		System.out.print("원화 입력(숫자만 기입): ");
		won = sc.nextInt();
		
		System.out.printf("%d원은 $ %.2f 입니다", won, (float)won/rate);	
		
	}

}

/*Scanner sc = new Scanner(System.in);
		int won;   //원화를 입력받을 변수
		
		final double rate = 1400.0;  // 1$=1400
		double dollar = 0;  //달러로 변환하여 저장할 변수
		
		System.out.print("원화 입력(숫자만 기입): ");
		won = sc.nextInt();
		
		dollar= won/rate;
		
		System.out.prinln(won+ "은 $"+ dollar+ "입니다");	
		
 * 
 */
