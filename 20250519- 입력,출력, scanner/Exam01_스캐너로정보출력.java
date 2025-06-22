package com.ioex; // 이 코드가 속한 폴더(패키지)를 나타내요. (패키지는 관련된 클래스들을 모아두는 일종의 폴더입니다.)

/* 문] Scanner 클래스로 이름, 도시, 나이, 체중, 독신 여부를 입력받고 출력하는 프로그램을 구현하시오
  
문자열: 이름, 도시
정수: 나이
실수: 체중
논리(boolean): 독신여부
*/ // 이 코드의 목표와 어떤 데이터 타입의 정보를 입력받을지 설명하고 있어요.

import java.util.*; // 'java.util' 패키지 안에 있는 모든 클래스들을 사용하겠다고 선언하는 부분이에요.
                     // 'Scanner' 클래스가 이 'java.util' 패키지 안에 있어서 이 줄이 필요합니다.

public class Exam01 { // 'Exam01'이라는 이름의 프로그램을 시작하는 클래스입니다. (모든 자바 코드는 클래스 안에 작성돼요.)

	public static void main(String[] args) { // 프로그램이 실제로 시작되는 부분이에요. 자바 프로그램은 항상 이 'main' 메서드부터 실행됩니다.
		
		// 1. Scanner 객체 생성
		Scanner sc = new Scanner(System.in); // 'Scanner'를 사용하기 위한 준비 단계입니다.
		                                     // 'sc'라는 이름의 'Scanner' 객체를 만들고, 'System.in' (표준 입력, 즉 키보드)으로부터
		                                     // 데이터를 읽어들이도록 설정했어요. 이제 'sc'를 통해 사용자 입력을 받을 수 있습니다.
		
		// 2. 변수 선언
		String name, city;     // 이름과 도시를 저장할 'String' (문자열) 타입 변수를 선언했어요.
		int age;               // 나이를 저장할 'int' (정수) 타입 변수를 선언했어요.
		double weight;         // 체중을 저장할 'double' (실수) 타입 변수를 선언했어요.
		boolean issingle;      // 독신 여부를 저장할 'boolean' (논리) 타입 변수를 선언했어요.
		// boolean single = false; // 이 주석은 'issingle' 대신 'single'이라는 변수명을 사용할 수도 있음을 보여주는 것 같아요.
		
		// 3. 사용자 입력 받기
		System.out.print("이름: "); // 사용자에게 '이름:'이라는 메시지를 출력해요. ('print'는 줄 바꿈 없음)
		name = sc.next();          // 사용자가 키보드로 입력한 **한 단어(공백 전까지)**를 읽어서 'name' 변수에 저장해요.
		
		System.out.print("도시: "); // '도시:' 메시지를 출력해요.
		city = sc.next();          // 사용자가 입력한 **한 단어**를 읽어서 'city' 변수에 저장해요.
		
		System.out.print("나이: "); // '나이:' 메시지를 출력해요.
		age = sc.nextInt();        // 사용자가 입력한 **정수 값**을 읽어서 'age' 변수에 저장해요.
		
		System.out.print("체중: "); // '체중:' 메시지를 출력해요.
		weight = sc.nextDouble();  // 사용자가 입력한 **실수 값**을 읽어서 'weight' 변수에 저장해요.
		
		System.out.print("독신 (true/false): "); // '독신 여부:' 메시지를 출력해요. (사용자가 'true' 또는 'false'를 입력하도록 안내)
		issingle = sc.nextBoolean(); // 사용자가 입력한 **'true' 또는 'false' 문자열**을 읽어서 'boolean' 타입으로 변환 후 'issingle' 변수에 저장해요.
		
		// 4. 입력받은 정보 출력하기
		System.out.println("이름은 " + name + ", 도시는 " + city + " , 나이는 " + age + ", 체중은 "
		+ weight + ", 독신 여부는 " + issingle + " 입니다." ); // 입력받은 모든 정보를 한 줄로 이어서 화면에 출력해요.
		// '+' 기호는 문자열과 변수의 값을 연결(이어 붙이기)할 때 사용됩니다.
		
		/* System.out.println("나의 이름은 " + name + "이고 \n 거주지는" + city+ "이며 \n 나이는 "age + "이고
		 \n" + weight + "kg이고 + "독신 여부는 " + isSingle + " 입니다.");
		*/	// 이 부분은 주석 처리된 다른 출력 예시입니다.
		    // '\n'은 '줄 바꿈'을 의미해요. 이 주석 처리된 코드를 사용하면 결과가 여러 줄로 출력될 것입니다.
		    // 또한, 'age' 앞에 '+' 연산자가 빠져있어 만약 주석을 풀고 사용한다면 컴파일 오류가 발생할 수 있습니다.
	}
}
