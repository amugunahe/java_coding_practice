package com.variable; // 이 코드가 속한 폴더(패키지)를 나타내요.

/* byte: 1byte 자료형
범위: 256 => -128~ 127
*/ // 여기에 이 코드에 대한 설명이 적혀있어요.

public class ByteEx { // 'ByteEx'라는 이름의 프로그램을 시작해요.

	public static void main(String[] args) { // 프로그램이 실제로 시작되는 부분이에요.
		
		byte bb = 127; // 'bb'라는 이름의 'byte' 타입 변수를 만들고 '127' 값을 넣어줘요.
		int a; // 'a'라는 이름의 'int' 타입 변수를 선언만 해요 (아직 값을 넣지 않음).
		
		a = (int)(bb + 1); // 'bb'에 1을 더한 값을 'int' 타입으로 변환해서 'a'에 넣어줘요.
		System.out.println("a = " + a); // 'a' 변수에 저장된 값을 화면에 보여줘요.
	}
}
