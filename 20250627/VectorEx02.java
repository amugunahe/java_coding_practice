package com.listex;

import java.util.*;

public class VectorEx02 { 

	// 이 배열은 초기값으로 쓸 색깔들을 모아놓은 거다. 딱 정해진 값이라 final 붙여놓은 거 봐라.
	private static final String colors[] = { "검정", "노랑", "녹색", "파랑", "주황", "연두" };

	public static void main(String[] args) {

		// Vector 객체를 만든다. <String>은 여기에 문자열만 넣겠다는 뜻이다.
		Vector<String> v = new Vector<>();

		// colors 배열에 있는 색깔들을 Vector에 하나씩 넣는다.
		for (String str : colors) {
			v.add(str); // add() : Vector의 맨 뒤에 요소를 추가한다.
		}
		System.out.println(v); // Vector 전체 내용을 출력. [검정, 노랑, 녹색, 파랑, 주황, 연두] 이렇게 나온다.
		System.out.println("요소 개수: " + v.size()); // size() : Vector에 몇 개 들어있는지 알려준다. 6개 나오겠지?
		System.out.println(); // 그냥 한 줄 띄우는 거.

		System.out.println("첫번째 요소: " + v.firstElement()); // firstElement() : 첫 번째 요소를 가져온다. "검정" 나온다.
		System.out.println("네번째 요소: " + v.get(3)); // get(인덱스) : 특정 위치(인덱스)의 요소를 가져온다. 인덱스는 0부터 시작하니까 3은 네 번째다. "파랑" 나온다.
		System.out.println("마지막 요소: " + v.lastElement()); // lastElement() : 마지막 요소를 가져온다. "연두" 나온다.

		// 첫번째 요소를 "흰색"으로 변경
		v.set(0, "흰색"); // set(인덱스, 새 값) : 특정 위치의 요소를 새로운 값으로 바꾼다. 첫 번째(인덱스 0)를 "흰색"으로 바꿈.
		System.out.println("첫번째 요소: " + v.firstElement()); // "흰색" 나오겠지?
		System.out.println("요소 개수: " + v.size()); // 여전히 6개. 바뀐 거지 추가된 게 아니니까.

		// 첫번째 요소에 빨강 추가 (기존 요소들은 뒤로 밀린다)
		v.insertElementAt("빨강", 0); // insertElementAt(새 값, 인덱스) : 특정 위치에 새로운 요소를 끼워넣는다. 0번째에 "빨강" 넣으니 "흰색"은 1번째로 밀려남.
		System.out.println("첫번째 요소: " + v.firstElement()); // "빨강" 나온다.
		System.out.println("요소 개수: " + v.size()); // 이제 7개로 늘어났다. 추가했으니까.

		// 전체 출력
		System.out.println("\n 전체 출력"); // 한 줄 띄우고 출력 문구.
		for (String str : v) { // Vector 안의 모든 요소를 하나씩 꺼내서 str에 넣고 반복한다.
			System.out.print(str + " "); // 각 요소를 출력하고 한 칸 띄운다.
		}
		System.out.println(); // 줄 바꿈.

		// 오름차순 정렬 (알파벳/가나다 순으로 정렬된다)
		Collections.sort(v); // Collections 클래스의 sort() 메소드를 이용해서 Vector v를 정렬한다. **이거 존나 중요하다.**
		System.out.println("\n오름차순 정렬후 출력");
		for (String str : v) {
			System.out.print(str + " ");
		}
		System.out.println();

		// 검색: 오름차순 정렬된 자료에서만 검색을 할 수 있음 (매우 중요! 이 부분 틀린 거다!)
		// 여기 주석은 반만 맞다. binarySearch는 "정렬된" 리스트에서만 쓸 수 있다는 게 존나 중요하다.
		// 만약 정렬 안 된 리스트에 이거 쓰면 결과 이상하게 나온다.
		int index = Collections.binarySearch(v, "보라"); // binarySearch(리스트, 찾을 값) : 리스트에서 "보라"를 찾는다.

		// 검색하고자 하는 자료가 없을 경우 음수 출력 (이것도 중요!)
		System.out.println("\n보라: " + index + "에 위치"); // "보라"는 없으니 음수(예: -4)가 나올 거다.

		// 내림 차순 정렬 (오름차순의 반대)
		Collections.sort(v, Collections.reverseOrder()); // Collections.reverseOrder()를 같이 쓰면 내림차순으로 정렬된다. 이것도 외워라.
		System.out.println("\n내림차순 정렬후 출력");
		for (String str : v) {
			System.out.print(str + " ");
		}
		System.out.println();

		// 내림 차순 검색 (binarySearch 쓸 때 내림차순이면 정렬 기준도 같이 줘야 한다)
		index = Collections.binarySearch(v, "파랑", Collections.reverseOrder()); // 내림차순으로 정렬된 리스트에서 파랑을 찾을 때도, 정렬 기준을 같이 넣어줘야 정확하게 찾는다.
		System.out.println("\n파랑: " + index + "에 위치"); // 파랑의 인덱스가 나온다.

		// 검색 (이건 그냥 앞에서부터 하나씩 다 찾아보는 방식이다. 정렬 여부 상관 없음)
		String s = "노랑";
		if (v.contains(s)) { // contains(값) : 리스트에 그 값이 있는지 없는지 true/false로 알려준다.
			int i = v.indexOf(s) + 1; // indexOf(값) : 그 값이 몇 번째 인덱스에 있는지 알려준다. 없으면 -1 반환. +1 하는 건 인덱스가 0부터 시작하니까 사람 기준으로 첫 번째부터 세려고 한 듯.
			System.out.println(s + "--> 위치:" + i);
		}
		// 삭제
		v.remove(0); // remove(인덱스) : 해당 인덱스의 요소를 삭제한다. 0번째(빨강)가 사라진다.
		v.remove("파랑"); // remove(값) : 특정 값을 가진 요소를 삭제한다. "파랑"이 사라진다. 만약 같은 값이 여러 개 있으면 맨 앞에 있는 하나만 사라진다.
	}
}
