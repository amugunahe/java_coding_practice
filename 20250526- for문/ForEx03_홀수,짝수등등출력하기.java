package com.loop;

public class ForEx03 {

	public static void main(String[] args) {
		
		/* int sum = 0;
		
		for (int i = 1, j = 10, k = 10; i <= 10; i++, j--, k--) {
			System.out.println(i + " => " + j + " => " + k);
		}
		*/
		
		System.out.println("i\t 2 * i\t 2 * i - 1\t i * i\t 11 - i\t i % 3\t i / 3");
		System.out.println("---------------------------------------");
		
		for (int i = 1; i <= 10; i++)
			System.out.printf("%d\t %d\t %d\t %d\t %d\t %d\t %d%n", i, 2 * i, 2 * i - 1, i * i, 11 - i, i % 3, i / 3);
	}
}
