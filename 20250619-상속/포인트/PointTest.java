package com.inher; // 이 코드가 속한 패키지 이름입니다.

public class PointTest { // 'PointTest'라는 이름의 클래스를 정의합니다. 이 클래스는 주로 다른 클래스들의 기능을 테스트하거나 실행하는 역할을 합니다.

	public static void main(String[] args) { // ★★★ 프로그램의 시작점 ★★★
		// 이 `main` 메서드 안의 코드가 프로그램이 실행될 때 가장 먼저 동작합니다.
		// `public static void`는 이 메서드가 외부에서 접근 가능하고(public),
		// 객체를 생성하지 않고도 바로 실행할 수 있으며(static),
		// 어떤 결과 값도 반환하지 않는다는(void) 의미입니다.
		// `String[] args`는 프로그램 실행 시 외부에서 어떤 값을 전달받을 때 사용하는데, 여기서는 사용하지 않습니다.

		Point3D p3 = new Point3D(); // 1. 'Point3D' 클래스의 새로운 '객체(인스턴스)'를 생성합니다.
									// 'p3'라는 이름의 변수에 이 새로 만들어진 Point3D 객체를 저장합니다.
									// 이 시점에 Point3D 객체가 생성되면서, 그 안에 상속받은 Point의 부분과 Point3D 자신의 부분이 모두 준비됩니다.
									// Point3D의 기본 생성자 `Point3D()`는 `this(100, 200, 300);`을 호출했었죠.
									// 따라서 `p3` 객체의 x, y, z 좌표는 각각 100, 200, 300으로 초기화됩니다.

		System.out.println(p3.getLocation()); // 2. 'p3' 객체가 가지고 있는 'getLocation()' 기능을 호출(실행)하고, 그 결과를 화면에 출력합니다.
											// 'getLocation()'은 Point3D 클래스에서 **오버라이딩**했던 바로 그 메서드입니다.
											// 이 메서드는 `x`, `y`, `z` 좌표를 포함하는 문자열을 반환하도록 재정의되어 있었죠.
	}
}
