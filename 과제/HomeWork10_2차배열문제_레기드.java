package com.test; // 이 코드가 속한 패키지 이름입니다.

/*
 * [문제 5]
 * 다음과 같은 형태로 숫자를 출력하는 프로그램을 구현합니다.
 *
 * 1  2  3  4
 * 5  6  7
 * 8  9
 * 10
 *
 * 이 패턴은 각 행(row)마다 열(column)의 개수가 하나씩 줄어드는 특징이 있습니다.
 * (첫 번째 행: 4개, 두 번째 행: 3개, 세 번째 행: 2개, 마지막 행: 1개)
 */

public class HomeWork10 { // 'HomeWork10'이라는 이름의 클래스를 정의합니다.

	public static void main(String[] args) { // ★★★ 프로그램의 시작점 ★★★
		// 이 `main` 메서드 안의 코드가 프로그램이 실행될 때 가장 먼저 동작합니다.

		// 1. 2차원 배열 선언 및 초기화
		// `int[][] arr = new int[4][];`
		// - 4개의 행(row)을 가진 2차원 배열을 선언합니다.
		// - 하지만 각 행의 열(column) 길이는 아직 정해지지 않았습니다 (`[]` 부분이 비어있죠?).
		// - 이렇게 각 행의 길이가 다른 배열을 '가변 배열' 또는 '비정방형 배열'이라고 부릅니다.
		int[][] arr = new int[4][];

		// 2. 배열에 값을 채우기 위한 숫자 변수 초기화
		int n = 1; // 배열에 1부터 순서대로 채워 넣을 숫자를 저장하는 변수입니다.

		// 3. 2차원 배열의 각 행에 열 길이를 할당하고 값 채우기
		// 바깥쪽 `for` 루프: 행(i)을 제어합니다. (0부터 arr.length-1까지, 즉 0, 1, 2, 3)
		for (int i = 0; i < arr.length; i++) {
			// ★ 중요 ★ 각 행(i)마다 열의 길이를 다르게 지정합니다.
			// 문제의 출력 형태(4, 3, 2, 1)를 만들려면, '전체 행의 길이(4) - 현재 행 인덱스(i)'를 사용합니다.
			// - i가 0일 때: arr[0] = new int[4 - 0]; 즉, 길이 4
			// - i가 1일 때: arr[1] = new int[4 - 1]; 즉, 길이 3
			// - i가 2일 때: arr[2] = new int[4 - 2]; 즉, 길이 2
			// - i가 3일 때: arr[3] = new int[4 - 3]; 즉, 길이 1
			arr[i] = new int[arr.length - i];

			// 안쪽 `for` 루프: 현재 행(arr[i])의 각 열(j)을 제어하며 값을 채웁니다.
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = n++; // `n` 값을 현재 위치(arr[i][j])에 저장하고, `n`을 1 증가시킵니다.
			}
		}

		// 4. 배열에 저장된 값 출력
		// 바깥쪽 `for` 루프: 행(i)을 순회합니다.
		for (int i = 0; i < arr.length; i++) {
			// 안쪽 `for` 루프: 각 행(arr[i])의 열(j)을 순회하며 값을 출력합니다.
			for (int j = 0; j < arr[i].length; j++) {
				// 현재 값을 출력하고 탭(`\t`)으로 간격을 둡니다.
				// 탭은 각 숫자가 일정한 간격으로 정렬되게 해줍니다.
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println(); // 한 행의 모든 숫자를 출력한 후, 다음 출력을 위해 줄을 바꿉니다.
		}
	}
}
						
/* 나의 답]	

int num = 1;

int[][] arr = new int[4][];

arr[0] = new int[4];
arr[1] = new int[3];
arr[2] = new int[2];
arr[3] = new int[1];

for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num++;
				System.out.print(arr[i][j] + " ");
			} System.out.println();
		}
	}
}
*/
