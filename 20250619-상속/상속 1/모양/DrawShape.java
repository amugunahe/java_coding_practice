package com.inher; // 이 코드가 속한 패키지 이름입니다.

public class DrawShape { // 'DrawShape'라는 이름의 클래스를 정의합니다. 이 클래스는 도형을 '그리는' (여기서는 정보를 출력하는) 역할을 합니다.

	// 자바 프로그램이 시작될 때 가장 먼저 실행되는 메서드
	public static void main(String[] args) { // ★★★ 프로그램의 시작점 ★★★
		// 이 `main` 메서드 안의 코드가 프로그램이 실행될 때 가장 먼저 동작합니다.

		// 1. Triangle(삼각형) 객체 생성 및 초기화
		// 삼각형의 세 꼭짓점을 나타내는 Point 객체 3개를 배열로 만듭니다.
		// Point는 (x, y) 좌표를 나타내는 클래스입니다.
		Point[] p = {
			new Point(100, 100), // 첫 번째 점: (100, 100)
			new Point(140, 50),  // 두 번째 점: (140, 50)
			new Point(200, 100)  // 세 번째 점: (200, 100)
		};
		
		// 위에서 정의한 Point 배열 p를 사용하여 Triangle 객체 t를 생성합니다.
		// Triangle 클래스의 생성자는 Point 배열을 인자로 받습니다.
		Triangle t = new Triangle(p);

		// 2. Circle(원) 객체 생성 및 초기화
		// 원의 중심 (150, 150)을 나타내는 새로운 Point 객체를 만들고, 반지름 50을 함께 사용하여 Circle 객체 c를 생성합니다.
		// Circle 클래스의 생성자는 Point 객체와 정수형 반지름을 인자로 받습니다.
		Circle c = new Circle (new Point(150, 150), 50);
		
		// 3. 도형 정보 출력 (draw 메서드 호출)
		// 삼각형 t의 draw() 메서드를 호출하여 삼각형 정보를 출력합니다.
		// Triangle 클래스에서 재정의된 draw() 메서드가 실행될 것입니다.
		t.draw();
		// 원 c의 draw() 메서드를 호출하여 원 정보를 출력합니다.
		// Circle 클래스에서 재정의된 draw() 메서드가 실행될 것입니다.
		c.draw();

	} // main 메서드 끝

} // DrawShape 클래스 끝
