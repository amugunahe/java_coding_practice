package com.functionex; // 'com.functionex'는 이 자바 파일(클래스)이 속한 패키지 이름입니다. 패키지는 관련 클래스들을 묶어서 관리하는 폴더와 같은 역할을 합니다.

import java.io.*; // Java의 입출력(Input/Output) 관련 클래스들을 가져옵니다. 사용자로부터 키보드 입력을 받거나 파일 처리 등을 할 때 필요합니다.

/*
  이 프로그램은 사용자로부터 메뉴 번호를 입력받아 여러 가지 계산 기능을 수행하는 콘솔 기반 계산기입니다.
  각 기능은 별도의 '메서드(method)'로 구현되어 코드의 재사용성과 가독성을 높였습니다.
 
  제공되는 기능:
  1. 두 개의 숫자를 입력받아 그 중 **큰 수**를 찾아 출력합니다. ('aaa' 메서드)
  2. 두 개의 숫자를 입력받아 두 수 **사이의 합계**를 구해 출력합니다. ('bbb' 메서드)
  3. 세 개의 숫자를 입력받아 **큰 순서대로 나열**하여 출력합니다. ('ccc' 메서드)
  4. 프로그램을 **종료**합니다. ('finish' 메서드)
 
  프로그램은 사용자가 4번을 선택하여 종료할 때까지 메뉴를 계속해서 보여주고 기능을 수행합니다.
 */

public class funcExam01 { // 'funcExam01'이라는 이름의 공개(public) 클래스를 선언합니다. 모든 자바 프로그램은 클래스 안에 정의되어야 합니다.

    // --- 1. 두 수 중 큰 수 찾기 기능 ('aaa' 메서드) ---
    // 이 메서드는 사용자로부터 두 개의 정수를 입력받아 그 중 더 큰 값을 반환합니다.
	public static int aaa() throws IOException { // 'public static'은 어디서든 접근 가능하고 객체 생성 없이 사용 가능함을 의미합니다.
                                                 // 'int'는 이 메서드가 정수 값을 반환한다는 의미입니다.
                                                 // 'throws IOException'은 이 메서드 안에서 발생할 수 있는 입출력 관련 예외를 호출한 곳으로 넘긴다는 의미입니다.

		// 'BufferedReader'는 키보드로부터 한 줄 단위로 텍스트 입력을 효율적으로 읽어들이기 위한 객체입니다.
		// 'InputStreamReader(System.in)'는 'System.in'(표준 입력 스트림, 주로 키보드)에서 바이트를 문자로 변환합니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("첫번째 수: "); // 사용자에게 첫 번째 숫자 입력을 안내하는 메시지를 출력합니다. (줄 바꿈 없음)
		// 'br.readLine()'으로 사용자가 입력한 한 줄(문자열)을 읽어옵니다.
		// 'Integer.parseInt()'는 읽어온 문자열을 정수(int) 타입으로 변환합니다.
		int a = Integer.parseInt(br.readLine()); // 변환된 정수 값을 'a' 변수에 저장합니다.

		System.out.print("두번째 수: "); // 사용자에게 두 번째 숫자 입력을 안내합니다.
		int b = Integer.parseInt(br.readLine()); // 두 번째 숫자를 입력받아 'b' 변수에 저장합니다.

		if (a > b) { // 만약 'a'가 'b'보다 크면 (즉, 'a'가 더 큰 수라면)
			return a; // 'a'의 값을 이 메서드를 호출한 곳으로 반환합니다.
		}
		return b; // 그렇지 않으면 (즉, 'b'가 'a'보다 크거나 같으면) 'b'의 값을 반환합니다.
	}

