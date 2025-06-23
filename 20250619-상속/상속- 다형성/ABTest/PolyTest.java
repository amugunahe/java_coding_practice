package com.polymorphism;

import java.util.Scanner; // 사용자 입력을 받기 위한 Scanner 클래스를 불러옵니다.

// --- MyPoint 클래스: 모든 도형의 기본이 되는 '점' 클래스 ---
// 모든 도형(원, 사각형)은 기본적으로 좌표(x, y)를 가집니다.
// 이 클래스는 도형들이 공통으로 가질 속성과 기능을 정의합니다.
class MyPoint {
	private int x; // 점의 x 좌표
	private int y; // 점의 y 좌표

	// static: 프로그램 시작 시 단 한 번 생성되고 모든 객체가 공유합니다.
	// protected: 이 클래스와 자식 클래스에서만 접근 가능합니다.
	protected static Scanner sc;

	// static 블록: 클래스가 메모리에 로드될 때 (가장 처음 사용될 때) 실행됩니다.
	static {
		sc = new Scanner(System.in); // 프로그램 전체에서 사용할 Scanner 객체를 여기서 한 번만 생성합니다.
	}

	// 생성자: 새로운 MyPoint 객체를 만들 때 실행됩니다.
	// x, y 좌표를 사용자로부터 입력받아 초기화합니다.
	protected MyPoint() {
		System.out.print("x 좌표 입력: ");
		this.x = sc.nextInt();
		System.out.print("y 좌표 입력: ");
		this.y = sc.nextInt();
	}

	// 점의 정보를 화면에 출력하는 메소드
	// 자식 클래스에서 오버라이딩하거나 호출할 수 있도록 protected로 선언합니다.
	protected void disp() {
		System.out.println("점(x, y): (" + x + ", " + y + ")");
	}
}

// --- Circle 클래스: '원'을 나타내는 클래스 ---
// MyPoint를 상속받아 점의 속성(x, y)을 가지고, 반지름(r)을 추가합니다.
class Circle extends MyPoint {
	private int r; // 원의 반지름

	// 생성자: 원 객체를 만들 때 실행됩니다.
	public Circle() {
		super(); // 부모 클래스(MyPoint)의 생성자를 호출합니다. (x, y 좌표 입력받는 부분 실행)
		System.out.print("반지름 r 입력: ");
		this.r = sc.nextInt(); // MyPoint의 static Scanner(sc)를 재사용합니다.
	}

	// disp() 메소드 재정의(Override): 원의 정보(x, y, r)를 출력합니다.
	@Override
	protected void disp() {
		super.disp(); // 부모 클래스(MyPoint)의 disp()를 먼저 호출합니다. (x, y 출력)
		System.out.println("반지름 r: " + this.r);
	}
}

// --- Rect 클래스: '사각형'을 나타내는 클래스 ---
// MyPoint를 상속받아 점의 속성(x, y)을 가지고, 가로(w)와 세로(h)를 추가합니다.
class Rect extends MyPoint {
	private int w; // 사각형의 가로
	private int h; // 사각형의 세로

	// 생성자: 사각형 객체를 만들 때 실행됩니다.
	public Rect() {
		super(); // 부모 클래스(MyPoint)의 생성자를 호출합니다. (x, y 좌표 입력받는 부분 실행)
		System.out.print("가로 w 입력: ");
		this.w = sc.nextInt(); // MyPoint의 static Scanner(sc)를 재사용합니다.
		System.out.print("세로 h 입력: ");
		this.h = sc.nextInt(); // MyPoint의 static Scanner(sc)를 재사용합니다.
	}

	// disp() 메소드 재정의(Override): 사각형의 정보(x, y, w, h)를 출력합니다.
	@Override
	protected void disp() {
		super.disp(); // 부모 클래스(MyPoint)의 disp()를 먼저 호출합니다. (x, y 출력)
		System.out.println("가로: " + this.w + ", 세로: " + this.h);
	}
}

