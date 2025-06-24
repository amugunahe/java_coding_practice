package com.inher; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  DrawShape 클래스: 도형 정보 출력하는 메인 프로그램!
 
  핵심:
  - 'Triangle'이랑 'Circle' 객체를 만들고,
  - 각 도형의 'draw()' 메소드를 호출해서 정보를 화면에 뿌려준다.
  (여기서 'draw()'는 각 클래스에서 지 맘대로 재정의된(오버라이딩된) 놈들이 실행된다!)
 */

public class DrawShape {

	public static void main(String[] args) { // ★★★ 여.기.서.부.터. 프로그램 시작! ★★★

		// 1. 삼각형(Triangle) 객체 만들고 초기화
		// 삼각형 세 꼭짓점 좌표를 Point 객체 3개로 배열에 박아 넣는다.
		Point[] p = {
			new Point(100, 100), // 첫 번째 점: (100, 100)
			new Point(140, 50),  // 두 번째 점: (140, 50)
			new Point(200, 100)  // 세 번째 점: (200, 100)
		};
		
		// 위에서 만든 점들로 'Triangle' 객체 't'를 존나게 만든다.
		Triangle t = new Triangle(p);

		// 2. 원(Circle) 객체 만들고 초기화
		// 원의 중심 (150, 150)이랑 반지름 50으로 'Circle' 객체 'c'를 존나게 만든다.
		Circle c = new Circle (new Point(150, 150), 50);
		
		// 3. 도형 정보 출력 (각자의 'draw()' 메소드 호출!)
		// 삼각형 't'한테 'draw()' 시켜서 지 정보 뱉어내게 한다. (Triangle에서 재정의된 draw() 실행!)
		t.draw();
		// 원 'c'한테 'draw()' 시켜서 지 정보 뱉어내게 한다. (Circle에서 재정의된 draw() 실행!)
		c.draw();

	}
}
