package com.arraytwo;

/* 문] 영단어를 보여주고 단어의 뜻을 알아맞추는 프로그램을 구현하시오.

chair의 뜻은 ? 바꾸다
틀렸습니다. 정답은 의자입니다.

computer의 뜻은? 컴퓨터
정답입니다.
*/

import java.util.*;

public class ArrayEx07 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
	 		// words[0][0], words[0][1]
		String[][] words = { { "chair", "의자" }, { "computer", "컴퓨터" }, { "integer", "정수" }, { "love", "사랑" }, { "happy", "행복" } };

		for (int i = 0; i < words.length; i++) {
			System.out.printf("문] %d. %s의 뜻은?", i + 1, words[i][0]);
			String str = sc.nextLine();
			
			// 입력 받은 뜻을 비교함
			if (str.equals(words[i][1])) {
				System.out.print("정답입니다. 축하드립니다.");
			} else {
				System.out.print("틀렸습니다.");
			}
		}
	}
}
