package com.abstractex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  PlayingCard 인터페이스: **존나게 중요한 '카드'의 설계도!**
 
  핵심:
  - **'interface' 키워드가 붙어서 이 새끼는 인터페이스다!** (객체 못 만든다, 씨발!)
  - **카드의 '종류(SPADE, DIAMOND 등)'를 나타내는 상수들을 정의한다.**
  -> 인터페이스의 필드는 **`public static final`이 자동으로 붙는다!** 니가 써놨든 안 써놨든!
  - **카드가 가져야 할 '행동'(번호 얻기, 종류 얻기)을 '추상 메소드'로 정의한다.**
  -> 인터페이스의 메소드는 **`public abstract`가 자동으로 붙는다!** 니가 써놨든 안 써놨든!
  - **이 인터페이스를 'implements'하는 모든 클래스들은 여기 정의된 추상 메소드를 무조건 구현해야 한다!**
 */

public interface PlayingCard {

	// --- 카드의 종류 (상수들) ---
	// 인터페이스의 필드는 'public static final'이 자동으로 붙는다. (변하지 않는 값!)
	public static final int SPADE = 4; // 스페이드 (숫자 4로 표현)
	final int DIAMOND = 3;             // 다이아몬드 (숫자 3로 표현) - 'public static' 생략됨
	static int HEART = 2;              // 하트 (숫자 2로 표현) - 'public final' 생략됨
	int CLOVER = 1;                    // 클로버 (숫자 1로 표현) - 'public static final' 다 생략됨
	
	// --- 카드의 행동 (추상 메소드들) ---
	// 인터페이스의 메소드는 'public abstract'가 자동으로 붙는다. (내용이 없다! 구현은 자식 클래스가!)
	public abstract String getCardNumber(); // 카드 번호를 문자열로 반환하는 메소드 (구현해야 함!)
	String getCardKind();                   // 카드 종류를 문자열로 반환하는 메소드 (구현해야 함!) - 'public abstract' 생략됨
}
