package com.polymorphism;

// --- A 클래스: 부모 (기본 좌표) ---
// 모든 자식들이 물려받을 기본 틀이다.

class A {
	private int x = 100; // x 좌표 (나만 건드릴 수 있음)
	private int y = 200; // y 좌표 (나만 건드릴 수 있음)

	public void setX(int x) { // x 좌표 설정
		this.x = x;
	}

	public void setY(int y) { // y 좌표 설정
		this.y = y;
	}

	public void disp() { // 현재 좌표 출력
		System.out.println("A클래스 (부모): x: " + x + ", y: " + y);
	}
}

// --- B 클래스: 자식 (A 물려받고, 지만의 특징 추가) ---
// 'A'를 상속받아서 'A'의 기능들을 쓰고, 지만의 새로운 속성/기능도 추가한다.
class B extends A { // A의 자식이다!

	// ★★★ 존나 중요! '필드 숨김(Field Hiding)' ★★★
	// 부모 'A'에도 'y'가 있지만, 'B'가 'y'를 새로 만들어서 지 혼자 쓰는 거다.
	// 그래서 'A'의 'y'랑 'B'의 'y'는 서로 다른 별개의 공간이다. (값도 다를 수 있음!)
	private int y = 300; // B가 새로 만든 y 좌표
	private int z = 400; // B에만 있는 새로운 z 좌표

	// ★★★ 존나 중요! 오버라이딩! ★★★
	// 부모 'A'의 'setY()'를 'B' 자기식대로 바꾼 거다.
	// 'B' 객체로 'setY()' 부르면, 'A' 거 말고 이 'B' 거가 실행된다.
	@Override
	public void setY(int y) { // B의 y 좌표 설정 (A의 setY 덮어씀)
		this.y = y; // 'this.y'는 이 'B' 객체 자신의 'y'를 말한다.
	}

	public void setZ(int z) { // z 좌표 설정 (B에만 있는 기능)
		this.z = z;
	}

	// ★★★ 존나 중요! 오버라이딩! ★★★
	// 부모 'A'의 'disp()'를 'B' 자기식대로 바꾼 거다.
	@Override
	public void disp() { // 정보 출력 (A의 disp() 덮어씀)
		super.disp(); // 'super.disp()': 일단 부모 'A'의 'disp()'를 먼저 실행한다! (그래서 A의 x,y가 먼저 나옴)
		System.out.println("B클래스 (자식): y: " + y + ", z: " + z); // 그 다음에 B의 y, z를 출력.
	}
}

// --- ABTest 클래스: 프로그램 실행 시작점 (다형성 테스트장) ---
public class ABTest {

	public static void main(String[] args) {

		// --- ★★★ 존나 중요! 다형성의 활용 (업캐스팅) ★★★ ---
		// 'A' 타입 변수 'a'가 실제로는 'B' 객체를 가리킨다.
		// 'a'로는 'A'에 있는 것만 부를 수 있지만, 오버라이딩된 건 'B'께 실행된다!
		A a = new B(); // 'a'가 'B' 객체를 참조 중. (B가 A의 자식이니 가능)

		System.out.println("--- 1. 초기 상태 ---");
		a.disp(); // 'B'에서 오버라이딩된 'disp()'가 호출된다. (A의 disp() + B의 y, z 출력)
		System.out.println();

		System.out.println("--- 2. a.setX(1) 호출 후 ---");
		// 'setX()': 이건 'A'에만 있는 메소드다. 'B'는 오버라이딩 안 했다.
		// 'a'가 가리키는 'B' 객체 내부의 'A' 부분에 있는 'x' 값을 1로 바꾼다.
		a.setX(1);
		a.disp();
		System.out.println();

		System.out.println("--- 3. a.setY(2) 호출 후 ---");
		// 'setY()': 'A'에도 있고 'B'에도 있다. 근데 'B'에서 오버라이딩했지?
		// 'a'가 'B' 객체 가리키니까, 오버라이딩 규칙에 따라 **'B' 클래스의 'setY()'가 호출된다.**
		// 그래서 'B'의 'y' (초기값 300)가 2로 바뀐다.
		// ★★★ 존나 중요! 'A'의 'y' (200)는 그대로다! (필드 숨김 때문!) ★★★
		a.setY(2);
		a.disp();
		System.out.println();

		// a.setZ(3); // ★★★ 존나 중요! 컴파일 에러 난다! ★★★
		            // 'a'는 'A' 타입이라 'A'에 없는 'setZ()' 메소드는 못 부른다.
		            // 실제 객체가 'B'여도, 변수 타입('A')만 보고 판단하기 때문에 에러!

		// --- 'B' 객체만의 고유 기능 직접 쓰는 방법 ---
		// B b = new B(); // 'B' 타입 변수 'b'를 만들고 'B' 객체 참조.
		// b.setZ(3);     // 'b'는 'B' 타입이라 'setZ()' 메소드 호출 가능!
		// b.disp();      // 'b'의 상태 출력.
	}
}
