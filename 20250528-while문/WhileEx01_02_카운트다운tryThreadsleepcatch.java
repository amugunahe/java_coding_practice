package com.loop;

/*
 * I can do it 5번 출력
 * i의 값이 0이 아닌 동안 출력
 * 5 4 3 2 1 0 => -1씩 감소 
 */

public class WhileEx01_02 {

	public static void main(String[] args) {

		int i = 11;

		while (i-- != 0) {
			try {
				Thread.sleep(1000); // 1000분의 1씩
			} catch (InterruptedException e) {

			}
			// System.out.println(i + " I can do it");
			System.out.println(i);
		}
		System.out.println("GAME OVER");
	}

}
