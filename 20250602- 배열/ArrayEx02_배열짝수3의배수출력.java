package com.arrayex;

/* 문]
 * 임의의 숫자가 들어있는 배열의 숫자 데이터들 중 
 * 짝수인 요소만 골라서 출력하고, 3의 배수인 요소를 출력하는 프로그램을 구현하시오
 * 임의의 숫자: 4 7 9 1 3 2 5 6 8 
 * 
 * 
 * 출력 결과
 *  배열 전체 요소 출력: 
 *  4 7 9 1 3 2 5 6 8
 *  짝수 출력:
 *  4 2 6 8 
 *  3의 배수 출력:
 *  9 3 6 
 */

public class ArrayEx02 {

	public static void main(String[] args) {

		int arr[] = { 4, 7, 9, 1, 3, 2, 5, 6, 8 };

		System.out.println("배열 요소 전체 출력");

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("\n짝수 출력:");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0)
				System.out.print(arr[i] + "\t");
		}
		System.out.println("\n3의 배수");

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 3 == 0)
				System.out.print(arr[i] + "\t");
		}

	}

}
