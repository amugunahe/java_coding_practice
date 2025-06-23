package com.homework;

import java.util.Scanner;

public class Concert {
	private String hallName; // 콘서트 홀 이름
	private Scanner sc; // 사용자 입력을 위한 Scanner 객체
	private Group[] group = new Group[3]; // S, A, B 세 가지 좌석 등급을 위한 Group 배열

	public Concert(String hallName) {
		this.hallName = hallName;
		sc = new Scanner(System.in);
		// 각 좌석 등급별 Group 객체 초기화 (S, A, B 등급 각 10석)
		group[0] = new Group('S', 10);
		group[1] = new Group('A', 10);
		group[2] = new Group('B', 10);
	}

	// 콘서트 좌석 예약
	public void reserve() {
		System.out.print("좌석 구분: S(1), A(2), B(3): ");
		int type = sc.nextInt(); // 좌석 구분 입력 받기
		if (type < 1 || type > 3) { // 잘못된 좌석 타입 입력 시 오류 메시지 출력
			System.out.println("잘못된 좌석 타입입니다. 다시 입력해주세요.");
			return;
		}
		group[type - 1].reserve(); // 해당 좌석 등급의 예약 메서드 호출
	}

	// 예약 현황 조회
	public void search() {
		for (int i = 0; i < group.length; i++) {
			group[i].show(); // 각 좌석 등급의 예약 현황 표시 메서드 호출
		}
		System.out.println("<<<<<< 조회를 완료하였습니다. >>>>>>>");
	}

	// 예약 취소
	public void cancel() {
		System.out.print("좌석 구분: S(1), A(2), B(3): ");
		int type = sc.nextInt(); // 좌석 구분 입력 받기
		if (type < 1 || type > 3) { // 잘못된 좌석 타입 입력 시 오류 메시지 출력
			System.out.println("잘못된 좌석 타입입니다. 다시 입력해주세요.");
			return;
		}
		group[type - 1].cancel(); // 해당 좌석 등급의 취소 메서드 호출
	}

	// 콘서트 예약 시스템 실행 (메인 루프)
	public void run() {
		System.out.println(hallName + " 예약 시스템입니다.");

		int menu = 0; // 메뉴 선택 변수

		while (menu != 4) { // 메뉴가 4(종료)가 아닐 동안 반복
			// 사용자에게 메뉴 옵션 출력
			System.out.print("예약: 1, 조회: 2, 취소: 3, 종료: 4 >> ");
			menu = sc.nextInt(); // 메뉴 선택 입력 받기

			switch (menu) {
				case 1:
					reserve(); // 예약 기능 호출
					break;
				case 2:
					search(); // 조회 기능 호출
					break;
				case 3:
					cancel(); // 취소 기능 호출
					break;
				case 4:
					System.out.println("프로그램을 종료합니다."); // 프로그램 종료 메시지
					break;
				default:
					System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요."); // 잘못된 입력 시 메시지
			}
		}
	}
}
