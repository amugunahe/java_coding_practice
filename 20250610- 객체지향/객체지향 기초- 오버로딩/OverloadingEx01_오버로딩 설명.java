package com.overex;

/* 오버로딩 (Overloading) 
 - 한 클래스 내에 같은 이름의 메소드를 여러개 정의하는 것을 의미함 
 하나의 메소드 이름으로 여러 기능을 구현하기 때문에 붙여진 이름임 
 
 오버로딩의 조건
 1. 메소드 이름이 같아야 한다.
 2. 매개변수의 개수 또는 자료명이 달라야한다. 
 
 	int add(int a, int b){}
 	long add(int x, int y)  // 매개변수가 같아서 안됨
 	
 	long add(long x, int y) // 이거는 됨 
 		 
 */

class FunctionEx {
	
	int add(int a, int b) {
		System.out.println("int, int");
		return a + b;
	}
	
	long add(int a, long b) {
		System.out.println("int, long");
		return a + b;
	}

	long add(long a, int b) {
		System.out.println("long, int");
		return a + b;
	}
	
	long add(long a, long b) {
		System.out.println("long, long");
		return a + b;
	}
	
	int add(int[] a) {
		
		int res = 0;
		for (int i = 0; i <a.length; i++) {
			res += a[i];
		}
		return res;
	}	
}

public class OverloadingEx01 {

	public static void main(String[] args) {
		
		// 메소드 호출
		FunctionEx fe = new FunctionEx();
		System.out.println(fe.add(3, 3));
		System.out.println(fe.add(3L, 3));
		System.out.println(fe.add(3, 3L));
		System.out.println(fe.add(3L, 3L));
		
		int[] a = {100, 200, 300};
		System.out.println(fe.add(a));	
	}
}
