package com.objectex; // 이 코드는 'com.objectex' 패키지에 있음.

class Data { // 'Data'라는 클래스.
	int x; // int형 멤버 변수 'x'. Data 객체 만들 때마다 자신만의 'x'를 가짐.
}

public class ReferenceParamEx01 { // 'ReferenceParamEx01'라는 클래스.

	// 1. `change` 메서드 정의
	// `static`이라 객체 생성 없이 바로 호출 가능.
	// `void`라 반환값 없음.
	// 'Data d' ← 여기가 바로 ★참조형 매개변수★ 부분임.
	// 뜻: "Data 클래스 객체 하나를 받을 건데, 객체 '주소'를 복사해서 받을 거야!"
    
	static void change(Data d) { // 매개변수 `d`는 `main` 메서드의 `d`와 ★같은 객체를 가리킴★.
		
		d.x = 1000; // 매개변수 `d`가 가리키는 객체의 `x` 값을 1000으로 변경.
					// ★개중요★ `main` 메서드의 `d`랑 `change` 메서드의 `d`가 ★같은 메모리 주소를 보고 있으니까,
					// 여기서 `x` 값을 바꾸면 `main` 메서드에 있는 그 객체 자체의 `x` 값이 ★직접 바뀜★.
		
		System.out.println("change() : x =>" + d.x); // change 메서드 안에서 변경된 `d.x` 값 출력.
													 // 출력: "change() : x => 1000"
	}
	
	public static void main(String[] args) { // 프로그램 시작점인 메인 메서드.
		
		// 1. Data 클래스 객체 생성
		// `new Data()` 하면 메모리에 'Data' 객체가 만들어짐.
		// 이 객체의 메모리 '주소'가 `d`라는 변수에 저장됨.
		Data d = new Data();
		
		// 2. 객체 `d`의 `x` 값 초기화
		d.x = 10; // `d`가 가리키는 객체의 멤버 변수 `x`에 10 저장.
		
		System.out.println("main(): x =>" + d.x); // main 메서드에서 현재 `d.x` 값 출력.
												 // 출력: "main(): x => 10"

		// 3. `change()` 메서드 호출
		// `change(d);` → `d` 변수 (Data 객체의 메모리 주소)를 `change` 메서드로 넘겨줌.
		// 여기서 중요한 건: `main`의 `d`에 담긴 '주소 값'이 `change` 메서드의 매개변수 `d`에 '복사'됨.
		// 즉, 두 `d`는 '다른 변수'지만, ★'같은 객체'를 가리키게 됨★.
		
		change(d); // `change` 메서드에서 `x`의 값을 1000으로 변경할 거임. (주소 복사라 원본 객체 값이 변경됨!)
		
		// 4. `change()` 메서드 호출 후 `main` 메서드에서 `x` 값 확인
		System.out.println("main(): x =>" + d.x); // `change` 메서드 호출 후 `main`에서 다시 `d.x` 값 출력.
												 // `change`에서 `d.x` 값이 1000으로 바뀌었으니,
												 // 여기서도 `d.x` 값은 ★1000이 되어 있음★.
												 // 출력: "main(): x => 1000"
		
	}
}
