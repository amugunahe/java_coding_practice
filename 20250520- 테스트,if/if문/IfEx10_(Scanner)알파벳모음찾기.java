package com.ioex; // 야, 이 코드가 여기 산다. 주소 박아놨으니까 딴 데서 헤매지 마라.

/* 문제) 알파벳 한 글자 받아서 모음이면 '모음 O', 자음이면 아무것도, 알파벳 아니면 '입력 오류' 출력하는 프로그램이다.
대소문자 다 된다. */

import java.util.*; // java.util 패키지 다 쓸 거다. Scanner 쓸 때 필요함.

public class IfEx10 { // 야, IfEx10 이름으로 프로그램 시작한다. 이 파일 이름이랑 똑같으니까 틀리면 뒤진다.

	public static void main(String[] args) { // 여기가 진짜 시작점이다. 무조건 여기부터 실행된다고 보면 됨.

		Scanner sc = new Scanner(System.in); // Scanner 쓸 준비하는 거다. 키보드 입력 받으려고 sc라는 이름으로 하나 만들었다.

		char ch; // ch라는 char(글자) 변수 만들었다.

		System.out.print("알파벳 입력: "); // "알파벳 입력: " 화면에 띄우고
		ch = sc.next().charAt(0); // 사용자가 입력한 한 단어 받아서 첫 글자만 뽑아 ch에 박아 넣는다.

		// 입력받은 게 알파벳인지 먼저 확인한다.
		if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) { // ch가 소문자 알파벳이거나 대문자 알파벳이면

			// 모음인지 확인한다.
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') { // ch가 소소문자 모음이면
				System.out.print("모음 O"); // "모음 O" 출력한다.
			} else if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') { // ch가 대문자 모음이면
				System.out.println("모음 O"); // "모음 O" 출력한다.
			} else { // 모음이 아니면 (알파벳은 맞는데 자음이면)
				// 아무것도 출력하지 않고 메소드 끝낸다.
				return;
			}
		} else { // 알파벳이 아니면
			System.out.print("입력 오류"); // "입력 오류"라고 욕 박는다.
		}
	}
}
