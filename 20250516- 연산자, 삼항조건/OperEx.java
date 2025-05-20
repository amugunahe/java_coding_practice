package com.operex;

public class OperEx {

	public static void main(String[] args) {
		int x= 10;
		
		int y= ++x; // 선연산 후대입
		//x++ // 선대입 후연산
		System.out.println("x:" + x);
		System.out.println("y:" + y);
	}

}
