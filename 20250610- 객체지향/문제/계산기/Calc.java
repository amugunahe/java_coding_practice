package com.functionex;

import java.util.*;

public class Calc {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("두정수와 연산자 입력: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		char c = sc.next().charAt(0);
	
	switch(c) {
	case '+':
		Add add = new Add();
		add.setValue(a, b);
		System.out.println("결과: " + add.calculate());
		break;
	case '-':
		Sub sub = new Sub();
		sub.setValue(a, b);
		System.out.println("결과: " + sub.calculate());
		break;
	case '*':
		Mul mul = new Mul();
		mul.setValue(a, b);
		System.out.println("결과: " + mul.calculate());
		break;
	case '/':
		Div div = new Div();
		div.setValue(a, b);
		System.out.println("결과: " + div.calculate());
		break;
	default:
		System.out.println("잘못된 연산자 입니다.");
		}
		
	}

}
