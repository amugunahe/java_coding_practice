package com.ioex; // 이 코드가 속한 폴더(패키지)를 나타내요. (패키지는 관련된 클래스들을 모아두는 일종의 폴더입니다.)

/* 문자 하나 이상일때를 문자열로 처리 // BufferedReader는 한 문자 단위가 아니라 문자열(여러 문자) 단위로 처리하는 데 적합하다는 의미입니다.
InputStreamReader is = new InputStreamReader(System.in); // 바이트 입력을 문자 입력으로 바꿔주는 다리 역할을 해요.
BufferedReader br = new BufferedReader(is) // 버퍼링 기능을 추가해서 입력 효율을 높여줘요.
String name = br.readLine(); // BufferedReader의 핵심 메소드로, 한 줄을 통째로 읽어와요.
*/ 

import java.io.*; // 'java.io' 패키지 안에 있는 모든 클래스들을 사용하겠다고 선언하는 부분이에요.
                   // 'BufferedReader', 'InputStreamReader', 'IOException' 등이 이 패키지 안에 있어서 이 줄이 필요합니다.

public class InputEx04 { // 'InputEx04'라는 이름의 프로그램을 시작하는 클래스입니다.

	public static void main(String[] arg) throws IOException { // 프로그램이 실제로 시작되는 부분인 'main' 메소드예요.
		// throws IOException: 'BufferedReader'의 `readLine()` 메소드가 `IOException`을 발생시킬 수 있기 때문에,
		//                      이 예외를 'main' 메소드를 호출한 상위 시스템(JVM)으로 전가하겠다는 의미예요.
		
		String name;    // 이름을 저장할 'String' (문자열) 타입 변수를 선언했어요.
		String age;     // 나이를 저장할 'String' 타입 변수를 선언했어요. (나중에 숫자로 변환할 수 있습니다.)
		String address; // 주소를 저장할 'String' 타입 변수를 선언했어요.
		String tel;     // 전화번호를 저장할 'String' 타입 변수를 선언했어요.
		
		/* 객체생성
		 InputStreamReader is = new InputStreamReader(System.in);  // 주석 처리된 부분이지만, 위에서 설명한 `InputStreamReader` 객체를 따로 만드는 과정을 보여줍니다.
   		 BufferedReader br = new BufferedReader(is);              // 이렇게 `BufferedReader`가 `InputStreamReader`를 감싸는 형태가 돼요.
		 */
		
		// 입력처리
		// 한 줄로 'BufferedReader' 객체를 생성하는 부분이에요.
		// System.in (바이트 스트림) -> InputStreamReader (문자 스트림으로 변환) -> BufferedReader (버퍼링 및 줄 단위 읽기 기능 추가)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름 입력:"); // 사용자에게 '이름 입력:'이라는 메시지를 출력해요.
		name = br.readLine();       // 사용자가 키보드로 입력한 **한 줄 전체**(엔터 전까지)를 읽어서 'name' 변수에 저장해요.
		                            // 'BufferedReader'의 가장 큰 특징이자 장점인 `readLine()` 메소드예요!
		
		System.out.print("나이 입력:"); // '나이 입력:' 메시지를 출력해요.
		age = br.readLine();        // 입력된 한 줄을 'age' 변수에 저장해요. (숫자 형태의 문자열이 저장됩니다.)
		
		System.out.print("주소 입력:"); // '주소 입력:' 메시지를 출력해요.
		address = br.readLine();    // 입력된 한 줄을 'address' 변수에 저장해요.
		
		System.out.print("전번 입력:"); // '전번 입력:' 메시지를 출력해요.
		tel = br.readLine();        // 입력된 한 줄을 'tel' 변수에 저장해요.
		
		//출력처리
		System.out.println("나의 이름은 "+ name + "이고\n, 나이는 "+ age + "세, 주소는 " + address +
				"이며\n 전번은 " + tel + "입니다"); // 입력받은 모든 정보를 조합하여 화면에 출력해요.
		                                       // `\n`은 줄 바꿈을 의미해요.
	}
}
