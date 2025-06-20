package com.inher;

public class Shape { // 모든 도형들의 부모 클래스 (가장 기본적인 도형의 '틀')

	String color = "black"; // 모든 도형이 기본적으로 가질 '색상' 필드. 기본값은 "black"입니다.

	// 도형을 '그리는' 기능을 나타내는 메서드.
	// 자식 클래스들이 이 메서드를 각자의 방식으로 재정의(오버라이드)할 것입니다.
	void draw() {
		// Shape의 기본 그리기 메서드는 단순히 도형의 색상만 출력합니다.
		System.out.printf("[color = %s]%n", color); // %s는 문자열을, %n은 줄바꿈을 의미합니다.
	}

}