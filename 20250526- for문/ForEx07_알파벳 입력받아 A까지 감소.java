package com.loop;

/* 문] 알파벳 한문자를 입력받아 입력받은 문자부터 A까지 감소시키며 출력하는 프로그램을 구현하시오.

알파벳 입력: e
abcde
abcd
abc
ab
a
*/

import java.util.*;

public class ForEx07 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("소문자 알파벳 하나를 입력하시오. >> ");
		char input = sc.next().charAt(0);  // 예: 'e'

		for (char i = input; i >= 'a'; i--) {
			for (char j = 'a'; j <= i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
}
