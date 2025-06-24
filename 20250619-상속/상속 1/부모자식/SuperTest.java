package com.inher; // 이 코드는 'com.inher' 패키지에 들어있음.

public class SuperTest { // 'SuperTest'라는 이름의 설계도. 주로 다른 클래스 테스트/실행용.

	// ★★★ 프로그램 시작점 (메인 메서드) ★★★
	public static void main(String[] args) {
		// `main` 메서드 안의 코드가 프로그램 시작하면 가장 먼저 실행됨.

		// 1. 'Child' 클래스의 새 객체('인스턴스')를 만듦.
		// ★개중요★ 'c'라는 이름의 변수에 이 Child 객체를 저장함.
		// 이 순간, Child 객체가 만들어지면서 그 안에 부모인 Parent 부분이랑 Child 자기 부분이 전부 준비됨.
		Child c = new Child();

		// 2. 'c' 객체가 가지고 있는 'method()' 기능을 호출(실행)함.
		// 이 `method()`는 Child 클래스에 정의된 그 메서드임.
		// 이걸 실행하면 Child의 `method()` 안에 있는 출력 구문들이 차례로 실행됨.
		// (여기서 `x`, `this.x`, `super.x` 값들을 볼 수 있을 거임!)
		c.method(); 

	}
}
