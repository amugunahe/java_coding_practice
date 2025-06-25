package com.loop;

/* 문] 알파벳 한문자를 입력받아 입력받은 문자부터 A까지 감소시키며 출력하는 프로그램을 구현하시오.

알파벳 입력: e
abcde
abcd
abc
ab
a
*/

import java.util.*; // Scanner 쓰려면 무조건 임포트해야지.

public class ForEx07 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // 사용자 입력받을 준비 완료!
		
		System.out.print("소문자 알파벳 하나를 입력하시오. >> "); // 안내 메시지 출력
		// 핵심 1: 사용자한테 입력받은 문자열(예: "e")에서 첫 번째 글자('e')만 char 타입으로 가져온다.
		char input = sc.next().charAt(0); 

		// 바깥쪽 for문: 줄(행)을 제어한다. 입력받은 문자부터 'a'까지 역순으로 반복.
		// 예: input이 'e'면 i는 'e', 'd', 'c', 'b', 'a' 순으로 바뀜.
		for (char i = input; i >= 'a'; i--) { 
			// 안쪽 for문: 각 줄에 출력될 알파벳을 제어한다.
			// 'a'부터 현재 바깥쪽 for문의 i 값까지 순서대로 출력.
			for (char j = 'a'; j <= i; j++) { 
				System.out.print(j); // 알파벳 출력 (줄바꿈 없음)
			}
			System.out.println(); // 한 줄 출력 끝나면 줄바꿈
		}
        // Scanner 사용 후 꼭 닫아라.
        sc.close();
	}
}
