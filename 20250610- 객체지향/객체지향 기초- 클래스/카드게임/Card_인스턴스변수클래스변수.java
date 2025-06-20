package com.objectex; // 이 코드가 속한 패키지(폴더) 이름이에요.

public class Card { // 'Card'라는 이름의 공개(public) 클래스를 정의합니다.
	
	// 속성: 변수 -> 클래스 변수, 인스턴스 변수
	
    // 1. 인스턴스 변수 (Instance Variable)
    // 'static' 키워드가 붙어있지 않아요.
    // 이 변수들은 `Card` 클래스로부터 **객체(인스턴스)가 만들어질 때마다 각각 고유하게 생성**됩니다.
    // 예를 들어, 하트 7 카드와 스페이드 4 카드를 만들면, 각 카드는 자신만의 무늬(kind)와 숫자(number)를 가지게 돼요.
	String kind;  // 카드의 '무늬' (예: "Heart", "Spade")를 저장할 문자열(String) 변수
	int number;   // 카드의 '숫자' (예: 7, 4)를 저장할 정수(int) 변
	
    // 2. 클래스 변수 (Class Variable = Static Variable)
    // 'static' 키워드가 붙어있어요.
    // 이 변수들은 `Card` **클래스 자체에 속하며**, `Card` 클래스가 메모리에 **로딩될 때 딱 한 번 생성**됩니다.
    // 따라서 이 `Card` 클래스로부터 아무리 많은 카드 객체(`new Card()`)를 만들더라도,
    // 모든 카드 객체들이 이 `width`와 `height` 값을 **함께 공유**하게 됩니다.
    // 카드 한 장의 너비나 높이가 바뀌면, 모든 카드의 너비나 높이가 함께 바뀌는 것과 같아요.
	static int width = 100;  // 모든 카드의 '너비'를 100으로 초기화
	static int height = 200; // 모든 카드의 '높이'를 200으로 초기화
}
