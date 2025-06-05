package com.loop;

/*
 * 문]
 *  다음과 같이 중첩 for문을 이용하여 구현하시오.
 *  
 *                0
 *               101
 *              21012
 *             3210123 
 *            432101234
 *           54321012345
 *          6543210123456 
 * 		   765432101234567
 * 
 * 절대값 함수: math.abs()
 */

public class ForEx08 {

	public static void main(String[] args) {

		int i, j;
		final int num = 7;

		for (i = 0; i <= num; i++) {
			for (j = num; j >= -num; j--) {
				if (Math.abs(j) > i)
					System.out.printf("%s", " ");
				else 
					System.out.print(Math.abs(j));
			}
			System.out.println();
		}
	}
}