    // --- 2. 두 수 사이의 합계 구하기 기능 ('bbb' 메서드) ---
    // 이 메서드는 사용자로부터 두 개의 정수를 입력받아, 그 두 수 사이의 모든 정수(첫 번째 수부터 두 번째 수 미만까지)의 합계를 계산하여 출력합니다.
	public static void bbb() throws IOException { // 이 메서드는 특정 값을 반환하지 않고(void), 결과를 직접 출력합니다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 키보드 입력을 위한 BufferedReader 객체를 생성합니다.

		System.out.print("첫번째 수: "); // 첫 번째 숫자 입력을 안내합니다.
		int a = Integer.parseInt(br.readLine()); // 정수로 변환하여 'a'에 저장합니다.

		System.out.print("두번째 수: "); // 두 번째 숫자 입력을 안내합니다.
		int b = Integer.parseInt(br.readLine()); // 정수로 변환하여 'b'에 저장합니다.

		int sum = 0; // 합계를 저장할 변수를 선언하고 0으로 초기화합니다.

		// 만약 첫 번째 수 'a'가 두 번째 수 'b'보다 크다면, 두 변수의 값을 서로 교환하여 항상 'a'가 'b'보다 작도록 만듭니다.
		// 이렇게 해야 'for' 루프가 올바르게 동작합니다. (예: 10과 5를 입력하면 5부터 10까지의 합계를 구해야 함)
		// 비트 XOR 연산자(^)를 이용한 값 교환 방식입니다. 임시 변수 없이 두 변수의 값을 바꿀 수 있습니다.
		if (a > b) { // 'a'가 'b'보다 크면
			a = a ^ b; // a에 (a XOR b) 결과 저장
			b = a ^ b; // b에 (새로운 a XOR b) 결과 저장 -> 이 시점에서 b는 원래 a의 값이 됩니다.
			a = a ^ b; // a에 (새로운 a XOR 새로운 b) 결과 저장 -> 이 시점에서 a는 원래 b의 값이 됩니다.
		}

		// 'a'부터 'b-1'까지의 합계를 계산하는 반복문입니다.
		// 'for' 루프는 초기화(int i = a;), 조건(i < b;), 증감(i++) 순서로 작동합니다.
		for (int i = a; i < b; i++) { // 변수 'i'를 'a'로 초기화하고, 'i'가 'b'보다 작은 동안 반복하며, 반복마다 'i'를 1씩 증가시킵니다.
			sum += i; // 'sum = sum + i;'와 같습니다. 현재 'i'의 값을 'sum'에 더해 누적합니다.
		}
		// 계산된 두 수 사이의 합계를 화면에 출력합니다.
		System.out.println(a + " ~ " + b + "사이의 합계: " + sum);
	}

    // --- 3. 세 수를 큰 순서대로 나열하기 기능 ('ccc' 메서드) ---
    // 이 메서드는 세 개의 정수(x, y, z)를 매개변수로 받아, 이들을 내림차순(큰 수부터 작은 수 순서)으로 정렬한 문자열을 반환합니다.
	public static String ccc(int x, int y, int z) { // 'String'은 이 메서드가 문자열을 반환한다는 의미입니다.

		// 단계 1: 'y'가 가장 큰 경우, 'x'와 'y'의 위치를 바꿉니다. (가장 큰 수를 'x' 위치에 두기 위함)
		if (y >= x && y >= z) { // 만약 'y'가 'x'보다 크거나 같고 동시에 'y'가 'z'보다 크거나 같으면 (y가 최대값)
			int imsi = x; // 'x'의 값을 임시 변수 'imsi'에 저장해 둡니다.
			x = y;        // 'x'에 'y'의 값을 할당합니다. (이제 'x'가 가장 큰 수가 됨)
			y = imsi;     // 'y'에 'imsi'에 저장했던 원래 'x'의 값을 할당합니다.
		}
		// 단계 2: 'z'가 가장 큰 경우, 'x'와 'z'의 위치를 바꿉니다. (가장 큰 수를 'x' 위치에 두기 위함)
		// 이 'else if'는 위의 'if' 조건이 거짓일 때만 실행됩니다.
		else if(z >= x && z >= y) { // 만약 'z'가 'x'보다 크거나 같고 동시에 'z'가 'y'보다 크거나 같으면 (z가 최대값)
			int imsi = x; // 'x'의 값을 임시 변수 'imsi'에 저장해 둡니다.
			x = z;        // 'x'에 'z'의 값을 할당합니다. (이제 'x'가 가장 큰 수가 됨)
			z = imsi;     // 'z'에 'imsi'에 저장했던 원래 'x'의 값을 할당합니다.
		}
		// 이 두 단계가 끝나면, 'x'는 세 수 중 가장 큰 수가 됩니다.

		// 단계 3: 남은 'y'와 'z' 중에서 큰 수를 'y' 위치로 옮겨 두 번째로 큰 수가 되도록 합니다.
		if (z >= y) { // 만약 'z'가 'y'보다 크거나 같으면
			int imsi = y; // 'y'의 값을 임시 변수 'imsi'에 저장해 둡니다.
			y = z;        // 'y'에 'z'의 값을 할당합니다. (이제 'y'가 두 번째로 큰 수가 됨)
			z = imsi;     // 'z'에 'imsi'에 저장했던 원래 'y'의 값을 할당합니다. (이제 'z'가 가장 작은 수가 됨)
		}
		// 위 세 단계의 비교 및 교환 과정을 거치면, 'x'는 가장 큰 수, 'y'는 중간 수, 'z'는 가장 작은 수가 됩니다.

		// 정렬된 세 수를 ">=" 기호로 연결하여 하나의 문자열로 만듭니다.
		String abc = x + ">=" + y + ">=" + z;

		return abc; // 만들어진 문자열을 이 메서드를 호출한 곳으로 반환합니다.
	}

    // --- 4. 프로그램 종료 기능 ('finish' 메서드) ---
    // 이 메서드는 프로그램 종료 메시지를 출력하고, 자바 프로그램을 완전히 종료시킵니다.
	public static void finish() { // 이 메서드는 반환 값이 없습니다(void).
		System.out.println("프로그램을 종료합니다."); // 종료 메시지를 화면에 출력합니다.
		System.exit(0); // 'System.exit(0)'는 현재 실행 중인 자바 가상 머신(JVM)을 종료시킵니다.
                        // 괄호 안의 '0'은 프로그램이 정상적으로 종료되었음을 의미하는 상태 코드입니다.
	}

