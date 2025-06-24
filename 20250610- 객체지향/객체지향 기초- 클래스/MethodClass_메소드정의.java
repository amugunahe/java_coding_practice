package com.objectex; // 이 코드는 'com.objectex' 패키지에 있음.

/*
  ★★★ 메소드(Method)란? ★★★
  - 특정 작업을 수행하는 코드 덩어리. 수학의 함수랑 비슷함.
  (예: Math.sqrt(4.0) → 2.0 나옴)
 
  ★★★ 메소드 사용하는 이유 (존나 중요!) ★★★
  1. 높은 ★재사용성★: 한 번 만들면 계속 써먹을 수 있음.
  2. ★중복 코드 제거★: 똑같은 코드 반복해서 안 써도 됨.
  3. 프로그램 ★구조화★: 코드를 기능별로 쪼개서 관리하기 쉬워짐.
 */

public class MethodClass { // 'MethodClass'라는 클래스.

	// 1. 배열을 화면에 출력하는 메서드: `printArr`
	// `static`은 "이 메서드는 클래스 꺼니까, 객체(인스턴스) 안 만들어도 바로 쓸 수 있어!" 라는 뜻.
	// `void`는 "이 메서드는 작업만 하고, 아무 값도 안 돌려줘!" 라는 의미.
	// `int[] numArr`는 "int형 배열 하나를 입력(매개변수)으로 받을 거야!" 라는 뜻.
	static void printArr(int[] numArr) {
		for (int i = 0; i < 10; i++) { // 배열 0번부터 9번 인덱스까지 (총 10개) 반복.
			System.out.print(numArr[i] + " "); // 각 요소 출력하고 한 칸 띄움.
		}
		System.out.println(); // 한 줄 다 출력하면 줄 바꿈.
	}

	// 2. 배열을 랜덤 값으로 초기화하는 메서드: `intiArr` (아마 `initArr` 오타일 거임 ㅋㅋㅋ)
	// 얘도 `static`이고 `void`임. 정수형 배열 받음.
	static void intiArr(int[] numArr) { // (작명 센스 보소... 보통 `initArr`로 쓴다 이기.)
		for (int i = 0; i < 10; i++) {
			// `Math.random()`: 0.0 ~ 1.0 미만의 랜덤 실수 나옴.
			// `* 10`: 0.0 ~ 10.0 미만.
			// `(int)`: 소수점 버리고 0~9 사이의 랜덤 정수 됨.
			numArr[i] = (int)(Math.random() * 10); // 배열 각 칸에 0~9 랜덤 정수 채워 넣음.
		}
	}

	// 3. 메인 메서드: 프로그램 시작점
	public static void main(String[] args) {

		int [] arr = new int[10]; // int 10개 저장할 수 있는 'arr' 배열 만듦.

		// ★★★ 메서드 호출 예시 (메서드 쓰는 이유가 명확히 보임!) ★★★

		// `intiArr` 메서드 호출: `arr` 배열에 랜덤 값 채움.
		intiArr(arr); // 코드 존나 간결해지지?

		// `printArr` 메서드 호출: `arr` 배열 내용 화면에 출력.
		printArr(arr); // 재사용성 봐라 이기! 똑같은 코드 또 안 쓰고 그냥 메서드 이름만 부르면 됨.
		printArr(arr); // 같은 배열 또 출력!
		printArr(arr); // 또 출력! 개꿀!
	}
}
