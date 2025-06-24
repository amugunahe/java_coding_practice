package com.overex; // 이 코드는 'com.overex' 패키지에 들어있음.

class Diagram { // 'Diagram'이라는 클래스. 도형 넓이 계산하고 출력하는 메서드들이 있음.

	// 1. 사각형 넓이 계산하는 area 메서드
	public int area(int w, int h) { // area(int, int) → 매개변수: 너비(w), 높이(h)
		return w * h; // 너비 * 높이 반환 (사각형 넓이)
	}

	// 2. 원 넓이 계산하는 area 메서드 (★오버로딩!★)
	public double area(double r) { // area(double) → 매개변수: 반지름(r)
		return r * r * 3.141592; // 반지름 * 반지름 * 원주율 반환 (원 넓이)
	}
	// ★핵심: 위 두 `area` 메서드는 이름은 같지만, 매개변수 개수(2개 vs 1개)랑 자료형(int, int vs double)이 달라서
	// 자바가 서로 다른 메서드로 인식하고 오버로딩 성공함.

	// 3. int형 결과 출력하는 write 메서드
	public void write(int result) { // write(int)
		System.out.println("사각형의 넓이: " + result);
	}

	// 4. double형 결과 출력하는 write 메서드 (★오버로딩!★)
	public void write(double result) { // write(double)
		System.out.println("원 넓이: " + result);
	}
	// ★핵심: 위 두 `write` 메서드도 이름은 같지만, 매개변수 자료형(int vs double)이 달라서 오버로딩 가능함.
}

public class OverloadingEx03 { // 프로그램 실행용 메인 클래스.

	// ★★★ 프로그램 시작점 (메인 메서드) ★★★
	public static void main(String[] args) {

		Diagram d = new Diagram(); // 'Diagram' 객체 생성. 얘로 도형 넓이 계산할 거임.

		// ★사각형 넓이 계산 및 출력★
		int rest = d.area(10, 5); // area(10, 5) 호출 → `public int area(int w, int h)` 실행. rest에 50 저장.
		d.write(rest);            // write(50) 호출 → `public void write(int result)` 실행. "사각형의 넓이: 50" 출력.

		// ★원 넓이 계산 및 출력★
		double ci = d.area(10.5); // area(10.5) 호출 → `public double area(double r)` 실행. ci에 원 넓이 저장.
		d.write(ci);              // write(ci) 호출 → `public void write(double result)` 실행. "원 넓이: [값]" 출력.
	}
}
