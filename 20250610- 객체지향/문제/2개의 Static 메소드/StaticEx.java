package com.functionex;

/* 문 7] 두개의 static 메소드를 가진 ArrayUtil 클래스를 만들어라
다음 코드의 실행 결과를 참고하여 concat()와 print()를 작성하여 ArrayUtil 클래스를 완성하시오 
 */
class StaticEx {

	public static void main(String[] args) {

		int[] array1 = { 1, 5, 7, 9 };
		int[] array2 = { 3, 6, -1, 100, 7 };
		int[] array3 = ArrayUtil.concat(array1, array2);
		ArrayUtil.print(array3);
	}

}