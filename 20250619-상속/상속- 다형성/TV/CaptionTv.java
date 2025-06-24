package com.polymorphism;

/*
  CaptionTv 클래스: 자막 기능이 있는 TV.
 
  핵심:
  - **'Tv' 클래스를 상속받는다.** (extends Tv)
  이게 존나 중요하다! 일반 TV가 가진 기능(켜고 끄고 채널 돌리고 등)을 다 물려받는다는 뜻이다.
  - 'text'라는 지만의 새로운 속성(자막 내용)을 가진다.
  - 'caption()'이라는 지만의 새로운 기능(자막 켜는)을 가진다.
  (나중에 'on/off' 같은 구체적인 기능 추가할 수 있겠지, 씨발?)
 */

public class CaptionTv extends Tv { // Tv를 상속받아서 TV다!

	String text; // 자막 내용을 저장할 속성.
	void caption() { // 자막 기능을 켜거나 끌 때 쓰는 메소드. (여기에 구체적인 동작을 채워 넣으면 됨)
		// System.out.println("자막을 켜고 끈다."); // 예시로 이렇게 넣을 수도 있겠지.
	}
	
}
