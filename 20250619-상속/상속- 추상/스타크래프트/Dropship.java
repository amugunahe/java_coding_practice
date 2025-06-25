package com.abstractex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  Dropship 클래스: **유닛들을 태우고 내리는 드랍십 유닛!** (Unit의 자식이어야 한다!)
 
  핵심:
  - **'Unit'이라는 부모 클래스를 상속받아야 한다!** (그래야 Unit의 속성/메소드를 물려받지!)
  - **`move()`라는 추상 메소드를 지만의 방식으로 구현(오버라이딩)한다!**
  - **드랍십 고유의 기능(`load()`, `unload()`)을 가진다.** (유닛 태우고 내리는 거겠지, 씨발!)
 */

public class Dropship extends Unit { 


	/*
	  (이 주석 처리된 부분은 부모 'Unit' 클래스에서 물려받는 멤버들을 표시한 거다.
	  실제 코드에서는 이렇게 다시 선언할 필요 없다. 그냥 물려받아서 쓰면 된다!)
	  int x, y;
	  void move(int x, int y) {}
	  void stop() {}
	 */
	
	void load() {}   // 드랍십 고유의 기능. (유닛 태우는 거!)
	void unload() {} // 드랍십 고유의 기능. (유닛 내리는 거!)

	// ★★★ 존나 중요! 'move()' 메소드 재정의(Override)! ★★★
	// 부모 'Unit'의 추상 메소드인 'move()'를 여기서 구현하는 거다.
	@Override
	void move(int x, int y) {
		// 드랍십이 (x,y)로 이동했을 때 어떤 동작을 할지 코드를 써줘야 한다!
		System.out.println("드랍십이 x:" + x + ", y:" + y + " 위치로 날아갑니다!"); // 예시로 이동했다고 출력하도록 추가함.
	}
}
