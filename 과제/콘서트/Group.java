package com.homework;

import java.util.Scanner; // Scanner 클래스 사용을 위한 import 추가

public class Group {
	private char type; // 좌석 등급 (예: 'S', 'A', 'B')
	private Seat[] seats; // 해당 등급의 Seat 객체 배열
	private Scanner sc; // 사용자 입력을 위한 Scanner 객체 (Concert 클래스와는 별개로 Group 내에서 사용)

	public Group(char type, int num) {
		this.type = type;
		seats = new Seat[num]; // Seat 배열 초기화
		for (int i = 0; i < seats.length; i++) {
			seats[i] = new Seat(); // 각 좌석 객체 초기화
		}
		sc = new Scanner(System.in); // Scanner 객체 초기화
	}

	// 현재 등급의 좌석 예약
	public void reserve() {
		show(); // 현재 좌석 현황을 먼저 보여줌
		System.out.print("이름: ");
		String name = sc.next(); // 예약할 사람 이름 입력 받기
		System.out.print("번호: ");
		int no = sc.nextInt(); // 예약할 좌석 번호 입력 받기

		// 입력된 좌석 번호가 유효 범위 내에 있는지 확인 (1부터 seats.length까지)
		if (no < 1 || no > seats.length) {
			System.out.println("잘못된 좌석번호입니다.");
			return;
		}

		// 해당 좌석이 이미 예약되어 있는지 확인
		if (seats[no - 1].isOccupied()) { // Seat 클래스의 isOccupied() 메서드 사용
			System.out.println("이미 예약된 좌석입니다.");
			return;
		}

		seats[no - 1].reserve(name); // 좌석 예약 처리
		System.out.println(name + "님이 " + type + "석 " + no + "번 좌석을 예약했습니다."); // 예약 성공 메시지
	}

	// 현재 등급의 좌석 예약 취소
	public void cancel() {
		show(); // 현재 좌석 현황을 먼저 보여줌
		System.out.print("취소자 이름: ");
		String name = sc.next(); // 취소할 사람 이름 입력 받기

		boolean found = false; // 예약자를 찾았는지 여부를 나타내는 플래그
		for (int i = 0; i < seats.length; i++) {
			// 해당 좌석이 예약되어 있고, 이름이 일치하는 경우
			if (seats[i].isOccupied() && seats[i].getName().equals(name)) {
				seats[i].cancel(); // 좌석 취소
				System.out.println(name + "님의 " + type + "석 " + (i + 1) + "번 좌석 예약을 취소했습니다.");
				found = true;
				break; // 찾아서 취소했으므로 루프 종료
			}
		}
		if (!found) {
			System.out.println(name + "님으로 예약된 좌석이 없습니다.");
		}
	}

	// 현재 등급의 좌석 현황 표시
	public void show() {
		System.out.print(type + ">> "); // 좌석 등급 출력 (예: S>>)
		for (int i = 0; i < seats.length; i++) {
			// 좌석이 예약되어 있으면 이름 출력, 아니면 --- 출력
			if (seats[i].isOccupied()) {
				System.out.print(seats[i].getName() + " ");
			} else {
				System.out.print("--- ");
			}
		}
		System.out.println(); // 다음 줄로 이동
	}
}