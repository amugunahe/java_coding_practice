package com.switchex;

import java.util.Scanner;

public class SwitchEx04_02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위한 Scanner 객체 생성

		System.out.print("주민등록번호 전부 입력(123456-1234567): "); // 주민등록번호 입력 요청
		String jumin = sc.nextLine(); // 주민등록번호 문자열로 입력받기 (공백/특수문자 포함 가능)

		// 주민등록번호 뒷자리 첫 번째 숫자(성별/출생년대 코드) 추출
		// 문자열 인덱스는 0부터 시작하므로 8번째 문자는 인덱스 7
		char gender = jumin.charAt(7);

		System.out.println("추출된 성별 코드: " + gender); // 추출된 성별 코드 출력 (확인용)

		sc.close(); // 사용이 끝난 Scanner 객체 닫기 (리소스 해제)
	}
}
