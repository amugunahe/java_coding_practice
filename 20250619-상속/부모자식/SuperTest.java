package com.inher; // 이 코드가 속한 패키지 이름입니다.

public class SuperTest { // 'SuperTest'라는 이름의 클래스를 정의합니다. 이 클래스는 주로 다른 클래스들의 기능을 테스트하거나 실행하는 역할을 합니다.

	public static void main(String[] args) { // ★★★ 프로그램의 시작점 ★★★
		// 이 `main` 메서드 안의 코드가 프로그램이 실행될 때 가장 먼저 동작합니다.
		// `public static void`는 이 메서드가 외부에서 접근 가능하고(public),
		// 객체를 생성하지 않고도 바로 실행할 수 있으며(static),
		// 어떤 결과 값도 반환하지 않는다는(void) 의미입니다.
		// `String[] args`는 프로그램 실행 시 외부에서 어떤 값을 전달받을 때 사용하는데, 여기서는 사용하지 않습니다.

		Child c = new Child(); // 1. 'Child' 클래스의 새로운 '객체(인스턴스)'를 생성합니다.
								// 'c'라는 이름의 변수에 이 새로 만들어진 Child 객체를 저장합니다.
								// 이제 'c'는 실제 TV처럼 동작할 수 있는 'Child' 타입의 무언가라고 생각하시면 돼요.
								// 이 시점에 Child 객체가 생성되면서, 그 안에 상속받은 Parent의 부분과 Child 자신의 부분이 모두 준비됩니다.

		c.method(); // 2. 'c' 객체가 가지고 있는 'method()' 기능을 호출(실행)합니다.
					// 이 'method()'는 Child 클래스에 정의되어 있던 그 메서드입니다.
					// 이 메서드를 실행하면 Child 클래스의 `method()` 안에 있는 `System.out.println` 구문들이 차례로 실행될 거예요.

	}
}
