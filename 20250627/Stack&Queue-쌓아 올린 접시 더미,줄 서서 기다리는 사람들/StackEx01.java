package com.listex; // 이 코드가 속한 폴더(패키지) 이름이다. 대충 파일 정리해놓는 곳이라 생각해라.

import java.util.Stack; // 'Stack' 클래스를 사용하기 위해 가져온다. (LIFO: Last In, First Out 구조! 마지막에 넣은 게 먼저 나온다, 이 말이야!)

/*
  StackEx01 클래스: 자바의 'Stack'을 활용해서 웹 브라우저의 '뒤로 가기'/'앞으로 가기' 기능을 구현하는 예제다.
 
  핵심:
  - **`Stack` (스택) 이란?**
  - 데이터를 차곡차곡 쌓아 올리는(push) 구조다. 제일 나중에 넣은 데이터가 제일 먼저 나온다(pop). (LIFO: Last In, First Out)
  - 웹 브라우저의 '뒤로 가기'/'앞으로 가기' 이력을 저장하는 데 아주 적합하다!
 
  - **`back` 스택:**
  - 현재 보고 있는 페이지를 포함해서 **이전에 방문했던 페이지들**을 저장한다.
  - 스택의 맨 위(`back.peek()`)가 현재 보고 있는 페이지라고 생각하면 된다.
  - **`forward` 스택:**
  - '뒤로 가기'를 했을 때, **다시 '앞으로 갈 수 있는' 페이지들**을 저장한다.
 
  - **주요 `Stack` 메소드 (이것만 알면 된다!):**
  - `push(요소)`: 스택의 맨 위에 요소를 추가한다. (위에 쌓는 거지!)
  - `pop()`: 스택의 맨 위 요소를 꺼내면서 삭제한다. (맨 위 놈 빼는 거다! 스택이 비어있으면 `EmptyStackException`이라는 에러가 터진다!)
  - `peek()`: 스택의 맨 위 요소를 **삭제하지 않고** 그냥 확인만 한다. (누가 맨 위에 있나 눈팅만 하는 거지! 이것도 비어있으면 에러난다!)
  - `empty()`: 스택이 비어있는지 `true`/`false`로 반환한다. (비어있냐? 안 비어있냐? 확인용!)
  - `clear()`: 스택의 모든 요소를 싹 다 삭제한다. (스택 초기화!)
 
  ★★★ 이전 코드의 문제점 및 수정 사항 (이거 존나 중요하다!): ★★★
  1.  **`goBack()` 메소드 오류:**
  - 원본: `back.push(forward.pop());`
  - 문제: `goBack()`을 처음 호출할 때 `forward` 스택은 비어있을 수 있다! `empty()` 체크 없이 `forward.pop()`을 호출하면 `EmptyStackException`이 터진다! (빈 통에서 뭘 꺼내려고 하면 당연히 에러나지, 이 새끼야!)
  - **수정:** '현재 페이지'를 `back` 스택에서 꺼내서 `forward` 스택에 넣고, `back` 스택의 이전 페이지를 '새로운 현재 페이지'로 만든다. `back` 스택에 최소 2개 이상의 페이지가 있어야 뒤로 갈 수 있다는 걸 명심해라!
  2.  **`goFoward()` 메소드 오류:**
  - 원본: `forward.push(back.pop());`
  - 문제: `goFoward()`는 `forward` 스택에서 페이지를 꺼내서 `back` 스택으로 옮겨야 한다. `back`에서 꺼내면 안 된다! (앞으로 가는데 왜 뒤에 있던 걸 꺼내냐고, 병신아!)
  - **수정:** `forward` 스택에서 페이지를 꺼내서 `back` 스택에 넣는다.
  3.  **`peek()` 사용 시 스택 비어있는지 체크:** `System.out.println("현재 화면은 " + back.peek() + "입니다.");` 이 부분도 `back` 스택이 비어있으면 에러가 터진다! 이걸 방지하기 위해 `back.empty()` 체크를 추가했다. (빈 깡통인데 뭘 보려고 하냐!)
 */

public class StackEx01 {
	// 'back' 스택: 이전 방문 페이지들을 저장하는 곳이다. (맨 위가 현재 보고 있는 페이지!)
	public static Stack back = new Stack();
	// 'forward' 스택: '뒤로 가기' 눌렀을 때 다시 '앞으로 갈 수 있는' 페이지들을 저장하는 곳이다.
	public static Stack forward = new Stack();
	
