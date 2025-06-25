package com.overex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  OverloadingEx 클래스: **메소드 오버로딩(Overloading)의 규칙을 존나게 보여주는 예제다!**
 
  핵심:
  - **메소드 오버로딩이란?**
  - 같은 클래스 안에서 **메소드 이름은 같지만, 매개변수의 '개수'나 '타입'이 다르면** 다른 메소드로 인식하는 기능이다!
  - **반환 타입은 오버로딩 조건에 영향을 안 준다!** (이름, 매개변수 같으면 반환 타입 달라도 오버로딩 아님! 에러남!)
  - **컴파일러의 존나 똑똑한 판단:**
  - 메소드를 호출할 때, 컴파일러가 넘겨주는 매개변수(인자)의 타입과 개수를 보고 **가장 적절한(정확히 일치하는) 오버로딩 메소드를 알아서 찾아 실행한다!**
  - 만약 정확히 일치하는 게 없으면, **자동 형 변환(Widening, 예를 들어 short -> int -> long 순)을 고려해서 찾아낸다!**
  - **`print()` 메소드들:** 매개변수 없는 버전, `short` 받는 버전, `int` 받는 버전, `long` 받는 버전으로 오버로딩되어 있다.
  - **`write()` 메소드들:** `int` 받는 버전, `long` 받는 버전, 그리고 **`Long` 객체(래퍼 클래스) 받는 버전**으로 오버로딩되어 있다.
  - `long`(기본형)과 `Long`(객체)은 서로 다른 타입이라 오버로딩이 가능하다! (존나 중요!)
 */

// --- OverloadingEx 클래스: 오버로딩된 메소드들을 모아 놓은 곳 ---
class OverloadingEx {

	// 1. 매개변수 없는 print 메소드.
	public void print() {
		System.out.println("인자 없는 메소드 ...."); // 그냥 지가 불렸다고 출력.
	}

	/*
	// public int print() { return 1; }
	// ★★★ 중요! 이 메소드는 위에 `public void print()`와 이름, 매개변수가 완전히 같아서 오버로딩이 안 된다! ★★★
	// 반환 타입만 다르면 컴파일 에러가 발생한다! 주석 풀면 난리 난다, 씨발!
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
		System.out.println("write(int) 호출"); // 어떤 메소드가 호출됐는지 명확히 알 수 있게 출력 내용 변경!
	}

	// 6. long형 받는 write 메소드. (오버로딩!)
	public void write(long val) {
		System.out.println("write(long) 호출"); // 출력 내용 변경!
	}

	// 7. Long 객체(래퍼 클래스) 받는 write 메소드. (오버로딩!)
	// ★★★ 중요! 'long'(기본형)과 'Long'(객체)은 서로 다른 타입이다! 그래서 오버로딩 가능함. ★★★
	public void write(Long val) { // 'Long'은 'long' 기본형을 감싸는 객체(래퍼 클래스)다.
		System.out.println("write(Long) 호출"); // 출력 내용 변경!
	}
}

// --- OverloadingEx02 클래스: 프로그램 실행 시작점 ---
public class OverloadingEx02 {

	// ★★★ 프로그램 시작점 (메인 메소드) ★★★
	public static void main(String[] args) {

		OverloadingEx oe = new OverloadingEx(); // 'OverloadingEx' 객체 생성! 얘로 메소드들 불러볼 거다.

		short s = 10;  // short 기본형 변수
		Short ss = 10; // Short 래퍼 클래스 객체. (자동 박싱: 10(int)이 Short 객체로 자동 변환됨!)
		int i = 10;    // int 기본형 변수
		long l = 10;   // long 기본형 변수

		System.out.println("--- print 메소드 호출 결과 ---");
		oe.print();      // print(): 매개변수 없는 메소드 호출. (정확히 일치!)
		oe.print(s);     // print(short): short 타입과 정확히 일치하는 메소드 호출.
		oe.print(i);     // print(int): int 타입과 정확히 일치하는 메소드 호출.
		oe.print(l);     // print(long): long 타입과 정확히 일치하는 메소드 호출.

		System.out.println("\n--- write 메소드 호출 결과 ---");
		// ★★★ 이 부분 존나 복잡하고 중요함! 오버로딩 우선순위랑 자동 형변환 잘 봐라! ★★★
		
		// 1. oe.write(s); (short 타입 's'를 넘김)
		// - write(short) 메소드는 없다.
		// - short는 int로 자동 형변환(Widening)될 수 있으므로, write(int)가 호출된다.
		oe.write(s);    
		
		// 2. oe.write(ss); (Short 래퍼 클래스 객체 'ss'를 넘김)
		// - write(Short) 메소드는 없다.
		// - Short 객체는 Long 객체로 자동 변환(Upcasting 또는 Auto-boxing 후 widening)될 수 있다.
		// - 따라서 write(Long)이 호출된다.
		oe.write(ss);   
		
		// 3. oe.write(i); (int 타입 'i'를 넘김)
		// - write(int) 메소드와 정확히 일치한다.
		oe.write(i);    
		
		// 4. oe.write(l); (long 타입 'l'를 넘김)
		// - write(long) 메소드와 정확히 일치한다.
		oe.write(l);    
	}
}
