package com.homework;

public class Seat {
	private String name; // 좌석을 예약한 사람의 이름

	public Seat() {
		name = null; // 초기에는 아무도 예약하지 않으므로 null로 설정
	}

	public String getName() {
		return name; // 예약자 이름 반환
	}

	// 좌석 예약 취소
	public void cancel() {
		name = null; // 이름을 null로 설정하여 예약 취소
	}

	// 좌석 예약
	public void reserve(String name) {
		this.name = name; // 예약자 이름을 설정
	}

	// 좌석이 예약되어 있는지 확인 (true: 예약됨, false: 비어있음)
	public boolean isOccupied() {
		// 좌석이 예약되어 있으면 true를 반환함 (name이 null이 아니면 예약된 것)
		return name != null; // 논리 오류 수정: name이 null이 아니어야 true 반환
	}
}