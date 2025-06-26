package com.innerex; // 이 코드가 속한 패키지(폴더) 이름이다.

/*
  Innerex01 클래스: **자바의 '내부 클래스(Inner Class)'를 존나게 파헤치는 예제다!**
 
  핵심:
  - **내부 클래스란?** 클래스 안에 또 다른 클래스를 선언하는 거다! (연관된 클래스끼리 묶어서 관리하기 존나 편하다!)
  - **세 가지 주요 내부 클래스:**
  1. **인스턴스 내부 클래스 (Instance Inner Class):** 외부 클래스의 인스턴스(객체)에 종속된다. `static` 멤버를 가질 수 없다! (단, `final static` 상수는 예외다! 컴파일 시 값이 확정되니까!)
  2. **스태틱 내부 클래스 (Static Inner Class):** 외부 클래스의 객체 없이도 독립적으로 존재할 수 있다. 지 혼자 `static` 멤버를 가질 수 있다! (존나 중요!)
  3. **지역 내부 클래스 (Local Inner Class):** 메소드 안에서만 존재하고, 해당 메소드 안에서만 쓸 수 있는 존나 임시적인 클래스다. 얘도 `static` 멤버를 가질 수 없다! (이것도 `final static` 상수는 예외다!)
  - **접근 방식:**
  - 인스턴스 내부 클래스 멤버: 외부 클래스 객체를 통해 접근해야 한다.
  - 스태틱 내부 클래스 멤버: 외부 클래스 이름으로 바로 접근 가능하다.
 */

public class Innerex01 {
	
	// --- 스태틱 내부 클래스: 'InstanceInner' --- (이름은 'InstanceInner'지만 'static'이라 스태틱 내부 클래스다!)
	// 이 새끼는 'Innerex01' 객체 없어도 지 혼자 독립적으로 존재할 수 있다!
	// ★★★ 중요! 니 코드에 `static`이 붙어있어서 이건 스태틱 내부 클래스다! ★★★

	static class InstanceInner {
		int iv = 100; // 인스턴스 변수 (객체마다 다름)
		
		// ★★★ 존나 중요! 스태틱 내부 클래스에서는 `static` 변수 선언할 수 있다! ★★★
		static int cv = 100; 
		
		final static int CONST = 100; // `final static` 상수는 어디서든 선언 가능하다! (컴파일 시 값이 정해지니까!)
	}
	
	// --- 스태틱 내부 클래스: 'StaticInner' ---
	// 이 새끼는 'Innerex01' 객체 없어도 지 혼자 독립적으로 존재할 수 있다!
	static class StaticInner {
		int iv = 200; // 인스턴스 변수
		static int cv = 200; // ★★★ 존나 중요! 스태틱 내부 클래스에서는 `static` 변수를 선언할 수 있다! ★★★
	}
	
	// --- 메소드 'myMethod()' 안의 지역 내부 클래스: 'LocalInner' ---
	// 이 새끼는 `myMethod()`가 호출될 때만 잠깐 만들어지고, 이 메소드 안에서만 쓸 수 있다!
	void myMethod() {
		class LocalInner {
			int iv = 300; // 인스턴스 변수
			// static int cv = 300; // ★★★ 존나 중요! 지역 내부 클래스에서는 `static` 변수 선언할 수 없다! ★★★
			                           // 니 코드 주석처럼 '상수이므로 허용 가능'한 건 `final static`만 해당한다!
			final static int CONST = 300; // 상수이므로 허용 가능 (컴파일 시 값이 정해지니까!)
		}
		// 'LocalInner' 클래스의 객체는 이 메소드 안에서만 생성해서 쓸 수 있다.
		// LocalInner li = new LocalInner();
		// System.out.println(li.iv);
	}
	
	// --- 메인 메소드: 프로그램의 시작점! ---
	public static void main(String[] args) {
		// ★★★ 스태틱 내부 클래스 멤버에 접근! ★★★
		// 'InstanceInner.CONST': `static` 상수는 클래스 이름으로 바로 접근 가능하다!
		// 'InstanceInner'는 `static class`라서 `static` 멤버(`CONST`, `cv`)에 직접 접근 가능한 거다!
		System.out.println("InstanceInner.CONST: " + InstanceInner.CONST); // 출력 구분을 위해 문자열 추가
		
		// 'StaticInner.cv': `static` 내부 클래스의 `static` 변수도 클래스 이름으로 바로 접근 가능하다!
		System.out.println("StaticInner.cv: " + StaticInner.cv); // 출력 구분을 위해 문자열 추가

		// ★★★ 'InstanceInner'가 'static class'이므로, 그 안의 인스턴스 변수 'iv'에 접근하려면... ★★★
		// 먼저 'InstanceInner'의 객체를 생성해야 한다!
		// (만약 'InstanceInner'가 `static`이 없는 진짜 '인스턴스 내부 클래스'였다면,
		// `Innerex01 outer = new Innerex01();` 한 다음에 `outer.new InstanceInner()` 이렇게 만들었어야 한다)
		Innerex01.InstanceInner instanceInnerObj = new Innerex01.InstanceInner();
		System.out.println("InstanceInner의 iv (객체 생성 후 접근): " + instanceInnerObj.iv);
	}

}
