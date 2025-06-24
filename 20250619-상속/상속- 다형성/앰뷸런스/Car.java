package com.polymorphism; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  Car 클래스: 모든 '차'들의 **존나 중요한 부모 클래스!**
 
  핵심:
  - **모든 차가 공통으로 가져야 할 것들을 여기다 정의한다.** (색깔, 문 개수 같은 속성)
  - **모든 차가 공통으로 할 수 있는 행동들도 여기다 정의한다.** (운전, 멈추기 같은 메소드)
  - ★★★★★ 이게 바로 '다형성'의 **업캐스팅 기반**이다! ★★★★★
  (자식 차 객체들을 'Car' 타입으로 한 방에 묶어서 다룰 수 있게 해준다.)
 */

public class Car {

	String color; // 차의 색깔.
	int door;     // 차의 문 개수.

	// 차를 운전하는 메소드.
	void drive() {
		System.out.println("drive,~~~~~");
	}

	// 차를 멈추는 메소드.
	void stop(){
		System.out.println("hoho");
	}
}
