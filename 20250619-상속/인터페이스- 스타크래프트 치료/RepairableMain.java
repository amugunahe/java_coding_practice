package com.interexam;

public class RepairableMain {

	public static void main(String[] args) {
		// Tank와 Dropship은 Repair 인터페이스를 구현하므로 SCV가 수리할 수 있다.
		// ★★★ Tank와 Dropship의 초기 체력을 만피가 아닌 상태로 설정하여 수리 테스트를 용이하게 한다! ★★★
		Tank tank = new Tank(100); // 탱크 생성 (MAX_HP 150인데, 100으로 시작해서 수리 필요!)
		Dropship dropship = new Dropship(); // 드랍십 생성 (MAX_HP 125인데, 생성자에서 125로 시작. 수리 필요 없음)
		dropship.hitPoint = 50; // ★★★ Dropship의 체력을 일부러 깎아서 수리 테스트를 한다! ★★★
		
		Marine marine = new Marine(); // 마린 생성 (마린은 Repair를 구현하지 않으므로 SCV가 수리 못함)
		SCV scv = new SCV(); // SCV 생성
		
		System.out.println("--- 수리 전 초기 상태 ---");
		System.out.println("Tank 체력: " + tank.getCurrentHP() + "/" + tank.getMaxHP());
		System.out.println("Dropship 체력: " + dropship.getCurrentHP() + "/" + dropship.getMaxHP());
		System.out.println("Marine 체력: " + marine.hitPoint + "/" + marine.MAX_HP);
		System.out.println("SCV 체력: " + scv.getCurrentHP() + "/" + scv.getMaxHP());
		System.out.println("------------------------------------");

		scv.repair(tank);  // scv가 tank를 수리하도록 한다.
		scv.repair(dropship); // scv가 dropship을 수리하도록 한다.
		
		// scv.repair(marine); // ★★★ 마린은 Repair 인터페이스를 구현하지 않으므로 컴파일 에러는 안 나지만, ★★★
		                     // ★★★ 런타임에 SCV의 repair 메소드에서 걸러져서 메시지가 뜰 거다! ★★★
        // scv.repair(marine); // 주석을 풀면 "SCV는 Marine를 수리할 수 없습니다" 메시지가 뜬다.
        // scv.repair(scv); // SCV도 Repair를 구현하므로 SCV가 SCV 자신을 수리할 수도 있다.
        
		System.out.println("------------------------------------");
		System.out.println("--- 수리 후 최종 상태 ---");
		System.out.println("Tank 최종 체력: " + tank.getCurrentHP() + "/" + tank.getMaxHP());
		System.out.println("Dropship 최종 체력: " + dropship.getCurrentHP() + "/" + dropship.getMaxHP());
	}

}
