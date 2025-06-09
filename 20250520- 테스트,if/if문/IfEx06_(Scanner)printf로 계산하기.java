package com.condition;

/*문] 사용자로부터 두 정수와 연산자를 입력받아 해당 연산을 처리하는 프로그램을 구현하시오 
출력 결과
첫번째 정수입력: 10
연산자 입력{+ - / *}: +
두번째 정수입력: 14
  
10+ 14 = 24
*/

import java.util.*;

public class IfEx06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a, b; 
		char c;
		
		System.out.print("첫번째 정수 입력: ");
		a = sc.nextInt();
		
		System.out.print("연산자 입력: ");
		c = sc.next().charAt(0);
		
		System.out.println("두번째 정수 입력: ");
		b = sc.nextInt();
		
		if (c == '+') {
			System.out.printf("%d + %d = %d", a, b, (a + b));
		} else if (c == '-') {
			System.out.printf("%d - %d = %d", a, b, (a - b));
		} else if (c == '*') {
			System.out.printf("%d * %d = %d", a, b, (a * b));
		} else if (c == '/') {
			System.out.printf("%d / %d = %d", a, b, (a / b));
		}
	}
}
