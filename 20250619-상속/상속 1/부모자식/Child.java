package com.inher; // 이 코드는 'com.inher' 패키지에 들어있음.

/*
  ★★★ 상속의 핵심 개념 ★★★
  - 생성자/초기화 블록은 상속 안 됨! -> BUT, 자식 객체 만들 때 부모 생성자가 먼저 호출돼서 부모 부분 초기화함.
  - 멤버(변수, 메서드)만 상속됨. -> 자식은 부모 꺼 내 것인 양 쓸 수 있음.
  - 자식 클래스 멤버 수는 부모보다 항상 같거나 많음. (물려받고 자기 거 추가 가능)
 */

import java.io.IOException; // 파일 입출력 오류 처리용.

public class Child extends Parent { // ★★★개중요★★★ 'Child'는 'Parent'를 상속받음.
	// Child는 Parent의 모든 변수와 메서드를 물려받았다는 뜻.

	int x = 20; // Child 클래스만의 고유 변수 'x'.
				// ★주의★ 부모에도 'x'가 있다면 이건 별개임! (아래 method()에서 확인)

	@Override // ★★★필수★★★ "아래 메서드, 부모 거 재정의(Override)했음!" 컴파일러한테 알려주는 표시.
	void parentMethod() { // 부모의 `parentMethod()` 내용을 Child에 맞게 바꿈.
						// 부모보다 좁거나 같은 범위의 예외(IOException) 던질 수 있음.
		System.out.println("여기는 자식 클래스임당"); // 부모랑 다르게 출력됨.
	}

	// ★오버로딩(Overloading) 예시★
	// 같은 이름의 메서드를 여러 개 만들지만, 매개변수 개수나 타입이 달라야 함.
	void parentMethod(int i) throws IOException { // int i 하나 받는 `parentMethod`
		System.out.println("여기는 자식 클래스임당 (오버로딩 - int i)");
	}

	void parentMethod(int i, int j) throws IOException { // int i, int j 두 개 받는 `parentMethod`
		System.out.println("여기는 자식 클래스임당 (오버로딩 - int i, int j)");
	}

	void play() { // 'Child' 클래스에만 있는 고유 메서드.
		System.out.println("놀자~~~~");
	}

	void method() { // 변수 'x' 접근 방법 비교 메서드.
		System.out.println("x: " + x);         // 그냥 'x': 현재 Child 클래스의 'x' (값: 20)
		System.out.println("this.x: " + this.x); // 'this.x': 'this'는 "지금 내 객체 자신". 역시 Child의 'x' (값: 20)
		System.out.println("super.x: " + super.x); // ★존나중요★ 'super.x': 'super'는 "내 직계 부모". 부모 클래스의 'x' (Parent에 x=10 있으면 10 출력됨)
	}
}
