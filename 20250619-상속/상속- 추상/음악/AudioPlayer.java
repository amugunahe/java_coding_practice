package com.abstractex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  AudioPlayer 클래스: **노래를 재생하는 오디오 플레이어!** (Player의 자식!)
 
  핵심:
  - **'Player'라는 부모 클래스를 상속받는다.** (Player의 모든 속성/메소드 물려받음)
  - 부모 'Player'에 있는 **`play()`랑 `stop()` 추상 메소드들을 지만의 방식으로 구현(오버라이딩)한다!**
  (이 새끼는 노래를 재생하고 멈추는 구체적인 동작을 한다!)
 */

public class AudioPlayer extends Player {
// 구체화: 상속을 통해 클래스를 구현한다. 또는 확장하는 작업을 의미함

	// ★★★ 존나 중요! 'play()' 메소드 재정의(Override)! ★★★
	// 부모 'Player'의 'play()' 추상 메소드를 여기서 구현한다.
	// 오디오 플레이어는 이 메소드가 호출되면 "노래야 돌려라~~~"라고 외치면서 재생하는 거다!

	@Override
	void play(int pos) {
		System.out.println("노래야 돌려라~~~"); // 노래 재생 시작!
	}

	// ★★★ 존나 중요! 'stop()' 메소드 재정의(Override)! ★★★
	// 부모 'Player'의 'stop()' 추상 메소드를 여기서 구현한다.
	// 오디오 플레이어는 이 메소드가 호출되면 "노래야 멈춰라~~~"라고 외치면서 멈춘다!
	
	@Override
	void stop() {
		System.out.println("노래야 멈춰라~~~"); // 노래 재생 멈춤!
	}
	
}
