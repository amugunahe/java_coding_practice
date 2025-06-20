package com.inher;

// Circle은 Shape의 자식(하위) 클래스입니다.
// 'extends Shape'는 Shape 클래스가 가진 모든 필드와 메서드를 물려받는다는 의미입니다.
public class Circle extends Shape {

	Point center; // 원의 중심 좌표 (Point 객체로 표현)
	int r;        // 원의 반지름

	// 기본 생성자: Circle 객체를 'new Circle()'처럼 만들 때 호출됩니다.
	// 중심이 (0,0)이고 반지름이 100인 원을 만듭니다.
	public Circle() {
		// this(new Point(0, 0), 100); : 같은 클래스의 다른 생성자를 호출합니다.
		// new Point(0, 0)으로 중심점을 만들고, 반지름은 100으로 설정합니다.
		this(new Point(0, 0), 100);
	}

	// 중심점과 반지름을 받아서 원을 만드는 생성자
	public Circle(Point center, int r) {
		this.center = center; // 매개변수로 받은 center를 이 Circle 객체의 center에 저장
		this.r = r;           // 매개변수로 받은 r을 이 Circle 객체의 r에 저장
	}

	// 원의 정보를 출력하는 메서드. Shape의 draw() 메서드를 재정의합니다.
	@Override // 부모 클래스(Shape)의 draw 메서드를 오버라이드(재정의)한다는 의미입니다.
	void draw() {
		// 원의 중심 좌표 (x, y), 반지름, 그리고 Shape에서 물려받은 색상을 출력합니다.
		// center.x, center.y: Point 객체 내부의 x, y 좌표에 접근합니다.
		System.out.printf("[center = (%d, %d), r = %d, color = %s]%n", center.x, center.y, r, color);
	}
}
