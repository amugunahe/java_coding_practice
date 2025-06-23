package com.functionex; // com.functionex 패키지에 속하는 클래스임을 나타냅니다. 패키지는 관련 클래스들을 묶어 관리하는 폴더와 같은 개념입니다.

import java.io.*; // Java의 입출력(Input/Output) 관련 클래스들을 가져옵니다. 사용자로부터 키보드 입력을 받을 때 필요합니다.

public class funcExam02 { // funcExam02라는 이름의 공개(public) 클래스를 선언합니다. 자바 프로그램의 기본 실행 단위입니다.

    // --- 연산 메서드들 ---
    // 아래 메서드들은 각각 덧셈, 뺄셈, 곱셈, 나눗셈, 나머지 연산을 수행하고 결과를 반환합니다.

	public static int plus(int a, int b) { // 두 개의 정수(a, b)를 받아 덧셈(+)을 수행하고 그 결과를 정수형으로 반환하는 메서드입니다.
		return a + b;
	}

	public static int minus(int a, int b) { // 두 개의 정수(a, b)를 받아 뺄셈(-)을 수행하고 그 결과를 정수형으로 반환하는 메서드입니다.
		return a - b;
	}

	public static int multi(int a, int b) { // 두 개의 정수(a, b)를 받아 곱셈(*)을 수행하고 그 결과를 정수형으로 반환하는 메서드입니다.
		return a * b;
	}

	public static int divi(int a, int b) { // 두 개의 정수(a, b)를 받아 나눗셈(/)을 수행하고 그 결과를 정수형으로 반환하는 메서드입니다.
		return a / b; // 정수 간 나눗셈은 몫만 반환합니다. (예: 5 / 2 = 2)
	}

	public static int per(int a, int b) { // 두 개의 정수(a, b)를 받아 나머지 연산(%)을 수행하고 그 결과를 정수형으로 반환하는 메서드입니다.
		return a % b; // (예: 5 % 2 = 1)
	}

    // --- 결과 출력 메서드 ---

	public static void disp(int a, char b, int c, int d) { // 첫 번째 수(a), 연산자(b), 두 번째 수(c), 결과(d)를 받아 화면에 출력하는 메서드입니다.
		// 이 메서드는 계산 결과를 반환하지 않고(void), 단순히 화면에 내용을 표시하는 역할만 합니다.
		System.out.println(); // 한 줄을 비워 출력합니다. (줄 바꿈)
		// "첫 번째 수 연산자 두 번째 수 = 결과" 형식으로 출력합니다.
		System.out.println(a + " " + b + " " + c + " = " + d);
	}

    // --- 메인 메서드: 프로그램 시작점 ---

	public static void main(String[] args) throws IOException { // 자바 프로그램이 실행될 때 가장 먼저 실행되는 메서드입니다.
		// 'throws IOException'은 입출력 작업 중 발생할 수 있는 예외(에러)를 처리하겠다는 의미입니다.

		// 키보드 입력을 효율적으로 읽어들이기 위한 BufferedReader 객체를 생성합니다.
		// System.in은 표준 입력 스트림(키보드)을 나타냅니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 변수 선언:
		int su1, su2, res = 0; // su1: 첫 번째 숫자, su2: 두 번째 숫자, res: 계산 결과를 저장할 변수 (0으로 초기화)
		char yon; // yon: 연산자(+, -, *, /, %)를 저장할 문자(char)형 변수

		// --- 첫 번째 숫자 입력 받기 ---
		System.out.print("첫번째 수: "); // 사용자에게 첫 번째 숫자를 입력하라는 메시지를 출력합니다.
		// br.readLine()으로 한 줄을 읽어와 문자열로 받은 후, Integer.parseInt()를 이용해 정수형으로 변환하여 su1에 저장합니다.
		
		su1 = Integer.parseInt(br.readLine());

		// --- 연산자 입력 받기 (유효성 검사 포함) ---
		// do-while 반복문을 사용하여 올바른 연산자를 입력할 때까지 반복해서 입력받습니다.
		do {
			System.out.print("연산자 입력: "); // 사용자에게 연산자를 입력하라는 메시지를 출력합니다.
			
			// System.in.read()로 문자 하나를 읽어와 char형으로 변환하여 yon에 저장합니다.
			yon = (char)System.in.read();
			
			// System.in.read(); System.in.read();
			// 남은 개행 문자(Enter 키 입력 시 발생하는 '\r', '\n')를 버퍼에서 제거하여 다음 입력에 영향을 주지 않도록 합니다.
			System.in.read();
			System.in.read();

		} while (yon != '+' && yon != '-' && yon != '*' && yon != '/' && yon != '%');
		// yon 변수의 값이 '+', '-', '*', '/', '%' 중 어느 하나도 아닐 경우 (즉, 유효하지 않은 연산자를 입력했을 경우)
		// do 블록을 다시 실행하여 연산자를 재입력받습니다.

		// --- 두 번째 숫자 입력 받기 ---
		System.out.print("두번째 수: "); // 사용자에게 두 번째 숫자를 입력하라는 메시지를 출력합니다.
		// 첫 번째 숫자와 동일한 방식으로 두 번째 숫자를 입력받아 su2에 저장합니다.
		su2 = Integer.parseInt(br.readLine());

		// --- 연산 수행 (switch 문) ---
		// 입력받은 연산자(yon)에 따라 해당 연산을 수행하는 메서드를 호출하고 결과를 res에 저장합니다.
		switch (yon) { // yon 변수의 값에 따라 해당 case 블록을 실행합니다.
				
		case '+': // yon이 '+'일 경우
			res = plus(su1, su2); // plus 메서드를 호출하여 덧셈 결과를 res에 저장합니다.
			break; // 현재 case 실행을 종료하고 switch 문을 빠져나갑니다.
				
		case '-': // yon이 '-'일 경우
			res = minus(su1, su2); // minus 메서드를 호출하여 뺄셈 결과를 res에 저장합니다.
			break;
				
		case '*': // yon이 '*'일 경우
			res = multi(su1, su2); // multi 메서드를 호출하여 곱셈 결과를 res에 저장합니다.
			break;
				
		case '/': // yon이 '/'일 경우
			// 0으로 나누는 경우에 대한 예외 처리는 이 코드에 포함되어 있지 않습니다.
			// 실제 프로그램에서는 나누는 수가 0인지 확인하는 로직이 필요합니다.
			res = divi(su1, su2); // divi 메서드를 호출하여 나눗셈 결과를 res에 저장합니다.
			break;
				
		case '%': // yon이 '%'일 경우
			res = per(su1, su2); // per 메서드를 호출하여 나머지 연산 결과를 res에 저장합니다.
			break;
		}

		// --- 결과 출력 메서드 호출 ---
		// 계산된 첫 번째 수(su1), 연산자(yon), 두 번째 수(su2), 최종 결과(res)를 disp 메서드에 전달하여 출력합니다.
		disp(su1, yon, su2, res);
		
	} // main 메서드 종료
} // funcExam02 클래스 종료
