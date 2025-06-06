package com.condition;

/* 문] 사용자로부터 임의의 년도를 입력받아 
 입력받은 년도가 윤년인지 평년인지를 판정하는 프로그램을 구현하시오.
  
 윤년의 판정 조건 
 년도가 4의 배수이면서 100의 배수가 아니거나, 400의 배수이면 윤년
 그렇지 않으면 평년 
 */

import java.util.*;

public class IfEx04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int year;
		
		System.out.print("연도 입력: ");
		year = sc.nextInt();
		
	if(year % 4 == 0 && year % 100 != 0) {
		System.out.println(year + "는 윤년입니다.");
	} else {
		if(year % 400 == 0) {
			System.out.println(year + "는 윤년입니다.");
		} else {
			System.out.println(year + "는 평년입니다.");
			}
		}
	}
}

	/* if(year % 4 == 0) { 
		  	if(year % 100 != 0) { 
		 		System.out.println(year + "은 윤년 입니다."); 
		 	} else { 
		          	if(year % 400 == 0) { 
		         		System.out.println(year + "은 윤년입니다."); 
	     			} else {
		         		System.out.println(year + "은 평년입니다."); 
	     				}
		 	} else { 
		  		System.out.println(year + "은 평년 입니다."); 
      				}
 */

/* if 연산자 
   if(year % 4 ==0 && year % 100 !=0 || (year % 400 == 0)) {
 	System.out.println(year + " ==> 윤년");
 	} else {
	System.out.println(year + " ==> 평년");

삼항 연산자
str = ((year % 4 == 0 && year % 100 !=0)||(year % 400 == 0))? "윤년" : "평년"
*/
