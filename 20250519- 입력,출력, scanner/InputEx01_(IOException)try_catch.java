package com.ioex; // 이 코드가 속한 폴더(패키지)를 나타내요. (패키지는 관련된 클래스들을 모아두는 일종의 폴더입니다.)

/* 예외 전가: 실행할때 실행 메소드가 알아서 처리하게끔 위임 
(*에러가 발생했다면 알아서 처리하도록 시키는 것)
throws -> 예외 전가 메소드 가로 뒤에 처리해야함
아스키 코드값 출력 때 사용할 수 있다 
*/ // 이 코드에 대한 기본적인 설명이 여기에 적혀있어요. 'throws' 키워드를 사용하여 예외를 위임한다는 내용입니다.

import java.io.*; // 'java.io' 패키지 안에 있는 모든 클래스들을 사용하겠다고 선언하는 부분이에요.
                   // 'IOException'이 이 패키지 안에 있어서 이 줄이 필요합니다.

public class InputEx01 { // 'InputEx01'이라는 이름의 프로그램을 시작하는 클래스입니다.

	public static void main(String[] args) throws IOException { // 프로그램이 실제로 시작되는 부분인 'main' 메소드예요.
		// throws IOException: 이 'main' 메소드 안에서 'IOException'이 발생할 경우,
		//                      'main' 메소드 자신이 처리하지 않고, 이 'main' 메소드를 호출한 상위 시스템(JVM)으로
		//                      예외 처리를 '전가(위임)'하겠다는 뜻입니다.
		//                      이렇게 하면 'System.in.read()'가 던질 수 있는 'IOException'에 대해
		//                      별도의 'try-catch' 블록을 사용하지 않아도 컴파일 오류가 발생하지 않아요.
		
		try { // 예외가 발생할 수 있는 코드를 이 'try' 블록 안에 넣습니다.
		
			System.out.print("문자 입력:"); // 사용자에게 '문자 입력:'이라는 메시지를 출력해요.
			int i = System.in.read();      // 키보드로부터 1바이트(문자 1개)를 읽어와서 'int' 타입 변수 'i'에 저장해요.
			                               // 'read()' 메소드는 읽어온 문자의 '아스키 코드' 값을 정수로 반환합니다.
			                               // 예를 들어 'A'를 입력하면 65를 반환해요.
			
			System.out.println();          // 줄 바꿈을 출력해서 다음 출력이 새로운 줄에 나오도록 합니다.
			System.out.println("ASCII 코드 값:" + i); // 읽어온 문자의 아스키 코드 값을 화면에 출력해요.
			
		} catch(IOException e) { // 만약 'try' 블록 안에서 'IOException'이 발생하면, 이 'catch' 블록이 실행됩니다.
			e.printStackTrace(); // 'e.printStackTrace()'는 예외가 발생한 경로와 원인을 상세하게 콘솔에 출력해주는 메소드예요.
			                     // (*error가 발생하면 이것을 출력해라) 라는 주석처럼, 오류 발생 시 디버깅(오류 찾기)에 아주 유용합니다.
		}
	}
}
