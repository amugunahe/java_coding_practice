package com.inher; // 이 코드는 'com.inher' 패키지에 들어있음.

/*
  ★★★ 상속 (Inheritance)이란? ★★★
  - 기존 클래스(부모)의 변수랑 메서드를 물려받아 새 클래스(자식) 만드는 기술.
  - ★핵심: 코드 재활용!★ 중복 줄이고 효율적으로 개발 가능.
 
  상속받는 방법:
  `public class 자식클래스 extends 부모클래스 { ... }` ← 이렇게 'extends' 쓰면 됨.
 
  상속 관계 용어:
  - 조상 클래스 (Parent/Super/Base Class): 물려주는 놈.
  - 자손 클래스 (Child/Sub/Derived Class): 물려받는 놈.
 
  ★정리: 자식은 부모 거 다 물려받고, 자기 거 추가하거나 물려받은 거 자기 맘대로 바꿀 수 있음.★
 */

import java.io.IOException; // 파일 입출력 오류 처리용.

import java.sql.SQLException; // 데이터베이스 오류 처리용. (여기선 안 쓰지만 그냥 냅둠)

public class Parent { // 'Parent'라는 이름의 설계도. 다른 클래스들의 부모가 될 수 있음.

	int age; // 부모 클래스의 나이 변수. 자식 클래스도 얘 쓸 수 있음.
	int x = 10; // 'x'라는 변수. 초기값 10. 얘도 자식 클래스에 상속됨.

	// 'parentMethod'라는 메서드.
	// 'void'는 결과값 안 돌려준다는 뜻.
	// 'throws IOException, SQLException'은 이 메서드 실행하다가 저런 오류 날 수 있다고 미리 알려주는 거임.
	// (호출하는 쪽에서 이 오류들 처리할 준비해야 함)
	void parentMethod() throws IOException, SQLException {
		// 여기엔 아직 코드 없음.
		// 자식 클래스에서 이 메서드 물려받아 지 맘대로 기능 구현할 수 있음. (이게 ★오버라이딩★)
	}

}
