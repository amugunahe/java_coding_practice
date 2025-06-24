package com.polymorphism;

/*
  CarTest 클래스: 다형성과 객체 형변환 테스트.
 
  핵심:
  1. 상속 관계 없는 클래스끼리는 형변환 절대 불가능 (컴파일 에러).
  2. 상속 관계에선 업캐스팅/다운캐스팅 가능.
  - 업캐스팅 (자식 -> 부모): 존나 안전함. 자동 처리.
  - 다운캐스팅 (부모 -> 자식): 명시적 형변환 필수.
  실제 객체 타입이랑 다르면 'ClassCastException' 터짐.
 */

public class CarTest {

	public static void main(String[] args) {
		FireEngine f;
		Ambulance a;

		// a = (Ambulance)f; // 컴파일 에러: 상속 관계 아니라서 안 됨.
		// f = (FireEngine)a; // 컴파일 에러: 상속 관계 아니라서 안 됨.

		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;

		fe.water(); // 'fe'는 FireEngine이니 water() 호출 가능.

		// --- 업캐스팅 (자식 -> 부모): 존나 안전함 ---
		car = fe; // 'fe'(FireEngine)가 'car'(Car)로 자동 변환 (Car가 부모).

		// car.water(); // 컴파일 에러: 'car'는 Car 타입이라 water() 메소드 없음.
		                   // 실제 FireEngine 객체여도 변수 타입이 'Car'면 못 부름.

		// --- 다운캐스팅 (부모 -> 자식): 원래 타입으로 돌려놓기 ---
		fe2 = (FireEngine)car; // 'car'가 원래 FireEngine이었으니 FireEngine으로 성공적으로 변환.
		                       // (이전 코드 주석처럼 오류 안 남. 주의!)

		fe2.water(); // 'fe2'는 FireEngine이니 water() 다시 호출 가능.

		System.out.println("-------------------------------");

		Car c = new FireEngine(); // 'c'(Car 타입)에 FireEngine 객체 할당 (업캐스팅).
		Car c2 = null;
		FireEngine fee = null;

		c.drive(); // 'c'는 Car 타입이라 drive() 호출 가능.

		// fee = c; // 컴파일 에러: 부모(Car)를 자식(FireEngine)에 바로 못 넣음. 명시적 형변환 필수.

		// --- 다운캐스팅 (실제 객체가 FireEngine이니 성공!) ---
		fee = (FireEngine)c; // 'c'가 실제 FireEngine 객체라 다운캐스팅 성공!
		                     // (이전 코드 주석과 달리, 이제 여기서 ClassCastException 안 터진다!)

		fee.drive(); // 'fee'는 FireEngine이라 drive() 호출 가능.

		c2 = fee; // 'fee'(FireEngine)를 'c2'(Car)로 자동 변환 (업캐스팅).

		c2.drive(); // 'c2'는 Car 타입이라 drive() 호출 가능.
	}
}
