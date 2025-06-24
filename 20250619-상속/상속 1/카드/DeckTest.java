package com.inher;

public class DeckTest {

	// ★★★ 프로그램 시작점 (메인 메서드) ★★★
	public static void main(String[] args) {
	
		// 1. 새로운 카드 덱(Deck)을 만듦.
		// ★중요★ 이 시점에 52장의 카드가 모두 생성돼서 덱에 들어감.
		Deck d = new Deck();

		// 2. 덱에서 첫 번째 카드(인덱스 0)를 뽑음.
		Card c = d.pick(0);
		// 뽑은 카드 정보 출력. (Card 클래스의 toString()이 자동으로 호출됨)
		System.out.println(c); 

		d.shuffle(); // 3. 덱에 있는 52장의 카드를 ★무작위로 섞음★. (셔플!)
		
		// 4. 카드 섞은 후, 다시 첫 번째 카드(인덱스 0)를 뽑음.
		// 섞였으니까 이전 카드랑 다를 확률 높음.
		c = d.pick(0);
		// 새로 뽑은 카드 정보 출력.
		System.out.println(c);
	}

}
