package com.arraytwo;

/* 가변배열
 * 선언:자료형[][] 배열명; 또는 자료형[] 배열명[]; 또는 자료형 배열명[][];
 * 초기화: 배열명 = new 자료형[행][]
 * int[][] arr= new int[3][];
 * arr[0]= new int[2];
 * arr[1]= new int[1];
 * arr[2]= new int[3];
 * 
 */
public class ArrayEx08 {

	public static void main(String[] args) {
		// 레기드 배열선언

		int[][] arr = new int[3][];

		arr[0] = new int[2]; // 1행 초기화
		arr[1] = new int[1]; // 2행 초기화
		arr[2] = new int[3]; // 3행 초기화

		arr[0][0] = 100;
		arr[0][1] = 200;
		// 1행 끝

		arr[1][0] = 300;
		// 2행 끝

		arr[2][0] = 400;
		arr[2][1] = 500;
		arr[2][2] = 600;
		// 3행끝

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print("arr[" + i + "][" + j + "]: " + arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}