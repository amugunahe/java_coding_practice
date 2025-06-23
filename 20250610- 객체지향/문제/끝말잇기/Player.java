package com.exam; // 'com.exam'은 이 자바 파일(클래스)이 속한 패키지 이름입니다. 패키지는 관련 클래스들을 묶어서 관리하는 폴더와 같은 역할을 합니다.

// 한 사람의 참가자를 의미하는 클래스
// 이 클래스는 끝말잇기 게임의 각 플레이어를 나타내며, 플레이어의 이름, 입력한 단어, 그리고 게임 로직을 처리하는 메소드를 포함합니다.
// 즉, 끝말잇기 게임에서 한 명의 '참가자'가 가져야 할 정보(이름, 입력 단어)와 행동(단어 입력받기, 끝말잇기 규칙 확인)을 정의한 '설계도'입니다.

import java.util.*; // 'java.util' 패키지 안에 있는 모든 유틸리티 클래스들을 가져와 사용하겠다는 의미입니다.
                    // 여기서는 사용자로부터 입력을 받기 위한 'Scanner' 클래스를 사용하기 위해 필요합니다.

public class Player { // 'Player'라는 이름의 공개(public) 클래스를 선언합니다. 이 클래스가 바로 '참가자' 객체를 만들기 위한 설계도입니다.

    // --- 멤버 변수 (필드) ---
    // 이들은 'Player' 클래스로 만들어지는 각각의 객체(플레이어)가 가질 고유한 정보들을 저장하는 공간입니다.
    // 'private' 접근 제어자는 이 변수들이 'Player' 클래스 내부에서만 직접 접근 가능하도록 하여 데이터를 안전하게 보호합니다.
	private String name; // 참가자(플레이어)의 이름을 저장할 문자열(String) 변수입니다.
	private String word; // 현재 참가자가 게임에서 입력한 단어를 저장할 문자열(String) 변수입니다.
	private Scanner sc;  // 사용자로부터 입력을 받기 위한 'Scanner' 객체입니다. 콘솔(키보드) 입력을 담당합니다.

	// --- 생성자(Constructor) ---
	// 'Player' 클래스의 생성자입니다.
    // 'Player' 객체(예: 'Player player1 = new Player("철수");'와 같이)가 생성될 때 자동으로 호출되며,
    // 플레이어의 이름을 설정하고 사용자 입력을 위한 'Scanner' 객체를 초기화합니다.
	public Player(String name) { // 'Player' 객체를 만들 때, 플레이어의 'name'을 매개변수로 받습니다.
		this.name = name; // 전달받은 'name' 매개변수 값을 현재 'Player' 객체의 'name' 멤버 변수(필드)에 할당합니다.
                          // 'this.name'은 이 객체 자신의 'name' 변수를 의미합니다.
		sc = new Scanner(System.in); // 시스템의 표준 입력 스트림(System.in, 즉 키보드 입력)으로부터 읽어올 새 'Scanner' 객체를 생성하여 'sc' 변수에 저장합니다.
	}

    // --- Getter 메소드 ---
    // 'name' 필드(멤버 변수)의 값을 외부에서 읽어갈 수 있도록 해주는 메소드입니다.
	public String getName() { // 이 메소드는 'String' 타입의 값을 반환합니다.
		return name; // 현재 'Player' 객체의 'name' 값을 반환합니다.
	}

	// --- 단어 입력받기 메소드 ---
	// 참가자의 이름으로 단어를 입력 받습니다.
	// 이 메소드는 플레이어의 이름을 콘솔에 출력하고, 사용자로부터 단어를 입력받아 'word' 필드에 저장한 후 그 단어를 반환합니다.
	public String getWordFromUser() {
		System.out.print(name + ": "); // 현재 플레이어의 이름을 출력하여 누가 단어를 입력할 차례인지 알려줍니다. (예: "철수: ")
		word = sc.next(); // 'sc.next()' 메소드를 사용하여 사용자가 콘솔에 입력한 '한 단어'(공백 이전까지)를 읽어와 'word' 필드에 저장합니다.
		return word; // 입력받은 단어('word')를 이 메소드를 호출한 곳으로 반환합니다.
	}

	// --- 끝말잇기 성공 여부 확인 메소드 ---
	// 'lastWord'(이전 단어)와 참가자가 입력한 단어('word')를 비교하여 끝말잇기 규칙을 잘 지켰는지를 판단합니다.
	// 성공적으로 규칙을 지켰으면 'true'를 반환하고, 아니면 'false'를 반환합니다.
	public boolean checkSuccess(String lastWord) { // 'lastWord'는 이전 플레이어가 말한 단어를 매개변수로 받습니다.
                                                  // 'boolean'은 이 메서드가 'true' 또는 'false'를 반환함을 의미합니다.

		// 'lastWord.length() - 1'은 'lastWord' 문자열의 마지막 문자에 대한 인덱스를 계산합니다.
		// 자바에서 문자열의 인덱스는 0부터 시작하므로, 길이가 5인 문자열의 마지막 인덱스는 4입니다.
		int lastIndex = lastWord.length() - 1;

		// --- 마지막 문자와 첫 번째 문자 비교 ---
		// 'lastWord.charAt(lastIndex)'는 'lastWord'의 마지막 글자를 가져옵니다.
		// 'word.charAt(0)'는 현재 플레이어가 입력한 'word'의 첫 글자를 가져옵니다.
		// 이 두 글자가 동일한지 비교합니다.
		// 참고: 만약 'lastWord'나 'word'가 빈 문자열일 경우, 'length()'가 0이 되어 'lastIndex'가 -1이 되고,
		// 'charAt(-1)' 호출 시 'IndexOutOfBoundsException'이 발생할 수 있습니다.
		// 실제 게임에서는 이러한 예외 상황(빈 문자열 입력 등)에 대한 추가적인 유효성 검사 로직이 필요할 수 있습니다.
		if(lastWord.charAt(lastIndex) == word.charAt(0)) { // 이전 단어의 마지막 글자와 현재 단어의 첫 글자가 같으면
			return true; // 끝말잇기 규칙을 성공적으로 지켰으므로 'true'를 반환합니다.
		} else { // 같지 않으면 (규칙을 지키지 못했으면)
			return false; // 'false'를 반환합니다.
		}
	}
} // Player 클래스 종료
