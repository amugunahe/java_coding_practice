package com.loop;

/* 문] 알파벳 한문자를 입력받아 입력받은 문자부터 A까지 감소시키며 출력하는 프로그램을 구현하시오.

알파벳 입력: e
abcde
abcd
abcab
a
*/

import java.util.*;

public class ForEx07 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("알파벳 입력: ");
		char alph = sc.next().charAt(0);
		
		for (char ch = 'A'; ch <= alph; ch++) {
			for (char bb = 'A'; bb <= alph - (ch -'A'); bb++) {
				System.out.print(bb);
			}
			System.out.println();
		}
	}
}
