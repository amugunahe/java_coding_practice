package com.functionex;

import java.util.*;

public class DicApp {
	
	private Scanner sc;
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("한영단어 검색 프로그램입니다.");
		while(true) {
		System.out.print("한글 단어: ");
		String kor = sc.next();
		if (kor.equals("그만")) {
			System.out.print("프로그램을 종료합니다.");
			System.exit(0);
		}
		
		String eng = Dictionary.kor2Eng(kor);
		if (eng == null) {
			System.out.println(kor + "는 저의 사전에 없습니다.");
		} else {
			System.out.println(kor + "은 " + eng);
			}
		}
	}
}
