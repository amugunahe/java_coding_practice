package com.inher; // 이 코드는 'com.inher' 패키지에 들어있음.

public class Deck { // 'Deck'이라는 이름의 설계도. 52장 카드 뭉치 만드는 용도임.

	final int CARD_NUM = 52; // ★개중요★ 전체 카드 수 (고정값, 못 바꿈)
	Card cardArr[] = new Card[CARD_NUM]; // Card 객체 52개를 담을 배열.

	// --- 생성자 (덱 만드는 놈) ---
	// Deck 객체를 'new Deck()' 하면 얘 호출됨.
	// 52장의 카드를 만들어서 'cardArr' 배열에 꽉 채워 넣음.
	
	public Deck() {
		int i = 0; // 배열 인덱스용 변수

		// ★핵심★ 카드 52장 만드는 이중 반복문
		// 무늬 (SPADE 4)부터 CLOVER (1)까지
		for (int k = Card.KIND_MAX; k > 0; k--) {
			// 각 무늬별로 숫자 1부터 13까지
			for (int n = 0; n < Card.NUM_MAX; n++) {
				cardArr[i++] = new Card(k, n + 1); // 'Card' 객체 만들어서 배열에 순서대로 넣음.
			}
		}
	}

	// --- 메서드 (덱 기능) ---

	// ★카드 한 장 뽑기 1: 특정 위치(index) 카드 뽑기★
	Card pick(int index) {
		// ※주의※ index가 0 미만 또는 51 초과면 배열 에러 날 수 있음. (초보자는 일단 패스)
		return cardArr[index]; // 배열의 해당 인덱스에 있는 카드 반환.
	}

	// ★카드 한 장 뽑기 2: 아무 카드나 무작위로 뽑기★ (오버로딩)
	// pick(int index)를 활용함.
	Card pick() {
		int index = (int)(Math.random() * CARD_NUM); // 0부터 51까지 랜덤 숫자 뽑음.
		return pick(index); // 랜덤 인덱스로 위에 'pick(int index)' 호출.
	}

	// ★★★덱 섞기 (셔플)★★★
	public void shuffle() {
		// 모든 카드(52장)를 한 바퀴 돌면서 무작위로 섞음.
		for (int i = 0; i < CARD_NUM; i++) {
			int r = (int)(Math.random() * CARD_NUM); // 0부터 51까지 랜덤 인덱스 뽑음.
		
			// ★핵심★ 현재 카드(cardArr[i])랑 랜덤 위치 카드(cardArr[r])랑 자리 바꿈.
			Card temp = cardArr[i];     // 1. 현재 카드 임시 저장
			cardArr[i] = cardArr[r];    // 2. 랜덤 카드 -> 현재 위치
			cardArr[r] = temp;          // 3. 임시 저장 카드 -> 랜덤 위치 (교환 끝)
		}
	}
}
