package com.condition;

/*사용자로부터 알파벳 한문자를 입력받아

 소문자를 입력 받았을 경우 대문자로 바꾸시고,
 대문자를 입력 받았을경우 소문자로 바꾸는 프로그램을 작성하시오.
 
 단, 입력은 System.in.read() 메소드로 처리하시오
 */

import java.io.*;

public class IfEx11 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 변수 선언
		char ch;
		int n;
		
		// 연산 및 처리작업
		System.out.print("알파벳 입력: ");
		
		// 문자로 했을 경우: ch = (char)System.in.read();
		n = System.in.read();
		//System.out.println((char)(n-32));

		
		// 입력 받은 값이 대문자라면? (정수로 했을 경우)
		if(n >= 65 && n <= 90) {
			n += 32;  //n값을 32 증가시켜라
			System.out.println((char)(n));	
			
		} else if(n >=97 && n <= 122) { //입력값이 소문자라면
			n -= 32;  //n값을 32 감소시켜라
			System.out.println((char)(n));
		} else {
			System.out.println("입력 오류 입니다.");
		}
		
		/* if(ch >= 'A' && ch <= 'Z') { 
		  ch += 32;   // ch 값을 32 증가시켜라 
		  System.out.println(ch);
		  
		  } else if(ch >= 'a' && ch <= 'z') { // 입력값이 소문자라면 
		  ch -= 32;   // ch 값을 32 감소시켜라
		 System.out.println(ch); 
 		  } else { 
		 System.out.println("입력 오류 입니다."); 
		 return;
		  }
		 */
	}
}
