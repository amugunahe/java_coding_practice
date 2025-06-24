package com.inher; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  Triangle 클래스: '삼각형'이다! (**Shape의 자식 클래스!**)
 
  핵심:
  - **'Shape' 클래스를 상속받는다.** (extends Shape) 이게 **존나 중요하다!** 'Shape'가 가진 모든 필드(속성)랑 메소드(기능)를 **물려받아서 다 쓸 수 있다는 뜻이다.** 그러니까 삼각형도 색깔(color)을 가질 수 있는 거지!
  - 지만의 새로운 속성으로 **'세 개의 꼭짓점(Point 배열)'을 가진다.**
  - 'draw()' 메소드를 **지만의 방식으로 재정의(Override)한다.** (부모의 'draw()'랑 다르게 삼각형 정보 출력!)
 */

public class Triangle extends Shape {

	Point[] p = new Point[3]; // 삼각형의 세 꼭짓점을 저장할 Point 객체 배열 (사이즈 3짜리)

	// 세 개의 Point 객체 배열을 받아서 삼각형을 만드는 생성자.
	public Triangle(Point[] p) {
		this.p = p; // 받은 Point 배열을 내 꼭짓점 배열에 존나게 저장한다.
	}

	// ★★★ 존나 중요! 'draw()' 메소드 재정의(Override)! ★★★
	// 부모 'Shape'에도 'draw()'가 있지만, 여기서는 '삼각형'에 맞게 내용을 바꾼 거다.
	@Override // 이거 붙이면 혹시 오타나서 부모 메소드랑 이름 다르면 컴파일 에러 내준다! (존나 고마운 기능!)
	void draw() {
		// 세 꼭짓점의 좌표랑 부모한테 물려받은 색깔을 존나게 깔끔하게 출력한다!
		System.out.printf("[p1=%s, p2=%s, p3=%s, color=%s]%n", p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
	}

}
