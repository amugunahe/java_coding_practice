package com.test;

import java.util.*;
public class HomeWork02 {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

double num1, num2;

char cal;

System.out.print("첫번째 수 입력: ");
	num1= sc.nextDouble();
	
	System.out.print("연산기호 입력(+, -, *, /): ");
	cal= sc.next().charAt(0);
	
	System.out.print("두번째수 입력:");
	num2= sc.nextDouble();
	
	switch(cal) {
	case '+':
		System.out.printf("%f + %f = %f", num1, num2, num1+num2);
		break;
	case '-':
		System.out.printf("%f - %f = %f", num1, num2, num1-num2);
		break;
	case '*':
		System.out.printf("%f * %f= %f", num1, num2, num1*num2);
		break;
	case '/':
		if (num2==0) {
			System.out.println("0으로 나눌수 없습니다 ");
		}
		else {
			System.out.printf("%f/ %f = %f", num1, num2,  num1/num2);
		}
		break;
	default: 
		System.out.println("잘못되었습니다.");
	}
	}
}
