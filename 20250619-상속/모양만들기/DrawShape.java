package com.inher;

public class DrawShape {

	// 자바 프로그램이 시작될 때 가장 먼저 실행되는 메서드
	public static void main(String[] args) {
		// 삼각형의 세 꼭짓점을 나타내는 Point 객체 3개를 배열로 만듭니다.
		Point[] p = {
			new Point(100, 100), // 첫 번째 점
			new Point(140, 50),  // 두 번째 점
			new Point(200, 100)  // 세 번째 점
		};
		
		// 위에서 정의한 Point 배열 p를 사용하여 Triangle 객체 t를 생성합니다.
		Triangle t = new Triangle(p);

		// 원의 중심 (150, 150)과 반지름 50을 사용하여 Circle 객체 c를 생성합니다.
		Circle c = new Circle (new Point(150, 150), 50);
		
		// 삼각형 t의 draw() 메서드를 호출하여 삼각형 정보를 출력합니다.
		t.draw();
		// 원 c의 draw() 메서드를 호출하여 원 정보를 출력합니다.
		c.draw();

	}

}
