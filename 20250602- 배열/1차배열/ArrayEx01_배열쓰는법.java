package com.arrayex;

/* 배열: 크기와 성격이 같은 일련의 원소들이 모여 공동의 집합 구조를 갖는
자료의 집합체를 의미한다.
개별적인 자료형을 부여하지 않고 하나의 이름을 가지고 처리할 목적으로 사용함

자바에서의 배열은 다음 순서에 의해서 사용된다.
배열선언 --> 배열에 메모리할당 --> 배열 요소의 이용

배열의 형식
자료형[] 변수명; 또는 자료형 변수명 [];
변수명 = new 자료형[배열의 크기];

배열에 값을 대입
변수명[인덱스] = 값;
aa[0]=10; 
 */

public class ArrayEx01 {

	public static void main(String[] args) {
		
		// 배열 선언
		int[] arr;
		
		// 자료형[] 배열명 
		arr = new int[10];
		
 		// 메모리 할당
		int[] ar = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// 배열 요소 사용(접근)
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;

		/* System.out.println(arr[0]); 
  		  System.out.println(arr[1]);
		 System.out.println(arr[2]); 
   		 System.out.println(arr[3]);
		 System.out.println(arr[4]); 
   		 System.out.println(arr[5]);
		 System.out.println(arr[6]); 
   		 System.out.println(arr[7]);
		 System.out.println(arr[8]); 
   		 System.out.println(arr[9]);
		 */

		/* for (int i = 0; i < 10; i++) { 
  		 System.out.println(arr[i]); 
    		 }
		 */

		/* for (int temp : arr) { 
  			System.out.println(temp);
     		  }
		 */

		System.out.println(arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
