package com.variable; // 이 코드가 속한 폴더(패키지)를 나타내요.

/* 변수와 상수의 개념
변수: 상수를 저장하거나 보관하는 공간(메모리)
상수: 항상 동일한 의미의 가치를 가지는 개체
변수명: 변수에 대한 특정 이름
자료형: 변수의 크기를 미리 만들어 놓은 크기의 약속

기본 자료형과 참조 자료형
기본 자료형
자바 컴파일러에 의해서 해석되는 자료형
기본 자료형: 8개(byte, short, int, long, float, double, boolean, char)
글자 => 1byte, 2byte (boolean, char)
정수 => 1byte, 2byte, 4byte, 8byte(byte, short, int, long)
실수 => 4byte, 8byte(float, double)

참조 자료형(reference data type)
- 자바 API(Application programming interface)에서 제공 되거나,
프로그래머에 의해서 만들어진 클래스를 자료형으로 선언하는 경우
*/

class AA { // 'AA'라는 이름의 새로운 클래스를 정의해요.
	int a; // 'AA' 클래스 안에 'a'라는 이름의 'int' 타입 변수를 선언해요.
}

public class VarEx { // 'VarEx'라는 이름의 프로그램을 시작해요.

	public static void main(String[] args) { // 프로그램이 실제로 시작되는 부분이에요.

	AA a; // 'AA' 클래스 타입의 변수 'a'를 선언해요. (아직 객체는 만들어지지 않음)
	a = new AA(); // 'AA' 클래스의 실제 객체를 만들고 그 주소를 변수 'a'에 저장해요.
	a.a = 10; // 'a' 객체 안에 있는 변수 'a' (int 타입)에 '10'을 저장해요.
	
	int[]aa = new int[3]; // 'int' 타입의 데이터를 3개 저장할 수 있는 배열 'aa'를 만들어요.
	aa[0] = 10; // 배열의 첫 번째 칸(인덱스 0)에 10을 저장해요.
	aa[1] = 10; // 배열의 두 번째 칸(인덱스 1)에 10을 저장해요.
	aa[2] = 10; // 배열의 세 번째 칸(인덱스 2)에 10을 저장해요.
	
	for (int i = 0; i < aa.length; i++) { // 배열의 각 칸을 순서대로 방문하며 반복해요.
		System.out.println(aa[i]); // 현재 방문 중인 배열의 칸에 저장된 값을 화면에 보여줘요.
		}
	}
}
