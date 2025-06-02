package com.condition;

import java.io.*;
public class IfEx07 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a, b; 
		char c;
		
		System.out.print("첫번째 정수 입력: ");
       		a= Integer.parseInt(br.readLine());
		
		System.out.print("연산자 입력:");
		c= (char)System.in.read();
		System.in.read();
		System.in.read();
		System.in.skip(2);
		
		System.out.println("두번째 정수 입력: ");
		b= Integer.parseInt(br.readLine());
		
		
		if(c== '+') {
			System.out.printf("%d + %d = %d", a, b, (a + b));
		} else if(c == '-') {
			System.out.printf("%d - %d = %d", a, b, (a - b));
		} else if(c == '*') {
			System.out.printf("%d * %d = %d", a, b, (a * b));
		} else if(c == '/') {
			System.out.printf("%d / %d = %d", a, b, (a /b));
		}
	}
}
