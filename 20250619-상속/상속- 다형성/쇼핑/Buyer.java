package com.polyexam; // 이 코드가 속한 폴더(패키지) 이름이다.

import java.util.Vector; // ★★★ 존나 중요! 'Vector' 클래스를 쓰려면 이걸 임포트해야 한다! ★★★

/*
  Buyer 클래스: **물건을 사고파는 고객!** (이 새끼가 돈 쓰고 보너스 포인트 쌓는 놈이다!)
 
  핵심:
  - 돈(`money`)이랑 보너스 포인트(`bonusPoint`)를 가진다.
  - **`Vector<Product> item`이라는 존나 유연한 목록을 이용해서 구매한 제품들을 관리한다!** (배열보다 훨씬 편하다!)
  - **`buy()` 메소드:** 어떤 `Product`든 받아서 살 수 있게 **다형성**을 활용한다.
  - **`refund()` 메소드:** 구매했던 물건을 환불 처리한다.
  - **`summary()` 메소드:** 지금까지 뭘 샀는지, 총 얼마 썼는지 **요약해서 보여준다.**
 */

public class Buyer { // 고객: 물건을 사는 사람이다!

	int money = 1000; // 이 고객이 가진 돈 (초기 1000만원!)
	int bonusPoint = 0; // 이 고객이 쌓은 보너스 포인트 (초기 0점!)
	
	// ★★★ 존나 중요! 구매한 제품들을 저장할 'Vector' 목록! ★★★
	// <Product>는 이 목록에 'Product' 타입의 객체들만 들어갈 수 있다고 명시하는 거다. (다형성 덕분에 모든 자식 제품 다 들어감!)
	Vector<Product> item = new Vector<>(); // 새로운 빈 Vector 객체를 만든다.
	
	// 'Product' 타입의 어떤 객체든(Tv, Computer, Audio 등) 받아서 물건을 구매하는 메소드.
	// ★★★ '매개변수의 다형성'이 여기서 존나 발휘된다! ★★★
	public void buy(Product p) {
		
		if(money < p.price) { // 가진 돈이 물건 값보다 적으면
			System.out.println("잔액이 너무나 부족하여 물건을 구매할 수 없습니다.");
			return; // 구매 못 한다고 하고 끝!
		}
		
		money -= p.price; // 물건 값만큼 돈을 뺀다!
		bonusPoint += p.bonusPoint; // 물건 보너스 포인트만큼 보너스를 더한다!
		item.add(p); // 구매한 제품을 'item' Vector에 추가한다!
		System.out.println(p + "을/를 구입하셨습니다."); // 어떤 제품 샀는지 출력. (p의 toString() 메소드가 호출된다!)
	}

	// 구매한 제품이 맘에 안 들거나 불량일 때 환불해주는 메소드.
	public void refund(Product p) {
		if(item.remove(p)) { // 'item' Vector에서 해당 제품을 찾아서 지운다. 성공하면 'true' 반환.
			money += p.price; // 돈 다시 돌려받고!
			bonusPoint -= p.bonusPoint; // 보너스 포인트 다시 깎는다!
			System.out.println(p + "을/를 반품 하셨습니다."); // 어떤 제품 반품했는지 출력.
		} else { // 제품이 없어서 환불 실패한 경우
			System.out.println("구매한 제품 중 해당 제품이 존재하지 않습니다.");
		}
	}
	
	// ★★★ 존나 중요! 지금까지 구매한 물품 정보들을 요약해서 보여주는 메소드! ★★★
	public void summary() {
		int sum = 0; // 구매한 물품들 총 가격 합계.
		String itemList = ""; // 구매한 물품들의 이름 목록을 저장할 문자열.

		if(item.isEmpty()) { // 'item' Vector가 비어있으면 (아무것도 산 적 없으면)
			System.out.println("구매한 제품이 존재하지 않습니다.");
			return; // 그냥 끝낸다.
		}
		
		// 'item' Vector에 있는 모든 제품을 하나씩 돌면서 처리한다.
		for(int i = 0; i < item.size(); i++) {
			Product p = item.get(i); // Vector에서 i번째 제품을 가져온다. (이게 다형성이다!)
			sum += p.price; // 가져온 제품 가격을 총 합계에 더한다.
			
			if(i == 0) { // 만약 첫 번째 제품이면
				itemList += p.toString(); // 그냥 이름만 붙인다. (예: "Tv")
			} else { // 첫 번째 제품이 아니면 (두 번째부터는)
				itemList += ", " + p.toString(); // 앞에 콤마(,)랑 공백을 붙이고 이름을 붙인다. (예: ", Computer")
			}
		}
		
		// 최종 결과를 화면에 존나게 출력한다!
		System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다.");
		System.out.println("구입하신 제품은 " + itemList + " 입니다.");
	}
}