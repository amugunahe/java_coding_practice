package com.listex; // 이 코드가 속한 패키지다. 대충 파일 정리하는 곳이라고 보면 된다.

import java.util.*; // java.util 패키지에 있는 모든 클래스를 불러온다. LinkedList, List 같은 거 쓰려면 이거 있어야 한다.

public class LinkedListEx { // LinkedListEx라는 이름의 공개 클래스 선언

	// 상수로 String 배열을 선언했다. final은 "바꾸지 마라!"는 뜻이다.
	private static final String color1[] = { "검정", "노랑", "녹색", "파랑", "주황", "연두" };
	private static final String color2[] = { "초록", "빨강", "흰색", "남색", "보라" };

	// 생성자다. 이 클래스로 객체를 만들면 여기 있는 코드가 자동으로 실행된다.
	public LinkedListEx() {
		// String 타입만 담을 수 있는 LinkedList 객체 두 개를 만든다.
		// LinkedList는 ArrayList랑 다르게 '링크'로 연결된 구조다. 삽입/삭제가 빠르고, 검색은 좀 느리다.
		List<String> list1 = new LinkedList<>(); // List는 인터페이스고, LinkedList가 실제 구현체다.
		List<String> list2 = new LinkedList<>(); // 이 새끼는 나중에 비어 있을 거다. 잘 봐라.

		// color1 배열의 요소들을 list1에 차례대로 추가한다.
		for (String color : color1) {
			list1.add(color);
		}
		
		// !!! 중요 !!!
		// 여기서는 color2 배열의 요소들을 list2에 넣는 게 아니라, 또 다시 list1에 추가하고 있다.
		// 그래서 list1은 color1 + color2의 모든 색깔을 순서대로 가지게 된다.
		// 반면에 list2는 이 시점에도 여전히 비어 있다! (의도한 건지, 실수한 건지 확인해봐라, 이 새끼야!)
		for (String color : color2) {
			list1.add(color);
		}

		// list1에 list2의 모든 요소를 추가한다.
		// 근데 위에서 list2에 아무것도 안 넣었기 때문에, 이 코드는 사실상 아무것도 안 하는 셈이다.
		// list2가 비어있으니 list1에 추가될 게 없다는 말이다!
		list1.addAll(list2);

		// list2 변수가 참조하던 객체를 버리는 거다. 이제 list2는 null을 가리킨다.
		// 메모리 정리될 때 알아서 사라질 거다. (가비지 컬렉션 대상이 된다.)
		list2 = null;

		// list1의 내용을 출력하는 메소드를 호출한다.
		printList(list1);
		
		System.out.print("\nDeleting element 4 to 6"); // 삭제할 범위 알려주는 메시지 출력
		// list1에서 4번 인덱스부터 7번 인덱스 '전'까지의 요소들을 삭제하는 메소드를 호출한다.
		// (4, 5, 6번 인덱스 요소가 삭제된다는 뜻이다. end는 포함 안 된다!)
		removeList(list1, 4, 7); 
		printList(list1); // 삭제 후 list1의 내용을 다시 출력한다.

		// list1의 내용을 역순으로 출력하는 메소드를 호출한다.
		printReversedList(list1);
		
	}

	// 리스트의 내용을 출력하는 메소드다.
	public void printList(List<String> list) {
		System.out.print("\nlist:"); // 출력 전에 "list:"라고 붙여준다.
		// 향상된 for 루프를 사용해서 리스트의 모든 요소를 순서대로 돌면서 출력한다.
		for (String color : list) {
			System.out.printf("%s ", color); // 각 요소를 공백으로 구분해서 출력한다.
		}
		System.out.println(); // 출력 후 줄바꿈
	}

	// 리스트에서 특정 범위의 요소들을 제거하는 메소드다.
	// static으로 선언되어서 객체 생성 없이 바로 클래스 이름으로 호출할 수 있다.
	public static void removeList(List<String> list, int start, int end) {
		// list.subList(start, end)는 리스트의 특정 범위(start부터 end-1까지)를 '부분 리스트'로 반환한다.
		// 이 부분 리스트에 .clear()를 호출하면 원본 리스트에서 해당 범위의 요소들이 싹 다 지워진다.
		// 존나 유용한 기능이니까 기억해둬라!
		list.subList(start, end).clear();
	}

	// 리스트의 내용을 역순으로 출력하는 메소드다.
	// 얘도 static이라 바로 클래스 이름으로 호출 가능.
	public static void printReversedList(List<String> list) {

		// ListIterator를 리스트의 '맨 뒤 (list.size() 위치)'에서 시작하도록 만든다.
		// list.size()는 리스트 요소의 개수를 반환한다. 예를 들어 5개면 5를 반환.
		// ListIterator에 5를 넘기면 5번 인덱스 '뒤'를 가리키게 된다.
		ListIterator<String> it = list.listIterator(list.size());

		System.out.print("\nReversed List:"); // 역순 출력 시작 메시지
		// it.hasPrevious(): 이전에 꺼낼 요소가 있는지 확인한다. (커서가 뒤로 갈 수 있는지)
		// 맨 뒤에서 시작했으니 이제 앞으로 쭉쭉 뽑아먹을 수 있다.
		while (it.hasPrevious()) {
			// it.previous(): 이전 요소를 반환하고, 커서를 그 이전 위치로 이동시킨다.
			System.out.printf("%s ", it.previous()); // 이전 요소를 뽑아서 출력한다.
		}
	}

	// 메인 메소드다. 프로그램이 여기서 시작된다.
	public static void main(String[] args) {
		// LinkedListEx 클래스의 새 객체를 생성한다.
		// 객체를 생성하면 위에서 설명한 LinkedListEx() 생성자가 자동으로 호출된다.
		// 별도의 변수에 담지 않고 바로 생성만 한다.
		new LinkedListEx();
	}
	
}
