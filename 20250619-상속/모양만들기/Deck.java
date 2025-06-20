package com.inher;

public class Deck {

	final int CARD_NUM = 52; // 카드 덱에 들어갈 전체 카드 수 (상수)
	Card cardArr[] = new Card[CARD_NUM]; // Card 객체들을 저장할 배열 (총 52칸)

	// Deck 생성자: Deck 객체를 'new Deck()'처럼 만들 때 호출됩니다.
	// 이 생성자 안에서 52장의 모든 카드를 만들어서 cardArr 배열에 채워 넣습니다.
	public Deck() {
		int i = 0; // cardArr 배열의 인덱스를 관리할 변수
		// 카드 무늬 (KIND_MAX = 4 즉 SPADE)부터 시작해서 CLOVER (1)까지 반복
		for (int k = Card.KIND_MAX; k > 0; k--) {
			// 각 무늬별로 0부터 NUM_MAX-1 (즉, 12)까지 반복 (숫자 1~13을 위해)
			for (int n = 0; n < Card.NUM_MAX; n++) {
				// 새로운 Card 객체를 생성하여 cardArr 배열에 순서대로 저장합니다.
				// 'k'는 무늬, 'n+1'은 숫자 (1부터 13까지)를 의미합니다.
				cardArr[i++] = new Card(k, n + 1);
			}
		}
	}

	// 지정된 위치(index)에 있는 카드를 하나 꺼내서 반환하는 메서드
	Card pick(int index) {
		// 만약 index가 유효한 범위를 벗어나면 (음수이거나 51보다 크면)
		if (index < 0 || index >= CARD_NUM) {
			// 에러 메시지를 출력하고 null을 반환하거나, 적절한 예외를 던질 수 있습니다.
			// 현재 코드는 이 부분을 생략하고 있으므로, 잘못된 인덱스 시 배열 에러가 날 수 있습니다.
			// (초보자 단계에서는 일단 넘어가도 됩니다.)
		}
		return cardArr[index]; // 배열의 해당 인덱스에 있는 Card 객체를 반환합니다.
	}

	// Deck에서 무작위로 카드 하나를 선택해서 반환하는 메서드 (오버로딩)
	// pick(int index) 메서드를 활용하여 구현됩니다.
	Card pick() {
		// Math.random()은 0.0 (포함) ~ 1.0 (제외) 사이의 double 값을 반환합니다.
		// 여기에 CARD_NUM(52)을 곱하면 0.0 ~ 51.999... 사이의 값이 되고,
		// (int)로 형 변환하면 소수점 아래가 버려져 0부터 51까지의 정수 인덱스를 얻게 됩니다.
		int index = (int)(Math.random() * CARD_NUM);
		return pick(index); // 무작위로 생성된 인덱스를 사용하여 pick(int index)를 호출합니다.
	}

	// 카드의 순서를 무작위로 섞는 메서드 (셔플)
	public void shuffle() {
		// 모든 카드(52장)를 한 번씩 순회하며 섞습니다.
		for (int i = 0; i < CARD_NUM; i++) { // cardArr.length 대신 CARD_NUM을 사용해도 됩니다.
			// 0부터 CARD_NUM-1 (51) 사이의 무작위 인덱스 'r'을 생성합니다.
			int r = (int)(Math.random() * CARD_NUM);
		
			// 현재 위치의 카드(cardArr[i])와 무작위 위치의 카드(cardArr[r])의 자리를 바꿉니다.
			Card temp = cardArr[i]; // 1. 현재 카드를 임시 변수 temp에 저장합니다.
			cardArr[i] = cardArr[r]; // 2. 무작위 위치의 카드를 현재 위치로 옮깁니다.
			cardArr[r] = temp;       // 3. 임시 저장했던 카드를 무작위 위치로 옮깁니다. (교환 완료)
		}
	}
}
