package com.inher; // 이 코드가 속한 패키지 이름입니다.

// CaptionTvTest는 Tv의 자식(하위) 클래스입니다.
// Tv의 모든 멤버(필드, 메서드)를 물려받습니다.
public class CaptionTvTest extends Tv { // 'extends Tv'는 Tv 클래스를 상속받는다는 의미입니다.
                                        // 즉, CaptionTvTest는 Tv가 가진 모든 변수(color, channel, power 등)와
                                        // 메서드(power(), channelUp(), channelDown() 등)를 사용할 수 있습니다.

	boolean caption; // 캡션 기능의 상태를 나타내는 필드입니다.
	                 // true면 캡션이 켜진 상태, false면 꺼진 상태를 의미합니다.
	                 // 이 필드는 부모 클래스인 'Tv'에는 없고, 'CaptionTvTest'에만 **추가된** 새로운 기능입니다.

	// 텍스트를 캡션으로 화면에 보여주는 메서드
	void displayCaption(String text) { // 'text'라는 문자열을 매개변수로 받아서 캡션으로 표시할 내용을 전달받습니다.
		if (caption) { // 현재 'caption' 필드의 값이 true인지 확인합니다.
                       // 즉, 캡션 기능이 **켜져(true) 있다면** 다음 코드를 실행합니다.
			System.out.println(text); // 전달받은 'text'(자막 내용)를 화면에 출력합니다.
                                      // 캡션이 꺼져(false) 있다면 아무것도 출력되지 않습니다.
		}
	}
}
