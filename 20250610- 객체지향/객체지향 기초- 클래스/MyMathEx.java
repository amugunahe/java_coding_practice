package com.objectex;


class MyMath {
	
	int add(int a, int b) // 선언부 
	{
		int result = a + b; // 구현부
			return result; 
	}
	
	int sub(int a, int b) // 선언부 
	{
		int result = a - b; // 구현부
			return result; 
	}
	
	int mul(int a, int b) // 선언부 
	{
		int result = a * b; // 구현부
			return result;
		
	}
		int div(int a, int b) // 선언부 
		{
			int result = a / b; // 구현부
				return result; 
		}
	}


public class MyMathEx {

	public static void main(String[] args) {
		
		MyMath mm= new MyMath();
		long r1 = mm.add(6, 7);
		long r2 = mm.sub(10, 2);
		long r3 = mm.mul(2, 3);
		long r4 = mm.div(10, 2);
		
		System.out.println(mm.add(6, 7));
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
		firstMethod();
	}
	
	static void firstMethod() {
		secondMethod();
	}
	
	static void secondMethod() {
		System.out.println("secondMethod()...");
	}
}
