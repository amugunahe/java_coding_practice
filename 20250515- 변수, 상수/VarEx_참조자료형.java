package com.variable; // 야, 이 코드가 여기 산다. 주소 박아놨으니까 딴 데서 헤매지 마라.

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
*/ // 변수, 상수, 자료형 개념이랑 기본 자료형 8가지, 참조 자료형이 뭔지 설명해놨다. 대충 읽고 넘어가도 됨.

class AA { // AA라는 새로운 클래스(설계도) 하나 만들었다.
	int a; // 이 AA 설계도로 만든 놈들 안에는 'a'라는 int(정수) 변수 하나씩 박혀있다.
}

public class VarEx { // 야, VarEx 이름으로 프로그램 시작한다. 이 파일 이름이랑 똑같으니까 틀리면 뒤진다.

	public static void main(String[] args) { // 여기가 진짜 시작점이다. 무조건 여기부터 실행된다고 보면 됨.

	AA a; // AA 클래스 타입의 'a'라는 변수 만들었다. (아직 실체는 없음)
	a = new AA(); // AA 설계도로 진짜 'AA' 놈을 만들고, 그 놈 주소를 변수 'a'에 박아 넣었다.
	a.a = 10; // 'a' 놈 안에 있는 변수 'a' (int 타입)에 '10'을 저장했다.

	int[]aa = new int[3]; // int(정수) 데이터 3개 넣을 수 있는 'aa'라는 배열(칸막이) 만들었다.
	aa[0] = 10; // 배열의 첫 번째 칸(0번째)에 10 박아 넣었다.
	aa[1] = 10; // 배열의 두 번째 칸(1번째)에 10 박아 넣었다.
	aa[2] = 10; // 배열의 세 번째 칸(2번째)에 10 박아 넣었다.

	for (int i = 0; i < aa.length; i++) { // 배열의 각 칸을 순서대로 돌면서 반복해라.
		// i는 0부터 시작해서 배열 길이(aa.length)보다 작을 때까지 1씩 증가한다.
		System.out.println(aa[i]); // 지금 돌고 있는 배열 칸(aa[i])에 뭐 들어있는지 화면에 보여준다.
		}
	}
}
