package com.interexam;

public class AirUnit extends Unit{ // 공중 유닛 (Unit을 상속받음)

	public AirUnit(int hp) {
		super(hp); // 부모 클래스(Unit)의 생성자 호출!
	}
	
    // ★★★ Unit 클래스에 추상 메소드 move()를 추가했으므로, ★★★
    // ★★★ AirUnit도 move()를 구현해야 한다. ★★★
    // 아니면 AirUnit도 abstract 클래스가 되어야 한다.
    // 여기서는 AirUnit도 abstract로 선언해서 move() 구현을 미룬다.
    @Override
    public void move(int x, int y) {
        // 공중 유닛의 공통적인 이동 로직 (구현은 하위 클래스에 위임할 수도 있음)
        System.out.println("공중 유닛이 x:" + x + ", y:" + y + " 위치로 날아갑니다.");
    }
}