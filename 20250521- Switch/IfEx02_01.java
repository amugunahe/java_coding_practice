package com.condition;

/*문]
 * 사용자로부터 임의의 정수를 입력받아 
 * 입력받은 정수가 짝수인지 홀수인지를 판정하는 프로그램
 * 
 * 삼항 연산자를 이용하여 계산하셈
 *
 */
import java.io.*;
public class IfEx02_01 {

	public static void main(String[] args) throws IOException {
		// BufferedReader 객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//주요 변수를 선언
		int n;  //사용자로부터 입력받은 정수를 저장할 변수
		String str;  //홀수인지 짝수인지 대한 판결에 대한 결과를 저장하는 변수
		
		/* 연산 및 처리 
		 * 1. 안내 메시지 출력 */
		System.out.print("정수 입력:");
		n= Integer.parseInt(br.readLine());
		
		
		//홀수인지 짝수인지를 판정
		if(n%2 == 0) {
			str= "짝수"; 
		}else {
			str= "홀수";
		}
		System.out.println(n+ "==> "+ str);
		
	}

}
