package com.overex; // 이 코드는 'com.overex' 패키지에 들어있음.

class OverloadingEx { // 'OverloadingEx'라는 클래스. 여기에 오버로딩된 메서드들이 있음.

	// 1. 매개변수 없는 print 메서드
	public void print() {
		System.out.println("인자 없는 메소드 ....");
	}

	/*
	public int print() {
		return; // ★개중요★ 이건 오버로딩 아님! 컴파일 에러남.
	}
	*/
	// ★핵심: 자바는 메서드 구분할 때 '반환 타입'은 안 봄!
	// 위에 `public void print()`랑 이름도 같고 매개변수도 없어서 '똑같은 메서드'로 간주함.
	// 그래서 동시에 못 쓰고 에러남. 이게 오버로딩의 존나 중요한 조건 중 하나임.

	// 2. short형 받는 print 메서드
	public void print(short val) { // print(short)
		System.out.println("short ....");
	}

	// 3. int형 받는 print 메서드 (오버로딩!)
	public void print(int val) { // print(int)
		System.out.println("int ....");
	}

	// 4. long형 받는 print 메서드 (오버로딩!)
	public void print(long val) { // print(long)
		System.out.println("long ....");
	}

	// --- 아래 write 메서드들은 print랑 이름이 달라서 오버로딩 관계 아님.
	//     write끼리만 오버로딩 관계임. ---

	// 5. int형 받는 write 메서드
	public void write(int val) { // write(int)
		System.out.println("int");
	}

	// 6. long형 받는 write 메서드 (오버로딩!)
	public void write(long val) { // write(long)
		System.out.println("long");
	}

	// 7. Long 객체(참조형) 받는 write 메서드 (오버로딩!)
	public void write(Long val) { // write(Long)
		System.out.println("Long");
	}
	// ★중요★ 'long'은 기본 자료형(8바이트 숫자), 'Long'은 'long'을 감싼 '래퍼 클래스' (객체).
	// 서로 다른 타입이라 오버로딩 가능함.
}

public class OverloadingEx02 { // 프로그램 실행용 메인 클래스.

	// ★★★ 프로그램 시작점 (메인 메서드) ★★★
	public static void main(String[] args) {

		OverloadingEx oe = new OverloadingEx(); // 'OverloadingEx' 객체 생성.

		short s = 10;   // short 기본형
		Short ss = 10;  // Short 래퍼 클래스 (자동 박싱)
		int i = 10;     // int 기본형
		long l = 10;    // long 기본형

		System.out.println("--- print 메서드 호출 결과 ---");
		oe.print();     // print() 호출 -> "인자 없는 메소드 ...."

		oe.print(s);    // print(short) 호출 (정확히 일치) -> "short ...."
		oe.print(i);    // print(int) 호출 (정확히 일치) -> "int ...."
		oe.print(l);    // print(long) 호출 (정확히 일치) -> "long ...."

		System.out.println("--- write 메서드 호출 결과 ---");
		oe.write(s);    // write(short) 없음! -> short는 int로 자동 형변환(Widening)돼서 write(int) 호출 -> "int"
		oe.write(ss);   // write(Short) 정확히 일치하는 메서드 있음 -> write(Long) 호출 (Short -> Long 자동 변환됨. 래퍼 클래스간 상속 관계 있음) -> "Long"
		oe.write(i);    // write(int) 호출 (정확히 일치) -> "int"
		oe.write(l);    // write(long) 호출 (정확히 일치) -> "long"
	}
}
