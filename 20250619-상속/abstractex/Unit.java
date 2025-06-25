package com.abstractex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  Tank 클래스: **존나 강력한 탱크 유닛!** (Unit의 자식!)
 
  핵심:
  - **'Unit'이라는 부모 클래스를 상속받는다.** 이게 존나 중요하다! (Unit의 모든 속성/메소드 물려받음)
  - **`move()`라는 추상 메소드를 지만의 방식으로 구현(오버라이딩)한다!** (탱크는 "x, y 좌표 찍어주는" 방식으로 움직인다!)
  - **`changeMode()`라는 탱크 고유의 기능**도 가지고 있다. (시즈 모드 같은 거겠지, 씨발!)
 */

public class Tank extends Unit{ // 이제 'Unit'을 제대로 상속받고 있다, 씨발!
	
	void changeMode() {} // 탱크 고유의 기능. (모드 전환 같은 거겠지!)
	
	// ★★★ 존나 중요! 'move()' 메소드 재정의(Override)! ★★★
	// 부모 'Unit'의 추상 메소드인 'move()'를 여기서 구현하는 거다.
	// 탱크는 그냥 "x, y 좌표"를 출력하면서 움직인다고 표현한 거다!
	@Override
	void move(int x, int y) {
		System.out.println("x:" + x + ",y:" + y); // 탱크가 (x, y)로 이동했다고 출력!
	}
}
