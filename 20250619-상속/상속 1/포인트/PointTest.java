package com.inher; // 이 코드는 'com.inher' 패키지에 속해 있음. (전에 만들었던 'Point'랑 'Point3D'랑 같은 곳이다, 씨발!)

/*
  PointTest 클래스: **'Point3D' 클래스가 존나게 잘 작동하는지 테스트하는 실행 프로그램이다!**
 
  핵심:
  - **목표:** 'Point3D' 객체를 만들고, 그 객체의 '위치(좌표)'를 출력해서 'Point3D'가 제대로 초기화되고 메소드가 작동하는지 확인한다.
  - **`Point3D p3 = new Point3D();`:** 'Point3D' 클래스의 기본 생성자를 써서 객체를 만드는 거다.
  -> 이때 'Point3D' 생성자 안에서 `this(100, 200, 300);`를 호출하기 때문에,
  -> `p3`는 만들어지자마자 x=100, y=200, z=300으로 존나게 초기화된다!
  - **`System.out.println(p3.getLocation());`:** 'p3' 객체의 `getLocation()` 메소드를 호출해서 결과값을 출력한다.
  -> 이 `getLocation()`은 'Point'에서 물려받았지만, 'Point3D'에서 `z` 좌표까지 포함하도록 **지 입맛대로 고쳐 쓴(오버라이딩) 메소드다!**
  -> 그래서 "(x: 100, y: 200, z: 300)" 같은 식으로 존나게 자세한 3차원 좌표가 나올 거다!
 */

public class PointTest { // 'PointTest'라는 이름의 공개(public) 클래스를 선언한다. 이 클래스가 프로그램의 실행 시작점이다!

	// ★★★ 프로그램 시작점 (메인 메소드) ★★★
	// 자바 프로그램이 실행될 때 가장 먼저 실행되는 메소드다.
	// 이 `main` 메소드 안에 있는 코드들이 순서대로 실행될 거다
	public static void main(String[] args) { 
		// 'public static void'는 자바 프로그램의 시작 메소드임을 나타내는 표준 선언이다.
		// 'String[] args'는 프로그램 실행 시 외부에서 전달되는 인자(arguments)를 받을 때 사용하지만, 여기선 안 쓴다.

		// 1. 'Point3D' 클래스의 새로운 객체 'p3'를 존나게 만든다.
		// 'new Point3D()'를 하는 순간, 'Point3D' 클래스의 기본 생성자가 호출된다.
		// 이 기본 생성자는 x, y, z를 각각 100, 200, 300으로 초기화한다!
		Point3D p3 = new Point3D(); 

		// 2. 'p3' 객체의 위치 정보를 존나게 출력한다.
		// 'p3.getLocation()'은 'Point3D' 클래스에서 오버라이딩된 `getLocation()` 메소드를 호출한다.
		// 이 메소드는 `x`, `y`, `z` 좌표를 포함한 문자열을 반환할 거다!
		System.out.println(p3.getLocation()); // 예시 출력: "x: 100, y: 200, z: 300"
	}

}
