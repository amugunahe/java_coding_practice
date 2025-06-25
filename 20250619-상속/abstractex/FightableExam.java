package com.abstractex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  FightableExam 클래스: **싸울 수 있는 유닛을 위한 설계도!**
 
  핵심:
  - 이 새끼는 **'Unit'이라는 클래스를 상속받고, 'Movable'이랑 'Attackable' 인터페이스를 구현한다.**
  - **`Unit`에서 물려받은 `move()`랑 `attackable` 인터페이스에서 물려받은 `attack()` 추상 메소드들을 반드시 구현해야 한다!**
  (이전에 `Fightable` 인터페이스에서 `default`로 구현했던 것들을, 여기서는 구체적인 클래스로서 구현하는 거다!)
 */

public class FightableExam extends Unit implements Movable, Attackable {
// ★★★ 존나 중요! 'extends Unit'으로 'Unit' 클래스를 상속받고, ★★★
// ★★★ 'implements Movable, Attackable'으로 두 인터페이스를 구현한다! ★★★
// (인터페이스는 'extends'로 상속받는 게 아니라 'implements'로 '구현'하는 거다)

	// ★★★ 존나 중요! 'attack()' 메소드 구현! ★★★
	// 'Attackable' 인터페이스의 추상 메소드를 여기서 구현하는 거다.
	@Override
	public void attack(Unit u) {
		// ★★★ 이 메소드 안에 '공격'하는 구체적인 코드를 넣어라 ★★★
		System.out.println("유닛이 " + u.getName() + "를 존나게 공격합니다!");
	}
	
	// ★★★ 존나 중요! 'move()' 메소드 구현! ★★★
	// 'Unit' 추상 클래스의 'move()' 추상 메소드를 여기서 구현하는 거다.
	// 또는 'Movable' 인터페이스의 추상 메소드를 여기서 구현하는 거다.
	@Override
	public void move(int x, int y) {
		// ★★★ 이 메소드 안에 '이동'하는 구체적인 코드를 넣어라 ★★★
		System.out.println("유닛이 (" + x + ", " + y + ") 위치로 존나게 이동합니다!");
	}
}
