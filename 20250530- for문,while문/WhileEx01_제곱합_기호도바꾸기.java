package com.exam;

/* 문] -1^2+2^2-3^2+4^2-5^2+6^2~~~~~~99^2의 합계를 구하는 제곱 프로그램을 구현하시오.
 단, while문 사용

결과: 5050 
 */

public class WhileEx01 {

	public static void main(String[] args) {

		int i = 0;
		int sum = 0;
		int plus = 1;

		/* while (i <= 100) {
			if (i % 2 == 0) {
				sum += i * i;
			} else {
				sum += -(i * i);
			}
   		*/
		
		 while (i <= 100){
			plus= -plus;
			sum += plus * (i * i);
			i++;
		}
		System.out.println("합계: " + sum);
	}
}
