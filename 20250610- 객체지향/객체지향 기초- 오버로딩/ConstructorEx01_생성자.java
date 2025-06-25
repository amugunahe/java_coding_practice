package com.overex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  ConstructorEx01 클래스: **생성자(Constructor)의 모든 것을 존나게 파헤치는 예제!**
 
  핵심:
  - **생성자 기본 개념**: 객체 만들 때 자동으로 호출돼서 변수 초기화하는 놈.
  - **기본 생성자**: 니가 안 만들면 자바가 알아서 만들어주는 착한 새끼. (근데 니가 하나라도 만들면 안 만들어줌!)
  - **생성자 오버로딩**: 이름은 같은데 매개변수 다르게 해서 여러 방식으로 객체를 초기화하는 거.
  - **`this` 키워드**: 변수 이름 헷갈릴 때 "이 객체 자신의 변수"라고 지칭하는 존나 유용한 놈.
  - **형 변환**: `long`을 `int`에 넣을 때처럼 크기 다르면 강제로 바꿔줘야 하는 거.
 */

// --- Data1 클래스: 기본 생성자 테스트용 ---
// 니가 직접 생성자를 안 만들면 자바가 기본 생성자를 자동으로 넣어준다!
class Data1 {
	int value; // 그냥 int 변수. (자동으로 0으로 초기화됨)
}

// --- Data2 클래스: 매개변수 있는 생성자 테스트용 ---
// 니가 생성자를 하나라도 직접 만들면, 자바는 기본 생성자를 자동으로 안 넣어준다!
// 그래서 이 새끼는 무조건 'new Data2(값)'처럼 값을 넣어서 만들어야 한다.
class Data2 {
	int value;

	public Data2(int x) { // 매개변수 'x'를 받는 생성자.
		value = x; // 받은 'x' 값으로 'value'를 초기화!
	}
}

// --- ConstructorEx01 클래스: 다양한 생성자 오버로딩 테스트 ---
public class ConstructorEx01 {

	private int n; // 이 클래스 안에서만 쓸 수 있는 변수 'n'.

	// 1. 기본 생성자 (매개변수 없음)
	public ConstructorEx01() {
		n = 10; // 'n'을 10으로 초기화한다.
	}
	
	// 2. 생성자 오버로딩: int 매개변수 받는 생성자.
	// ★ 핵심: 이름은 같지만 매개변수 타입이 달라서 여러 개의 생성자를 만들 수 있다! ★
	public ConstructorEx01(int n) {
		this.n = n; // ★ 존나 중요! 'this.n'은 "이 객체 자신의 변수 n"이다. 그냥 'n'은 매개변수! ★
	}
	
	// 3. 생성자 오버로딩: long 매개변수 받는 생성자.
	public ConstructorEx01(long n) {
		// long은 int보다 존나게 크다. 그래서 int에 넣으려면 '(int)'로 강제로 형 변환(Type Casting)해야 한다!
		this.n = (int)n;
	}
	
	// 4. 생성자 오버로딩: short 매개변수 받는 생성자.
	public ConstructorEx01(short s) {
		// short는 int보다 존나게 작다. 그래서 int에 넣을 땐 자동으로 형 변환(자동 Type Casting)된다!
		this.n = s;
	}
	
	// 'n' 값을 화면에 출력하는 메소드.
	public void write() {
		System.out.println("n: " + n);
	}

	// ★★★ 프로그램 시작점 ★★★
	public static void main(String[] args) {
		// --- Data1 객체 테스트 ---
		// 생성자 없어도 자바가 준 기본 생성자로 만들어진다. (value는 0으로 초기화됨)
		Data1 d1 = new Data1(); 
		// System.out.println("d1.value: " + d1.value); // 확인해봐라, 0 나올 거다.

		// --- Data2 객체 테스트 ---
		// 매개변수 있는 생성자만 있기 때문에 무조건 값을 넣어야 만들어진다.
		Data2 d2 = new Data2(10); 
		// System.out.println("d2.value: " + d2.value); // 확인해봐라, 10 나올 거다.

		// --- ConstructorEx01 객체 생성 및 테스트 ---
		// 1. 기본 생성자 호출: n = 10으로 초기화된다.
		ConstructorEx01 c = new ConstructorEx01();
		c.write(); // 출력: n: 10

		// 2. int 매개변수 생성자 호출: n = 20으로 초기화된다.
		ConstructorEx01 c2 = new ConstructorEx01(20);
		c2.write(); // 출력: n: 20

		// 3. long 매개변수 생성자 호출: n = 30으로 초기화된다. (30L은 long 타입 상수)
		ConstructorEx01 c3 = new ConstructorEx01(30L);
		c3.write(); // 출력: n: 30

		// (추가) 4. short 매개변수 생성자 호출: n = 40으로 초기화된다. (short는 자동으로 int로 변환됨)
		short shortValue = 40;
		ConstructorEx01 c4 = new ConstructorEx01(shortValue);
		c4.write(); // 출력: n: 40
	}
}
