package com.innerex; // 이 코드가 속한 패키지(폴더) 이름이다.

/*
  Innerex02 클래스: **자바 '내부 클래스(Inner Class)'들의 존나게 복잡한 '접근 규칙'을 파헤치는 예제다!**
 
  핵심:
  - **내부 클래스 종류:** '인스턴스 내부 클래스'와 '스태틱 내부 클래스', 그리고 '지역 내부 클래스'를 다룬다.
  - **접근 규칙의 존나게 중요한 원칙:**
  1. **인스턴스 멤버:** 인스턴스(객체)가 있어야 접근 가능하다.
  2. **스태틱 멤버:** 클래스 이름으로 바로 접근 가능하고, 객체 없이도 존재한다.
  - **내부 클래스별 특징:**
  - **인스턴스 내부 클래스 (`class InstanceInner`):** 외부 클래스의 '객체'에 붙어 산다. 그래서 외부 클래스의 모든 멤버(인스턴스/스태틱)에 존나게 자유롭게 접근 가능하다.
                                                  **단, 지 자신은 `static` 멤버를 못 가진다! (final static 상수는 제외!)**
  - **스태틱 내부 클래스 (`static class StaticInner`):** 외부 클래스의 '객체' 없이도 독립적으로 존재할 수 있다. 그래서 외부 클래스의 '스태틱 멤버'에만 직접 접근 가능하다. 
                                                     **지 자신은 `static` 멤버를 가질 수 있다! (존나 중요!)**
  - **지역 내부 클래스 (`class LocalInner`):** 메소드 안에서만 만들어지고 쓰인다. 메소드 안의 'final'이 붙은 지역 변수만 가져다 쓸 수 있고, 'static' 멤버는 못 가진다! (final static 상수는 제외!)
 */

public class Innerex02 {

	// --- 1. 인스턴스 내부 클래스: 'InstanceInner' ---
	// 이 새끼는 'Innerex02' 객체가 만들어져야만 존재할 수 있다.
	class InstanceInner {
		int iv = 100;
	} 
	
	// --- 2. 스태틱 내부 클래스: 'StaticInner' ---
	// 이 새끼는 'Innerex02' 객체 없이도 지 혼자 독립적으로 존재할 수 있다.
	static class StaticInner {
		int iv = 200; // 인스턴스 변수
		static int cv = 200; // ★★★ 존나 중요! 스태틱 내부 클래스에서는 `static` 변수를 선언할 수 있다! ★★★
	}
	
	// --- Innerex02 클래스의 멤버 변수 선언 ---

	// 인스턴스 멤버 변수 'iv'로 인스턴스 내부 클래스 'InstanceInner' 객체를 생성한다.
	// 외부 클래스의 인스턴스 멤버는 내부 클래스 인스턴스 멤버에 직접 접근 가능하므로 문제없다.
	InstanceInner iv = new InstanceInner(); // (Innerex02 객체 생성 시 InstanceInner 객체도 같이 만들어진다!)
	
	// 스태틱 멤버 변수 'cv'로 스태틱 내부 클래스 'StaticInner' 객체를 생성한다.
	// 외부 클래스의 static 멤버는 내부 클래스 static 멤버에 직접 접근 가능하므로 문제없다.
	static StaticInner cv = new StaticInner(); // (얘는 Innerex02 클래스가 메모리에 로드될 때 바로 만들어진다!)
	
