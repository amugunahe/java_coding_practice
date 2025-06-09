package com.switchex;

import java.util.Scanner;

public class SwitchEX06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		 System.out.print("주민등록번호 전부 입력(123456-1234567): "); 
		 String jumin = sc.nextLine();
		 
		 char gender = jumin.charAt(7);

		 switch (gender) {
		 case '1': case '3':  // 남성 
			 switch (gender) {
			 case '1':
				 System.out.println("1900년대 출생한 남성입니다.");
				 break;
			 case '3':
				 System.out.println("2000년대 출생한 남성입니다.");
				 break;
				 }
			 break;
		  case '2': case '4':  // 여성
			 switch (gender) {
			 case '2':
				 System.out.println("1900년대 출생한 여성입니다.");
			 	 break;
			 case '4':
				 System.out.println("2000년대 출생한 여성입니다.");
				 break;
			 }
			 break;
		 }
	}
}
