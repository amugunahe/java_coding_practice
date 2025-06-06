package com.exam;

/* 문] 정수로 된 돈의 금액을 입력받아 오만원권, 만원권, 오천원권, 천원권, 
500원 동전 100원 동전, 50원 동전, 10원 동전, 1원 동전이
각각 몇개인지를 반환하는 프로그램을 구현하시오.
  
단, if문만 사용하여 구현.

65376
오만원권 1매
만원권 1매
천원권 5매
100원 3개
50원 1개
10원 2개
1원  6개  
*/

import java.util.*;

public class Exam03 {
	
	final static int omanwon = 50000;
	final static int manwon = 10000;
	final static int ochunwon = 5000;
	final static int chunwon = 1000;
	final static int obekwon = 500;
	final static int bekwon = 100;
	final static int osipwon = 50;
	final static int sipwon = 10;
	final static int ilwon = 1;
	

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
		int money, result; //돈의 종류 상수화 시킴
		
		System.out.print("금액을 입력하세요: ");
		money = sc.nextInt();
		
		result = money / omanwon; // 오만원권 개수
		money = money % omanwon;  // 돈이 수정
		if(result > 0)
			System.out.println("오만원권: " + result + "매 입니다.");
		
		result = money / manwon; // 만원권 개수
		money = money % manwon;  // 돈이 수정
		if(result > 0)
			System.out.println("만원권: " + result + "매 입니다.");
		
		result = money / ochunwon; // 오천원권 개수
		money = money % ochunwon;  // 돈이 수정
		if(result > 0)
			System.out.println("오천원권: " + result + "매 입니다.");
		
		result = money / chunwon; // 천원권 개수
		money = money % chunwon;  // 돈이 수정
		if(result > 0)
			System.out.println("천원권: " + result + "매 입니다.");
	
		result = money / obekwon; // 500원 개수
		money = money % obekwon;  // 돈이 수정
		if(result > 0)
			System.out.println("500원: " + result + "개 입니다.");
		
		result = money/bekwon; // 100원 개수
		money = money % bekwon;  // 돈이 수정
		if(result > 0)
			System.out.println("100원: " + result + "개 입니다.");
		
		result = money / osipwon; // 50원 개수
		money = money % osipwon;  // 돈이 수정
		if(result > 0)
			System.out.println("50원: " + result + "개 입니다.");
		
		result = money / sipwon; //10원 개수
		money = money % sipwon;  //돈이 수정
		if(result > 0)
			System.out.println("10원: " + result + "개 입니다.");
		
		result = money / ilwon; // 1원 개수
		money = money % ilwon;  // 돈이 수정
		if(result > 0)
			System.out.println("1원: " + result + "개 입니다.");
	}
}
