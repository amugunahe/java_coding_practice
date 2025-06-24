package com.inher; // 이 코드는 'com.inher' 패키지에 들어있음.

public class Card { // 'Card'라는 이름의 설계도. 카드 한 장 만드는 용도임.

	// ★★★ 중요 상수들 (static final) ★★★
	// 'static'은 카드 객체 없어도 'Card.KIND_MAX'처럼 바로 쓸 수 있다는 뜻.
	// 'final'은 한 번 정하면 절대로 못 바꿈. 고정값임.

	static final int KIND_MAX = 4; // 카드 무늬 최대 4종류 (스페이드, 다이아, 하트, 클로버)
	static final int NUM_MAX = 13; // 각 무늬별 카드 수 13장 (A, 2~K)

	// 각 카드 무늬를 숫자로 정해놓은 거임. (헷갈리지 않게)
	static final int SPADE = 4;
	static final int DIAMOND = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;

	int kind; // 이 카드의 무늬 (위의 SPADE, DIAMOND 같은 값 들어감)
	int number; // 이 카드의 숫자 (1~13까지)

	// --- 생성자 (카드 만드는 놈) ---

	// 1. 기본 생성자: 'new Card()' 하면 얘 호출됨.
	// 기본으로 스페이드 1 (A) 카드를 만들어 줌.
	public Card() {
		this(SPADE, 1); // ★중요: 아래 '무늬, 숫자 받는 생성자'를 호출해서 초기화함. (코드 재활용)
	}

	// 2. 무늬랑 숫자를 받아서 카드 만드는 생성자
	public Card(int kind, int number) {
		this.kind = kind;     // 입력받은 무늬를 이 카드의 'kind'에 저장.
		this.number = number; // 입력받은 숫자를 이 카드의 'number'에 저장.
	}

	// --- 메서드 (카드 기능) ---

	@Override // ★필수★ 부모 클래스(Object)의 toString()을 재정의(Override)한다는 표시.
	public String toString() { // 이 카드를 문자열로 보여줄 때 자동으로 호출됨. (예: System.out.println(카드객체))

		// 카드 무늬 이름 매칭용 배열 (인덱스 0은 비워둠)
		String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
		
		// 카드 숫자/문자 매칭용 문자열 (1은 1, 10은 X, 11은 J, 12는 Q, 13은 K)
		String numbers = "0123456789XJQK";
		
		// "kind:SPADE, number:A" 같은 형식으로 만들어서 반환함.
		// this.kind로 무늬 이름 가져오고, this.number로 숫자 문자 가져옴.
		return "kind:" + kinds[this.kind] + ", number:" + numbers.charAt(this.number);
	}
}
