package com.interexam;

public class SCV extends GroupUnit implements Repair { // SCV는 GroupUnit(지상 유닛)의 자식이고, Repair 인터페이스를 구현한다!

	public SCV() {
		// ★★★ 중요! 부모 클래스 GroupUnit의 생성자 호출! ★★★
		// SCV의 기본 체력은 60으로 설정한다.
		// Unit 생성자에서 hitPoint도 MAX_HP로 초기화해주므로 `hitPoint = MAX_HP;`는 필요 없다!
		super(60); 
	}
	
	// ★★★ Unit의 toString() 메소드를 재정의해서 "SCV"라고 반환하도록 한다! ★★★
	@Override
    public String toString() {
        return "SCV";
    }

	// ★★★ SCV 고유의 수리(repair) 메소드! (존나 중요! 로직 대폭 수정!) ★★★
	// 'Repair' 인터페이스를 구현한 유닛만 수리할 수 있다.
	// 이제 Repair 인터페이스의 메소드들을 사용해서 수리 로직을 처리한다! (더 깔끔하고 유연함!)
	void repair(Repair r) { // 'r'은 수리할 대상 객체다.
	    // 수리할 대상이 정말로 '수리 가능한(Repair)' 객체인지 확인 (Marine은 Repair를 구현하지 않으므로 걸러짐)
		if(r != null) { // null 체크
            // 수리 대상이 이미 만피인지 확인
            if (r.getCurrentHP() == r.getMaxHP()) {
                System.out.println(r.getName() + "는 이미 만피라 수리할 필요 없습니다!");
                return; // 수리할 필요 없으면 바로 종료
            }

			System.out.println(r.getName() + "의 수리를 시작합니다. 현재 체력: " + r.getCurrentHP()); // 수리 시작 메시지
			
			// ★★★ 유닛의 체력을 1씩 증가시키며 최대 체력까지 존나게 채운다! ★★★
            // 이제 직접 hitPoint를 조작하는 대신, beRepaired() 메소드를 호출한다!
            int repairAmountPerTick = 10; // 한 번에 수리하는 양 (원래 1씩이었지만 좀 더 빠르게 보이도록)
            while(r.getCurrentHP() < r.getMaxHP()) {
                r.beRepaired(repairAmountPerTick); // 유닛에게 'repairAmountPerTick'만큼 수리받으라고 시킨다!
                // 현재 체력이 MAX_HP를 넘지 않도록 beRepaired 메소드 안에서 처리됨.
                try {
                    Thread.sleep(50); // 수리 과정이 보이도록 잠시 멈춘다 (ms 단위)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("수리 중 방해받았습니다.");
                }
            }
			System.out.println(r.getName() + "의 수리가 끝났습니다. 최종 체력: " + r.getCurrentHP()); // 수리 완료 메시지
		} else {
            System.out.println("SCV는 유효하지 않은 대상을 수리할 수 없습니다");
        }
	}
    // SCV도 자기 자신은 Repairable이니까 Repair 인터페이스의 메소드를 구현해야 하지만
    // 이 예제에서는 SCV가 '수리받는' 대상으로 쓰이지 않으므로 여기서는 구현하지 않는다.
    // 만약 SCV도 Repairable하게 만들려면 Tank, Dropship처럼 Repair 메소드를 구현해야 한다.
    // 현재 SCV는 '수리공' 역할만 한다.
    
    // SCV도 Repair 인터페이스를 implements 했으므로 다음 메소드들을 구현해야 한다.
    // 현재 코드에서는 SCV가 수리받는 대상이 아니므로, 의미상으로 비어둘 수도 있지만,
    // 문법적으로는 반드시 구현해야 한다.
    @Override
    public int getCurrentHP() { return hitPoint; } // 자기 체력
    
    @Override
    public int getMaxHP() { return MAX_HP; } // 자기 최대 체력
    
    @Override
    public void beRepaired(int amount) {
        this.hitPoint = Math.min(this.MAX_HP, this.hitPoint + amount);
        System.out.println(this.getName() + "가 " + amount + "만큼 수리받았습니다. 현재 체력: " + this.hitPoint);
    }
    
    @Override
    public String getName() { return this.toString(); }

}
