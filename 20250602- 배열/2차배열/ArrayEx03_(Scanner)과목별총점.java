package com.arraytwo;

/*
 * 2차원 배열을 활용하여 아래와 같이 출력되도록 프로그래밍 하시오. 
 * -------------------------------------------
 * 번호		국어		영어		수학		총점		평균
 * -------------------------------------------
 *	1       100		100		100		300		100.0
 *	2		20		20		20		60		20.0
 *	3		30		30		30		90		30.0		
 *	4		40		40		40		120		40.0	
 *	5		50		50		50		150		50.0
 *--------------------------------------------
 *	총점	240		240		240		
 *--------------------------------------------
 */

public class ArrayEx03 {

	public static void main(String[] args) {

		int score[][] = { // 배열의 초기화
				{ 100, 100, 100 }, { 20, 20, 20 }, { 30, 30, 30 }, { 40, 40, 40 }, { 50, 50, 50 }, };

		// 과목별 총점 변수 선언
		int korTot = 0, engTot = 0, mathTot = 0;

		// 각 개인별 총점과 평균변수 선언
		int sum = 0;
		float avg = 0.0f;

		System.out.println("번호  국어   영어   수학   총점   평균");
		System.out.println("---------------------------------------------");

		for (int i = 0; i < score.length; i++) {

			korTot += score[i][0];
			engTot += score[i][1];
			mathTot += score[i][2];
			System.out.print(i + 1 + " ");
			for (int j = 0; j < score[i].length; j++) {
				sum += score[i][j];
				System.out.printf("%5d%s", score[i][j], " ");
			}
			avg = sum / (float) score[i].length;
			System.out.printf("%5d %6.1f%n", sum, avg);

		}
		System.out.println("---------------------------------------------");
		System.out.printf("총점: %4d %4d %4d%n", korTot, engTot, mathTot);
	}

}
