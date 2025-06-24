package com.polymorphism;

/*
  CarTest 클래스: **다형성과 객체 형변환의 존나 중요한 테스트장!**
 
  핵심 정리:
  1. **상속 관계 없는 클래스끼리는 형변환? 절대 안 됨.** (컴파일 에러 박살!)
  2. **상속 관계일 때만 업캐스팅/다운캐스팅이 가능하다.**
  - **업캐스팅 (자식 -> 부모): 존나 안전함. 컴퓨터가 알아서 해줌.**
  - **다운캐스팅 (부모 -> 자식): 무조건 명시적으로 시켜야 함.**
  만약 실제 객체 타입이랑 다르면 'ClassCastException'이라는 오류가 터진다! (★★★★★ 존나 중요! ★★★★★)
 */

public class CarTest {

	public static void main(String[] args) {
		FireEngine f;
		Ambulance a;

		// a = (Ambulance)f; // 컴파일 에러: FireEngine이랑 Ambulance는 남남이라 변환 안 됨
		// f = (FireEngine)a; // 컴파일 에러: Ambulance랑 FireEngine도 남남이라 변환 안 됨

		Car car = null;
		FireEngine fe = new FireEngine(); // 소방차 객체 하나 만든다.
		FireEngine fe2 = null;

		fe.water(); // 'fe'는 소방차니 물 쏴! (water() 메소드 호출)

		// --- ★★★ 존나 중요! 업캐스팅 (자식 -> 부모) ---
		car = fe; // 'fe'(FireEngine)를 'car'(Car)에 넣음. FireEngine은 Car의 자식이니 **자동으로 안전하게 변환된다.**

		// car.water(); // 컴파일 에러: 'car' 변수는 Car 타입이라 water() 메소드 없다!
		                 // 실제 객체가 FireEngine이어도, 변수 타입이 Car면 Car의 메소드만 쓸 수 있음.

		// --- ★★★ 존나 중요! 다운캐스팅 (부모 -> 자식): 원래 타입으로 되돌리기 ---
		fe2 = (FireEngine)car; // 'car'가 사실 FireEngine이었으니 FireEngine으로 **성공적으로 변환!**
		                       // (이전 코드 주석처럼 오류 안 나고 잘 된다. 헷갈리지 마라!)

		fe2.water(); // 'fe2'는 다시 FireEngine이니 물 쏴! (water() 호출)

		System.out.println("-------------------------------"); // 구분선 쫙!

		Car c = new FireEngine(); // 'c'(Car 타입)에 새로운 소방차 객체를 할당. (업캐스팅 또 발동!)
		Car c2 = null;
		FireEngine fee = null;

		c.drive(); // 'c'는 Car 타입이니 운전시켜! (drive() 호출)

		// fee = c; // 컴파일 에러: 부모(Car) 타입을 자식(FireEngine) 타입에 바로 넣을 수 없음. **명시적으로 (FireEngine) 붙여야 한다!**

		// --- ★★★ 존나 중요! 다운캐스팅 (실제 객체가 FireEngine이라 성공!) ---
		fee = (FireEngine)c; // 'c'가 실제 소방차 객체라 다운캐스팅 **성공!**
		                     // (이전 코드 주석처럼 ClassCastException **절대 안 터진다!**)

		fee.drive(); // 'fee'는 FireEngine이니 운전시켜! (drive() 호출)

		c2 = fee; // 'fee'(FireEngine)를 'c2'(Car)에 넣음. (업캐스팅 다시 발동!)

		c2.drive(); // 'c2'는 Car 타입이니 운전시켜! (drive() 호출)
	}
}
