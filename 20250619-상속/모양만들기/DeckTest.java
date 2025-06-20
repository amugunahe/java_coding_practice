package com.inher;

public class DeckTest {

	// 자바 프로그램이 시작될 때 가장 먼저 실행되는 메서드
	public static void main(String[] args) {
	
		// 새로운 카드 덱(Deck)을 만듭니다. (이 시점에 52장의 카드가 모두 생성되어 덱에 들어갑니다.)
		Deck d = new Deck();

		// 덱에서 첫 번째 카드(인덱스 0)를 뽑아서 c 변수에 저장합니다.
		Card c = d.pick(0);
		// 뽑은 카드의 정보를 출력합니다. (Card 클래스의 toString() 메서드가 자동으로 호출됩니다.)
		System.out.println(c); // 예: "kind:SPADE, number:A" 또는 "kind:CLOVER, number:K" 등

		d.shuffle(); // 덱에 있는 52장의 카드를 무작위로 섞습니다.
		
		// 카드를 섞은 후, 다시 첫 번째 카드(인덱스 0)를 뽑아서 c 변수에 저장합니다.
		// 섞였기 때문에 이전과는 다른 카드가 나올 확률이 높습니다.
		c = d.pick(0);
		// 새로 뽑은 카드의 정보를 출력합니다.
		System.out.println(c);
	}

}
