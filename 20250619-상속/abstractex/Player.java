package com.abstractex;

public abstract class Player { 
	// 추상화: 클래스간에 공통점을 찾아내서 공통의 조상 클래스 모드는 작업
	// 변수 선언 
	boolean pause; // 일시 정지 상태를 저장하는 변수 
	int currentPos; // 현재 play되고 있는 위치를 저장하는 변수
	
	public Player() {
		
		pause = false;
		currentPos = 0;
		
	}
	
	abstract void play(int pos);
	abstract void stop();

	void play() {
		play(currentPos); // 추상 메소드를 사용할 수 있다.
	}
	
	void pause() {
		if(pause) {  // pause가 true일때 (정지상태)에서 pause가 호출되면 
			pause = false; // pause의 상태를 false로 바꾸고, 
			play(currentPos); // 현재 위치에서 play를 한다.
		} else { // pause가 false일때 (play상태)에서 pause가 호출되면 
			pause = true; // pause 상태를 true로 바꾸고,
			stop(); // play를 멈춘다.
		}
		
	}
}
