package com.abstractex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  Fightable 인터페이스: **존나게 중요한 '싸울 수 있는' 객체들의 설계도!**
 
  핵심:
  - **'interface' 키워드가 붙어서 이 새끼는 인터페이스다!** (객체 못 만든다, 씨발!)
  - **`Movable`이랑 `Attackable` 인터페이스를 `extends`로 상속받는다!**
  -> 이게 존나 중요하다! 인터페이스는 클래스랑 다르게 여러 개를 동시에 상속받을 수 있다!
  -> 즉, 이 `Fightable` 인터페이스를 구현하는 놈은 `Movable`의 기능, `Attackable`의 기능, 그리고 `Fightable`의 추가 기능까지 다 가져야 한다!
  - **`default` 메소드를 가지고 있다!**
  -> 이게 자바 8부터 추가된 존나 유용한 기능이다! 인터페이스 메소드에 **기본 구현을 제공할 수 있다!**
  -> 이 메소드를 구현하는 클래스가 따로 오버라이딩 안 하면 이 `default` 내용이 실행된다!
 */

public interface Fightable extends Movable, Attackable { // 'Movable'이랑 'Attackable' 인터페이스를 상속받는다!

	// ★★★ 존나 중요! 'attack()' 메소드 (default 구현)! ★★★
	// 'Attackable' 인터페이스에 'attack(Unit u)' 메소드가 있을 거다.
	// 여기서 `default` 키워드를 써서 기본적인 구현 내용을 제공한다.
	// 이걸 구현하는 클래스가 이 `attack()`을 따로 오버라이딩 안 하면 이 내용이 실행된다!
	
	@Override
	default void attack(Unit u) {
		// 기본적으로 어떻게 공격할지 여기에 코드를 써줘야 한다!
		System.out.println("기본 공격 동작: " + u.getName() + "를 공격!"); // 예시로 기본 공격 동작 추가함. (Unit에 getName() 있다고 가정)
	}

	// ★★★ 존나 중요! 'move()' 메소드 (default 구현)! ★★★
	// 'Movable' 인터페이스에 'move(int x, int y)' 메소드가 있을 거다.
	// 얘도 `default` 키워드를 써서 기본적인 구현 내용을 제공한다.
	@Override
	default void move (int x, int y) {
		// 기본적으로 어떻게 이동할지 여기에 코드를 써줘야 한다!
		System.out.println("기본 이동 동작: (" + x + ", " + y + ") 위치로 이동!"); // 예시로 기본 이동 동작 추가함.
	}
	
}
