package com.arrayex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  ArrayEx07 클래스: **영단어를 보여주고 뜻을 존나게 알아맞히는 퀴즈 프로그램!**
 
  핵심:
  - **문제:** 미리 정의된 영단어와 뜻을 보여주고, 사용자한테 뜻을 입력받아서 맞는지 틀리는지 확인해준다!
  - **2차원 배열 `words` 활용:**
  `words[문제번호][0]`에는 영단어가, `words[문제번호][1]`에는 그 영단어의 뜻이 저장된다!
  - **`Scanner` 클래스:** 사용자한테 키보드로 입력받을 때 쓰는 존나 유용한 놈이다!
  - **`nextLine()`:** 스페이스(공백) 포함해서 한 줄 전체를 입력받을 때 쓴다! (단어 뜻처럼 공백이 있을 수 있는 문장에 딱이다!)
  - **`equals()` 메소드:** 문자열(String)이 같은지 비교할 때 쓰는 존나 중요한 메소드다! (==으로 비교하면 안 된다, 씨발!) 
  - **`for` 문:** 배열에 있는 모든 단어를 돌면서 퀴즈를 내는 데 존나게 유용하다!
 */

import java.util.*; // 'Scanner' 클래스를 쓰려면 이 새끼를 불러와야 한다, 씨발!

public class ArrayEx07 {

	public static void main(String[] args) {

		// ★★★ 사용자 입력받을 준비! ★★★
		// 'Scanner' 객체를 만들어서 시스템 입력(키보드)을 읽어들인다.
		Scanner sc = new Scanner(System.in);
		
		// ★★★ 영단어랑 뜻을 저장할 2차원 배열 선언 및 초기화! ★★★
		// `words[i][0]`는 영단어, `words[i][1]`은 그 영단어의 뜻이다.
		String[][] words = {
			{ "chair", "의자" },
			{ "computer", "컴퓨터" },
			{ "integer", "정수" },
			{ "love", "사랑" },
			{ "happy", "행복" }
		};

		// --- 퀴즈 시작! (배열에 있는 모든 단어를 돌면서 문제 낸다!) ---
		for (int i = 0; i < words.length; i++) { // `i`는 문제 번호이자 배열의 행 인덱스다.
			// `printf()`로 문제 번호와 영단어를 존나게 깔끔하게 출력한다!
			System.out.printf("문] %d. %s의 뜻은? ", i + 1, words[i][0]);
			
			// ★★★ 사용자한테 단어의 뜻을 입력받는다! (띄어쓰기 포함될 수 있으니 `nextLine()` 쓴다!) ★★★
			String str = sc.nextLine();
			
			// --- 입력받은 뜻과 정답을 비교함! (존나 중요!) ---
			// `str.equals(words[i][1])`로 입력값(`str`)이 정답(`words[i][1]`)과 같은지 확인한다!
			if (str.equals(words[i][1])) {
				System.out.println("정답입니다. 축하드립니다."); // 맞으면 정답 메시지 출력!
			} else {
				System.out.println("틀렸습니다. 정답은 " + words[i][1] + "입니다."); // 틀리면 틀렸다는 메시지와 함께 정답을 알려준다!
			}
			System.out.println(); // 문제 하나 끝나고 깔끔하게 한 줄 띄우기!
		}
		
		// ★★★ 스캐너 닫기! (존나 중요!) ★★★
		// 자원 낭비를 막기 위해 다 쓴 'Scanner'는 꼭 닫아줘야 한다!
		sc.close();
	}
}
