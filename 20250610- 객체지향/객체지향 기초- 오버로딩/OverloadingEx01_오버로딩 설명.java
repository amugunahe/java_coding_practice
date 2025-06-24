package com.overex; // 이 코드는 'com.overex' 패키지에 들어있음.

/*
  ★★★ 오버로딩 (Overloading)이란? ★★★
  - 한 클래스 안에 ★같은 이름의 메서드를 여러 개★ 만드는 거.
  - 하나의 메서드 이름으로 여러 가지 기능을 하게 하는 거임.
 
  ★★★ 오버로딩 조건 ★★★
  1. 메서드 이름이 같아야 함.
  2. 매개변수의 ★개수★ 또는 ★자료형(타입)★이 달라야 함.
 
  ※주의※ 반환 타입만 다르면 오버로딩 안 됨! (예: `int add(int a, int b)`랑 `long add(int x, int y)`는 안 됨)
 */

class FunctionEx { // 'FunctionEx'라는 클래스. 여기 오버로딩된 메서드들이 있음.

	// 1. int형 두 개 더하기
	int add(int a, int b) { // add(int, int)
		System.out.println("int, int");
		return a + b;
	}

	// 2. int형 하나, long형 하나 더하기 (오버로딩!)
	long add(int a, long b) { // add(int, long)
		System.out.println("int, long");
		return a + b; // 더 큰 자료형(long)에 맞춰 반환.
	}

	// 3. long형 하나, int형 하나 더하기 (오버로딩! → 매개변수 순서가 다름)
	long add(long a, int b) { // add(long, int)
		System.out.println("long, int");
		return a + b;
	}

	// 4. long형 두 개 더하기 (오버로딩!)
	long add(long a, long b) { // add(long, long)
		System.out.println("long, long");
		return a + b;
	}

	// 5. int형 배열 안의 모든 요소 더하기 (오버로딩! → 매개변수 개수/타입이 완전히 다름)
	int add(int[] a) { // add(int[])
		int res = 0;
		for (int i = 0; i <a.length; i++) {
			res += a[i];
		}
		return res;
	}
}

public class OverloadingEx01 { // 프로그램 실행용 메인 클래스.

	// ★★★ 프로그램 시작점 (메인 메서드) ★★★
	public static void main(String[] args) {

		FunctionEx fe = new FunctionEx(); // 'FunctionEx' 객체 생성. 얘로 메서드들 쓸 거임.

		System.out.println(fe.add(3, 3));     // add(int, int) 호출됨. (매개변수 둘 다 int) -> "int, int" 출력 후 6
		System.out.println(fe.add(3L, 3));    // add(long, int) 호출됨. (첫째 long, 둘째 int) -> "long, int" 출력 후 6
		System.out.println(fe.add(3, 3L));    // add(int, long) 호출됨. (첫째 int, 둘째 long) -> "int, long" 출력 후 6
		System.out.println(fe.add(3L, 3L));   // add(long, long) 호출됨. (둘 다 long) -> "long, long" 출력 후 6

		int[] a = {100, 200, 300}; // int형 배열 만듦.
		System.out.println(fe.add(a)); // add(int[]) 호출됨. (매개변수 int 배열) -> 600
	}
}
