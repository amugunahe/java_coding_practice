package com.interexam;

public class Marine extends GroupUnit{ // Marine은 GroupUnit(지상 유닛)의 자식이다!
		
	public Marine() {
	    // ★★★ 중요! 부모 클래스 GroupUnit의 생성자 호출! ★★★
	    // Marine의 기본 체력은 40으로 설정한다.
	    // Unit 생성자에서 hitPoint도 MAX_HP로 초기화해주므로 `hitPoint = MAX_HP;`는 필요 없다!
	    super(40); 
	}

    // ★★★ Unit의 toString() 메소드를 재정의해서 "Marine"이라고 반환하도록 한다! ★★★
    @Override
    public String toString() {
        return "Marine";
    }

    // ★★★ GroupUnit이 move()를 구현했으므로 Marine은 따로 구현할 필요 없다. ★★★
    // 하지만 Marine만의 특수한 이동 방식이 있다면 여기서 재정의(Override)할 수 있다.
}