package com.functionex; // 이 코드가 'com.functionex' 폴더에 있다는 뜻.

public class Mul { // 'Mul'이라는 이름의 클래스(객체 설계도)다. 곱셈 전용이다.
	private int a; // ★★★ 중요! 첫 번째 숫자 저장용. 'private'이라 이 클래스 안에서만 건드릴 수 있다. ★★★
	private int b; // ★★★ 중요! 두 번째 숫자 저장용. 얘도 'private'이라 마찬가지. ★★★
	
	// 외부에서 두 숫자(a, b)를 받아서 이 객체의 'a', 'b' 변수에 저장하는 메서드.
	public void setValue(int a, int int b) { 
		this.a = a; // ★★★ 핵심! 'this.a'는 이 'Mul' 객체 안의 멤버 변수 'a'. 그냥 'a'는 이 메서드로 들어온 임시 'a'. ★★★
		            // 이름이 같을 때 헷갈리지 말라고 `this`를 쓴다.
		this.b = b; // 'this.b'는 이 'Mul' 객체 안의 멤버 변수 'b'. 그냥 'b'는 이 메서드로 들어온 임시 'b'.
	}

	// 이 객체에 저장된 두 숫자('a', 'b')를 곱해서 그 결과를 반환하는 메서드.
	public int calculate() { 
		return a * b; // 멤버 변수 'a'와 'b'를 곱한 값을 결과로 돌려준다.
	}	
}
