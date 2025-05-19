package com.operex;

/*복합대입연산자, 복합 연산자, 배정연산자
 * +=, -=, ....  a= a+b => a+=b
 *  
 */


public class OperEx06 {
	public static void main(String[] args) {
			int a=10;
			int result= 0;
			
			result += a;
			System.out.println("result:"+ result);  //10
			
			result *= a;
			System.out.println("result:" + result); //100
			result -= a;
			System.out.println("result:" + result);
			result /= a;
			System.out.println("result:"+ result);
			result %= a;
			System.out.println("result:" + result);
			
	}
}
