package com.objectex; // 이 코드가 속한 패키지(폴더) 이름이에요.

public class Tv { // 'Tv'라는 이름의 공개(public) 클래스를 정의합니다.
	
	// 1. 속성 = 멤버변수 = 필드 (Attributes = Member Variables = Fields)
    // 이 부분은 TV가 '무엇을 가지고 있는가?'를 나타냅니다.
    // 객체가 가질 데이터(상태)를 저장하는 변수들이에요.
	public String color;  // TV의 '색상'을 저장할 문자열(String) 변수. 'public'이라 어디서든 접근 가능해요.
	private boolean power; // TV의 '전원' 상태(켜짐/꺼짐)를 저장할 논리(boolean) 변수.
                         // 'private'이라 이 Tv 클래스 내부에서만 직접 접근할 수 있어요.
                         // 외부에서는 `power()` 메소드나 `isPower()` 메소드를 통해 접근해야 합니다. (정보 은닉)
	public int channel;   // TV의 '채널' 번호를 저장할 정수(int) 변수. 'public'이라 어디서든 접근 가능해요.
	
    // 2. 'Getter'와 'Setter' 메소드
    // private으로 선언된 멤버 변수(`power` 같은 것)나, 값을 설정/조회하는 표준적인 방법을 제공하기 위해 만들어요.
    // 'Setter'는 값을 설정(set)하고, 'Getter'는 값을 얻어오는(get) 역할을 해요.
    // `isPower()`는 boolean 타입의 getter에 주로 사용되는 이름 규칙이에요.

    // Setter 메소드들: 멤버 변수에 값을 '설정'하는 역할
	public void setColor(String color) { // Tv 객체의 color 속성을 설정하는 메소드
		this.color = color; // `this.color`는 현재 객체의 멤버 변수 `color`를, `color`는 매개변수 `color`를 의미해요.
	}
	public void setPower(boolean power) { // Tv 객체의 power 속성을 설정하는 메소드
		this.power = power;
	}
	public void setChannel(int channel) { // Tv 객체의 channel 속성을 설정하는 메소드
		this.channel = channel;
	}
	
    // Getter 메소드들: 멤버 변수의 값을 '반환'하는 역할
	public String getColor() { // Tv 객체의 color 속성 값을 반환하는 메소드
		return color;
	}
	public boolean isPower() { // Tv 객체의 power 속성 값을 반환하는 메소드 ('is'로 시작하는 건 boolean 타입의 흔한 관례)
		return power;
	}
	public int getChannel() { // Tv 객체의 channel 속성 값을 반환하는 메소드
		return channel;
	}
	
	// 3. 메소드 = 메서드 = 함수 (Methods = Functions)
    // 이 부분은 TV가 '무엇을 할 수 있는가?'를 나타냅니다.
    // 객체가 수행할 수 있는 동작(행위)을 정의한 코드 블록들이에요.
	public void power() { // TV의 전원 상태를 토글(반전)시키는 메소드
        // `power`가 true(켜짐)면 false(꺼짐)로, false(꺼짐)면 true(켜짐)로 바꿉니다.
        // 예를 들어, 전원이 켜져 있을 때 이 메소드를 호출하면 꺼지고, 꺼져 있을 때 호출하면 켜집니다.
        power = !power;
    }
	public void channelUp() { // TV 채널을 1 증가시키는 메소드
        channel++; // `channel` 값을 1 늘려요. (예: 7번 채널에서 `channelUp()` 호출하면 8번 채널)
    }
	public void channelDown() { // TV 채널을 1 감소시키는 메소드
        channel--; // `channel` 값을 1 줄여요. (예: 7번 채널에서 `channelDown()` 호출하면 6번 채널)
    }
}
