package com.operex;

/*
산술 연산자 = > +, -, *, /, %
byte, short, char, int 사이의 연산 결과는 int형 
   
long, float, double 사이의 연산 결과는 큰 자료형으로 결정됨
*/

public class OperEx02 {

	public static void main(String[] args) {
		
	short a, b;
		
	a = 10;
	b = 10;  // a = b = 10;
	
	int c = a + b;  // 같은 자료형이 더해지면 결과는 int (short랑 short랑 더했다고 short가 되는게 아님)
	System.out.println("c의 값은: " + c);
	}
}
