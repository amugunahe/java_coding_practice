package com.overex; // 이 코드는 'com.overex' 패키지에 있음.

class Rect { // 'Rect'라는 클래스. 사각형 기능 담당.

	// 1. 멤버 변수 (속성)
	private int w, h; // ★중요: 'private'이라 Rect 클래스 안에서만 직접 쓸 수 있음.
					  // w(너비), h(높이) 저장용. 객체 만들 때마다 자기만의 w, h 가짐.

	// 2. 사각형 넓이 계산 메서드
	public int area() { // 매개변수 없음.
		return w * h; // 멤버 변수 w, h 곱해서 반환. (★`this.w * this.h`라고 써도 똑같음.)
	}

	// 3. 결과 출력 메서드
	public void write(int result) {
		System.out.println("결과: " + result);
	}

	// 4. 너비, 높이 값 설정 메서드 (★`this` 키워드 사용!)
	public void setData(int w, int h) { // 매개변수 w, h는 이 메서드 안에서만 유효한 '지역 변수'임.
		this.w = w; // ★★★존나중요★★★ 'this.w'는 클래스의 '멤버 변수 w'.
					// 그냥 'w'는 매개변수로 넘어온 '지역 변수 w'.
					// 이렇게 이름이 같을 때 `this` 써서 멤버 변수임을 명확히 함.
		this.h = h; // 'this.h'는 클래스의 '멤버 변수 h'.
					// '= h'는 매개변수로 넘어온 '지역 변수 h'의 값을 멤버 변수 h에 대입.
	}

} // Rect 클래스 끝

public class ThisEx { // 프로그램 실행용 메인 클래스.

	// ★★★ 프로그램 시작점 (메인 메서드) ★★★
	public static void main(String[] args) {

		// 1. Rect 객체('사각형' 객체) 생성
		// 'new Rect()' 하면 메모리에 실제 사각형 객체가 만들어지고, 'r' 변수가 얘를 가리킴.
		// 'r'은 자기만의 w, h 변수를 가짐. (초기값은 0)
		Rect r = new Rect();

		// 2. 사각형의 너비, 높이 설정
		r.setData(10, 5); // r 객체의 `setData` 호출.
						  // `setData` 안에서 `this.w = 10;`, `this.h = 5;` 실행돼서
						  // r 객체의 w는 10, h는 5가 됨.

		// 3. 사각형 넓이 계산
		int a = r.area(); // r 객체의 `area` 호출.
						  // r의 w(10)와 h(5)로 넓이(50) 계산. 계산값 50이 'a'에 저장.

		// 4. 결과 출력
		r.write(a); // r 객체의 `write` 호출. 'a'의 값(50) 넘겨줌.
					// "결과: 50" 출력.
	}
}
