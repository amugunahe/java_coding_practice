package com.loop;

/* 문] 1부터 몇까지 더하면 누적합계를 100을 넘지 않은지 
n까지의 수와 합계를 출력하시오.
 */

public class WhileEx02 {

	public static void main(String[] args) {

		int i = 0, sum = 0;

		while ((sum += ++i) <= 100) {
		
			/* sum += i;
			  
			if (sum <= 100) {
   			System.out.printf("%d ==> %d%n", i, sum); 
			 i++; }
			 */

			System.out.printf("%d ==> %d%n", i, sum);
		}
	}
}
