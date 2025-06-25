package com.condition;

/* * 삼항 연산자를 이용하여 계산하셈
 */

import java.io.*; // 입출력 기능 쓰려면 이거 필수

public class IfEx02_02 {

	public static void main(String[] args) throws IOException { 
		// 키보드 입력 받을 준비 (이거 없으면 입력 못 받음)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		// 변수 두 개 선언: n은 숫자, str은 결과를 저장할 문자열
		int n;  
		String str;  
		
		System.out.print("정수 입력: "); // 사용자한테 숫자 입력하라고 알려줌
		// 입력받은 문자열을 숫자로 바꿔서 n에 저장 (이거 중요!)
		n= Integer.parseInt(br.readLine()); 
		
		// 삼항 연산자 써서 홀짝 판별하고 str에 결과 저장 (개핵심!)
		str = n % 2 == 0 ? "짝수" : "홀수"; 
		
		System.out.println(n + " ==> " + str); // 최종 결과 출력
	}
}
