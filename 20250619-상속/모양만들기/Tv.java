package com.inher;

public class Tv { // Tv 객체 -> 설계도, 틀

	boolean power; // TV의 전원 상태 (true: 켜짐, false: 꺼짐)
	int channel;   // TV의 현재 채널 번호

	// 전원 켜고 끄는 메서드
	void power() {
		power = !power; // 현재 전원 상태를 반대로 바꾼다 (켜져 있으면 끄고, 꺼져 있으면 켠다)
	}

	// 채널을 한 칸 올리는 메서드
	void channelUp() {
		++channel; // 현재 채널 번호를 1 증가시킨다
	}

	// 채널을 한 칸 내리는 메서드
	void channelDown() {
		--channel; // 현재 채널 번호를 1 감소시킨다
	}

}