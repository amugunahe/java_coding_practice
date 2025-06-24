package com.polyexam; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  Computer 클래스: 컴퓨터 제품! (**Product의 자식 클래스!**)
 
  핵심:
  - **'Product' 클래스를 상속받는다.** 이게 존나 중요하다! 'Product'가 가진 모든 속성(가격, 보너스 포인트)을 **물려받아서 다 쓸 수 있다.** 그러니까 컴퓨터도 가격이 있고, 사면 보너스 포인트를 받을 수 있는 거지!
  - 지만의 생성자를 통해서 **컴퓨터의 가격을 200만원으로 고정한다.** (보너스 포인트는 가격에 따라 자동으로 계산됨)
  - 'toString()' 메소드를 **지만의 방식으로 재정의(Override)한다.** 객체를 그냥 출력하면 "Computer"라고 나오게 만드는 거다.
 */

public class Computer extends Product{

	// 생성자: 컴퓨터 객체를 만들 때 호출된다.
	public Computer() {
		super(200); // ★★★ 존나 중요! 부모 클래스(Product)의 생성자를 호출해서 컴퓨터 가격을 200만원으로 설정한다! ★★★
	}
	
	// ★★★ 존나 중요! 'toString()' 메소드 재정의(Override)! ★★★
	// 이 객체를 문자열로 표현할 때 "Computer"라고 나오게 만든다. (예: System.out.println(new Computer()); 하면 "Computer" 출력!)
	@Override
	public String toString() {
		return "Computer";
	}
	
}