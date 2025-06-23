package com.polymorphism;

// --- A 클래스: 부모 클래스 역할 ---
// 기본적인 x, y 좌표를 가지고, 이들을 설정하고 출력하는 기능을 제공합니다.
class A {
	// private: 이 클래스 내부에서만 직접 접근 가능합니다.
	private int x = 100; // x 좌표 초기값
	private int y = 200; // y 좌표 초기값

	// x 값을 설정하는 공개 메소드
	public void setX(int x) {
		this.x = x; // 'this.x'는 이 A 객체의 x 멤버 변수를 의미합니다.
	}

	// y 값을 설정하는 공개 메소드
	public void setY(int y) {
		this.y = y; // 이 A 객체의 y 멤버 변수를 의미합니다.
	}

	// x, y 좌표를 화면에 출력하는 메소드
	public void disp() {
		System.out.println("A클래스 (부모): x: " + x + ", y: " + y);
	}
}

// --- B 클래스: 자식 클래스 역할 ---
// A 클래스를 상속받아 A의 속성과 기능을 물려받고, 자신만의 속성을 추가하며,
// 부모의 일부 기능을 재정의(오버라이딩)합니다.
class B extends A { // 'extends A': B가 A를 상속받는다는 의미입니다.

	// 중요! A에도 'y'가 있지만, B에서 'y'를 다시 선언하면 B는 자신만의 새로운 'y'를 가집니다.
	// 이것을 '필드 숨김(Field Hiding)'이라고 합니다.
	// A의 'y'(200)와 B의 'y'(300)는 메모리상에서 서로 다른 공간입니다.
	private int y = 300; // B 클래스에서 새로 정의한 y (초기값)
	private int z = 400; // B 클래스에만 있는 새로운 속성 (초기값)

	// B 클래스의 y 값을 설정하는 메소드
	// @Override: 부모(A)의 setY 메소드를 '재정의'했음을 컴파일러에게 알려줍니다.
	// B 객체에서 setY를 호출하면, A의 setY 대신 이 B의 setY가 실행됩니다.
	@Override
	public void setY(int y) {
		this.y = y; // 'this.y'는 이 B 객체 자신의 '새로운 y' 멤버 변수를 의미합니다.
	}

	// z 값을 설정하는 메소드 (B 클래스에만 있는 기능)
	public void setZ(int z) {
		this.z = z;
	}

	// 정보를 화면에 출력하는 메소드 (부모의 disp()를 재정의)
	@Override
	public void disp() {
		super.disp(); // 'super.disp()': 부모 클래스(A)의 disp() 메소드를 먼저 호출합니다.
		              // 이 호출 덕분에 A 객체 부분의 x, y 값이 먼저 출력됩니다.
		System.out.println("B클래스 (자식): y: " + y + ", z: " + z);
	}
}

// --- ABTest 클래스: 프로그램 실행 시작점 ---
// 이 파일의 유일한 'public' 클래스이며, 파일 이름(ABTest.java)과 같아야 합니다.
// 자바 프로그램이 시작될 때 가장 먼저 실행되는 main 메소드를 포함합니다.
public class ABTest {

	public static void main(String[] args) {

		// --- 다형성(Polymorphism)의 활용 ---
		// 'A' 타입의 참조 변수 'a'가 실제로는 'B' 클래스의 객체(인스턴스)를 가리킵니다.
		// 'A'는 부모 타입이므로, 'a'를 통해서는 'A' 클래스에 정의된 멤버만 접근할 수 있습니다.
		// 하지만, 오버라이딩된 메소드는 항상 실제 객체('B' 객체)의 메소드가 호출됩니다.
		A a = new B(); // 'a' 변수는 B 객체를 참조 (업캐스팅)

		System.out.println("--- 1. 초기 상태 ---");
		a.disp(); // B 클래스에서 오버라이딩된 disp() 호출 (A의 disp() 먼저 실행 후 B의 y, z 출력)
		System.out.println(); // 줄 바꿈

		System.out.println("--- 2. a.setX(1) 호출 후 ---");
		// setX(): A 클래스에만 정의된 메소드입니다 (B는 오버라이딩하지 않음).
		// 'a'가 가리키는 'B' 객체 내부의 A 부분에 있는 'x' 값을 1로 변경합니다.
		a.setX(1);
		a.disp();
		System.out.println();

		System.out.println("--- 3. a.setY(2) 호출 후 ---");
		// setY(): A와 B 모두에 정의되어 있으며, B에서 오버라이딩되었습니다.
		// 'a'가 'B' 객체를 가리키므로, 오버라이딩 규칙에 따라 'B' 클래스의 setY()가 호출됩니다.
		// 이 호출은 'B' 클래스 자신의 'y' 값(초기값 300)을 2로 변경합니다.
		// A 클래스의 'y' 값(200)에는 영향을 주지 않습니다! (필드 숨김 때문)
		a.setY(2);
		a.disp();
		System.out.println();

		// --- 추가 설명: 왜 a.setZ(3)은 컴파일 오류가 나는가? ---
		// a.setZ(3); // 이 코드는 주석을 풀면 컴파일 오류가 발생합니다.
		// 이유: 'a' 변수의 타입은 'A'입니다. 'A' 클래스에는 'setZ()' 메소드가 정의되어 있지 않습니다.
		// 'setZ()'는 오직 'B' 클래스에만 있는 메소드입니다.
		// 비록 'a'가 실제 'B' 객체를 가리키고 있더라도, 컴파일러는 '참조 변수의 타입(A)'만 보고
		// 호출 가능한 메소드를 판단하기 때문에 오류를 냅니다.

		// --- B 객체만의 고유한 기능 사용 예시 ---
		// B b = new B(); // 'B' 타입 변수 'b'를 새로 만들고 'B' 객체를 참조
		// b.setZ(3);     // 'b'는 'B' 타입이므로 'B' 클래스에 있는 'setZ()' 메소드 호출 가능
		// b.disp();      // 'b'의 상태를 출력 (새로운 B 객체의 상태)
	}
}