package com.ioex;

import java.io.*;

public class inputEx03 {
 
	public static void main(String[] args) throws IOException {
	
	int num1, num2;
		
	System.out.print("첫번째 숫자: ");
	num1 = System.in.read()-'0';
		
	/*System.in.read();  // \r-> 아스키 코드값 13
	System.in.read();  // \n:개행
	*/
		
	System.in.skip(2);
		
	System.out.print("두번째 숫자 :");
	
	num2 = System.in.read()-48;   // 아스키 코드 값에서 '-48'을 빼거나 '0'을 하면 정상값이 출력된다 (*공식

	System.out.println(num1);
	System.out.println(num2);
	}
}
