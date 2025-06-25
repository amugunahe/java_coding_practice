package com.interexam;

import java.lang.Math; // Math 클래스를 사용하기 위해 import (Math.min 사용)

public class Tank extends GroupUnit implements Repair { // Tank는 GroupUnit(지상 유닛)의 자식이고, Repair 인터페이스를 구현한다!

	public Tank(int hp) { // 탱크의 초기 체력을 hp로 받는다. (보통 150)
		// ★★★ 중요! 부모 클래스 GroupUnit의 생성자 호출! ★★★
		// Unit 생성자에서 hitPoint도 MAX_HP로 초기화해주므로 `hitPoint = MAX_HP;`는 필요 없다!
		super(hp); // Tank의 체력을 설정.
	}
	
	@Override
	public String toString() {
		return "Tank"; // Tank 객체를 문자열로 나타낼 때 "Tank"라고 반환한다.
	}
	
    // ★★★ Repair 인터페이스에 정의된 메소드들을 구현한다! (존나 중요!) ★★★

    @Override
    public int getCurrentHP() {
        return hitPoint; // 현재 체력(Unit의 멤버 변수)을 반환한다.
    }

    @Override
    public int getMaxHP() {
        return MAX_HP; // 최대 체력(Unit의 멤버 변수)을 반환한다.
    }

    @Override
    public void beRepaired(int amount) {
        // 'amount'만큼 체력을 회복시킨다.
        // Math.min(MAX_HP, hitPoint + amount)를 사용해서 최대 체력을 넘지 않도록 한다.
        this.hitPoint = Math.min(this.MAX_HP, this.hitPoint + amount);
        System.out.println(this.getName() + "가 " + amount + "만큼 수리받았습니다. 현재 체력: " + this.hitPoint);
    }

    @Override
    public String getName() {
        return this.toString(); // toString()이 이미 이름을 반환하므로 그걸 재활용한다.
    }
}