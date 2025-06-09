package com.test;

/* 문 4]

 1 5 9 13 17
 2 6 10 14 18
 3 7 11 15 19
 4 8 12 16 20  모양을 출력하세요.
*/

public class HomeWork09 {

	public static void main(String[] args) {
		
		int cnt_i = 4, cnt_j = 5;
		
		int[][] arr = new int[cnt_i][cnt_j];
		
		// 행 값 저장 
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				
				/* 1. 숫자는 하나씩 증가한다.
				   2. 행의 시작은 행 * 열 - i, 열의 시작은 행의 크기 * 열의 인덱스 
				*/
				arr[i][j] = (i + 1) + (cnt_j * j);			
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
  
int num = 1;

int[][] arr = new int[4][5];
		
		for (int j = 0; j < arr[0].length; j++) {
			for (int i = 0; i < arr.length; i++) {
				arr[i][j] = num++;
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
