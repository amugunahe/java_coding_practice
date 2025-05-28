package com.loop;

// while문을 이용하여 구구단 출력

public class WhileEx05 {

	public static void main(String[] args) {
		int i = 2, j;
		while (i <= 9) {
			j = 1; // j를 while문 안쪽으로 넣어줘야함
			while (j <= 9) {
				System.out.printf("%d * %d= %d%n", i, j, i * j);
				j++;
			}
			i++;
			System.out.println();
		}

	}

}
