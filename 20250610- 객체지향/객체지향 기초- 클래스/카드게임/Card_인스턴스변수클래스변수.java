package com.objectex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  Card 클래스: **카드 한 장의 정보를 존나게 깔끔하게 저장하는 설계도다!**
 
  핵심:
  - **인스턴스 변수 (`kind`, `number`):**
  - `static` 키워드가 없다.
  - `Card` 객체를 만들 때마다 **각 객체마다 고유한 값**을 가진다! (이 카드 저 카드 무늬랑 숫자 다 다르겠지?)
  - **클래스 변수 (`width`, `height`):**
  - **`static` 키워드가 붙어있다!** (존나 중요!)
  - 이 변수들은 `Card` 클래스가 메모리에 **딱 한 번 로딩될 때** 만들어진다.
  - `Card` 객체를 몇 개를 만들든, **모든 `Card` 객체가 이 `width`와 `height` 값을 ★공유★한다!**
  - 그래서 어떤 객체를 통해서 `width`나 `height`를 바꾸면, **다른 모든 `Card` 객체에서도 바뀐 값을 보게 된다!** (자판기 메뉴 바꾸는 거랑 비슷하다!)
 */

public class Card { // 'Card'라는 이름의 공개(public) 클래스를 정의한다.
	
	// 속성: 변수 -> 클래스 변수, 인스턴스 변수
	
	// 1. 인스턴스 변수 (Instance Variable)
	// 'static' 키워드가 붙어있지 않아요.
	// 이 변수들은 `Card` 클래스로부터 **객체(인스턴스)가 만들어질 때마다 각각 고유하게 생성**됩니다.
	// 예를 들어, 하트 7 카드와 스페이드 4 카드를 만들면, 각 카드는 자신만의 무늬(kind)와 숫자(number)를 가지게 돼요.
	String kind;  // 카드의 '무늬' (예: "Heart", "Spade")를 저장할 문자열(String) 변수
	int number;   // 카드의 '숫자' (예: 7, 4)를 저장할 정수(int) 변
	
	// 2. 클래스 변수 (Class Variable = Static Variable)
	// 'static' 키워드가 붙어있어요.
	// 이 변수들은 `Card` **클래스 자체에 속하며**, `Card` 클래스가 메모리에 **로딩될 때 딱 한 번 생성**됩니다.
	// 따라서 이 `Card` 클래스로부터 아무리 많은 카드 객체(`new Card()`)를 만들더라도,
	// 모든 카드 객체들이 이 `width`와 `height` 값을 **함께 공유**하게 됩니다.
	// 카드 한 장의 너비나 높이가 바뀌면, 모든 카드의 너비나 높이가 함께 바뀌는 것과 같아요.
	static int width = 100; // 모든 카드의 '너비'를 100으로 초기화
	static int height = 200; // 모든 카드의 '높이'를 200으로 초기화
}

/*
  CardExam 클래스: **`Card` 클래스의 '인스턴스 변수'와 '클래스 변수'의 차이를 존나게 직접 보여주는 프로그램이다!**
 
  핵심:
  - **클래스 변수 직접 접근:** `Card.width`처럼 '클래스 이름.변수이름'으로 객체 생성 없이 바로 접근할 수 있다!
  - **객체 생성:** `new Card()`로 'Card' 객체(`c1`, `c2`)를 두 개 만들어서 서로 다른 인스턴스 변수를 가지게 한다.
  - **클래스 변수 공유 확인:** `c1.width = 50;`처럼 특정 객체를 통해 `static` 변수를 바꾸면,
  다른 객체(`c2.width`)를 통해서도 **바뀐 값이 보이는지 존나게 확인한다!** (이게 `static`의 핵심!)
 */

public class CardExam { // 'CardExam'이라는 이름의 공개(public) 클래스를 정의한다.

