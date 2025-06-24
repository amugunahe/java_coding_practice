package com.polyexam; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  PolyExam02 클래스: **다형성을 이용해서 물건 사고파는 과정을 테스트하는 메인 프로그램!**
 
  핵심:
  - 'Buyer' 객체를 만들어서 물건을 '사고(buy)' '환불하고(refund)'
  - 'summary()' 메소드로 구매 내역을 확인하는 과정을 보여준다.
  - **다형성 덕분에 'buy()' 메소드 하나로 온갖 종류의 'Product'를 다 살 수 있다!**
 */

public class PolyExam02 {

	public static void main(String[] args) { // ★★★ 여.기.서.부.터. 프로그램 시작! ★★★
		
		Buyer b = new Buyer(); // 'Buyer' 객체를 만들어서 물건 살 준비를 한다.

		// --- 물건 사기 ---
		// 'b' (구매자)한테 'buy()' 메소드를 시켜서 물건을 산다.
		// ★★★ 'Tv', 'Computer', 'Audio' 모두 'Product'의 자식이라 'Product' 타입으로 다룰 수 있다! (다형성!) ★★★
		b.buy(new Tv());        // Tv 한 대 사!
		b.buy(new Computer());  // 컴퓨터 한 대 사!
		b.buy(new Audio());     // 오디오 한 대 사!

		// --- 구매 내역 요약 ---
		// 'b' (구매자)한테 'summary()' 메소드를 시켜서 지금까지 뭘 샀는지, 돈은 얼마 썼는지 확인한다.
		b.summary(); // 현재까지 구매한 물품의 총액과 목록을 출력.
		
		// --- 물건 환불 테스트 ---
		// 'b' (구매자)한테 'refund()' 메소드를 시켜서 특정 물건을 반품한다.
		b.refund(new Audio()); // 오디오 반품해라!
		
		// --- 환불 후 구매 내역 다시 요약 ---
		// 물건 반품했으니, 다시 'summary()' 메소드를 시켜서 바뀐 구매 내역을 확인한다.
		b.summary(); // 반품 후 남은 물품의 총액과 목록을 출력.
	}
}