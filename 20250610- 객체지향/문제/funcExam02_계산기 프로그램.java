package com.functionex;

/* 문] 계산기 프로그램에서 +, -, *, /, % 등의 연산을 메소드를 이용하여 
  프로그램을 구현하시오. 
  
  	plus(+), minus(-), multi(*), divi(/), per(%),
  	disp(출력)
  	
  	첫번째 수:  
  	연산자: (+, -, /, /, %): -> 연산자가 아닌 경우 다시 받도록 한다. 
  	두번째 수: 
 */

import java.io.*;

public class funcExam02 {	

	public static int plus(int a, int b) {
		return a + b; 	
	}
	
	public static int minus(int a, int b) {
		return a - b;
	}
	
	public static int multi(int a, int b) {
		return a * b;
	}
	
	public static int divi(int a, int b) {
		return a / b;
	}
	
	public static int per(int a, int b) {
		return a % b;
	}
	
	public static void disp(int a, char b, int c, int d) {
		System.out.println();
		System.out.println(a + " " + b + " " + c + " = " + d);
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int su1, su2, res = 0;
		
		char yon;
		
		System.out.print("첫번째 수: ");
		su1 = Integer.parseInt(br.readLine());
		do {
			System.out.print("연산자 입력: ");
			yon = (char)System.in.read();
			System.in.read();
			System.in.read();
			
		} while (yon != '+' && yon != '-' && yon != '*' && yon != '/' && yon != '%');
		System.out.print("두번째 수: ");
		su2 = Integer.parseInt(br.readLine());
		
		switch (yon) {
		case '+':
			res = plus(su1, su2);
			break;
		case '-':
			res = minus(su1, su2);
			break;
		case '*':
			res = multi(su1, su2);
			break;
		case '/':
			res = divi(su1, su2);
			break;
		case '%':
			res = per(su1, su2);
			break;		
		}
		
		// 출력 메소드 호출 
		disp(su1, yon, su2, res);
		
	}

}
