package com.exam;

/* n명이 참가하는 끝말잇기 게임 프로그램을 구현하시오.
처음 단어는 "아버지"이다.
n명의 참가자들은 순서대로 자신의 단어를 입력한다.
끝말잇기에서 끝말이 틀린 경우 게임을 끝내고 게임에서 진 참가자를 화면에 출력한다.
프로그램에서는 시간 지연을 구현하지 않아도 된다.
그렇지만 참가자들이 스스로 시간을 제어보는 것도 좋겠다.
이 문제의 핵심은 여러개의 객체와 배열을 사용하는 것임


main()함수를 포함한 WordApp클래스와 각 선수를 나타내는 Player 클래스를 작성하고, 
실행중에는 WordGameApp 객체 하나와 선수 숫자만큼의 Player 객체를 생성하면된다.

실행은 run() 메소드 -> run()메소드에서는 선수 숫자만큼 Player 객체를 배열로 생성함
Player 클래스는 게임 참가자의 이름필드와 사용자로부터 단어를 입력받는 메소드
getWordFromUser() 끝말 잇기의 성공여부와 게임을 계속할지를 판별하는 checkSuccess() 메소드를 구현한다.

문자열의 마지막 문자와 첫번째 문자는 다음과 같은 방법으로 알아낼 수 있음

String word = "아버지";
int lastIndex = word.length() - 1;   // 마지막 문자에 대한 인덱스
char lastChar = word.charAt(lastIndex);  // 마지막 문자
char firstChar = word.charAt(0);   // 첫번째 문자 
 */

import java.util.*;

public class WordGameApp {
	private String startWord = "아버지"; // 시작 단어
	private Scanner sc; // 입력
	private Player[] players; // 참가자들

	public WordGameApp() {
		sc = new Scanner(System.in);
	}

	public void createPlayer() {
		System.out.println("게임에 참가하는 사람은 몇 명: ");
		int nPlayers = sc.nextInt();
		players = new Player[nPlayers];

		for (int i = 0; i < nPlayers; i++) {
			System.out.print("참가자 이름: ");
			String name = sc.next();
			players[i] = new Player(name);
		}
	}

	public void run() {

		System.out.println("끝말잇기 게임을 시작합니다. ......");
		// 참가자를 위한 Player[] 배열 생성
		createPlayer();
		// 시작 단어
		String lastWord = startWord;

		System.out.println("시작 단어는 " + lastWord + "입니다.");
		int next = 0; // 참가자의 순서를 증가시키는 변수

		while (true) {
			// 다음 참가자 단어를 입력하도록 한다.
			String newWord = players[next].getWordFromUser();

			if (!players[next].checkSuccess(lastWord)) { // 다음 참가자가 성공하였는지를 검사한다.
				System.out.println(players[next].getName() + "이 졌습니다.");
				break; // 게임 종료
			}
			next++; // 다음 참가자
			next %= players.length;
			lastWord = newWord;
		}
	}

	public static void main(String[] args) {
		WordGameApp game = new WordGameApp();
		game.run();
	}
}