package com.condition;

 /* 
 * 삼항 연산자를 이용하여 계산하셈
 */

import java.io.*;

public class IfEx02_02 {

	public static void main(String[] args) throws IOException { // BufferedReader 객체 생성
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // 주요 변수를 선언
		
		int n;  // 사용자로부터 입력받은 정수를 저장할 변수
		String str;  // 홀수인지 짝수인지 대한 판결에 대한 결과를 저장하는 변수
		
		System.out.print("정수 입력: ");
		n= Integer.parseInt(br.readLine());
		
		str= n % 2 == 0? "짝수" : "홀수";
		System.out.println(n + " ==> " + str);
	}
}
