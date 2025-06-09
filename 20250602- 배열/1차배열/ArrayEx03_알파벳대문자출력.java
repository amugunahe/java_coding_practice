package com.arrayex;

/* 문] char 자료형의 배열에 알파벳 대문자를 저장하고
저장된 배열의 전체요소를 출력하는 프로그램을 작성하시오.
 
ABCD~Z
*/

public class ArrayEx03 {

	public static void main(String[] args) {
		
		/* 첫번째 
		 char [] arr1 = new char [26]; arr1[0] = 'A'; arr1[25] = 'Z';
	
		 두번째
		char[]arr2 = {'A','B','C','D','E','F','G'~~'Z'};
	
		 세번째
 		char[] arr3 = new char[26]; for(int i = 0, b = 65; i < arr3.length; i++, b++) {
		arr3[i] = (char)b; System.out.print(arr3[i] + " ");
		 */

		char[] arr3 = new char[26];
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = (char) ('A' + i);
			System.out.print(arr3[i] + " ");
		}
	}
}
