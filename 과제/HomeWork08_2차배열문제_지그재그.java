package com.test;

/*
 문 3]

  20 16 12  8  4
  19 15 11  7  3
  18 14 10  6  2
  17 13  9  5  1  모양을 출력하세요.
 */

public class HomeWork08 {

	public static void main(String[] args) {

		int cnt_i = 4, cnt_j = 5;
		
		int[][] arr = new int[cnt_i][cnt_j];
		
		// 행 값 저장 
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				
				/* 1. 숫자는 하나씩 증가한다.
				   2. 행의 시작은 행 * 열 - i, 열의 시작은 행의 크기 * 열의 인덱스 
				*/
				arr[i][j] = (cnt_i * cnt_j - i) - (cnt_i * j);			
				}
		}
		// 배열의 저장된 값 출력 
		for (int i = 0; i < arr.length; i++) {
			for(int j = 0; j <arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

/* 내가 쓴 답]	
 
int num = 20;
 
int[][] arr = new int[4][5];

for (int j = 0; j < arr[0].length; j++) {
	for (int i = 0; i < arr.length; i++) {
				arr[i][j] = num--;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
*/
