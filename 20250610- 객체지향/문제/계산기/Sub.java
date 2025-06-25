package com.functionex; // 이 Sub 클래스가 'com.functionex'라는 폴더(패키지)에 속해 있다는 뜻.

public class Sub { // 'Sub'라는 이름의 공개 클래스(설계도)를 정의한다.

	private int a; // 'a'라는 이름의 정수형(int) 변수를 선언. 이건 'Sub' 객체만의 '첫 번째 숫자' 속성이다.
	               // 'private'이라 이 클래스 안에서만 직접 접근 가능. 밖에서는 못 건드린다.
	private int b; // 'b'라는 이름의 정수형(int) 변수를 선언. 이건 'Sub' 객체만의 '두 번째 숫자' 속성이다.
	               // 얘도 'private'이라 밖에서 직접 못 건드림.

	// 이 메서드는 'Sub' 객체의 'a'와 'b' 변수에 값을 설정하는 역할을 한다.
	public void setValue(int a, int b) { // 'setValue'라는 공개 메서드. int형 변수 두 개를 입력받는다.
		this.a = a; // 'this.a'는 이 'Sub' 객체 자체의 멤버 변수 'a'를 말한다.
		            // 매개변수로 넘어온 'a' 값을 이 객체의 'a'에 저장한다.
		this.b = b; // 'this.b'는 이 'Sub' 객체 자체의 멤버 변수 'b'를 말한다.
		            // 매개변수로 넘어온 'b' 값을 이 객체의 'b'에 저장한다.
	}

	// 이 메서드는 'Sub' 객체에 저장된 두 수('a'와 'b')를 빼서 그 결과를 반환한다.
	public int calculate() { // 'calculate'라는 공개 메서드. 어떤 값도 입력받지 않고 정수형(int) 값을 반환한다.
		return a - b; // 이 객체의 멤버 변수 'a'에서 'b'를 뺀 결과를 호출한 곳으로 돌려준다.
	}
}
