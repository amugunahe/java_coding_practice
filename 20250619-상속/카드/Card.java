package com.inher;

public class Card {

	// 상수는 대문자로 표기하며, static final을 사용하여 클래스 수준에서 고정된 값을 가집니다.
	// 'static'은 Card 객체를 만들지 않아도 'Card.KIND_MAX'처럼 바로 사용할 수 있게 해줍니다.
	// 'final'은 한 번 정해지면 값을 바꿀 수 없다는 의미입니다.

	// 카드 무늬의 최대 종류 수 (총 4가지 무늬)
	static final int KIND_MAX = 4;
	// 각 무늬별 카드 수 (A, 2~10, J, Q, K -> 총 13장)
	static final int NUM_MAX = 13;

	// 각 카드 무늬를 나타내는 상수 정의 (값을 정해두어 나중에 헷갈리지 않게 함)
	static final int SPADE = 4;   // 스페이드 무늬는 4
	static final int DIAMOND = 3; // 다이아몬드 무늬는 3
	static final int HEART = 2;   // 하트 무늬는 2
	static final int CLOVER = 1;  // 클로버 무늬는 1

	int kind;   // 이 카드의 무늬를 저장하는 변수 (예: SPADE, DIAMOND)
	int number; // 이 카드의 숫자를 저장하는 변수 (예: 1, 7, 13)

	// 기본 생성자: Card 객체를 'new Card()'처럼 만들 때 호출됩니다.
	// 기본적으로 스페이드 1 (Ace) 카드를 만듭니다.
	public Card() {
		this(SPADE, 1); // 다른 생성자(kind, number를 받는 생성자)를 호출하여 초기화합니다.
	}
	
	// '무늬'와 '숫자'를 받아서 Card 객체를 만드는 생성자
	public Card(int kind, int number) {
		this.kind = kind;     // 매개변수로 받은 kind를 이 Card 객체의 kind에 저장
		this.number = number; // 매개변수로 받은 number를 이 Card 객체의 number에 저장
	}
	
	// 객체를 문자열로 표현할 때 자동으로 호출되는 메서드 (예: System.out.println(card_object);)
	@Override // 부모 클래스인 Object의 toString() 메서드를 재정의한다는 의미입니다.
	public String toString() {
		// 무늬 상수에 해당하는 이름을 찾아오기 위한 배열 (인덱스 0은 비워두고 1부터 시작)
		String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
		
		// 카드 숫자에 해당하는 문자를 찾아오기 위한 문자열 (인덱스 0은 무시하고 1부터 사용)
		// '0'은 자리 맞춤용이고, 1~9는 숫자, 'X'는 10, 'J'는 11, 'Q'는 12, 'K'는 13을 나타냅니다.
		String numbers= "0123456789XJQK";
		
		// "kind:SPADE, number:A"와 같은 형식의 문자열을 반환합니다.
		// this.kind (4, 3, 2, 1 중 하나)를 kinds 배열의 인덱스로 사용하여 무늬 이름을 가져오고,
		// this.number (1~13)를 numbers 문자열의 인덱스로 사용하여 숫자 문자를 가져옵니다.
		return "kind:" + kinds[this.kind] + ", number:" + numbers.charAt(this.number);
	}
}
