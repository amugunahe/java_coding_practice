package com.polymorphism; // 이 클래스가 속한 패키지다.

/*
  Car 클래스: 모든 차들의 '부모' 클래스.
 
 *핵심:
 - 모든 차들이 공통으로 가질 속성 (색깔, 문 개수)이랑
  - 공통으로 할 수 있는 행동 (운전, 멈추기)을 정의한다.
  - 이게 다형성에서 '업캐스팅'의 기반이 된다. (자식 객체를 부모 타입으로 다룰 수 있게 해줌)
 */

public class Car {

	String color; // 차의 색깔 (속성)
	int door;     // 차의 문 개수 (속성)

	// 차를 운전하는 행동 (메소드)
	void drive() {
		System.out.println("drive,~~~~~");
	}

	// 차를 멈추는 행동 (메소드)
	void stop(){
		System.out.println("hoho");
	}
}