	// --- 스태틱 메소드: 'staticMethod()' ---
	// 이 메소드는 'Innerex02' 객체 없이도 호출할 수 있다.
	// 그래서 이 안에서는 'Innerex02'의 '인스턴스 멤버'에 직접 접근할 수 없다!
	static void staticMethod() {
		// ★★★ 존나 중요! static 메소드는 인스턴스 멤버에 직접 접근이 불가능하다! ★★★
		// 'InstanceInner'는 인스턴스 내부 클래스이므로,  
		// 'Innerex02' 객체(인스턴스)가 있어야만 만들 수 있다! 그래서 아래 코드는 에러난다.
		// StaticInner obj1 = new InstanceInner(); // (오류 주석: StaticInner가 아니라 InstanceInner 객체 생성 시 문제 발생)

		// 스태틱 내부 클래스 'StaticInner'는 외부 클래스 객체 없이도 만들 수 있으니 문제없다.
		StaticInner obj2 = new StaticInner();
		
		// ★★★ 인스턴스 내부 클래스에 접근하려면 이렇게 '외부 클래스 객체'를 먼저 만들어야 한다! ★★★
		Innerex02 outer = new Innerex02(); // 외부 클래스 'Innerex02'의 객체를 먼저 생성한다.
		// 'outer.new InstanceInner()': 이 'outer' 객체를 통해 'InstanceInner' 객체를 생성한다.
		InstanceInner obj1 = outer.new InstanceInner(); 
		// 니 코드 주석: "인스턴스 클래스는 외부 클래스 먼저 생성해야 내부클래스에 접근이 가능함" -> 이 설명이 존나 정확하다!
	}
	
	// --- 인스턴스 메소드: 'instanceMethod()' ---
	// 이 메소드는 'Innerex02' 객체가 만들어져야만 호출할 수 있다.
	// 그래서 이 안에서는 'Innerex02'의 모든 멤버(인스턴스/스태틱)에 존나게 자유롭게 접근 가능하다!
	void instanceMethod() {
		// 인스턴스 메소드에서는 인스턴스 멤버와 static 멤버 모두 접근이 가능하다! (존나 편함!)
		InstanceInner obj1 = new InstanceInner(); // 인스턴스 내부 클래스 객체 생성 (자기 객체 있으니 바로 가능)
		StaticInner obj2 = new StaticInner();     // 스태틱 내부 클래스 객체 생성 (static은 어디서든 가능)
		
		// ★★★ 지역 내부 클래스는 메소드 안에서만 존재한다! ★★★
		// 'LocalInner' 클래스는 아래 'myMethod()' 안에서 정의됐으니, 여기서는 접근할 수 없다.
		// 니 코드 주석: "메소드 내에 지역적으로 선언된 내부클래스는 외부에서 접근 할 수 없음" -> 이 설명도 존나 정확하다!
		// LocalInner lv = new LocalInner(); // (오류 발생: LocalInner는 이 메소드에서 보이지 않음)
	}

	// --- 메소드 'myMethod()' 안의 지역 내부 클래스: 'LocalInner' ---
	// 이 새끼는 `myMethod()`가 호출될 때만 잠깐 만들어지고, 이 메소드 안에서만 쓸 수 있다!
	void myMethod() {
		class LocalInner{} // 'LocalInner' 클래스 정의
		LocalInner lv =new LocalInner(); // 'LocalInner' 객체는 이 메소드 안에서만 만들 수 있다.
	}
	
	// --- 메인 메소드: 프로그램의 시작점! ---
	public static void main(String[] args) {
		// 'StaticInner.cv': 스태틱 내부 클래스의 `static` 변수는 클래스 이름으로 바로 접근 가능하다! (깔끔!)
		System.out.println("StaticInner.cv: " + StaticInner.cv); // 출력에 구분을 위해 문자열 추가

		// ★★★ `Innerex02` 클래스를 참조하여 객체 생성 및 접근! ★★★
		Innerex02 outer = new Innerex02(); // 외부 클래스 'Innerex02' 객체 생성!
		// 'InstanceInner'는 'Innerex02'의 인스턴스 내부 클래스이므로, 외부 클래스 객체를 통해 생성해야 한다!
		Innerex02.InstanceInner inner = outer.new InstanceInner(); // 인스턴스 내부 클래스 객체 생성
		System.out.println("InstanceInner의 iv (객체 생성 후 접근): " + inner.iv);
	}

}
