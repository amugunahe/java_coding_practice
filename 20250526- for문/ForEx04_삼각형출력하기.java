package com.loop;

import java.util.Scanner;

public class ForEx04 {

	public static void main(String[] args) {
		
/* 노가다 방법
System.out.println("**********");
System.out.println("**********");
System.out.println("**********");
System.out.println("**********");
System.out.println("**********");
System.out.println("**********");
*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("*을 입력할 라인 수 입력:");
		int line = sc.nextInt();
		
		for (int j = 1; j <= line; j++) {  // 행
		for (int i = 1; i <= j; i++) { // 열
			System.out.print("*");				
			}
			System.out.println();
		}
	}
}
