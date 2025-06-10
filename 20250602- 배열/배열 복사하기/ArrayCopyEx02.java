package com.arrayExam;

public class ArrayCopyEx02 {

	public static void main(String[] args) {
		
		int[] arr = new int[5];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			
		}
		
		System.out.println("[변경전]");
		System.out.println("arr.length: " + arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "]" + arr[i]);
		
	}
		int temp[] = new int [arr.length * 2];
		System.out.println("temp.length: " + temp.length);
		// 배열 arr의 저장된 값들을 배열 temp에 복사함
		
		for (int i =0; i < arr.length; i++) {
		temp[i] = arr[i];
		System.out.println("temp [" + i + "]: " + temp[i]);
		}
		System.out.println();
		
		// temp에 저장된 값을 arr에 저장함
		 arr = temp;  // 배열은 참조 변수를 통해서만 접근이 가능하기 때문에   
		
		System.out.println("[변경후]");
		System.out.println("arr.length: " + arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "]" + arr[i]);
		
		}
	}

}
