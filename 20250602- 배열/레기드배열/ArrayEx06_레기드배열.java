package com.arraytwo;
/* 레기드 배열 = 가변 배열 = 비정형 배열
전체 배열의 크기중 마지막 차수의 길이를 지정하지 않고 
다른 길이의 배열 생성하는 것을 의미함.
즉, 고정형태가 아닌 보다 유동적인 것을 가변 배열이라고 함
 
ex)
int[][] arr = new int[5][];
arr[0] = new int[4];
arr[1] = new int[2];
arr[2] = new int[3];
arr[3] = new int[5];
arr[4] = new int[3];
 */

public class ArrayEx06 {

	public static void main(String[] args) {
		
		int[][] arr = { { 100, 100, 100, 100}, { 70, 70 }, { 100, 90, 90 }, { 100, 80, 80, 90, 100 },
				{ 100, 60, 60 } };

		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) { // 각 행 점수 순행 
			sum = 0;  // 합계 다시 구하기 위해 sum = 0으로 초기화 
			for (int j = 0; j < arr[i].length; j++) { // 각 열 점수 순행
				System.out.print(arr[i][j] + "\t");
				sum += arr[i][j];
			}
			System.out.println(sum);
			System.out.println();
		}
	}
}
