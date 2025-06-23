package com.inher; // 이 코드가 속한 패키지 이름입니다.

/*
  생성자와 초기화 블록은 상속되지 않습니다. (중요!)
  -> 자식 클래스는 부모의 생성자나 초기화 블록을 직접 물려받지 않아요.
  하지만 자식 객체를 만들 때, 부모의 생성자가 먼저 호출되어 부모 부분을 초기화합니다.
 
  멤버(변수와 메서드)만 상속됩니다.
  -> 부모 클래스에 선언된 변수와 메서드는 자식 클래스에서 마치 자기 것인 것처럼 사용할 수 있습니다.
 
  자손(자식) 클래스의 멤버 개수는 조상(부모) 클래스보다 항상 같거나 많습니다.
  -> 자식은 부모의 모든 것을 물려받고, 추가적으로 자신만의 변수나 메서드를 가질 수 있기 때문입니다.
 */

import java.io.IOException; // 파일 입출력 시 발생할 수 있는 예외(오류)를 처리하기 위해 필요한 클래스입니다.
// import java.sql.SQLException; // 데이터베이스 관련 예외를 처리하기 위한 클래스인데, 현재 코드에서는 사용되지 않습니다.

public class Child extends Parent { // ★★★ 중요 ★★★
	// 'Child' 클래스는 'Parent' 클래스를 '상속(extends)'받습니다.
	// 이는 Child가 Parent의 모든 변수와 메서드를 물려받았다는 뜻입니다.

	int x = 20; // 'Child' 클래스만의 고유한 멤버 변수 'x'입니다.
				// 만약 부모 클래스에도 'x'라는 변수가 있다면, 이 'x'는 부모의 'x'와는 별개의,
				// 자식 클래스 내부에서만 유효한 'x'가 됩니다. (나중에 `method()`에서 자세히 설명)

	@Override // ★★★ 중요 ★★★
	// 이 어노테이션(Annotation)은 "아래 메서드가 부모 클래스의 메서드를 재정의(Override)한 것이다"라고
	// 자바 컴파일러에게 알려주는 역할을 합니다. 오타 등으로 재정의가 잘못되었을 때 오류를 알려줘서 실수를 막아줍니다.
	void parentMethod() { // 부모 클래스의 `parentMethod()`를 자식 클래스에 맞게 내용을 바꾼 것입니다.
						// 이 메서드는 `IOException`만 던져도 문제가 없습니다.
						// (부모 메서드가 더 넓은 범위의 예외를 던지거나, 같은 예외를 던질 수 있기 때문)
		System.out.println("여기는 자식 클래스임당"); // 부모 메서드와 다르게 출력됩니다.
	}

	// 아래 두 메서드는 '오버로딩(Overloading)'의 예시입니다.
	// 오버로딩: 같은 이름의 메서드를 여러 개 만들 수 있지만, 매개변수(괄호 안의 입력값)의 개수나 타입이 달라야 합니다.
	void parentMethod(int i) throws IOException { // `int i`라는 매개변수를 하나 받는 `parentMethod`
		System.out.println("여기는 자식 클래스임당 (오버로딩 - int i)");
	}

	void parentMethod(int i, int j) throws IOException { // `int i`, `int j` 두 개의 매개변수를 받는 `parentMethod`
		System.out.println("여기는 자식 클래스임당 (오버로딩 - int i, int j)");
	}

	void play() { // 'Child' 클래스에만 있는 고유한 메서드(기능)입니다.
		System.out.println("놀자~~~~");
	}

	void method() { // 변수 'x'의 다양한 접근 방법을 보여주는 메서드입니다.
		System.out.println("x: " + x); // 그냥 'x'라고 하면, 현재 이 `Child` 클래스의 'x' (값: 20)를 가리킵니다.
		System.out.println("this.x: " + this.x); // 'this.x'도 현재 이 `Child` 클래스의 'x' (값: 20)를 가리킵니다.
												// 'this'는 "지금 내가 속한 객체 자신"을 의미해요.
		System.out.println("super.x: " + super.x); // 'super.x'는 "나를 상속해 준 부모 클래스의 'x'"를 가리킵니다.
												// 만약 `Parent` 클래스에 `x = 10`이라고 선언되어 있다면,
												// 여기서는 10이 출력될 것입니다.
												// 'super'는 "나의 직계 부모"를 의미해요.
	}
}
