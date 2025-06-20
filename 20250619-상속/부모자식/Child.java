package com.inher;

/* 생성자와 초기화 블럭은 상속되지 않는다. 멤버만 상속됨
  자손 클래스의 멤버 개수는 조상 클래스보다 항상 같거나 많다. 
 */

import java.io.IOException; // IOException 클래스를 사용하기 위해 임포트 추가
import java.sql.SQLException; // <--- 이 줄이 추가되어야 합니다!

public class Child extends Parent {
	
	int x = 20;

	@Override
	void parentMethod() { // 이 메서드는 IOException만 던져도 문제가 없습니다.
		System.out.println("여기는 자식 클래스임당");
	}
	
	void parentMethod(int i) throws IOException {
		System.out.println("여기는 자식 클래스임당 (오버로딩 - int i)");
	}

	void parentMethod(int i, int j) throws IOException {
		System.out.println("여기는 자식 클래스임당 (오버로딩 - int i, int j)");
	}
	
	void play() {
		System.out.println("놀자~~~~");
	}

	void method() {
		System.out.println("x: " + x);
		System.out.println("this.x: " + this.x);
		System.out.println("super.x: " + super.x); // 'Super'를 'super'로 수정했습니다.
	}
}