package com.arraytwo;

public class ArrayEx02 {

	public static void main(String[] args) {

		int[][] score = { // 배열의 초기화
				{ 100, 100, 100 }, { 20, 20, 20 }, { 30, 30, 30 }, { 40, 40, 40 }, { 50, 50, 50 } };

		/*
		 * for (int i = 0; i < score.length; i++) { for (int j = 0; j < score[i].length;
		 * j++) { System.out.print(score[i][j] + "\t"); } System.out.println(); }
		 */
		int sum = 0;
		for (int[] temp : score) {
			for (int i : temp) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
		System.out.println();
		for (int[] temp : score) {
			// score의 각 요소(1차원 배열 주소)를 1차원 배열의 temp에 저장
			for (int i : temp) {
				// temp는 1차원 배열을 가리키는 참조변수
				sum += i;
			}
		}
		System.out.println("합계: " + sum);
	}
}