    // --- 메인 메서드(main method): 프로그램의 시작점 ---
    // 자바 프로그램이 실행될 때 가장 먼저 실행되는 메서드입니다. 여기서 전체 프로그램의 흐름을 제어합니다.
	public static void main(String[] args) throws IOException { // 'throws IOException'은 입출력 관련 예외 처리를 위함입니다.

		BufferedReader br =	new BufferedReader(new InputStreamReader(System.in)); // 키보드 입력을 위한 BufferedReader 객체를 생성합니다.

		int x = 0; // 사용자 메뉴 선택 번호를 저장할 변수를 선언합니다. 초기값은 0입니다.

		// --- 무한 루프 시작 ---
		// 'while (true)'는 조건이 항상 참이므로, 이 안의 코드가 무한히 반복됩니다.
		// 프로그램 종료는 'finish()' 메서드가 호출될 때 'System.exit(0)'에 의해 이루어집니다.
		while (true) {
			// 사용자에게 메뉴 선택지를 출력하고 입력을 기다립니다.
			System.out.print("1: 최대수 2: 사이 합 3: 수 나열 4: 종료 =>");
			// 사용자 입력을 읽어 정수로 변환한 후 'x' 변수에 저장합니다.
			x = Integer.parseInt(br.readLine());

			// --- 'switch' 문: 사용자 선택에 따라 다른 기능 실행 ---
			// 'x' 변수의 값에 따라 해당하는 'case' 블록으로 이동하여 코드를 실행합니다.
			switch (x) {
			case 1: // 'x'가 1일 경우 (최대수 기능 선택)
				// 'aaa()' 메서드를 호출하고, 그 메서드가 반환하는 '큰 수'를 출력합니다.
				System.out.println("둘중 최대수는 " + aaa() + "입니다.");
				break; // 현재 'case' 블록의 실행을 종료하고 'switch' 문을 빠져나갑니다. (이 'break'가 없으면 다음 'case'도 실행될 수 있음)

			case 2: // 'x'가 2일 경우 (두 수 사이 합계 기능 선택)
				bbb(); // 'bbb()' 메서드를 호출합니다. 'bbb()'는 내부에서 직접 합계를 계산하고 출력합니다.
				break; // 'switch' 문을 빠져나갑니다.

			case 3: // 'x'가 3일 경우 (세 수 나열 기능 선택)
				System.out.println("첫번째 수: "); // 세 개의 숫자를 입력받기 위해 첫 번째 숫자 입력을 안내합니다.
				int firstSu = Integer.parseInt(br.readLine()); // 첫 번째 숫자를 입력받아 'firstSu'에 저장합니다.
				System.out.println("두번째 수: "); // 두 번째 숫자 입력을 안내합니다.
				int secondSu = Integer.parseInt(br.readLine()); // 두 번째 숫자를 입력받아 'secondSu'에 저장합니다.
				System.out.println("세번째 수: "); // 세 번째 숫자 입력을 안내합니다.
				int thirdSu = Integer.parseInt(br.readLine()); // 세 번째 숫자를 입력받아 'thirdSu'에 저장합니다.

				// 'ccc()' 메서드를 호출하여 세 수를 큰 순서대로 정렬한 문자열을 받아 'str' 변수에 저장합니다.
				String str = ccc(firstSu, secondSu, thirdSu);
				// 정렬된 결과를 출력합니다.
				System.out.println("큰 순으로 나열은 " + str);

				System.out.println(); // 한 줄을 비워 출력합니다. (보기 좋게)
				break; // 'switch' 문을 빠져나갑니다.

			case 4: // 'x'가 4일 경우 (프로그램 종료 기능 선택)
				finish(); // 'finish()' 메서드를 호출하여 프로그램을 종료합니다.
				break; // 'switch' 문을 빠져나갑니다. (하지만 finish() 내부에서 프로그램이 종료되므로 사실상 이 'break'는 실행되지 않습니다.)

			default: // 'x'가 위의 어떤 'case'에도 해당하지 않을 경우 (잘못된 입력)
				System.out.println("잘못 입력하셨습니다."); // 잘못된 입력임을 알리는 메시지를 출력합니다.
				break; // 'switch' 문을 빠져나갑니다.
			}
			System.out.println(); // 각 기능 실행 후 한 줄을 비워 출력합니다. (보기 좋게)
		}
		// 'System.out.println("오늘도 열공하세요.");' 이 부분은 현재 주석 처리되어 있습니다.
		// 만약 주석을 풀면 프로그램이 종료되기 전에 이 메시지가 출력될 것입니다.
	} // main 메서드 종료

} // funcExam01 클래스 종료
