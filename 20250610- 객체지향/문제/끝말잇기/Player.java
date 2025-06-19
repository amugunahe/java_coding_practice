package com.exam;

// 한 사람의 참가자를 의미하는 클래스
// 이 클래스는 끝말잇기 게임의 각 플레이어를 나타내며, 플레이어의 이름, 입력한 단어, 그리고 게임 로직을 처리하는 메소드를 포함합니다.

import java.util.*;

public class Player {

	private String name; // 참가자 이름
	private String word; // 참가자가 입력한 단어
	private Scanner sc; // 사용자로부터 입력을 받기 위한 Scanner 객체. 콘솔 입력을 담당합니다.

	// Player 클래스의 생성자입니다.
	// Player 객체가 생성될 때 호출되며, 플레이어의 이름을 설정하고 사용자 입력을 위한 Scanner 객체를 초기화합니다.
	public Player(String name) {
		this.name = name; // 전달받은 이름을 현재 Player 객체의 name 필드에 할당합니다.
		sc = new Scanner(System.in); // 시스템의 표준 입력 스트림(System.in)으로부터 읽어올 새 Scanner 객체를 생성합니다.
	}

	public String getName() {
		return name;
	}
	
	// 참가자의 이름으로 단어를 입력 받는다 
	// 이 메소드는 플레이어의 이름을 콘솔에 출력하고, 사용자로부터 단어를 입력받아 반환합니다.
	public String getWordFromUser() {
		System.out.print(name + ": ");
		word = sc.next(); // 사용자가 콘솔에 입력한 단어를 읽어 word 필드에 저장합니다.
		return word; // 입력받은 단어를 반환합니다.
	}
		
	// lastWord와 참가자가 입력한 단어를 비교하여 끝말잇기가 잘되었는지를 판단한다.
	// 성공하면 true 리턴
	// 이 메소드는 이전 단어(lastWord)의 마지막 글자와 현재 플레이어가 입력한 단어(word)의 첫 글자를 비교하여 끝말잇기 규칙 준수 여부를 확인합니다.
	public boolean checkSuccess(String lastWord) {
		int lastIndex = lastWord.length() - 1;   // lastWord의 마지막 문자에 대한 인덱스. 문자열은 0부터 시작하므로 길이에 1을 뺀 값입니다.

		// 마지막 문자와 첫번째 문자가 같은지 비교 
		// lastWord의 마지막 글자(lastWord.charAt(lastIndex))와 word의 첫 글자(word.charAt(0))가 동일한지 확인합니다.
		// 만약 lastWord나 word가 빈 문자열일 경우 IndexOutOfBoundsException이 발생할 수 있으므로, 실제 게임에서는 빈 문자열에 대한 추가적인 유효성 검사가 필요합니다.
		if(lastWord.charAt(lastIndex) == word.charAt(0)) {
			return true; // 끝말잇기 규칙을 성공적으로 지켰을 경우 true를 반환합니다.
		} else {
			return false; // 끝말잇기 규칙을 지키지 못했을 경우 false를 반환합니다.
			}
		}
	}
