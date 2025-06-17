package com.functionex;

public class Div {
	private int a;
	private int b;
	
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int calculate() {
		
		int res = 0;
		
		try { 
			res = a / b;
		} catch (ArithmeticException a) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		return res;
	}	
}

