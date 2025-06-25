package com.condition;

import java.io.*; // 입출력 관련 클래스 쓰려고 import 함

public class IfEx07 {

	public static void main(String[] args)throws IOException { // 예외 처리 필수. 입출력하다 문제 생길 수 있어서 미리 알려주는 거임.

		// BufferedReader와 InputStreamReader로 효율적으로 사용자 입력 받기 준비
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a, b; // 첫번째, 두번째 정수를 저장할 변수
		char c; // 연산자를 저장할 변수

		System.out.print("첫번째 정수 입력: "); // 사용자에게 첫번째 정수 입력하라고 알려줌
		a = Integer.parseInt(br.readLine()); // 사용자가 입력한 문자열을 정수로 바꿔서 'a'에 저장

		System.out.print("연산자 입력: "); // 사용자에게 연산자 입력하라고 알려줌
		// char c = (char)System.in.read(); // <-- 이 부분 때문에 문제가 생김.
		// BufferedReader로 입력받은 문자열의 첫 글자를 연산자로 사용
		c = br.readLine().charAt(0); // 연산자도 BufferedReader로 받아서 첫 글자만 char로 뽑아냄. 이게 훨씬 깔끔함.


		System.out.print("두번째 정수 입력: "); // 사용자에게 두번째 정수 입력하라고 알려줌 (println 대신 print로 통일)
		b = Integer.parseInt(br.readLine()); // 사용자가 입력한 문자열을 정수로 바꿔서 'b'에 저장

		// 연산자에 따라 다른 계산 수행
		if( c == '+') { // 연산자가 '+'면 덧셈
			System.out.printf("%d + %d = %d", a, b, (a + b));
		} else if (c == '-') { // 연산자가 '-'면 뺄셈
			System.out.printf("%d - %d = %d", a, b, (a - b));
		} else if (c == '*') { // 연산자가 '*'면 곱셈
			System.out.printf("%d * %d = %d", a, b, (a * b));
		} else if (c == '/') { // 연산자가 '/'면 나눗셈
			// 나눗셈은 0으로 나눌 경우 에러 나니까 예외 처리 해주는 게 좋다.
			if (b == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
			} else {
				System.out.printf("%d / %d = %d", a, b, (a / b));
			}
		} else { // 위에 해당 안 되는 이상한 연산자 입력했을 때
			System.out.println("잘못된 연산자입니다.");
		}

		br.close(); // BufferedReader 사용 끝나면 꼭 닫아줘야 리소스 낭비 안 함. (중요!)
	}
}
