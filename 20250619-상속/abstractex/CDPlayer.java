package com.abstractex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  CDPlayer 클래스: **CD를 재생하는 CD 플레이어!** (Player의 자식!)
 
  핵심:
  - **'Player'라는 부모 클래스를 상속받는다.** (Player의 모든 속성/메소드 물려받음)
  - 부모 'Player'에 있는 **`play()`랑 `stop()` 추상 메소드들을 지만의 방식으로 구현(오버라이딩)한다!**
  (근데 씨발, 구현 내용이 비어있다! 이거 고쳐야 한다!)
  - **CD 플레이어 고유의 트랙 관리 기능(`currentTrack`, `nextTrack()`, `preTrack()`)을 가진다.**
 */

public class CDPlayer extends Player {

	// ★★★ 존나 중요! 'play()' 메소드 재정의(Override)! ★★★
	// 부모 'Player'의 'play()' 추상 메소드를 여기서 구현한다.
	@Override
	void play(int pos) {
		// CD 플레이어가 노래를 재생했을 때 어떤 동작을 할지 코드를 써줘야 한다!
		System.out.println("CD가 " + pos + " 위치부터 재생 시작!"); // 예시로 재생 시작했다고 출력하도록 추가함.
	}
	
	// ★★★ 존나 중요! 'stop()' 메소드 재정의(Override)! ★★★
	// 부모 'Player'의 'stop()' 추상 메소드를 여기서 구현한다.
	@Override
	void stop() {
		// CD 플레이어가 노래를 멈췄을 때 어떤 동작을 할지 코드를 써줘야 한다!
		System.out.println("CD 재생 멈춤!"); // 예시로 재생 멈췄다고 출력하도록 추가함.
	}
	
	int currentTrack = 1; // ★★★ 중요! 현재 트랙 번호. 기본적으로 1번 트랙부터 시작한다고 가정한다! ★★★
	
	// 다음 트랙으로 이동하는 메소드.
	void nextTrack() {
		currentTrack++; // 트랙 번호 1 증가!
		System.out.println("다음 트랙 (" + currentTrack + ")으로 이동!");
	}

	// 이전 트랙으로 이동하는 메소드.
	void preTrack() {
		if(currentTrack > 1) { // ★★★ 중요! 현재 트랙이 1보다 클 때만 감소시킨다! ★★★
			currentTrack--;    // 트랙 번호 1 감소!
			System.out.println("이전 트랙 (" + currentTrack + ")으로 이동!");
		} else {
			System.out.println("이미 첫 번째 트랙입니다!"); // 첫 트랙이면 더 이상 못 내려감.
		}
	}
}
