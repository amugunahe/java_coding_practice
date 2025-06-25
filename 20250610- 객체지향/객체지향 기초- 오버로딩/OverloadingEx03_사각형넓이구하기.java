package com.overex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  OverloadingEx03 클래스: **메소드 오버로딩(Overloading)으로 도형 넓이 계산하고 출력하는 예제!**
 
  핵심:
  - **'area()' 메소드:** 사각형 넓이랑 원 넓이를 **이름은 같지만 매개변수 다르게 해서 오버로딩한다.**
  - **'write()' 메소드:** int 값 출력, double 값 출력 **이름은 같지만 매개변수 다르게 해서 오버로딩한다.**
  - **컴파일러가 호출 시 매개변수 보고 알아서 맞는 메소드를 골라 실행한다!** (존나 똑똑함!)
 */

// --- Diagram 클래스: 도형 넓이 계산하고 출력하는 메소드들을 모아 놓은 곳 ---
class Diagram {

	// 1. 사각형 넓이 계산하는 area 메소드: area(int, int)
	public int area(int w, int h) { // 매개변수: 너비(w), 높이(h)
		return w * h; // 사각형 넓이 반환.
	}

	// 2. 원 넓이 계산하는 area 메소드: area(double) - ★오버로딩!★
	// 매개변수 개수/타입이 달라서 'area(int, int)'랑 다른 메소드로 인식된다.
	public double area(double r) { // 매개변수: 반지름(r)
		return r * r * 3.141592; // 원 넓이 반환.
	}

	// 3. int형 결과 출력하는 write 메소드: write(int)
	public void write(int result) {
		System.out.println("사각형의 넓이: " + result);
	}

	// 4. double형 결과 출력하는 write 메소드: write(double) - ★오버로딩!★
	// 매개변수 자료형이 달라서 'write(int)'랑 다른 메소드로 인식된다.
	public void write(double result) {
		System.out.println("원 넓이: " + result);
	}
}

// --- OverloadingEx03 클래스: 프로그램 실행 시작점 (메인 클래스) ---
public class OverloadingEx03 {

	// ★★★ 프로그램 시작점 (메인 메소드) ★★★
	public static void main(String[] args) {

		Diagram d = new Diagram(); // 'Diagram' 객체 생성! 얘로 도형 넓이 계산하고 출력할 거다.

		// ★★★ 사각형 넓이 계산 및 출력 ★★★
		// d.area(10, 5) 호출 시, int형 2개를 받아서 'public int area(int w, int h)' 메소드가 선택된다.
		int rest = d.area(10, 5); 
		// d.write(rest) 호출 시, int형 1개를 받아서 'public void write(int result)' 메소드가 선택된다.
		d.write(rest); 

		// ★★★ 원 넓이 계산 및 출력 ★★★
		// d.area(10.5) 호출 시, double형 1개를 받아서 'public double area(double r)' 메소드가 선택된다.
		double ci = d.area(10.5); 
		// d.write(ci) 호출 시, double형 1개를 받아서 'public void write(double result)' 메소드가 선택된다.
		d.write(ci); 
	}
}
