package com.objectex; // 이 코드는 'com.objectex' 패키지에 있다.

public class Tv { // 'Tv'라는 이름의 클래스. Tv 객체를 만들기 위한 '설계도'다.
	
	// 1. 속성 (멤버 변수 / 필드)
    // Tv 객체가 '무엇을 가지고 있는지'를 나타내는 데이터들이야.
	public String color;  // Tv의 색상. `public`이라 어디서든 접근 가능.
	private boolean power; // Tv의 전원 상태 (켜짐/꺼짐).
                           // ★핵심: `private`이라 이 클래스 안에서만 직접 건드릴 수 있다.
                           // 외부에서 함부로 못 바꾸게 막는 '정보 은닉' 개념이다.
	public int channel;    // Tv의 채널 번호. `public`이라 어디서든 접근 가능.
	
    // 2. Getter와 Setter 메소드
    // `private`으로 막아놓은 변수(`power` 같은 거)를 외부에서 안전하게 건드리거나(Setter)
    // 값을 읽어올 때(Getter) 쓰는 표준적인 방법들이다.
    
    // Setter 메소드들: 값을 '설정' (Set)
	public void setColor(String color) { 
		this.color = color; // ★`this.color`는 이 Tv 객체 자신의 `color` 멤버 변수다.
                            // 그냥 `color`는 메소드로 들어온 '매개변수' `color`고. 이름이 같을 때 구별하려고 `this` 쓴다.
	}
	public void setPower(boolean power) { 
		this.power = power;
	}
	public void setChannel(int channel) { 
		this.channel = channel;
	}
	
    // Getter 메소드들: 값을 '반환' (Get)
	public String getColor() { 
		return color;
	}
	public boolean isPower() { // boolean 타입의 Getter는 보통 `is`로 시작한다.
		return power;
	}
	public int getChannel() { 
		return channel;
	}
	
	// 3. 메소드 (행동 / 함수)
    // Tv 객체가 '무엇을 할 수 있는지'를 정의한 기능들이야.
	public void power() { // 전원을 켜고 끄는 메소드.
        // `power`가 `true`면 `false`로, `false`면 `true`로 바꾼다. (토글 기능)
        power = !power;
    }
	public void channelUp() { // 채널을 1 올리는 메소드.
        channel++;
    }
	public void channelDown() { // 채널을 1 내리는 메소드.
        channel--;
    }
}
