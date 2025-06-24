package com.test; // 이 코드 덩어리가 속한 폴더(패키지) 이름이다.

/*
  [문제 1] 3, 6, 9 게임 박수세기 프로그램
  - 목표: 1~99 숫자 입력받아서 3, 6, 9 개수에 따라 박수 출력.
  - 규칙:
  - 3, 6, 9 하나: "박수짝"
  - 3, 6, 9 두 개: "박수짝짝"
 
  [예시]
  1~99 사이의 정수 입력 : 36
  박수짝짝
 */

import java.util.Scanner; // 사용자 입력받는 도구 'Scanner' 가져오기.

public class HomeWork01 {

	public static void main(String[] args) { // ★★★ 여.기.서.부.터. 프로그램 시작! ★★★

		Scanner sc = new Scanner(System.in); // 키보드 입력받을 준비!

		int num = 0;        // 사용자 입력 숫자 저장용.
		int clapCount = 0;  // 3, 6, 9 개수 셀 카운터.

		System.out.print("1~99 사이의 정수 입력: "); // 사용자한테 입력하라고 화면에 띄우기.
		num = sc.nextInt(); // 사용자가 입력한 숫자 'num'에 저장.

		// --- ★★★ 존나 중요! 입력 값 유효성 검사 (범위 벗어났는지 확인) ★★★ ---
		if (num < 1 || num > 99) { // 숫자가 1보다 작거나 99보다 크면
			System.out.println("숫자의 범위를 벗어났습니다. 1~99 사이의 정수를 다시 입력하세요."); // 에러 메시지 뱉어라!
			sc.close(); // 입력 도구 닫고
			return;     // 프로그램 강제 종료!
		}

		// --- ★★★ 존나 중요! 숫자의 각 자릿수 분리 및 3, 6, 9 확인 ★★★ ---
		int tensDigit = num / 10;   // 십의 자리 숫자 (예: 36 -> 3)
		int unitsDigit = num % 10; // 일의 자리 숫자 (예: 36 -> 6)

		// 십의 자리에 3, 6, 9가 있는지 확인. (한 자리 숫자일 땐 십의 자리가 0이니 패스)
		if (tensDigit != 0 && (tensDigit == 3 || tensDigit == 6 || tensDigit == 9)) {
			clapCount++; // 있으면 박수 카운트 1개 올리기.
		}

		// 일의 자리에 3, 6, 9가 있는지 확인. (예: 30은 일의 자리가 0이니까 짝 없음)
		if (unitsDigit != 0 && (unitsDigit == 3 || unitsDigit == 6 || unitsDigit == 9)) {
			clapCount++; // 있으면 박수 카운트 1개 올리기.
		}

		// --- 최종 결과 출력 ---
		if (clapCount == 2) {     // 박수 카운트가 2개면 (36처럼)
			System.out.println("박수 짝짝");
		} else if (clapCount == 1) { // 박수 카운트가 1개면 (3이나 60처럼)
			System.out.println("박수 짝");
		} else {                  // 박수 카운트가 0개면 (1이나 22처럼)
			System.out.println("박수 없음");
		}

		sc.close(); // 다 썼으면 입력 도구 깔끔하게 닫아라.
	}
}
