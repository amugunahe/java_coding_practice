package com.loop;

/* I can do it 5번 출력
i의 값이 0이 아닌 동안 출력
5 4 3 2 1 0 => -1씩 감소 
*/

public class WhileEx01_02 {

	public static void main(String[] args) {

		int i = 11; // ★ 핵심1: i를 11로 초기화 (i--를 쓰기 때문에 11부터 시작해야 10부터 0까지 총 11번 반복)

		// 핵심2: `while (i-- != 0)`
		// 이 조건식이 이 코드의 마법이다.
		// 1. `i--`: 현재 i의 값을 먼저 사용하고, 그 다음에 i를 1 감소시킨다.
		// 2. `!= 0`: i의 현재 값이 0이 아닌 동안 (즉, 11, 10, 9, ... 1까지는 참, 0이 되면 거짓)
		while (i-- != 0) { 
			try {
				Thread.sleep(1000); // 1000밀리초 = 1초 동안 프로그램 실행을 잠시 멈춘다. (딜레이 효과)
			} catch (InterruptedException e) {
				// Thread.sleep()은 예외가 발생할 수 있어서 try-catch로 묶어줘야 한다.
				// 여기서는 특별히 처리할 게 없으면 비워둬도 됨.
			}
			// System.out.println(i + " I can do it"); // (주석 처리된)원래는 이렇게 'I can do it'이랑 같이 출력했을 듯
			System.out.println(i); // 현재 i 값 출력 (딜레이 때문에 10, 9, ... 0 순서로 출력됨)
		}
		System.out.println("GAME OVER"); // while문이 끝나면 이 메시지 출력
	}
}
