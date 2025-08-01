package com.ioex; // 야, 이 코드가 여기 산다. 주소 박아놨으니까 딴 데서 헤매지 마라.

/* 문제1) 숫자 하나를 입력받아 그 수가 1이면 "남성, 2이면 "여성"이라는 글자를 출력하는 프로그램,
	 단 모든 조건을 삼항연산자로 처리하시오
*/ // 숫자 받아서 1이면 남자, 2면 여자 출력하는 프로그램이다. 삼항 연산자로 조져라.

import java.io.*; // java.io 패키지 다 쓸 거다. 에러 처리할 때 필요함.

public class Test01 { // 야, Test01 이름으로 프로그램 시작한다. 이 파일 이름이랑 똑같으니까 틀리면 뒤진다.

	public static void main(String[] args) throws IOException { // 여기가 진짜 시작점이다. 무조건 여기부터 실행된다고 보면 됨. 에러 나면 main 메소드 밖으로 던져버리라는 뜻이다.

		int gender = 0; // gender라는 정수(int) 변수 만들었다. 0으로 초기화함.

		System.out.print("성별 입력(1:남성, 2:여성): "); // "성별 입력(1:남성, 2:여성): " 화면에 띄우고
		gender = System.in.read()-48; // 키보드에서 숫자 하나 읽어서 gender에 박아 넣는다. 아스키 코드 값에서 '0'을 빼야 진짜 숫자 됨.

		String str = (gender == 1? "남성" : "여성"); // gender가 1이면 "남성", 아니면 "여성"을 str에 넣는다. 이게 삼항 연산자다.
		System.out.println("당신은 " + str + "입니다."); // "당신은 [성별]입니다." 화면에 보여준다.
	}
}
