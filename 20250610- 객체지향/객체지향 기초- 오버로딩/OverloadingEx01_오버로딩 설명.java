package com.overex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  OverloadingEx01 클래스: **메서드 오버로딩(Overloading)의 모든 것을 존나게 파헤치는 예제!**
 
  핵심:
  - **오버로딩이란?** 같은 이름의 메서드를 여러 개 만드는 건데, 매개변수만 다르면 된다!
  - **왜 씀?** 하나의 메서드 이름으로 존나게 다양한 데이터 타입이나 개수를 처리할 때 쓴다!
  - **조건:**
  1. 메서드 이름이 무조건 같아야 함.
  2. 매개변수의 **개수**가 다르거나, 매개변수의 **자료형(타입) 순서나 종류**가 달라야 함.
  (※ 주의: 반환 타입만 다르면 오버로딩 아님! 컴파일 오류난다, 씨발!)
 */

// --- FunctionEx 클래스: 오버로딩된 메서드들을 모아 놓은 곳 ---
class FunctionEx {

	// 1. int형 두 개 더하기: add(int, int)
	int add(int a, int b) {
		System.out.println("int, int"); // 어떤 add가 호출됐는지 보여주기 위함.
		return a + b;
	}

	// 2. int 하나, long 하나 더하기: add(int, long) - ★오버로딩! 매개변수 타입 다름!★
	long add(int a, long b) {
		System.out.println("int, long");
		return a + b; // 더 큰 자료형(long)에 맞춰 결과를 반환한다.
	}

	// 3. long 하나, int 하나 더하기: add(long, int) - ★오버로딩! 매개변수 순서 다름!★
	long add(long a, int b) {
		System.out.println("long, int");
		return a + b;
	}

	// 4. long형 두 개 더하기: add(long, long) - ★오버로딩! 매개변수 타입 다름!★
	long add(long a, long b) {
		System.out.println("long, long");
		return a + b;
	}

	// 5. int형 배열의 모든 요소 더하기: add(int[]) - ★오버로딩! 매개변수 개수/타입이 완전히 다름!★
	int add(int[] a) {
		int res = 0;
		for (int i = 0; i < a.length; i++) { // 배열을 뺑뺑이 돌면서 다 더한다.
			res += a[i];
		}
		return res;
	}
}

// --- OverloadingEx01 클래스: 프로그램 실행 시작점 (메인 클래스) ---
public class OverloadingEx01 {

	// ★★★ 프로그램 시작점 (메인 메소드) ★★★
	public static void main(String[] args) {

		FunctionEx fe = new FunctionEx(); // 'FunctionEx' 객체를 만든다. 이제 이 새끼로 오버로딩된 메소드들 다 쓸 수 있다!

		// --- 다양한 'add' 메소드 호출 테스트 ---
		System.out.println(fe.add(3, 3));      // int, int 호출: 둘 다 int형이라 가장 정확한 add(int, int)가 선택된다. -> "int, int" 출력 후 6 반환
		System.out.println(fe.add(3L, 3));     // long, int 호출: 첫째가 long이라 add(long, int)가 선택된다. -> "long, int" 출력 후 6 반환
		System.out.println(fe.add(3, 3L));     // int, long 호출: 둘째가 long이라 add(int, long)이 선택된다. -> "int, long" 출력 후 6 반환
		System.out.println(fe.add(3L, 3L));    // long, long 호출: 둘 다 long이라 add(long, long)이 선택된다. -> "long, long" 출력 후 6 반환

		int[] a = {100, 200, 300}; // int형 배열을 하나 만든다.
		System.out.println(fe.add(a)); // int 배열 호출: 매개변수가 int 배열이라 add(int[])가 선택된다. -> 600 반환
	}
}
