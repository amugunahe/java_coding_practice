package com.loop;

public class ForEx05 {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 9; i++) { // 행
			for (int j = 1; j <= 9; j++) { // 열 컬럼
				if (i == j) {
					System.out.printf("[%d, %d]", i, j);
				}else {
				System.out.printf("%8c",' ');
				}
			}
			System.out.println();
		}
	}
}



