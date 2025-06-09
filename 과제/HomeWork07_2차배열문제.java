package com.test;

/* 
 문 2]
 1  2  3  4  5
 10  9  8  7  6
 11 12 13 14 15
 20 19 18 17 16  모양을 출력하세요.
 */

public class HomeWork07 {

	public static void main(String[] args) {

		int[][] arr = new int[4][5];
		
		int n = 1;
		
		// 배열에 값 저장
		for (int i = 0; i < arr.length; i++) {
			
			if (i % 2 == 0) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = n++;
				}
			} else {
				for (int j = arr[i].length - 1; j >= 0; j--) {
					arr[i][j] = n++;
				}
			}
		}
	
	// 배열에 저장된 값 출력
		for (int i = 0; i < arr.length; i++) {
			for(int j = 0; j <arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
		
		
		
		
/* 내가 쓴 답]
 * 
int num = 1;

int[][] arr = new int[4][5];

		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr[i].length; j++)
					System.out.print(arr[i][j] + " ");
			} else {
				for (int j = arr[i].length-1; j>=0; j--)
					System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
*/
