package com.objectex;

class Data {int x;} // Data d;

public class ReferenceParamEx01 {

	static void change(Data d) { // Data d: 참조형 매개변수
		
		d.x = 1000;
		
		System.out.println("change() : x =>" + d.x);
	}
	
	public static void main(String[] args) {
		
		Data d = new Data();
		
		d.x = 10;
		
		System.out.println("main(): x =>" + d.x);
		// change() 메소드가 호출되면서 d.x가 change 메소드의 매개변수 x에 복사됨 
		
		change(d);  // change 메소드에 x의 값을 1000으로 변경 
		
		System.out.println("main(): x =>" + d.x); 
		// change 메소드가 종료되면서 매개변수 x는 종료하게 됨 
	
	}
}