	// ★★★ 프로그램 시작점 (메인 메소드) ★★★
	public static void main(String[] args) { // `main` 메소드부터 프로그램이 실행된다.
		
		// --- 1. 클래스 변수(static 변수)에 직접 접근 (객체 생성 전에도 가능!) ---
		// 'Card' 클래스의 'width'와 'height'는 `static` 변수이므로,
		// 'Card' 객체를 만들지 않고도 '클래스 이름.변수이름' 형식으로 바로 접근할 수 있다. (존나 편하다!)
		System.out.println("Card.width (클래스 직접 접근): " + Card.width);    // 출력: Card.width (클래스 직접 접근): 100
		System.out.println("Card.height (클래스 직접 접근): " + Card.height);  // 출력: Card.height (클래스 직접 접근): 250
		
		/* 주석 설명: 클래스 변수는 객체 생성없이 클래스 이름.변수로 직접 사용 가능하다. (존나 중요!) */
		System.out.println(); // 줄 바꿈

		// --- 2. 첫 번째 Card 객체(`c1`) 생성 및 인스턴스 변수 설정 ---
		Card c1 = new Card(); // 새로운 'Card' 객체를 메모리에 만들고, 그 주소를 `c1` 변수에 저장한다.
		                      // `c1`은 자신만의 독립적인 `kind`와 `number`를 가진다.
		c1.kind = "Heart";    // `c1` 객체의 `kind`를 "Heart"로 설정
		c1.number = 7;        // `c1` 객체의 `number`를 7로 설정
		
		// --- 3. 두 번째 Card 객체(`c2`) 생성 및 인스턴스 변수 설정 ---
		Card c2 = new Card(); // 또 다른 새로운 'Card' 객체를 메모리에 만들고, 그 주소를 `c2` 변수에 저장한다.
		                      // `c2`는 `c1`과 독립적으로 자신만의 `kind`와 `number`를 가진다.
		c2.kind = "Spade";    // `c2` 객체의 `kind`를 "Spade"로 설정
		c2.number = 4;        // `c2` 객체의 `number`를 4로 설정

		/* (이 시점에서 메모리 상의 상황)
		  Card 클래스:
		  static width = 100
		  static height = 250
		 
		  c1 객체: (인스턴스)
		  kind = "Heart"
		  number = 7
		 
		  c2 객체: (인스턴스)
		  kind = "Spade"
		  number = 4
		 
		  *주의: `c1.width`와 `c2.width`는 사실 `Card.width`와 같은 메모리 공간을 가리킨다!*
		 */
		
		System.out.println(); // 줄 바꿈

		// --- 4. `c1`과 `c2`의 인스턴스 변수 및 클래스 변수 값 출력 (변경 전) ---
		// 인스턴스 변수는 각 객체에 따라 다르고, 클래스 변수는 모든 객체에서 동일하게 보인다.
		System.out.println("--- 변경 전 객체들의 값 ---");
		System.out.println("c1은 " + c1.kind + ", " + c1.number +
				"이며, 크기는 (" + c1.width + ", " + c1.height + ")");
		// 출력: c1은 Heart, 7이며, 크기는 (100, 250) <- c1은 static width, height를 가져옴
		System.out.println("c2은 " + c2.kind + ", " + c2.number +
				"이며, 크기는 (" + c2.width + ", " + c2.height + ")");
		// 출력: c2은 Spade, 4이며, 크기는 (100, 250) <- c2도 static width, height를 가져옴
		System.out.println(); // 줄 바꿈
		
		System.out.println("c1의 width와 height를 각각 150, 300으로 변경합니다.");

		// --- 5. 클래스 변수 값 변경 (인스턴스 참조 변수를 통해) ---
		// `c1.width = 150;`과 `c1.height = 300;`은 `Card.width = 150;`과 `Card.height = 300;`과 완전히 동일한 의미다.
		// 즉, `c1`이라는 객체를 통해 `Card` 클래스에 속한 `static` 변수의 값을 변경하는 것이므로,
		// 이 변경은 `Card` 클래스의 모든 인스턴스에 존나게 영향을 미친다! (핵심!)
		c1.width = 150;    // Card.width가 150으로 변경됨 (c2에도 영향!)
		c1.height = 300;   // Card.height가 300으로 변경됨 (c2에도 영향!)

		/* (이 시점에서 메모리 상의 상황)
		  Card 클래스:
		  static width = 150 (값이 변경됨)
		  static height = 300 (값이 변경됨)
		 
		  c1 객체: (인스턴스)
		  kind = "Heart"
		  number = 7
		 
		  c2 객체: (인스턴스)
		  kind = "Spade"
		  number = 4
		 
		  *주의: `c1.width`와 `c2.width`는 이제 모두 변경된 150, 300을 가리킨다!*
		 */
		
		System.out.println(); // 줄 바꿈

		// --- 6. 변경된 값 다시 출력 (클래스 변수의 변화 확인) ---
		// `c1`을 통해 변경했지만, `c2`를 통해서도 변경된 `width`와 `height` 값을 볼 수 있다! (이것이 공유의 힘!)
		System.out.println("--- 변경 후 객체들의 값 ---");
		System.out.println("c1은 " + c1.kind + ", " + c1.number +
				"이며, 크기는 (" + c1.width + ", " + c1.height + ")");
		// 출력: c1은 Heart, 7이며, 크기는 (150, 300)
		System.out.println("c2은 " + c2.kind + ", " + c2.number +
				"이며, 크기는 (" + c2.width + ", " + c2.height + ")");
		// 출력: c2은 Spade, 4이며, 크기는 (150, 300) <- c2도 변경된 width, height를 가져옴
		
		/* 주석 설명:
		  인스턴스 변수는 인스턴스(객체)가 생성될 때마다 생성되므로
		  인스턴스마다 각기 다른 값을 유지할 수 있지만,
		 
		  클래스 변수는 모든 인스턴스가 하나의 저장공간을 공유하므로
		  항상 공통된 값을 갖는다. (존나 중요!)
		 */
	}
}
