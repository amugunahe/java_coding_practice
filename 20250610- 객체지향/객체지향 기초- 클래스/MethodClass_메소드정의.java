package com.objectex;

/* 메소드
 -  특정 작업을 수행하는 일련의 문장을 하나로 묶은 것을 의미함
 	기본적으로 수학의 함수와 유사하다.
 	
 	Math.sqrt() -> 제곱근 -> 4.0을 입력하면 결과 -> 2.0
 	
 	메소드를 사용하는 이유
 	1. 높은 재사용성
	2. 중복 코드를 제거
	3. 프로그램을 구조화 
 */

public class MethodClass {
	
	static void printArr(int[] numArr) {
		for (int i = 0; i < 10; i++) {
			System.out.print(numArr[i] + " ");
		}
		System.out.println();
	}
	
	static void intiArr(int[] numArr) {
		
		for (int i = 0; i < 10; i++) {
			numArr[i] = (int)(Math.random() * 10);
		}
	}
	
	public static void main(String[] args) {
		
		int [] arr = new int[10];
		
		intiArr(arr);
		printArr(arr);
		printArr(arr);
		printArr(arr);
		
		}	
	}

