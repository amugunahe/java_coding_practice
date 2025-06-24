package com.polyexam; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  PolyExam01 클래스: **간단한 물건 구매 과정을 테스트하는 메인 프로그램!**
 
  핵심:
  - 'Buyer' 객체를 만들어서 TV랑 컴퓨터를 산다.
  - 물건 사고 난 후에 'Buyer'의 남은 돈이랑 보너스 포인트를 직접 확인한다.
  - **'b.buy()' 메소드가 'Product'의 자식인 'Tv', 'Computer'를 모두 받을 수 있는 게 다형성이다!**
 */

public class PolyExam01 {

	public static void main(String[] args) { // ★★★ 여.기.서.부.터. 프로그램 시작! ★★★
		
		Buyer b = new Buyer(); // 'Buyer' 객체를 만들어서 물건 살 준비를 한다. (초기 돈 1000만원, 보너스 0점)
		
		// --- 물건 사기 ---
		// 'b' (구매자)한테 'buy()' 메소드를 시켜서 물건을 산다.
		// ★★★ 'Product' 타입으로 선언된 'buy()' 메소드가 'Tv'랑 'Computer' 객체를 모두 받을 수 있다! (다형성!) ★★★
		b.buy(new Tv());        // Tv 한 대 사! (Tv 가격: 100만원)
		b.buy(new Computer());  // 컴퓨터 한 대 사! (Computer 가격: 200만원)
		
		// --- 구매 후 상태 확인 ---
		// 'b' (구매자)의 남은 돈이랑 보너스 포인트를 직접 가져와서 화면에 출력한다.
		System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");       // Tv 사고 컴퓨터 샀으니 (1000 - 100 - 200) = 700만원 남음.
		System.out.println("현재 보너스 점수는 " + b.bonusPoint + "점 입니다."); // Tv (10점) + Computer (20점) = 30점 쌓임.
	}
}