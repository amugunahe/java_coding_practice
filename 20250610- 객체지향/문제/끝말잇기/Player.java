package com.exam;

// 한 사람의 참가자를 의미하는 클래스

import java.util.*;

public class Player {

	private String name; // 참가자 이름
	private String word; // 참가자가 입력한 단어
	private Scanner sc;

	public Player(String name) {
		this.name = name;
		sc = new Scanner(System.in);
	}

	public String getName() {
		return name;
	}
	
	// 참가자의 이름으로 단어를 입력 받는다 
	public String getWordFromUser() {
		System.out.print(name + ": ");
		word = sc.next();
		return word;
	}
		
	// lastWord와 참가자가 입력한 단어를 비교하여 끝말잇기가 잘되었는지를 판단한다.
	// 성공하면 true 리턴
	public boolean checkSuccess(String lastWord) {
		int lastIndex = lastWord.length() - 1;   // 마지막 문자에 대한 인덱스

		// 마지막 문자와 첫번째 문자가 같은지 비교 
		if(lastWord.charAt(lastIndex) == word.charAt(0)) {
			return true;
		} else {
			return false;
			}
		}
	}
