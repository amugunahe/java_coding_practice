package com.switchex;

import java.util.Scanner;

public class SwitchEx05_02_con {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위한 Scanner 객체 생성

		System.out.print("가위(1), 바위(2), 보(3) 중 입력: "); // 사용자에게 입력 요청
		int user = sc.nextInt(); // 사용자 선택 입력받아 저장

		int com = (int)(Math.random() * 3) + 1; // 컴퓨터는 1~3 중 랜덤으로 선택

		System.out.println("사용자: " + user); // 사용자 선택 값 출력 (디버깅용)
		System.out.println("컴퓨터: " + com); // 컴퓨터 선택 값 출력 (디버깅용)

		// 가위바위보 승패 판정
		// 결과값이 0이면 비김
		if (user - com == 0) {
			System.out.println("비겼습니다.");
		}
		// 사용자 승리 조건: user=1,com=3 (1-3=-2) 또는 user=2,com=1 (2-1=1) 또는 user=3,com=2 (3-2=1)
		// 즉, 차이가 -2 또는 1일 경우
		else if (user - com == -2 || user - com == 1) {
			System.out.println("사용자가 이겼습니다!");
		}
		// 나머지 경우는 모두 컴퓨터 승리
		// user=1,com=2 (1-2=-1) 또는 user=2,com=3 (2-3=-1) 또는 user=3,com=1 (3-1=2)
		// 즉, 차이가 -1 또는 2일 경우
		else { // (user - com == -1 || user - com == 2)
			System.out.println("컴퓨터가 이겼습니다!");
		}

		sc.close(); // Scanner 사용이 끝나면 닫아주기
	}
}
