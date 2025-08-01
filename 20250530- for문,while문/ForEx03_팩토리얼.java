package com.exam; // 이 코드가 속한 패키지(폴더) 이름이다.

/*
  ForEx03 클래스: **사용자가 입력한 양의 정수의 '팩토리얼(Factorial)'을 존나게 계산하는 프로그램이다!**
 
  핵심:
  - **문제:** 양의 정수를 입력받아, 그 숫자만큼의 팩토리얼 값 (예: 7! = 7 * 6 * 5 * 4 * 3 * 2 * 1 = 5040)을 계산한다.
  - **`Scanner` 클래스:** 사용자한테 키보드로 정수를 입력받을 때 쓰는 존나 유용한 놈이다!
  - **`n` (입력받을 숫자):** 팩토리얼을 계산할 대상 숫자다.
  - **`f` (팩토리얼 결과):** 계산된 팩토리얼 값을 저장하는 변수다. **초기값은 1로 존나게 설정한다!** (곱셈이라 0으로 하면 다 0 된다, 씨발!)
  - **입력값 유효성 검사:** `if (n <= 0)`을 써서 1보다 작은 숫자가 입력되면 경고 메시지를 출력한다! (팩토리얼은 0이나 음수 계산 안 한다!)
  - **`for` 루프:** 1부터 `n`까지 숫자를 존나게 곱해가면서 팩토리얼을 계산한다!
  - **`f *= i;`:** `f = f * i;`와 같은 의미다. 현재 `f` 값에 `i`를 곱해서 다시 `f`에 저장한다! (이게 핵심!)
 */

import java.util.*; // 사용자로부터 키보드 입력을 받기 위해 'Scanner' 클래스가 포함된 java.util 패키지 전체를 불러온다.

public class ForEx03 {

	public static void main(String[] args) {

		// ★★★ 사용자 입력을 받을 'Scanner' 객체 생성! ★★★
		Scanner sc = new Scanner(System.in);

		// ★★★ 변수 선언 및 초기화! ★★★
		// `n`: 사용자로부터 입력받을 정수.
		// `f`: 팩토리얼 값을 저장할 변수. **곱셈 연산이라 초기값은 반드시 1로 해야 한다!** (존나 중요!)
		int n, f = 1; 

		// --- 사용자에게 정수 입력 요청! ---
		System.out.print("정수 입력: ");
		n = sc.nextInt(); // 사용자가 입력한 정수를 'n' 변수에 저장한다.

		// ★★★ 입력값 유효성 검사! (존나 중요!) ★★★
		// 팩토리얼은 1 이상의 양의 정수에만 정의된다. 0이나 음수가 입력되면 경고 메시지를 출력한다.
		if (n <= 0) {
			System.out.println("정수는 1 이상부터 입력해라, 씨발!");
		} else { // 1 이상의 양의 정수가 입력된 경우에만 팩토리얼을 계산한다.
			// ★★★ 팩토리얼 계산 루프! ★★★
			// `i`는 1부터 `n`까지 1씩 증가하면서 반복한다.
			for (int i = 1; i <= n; i++) {
				f *= i; // 현재 팩토리얼 값 `f`에 `i`를 곱해서 누적한다. (f = f * i;)
				// 중간 과정이나 최종 결과를 출력한다.
				// (문제 요구사항에 따라 최종 결과만 출력하거나, 각 단계별로 출력할 수 있다.)
				// System.out.println(i + "의 팩토리얼은 " + f + "입니다."); // 각 단계별로 출력하고 싶을 때 이 주석 해제!
			}
			// ★★★ 최종 팩토리얼 결과 출력! ★★★
			System.out.println(n + "의 팩토리얼은 " + f + "입니다.");
		}
		
		// ★★★ Scanner 닫기! (존나 중요!) ★★★
		// 자원 낭비를 막기 위해 다 쓴 'Scanner'는 꼭 닫아줘야 한다!
		sc.close();
	}
}
