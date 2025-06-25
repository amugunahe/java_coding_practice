package com.condition; // 야, 이 코드가 여기 산다. 주소 박아놨으니까 딴 데서 헤매지 마라.

/* 알파벳 하나 받아서 대문자면 소문자로, 소문자면 대문자로 바꿔주는 프로그램이다. System.in.read() 써서 입력받아라. */

import java.io.*; // java.io 패키지 다 쓸 거다. 입력 받거나 에러 처리할 때 필요함.

public class IfEx11 { // 야, IfEx11 이름으로 프로그램 시작한다. 이 파일 이름이랑 똑같으니까 틀리면 뒤진다.

	public static void main(String[] args) throws IOException { // 여기가 진짜 시작점이다. 무조건 여기부터 실행된다고 보면 됨. 에러 나면 main 메소드 밖으로 던져버리라는 뜻이다.

		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 이거는 지금 안 쓴다. System.in.read()로 바로 받아서.

		int n; // 아스키 코드 숫자 담을 변수.

		System.out.print("알파벳 입력: "); // "알파벳 입력: " 띄우고
		n = System.in.read(); // 키보드에서 글자 하나 읽어와서 n에 박아 넣는다. (아스키 코드 숫자 값으로 들어감)

		// 입력 받은 값이 대문자라면? (정수로 아스키 코드 비교)
		if (n >= 65 && n <= 90) { // n이 대문자(아스키 코드 65~90)면
			n += 32; // 32 더해서 소문자 아스키 코드로 바꾼다.
			System.out.println((char)(n)); // 소문자로 바꾼 거 화면에 보여준다.

		} else if (n >=97 && n <= 122) { // n이 소문자(아스키 코드 97~122)면
			n -= 32; // 32 빼서 대문자 아스키 코드로 바꾼다.
			System.out.println((char)(n)); // 대문자로 바꾼 거 화면에 보여준다.
		} else { // 둘 다 아니면 (알파벳 아니면)
			System.out.println("입력 오류 입니다."); // "입력 오류"라고 욕 박는다.
		}
	}
}
