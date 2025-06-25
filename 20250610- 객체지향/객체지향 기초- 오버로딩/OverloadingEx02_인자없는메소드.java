package com.overex; // 이 코드가 속한 폴더(패키지) 이름이다.

// --- OverloadingEx 클래스: 오버로딩된 메소드들을 모아 놓은 곳 ---
class OverloadingEx {

	// 1. 매개변수 없는 print 메소드.
	public void print() {
		System.out.println("인자 없는 메소드 ...."); // 그냥 지가 불렸다고 출력.
	}

	/*
	// public int print() { return 1; }
	// ★★★ 중요! 이거 주석 풀면 에러남! 이름, 매개변수 같으면 반환 타입 달라도 오버로딩 아님! ★★★
	*/

	// 2. short형 받는 print 메소드.
	public void print(short val) {
		System.out.println("short ....");
	}

	// 3. int형 받는 print 메소드. (오버로딩!)
	public void print(int val) {
		System.out.println("int ....");
	}

	// 4. long형 받는 print 메소드. (오버로딩!)
	public void print(long val) {
		System.out.println("long ....");
	}

	// --- 아래 write 메소드들은 print랑 이름이 달라서 오버로딩 관계 아님. ---
	// --- write 메소드들끼리만 오버로딩 관계임. ---

	// 5. int형 받는 write 메소드.
	public void write(int val) {
		System.out.println("int");
	}

	// 6. long형 받는 write 메소드. (오버로딩!)
	public void write(long val) {
		System.out.println("long");
	}

	// 7. Long 객체(참조형) 받는 write 메소드. (오버로딩!)
	// ★★★ 중요! 'long'(기본형)과 'Long'(객체)은 서로 다른 타입이다! 그래서 오버로딩 가능함. ★★★
	public void write(Long val) {
		System.out.println("Long");
	}
}

// --- OverloadingEx02 클래스: 프로그램 실행 시작점 ---
public class OverloadingEx02 {

	// ★★★ 프로그램 시작점 (메인 메소드) ★★★
	public static void main(String[] args) {

		OverloadingEx oe = new OverloadingEx(); // 'OverloadingEx' 객체 생성!

		short s = 10;  // short 기본형
		Short ss = 10; // Short 래퍼 클래스 (자동 박싱)
		int i = 10;    // int 기본형
		long l = 10;   // long 기본형

		System.out.println("--- print 메소드 호출 결과 ---");
		oe.print();     // print(): 매개변수 없는 메소드 호출.
		oe.print(s);    // print(short): short 타입과 정확히 일치.
		oe.print(i);    // print(int): int 타입과 정확히 일치.
		oe.print(l);    // print(long): long 타입과 정확히 일치.

		System.out.println("--- write 메소드 호출 결과 ---");
		// ★★★ 이 부분 존나 복잡하고 중요함! 오버로딩 우선순위랑 자동 형변환 잘 봐라! ★★★
		oe.write(s);    // write(short) 없음! -> short는 int로 자동 형변환(Widening)돼서 write(int) 호출!
		oe.write(ss);   // write(Short) 없음! -> Short는 Long으로 자동 변환돼서 write(Long) 호출!
		oe.write(i);    // write(int): int 타입과 정확히 일치.
		oe.write(l);    // write(long): long 타입과 정확히 일치.
	}
}
