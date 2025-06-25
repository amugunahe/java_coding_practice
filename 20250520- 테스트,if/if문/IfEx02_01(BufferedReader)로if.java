package com.condition;

/* 문] 사용자로부터 임의의 정수를 입력받아 
 입력받은 정수가 짝수인지 홀수인지를 판정하는 프로그램
  
 삼항 연산자를 이용하여 계산하셈
 */

import java.io.*; // 입출력 기능을 위한 라이브러리 임포트

public class IfEx02_01 {

	public static void main(String[] args) throws IOException {
	
		// 키보드 입력 준비 (필수)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		// 사용할 변수 선언: n은 숫자, str은 결과를 담을 문자열
		int n;  
		String str;  
	
		System.out.print("정수 입력:"); // 사용자에게 입력 안내 메시지 출력
		// 사용자가 입력한 문자열을 정수(int)로 변환해서 n에 저장 (핵심)
		n= Integer.parseInt(br.readLine()); 
		
		
		// 홀짝 판별: n을 2로 나눈 나머지가 0이면 짝수, 아니면 홀수 (삼항 연산자 핵심)
		str = (n % 2 == 0) ? "짝수" : "홀수"; 
		
		// 최종 결과 출력 (입력받은 숫자 ==> 결과)
		System.out.println(n + "==> " + str);
	}
}
