package com.loop;

/* 문] 중첩 for문을 이용하여 다음과 같이 출력 되도록 구현하시오.
 
ABCDEFGHIJKLMNOPQRSTUVWXYZ
 BCDEFGHIJKLMNOPQRSTUVWXY
  CDEFGHIJKLMNOPQRSTUVWX
   DEFGHIJKLMNOPQRSTUVW
    EFGHIJKLMNOPQRSTUV
     FGHIJKLMNOPQRSTU
      GHIJKLMNOPQRST
       HIJKLMNOPQRS
        IJKLMNOPQR
         JKLMNOPQ
          KLMNOP
           LMNO
            MN            
*/

public class ForEx09 {

	public static void main(String[] args) {

		// 바깥쪽 for문: 줄(행)을 바꾸면서 첫 번째 글자를 'A'부터 'Z'까지 증가시킴
		// 'A'는 첫째 줄, 'B'는 둘째 줄... 이런 식
		for (char a = 'A'; a <= 'Z'; a++) { // a는 현재 줄의 시작 알파벳을 결정 (예: A, B, C...)

			// 핵심 1: 공백(들여쓰기) 출력 for문
			// 현재 줄의 시작 알파벳이 뒤로 갈수록 공백을 더 많이 찍어야 한다.
			// 'A'는 0칸, 'B'는 1칸, 'C'는 2칸... 이렇게.
			// char 'A'의 아스키 코드는 65다. 그래서 'a' - 65를 하면 'A'일 때 0, 'B'일 때 1이 됨.
			for (int c = 0; c < a - 'A'; c++) { // 'A' 대신 65를 써도 됨
				System.out.print(" "); // 공백 한 칸 출력
			}

			// 핵심 2: 알파벳 출력 for문
			// 시작 알파벳은 현재 줄의 'a' 값부터다. (예: A, B, C...)
			// 끝 알파벳은 'Z'에서 현재 줄의 시작 알파벳만큼 빼주는 거다.
			// 예를 들어, 'A' 줄일 때는 'Z'까지 다 나오고, 'B' 줄일 때는 'Y'까지만 나오게.
			for (char b = a; b <= 'Z' - (a - 'A'); b++) { // 'A' 대신 65를 써도 됨
				System.out.print(b); // 알파벳 출력
			}
			System.out.println(); // 한 줄 다 출력했으니 다음 줄로 넘어가기
		}
	}
}
