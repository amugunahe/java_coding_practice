package com.switchex;

/* 문] 주민등록번호 7번째 자리를 입력받아 년도와 성별을 출력하는 프로그램을 구현하시오.
switch~case문 활용
 
90 -> 1800
12 -> 1900
34 -> 2000
*/

import java.io.*;

public class SwitchEx04_01 {

	public static void main(String[] args) throws IOException {
	
	System.out.print("주민등록번호 7번째 자리 입력: ");
	int x = System.in.read()-48;
	
	int year = 0;
	String gender = " ";
	
	switch(x) {
	case 9 : case 0:
	year = 1800;
	break;
	case 1 : case 2:
	year = 1900;
	break;
	case 3 : case 4:
	year = 2000;
	break;
	default:
	System.out.println("잘못 입력하셨습니다.");
	System.exit(-1); //return;
	}
	gender = (x % 2 == 0)? "여성" : "남성";
				
	System.out.println("당신은 " + year + "년대생 " + gender + " 입니다.");
	}	
}