	// ★★★ 메인 메소드: 프로그램의 시작점이다! 여기서부터 코드가 실행된다! ★★★
	public static void main(String[] args) {
		System.out.println("--- StackEx01 프로그램 시작! ---");

		// 1. URL 방문 기록 쌓기
		System.out.println("★URL 방문★");
		goURL("1.구글"); // 구글 방문! back에 쌓인다.
		goURL("2.야후"); // 야후 방문! back에 쌓인다.
		goURL("3.네이버"); // 네이버 방문! back에 쌓인다.
		goURL("4.다음"); // 다음 방문! 현재 페이지: 4.다음
		
		printStatus(); // 현재 스택 상태를 출력해서 눈으로 확인해라.
		
		// 2. '뒤로 가기' 기능 테스트
		System.out.println("★뒤로 가기 버튼을 누른 후 (1)★");
		goBack(); // 4.다음 페이지를 forward로 옮기고, 현재 페이지는 3.네이버가 된다.
		printStatus();
		
		System.out.println("★뒤로 가기 버튼을 누른 후 (2)★");
		goBack(); // 3.네이버 페이지를 forward로 옮기고, 현재 페이지는 2.야후가 된다.
		printStatus();
		
		// 3. '앞으로 가기' 기능 테스트
		System.out.println("★앞으로 가기 버튼을 누른 후 (1)★");
		goFoward(); // forward에 있던 3.네이버를 다시 back으로 옮겨서 현재 페이지는 3.네이버가 된다.
		printStatus();

		System.out.println("★새로운 URL 방문 (앞으로 가기 기록 삭제)★");
		goURL("5.네이트"); // 새로운 URL 방문하면 forward에 있던 모든 기록은 싹 다 날아간다! 중요!
		printStatus();

		System.out.println("★뒤로 가기 버튼을 누른 후 (3)★");
		goBack(); // 5.네이트 -> forward, 현재 3.네이버
		printStatus();

		System.out.println("★더 이상 뒤로 갈 수 없을 때★");
		goBack(); // 3.네이버 -> forward, 현재 2.야후
		printStatus();
		goBack(); // 2.야후 -> forward, 현재 1.구글
		printStatus();
		goBack(); // 1.구글 -> forward (더 이상 back에 페이지 없으므로 뒤로 못 감!)
		printStatus(); // 여기서 더 이상 뒤로 못 간다는 메시지가 출력된다.
		goBack(); // 다시 호출해도 똑같은 메시지 나온다.
		printStatus();

		System.out.println("\n--- StackEx01 프로그램 종료! ---");
	}
	
	// ★★★ 현재 'back' 스택과 'forward' 스택의 상태를 출력하는 메소드다! ★★★
	public static void printStatus() {
		System.out.println("back (방문 이력): " + back); // back 스택 내용 출력
		System.out.println("forward (앞으로 갈 수 있는 이력): " + forward); // forward 스택 내용 출력
		
		// 'back' 스택이 비어있지 않을 때만 현재 화면을 출력한다. (에러 안 나게 하려고!)
		if (!back.empty()) {
			System.out.println("현재 화면은 " + back.peek() + "입니다."); // peek()으로 맨 위만 본다.
		} else {
			System.out.println("현재 표시할 화면이 없습니다. (back 스택이 비어있음)");
		}
		System.out.println(); // 한 줄 띄우기
	}
	
	// ★★★ 새로운 URL을 방문할 때 호출하는 메소드다! ★★★
	public static void goURL(String url) {
		back.push(url); // 새로운 URL을 'back' 스택의 맨 위에 추가한다. (이게 현재 페이지가 된다!)
		if(!forward.empty()) { // 새로운 페이지를 방문하면 '앞으로 가기' 기록은 모두 싹 다 사라진다! 중요!
			forward.clear(); // forward 스택을 비운다.
		}
	}
	
	// ★★★ '뒤로 가기' 버튼을 눌렀을 때 호출하는 메소드다! ★★★
	public static void goBack() {
		// 'back' 스택에 현재 페이지와 그 이전 페이지 (최소 2개)가 있어야 뒤로 갈 수 있다!
		if (back.size() > 1) { // back 스택에 최소 2개 이상의 요소가 있는지 확인한다.
			String currentPage = (String) back.pop(); // 현재 페이지를 'back' 스택에서 꺼낸다.
			forward.push(currentPage); // 꺼낸 현재 페이지를 'forward' 스택에 넣어서 '앞으로 갈 수 있는' 기록으로 남긴다.
		} else {
			System.out.println("더 이상 뒤로 갈 페이지가 없습니다!"); // 뒤로 갈 페이지가 없으면 이 메시지 띄운다.
		}
	}
	
	// ★★★ '앞으로 가기' 버튼을 눌렀을 때 호출하는 메소드다! ★★★
	public static void goFoward() {
		// 'forward' 스택에 페이지가 있어야 앞으로 갈 수 있다!
		if (!forward.empty()) { // forward 스택이 비어있지 않은지 확인한다.
			String nextPage = (String) forward.pop(); // 'forward' 스택에서 가장 최근 '앞으로 갈 수 있는' 페이지를 꺼낸다.
			back.push(nextPage); // 꺼낸 페이지를 'back' 스택에 넣어서 '현재 페이지'로 만든다.
		} else {
			System.out.println("더 이상 앞으로 갈 페이지가 없습니다!"); // 앞으로 갈 페이지가 없으면 이 메시지 띄운다.
		}
	}

}
