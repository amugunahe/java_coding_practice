package com.roop;

/*
 * 문] 1~10까지의 합계를 구하는 프로그램을 구현하시오.
 * 
 */

public class ForEx02_01 {

	public static void main(String[] args) {
		int i, sum=0;
		
		for(i=1; i<=10; i++) {
			sum+=i;
			System.out.println("1부터 "+ i + "까지의 합계: " + sum );
			
		}

	}

}
