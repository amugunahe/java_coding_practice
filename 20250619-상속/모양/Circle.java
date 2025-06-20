package com.inher; // 이 코드가 속한 패키지 이름입니다.

// Circle은 Shape의 자식(하위) 클래스입니다.
// 'extends Shape'는 Shape 클래스가 가진 모든 필드와 메서드를 물려받는다는 의미입니다.
// 즉, Circle 객체는 Shape가 가진 'color' 필드를 자동으로 가지게 됩니다.
public class Circle extends Shape {

	// 1. 필드 (속성)
	Point center; // 원의 중심 좌표를 나타내는 필드입니다. 'Point'는 별도의 클래스로, x, y 좌표를 가질 것입니다.
	int r;        // 원의 반지름(radius)을 나타내는 필드입니다. 'int'는 정수 값을 저장합니다.

	// 2. 생성자 (객체를 만들 때 호출되는 특별한 메서드)

	// 기본 생성자: Circle 객체를 'new Circle()'처럼 인자 없이 만들 때 호출됩니다.
	// 이 생성자는 원의 중심과 반지름에 기본값을 설정해줍니다.
	public Circle() {
		// 'this(new Point(0, 0), 100);'
		// - 이 코드는 현재 Circle 클래스의 다른 생성자(매개변수가 있는 생성자)를 호출합니다.
		// - 'new Point(0, 0)'을 통해 중심이 (0,0)인 Point 객체를 생성하고,
		// - 반지름은 100으로 설정하여 그 생성자에게 전달합니다.
		// - 이렇게 하면 기본 Circle 객체는 항상 중심 (0,0), 반지름 100으로 만들어집니다.
		this(new Point(0, 0), 100);
	}

	// 중심점과 반지름을 받아서 원을 만드는 생성자 (매개변수가 있는 생성자)
	// 이 생성자는 사용자가 직접 원의 중심 좌표(center)와 반지름(r)을 지정할 수 있게 합니다.
	public Circle(Point center, int r) {
		this.center = center; // 매개변수로 받은 'center' (입력 값)를 현재 Circle 객체의 'center' 필드에 저장합니다.
		this.r = r;           // 매개변수로 받은 'r' (입력 값)을 현재 Circle 객체의 'r' 필드에 저장합니다.
	}

	// 3. 메서드 (기능)

	// 원의 정보를 출력하는 메서드입니다.
	// 'Shape' 클래스에도 'draw()'라는 메서드가 있는데, 여기서는 그 메서드를 '재정의(Override)'합니다.
	@Override // 이 어노테이션은 이 메서드가 부모 클래스(Shape)의 메서드를 오버라이드한다는 것을 명시적으로 알려줍니다.
	          // 만약 부모 클래스에 동일한 이름과 매개변수 목록을 가진 메서드가 없다면 컴파일 오류가 발생하여 실수를 방지할 수 있습니다.
	void draw() {
		// 원의 중심 좌표 (x, y), 반지름, 그리고 부모 클래스(Shape)에서 물려받은 색상(color)을 출력합니다.
		// 'center.x', 'center.y': 'Point' 객체 내부에 저장된 x, y 좌표 값에 접근합니다.
		// `%d`: 정수형 값을 출력하기 위한 형식 지정자입니다.
		// `%s`: 문자열 값을 출력하기 위한 형식 지정자입니다.
		// `%n`: 운영체제에 맞는 줄바꿈 문자를 출력합니다. (System.out.println()과 유사)
		System.out.printf("[center = (%d, %d), r = %d, color = %s]%n", center.x, center.y, r, color);
	}
}
