package com.test;
/* 문1] 
1 ~ 99까지의 정수를 입력받고 정수에 3, 6, 9 중 하나가 있는 경우는 "박수짝",
두개가 있는 경우는 "박수짝짝"을 출력하는 프로그램을 구현하시오.
     
결과      
1 ~ 99 사이의 정수 입력 : 36
박수짝짝
 */

import java.util.Scanner;

public class HomeWork01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n, cnt = 0;
 		int a, b;  // a는 10의자리 b는 1의자리 
   
 		System.out.print("1 ~ 99 사이의 정수: ");
		n = sc.nextInt();
		
 	
 	// 1  ~99까지의 정수 범위
 	if (n >= 1 && n <= 99) {
 
 	a = n / 10;   // 10의 자리 
 	b = n % 10;  // 1의 자리 
 
 // 십의 자리 정수에 3, 6, 9 중 하나가 있는 경우 cnt를 증가시킴
  	if (a != 0 && a % 3 == 0) {
  	cnt++;
  }
  
 // 일의 자리 정수에 3, 6, 9 중 하나가 있는 경우 cnt를 증가시킴 
 	if (b != 0 && b % 3 == 0) {
 	cnt++;
 	}
 	
 	if (cnt == 2) 
 		System.out.println("박수 짝짝");
 	else if (cnt == 1)
 		System.out.println("박수 짝");
 	else if (cnt == 0)
 		System.out.println("박수 없음");
  	} else {
  	System.out.println("숫자의 범위를 벗어났습니다.");
  	return;
  	}
 } 
		
/* 내가 쓴 답] 
int num = 0;
		
System.out.print("1 ~ 99 사이의 정수 입력: ");
num = sc.nextInt();
			
	if (num > 0 && num < 100) {
	}
	 	else {
			System.out.println("범위보고 다시 입력하세요.");
			return;
		}
		
		int chak = num / 10;
		int chakchak = num % 10;
		
			if (chak == 0 || chak == 1 || chak == 2 || chak == 4 || chak == 5 || chak == 7 || chak == 8) {
			 	if (chakchak == 3 || chakchak == 6 || chakchak == 9) {
			 		System.out.println("박수 짝");
			 	} else {
			 		System.out.println("박수 X");{
			 		}
			 	}
			} else if ((chak == 3 || chak == 6|| chak == 9) && (chakchak == 3) || (chakchak == 6) || (chakchak == 9))  {
				System.out.println("박수 짝짝");
			} else if (chak == 3 || chak == 6 || chak == 9) {
				System.out.println("박수 짝");
			} else if (chakchak == 3 || chakchak == 6 || chakchak == 9)
				System.out.println("박수 짝");
				}		
	}
 */
