package com.objectex;

public class Tv {
	
	// 속성 = 멤버변수 = 필드 
	public String color;    // 색상
	private boolean power;   // 전원(on/off)
	public int channel;     // 채널
	
	public void setColor(String color) {
		this.color = color;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	public String getColor() {
		return color;
	}
	public boolean isPower() {
		return power;
	}
	public int getChannel() {
		return channel;
	}
	
	// 메소드 = 메서드 = 함수: 행위와 동작을 의미함
	public void power() { power = !power; };  // 전원
	public void channelUp() {channel++;}
	public void channelDown() {channel--;}
}
