package com.ioex; // 야, 이 코드가 여기 산다. 주소 박아놨으니까 딴 데서 헤매지 마라.

/* 문] Scanner 클래스로 이름, 도시, 나이, 체중, 독신 여부를 입력받고 출력하는 프로그램을 구현하시오

문자열: 이름, 도시
정수: 나이
실수: 체중
논리(boolean): 독신여부
*/ // Scanner로 이름, 도시, 나이, 체중, 독신 여부 받아서 출력하는 프로그램이다.

import java.util.*; // java.util 패키지 안에 있는 모든 클래스 쓸 거다. Scanner 쓰려면 이거 있어야 함.

public class Exam01 { // 야, Exam01 이름으로 프로그램 시작한다. 이 파일 이름이랑 똑같으니까 틀리면 뒤진다.

	public static void main(String[] args) { // 여기가 진짜 시작점이다. 무조건 여기부터 실행된다고 보면 됨.

		// 1. Scanner 객체 생성
		Scanner sc = new Scanner(System.in); // Scanner 쓸 준비하는 거다. 키보드 입력 받으려고 sc라는 이름으로 하나 만들었다.

		// 2. 변수 선언
		String name, city; 	// 이름이랑 도시 저장할 글자(String) 변수 만들었다.
		int age; 			// 나이 저장할 정수(int) 변수 만들었다.
		double weight; 		// 체중 저장할 실수(double) 변수 만들었다.
		boolean issingle; 	// 독신 여부 저장할 참/거짓(boolean) 변수 만들었다.

		// 3. 사용자 입력 받기
		System.out.print("이름: "); // "이름: " 화면에 띄우고
		name = sc.next(); 			// 사용자가 입력한 한 단어 받아서 name에 박아 넣는다.

		System.out.print("도시: "); // "도시: " 화면에 띄우고
		city = sc.next(); 			// 사용자가 입력한 한 단어 받아서 city에 박아 넣는다.

		System.out.print("나이: "); // "나이: " 화면에 띄우고
		age = sc.nextInt(); 		// 사용자가 입력한 정수 받아서 age에 박아 넣는다.

		System.out.print("체중: "); // "체중: " 화면에 띄우고
		weight = sc.nextDouble(); 	// 사용자가 입력한 실수 받아서 weight에 박아 넣는다.

		System.out.print("독신 (true/false): "); // "독신 (true/false): " 화면에 띄우고
		issingle = sc.nextBoolean(); // 사용자가 'true'나 'false' 입력한 거 받아서 issingle에 박아 넣는다.

		// 4. 입력받은 정보 출력하기
		System.out.println("이름은 " + name + ", 도시는 " + city + " , 나이는 " + age + ", 체중은 "
		+ weight + ", 독신 여부는 " + issingle + " 입니다." ); // 입력받은 모든 정보 한 줄로 쭉 이어서 화면에 보여준다.

	}
}
