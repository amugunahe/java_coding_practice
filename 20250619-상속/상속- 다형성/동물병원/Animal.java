// Animal.java 파일
package com.polymorphism;

public class Animal {
	// 동물의 울음소리를 반환하는 메소드.
	// 자식 클래스에서 각 동물의 고유한 울음소리로 재정의(override)할 거예요.
	public String scream() {
		return "동물 울음 소리"; // 모든 동물의 기본 울음소리
	}

	// 동물의 이름을 반환하는 메소드.
	// 기본적으로는 null을 반환하지만, 자식 클래스에서 이름을 설정하고 반환하도록 재정의하거나,
	// Animal 클래스 자체에 name 필드를 추가해서 관리할 수도 있어요.
	// 이 예제에서는 주신 코드를 유지합니다.
	public String getName() {
		return null; // 이름을 반환 (기본값 null)
	}
}