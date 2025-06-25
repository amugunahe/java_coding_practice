package com.abstractex;

public class AudioPlayer extends Player{
// 구체화: 상속을 통해 클래스를 구현한다. 또는 확장하는 작업을 의미함
	@Override
	void play(int pos) {
		System.out.println("노래야 돌려라~~~");
		
	}

	@Override
	void stop() {
		System.out.println("노래야 멈춰라~~~");
	}
}
