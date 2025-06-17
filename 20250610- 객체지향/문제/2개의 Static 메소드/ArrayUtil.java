package com.functionex;

public class ArrayUtil {
	public static int[] concat(int[] a, int[] b) {
		// 배열 a와 b를 연결한 새로운 배열 리턴

		int[] arr = new int[a.length + b.length];
		// 배열 a를 새로운 배열 arr에 복사
		for (int i = 0; i < a.length; i++)
			arr[i] = a[i];

		// 배열 b를 새로운 배열 arr에 복사
		for (int i = 0; i < b.length; i++) {
			int k = a.length + i;
			arr[k] = b[i];
		}
		return arr;
	}

	public static void print(int[] a) {
		// 배열 a 출력
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("]");
	}
}
