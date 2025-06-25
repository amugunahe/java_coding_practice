package com.loop;

/* 문] 다음과 같이 중첩 for문을 이용하여 구현하시오.

                0
               101
              21012
             3210123 
            432101234
           54321012345
          6543210123456 
         765432101234567
 
절대값 함수: math.abs() // Math.abs()는 절대값을 구해주는 함수다.
 */

public class ForEx08 {

	public static void main(String[] args) {

		int i, j; // i는 줄(행)을 담당, j는 각 줄의 내용(공백/숫자)을 담당
		final int num = 7; // 패턴의 최대 크기를 정하는 상수 (7까지 출력되니 7로 설정)

		// 바깥쪽 for문: 줄(행)을 제어한다. 0부터 num(7)까지 총 8줄 반복.
		for (i = 0; i <= num; i++) { 
			// 안쪽 for문: 각 줄에 출력될 내용(공백 또는 숫자)을 제어한다.
			// j는 num(7)부터 -num(-7)까지 감소하며 반복 (총 15번 반복: 7에서 -7까지 15개 숫자)
			for (j = num; j >= -num; j--) { 
				// 핵심 로직: 현재 j의 절대값이 i보다 크면 공백 출력, 아니면 j의 절대값 출력.
				if (Math.abs(j) > i) { // Math.abs(j)는 j의 절대값.
					System.out.printf("%s", " "); // 공백 출력 (printf 써도 되고 print 써도 됨)
				} else { 
					System.out.print(Math.abs(j)); // j의 절대값 출력
				}
			}
			System.out.println(); // 한 줄의 출력이 끝나면 다음 줄로 이동
		}
	}
}
