package com.inher; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  Circle 클래스: '원'이다! (**Shape의 자식 클래스!**)
 
  핵심:
  - **'Shape' 클래스를 상속받는다.** (extends Shape) 이게 **존나 중요하다!** 'Shape'가 가진 모든 필드(속성)랑 메소드(기능)를 **물려받아서 다 쓸 수 있다는 뜻이다.** 그러니까 원도 색깔(color)을 가질 수 있는 거지!
  - 지만의 새로운 속성으로 **'중심점(center)'과 '반지름(r)'을 가진다.**
  - 'draw()' 메소드를 **지만의 방식으로 재정의(Override)한다.** (부모의 'draw()'랑 다르게 원 정보 출력!)
 */

public class Circle extends Shape {

	// 1. 필드 (속성)
	Point center; // 원의 중심 좌표. ('Point'라는 별도의 클래스로 x, y 좌표를 가진다.)
	int r;        // 원의 반지름.

	// 2. 생성자 (객체 만들 때 호출되는 특별한 놈!)

	// 기본 생성자: 'new Circle()' 이렇게 인자 없이 호출할 때 쓴다.
	// 이 새끼는 다른 생성자를 불러서 중심 (0,0)에 반지름 100으로 원을 기본 세팅한다.
	public Circle() {
		this(new Point(0, 0), 100); // 다른 생성자(아래꺼)를 부르는 거다!
	}

	// 중심점과 반지름을 받아서 원을 만드는 생성자. (사용자가 직접 정해줄 때 씀)
	public Circle(Point center, int r) {
		this.center = center; // 받은 중심점을 내 중심점으로 저장!
		this.r = r;           // 받은 반지름을 내 반지름으로 저장!
	}

	// 3. 메소드 (기능)

	// ★★★ 존나 중요! 'draw()' 메소드 재정의(Override)! ★★★
	// 부모 'Shape'에도 'draw()'가 있지만, 여기서는 '원'에 맞게 내용을 바꾼 거다.
	@Override // 이거 붙이면 혹시 오타나서 부모 메소드랑 이름 다르면 컴파일 에러 내준다! (존나 고마운 기능!)
	void draw() {
		// 원의 정보(중심 x, y, 반지름, 그리고 부모한테 물려받은 색깔)를 존나게 깔끔하게 출력한다!
		System.out.printf("[center = (%d, %d), r = %d, color = %s]%n", center.x, center.y, r, color);
	}
}
