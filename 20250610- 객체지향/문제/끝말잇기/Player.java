package com.exam; // 이 코드가 'com.exam'이라는 폴더(패키지)에 속해 있다는 뜻.

// --- Player 클래스: 끝말잇기 게임 참가자의 설계도 ---
// 이 클래스는 끝말잇기 게임의 각 플레이어를 나타내고, 이름, 입력 단어, 게임 규칙 확인 같은 기능을 담당한다.
// 즉, 게임 플레이어 한 명이 가져야 할 정보(이름, 입력 단어)와 행동(단어 입력받기, 규칙 확인)을 정의한 '설계도'다.

import java.util.*; // 'java.util' 패키지 안의 모든 유틸리티 클래스들을 가져온다. 특히 'Scanner' 쓰려고 필요함.

public class Player { // 'Player'라는 이름의 공개 클래스(설계도)를 선언한다.

    // --- 멤버 변수 (속성) ---
    // 이 변수들은 'Player' 객체가 가질 고유한 정보들을 저장한다.
    // 'private'이라 이 'Player' 클래스 안에서만 직접 쓸 수 있어서 데이터를 안전하게 보호한다.
	private String name; // 참가자(플레이어) 이름을 저장할 곳.
	private String word; // 현재 플레이어가 입력한 단어를 저장할 곳.
	private Scanner sc;	 // 사용자한테 키보드 입력받을 때 쓰는 'Scanner' 객체.

	// --- 생성자(Constructor) ---
	// 'Player' 객체를 만들 때 자동으로 호출된다. 플레이어 이름 설정하고 'Scanner' 준비한다.
	public Player(String name) { // 'Player' 객체 만들 때 이름을 꼭 넣어줘야 함.
		this.name = name; // ★★★ 핵심! 'this.name'은 이 객체 자신의 이름이고, 그냥 'name'은 외부에서 받은 이름이다. ★★★
		sc = new Scanner(System.in); // 키보드 입력받을 Scanner 객체 생성.
	}

    // --- Getter 메소드 ---
    // 'name' 필드(멤버 변수)의 값을 외부에서 읽어갈 수 있도록 해주는 메소드다.
	public String getName() { // 이 플레이어의 이름을 돌려주는 메서드.
		return name; // 저장된 이름('name')을 반환한다.
	}

	// --- 단어 입력받기 메소드 ---
	// 플레이어 이름 띄워주고, 단어를 입력받아서 저장 후 반환한다.
	public String getWordFromUser() {
		System.out.print(name + ": "); // "플레이어이름: " 이렇게 출력해서 누가 입력할지 알려준다.
		word = sc.next(); // ★★★ 핵심! 사용자가 입력한 '한 단어'를 'word'에 저장. ★★★
		return word; // 입력받은 단어('word')를 돌려준다.
	}

	// --- 끝말잇기 성공 여부 확인 메소드 ---
	// 'lastWord'(이전 단어)와 지금 입력한 단어('word')를 비교해서 규칙 잘 지켰는지 판단.
	// 맞으면 'true', 틀리면 'false'를 돌려준다.
	public boolean checkSuccess(String lastWord) { // 이전 플레이어가 말한 'lastWord'를 받아서 체크한다.
        // 문자열 인덱스는 0부터 시작하니까, 마지막 글자의 인덱스는 '길이 - 1'이다.
		int lastIndex = lastWord.length() - 1;

		// --- 마지막 문자와 첫 번째 문자 비교 (★★★ 끝말잇기 규칙 확인의 핵심! ★★★) ---
		// 이전 단어의 마지막 글자(lastWord.charAt(lastIndex))와 현재 단어의 첫 글자(word.charAt(0))가 같은지 본다.
		// ★ 중요! 만약 단어가 비었으면 에러 터질 수 있으니, 실제 게임에선 길이 체크 필수! (지금 코드는 단순 비교) ★
		if(lastWord.charAt(lastIndex) == word.charAt(0)) { // 마지막 글자 == 첫 글자면
			return true; // 성공! 'true' 반환.
		} else { // 다르면
			return false; // 실패! 'false' 반환.
		}
	}
    // ★ 중요! 게임 끝나면 'sc.close()'로 Scanner를 닫아줘야 리소스 낭비 안 함! (이 클래스에서는 안 함) ★
} // Player 클래스 끝
