package com.ioex; // 야, 이 코드가 여기 산다. 주소 박아놨으니까 딴 데서 헤매지 마라.

/* 문제 2) 문자 하나를 입력 받아 문자가 산술 연산자인지 아닌지를 판단하는 프로그램을 만드세요
산술연산자: ('+ , - , *, /, %)
단, 모든 조건을 삼항연산자로 처리하시오.
*/ // 글자 하나 받아서 산술 연산자인지 아닌지 판단하는 프로그램이다. 삼항 연산자로 조져라.

import java.io.*; // java.io 패키지 다 쓸 거다. 에러 처리할 때 필요함.

public class Test02 { // 야, Test02 이름으로 프로그램 시작한다. 이 파일 이름이랑 똑같으니까 틀리면 뒤진다.

	public static void main(String[] args) throws IOException { // 여기가 진짜 시작점이다. 무조건 여기부터 실행된다고 보면 됨. 에러 나면 main 메소드 밖으로 던져버리라는 뜻이다.

		char yon; // yon이라는 char(글자) 변수 만들었다.
		boolean bool = false; // bool이라는 boolean(참/거짓) 변수 만들었다. 기본은 거짓(false)으로 해놨다.

		System.out.print("산술 연산자 입력(+, -, *, /, %): "); // "산술 연산자 입력..." 화면에 띄우고
		yon = (char)System.in.read(); // 키보드에서 글자 하나 읽어서 yon에 박아 넣는다. (char로 바로 변환함)

		bool = yon == '+' || yon == '-' || yon == '*' || yon == '/'
			|| yon == '%'? true : false; // yon이 '+', '-', '*', '/', '%' 중에 하나라도 맞으면 bool에 '참(true)', 아니면 '거짓(false)' 박아 넣는다. 이게 삼항 연산자다.

		/* if(yon == '+' || yon == '-' || yon == '*' || yon == '/' || yon == '%')
		  bool true;
		  else
		  bool false;
		 */ // 이거 원래 주석인데, if-else문으로 쓰는 거랑 똑같은데 삼항 연산자로 줄인 거다.

		System.out.print(bool + "는 산술연산자" + (bool? "입" : "가 아닙") + "니다"); // bool 값에 따라 "산술연산자입니다" 또는 "산술연산자가 아닙니다"를 출력한다.
	}
}
