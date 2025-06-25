package com.ioex; // 야, 이 코드가 여기 산다. 주소 박아놨으니까 딴 데서 헤매지 마라.

/* 예외 전가: 에러나면 지가 알아서 처리하라고 던지는 거임. throws 쓰면 된다.
*/ // 이 코드 설명이 여기 박혀있다.

import java.io.*; // java.io 패키지 다 쓸 거다. 에러 처리할 때 필요함.

public class InputEx01 { // 야, InputEx01 이름으로 프로그램 시작한다. 이 파일 이름이랑 똑같으니까 틀리면 뒤진다.

	public static void main(String[] args) throws IOException { // 여기가 진짜 시작점이다. 무조건 여기부터 실행된다고 보면 됨. 에러 나면 main 메소드 밖으로 던져버리라는 뜻이다. (throws IOException)

		try { // 에러 날 수도 있는 코드는 여기 안에 넣어라.

			System.out.print("문자 입력:"); // "문자 입력:" 띄우고
			int i = System.in.read(); 	// 키보드에서 글자 하나 읽어와서 i에 박아 넣는다. (아스키 코드 값으로 저장됨)

			System.out.println(); 		// 줄 바꿈 한번 해주고.
			System.out.println("ASCII 코드 값:" + i); // 읽어온 글자의 아스키 코드 값을 화면에 보여준다.

		} catch(IOException e) { // 만약 try 안에서 에러나면 이쪽으로 와라.
			e.printStackTrace(); // 에러 터진 곳 상세하게 다 보여준다. 디버깅할 때 존나 유용함.
		}
	}
}
