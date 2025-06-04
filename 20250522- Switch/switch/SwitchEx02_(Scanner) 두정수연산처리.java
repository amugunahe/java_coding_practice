package com.switchex;

/*문] 사용자로부터 두 정수와 연산자를 입력받아 해당 연산을 처리하는

프로그램을 구현하시오 
*  출력 결과
*  첫번째 정수입력: 10
*  연산자 입력{+ - / *}: +
*  두번째 정수입력: 14
*  
*  10+ 14 = 24
*/


import java.util.*;
public class SwitchEx02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a, b;
		char op;
		
		System.out.print("첫번째 정수: " );
		a = sc.nextInt();
		
		System.out.print("연산자 입력: " );
		op = sc.next().charAt(0);
		
		System.out.print("두번째 정수: " );
		b = sc.nextInt();
		
		switch(op) {
		case '+':
			System.out.printf("%d + %d = %d", a, b, a + b);
			break;
		case '-':
			System.out.printf("%d - %d = %d", a, b, a - b);
			break;
		case '*':
			System.out.printf("%d * %d = %d", a, b, a * b);
			break;
		case '/':
			System.out.printf("%d / %d = %d", a, b, a / b);
			break;
		
		default:
			System.out.println("연산자가 아닙니다.");
			break;
		}
	}

}
