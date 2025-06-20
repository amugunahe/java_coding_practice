package com.inher;

// CaptionTv는 Tv의 자식(하위) 클래스입니다.
// Tv의 모든 멤버(필드, 메서드)를 물려받습니다.

public class CaptionTvTest extends Tv { // 'extends Tv'는 Tv 클래스를 상속받는다는 의미

	boolean caption; // 캡션 기능의 상태 (true: 캡션 켜짐, false: 캡션 꺼짐)
						// 이 필드는 Tv 클래스에는 없고 CaptionTv에만 있는, 추가된 기능입니다.

	// 텍스트를 캡션으로 화면에 보여주는 메서드
	void displayCaption(String text) {
		if (caption) { // 현재 캡션 상태가 '켜져(true)' 있다면
			System.out.println(text); // 전달받은 텍스트(자막 내용)를 화면에 출력한다.
		}
	}
}
