package com.listex; // 이 코드가 속한 패키지다. 대충 파일 위치라고 생각하면 된다.

import java.util.*; // java.util 패키지에 있는 모든 클래스를 불러온다. ArrayList, ListIterator 같은 거 쓰려면 이거 있어야 한다.

public class IteratorEx { // IteratorEx라는 이름의 공개 클래스 선언

	public static void main(String[] args) { // 프로그램 시작점, 메인 메소드다. 여기서부터 코드가 실행된다.
		
		// String 타입의 요소만 담을 수 있는 ArrayList 객체를 생성한다.
		// <> 안에 타입을 명시해서 어떤 데이터만 들어갈지 딱 정해주는 게 좋다. (제네릭이라고 한다, 이 새끼야!)
		ArrayList<String> list = new ArrayList<String>();
		
		// list에 문자열 요소들을 순서대로 추가한다.
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");

		// 현재 list의 전체 내용을 콘솔에 출력한다. [1, 2, 3, 4, 5] 이렇게 나올 거다.
		System.out.println("원본 리스트: " + list);
		
		// ListIterator 객체를 얻어온다.
		// ListIterator는 Iterator의 업그레이드 버전으로, 리스트 요소를 '앞뒤로' 왔다갔다하며 탐색할 수 있다.
		// 처음 ListIterator를 만들면 리스트의 '맨 앞 (0번 인덱스 바로 앞)'을 가리키고 있다. (이 위치가 존나 중요!)
		ListIterator<String> it = list.listIterator();
		
		System.out.print("\n정방향으로 순회 (next()): ");
		// it.hasNext(): 다음에 꺼낼 요소가 있는지 확인한다. 있으면 true, 없으면 false.
		// 현재 커서(위치)는 0번 인덱스 앞에 있으니, 1부터 5까지 쭉 뽑을 수 있다.
		while(it.hasNext()) {
			// it.next(): 다음 요소를 반환하고, 커서를 그 다음 위치로 이동시킨다.
			System.out.print(it.next() + " "); // 1 2 3 4 5 가 출력될 거다.
		}
		System.out.println(); // 줄바꿈

		System.out.print("역방향으로 순회 (previous()): ");
		// 첫 번째 while 루프가 끝난 후, it (ListIterator)의 커서는 리스트의 '맨 뒤 (마지막 요소 5번 뒤)'에 위치한다.
		// it.hasPrevious(): 이전으로 돌아가면 꺼낼 요소가 있는지 확인한다. 있으면 true, 없으면 false.
		// 커서가 맨 뒤에 있으니, 이제 뒤에서부터 앞으로 요소들을 뽑을 수 있다.
		while(it.hasPrevious()) {
			// it.previous(): 이전 요소를 반환하고, 커서를 이전 위치로 이동시킨다.
			System.out.print(it.previous() + " "); // 5 4 3 2 1 이 출력될 거다.
		}
		System.out.println(); // 줄바꿈 (마지막에 깔끔하게)
	}

}
