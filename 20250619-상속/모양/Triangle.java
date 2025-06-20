package com.inher;

// Triangle은 Shape의 자식(하위) 클래스입니다.
// 'extends Shape'를 통해 Shape이 가진 모든 필드와 메서드를 물려받습니다.
public class Triangle extends Shape {

	Point[] p = new Point[3]; // 삼각형의 세 꼭짓점을 저장할 Point 객체 배열 (크기 3)

	// 세 개의 Point 객체 배열을 받아서 삼각형을 만드는 생성자
	public Triangle(Point[] p) {
		this.p = p; // 매개변수로 받은 Point 배열을 이 Triangle 객체의 p에 저장합니다.
	}

	// 삼각형의 정보를 출력하는 메서드. Shape의 draw() 메서드를 재정의합니다.
	@Override // 부모 클래스(Shape)의 draw 메서드를 오버라이드(재정의)한다는 의미입니다.
	void draw() {
		// 세 꼭짓점의 좌표(getXY() 메서드 사용)와 Shape에서 물려받은 색상을 출력합니다.
		// p[0].getXY(), p[1].getXY(), p[2].getXY()는 각 Point 객체의 문자열 표현을 가져옵니다.
		System.out.printf("[p1=%s, p2=%s, p3=%s, color=%s]%n", p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
	}

}