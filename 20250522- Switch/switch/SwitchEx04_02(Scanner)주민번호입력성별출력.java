package com.switchex;

import java.util. *;
public class SwitchEx04_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 System.out.print("주민등록번호 전부 입력(123456-1234567): "); 
		 String jumin = sc.nextLine();
		 
		 char gender = jumin.charAt(7);
		 System.out.println(gender);
	}
}
