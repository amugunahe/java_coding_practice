package com.ioex;

/*문제 2) 문자 하나를 입력 받아 문자가 산술 연산자인지 아닌지를 판단하는 프로그램을 만드세요
 *       산술연산자: ('+ , - , *, /, %)
		 단, 모든 조건을 삼항연산자로 처리하시오.
*/
import java.io.*;

public class Test02 {
	
	public static void main(String[] args) throws IOException {
		char yon;
		boolean bool = false;
		
		System.out.print("산술 연산자 입력(+, -, *, /, %): ");
		yon = (char)System.in.read();
		
		bool = yon == '+' || yon == '-' || yon == '*' || yon == '/'
			|| yon == '%'? true : false; 	
		
		/* if(yon == '+' || yon == '-' || yon == '*' || yon == '/' || yon == '%')
		 * bool true;
		 * else
		 * bool false; 
		 */
		System.out.print(bool + "는 산술연산자" + (bool? "입" : "가 아닙") + "니다");

	}
}

