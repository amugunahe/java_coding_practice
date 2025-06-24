package com.objectex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  Tv 클래스: 모든 텔레비전의 **존나 중요한 설계도!**
 
  핵심:
  - TV가 가져야 할 **속성들(색깔, 전원 상태, 채널)**을 정의한다.
  - TV가 할 수 있는 **행동들(전원 켜고 끄기, 채널 돌리기)**을 정의한다.
  - 특히 **`private` 필드는 `Getter`, `Setter`로 안전하게 건드린다.** (★★★★★ 정보 은닉의 존나 중요한 예시! ★★★★★)
 */

public class Tv { // 'Tv'라는 이름의 설계도를 만드는 부분이다. 이걸로 실제 TV를 존나게 찍어낼 거다.
	
	// 1. 속성 (멤버 변수 / 필드)
    // Tv 객체가 '무엇을 가지고 있는지'를 나타내는 데이터들이다.
	public String color;  // Tv 색깔. 'public'이라 아무나 막 건드릴 수 있다.
	private boolean power; // Tv 전원 상태 (켜짐/꺼짐).
                           // ★★★ 존나 중요! 'private'이라 이 클래스 안에서만 직접 건드릴 수 있다. ★★★
                           // 외부에서 함부로 못 바꾸게 막는 '정보 은닉'이라는 존나 중요한 개념이다.
	public int channel;    // Tv 채널 번호. 'public'이라 아무나 막 건드릴 수 있다.
	
    // 2. Getter와 Setter 메소드
    // 'private'으로 막아놓은 변수들('power' 같은 거)을 외부에서 **안전하게 건드리거나(Setter) 값을 읽어올 때(Getter)** 쓰는 표준적인 방법들이다.
    
    // Setter 메소드들: 값을 '설정' (Set)한다.
	public void setColor(String color) {  // 색깔 설정
		this.color = color; // ★`this.color`는 이 Tv 객체 자신의 'color' 멤버 변수다. 그냥 'color'는 메소드로 들어온 '매개변수'고. 이름 같을 때 헷갈리지 말라고 'this' 쓴다.
	}
	public void setPower(boolean power) { // 전원 상태 설정
		this.power = power;
	}
	public void void setChannel(int channel) { // 채널 설정
		this.channel = channel;
	}
	
    // Getter 메소드들: 값을 '반환' (Get)한다.
	public String getColor() {  // 색깔 가져오기
		return color;
	}
	public boolean isPower() { // 전원 상태 가져오기 ('boolean' 타입 Getter는 보통 'is'로 시작한다.)
		return power;
	}
	public int getChannel() {  // 채널 가져오기
		return channel;
	}
	
	// 3. 메소드 (행동 / 함수)
    // Tv 객체가 '무엇을 할 수 있는지'를 정의한 기능들이다.
	public void power() { // 전원 켜고 끄는 메소드.
        // 'power'가 'true'면 'false'로, 'false'면 'true'로 바꿔버린다. (토글 기능!)
        power = !power;
    }
	public void channelUp() { // 채널을 1 올리는 메소드.
        channel++;
    }
	public void channelDown() { // 채널을 1 내리는 메소드.
        channel--;
    }
}
