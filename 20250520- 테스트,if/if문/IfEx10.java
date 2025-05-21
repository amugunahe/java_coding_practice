package com.condition;

/* 사용자로부터 알파벳 한 문자를 입력받아 
 * 입력받은 알파벳이 모음일 경우만 출력하는 프로그램을 구현하시오. 
 * 
 * 단, 대소문자 모두를 적용하도록 한다.
 * 또한 알파벳 이외의 문자가 입력되면, 입력 오류를 출력한다.
 * 
 * 문자 입력: A
 * 모음 O
 *
 * 문자 입력: B
 * 모음 X
 * 
 * 문자 입력: 1
 * 입력 오류
 *  
 */


import java.util.*;
public class IfEx10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		char ch;
		
		System.out.print("알파벳 입력:" );
		ch= sc.next().charAt(0);
		if((ch>='a' && ch<='z')||(ch>='A' && ch<='Z'))
		{ /*
			if((ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch== 'u') || (ch=='A' || ch=='E' ||  ch=='I' ||  ch=='O' ||  ch== 'U'))
				System.out.print("모음 O");
			*/
			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch== 'u'){
				System.out.print("모음 O");
			}else if(ch=='A' || ch=='E' || ch=='I' ||  ch=='O' ||  ch== 'U'){
				System.out.println("모음 O");
			}else { 
				return;
		}
			
		}else {
			System.out.print("입력 오류");
		}
		
	}
}

