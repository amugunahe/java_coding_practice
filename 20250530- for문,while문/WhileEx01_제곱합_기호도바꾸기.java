package com.exam; // 이 코드가 속한 패키지(폴더) 이름이다.

/*
  WhileEx01 클래스: **-1^2 + 2^2 - 3^2 + 4^2 ... 99^2의 합계를 존나게 구하는 프로그램이다!**
 
  핵심:
  - **문제:** `-(1^2) + (2^2) - (3^2) + (4^2) ... - (99^2)` 의 합계를 구하는 거다! (원래 문제 설명이 99^2까지였는데, 코드는 100까지 돌고 있으니 100^2까지 계산한다!)
  - **`while` 문 사용!**: 특정 조건이 참일 동안 반복할 때 쓰는 존나 유용한 반복문이다.
  - **부호 제어 (`plus` 변수):** `+1`, `-1`을 번갈아 가면서 숫자의 부호를 바꿔주는 존나 똑똑한 방법이다!
  - **제곱 계산:** `i * i` (자기 자신을 두 번 곱한다!)
  - **누적 합:** `sum += ...` (기존 `sum`에 새로운 값을 계속 더해나간다!)
 */

public class WhileEx01 {

	public static void main(String[] args) {

		int i = 1;   // ★★★ 중요! 현재 숫자를 나타내는 변수다. 1부터 시작해야 한다! ★★★
		int sum = 0; // ★★★ 최종 누적 합계를 저장할 변수다. 0으로 초기화한다! ★★★
		int plus = 1; // ★★★ 존나 중요! 부호를 제어하는 변수다. 처음엔 1로 시작한다! (+1, -1을 반복한다!) ★★★

		// --- 핵심 루프: 1부터 100까지 존나게 돌면서 합계를 계산한다! ---
		// `while (i <= 100)`: `i`가 100보다 작거나 같을 동안 계속 반복한다!
		while (i <= 100){ // 문제 설명은 99까지지만, 코드는 100까지 계산하도록 되어있다.
		    // ★★★ 존나 중요! 'plus' 변수로 부호를 번갈아 가면서 바꾼다! ★★★
		    // 'plus'가 1이면 -1로, -1이면 1로 바뀐다.
			plus = -plus; 

            // ★★★ 합계 계산! 'plus' 변수를 곱해서 부호를 결정한다! ★★★
            // (예시)
            // i=1: plus가 -1이 됨 -> sum += (-1) * (1*1) = -1
            // i=2: plus가 1이 됨 -> sum += (1) * (2*2) = +4 (총 합계 -1 + 4 = 3)
            // i=3: plus가 -1이 됨 -> sum += (-1) * (3*3) = -9 (총 합계 3 - 9 = -6)
			sum += plus * (i * i); // 현재 숫자의 제곱에 'plus'를 곱해서 `sum`에 누적시킨다.
			
			i++; // 다음 숫자로 넘어가기 위해 `i`를 1 증가시킨다!
		}
		// 최종 합계를 화면에 출력한다.
		System.out.println("합계: " + sum); // 기대 결과는 5050 (100^2까지 계산했을 때)
	}
}
