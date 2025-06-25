package com.ioex; // 야, 이 코드가 여기 산다. 주소 박아놨으니까 딴 데서 헤매지 마라.

import java.util.*; // java.util 패키지 다 쓸 거다. Scanner 쓸 때 필요함.

public class ScannerEx { // 야, ScannerEx 이름으로 프로그램 시작한다. 이 파일 이름이랑 똑같으니까 틀리면 뒤진다.

	public static void main(String[] args) { // 여기가 진짜 시작점이다. 무조건 여기부터 실행된다고 보면 됨.

		Scanner sc = new Scanner(System.in); // Scanner 쓸 준비하는 거다. 키보드 입력 받으려고 sc라는 이름으로 하나 만들었다.

		String name; // name이라는 글자(String) 변수 만들었다. 이름이나 긴 문장 넣을 때 쓴다.
		char c; 	// c라는 글자(char) 변수 만들었다. 딱 글자 한 글자만 넣을 수 있음.

		System.out.print("이름 입력: "); // "이름 입력: " 화면에 띄우고
		name = sc.next(); 			// 사용자가 입력한 한 단어 받아서 name에 박아 넣는다. (공백 전까지 끊어서 가져옴)

		System.out.print("혈액형: "); // "혈액형: " 화면에 띄우고
		c = sc.next().charAt(0); 	// 이거 존나 중요하고 좀 특이하다!
									// 1. sc.next(): 먼저 사용자가 입력한 걸 '문자열'로 통째로 읽어온다. (예: "A" 입력하면 "A" 문자열)
									// 2. .charAt(0): 그렇게 읽어온 문자열에서 '첫 번째 글자'(0번째 인덱스)만 딱 뽑아내는 거다.
									// (자바에서는 글자 순서를 0부터 센다. 첫 번째는 0번!)
									// 3. 그렇게 뽑아낸 한 글자 'A'를 char 변수 c에 박아 넣는 거임.

		System.out.println(name); // name에 뭐 들어있는지 화면에 보여준다.
		System.out.println(c); 	// c에 뭐 들어있는지 화면에 보여준다.
	}
}
