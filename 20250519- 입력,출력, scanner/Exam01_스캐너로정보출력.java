package com.ioex;

import java.util.*;
public class Exam01 {
/* 문제 Scanner 클래스로 이름, 도시, 나이, 체중, 독신 여부를 입력받고 출력하는 프로그램을 구현하시오
 * 
 * 문자열: 이름, 도시
 * 정수: 나이
 * 실수: 체중
 * 논리(boolean): 독신여부
 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name, city;
		int age;
		double weight;
		boolean issingle; //boolean single = false;
		
		System.out.print("이름: ");
		name = sc.next();
		
		System.out.print("도시: ");
		city = sc.next();
		
		System.out.print("나이: ");
		age = sc.nextInt();
		
		System.out.print("체중: ");
		weight = sc.nextDouble();
		
		System.out.print("독신 (true/false): ");
		issingle = sc.nextBoolean();
		
		System.out.println("이름은 " + name + ", 도시는 " + city + " , 나이는 " + age + ", 체중은 "
		+ weight + ", 독신 여부는 " + issingle + " 입니다." );
		/*
		 * System.out.println("나의 이름은 "+ name + "이고 \n 거주지는" + city+ "이며 \n 나이는 "age + "이고
		 * \n" + weight + "kg이고 + "독신 여부는 " + isSingle + " 입니다.");
		 */	
	}

}
