package com.test;

/* 문 1] 

  1
  2  3
  4  5  6
  7  8  9  10  모양을 출력하세요.
 */

public class HomeWork06 {

	public static void main(String[] args) {

		int[][] arr = new int[4][];
		int n = 1;
		
		// 배열에 값을 저장 
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new int[i + 1];
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j]= n++;
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

/* 나의 풀이]
 
int num = 1;

int[][] arr = new int[4][];

arr[0] = new int[1]; 
arr[1] = new int[2]; 
arr[2] = new int[3];
arr[3] = new int[4];
 
for (int i = 0; i < arr.length; i++) { 
 	for (int j = 0; j < arr[i].length;j++) { 
 			arr[i][j] = num++; 
 		System.out.print(arr[i][j] + " "); 
 			} 
		System.out.println(); 
		} 
	} 
}
 */