package com.abstractex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  Attackable 인터페이스: **존나게 중요한 '공격 가능한' 객체들의 설계도!**
 
  핵심:
  - **'interface' 키워드가 붙어서 이 새끼는 인터페이스다!** (객체 못 만든다, 씨발!)
  - **`attack()`이라는 '추상 메소드'를 가지고 있다!**
  -> 이게 존나 중요하다! 인터페이스의 메소드는 무조건 'public abstract'가 자동으로 붙는다!
  -> 이 인터페이스를 'implements'하는 모든 클래스들은 이 `attack()` 메소드를 무조건 구현해야 한다! (공격하는 방식은 지들 맘대로!)
 */

public interface Attackable {

	// ★★★ 존나 중요! 인터페이스의 메소드는 무조건 'public abstract'가 자동으로 붙는다! ★★★
	// 내용이 없다. 그냥 선언만 돼 있다.
	// 이걸 'implements'하는 모든 클래스들은 **무조건 이 메소드를 지만의 방식으로 구현해야 한다!**
	void attack(Unit u); // 'Unit' 객체를 받아서 공격하는 추상 메소드.

}
