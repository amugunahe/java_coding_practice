package com.exam;

/* 문] 정수로 된 돈의 금액을 입력받아 오만원권, 만원권, 오천원권, 천원권,
500원 동전 100원 동전, 50원 동전, 10원 동전, 1원 동전이
각각 몇개인지를 반환하는 프로그램을 구현하시오.

단, if문만 사용하여 구현.

65376
오만원권 1매
만원권 1매
천원권 5매
100원 3개
50원 1개
10원 2개
1원  6개
*/

import java.util.*;

public class Exam03 {

	// 돈의 종류를 상수로 정의하여 코드 가독성 및 유지보수성 향상
	final static int omanwon = 50000;
	final static int manwon = 10000;
	final static int ochunwon = 5000;
	final static int chunwon = 1000;
	final static int obekwon = 500;
	final static int bekwon = 100;
	final static int osipwon = 50;
	final static int sipwon = 10;
	final static int ilwon = 1; // 1원 단위도 상수화

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위한 Scanner 객체 생성

		int money; // 입력받을 총 금액
		int result; // 각 화폐 단위의 개수를 저장할 변수

		System.out.print("금액을 입력하세요: "); // 사용자에게 금액 입력 요청
		money = sc.nextInt(); // 사용자가 입력한 정수 금액을 'money' 변수에 저장

		// 각 화폐 단위별 개수 계산 및 출력
		// '몫'은 해당 단위의 개수, '나머지'는 다음 계산을 위해 남은 금액
		result = money / omanwon; // 오만원권 개수 계산
		money = money % omanwon;  // 오만원권으로 계산하고 남은 금액 업데이트
		if (result > 0) { // 개수가 0보다 크면 출력
			System.out.println("오만원권: " + result + "매 입니다.");
		}

		result = money / manwon; // 만원권 개수 계산
		money = money % manwon;  // 만원권으로 계산하고 남은 금액 업데이트
		if (result > 0) { // 개수가 0보다 크면 출력
			System.out.println("만원권: " + result + "매 입니다.");
		}

		result = money / ochunwon; // 오천원권 개수 계산
		money = money % ochunwon;  // 오천원권으로 계산하고 남은 금액 업데이트
		if (result > 0) { // 개수가 0보다 크면 출력
			System.out.println("오천원권: " + result + "매 입니다.");
		}

		result = money / chunwon; // 천원권 개수 계산
		money = money % chunwon;  // 천원권으로 계산하고 남은 금액 업데이트
		if (result > 0) { // 개수가 0보다 크면 출력
			System.out.println("천원권: " + result + "매 입니다.");
		}

		result = money / obekwon; // 500원 개수 계산
		money = money % obekwon;  // 500원으로 계산하고 남은 금액 업데이트
		if (result > 0) { // 개수가 0보다 크면 출력
			System.out.println("500원: " + result + "개 입니다.");
		}

		result = money / bekwon; // 100원 개수 계산
		money = money % bekwon;  // 100원으로 계산하고 남은 금액 업데이트
		if (result > 0) { // 개수가 0보다 크면 출력
			System.out.println("100원: " + result + "개 입니다.");
		}

		result = money / osipwon; // 50원 개수 계산
		money = money % osipwon;  // 50원으로 계산하고 남은 금액 업데이트
		if (result > 0) { // 개수가 0보다 크면 출력
			System.out.println("50원: " + result + "개 입니다.");
		}

		result = money / sipwon; // 10원 개수 계산
		money = money % sipwon;  // 10원으로 계산하고 남은 금액 업데이트
		if (result > 0) { // 개수가 0보다 크면 출력
			System.out.println("10원: " + result + "개 입니다.");
		}

		result = money / ilwon; // 1원 개수 계산 (남은 money 자체가 1원 개수)
		money = money % ilwon;   // 1원으로 계산하고 남은 금액 업데이트 (항상 0이 됨)
		if (result > 0) { // 개수가 0보다 크면 출력
			System.out.println("1원: " + result + "개 입니다.");
		}

		sc.close(); // 사용이 끝난 Scanner 객체 닫기 (리소스 해제)
	}
}
