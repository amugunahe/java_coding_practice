package com.arrayExam; // 이 코드 덩어리가 속한 폴더(패키지) 이름이다.

/*
  ArrayCopyEx01 클래스: **자바에서 배열을 존나게 깔끔하게 복사하는 방법을 보여주는 예제다!**
 
  핵심:
  - **배열 복사 왜 필요해?:** 배열은 한 번 만들면 크기를 변경할 수 없다, 씨발!
  만약 크기를 늘리거나 줄이고 싶으면, 원하는 크기로 새 배열을 만들고 기존 배열 내용을 복사해야 한다!
  - **`System.arraycopy()` 메소드:** 배열을 복사할 때 쓰는 존나게 유용한 기본 메소드다!
  (자바에서 제공하는 거라 믿고 써도 된다!)
  - **`public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`:**
  이 메소드의 사용법을 존나게 정확히 알아야 한다!
  - `src`: **원본 배열** (복사할 데이터가 들어있는 배열이다!)
  - `srcPos`: **원본 배열의 복사 시작 위치** (몇 번째 칸부터 복사할지 인덱스 번호다!)
  - `dest`: **복사할 배열** (데이터가 들어가게 될 새 배열이다!)
  - `destPos`: **복사할 배열의 시작 위치** (새 배열의 몇 번째 칸부터 데이터를 채울지 인덱스 번호다!)
  - `length`: **복사되는 요소의 개수** (원본 배열에서 몇 개나 복사할지 개수다!)
 */

public class ArrayCopyEx01 { // 'ArrayCopyEx01'이라는 이름의 공개(public) 클래스를 선언한다.

	public static void main(String[] args) { // ★★★ 여.기.서.부.터. 프로그램 시작점이다! 무조건 여기부터 봄. ★★★
		// 'main' 메소드 안에 있는 코드들이 순서대로 실행될 거다
		
		// ★★★ 1. 원본 배열 선언 및 초기화! ★★★
		// 'src'라는 String 배열을 만들고 4개의 문자열 값으로 초기화한다. (Java, DataBase, Jsp, Xml)
		String[] src = {"Java", "DataBase", "Jsp", "Xml"}; // 원본 배열 (소스 배열)
		
		// ★★★ 2. 복사할 배열(대상 배열) 선언 및 초기화! ★★★
		// 'dest'라는 String 배열을 만들고 크기를 6으로 지정한다.
		// 초기값으로 "Spring", "Python"을 먼저 넣어둔다.
		String[] dest = new String[6]; // 복사할 배열 (대상 배열). 크기는 6이다.
		dest[0] = "Spring"; // dest[0]에 "Spring" 저장
		dest[1] = "Python"; // dest[1]에 "Python" 저장
		// 나머지 dest[2]~dest[5]는 기본값인 null로 채워져 있다.

		// ★★★ 3. 배열 복사 실행! (System.arraycopy() 사용!) ★★★
		// `System.arraycopy(src, 0, dest, 2, 4);`
		// - `src` (원본 배열)에서
		// - `0` (0번째 인덱스, 즉 "Java")부터
		// - `dest` (복사할 배열)로
		// - `2` (2번째 인덱스)부터
		// - `4`개 (총 4개의 요소)를 복사한다!
		// 즉, src의 "Java", "DataBase", "Jsp", "Xml"이
		// dest의 dest[2], dest[3], dest[4], dest[5]에 각각 복사된다!
		System.arraycopy(src, 0, dest, 2, 4);
		
		// --- 복사 결과 확인! (향상된 for 문으로 깔끔하게 출력!) ---
		// 'dest' 배열의 모든 요소를 하나씩 'temp'에 담아서 출력한다.
		System.out.println("--- 복사 후 dest 배열의 값 ---");
		for (String temp : dest) {
			System.out.println("dest value: " + temp); // 각 요소의 값을 출력!
		}
		// 예상 출력 순서:
		// dest value: Spring
		// dest value: Python
		// dest value: Java
		// dest value: DataBase
		// dest value: Jsp
		// dest value: Xml
	}
}
