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

		// ★ 중요! 만약 'lastWord'나 'word'가 빈 문자열이면 에러 터진다! 실제 게임에선 길이 체크 필수! ★
		// (지금 코드는 단순 비교만 한다)
		if (lastWord.isEmpty() || word.isEmpty()) { // 단어가 비어있으면 일단 실패.
			return false;
		}

		// --- 마지막 문자와 첫 번째 문자 비교 (★★★ 끝말잇기 규칙 확인의 핵심! ★★★) ---
		// 이전 단어의 마지막 글자(lastWord.charAt(lastIndex))와 현재 단어의 첫 글자(word.charAt(0))가 같은지 본다.
		if(lastWord.charAt(lastIndex) == word.charAt(0)) { // 마지막 글자 == 첫 글자면
			return true; // 성공! 'true' 반환.
		} else { // 다르면
			return false; // 실패! 'false' 반환.
		}
	}
    // ★ 중요! 게임 끝나면 'sc.close()'로 Scanner를 닫아줘야 리소스 낭비 안 함! (Player 객체 소멸 시 관리 필요) ★
} // Player 클래스 끝

// --- WordGameApp 클래스: 끝말잇기 게임 전체를 관리하는 메인 클래스 ---
// n명이 참가하는 끝말잇기 게임 프로그램을 구현한다.
// 처음 단어는 "아버지"이다.
// n명의 참가자들은 순서대로 자신의 단어를 입력한다.
// 끝말잇기에서 끝말이 틀린 경우 게임을 끝내고 게임에서 진 참가자를 화면에 출력한다.
// 이 문제의 핵심은 여러 개의 Player 객체와 배열을 사용하는 것임.

public class WordGameApp {
	private String startWord = "아버지"; // 게임 시작 단어다. 모든 게임은 여기서 시작한다.
	private Scanner sc; // 사용자 입력받을 스캐너. 참가자 수나 이름 입력받을 때 쓴다.
	private Player[] players; // 게임에 참가하는 Player 객체들을 저장할 배열. 게임 시작할 때 참가자 수만큼 만든다.

	// WordGameApp 클래스의 생성자다.
	// 이 객체가 만들어질 때(new WordGameApp() 할 때) 스캐너를 초기화한다.
	public WordGameApp() {
		sc = new Scanner(System.in); // 키보드 입력받을 새 스캐너 객체 생성.
	}

	// 게임에 참가할 플레이어들을 만들고 초기화하는 메서드다.
	// 사용자한테 참가자 수 입력받아서 그만큼 Player 객체 만들고 players 배열에 때려박는다.
	public void createPlayer() {
		System.out.print("게임에 참가하는 사람은 몇 명: ");
		int nPlayers = sc.nextInt(); // 사용자한테 참가자 수 입력받음.
		players = new Player[nPlayers]; // 입력받은 수만큼 Player 배열 만듦.

		for (int i = 0; i < nPlayers; i++) { // 참가자 수만큼 반복한다.
			System.out.print("참가자 이름: ");
			String name = sc.next(); // 각 참가자 이름 입력받음.
			players[i] = new Player(name); // ★★★ 핵심! 입력받은 이름으로 Player 객체 만들어서 배열에 넣음. ★★★
		}
	}

	// 끝말잇기 게임의 전체적인 흐름을 제어하는 메서드다.
	// 플레이어 생성부터 게임 종료까지 모든 게임 로직이 여기 다 있다.
	public void run() {

		System.out.println("끝말잇기 게임을 시작한다. 간다잉~");
		// 참가자를 위한 Player[] 배열 생성
		createPlayer(); // createPlayer 메서드 호출해서 플레이어들 설정.

		// 시작 단어 설정
		String lastWord = startWord; // 게임의 첫 단어는 "아버지"다.

		System.out.println("시작 단어는 " + lastWord + "이다. 받아라!");
		int next = 0; // 현재 턴의 참가자 순서(players 배열 인덱스)다. 0부터 시작한다.

		while (true) { // 게임이 끝날 때까지 무한 반복한다. 게임 끝나면 `break`로 나간다.
			// 다음 참가자 단어 입력받기
			// 현재 턴의 플레이어(players[next])한테 단어 입력받으라고 하고, 입력된 단어를 `newWord`에 저장한다.
			String newWord = players[next].getWordFromUser();

			// 다음 참가자가 끝말잇기 성공했는지 검사한다.
			// 현재 플레이어가 입력한 단어가 규칙에 맞는지(`checkSuccess` 메서드) 확인한다.
			if (!players[next].checkSuccess(lastWord)) { // 규칙에 안 맞으면 (false면)
				System.out.println(players[next].getName() + "이 졌다! ㅠㅠ"); // 해당 플레이어가 졌다고 알림.
				break; // ★★★ 게임 종료! 루프 박살냄. ★★★
			}
			next++; // 다음 참가자 턴으로 넘어가기 위해 `next` 값 1 증가.
			// 다음 턴의 플레이어를 결정한다. players 배열 크기만큼 순환한다.
			// (예: 3명일 경우 0 -> 1 -> 2 -> 0 -> 1 ...)
			next %= players.length;	// ★★★ 핵심! 나머지 연산자로 인덱스 범위 안 벗어나게 순환시킴. ★★★
			// 현재 입력된 단어(`newWord`)를 다음 턴의 `lastWord`로 설정한다.
			lastWord = newWord;	
		}
		sc.close(); // ★ 중요! 게임 끝나면 WordGameApp의 Scanner 닫아줘야 리소스 낭비 안 함! ★
	}

	// ★★★ 프로그램 실행 시작점 (메인 메서드) ★★★
	public static void main(String[] args) {
		WordGameApp game = new WordGameApp(); // `WordGameApp` 객체 만들어서 게임 준비.
		game.run(); // 만들어진 `game` 객체의 `run()` 메서드 호출해서 끝말잇기 게임 시작!
	}
}
