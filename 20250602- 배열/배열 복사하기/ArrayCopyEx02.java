package com.arrayExam; // 이 코드 덩어리가 속한 폴더(패키지) 이름이다.

/*
  ArrayCopyEx02 클래스: **배열의 크기를 존나게 늘리고, 기존 데이터를 새로운 배열로 복사하는 방법을 보여주는 예제다!**
 
  핵심:
  - **배열 크기 변경?:** 배열은 한번 만들면 크기를 변경할 수 없다, 씨발!
  만약 더 많은 공간이 필요하면, **원하는 크기로 새 배열을 만들고 기존 배열 내용을 그 새 배열로 복사해야 한다!**
  - **`int[] temp = new int[arr.length * 2];`:**
  기존 배열(`arr`) 길이의 **두 배**로 새로운 임시 배열(`temp`)을 만드는 거다!
  - **`for (int i = 0; i < arr.length; i++) { temp[i] = arr[i]; }`:**
  기존 `arr`에 있는 값들을 `temp` 배열의 앞부분으로 통째로 복사한다! (이전 데이터 보존!)
  - **`arr = temp;`:** ★★★ 존나 중요! '얕은 복사(Shallow Copy)'의 핵심! ★★★
  - 'arr' 변수가 이제 더 이상 원래 배열을 가리키지 않고,
  - 새로 만들어진 'temp' 배열을 가리키도록 한다!
  - 이렇게 하면 'arr'은 이제 더 커진 새로운 배열을 사용하는 것처럼 된다! (기존의 작은 배열은 더 이상 참조되지 않아 가비지 컬렉터가 처리한다.)
 */

public class ArrayCopyEx02 { // 'ArrayCopyEx02'이라는 이름의 공개(public) 클래스를 선언한다.

	public static void main(String[] args) { // ★★★ 여.기.서.부.터. 프로그램 시작점이다! 무조건 여기부터 봄. ★★★
		// 'main' 메소드 안에 있는 코드들이 순서대로 실행될 거다
		
		// 1. 초기 배열 선언 및 초기화
		// 5칸짜리 int형 배열 'arr'을 만들고, 1부터 5까지 값으로 채운다.
		int[] arr = new int[5];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1; // arr[0]=1, arr[1]=2, ..., arr[4]=5
		}
		
		// --- 변경 전 배열 상태 출력 ---
		System.out.println("[변경전]");
		System.out.println("arr.length: " + arr.length); // 배열의 현재 길이 (5) 출력
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "]: " + arr[i]); // 각 칸의 인덱스와 값 출력
		}
		System.out.println(); // 줄 바꿈 (깔끔하게 보이기 위함)
		
		// 2. 더 큰 새로운 배열 생성
		// 기존 'arr' 배열 길이의 두 배(5 * 2 = 10) 크기로 'temp'라는 새로운 int형 배열을 만든다.
		// 'temp'의 모든 칸은 기본값인 0으로 초기화된다.
		int temp[] = new int [arr.length * 2]; 
		System.out.println("temp.length: " + temp.length); // 새로 만든 'temp' 배열의 길이 (10) 출력
		System.out.println(); // 줄 바꿈

		// 3. 기존 'arr'의 값들을 'temp' 배열로 복사
		// 'arr'의 모든 요소(5개)를 'temp' 배열의 첫 5칸으로 복사한다.
		// 복사 후 'temp'는 [1, 2, 3, 4, 5, 0, 0, 0, 0, 0]이 된다.
		System.out.println("--- arr -> temp 복사 중 ---");
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i]; // arr[i]의 값을 temp[i]에 저장
			System.out.println("temp [" + i + "]: " + temp[i]); // 복사되는 과정 출력
		}
		System.out.println(); // 줄 바꿈
		
		// 4. 'arr' 참조 변수가 'temp' 배열을 가리키도록 변경 (존나 중요!)
		// 이제 'arr'은 기존의 5칸짜리 배열이 아니라, 새로 만들어진 10칸짜리 'temp' 배열을 가리키게 된다!
		// 기존 5칸짜리 배열은 더 이상 참조되지 않아 메모리에서 나중에 제거될 수 있다.
		arr = temp;  // 배열은 참조 변수를 통해서만 접근이 가능하기 때문에 이렇게 가리키는 대상을 바꿀 수 있다.
		
		// --- 변경 후 'arr' 배열 상태 출력 ---
		System.println("[변경후]");
		System.out.println("arr.length: " + arr.length); // 이제 'arr'의 길이는 10으로 늘어났다!
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "]: " + arr[i]); // 늘어난 'arr'의 모든 칸 출력
		}
	}
}
