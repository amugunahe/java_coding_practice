package com.operex;

/* 삼항 조건 연산자 -> 삼항연산자
 * 조건항 ? 항1(true): 항2(false)
*/
public class OperEx05 {

	public static void main(String[] args) {

		int a = 20, b = 30, max;
		max = a > b ? ++a : ++b;

		System.out.println("max:" + max);
		System.out.println("a:" + a);
		System.out.println("b:" + b);

	}

}
