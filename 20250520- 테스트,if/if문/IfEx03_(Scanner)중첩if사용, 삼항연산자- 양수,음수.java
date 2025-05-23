package com.condition;

/* 문] 중첩 if를 사용 
 *   사용자로부터 임의의 정수를 입력받아 입력받은 정수가 양수인지, 음수인지, 0인지를 
 *   판정하는 프로그램을 구현하시오. 
 *  
 *  단, scanner 클래스로 
 *  또한 조건 삼항연산자도 구현하시오.
 */
import java.util.*;

public class IfEx03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);  
									    /*int n;
		           String str;
		                                  System.out.print("정수 입력: ");
		                                  n= sc.nextInt(); */
		int userInput= sc.nextInt(); 
		String str;
		
		//중첩 if
		if(userInput!=0) {
			if(userInput>0) {
				System.out.println(userInput + "은 양수입니다.");
			}else {
				System.out.println(userInput+ "은 음수입니다.");
			}
		} else {
			System.out.println(userInput+ "은 0입니다.");
		}
	}
     /* 삼항 연산자
	 str= (n<0)? "음수":((n===0)? "0": "양수");*/
	
	/* if(n ==0)
	   str = "영"
	  else if(n<0)
	   str= "음수"
	  else 
	   str= "양수"
	   System.out.println("n +"==>" + str);
	 */
}