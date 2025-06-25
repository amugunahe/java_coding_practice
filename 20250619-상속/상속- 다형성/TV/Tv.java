package com.polymorphism; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  다형성(Polymorphism): **존나 여러 가지 형태로 변신할 수 있는 능력!**
 
  핵심:
  - 자바에서는 '부모 클래스' 타입 변수로 '자식 클래스' 객체들을 다룰 수 있게 해준다.
  - 이게 왜 중요하냐면, 코드 **유연성, 재사용성, 확장성**을 존나게 높여주기 때문이다!
  - 마치 '탈 것'이라는 큰 이름으로 '자동차', '자전거' 등 모든 걸 한 방에 묶어서 다루는 것과 같다.
 */

public class Tv { // 'Tv' 클래스: 모든 텔레비전의 **존나 중요한 부모 설계도!**

	boolean power; // TV 전원 상태 (true: 켜짐, false: 꺼짐)
	int channel;   // 현재 채널 번호

	// TV 전원을 켜고 끄는 메소드. (토글 기능: 켜져 있으면 끄고, 꺼져 있으면 켠다!)
	void power() {
		power = !power;
	}

	// 채널을 한 칸 올리는 메소드.
	void channelUp() {
		++channel;
	}

	// 채널을 한 칸 내리는 메소드.
	void channelDown() {
		--channel;
	}
}
