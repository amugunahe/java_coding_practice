package com.inher; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  Tv 클래스: 모든 텔레비전의 **존나 중요한 설계도!**
 
  핵심:
  - TV가 가져야 할 기본적인 속성(전원, 채널)이랑
  - TV가 할 수 있는 기본적인 행동(전원 켜고 끄고, 채널 돌리는 거)을 정의한다.
 */

public class Tv { // 'Tv'라는 이름의 설계도를 만드는 부분이다. 이걸로 실제 TV를 존나게 찍어낼 거다.

	boolean power; // TV 전원 상태 (true: 켜짐, false: 꺼짐)
	int channel;   // TV 현재 채널 번호

	// --- TV 기능들 ---

	// TV 전원을 켜고 끄는 메소드. (토글 기능: 켜져 있으면 끄고, 꺼져 있으면 켠다!)
	void power() {
		power = !power; // 'power' 값을 존나게 반대로 바꿔버린다!
	}

	// 채널을 1씩 올리는 메소드.
	void channelUp() {
		++channel; // 채널 값 1 증가!
	}

	// 채널을 1씩 내리는 메소드.
	void channelDown() {
		--channel; // 채널 값 1 감소!
	}

}
