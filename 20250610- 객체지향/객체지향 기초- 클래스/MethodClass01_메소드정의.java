package com.objectex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  MethodClass01 클래스: **메소드(Method)가 뭔지, 어떻게 만드는지, 왜 쓰는지 존나게 보여주는 예제다!**
 
  핵심:
  - **메소드란?**
  - 특정 작업을 수행하는 일련의 문장들을 하나로 묶은 거다! (수학의 함수랑 존나게 비슷하다!)
  - **메소드 왜 씀?:**
  1. **높은 재사용성:** 한 번 만들어두면 필요할 때마다 존나게 불러 쓸 수 있다! (코드를 복붙할 필요가 없다!)
  2. **중복 코드 제거:** 똑같은 코드를 여러 번 쓰는 대신, 메소드 하나 만들어서 깔끔하게 쓴다!
  3. **프로그램 구조화:** 복잡한 프로그램을 작은 단위로 쪼개서 만들 수 있어서 존나 보기 좋고 관리하기도 편하다!
 
  - **`static` 키워드 (존나 중요!):**
  - `static`이 붙은 메소드나 변수는 **객체를 만들지 않고도 클래스 이름으로 바로 불러 쓸 수 있다!** (예: `Math.random()`, `MethodClass01.printArr()`)
  - 보통 유틸리티 기능(혼자서도 잘 돌아가는 기능)이나 프로그램 시작점(`main` 메소드)에 많이 쓴다!
  - **`Scanner`:** 사용자한테 키보드로 입력받을 때 쓰는 존나 유용한 놈이다!
  - **`Math.random()`:** 0.0부터 1.0 미만의 랜덤한 실수를 반환하는 존나 신기한 메소드다! (숫자 뽑을 때 쓴다!)
 */

import java.util.Scanner; // 사용자로부터 키보드 입력을 받기 위해 Scanner 클래스를 가져옵니다.

public class MethodClass01 { // 'MethodClass01'이라는 이름의 공개(public) 클래스를 정의한다.

	// ★★★ 1. `static` 변수 `sc`: 프로그램 전체에서 **딱 한 번 만들어서 다 같이 쓴다!** ★★★
	// 'static' 키워드는 이 변수가 클래스에 속하며, 'MethodClass01.sc'처럼 객체를 만들지 않고도 바로 사용할 수 있다는 뜻이다.
	// 'Scanner'는 사용자 입력을 읽어들이는 도구다. `sc`라는 이름으로 만들어서 프로그램 전체에서 존나게 재활용한다.
	static Scanner sc = new Scanner(System.in);

	// ★★★ 2. 배열을 출력하는 메소드: `printArr` ★★★
	// 'static'이라 객체 없이 바로 `MethodClass01.printArr()`처럼 부를 수 있다.
	// 'void'는 이 메소드가 어떤 값도 반환하지 않는다는 뜻이다. (그냥 출력만 하고 끝!)
	// 'int[] numArr'는 이 메소드가 '정수형 배열' 하나를 입력(매개변수)으로 받는다는 뜻이다.
	static void printArr(int[] numArr) {
		for (int i = 0; i < 10; i++) { // 배열의 첫 번째 요소부터 열 번째 요소까지 (총 10개) 반복한다.
			System.out.print(numArr[i] + " "); // 각 요소를 출력하고 한 칸 띄운다.
		}
		System.out.println(); // 10개의 요소를 다 출력한 후 줄바꿈을 한다.
	}

	// ★★★ 3. 배열을 초기화하는 메소드: `initArr` ★★★
	// 이 메소드도 'static'이고, 'void' (반환값 없음)이며, '정수형 배열'을 매개변수로 받는다.
	static void initArr(int[] numArr) {

		for (int i = 0; i < 10; i++) { // 배열의 첫 번째 요소부터 열 번째 요소까지 반복한다.
			// `Math.random()`은 0.0 이상 1.0 미만의 랜덤한 실수를 반환한다.
			// 여기에 10을 곱하면 0.0 이상 10.0 미만의 실수가 된다.
			// `(int)`를 붙여 정수로 강제 형변환하면 0부터 9까지의 정수가 된다.
			numArr[i] = (int)(Math.random() * 10); // 배열의 각 요소에 0~9 사이의 랜덤한 정수를 채워 넣는다.
		}
	}

