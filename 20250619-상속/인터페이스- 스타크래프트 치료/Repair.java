package com.interexam;

/*
  Repair 인터페이스: **'수리 가능한' 객체들이라면 무조건 가져야 할 기능들을 정의하는 존나게 중요한 설계도다!**
 
  핵심:
  - 이 인터페이스를 `implements`하는 클래스(예: `Tank`, `Dropship`)는
  - **현재 체력**을 알려주고 (`getCurrentHP()`),
  - **최대 체력**을 알려주고 (`getMaxHP()`),
  - **이름**을 알려주고 (`getName()`),
  - **얼마만큼 수리를 받을지** (`beRepaired(int amount)`) 정의하는 메소드를 **무조건 구현해야 한다!**
 */

public interface Repair {
    // --- 수리 가능한 객체가 제공해야 할 기능들 (추상 메소드)! ---

    // 1. 현재 체력을 반환하는 메소드 (수리사가 현재 상태를 파악할 때 사용)
    public abstract int getCurrentHP(); // 현재 체력 반환

    // 2. 최대 체력을 반환하는 메소드 (수리사가 얼마나 더 채워야 할지 파악할 때 사용)
    public abstract int getMaxHP(); // 최대 체력 반환

    // 3. 수리사가 수리했을 때, 그만큼 체력을 회복하는 메소드
    // 'amount'만큼 체력을 회복하고, 최대 체력을 넘지 않도록 한다.
    public abstract void beRepaired(int amount); // 'amount'만큼 수리받는 기능

    // 4. 유닛의 이름을 반환하는 메소드 (수리 메시지 출력 시 유용)
    public abstract String getName(); // 유닛 이름 반환 (toString()과 유사하지만 의미가 더 명확)
}