package com.inher;

public class Point { // 2차원 평면상의 '점'을 나타내는 클래스

	int x; // 점의 x 좌표
	int y; // 점의 y 좌표

	// x와 y 좌표를 받아서 점을 만드는 생성자
	public Point(int x, int y) {
		this.x = x; // 매개변수 x를 이 Point 객체의 x에 저장
		this.y = y; // 매개변수 y를 이 Point 객체의 y에 저장
	}

	// 기본 생성자: x, y 좌표를 모두 0으로 초기화하는 점을 만듭니다.
	public Point() {
		this(0, 0); // 다른 생성자(x, y를 받는 생성자)를 호출하여 0,0으로 초기화합니다.
	}

	// 점의 x, y 좌표를 "(x,y)" 형태의 문자열로 반환하는 메서드
	String getXY() {
		return "(" + x + "," + y + ")";
	}
	
	String getLocation() {
		return "x: " + x + ",y:" + y;
	}
}