	// ★★★ 4. 메뉴를 보여주고 사용자 선택을 받는 메소드: `showMenu` ★★★
	// 이 메소드는 'int' 값을 반환한다. 즉, 사용자에게 받은 정수(메뉴 선택)를 돌려준다.
	static int showMenu() {
		System.out.print("메뉴선택: "); // "메뉴선택: "이라는 메시지를 출력한다.
		int n = sc.nextInt(); // 사용자가 키보드로 입력한 정수를 읽어서 `n` 변수에 저장한다.
		return n; // 저장된 `n` 값을 메소드를 호출한 곳으로 돌려준다.
	}

	// ★★★ 5. 비어있는 메소드들 (구현 예정): 이거 나중에 채워 넣으면 된다! ★★★
	// 이 메소드들은 현재 아무런 작업도 하지 않지만,
	// 나중에 프로그램 기능이 추가될 때 여기에 코드를 채워 넣을 수 있다.
	// 이렇게 미리 메소드를 정의해두면 프로그램의 전체적인 구조를 미리 설계할 수 있어서 존나 좋다!
	static void inputRecord() {System.out.println("레코드 입력 기능 (미구현)");} // 레코드를 입력하는 기능
	static void updateRecord() {System.out.println("레코드 수정 기능 (미구현)");} // 레코드를 수정하는 기능
	static void deleteRecord() {System.out.println("레코드 삭제 기능 (미구현)");} // 레코드를 삭제하는 기능
	static void listAllRecord() {System.out.println("모든 레코드 목록 보기 기능 (미구현)");} // 모든 레코드를 목록으로 보여주는 기능
	static void searchRecord() {System.out.println("레코드 검색 기능 (미구현)");} // 레코드를 검색하는 기능
	static void printRecord() {System.out.println("레코드 출력 기능 (미구현)");} // 레코드를 출력하는 기능

	// ★★★ 프로그램의 시작점인 `main` 메소드다! ★★★
	public static void main(String[] args) {

		int [] arr = new int[10]; // 10개의 정수를 저장할 수 있는 'arr'이라는 이름의 배열을 만든다.

		// --- 메소드 호출 예시 ---
		// 배열을 초기화하는 메소드 호출
		// ★★★ 니 코드에 'intiArr(arr);'라고 오타가 있었는데, 'initArr(arr);'로 존나게 고쳤다! ★★★
		initArr(arr); // `arr` 배열에 0~9 사이의 랜덤한 숫자 10개를 채워 넣는다.

		// 배열을 출력하는 메소드 호출
		printArr(arr); // `arr` 배열의 내용을 화면에 출력한다. (메소드 재사용!)
		printArr(arr); // 같은 배열을 또 출력한다. (재사용성 존나 좋다!)
		printArr(arr); // 또 출력한다. (재사용성 존나 좋다!)

		// `switch` 문을 이용한 메뉴 처리
		switch (showMenu()){ // `showMenu()` 메소드를 호출하여 사용자로부터 메뉴 선택을 받고, 그 반환값을 `switch` 문으로 처리한다.
		case 1: inputRecord(); // 만약 `showMenu()`가 1을 반환하면 `inputRecord()` 메소드를 호출한다.
				break; // 해당 `case` 실행 후 `switch` 문을 빠져나온다.
		case 2: updateRecord(); // 2를 반환하면 `updateRecord()` 호출
				break;
		case 3: deleteRecord(); // 3을 반환하면 `deleteRecord()` 호출
				break;
		case 4: listAllRecord(); // 4를 반환하면 `listAllRecord()` 호출
				break;
		case 5: searchRecord(); // 5를 반환하면 `searchRecord()` 호출
				break;
		case 6: printRecord(); // 6을 반환하면 `printRecord()` 호출
				break;
		default: System.out.println("잘못된 메뉴 선택이다, 씨발! 다시 해라!"); // 1~6이 아닌 다른 값을 반환하면 이 메시지를 출력한다.
			}
		// 모든 작업이 끝나면 'Scanner' 객체를 닫아준다. (자원 낭비 방지)
		sc.close();
	}
}
