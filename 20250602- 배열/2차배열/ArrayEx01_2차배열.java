package com.arraytwo;

/*
 * 2차원 배열= 다차원 배열
 * 배열선언 
 *  자료형[][] 배열명;
 *  자료형 배열명[][];
 *  자료형[] 배열명[];
 *  
 *  배열의 초기화 
 *  배열명 = new 자료형[행][열];
 *  배열명 = new 자료형[행][]; --> 가변배열, 레기드배열, 비정형배열 
 *  배열명 = {{1,2,3,4},{5,6,7,8}};
 * 
 */

public class ArrayEx01 {

	public static void main(String[] args) {
		// 배열 선언
		int[][] test = new int[2][3];

		// 배열에 값 저장
		test[0][0] = 100;
		test[0][1] = 200;
		test[0][2] = 300;

		test[1][0] = 400;
		test[1][1] = 500;
		test[1][2] = 600;

		// 배열에 저장된 값 출력
		for (int i = 0; i < test.length; i++) { // 행 i < 2
			for (int j = 0; j < test[i].length; j++) { // 열 j < 3
				System.out.print("test[" + i + "][" + j + "]:" + test[i][j] + "\t\t");
			}
			System.out.println();
		}

	}

}