// --- PolyTest 클래스: 도형 관리 프로그램의 시작점 ---
// 이 파일의 유일한 'public' 클래스이며, 파일 이름(PolyTest.java)과 같아야 합니다.
// 프로그램의 메인 실행 로직을 포함합니다.
public class PolyTest {

	public static void main(String[] args) {
		// MyPoint 타입의 배열을 10칸 만듭니다.
		// 이 배열에는 MyPoint 객체뿐만 아니라, MyPoint를 상속받는 Circle, Rect 객체도 저장할 수 있습니다.
		// 이것이 '다형성(Polymorphism)'의 핵심입니다.
		MyPoint[] mp = new MyPoint[10];

		// 현재까지 입력된 도형의 개수를 세는 변수
		int count = 0;

		// 무한 루프: 사용자가 '4. 프로그램 종료'를 선택할 때까지 계속 실행됩니다.
		while (true) {
			// 배열이 꽉 찼는지 확인하여 더 이상 입력받지 않도록 사용자에게 안내합니다.
			if (count >= mp.length) {
				System.out.println("\n[알림] 더 이상 도형을 입력할 수 없습니다. (최대 10개)");
				System.out.println("       '3. 현재까지 입력된 도형 보기'를 이용하거나 '4. 프로그램 종료'를 선택해주세요.");
			}

			System.out.println("\n--- 도형 관리 메뉴 ---");
			System.out.print("1.원 입력 2.사각형 입력 3.현재까지 입력된 도형 보기 4.프로그램 종료 >> ");

			// MyPoint 클래스의 static Scanner를 사용하여 사용자 입력을 받습니다.
			int n = MyPoint.sc.nextInt();

			if (n == 1) { // 1번: 원 입력 선택
				if (count < mp.length) { // 배열에 공간이 남아있다면
					mp[count] = new Circle(); // 새로운 Circle 객체를 만들어 배열에 저장 (업캐스팅)
					count++; // 입력된 도형 개수를 1 증가
				} else {
					System.out.println("좌표 배열이 가득 찼습니다. 더 이상 입력할 수 없습니다.");
				}
			} else if (n == 2) { // 2번: 사각형 입력 선택
				if (count < mp.length) { // 배열에 공간이 남아있다면
					mp[count] = new Rect(); // 새로운 Rect 객체를 만들어 배열에 저장 (업캐스팅)
					count++; // 입력된 도형 개수를 1 증가
				} else {
					System.out.println("좌표 배열이 가득 찼습니다. 더 이상 입력할 수 없습니다.");
				}
			} else if (n == 3) { // 3번: 현재까지 입력된 도형 보기 선택
				System.out.println("\n--- 현재까지 입력된 도형 정보 ---");
				if (count == 0) { // 입력된 도형이 하나도 없으면
					System.out.println("아직 입력된 도형이 없습니다.");
				} else {
					// 현재까지 입력된 도형의 개수(count)만큼 반복하여 정보를 출력합니다.
					for (int j = 0; j < count; j++) {
						mp[j].disp(); // 중요! mp[j]가 가리키는 실제 객체(Circle 또는 Rect)의
						              // 오버라이딩된 disp() 메소드가 자동으로 호출됩니다.
						System.out.println("-------------------------"); // 각 도형 구분을 위한 구분선
					}
				}
				System.out.println("--- 조회 완료 ---");
			} else if (n == 4) { // 4번: 프로그램 종료 선택
				System.out.println("프로그램을 종료합니다.");
				MyPoint.sc.close(); // 프로그램 종료 전에 Scanner 자원을 해제합니다.
				System.exit(0); // 프로그램을 완전히 종료합니다.
			} else { // 1, 2, 3, 4 외의 잘못된 입력
				System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요.");
			}
		} // while 루프 끝
	} // main 메소드 끝
} // PolyTest 클래스 끝