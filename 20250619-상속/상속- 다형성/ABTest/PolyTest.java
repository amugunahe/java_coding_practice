package com.polymorphism; // 이 코드가 속한 패키지(폴더) 이름이다.

import java.util.*; // 'Scanner' 클래스를 쓰려면 이 새끼를 불러와야 한다, 씨발!

// --- MyPoint 클래스: 모든 도형의 **존나 중요한 부모 (기본 '점')** ---
// 모든 도형은 기본적으로 x, y 좌표를 가진다. 그 공통점을 여기서 정의한다.
class MyPoint {
	private int x; // 점의 x 좌표
	private int y; // 점의 y 좌표

	// ★★★ 존나 중요! 'static Scanner': 프로그램 전체에서 **딱 한 번 만들어서 다 같이 쓴다.** ★★★
	// 'protected': 나(MyPoint)랑 내 자식들(Circle, Rect)만 접근 가능.
	protected static Scanner sc;

	// static 블록: 이 클래스가 메모리에 올라올 때 (가장 처음 쓰일 때) **단 한 번만 실행된다.**
	static {
		sc = new Scanner(System.in); // Scanner 객체를 여기서 미리 만들어 둔다.
        System.out.println("--- MyPoint 클래스 로드됨: Scanner 준비 완료 ---"); // 디버깅용 메시지
	}

	// 생성자: 새로운 '점' 객체 만들 때 실행된다. x, y 좌표는 사용자한테 입력받아서 초기화한다.
	protected MyPoint() {
		System.out.print("x 좌표 입력: ");
		this.x = sc.nextInt();
		System.out.print("y 좌표 입력: ");
		this.y = sc.nextInt();
	}

	// 점의 정보를 화면에 출력하는 메소드.
	// 자식들이 오버라이딩하거나 불러 쓸 수 있게 'protected'로 열어뒀다.
	protected void disp() {
		System.out.println("점(x, y): (" + x + ", " + y + ")");
	}
}

// --- Circle 클래스: '원' (MyPoint의 자식) ---
// 점(x, y)은 기본으로 가지고, 반지름(r)을 추가한다.
class Circle extends MyPoint { // MyPoint를 상속받아서 '점'의 속성을 물려받는다.
	private int r; // 원의 반지름

	// 생성자: 원 객체 만들 때 실행된다.
	public Circle() {
		super(); // ★★★ 존나 중요! 부모(MyPoint) 생성자 먼저 호출해서 x, y 좌표 입력받는다! ★★★
		System.out.print("반지름 r 입력: ");
		this.r = sc.nextInt(); // 부모의 static Scanner(sc) 재활용!
	}

	// disp() 메소드 재정의(Override): 원의 정보(x, y, r)를 출력한다.
	@Override
	protected void disp() {
		super.disp(); // ★★★ 부모(MyPoint)의 disp() 먼저 불러서 x, y 출력하고! ★★★
		System.out.println("반지름 r: " + this.r); // 그다음에 반지름 출력.
	}
}

// --- Rect 클래스: '사각형' (MyPoint의 자식) ---
// 점(x, y)은 기본으로 가지고, 가로(w)와 세로(h)를 추가한다.
class Rect extends MyPoint { // MyPoint를 상속받아서 '점'의 속성을 물려받는다.
	private int w; // 사각형의 가로
	private int h; // 사각형의 세로

	// 생성자: 사각형 객체 만들 때 실행된다.
	public Rect() {
		super(); // ★★★ 존나 중요! 부모(MyPoint) 생성자 먼저 호출해서 x, y 좌표 입력받는다! ★★★
		System.out.print("가로 w 입력: ");
		this.w = sc.nextInt(); // 부모의 static Scanner(sc) 재활용!
		System.out.print("세로 h 입력: ");
		this.h = sc.nextInt(); // 부모의 static Scanner(sc) 재활용!
	}

