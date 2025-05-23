package com.operex;

/*
 * 논리 연산자 &&(and), ||(or), !(not)
 * 
*/
public class OperEx04 {

	public static void main(String[] args) {
		
		boolean a;
		boolean b;
		
		if((a= 4>3)|(b= 5>7)) { 
	//a= true, b=false => true
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		}
		// 에러 원인: 초기화 되지 않음
		// a= true, b= false => true
	}		
}
