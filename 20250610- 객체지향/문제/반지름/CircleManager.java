package com.functionex; // 'com.functionex'는 이 자바 파일(클래스)이 속한 패키지 이름입니다.
                        // 앞서 만든 'Circle' 클래스와 같은 패키지에 있어야 서로를 쉽게 찾아 사용할 수 있습니다.

import java.util.Scanner; // 'java.util.Scanner'는 사용자로부터 키보드 입력을 받기 위해 필요한 클래스입니다.
                           // 이 클래스를 사용하면 콘솔에서 숫자나 문자열을 쉽게 입력받을 수 있어요.

/*
 * 이 'CircleManager' 클래스는 '원' 객체(Circle)들을 관리하는 역할을 합니다.
 * 주로 'main' 메소드 안에서 프로그램의 시작부터 끝까지의 흐름을 제어합니다.
 *
 * 기능:
 * 1. 사용자로부터 3개의 원에 대한 중심 좌표(x, y)와 반지름(radius)을 입력받습니다.
 * 2. 입력받은 정보로 3개의 'Circle' 객체를 생성하여 배열에 저장합니다.
 * 3. 저장된 각 'Circle' 객체의 정보를 'show()' 메소드를 사용하여 화면에 출력합니다.
 */
public class CircleManager { // 'CircleManager'라는 이름의 공개(public) 클래스를 선언합니다.
                             // 이 클래스는 여러 'Circle' 객체를 만들고 관리하는 '관리자' 역할을 한다고 생각하시면 됩니다.

    // --- 메인 메소드(main method): 프로그램의 실제 시작점 ---
    // 자바 프로그램을 실행하면 이 'main' 메소드부터 코드가 실행되기 시작합니다.
    // 여기서 프로그램의 전체적인 흐름을 제어합니다.
	public static void main(String[] args){ // 'public static void'는 자바 프로그램의 시작 메소드임을 나타내는 표준 선언입니다.
                                             // 'String[] args'는 프로그램 실행 시 외부에서 전달되는 인자(arguments)를 받을 때 사용하지만,
                                             // 이 프로그램에서는 사용하지 않습니다.

		// Scanner 객체를 생성하여 사용자로부터 키보드 입력을 받을 준비를 합니다.
		// 'new Scanner(System.in)'은 시스템의 표준 입력 스트림(System.in, 즉 키보드)으로부터 읽어올 새 Scanner 객체를 만듭니다.
		Scanner sc = new Scanner(System.in);
		
		// 'Circle' 객체(원 정보)를 3개 저장할 수 있는 '배열'을 선언하고 생성합니다.
		// 'Circle c[]'는 'Circle' 타입의 객체들을 저장할 배열 'c'를 선언한다는 의미입니다.
		// 'new Circle[3]'은 'Circle' 객체를 3개(인덱스 0, 1, 2) 저장할 수 있는 공간을 메모리에 만든다는 의미입니다.
		// 이 배열의 각 칸에는 아직 'Circle' 객체가 들어있지 않고, 'null' 상태입니다.
		Circle c[] = new Circle[3];

		// --- 'for' 루프: 3개의 원 정보 입력받기 ---
		// 이 반복문은 3번 반복하여 각각의 'Circle' 객체에 대한 정보를 사용자로부터 입력받고 생성합니다.
		for(int i = 0; i < c.length; i++){ // 'int i = 0;': 반복문의 시작 인덱스를 0으로 초기화합니다.
                                           // 'i < c.length;': 'i'가 배열 'c'의 길이(3)보다 작은 동안 (즉, i가 0, 1, 2일 때) 반복합니다.
                                           // 'i++': 반복할 때마다 'i' 값을 1씩 증가시킵니다.

            // 현재 입력받을 원이 몇 번째 원인지 알려주는 안내 메시지입니다.
            // (참고: 원래 코드는 "x, y, radius >> "만 있었고, 각 변수마다 별도의 안내 문구가 추가되었네요.)
		    System.out.print("x, y, radius >> "); // 사용자에게 x, y 좌표와 반지름을 입력하라고 안내합니다. (줄 바꿈 없음)

		    System.out.print("x값 입력"); // x 좌표 입력을 안내합니다.
		    double x = sc.nextDouble(); // 'sc.nextDouble()'로 사용자가 입력한 실수(double) 값을 읽어와 'x' 변수에 저장합니다.

		    System.out.print("y값 입력"); // y 좌표 입력을 안내합니다.
		    double y = sc.nextDouble(); // 'sc.nextDouble()'로 사용자가 입력한 실수(double) 값을 읽어와 'y' 변수에 저장합니다.

		    System.out.print("반지름 입력"); // 반지름 입력을 안내합니다.
		    int radius = sc.nextInt(); // 'sc.nextInt()'로 사용자가 입력한 정수(int) 값을 읽어와 'radius' 변수에 저장합니다.

		    // 입력받은 'x', 'y', 'radius' 값을 가지고 새로운 'Circle' 객체를 생성합니다.
		    // 그리고 이 새로 생성된 'Circle' 객체를 배열 'c'의 'i'번째 위치에 저장합니다.
		    // 이제 배열의 각 칸에 실제 'Circle' 객체가 채워지기 시작합니다.
		    c[i] = new Circle(x, y, radius); // 'Circle' 클래스의 생성자를 호출하여 객체를 만듭니다.
		    }

		// --- 'for' 루프: 3개의 원 정보 출력하기 ---
		// 이 반복문은 배열 'c'에 저장된 각 'Circle' 객체의 정보를 'show()' 메소드를 사용하여 화면에 출력합니다.
		for(int i = 0; i < c.length; i++) // 위와 동일하게 배열의 모든 요소에 대해 반복합니다.
			c[i].show(); // 배열 'c'의 'i'번째 위치에 있는 'Circle' 객체의 'show()' 메소드를 호출합니다.
                         // 'show()' 메소드는 해당 원의 중심 좌표와 반지름을 출력하는 역할을 합니다.
		
        // 프로그램이 모든 작업을 마쳤으므로, 여기서 'main' 메소드의 실행이 종료되고 프로그램이 끝납니다.
		// sc.close(); // (선택 사항) 사용했던 Scanner 객체를 닫아 자원을 해제하는 것이 좋은 습관입니다.
	}
} // CircleManager 클래스 종료
