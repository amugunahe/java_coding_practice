package com.abstractex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  Marine 클래스: **존나 용감한 마린 유닛!** (Unit의 자식!)
 
  핵심:
  - **'Unit'이라는 부모 클래스를 상속받는다.** (Unit의 모든 속성/메소드 물려받음)
  - **`move()`라는 추상 메소드를 지만의 방식으로 구현(오버라이딩)한다!**
  - **`stimPack()`이라는 마린 고유의 기능**도 가지고 있다. (스팀팩 빨고 돌진하는 거겠지, 씨발!)
 */

public class Marine extends Unit {
	/*
	  (이 주석 처리된 부분은 부모 'Unit' 클래스에서 물려받는 멤버들을 표시한 거다.
	  실제 코드에서는 이렇게 다시 선언할 필요 없다. 그냥 물려받아서 쓰면 된다!)
	  int x, y; // x, y 좌표는 Unit에서 물려받는다.
	  void move(int x, int y) {} // move 메소드도 Unit에서 물려받고 여기서 재정의(override)해야 한다.
	  void stop() {} // stop 메소드도 Unit에서 물려받는다.
	 */
	
	void stimPack() {} // 마린 고유의 기능. (스팀팩 빠는 거!)
	
	// ★★★ 존나 중요! 'move()' 메소드 재정의(Override)! ★★★
	// 부모 'Unit'의 추상 메소드인 'move()'를 여기서 구현하는 거다.
	@Override
	void move(int x, int y) {
		System.out.println("마린이 x:" + x + ", y:" + y + " 위치로 이동!"); 
	}
}