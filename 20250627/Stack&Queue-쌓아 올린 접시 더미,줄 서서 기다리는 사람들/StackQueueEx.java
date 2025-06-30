package com.listex; // 이 코드 파일이 속한 폴더(패키지) 이름이다.

import java.util.*; // 'Stack'과 'Queue' 같은 유용한 클래스들을 다 가져온다.

public class StackQueueEx { // 'StackQueueEx'라는 클래스 시작!

	public static void main(String[] args) { // 프로그램의 시작점, 메인 메소드다!

		// Stack 생성: String 타입의 데이터를 쌓을 스택 'st'를 만든다. (LIFO!)
		Stack<String> st = new Stack<>(); 
		// Queue 생성: String 타입의 데이터를 줄 세울 큐 'q'를 만든다. (FIFO!)
		// Queue는 인터페이스라 LinkedList로 구현체를 만들어준다. 그냥 'Queue 쓸 땐 LinkedList 써라'라고 외워라.
		Queue<String> q = new LinkedList<>(); 
		
		// == Stack에 데이터 넣기 (push) ==
		st.push("0"); // "0"을 스택에 넣는다. (맨 밑)
		st.push("1"); // "1"을 스택에 넣는다. (0 위에)
		st.push("2"); // "2"을 스택에 넣는다. (1 위에, 맨 위)
	
		// == Queue에 데이터 넣기 (offer) ==
		q.offer("0"); // "0"을 큐에 넣는다. (맨 앞)
		q.offer("1"); // "1"을 큐에 넣는다. (0 뒤에)
		q.offer("2"); // "2"을 큐에 넣는다. (1 뒤에, 맨 뒤)
		
		System.out.println("==stack=="); // 스택 결과를 표시할 라벨
		// 스택이 비어있지 않은 동안 계속 반복한다.
		while(!st.empty()) { // st.empty()는 스택이 비었는지 확인하는 메소드다. '!'는 '아니라면' 이라는 뜻.
			System.out.println(st.pop()); // 스택의 맨 위 요소를 꺼내면서 출력한다. (pop은 꺼내면서 삭제!)
		}
		System.out.println(); // 한 줄 띄우기
		
		System.out.println("==q=="); // 큐 결과를 표시할 라벨
		// 큐가 비어있지 않은 동안 계속 반복한다.
		while(!q.isEmpty()) { // q.isEmpty()는 큐가 비었는지 확인하는 메소드다.
			System.out.println(q.poll()); // 큐의 맨 앞 요소를 꺼내면서 출력한다. (poll은 꺼내면서 삭제!)
		}
		
	} // main 메소드 끝
} // StackQueueEx 클래스 끝
