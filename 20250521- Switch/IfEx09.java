package com.condition;

/*
* 문] 사용자로부터 3개의 정수를 입력받아 
* 작은 수부터 큰 수를 순서대로 출력하는 프로그램을 구현하시오.
* 
* 실행결과는 
* 첫번째: 16
* 두번째: 8
* 세번째: 21
* 
* 출력 결과: 8 16 21 
* 
*/
import java.util.*;
public class IfEx09 {

	public static void main(String[] args) {
		/* 1. 첫번째 정수가 두번째 정수보다 크다면 두정수의 자리를 바꾼다. a와 b가 자리를 바꾼다
		 * 2. 첫번째 정수가 세번째 정수보다 크다면 두정수의 자리를 바꾼다. a와 c가 자리를 바꾼다
		 * 3. 두번째 정수가 세번째 정수보다 크다면 두정수의 자리를 바꾼다. b와 c가 자리를 바꾼다 
		 *
		 */
		 
		Scanner sc = new Scanner(System.in);
		int a, b, c, imsi;
		System.out.print("첫번째 정수: ");
		a= sc.nextInt();
		
		System.out.print("두번째 정수: ");
		b= sc.nextInt();
		
		System.out.print("세번째 정수: ");
		c= sc.nextInt();
		
		if(a>b) {
			/* imsi=a;
			a=b;
			b=imsi; */
			
			a= a^b;
			b= b^a;
			a= b^a;
		}
		else if(a>c) {
		/*	imsi=a;
			a=c;
			c=imsi;*/
			
			a= a^c;
			b= c^a;
			a= a^c;
		}
		if (b>c) {
			/*imsi=b;
			b=c;
			c=imsi;*/
			
			b= b^c;
			c= c^b;
			b= b^c;
		}
		//결과 출력
		System.out.println("결과:" +a + " "+b+ " "+ c);
		}
	
}		

	

