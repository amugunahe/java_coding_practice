package com.overex; // 이 코드는 'com.overex' 패키지에 들어있음.

/*
  ★★★ 생성자 (Constructor)란? ★★★
  - 객체 만들 때 ★자동으로 호출★되는 초기화 메서드.
  - 주로 객체 안의 변수(필드)들 초기화할 때 씀.
  - 조건: 1. 클래스 이름이랑 똑같아야 함. 2. 리턴값 없음 (void 안 붙임).
 */

class Data1 {
	int value; // 명시적으로 생성자 없음.
	// ★핵심★ 생성자 없으면 자바 컴파일러가 'public Data1() {}' 같은 ★기본 생성자★ 자동으로 넣어줌.
}

class Data2 {
	int value;

	public Data2(int x) { // 매개변수 있는 생성자를 직접 정의함.
		// ★중요★ 생성자를 하나라도 직접 만들면, 컴파일러가 ★기본 생성자를 자동으로 안 넣어줌!★
		// 그래서 Data2 객체는 'new Data2(값)'처럼 무조건 값 넣어서 만들어야 함.
		value = x; // 받은 x 값을 'value'에 저장해서 초기화.
	}
}

public class ConstructorEx01 { // 'ConstructorEx01'이라는 이름의 클래스.

	private int n; // 이 클래스 안에서만 쓸 수 있는 변수 'n'.

	// 1. 기본 생성자 (매개변수 없음)
	public ConstructorEx01() {
		n = 10; // 'n'을 10으로 초기화.
	}
	
	// 2. 생성자 오버로딩 (int 매개변수)
	// ★생성자 오버로딩: 이름 같은 생성자를 여러 개 만들 때, 매개변수(타입이나 개수)가 달라야 함.
	// → 객체를 여러 방식으로 초기화할 수 있게 해줌.
	public ConstructorEx01(int n) {
		this.n = n; // ★중요★ 'this.n'은 "이 객체의 변수 n", 그냥 'n'은 "매개변수 n".
					// 이름 같을 때 'this' 써서 구분함. 받은 n 값으로 인스턴스 변수 'n' 초기화.
	}
	
	// 3. 생성자 오버로딩 (long 매개변수)
	public ConstructorEx01(long n) {
		// long은 int보다 범위 넓음. 데이터 손실 방지 위해 '(int)n'으로 ★강제 형 변환(Type Casting)★해서 넣음.
		this.n = (int)n;
	}
	
	// 4. 생성자 오버로딩 (short 매개변수)
	public ConstructorEx01(short s) {
		// short는 int보다 범위 좁음. 자동으로 int로 확장됨. (★자동 형 변환★)
		this.n = s;
	}
	
	// 'n' 값을 출력하는 메서드.
	public void write() {
		System.out.println("n: " + n);
	}

	// ★★★ 프로그램 시작점 ★★★
	public static void main(String[] args) {
		// Data1 객체: 생성자 없어도 컴파일러가 준 기본 생성자로 만들어짐. (value는 0으로 초기화)
		Data1 d1 = new Data1();

		// Data2 객체: 매개변수 있는 생성자 강제됨. 무조건 값 10 넣어서 만듦.
		Data2 d2 = new Data2(10);

		// ConstructorEx01 객체 생성 및 테스트
		ConstructorEx01 c = new ConstructorEx01();     // 기본 생성자 호출. n = 10
		c.write(); // 출력: n: 10

		ConstructorEx01 c2 = new ConstructorEx01(20);  // int 매개변수 생성자 호출. n = 20
		c2.write(); // 출력: n: 20

		ConstructorEx01 c3 = new ConstructorEx01(30L); // long 매개변수 생성자 호출. n = 30
		c3.write(); // 출력: n: 30

		// ConstructorEx01 객체 생성 (short 매개변수 생성자 호출)
		// 여기 뒤에 'new ConstructorEx01(some_short_value);' 넣어서 테스트 해봐라.
	}
}
