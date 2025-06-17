package com.functionex;

/* 문 8] Dictionary 클래스의 kor2Eng()메소드와 DicApp 클래스를 완성하여 아래와 같이 구현하시오.
*/

public class Dictionary {
	private static String[] kor = { "사랑", "아기", "돈", "미래", "희망" };
	private static String[] eng = { "love", "baby", "money", "future", "hope" };

	public static String kor2Eng(String word) {
		// 검색 코드 작성
		for(int i = 0; i < kor.length; i++) {
			if(kor[i].equals(word)) {
				return eng[i];
			}
		}
		return null;
	}
}
