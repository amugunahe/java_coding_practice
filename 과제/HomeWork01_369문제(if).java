package com.test;

/*
 * 문1]
      1 ~ 99까지의 정수를 입력받고 정수에 3,6, 9 중 하나가 있는 경우는 "박수짝",
     두개가 있는 경우는 "박수짝짝"을 출력하는 프로그램을 구현하시오.

     결과
     1 ~ 99 사이의 정수 입력 : 36
     박수짝짝
 */

import java.util.Scanner;

public class HomeWork01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 사용자 입력을 위한 Scanner 객체를 생성합니다.

		int num = 0; // 입력받을 숫자를 저장할 변수입니다.
		int clapCount = 0; // '짝'의 개수를 세는 변수를 0으로 초기화합니다.

		System.out.print("1~99 사이의 정수 입력: "); // 사용자에게 숫자 입력을 요청합니다.
		num = sc.nextInt(); // 사용자가 입력한 정수를 num 변수에 저장합니다.

		// 입력된 숫자가 1부터 99 사이의 유효한 범위에 있는지 확인합니다.
		if (num < 1 || num > 99) { // 숫자가 1보다 작거나 99보다 큰 경우 (즉, 유효 범위를 벗어난 경우)
			System.out.println("숫자의 범위를 벗어났습니다. 1~99 사이의 정수를 다시 입력하세요."); // 오류 메시지를 출력합니다.
			sc.close(); // Scanner 객체를 닫아 자원 누수를 방지합니다.
			return; // main 메소드를 종료하여 프로그램을 끝냅니다.
		}

		// 십의 자리 숫자와 일의 자리 숫자를 분리합니다.
		int tensDigit = num / 10; // num을 10으로 나눈 몫은 십의 자리 숫자입니다. 예: 36 -> 3
		int unitsDigit = num % 10; // num을 10으로 나눈 나머지는 일의 자리 숫자입니다. 예: 36 -> 6

		// 십의 자리에 3, 6, 9가 있는지 확인합니다.
		// 십의 자리가 0이 아닌 경우에만 3, 6, 9인지 검사합니다 (예: 7은 '짝'이 아님).
		if (tensDigit != 0 && (tensDigit == 3 || tensDigit == 6 || tensDigit == 9)) {
			clapCount++; // 십의 자리가 3, 6, 9 중 하나라면 '짝' 개수를 1 증가시킵니다.
		}

		// 일의 자리에 3, 6, 9가 있는지 확인합니다.
		// 일의 자리가 0이 아닌 경우에만 3, 6, 9인지 검사합니다 (예: 30은 십의 자리에만 3이 있음).
		if (unitsDigit != 0 && (unitsDigit == 3 || unitsDigit == 6 || unitsDigit == 9)) {
			clapCount++; // 일의 자리가 3, 6, 9 중 하나라면 '짝' 개수를 1 증가시킵니다.
		}

		// '짝' 개수에 따라 최종 결과를 출력합니다.
		if (clapCount == 2) { // '짝'이 두 개라면
			System.out.println("박수 짝짝"); // "박수 짝짝"을 출력합니다.
		} else if (clapCount == 1) { // '짝'이 한 개라면
			System.out.println("박수 짝"); // "박수 짝"을 출력합니다.
		} else { // '짝'이 전혀 없다면
			System.out.println("박수 없음"); // "박수 없음"을 출력합니다.
		}

		sc.close(); // Scanner 객체를 닫아 자원 누수를 방지합니다.
	}
}
