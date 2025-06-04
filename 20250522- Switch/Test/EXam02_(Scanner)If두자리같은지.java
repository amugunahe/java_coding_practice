package com.exam;

/*
 * 문] 2자리의 정수(0~99)사이의 정수를 입력받고,
 * 10의 자리와 1의 자리가 같은지를 판별하는 프로그램을 구현하시오.
 * 
 * 출력
 * 2자리 정수 입력(10~99): 77
 * 10의 자리와 1의 자리가 같습니다.  
 * 
 * 2자리 정수 입력(10~99): 57
 * 10의 자리와 1의 자리가 다릅니다.  
 * 
 * 10의자리와 1의 자리를 구분 
 * 몫은 10의자리로 나머지는 1의 자리로 
 */

import java.util.*;
public class EXam02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		
		System.out.print("10자리 정수를 입력해라: ");
		a = sc.nextInt();
		
		if(a > 9 && a <= 99) {
			if(a / 10 == a % 10)
				System.out.println("10자리와 1의 자리가 같습니다.");
			else
				System.out.println("10의 자리와 1의 자리가 다릅니다.");
		}	
		else
			System.out.println("범위를 벗어났습니다.");			
		}
	}

/*

 *  다른 답) 
 * 		Scanner sc = new Scanner(System.in);
		int n, ten, one;
		
		System.out.print("2자리 정수를 입력(10~99): ");
		n = sc.nextInt();
		
		//범위
		if(n < 10 || n > 99){
		System.out.Pritnln("정수의 범위는 10~99만 입력하세요.");
		return;
		}
		
		ten = n / 10;   //10의 자리
		one = n % 10;  // 1의 자리
	
	//십의 자리와 일의 자리가 같은지를 비교
	  if(ten == one)
	  System.out.Pritnln("10자리와 1의 자리가 같습니다.");
		else
	  System.out.Pritnln("10의 자리와 1의 자리가 다릅니다.");
 */

