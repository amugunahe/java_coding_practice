package com.ioex; // 야, 이 코드가 여기 산다. 주소 박아놨으니까 딴 데서 헤매지 마라.

public class InputEx02 { // 야, InputEx02 이름으로 프로그램 시작한다. 이 파일 이름이랑 똑같으니까 틀리면 뒤진다.

	public static void main(String[] args) throws IOException { // 여기가 진짜 시작점이다. 무조건 여기부터 실행된다고 보면 됨. 에러 나면 main 메소드 밖으로 던져버리라는 뜻이다.

	System.out.print("문자 입력: "); // "문자 입력: " 화면에 띄우고
	char ch = (char)System.in.read(); // 키보드에서 글자 하나 읽어와서 ch에 박아 넣는다. (char로 바로 변환함)

	/*
	 char ch = (char)System.in.read();로 입력 받은 값을
	 정수 값 그대로 활용하기 위함
	 [* System.in.read();는 아스키 코드 출력 관련] 문자를 출력시킬 때 오류가 발생했을 경우 throws IOException{}을 활용하여
	 jAVA 버츄얼 머신에 오류 교정을 맡긴다
	 */ // 이거 원래 주석인데, System.in.read()는 아스키 코드 값을 int로 반환하는데, 그걸 char로 바꿔서 바로 글자 뽑아내려고 쓰는 거다. 에러 나면 JVM한테 던져버림.

	System.out.println(ch); // ch에 뭐 들어있는지 화면에 보여준다.
	}
}
