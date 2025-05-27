package com.loop;

/*
 * 반복문 형식
 * for(초기 값; 조건식; 증감식){
 * 반복 수행할 문장;
 * } 
 * 
 */
public class ForEx01 {

	public static void main(String[] args) {
		int i;   //반복을 수행할 변수 
 
		for(i=1; i<=100; i++) {
		System.out.println("I can do it.");
		}
		System.out.println();
		for(i=10; i>=1; i--) {
			System.out.println(i+"\t");
		}
		System.out.println();
		for(i=1; i<=10; i*=3) {
			System.out.println(i+"\t");
		}
		System.out.println();
		for(i=1; i<=10; i+=3) {
			System.out.println(i+"\n");
		}
		
		
		
		
		/* 초기값 빼기 
		int i= 1;
		
		for(; i<=100; i++) 
		System.out.println("I can do it.");
		 *
		 *
		 * 증감식도 빼기 
		 * 
		 * int i= 1;
		 * 
		 * for(; i<=100; )   //조건식이 거짓일 때 반복문은 탈출한다
		 * System.out.println("I can do it.");
		 * i++;  //1씩 증가 
		 */
	
	}
}
