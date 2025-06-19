package com.exam;

/* n명이 참가하는 끝말잇기 게임 프로그램을 구현하시오.
처음 단어는 "아버지"이다.
n명의 참가자들은 순서대로 자신의 단어를 입력한다.
끝말잇기에서 끝말이 틀린 경우 게임을 끝내고 게임에서 진 참가자를 화면에 출력한다.
프로그램에서는 시간 지연을 구현하지 않아도 된다.
그렇지만 참가자들이 스스로 시간을 제어보는 것도 좋겠다.
이 문제의 핵심은 여러개의 객체와 배열을 사용하는 것임

이 주석은 끝말잇기 게임 애플리케이션의 전체적인 요구사항과 구현 지침을 설명합니다.
여러 개의 Player 객체와 배열을 사용하여 게임 로직을 구현하는 것이 핵심입니다.


main()함수를 포함한 WordApp클래스와 각 선수를 나타내는 Player 클래스를 작성하고, 
실행중에는 WordGameApp 객체 하나와 선수 숫자만큼의 Player 객체를 생성하면된다.

WordGameApp 클래스는 게임의 전반적인 진행을 관리하는 메인 클래스이며, Player 클래스는 각 참가자를 나타냅니다.
게임 실행 시 WordGameApp 인스턴스 하나와 참가자 수에 해당하는 Player 인스턴스 배열이 생성됩니다.

실행은 run() 메소드 -> run()메소드에서는 선수 숫자만큼 Player 객체를 배열로 생성함
run() 메소드는 게임의 시작점이며, 이 안에서 createPlayer() 메소드를 통해 Player 객체 배열이 초기화됩니다.

Player 클래스는 게임 참가자의 이름필드와 사용자로부터 단어를 입력받는 메소드
getWordFromUser() 끝말 잇기의 성공여부와 게임을 계속할지를 판별하는 checkSuccess() 메소드를 구현한다.

Player 클래스의 주요 기능은 이름 저장, 사용자로부터 단어 입력받기(getWordFromUser), 그리고 끝말잇기 규칙 성공 여부 확인(checkSuccess)입니다.

문자열의 마지막 문자와 첫번째 문자는 다음과 같은 방법으로 알아낼 수 있음

String word = "아버지";
int lastIndex = word.length() - 1;   // 마지막 문자에 대한 인덱스
char lastChar = word.charAt(lastIndex);  // 마지막 문자
char firstChar = word.charAt(0);   // 첫번째 문자 
이 부분은 문자열의 특정 인덱스에 접근하여 문자를 추출하는 방법을 예시로 보여줍니다.
*/

import java.util.*;

public class WordGameApp {
	private String startWord = "아버지"; // 게임의 시작 단어입니다. 모든 게임은 이 단어에서 시작합니다.
	private Scanner sc; // 사용자 입력을 받기 위한 Scanner 객체입니다. 주로 참가자 수나 이름을 입력받는 데 사용됩니다.
	private Player[] players; // 게임에 참가하는 Player 객체들을 저장할 배열입니다. 게임 시작 시 참가자 수만큼 동적으로 생성됩니다.

	// WordGameApp 클래스의 생성자입니다.
	// WordGameApp 객체가 생성될 때 호출되며, 사용자 입력을 위한 Scanner 객체를 초기화합니다.
	public WordGameApp() {
		sc = new Scanner(System.in); // 시스템의 표준 입력 스트림(System.in)으로부터 읽어올 새 Scanner 객체를 생성합니다.
	}

	// 게임에 참가할 플레이어들을 생성하고 초기화하는 메소드입니다.
	// 사용자로부터 참가자 수를 입력받아 해당 수만큼 Player 객체를 생성하고 players 배열에 저장합니다.
	public void createPlayer() {
		System.out.print("게임에 참가하는 사람은 몇 명: ");
		int nPlayers = sc.nextInt(); // 사용자로부터 참가자 수를 입력받습니다.
		players = new Player[nPlayers]; // 입력받은 참가자 수에 맞춰 Player 배열을 생성합니다.

		for (int i = 0; i < nPlayers; i++) {
			System.out.print("참가자 이름: ");
			String name = sc.next(); // 각 참가자의 이름을 입력받습니다.
			players[i] = new Player(name); // 입력받은 이름으로 Player 객체를 생성하여 배열의 해당 인덱스에 할당합니다.
		}
	}

	// 끝말잇기 게임의 전체적인 흐름을 제어하는 메소드입니다.
	// 플레이어 생성부터 게임 종료 조건까지 모든 게임 로직을 포함합니다.
	public void run() {

		System.out.println("끝말잇기 게임을 시작합니다. ......");
		// 참가자를 위한 Player[] 배열 생성
		createPlayer(); // createPlayer 메소드를 호출하여 게임에 참여할 플레이어들을 설정합니다.

		// 시작 단어
		String lastWord = startWord; // 게임의 첫 번째 단어를 `startWord` ("아버지")로 설정합니다.

		System.out.println("시작 단어는 " + lastWord + "입니다.");
		int next = 0; // 현재 턴의 참가자 순서를 나타내는 변수입니다. players 배열의 인덱스로 사용되며, 0부터 시작합니다.

		while (true) { // 게임이 끝날 때까지 무한 반복하는 루프입니다. 게임 종료 조건이 충족되면 `break` 문으로 루프를 빠져나옵니다.
			// 다음 참가자 단어를 입력하도록 한다.
			// 현재 턴의 플레이어(players[next])에게 단어를 입력받도록 요청하고, 입력된 단어를 `newWord`에 저장합니다.
			String newWord = players[next].getWordFromUser();

			// 다음 참가자가 성공하였는지를 검사한다.
			// 현재 플레이어가 입력한 단어가 끝말잇기 규칙에 맞는지(즉, 이전 단어의 마지막 글자와 현재 단어의 첫 글자가 일치하는지) `checkSuccess` 메소드를 통해 확인합니다.
			if (!players[next].checkSuccess(lastWord)) {
				System.out.println(players[next].getName() + "이 졌습니다."); // 규칙에 어긋나면 해당 플레이어가 패배했음을 알리고
				break; // 게임을 종료합니다.
			}
			next++; // 다음 참가자의 턴으로 넘어가기 위해 `next` 값을 1 증가시킵니다.
			// 다음 턴의 플레이어를 결정한다. players 배열의 크기를 이용하여 순환하도록 한다.
			// `players.length`로 나눈 나머지를 사용하여 `next`가 `players` 배열의 인덱스 범위를 벗어나지 않고 순환하도록 합니다.
			// (예: 3명일 경우 0 -> 1 -> 2 -> 0 -> 1 ...)
			next %= players.length; 
			// 현재 입력된 단어(`newWord`)를 다음 턴의 `lastWord`로 설정하여, 다음 플레이어가 이 단어를 기준으로 끝말잇기를 할 수 있도록 합니다.
			lastWord = newWord; 
		}
	}

	public static void main(String[] args) {
		WordGameApp game = new WordGameApp(); // `WordGameApp` 객체를 생성하여 게임을 준비합니다.
		game.run(); // 생성된 `game` 객체의 `run()` 메소드를 호출하여 끝말잇기 게임을 시작합니다.
	}
}