	// disp() 메소드 재정의(Override): 사각형의 정보(x, y, w, h)를 출력한다.
	@Override
	protected void disp() {
		super.disp(); // ★★★ 부모(MyPoint)의 disp() 먼저 불러서 x, y 출력하고! ★★★
		System.out.println("가로: " + this.w + ", 세로: " + this.h); // 그다음에 가로, 세로 출력.
	}
}

// --- PolyTest 클래스: **도형 관리 프로그램의 존나게 중요한 메인!** ---
// ★★★★★ 이 코드는 '다형성(Polymorphism)'이 왜 존나게 편리한지 보여준다! ★★★★★
public class PolyTest {

	public static void main(String[] args) {
		// 'MyPoint' 타입 배열을 10칸 만든다.
		// ★★★ 존나 중요! 이 배열엔 'MyPoint' 뿐 아니라, 자식인 'Circle', 'Rect'도 다 때려 박을 수 있다! (이게 다형성!) ★★★
		MyPoint[] mp = new MyPoint[10];

		int count = 0; // 현재까지 입력된 도형 개수 카운트.

		// 무한 루프: 4번 선택해서 프로그램 끌 때까지 계속 돈다.
		while (true) {
			// 배열이 꽉 찼으면 사용자한테 알려준다.
			if (count >= mp.length) {
				System.out.println("\n[알림] 더 이상 도형을 입력할 수 없습니다. (최대 10개)");
				System.out.println("       '3. 현재까지 입력된 도형 보기'를 이용하거나 '4. 프로그램 종료'를 선택해주세요.");
			}

			System.out.println("\n--- 도형 관리 메뉴 ---");
			System.out.print("1.원 입력 2.사각형 입력 3.현재까지 입력된 도형 보기 4.프로그램 종료 >> ");

			// MyPoint 클래스의 static Scanner를 이용해서 사용자 입력받는다. (클래스 이름으로 바로 접근!)
			int n = MyPoint.sc.nextInt();

			if (n == 1) { // 1번: 원 입력
				if (count < mp.length) { // 배열 공간 남았는지 확인
					mp[count] = new Circle(); // 새로운 'Circle' 객체 만들어서 배열에 저장. (업캐스팅 발생!)
					count++; // 도형 개수 +1
				} else {
					System.out.println("좌표 배열이 가득 찼습니다. 더 이상 입력할 수 없습니다.");
				}
			} else if (n == 2) { // 2번: 사각형 입력
				if (count < mp.length) { // 배열 공간 남았는지 확인
					mp[count] = new Rect(); // 새로운 'Rect' 객체 만들어서 배열에 저장. (업캐스팅 발생!)
					count++; // 도형 개수 +1
				} else {
					System.out.println("좌표 배열이 가득 찼습니다. 더 이상 입력할 수 없습니다.");
				}
			} else if (n == 3) { // 3번: 입력된 도형 보기
				System.out.println("\n--- 현재까지 입력된 도형 정보 ---");
				if (count == 0) { // 도형 하나도 없으면
					System.out.println("아직 입력된 도형이 없습니다.");
				} else {
					// 입력된 도형 개수만큼 반복해서 정보 출력.
					for (int j = 0; j < count; j++) {
						// ★★★ 존나 중요! 'mp[j].disp()' 호출하면! ★★★
						// 'mp[j]'가 실제 가리키는 객체(Circle이면 Circle, Rect면 Rect)의
						// **오버라이딩된 'disp()' 메소드가 자동으로 실행된다!** (이게 다형성의 마법이다!)
						mp[j].disp();
						System.out.println("-------------------------"); // 각 도형 구분선
					}
				}
				System.out.println("--- 조회 완료 ---");
			} else if (n == 4) { // 4번: 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				MyPoint.sc.close(); // 프로그램 끝내기 전에 Scanner 자원 깔끔하게 해제!
				System.exit(0); // 프로그램 완전히 종료!
			} else { // 이상한 숫자 입력하면
				System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요.");
			}
		} // while 루프 끝
	} // main 메소드 끝
} // PolyTest 클래스 끝
