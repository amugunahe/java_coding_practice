package com.inher; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  CaptionTv 클래스: 자막 기능이 있는 TV. (**Tv의 자식 클래스!**)
 
  핵심:
  - **'Tv' 클래스를 상속받는다.** (extends Tv) 이게 **존나 중요하다!** 일반 TV가 가진 모든 기능(전원 켜고 끄기, 채널 돌리기 등)을 **물려받아서 그대로 다 쓸 수 있다는 뜻이다.**
  - 'caption'이라는 **지만의 새로운 필드를 추가한다.** (자막 켜고 끄는 상태). 이건 부모 'Tv'에는 없는, 'CaptionTv' **고유의 기능**이다.
  - 'displayCaption()'이라는 **자막을 화면에 보여주는 지만의 새로운 메소드**를 가진다. (단, 'caption'이 켜져 있을 때만 자막을 보여준다!)
 */

public class CaptionTv extends Tv { // 'Tv'를 상속받아서, 이제 'CaptionTv'도 'Tv'다!

	boolean caption; // 자막 기능이 켜졌는지(true) 꺼졌는지(false) 상태를 나타냄.

	// 이 메소드는 'text'를 자막으로 화면에 띄운다.
	void displayCaption(String text) {
		if (caption) { // 만약 자막 기능이 **켜져 있으면 (true)**
			System.out.println(text); // 전달받은 'text' (자막 내용)를 화면에 **존나게 출력한다!**
		}
		// 자막 기능이 꺼져 있으면 아무것도 안 함.
	}
}
