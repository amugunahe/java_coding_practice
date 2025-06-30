package com.listex; // 이 코드가 속한 패키지다. 대충 파일 폴더라고 생각하면 된다.

import java.util.*; // java.util 패키지에 있는 모든 클래스를 다 불러온다. TreeSet이랑 Set 쓰려면 이거 필수다.

public class TreeSetLotto { // TreeSetLotto라는 이름의 공개 클래스 선언

	public static void main(String[] args) { // 프로그램 시작점, 여기서부터 코드가 실행된다.
		// Set 인터페이스 타입으로 TreeSet 객체를 생성한다.
		// TreeSet은 데이터를 '자동으로 정렬'(오름차순)해서 저장하고, '중복을 허용하지 않는' 컬렉션이다.
		// 로또 번호처럼 중복 없이 순서대로 뽑아야 할 때 존나 유용하다!
		Set set = new TreeSet(); 

		// for 루프를 돌면서 로또 번호 6개를 뽑는다.
		// set.size()가 6보다 작을 때까지 루프를 돌린다.
		// 중복된 번호가 나오면 set.add() 메소드가 알아서 거르기 때문에, 
		// 유니크한 번호가 6개 채워질 때까지 무한정 돌리는 거다, 이 새끼야!
		for (int i = 0; set.size() < 6; i++) { 
			// 1부터 45 사이의 난수(랜덤 숫자)를 생성한다.
			// Math.random()은 0.0 이상 1.0 미만의 double 값을 반환한다.
			// 여기에 45를 곱하면 0.0 이상 45.0 미만이 되고, 
			// int로 형변환하면 0부터 44까지의 정수가 된다.
			// 마지막에 + 1을 해서 1부터 45까지의 숫자를 만든다. (로또 번호는 1부터 시작하니까!)
			int num = (int) (Math.random() * 45) + 1;
			
			// 생성된 난수를 TreeSet에 추가한다.
			// TreeSet은 알아서 중복을 걸러주고, 숫자를 오름차순으로 정렬해서 저장한다.
			set.add(num); 
		}
		
		// 6개의 로또 번호가 담긴 TreeSet을 출력한다.
		// 이미 TreeSet 안에서 자동으로 정렬되어 있기 때문에, 번호가 작은 순서대로 나온다. (개꿀!)
		System.out.println(set);

		/*
		  아래 주석 처리된 코드는 만약 TreeSet 대신 중복을 허용하는 Set (예: HashSet)을 썼다면 
		  나중에 번호를 정렬하기 위해 LinkedList로 옮겨서 Collections.sort()를 써야 했을 거다.
		  하지만 우리는 'TreeSet'을 썼기 때문에, 애초에 알아서 정렬되므로 굳이 이딴 코드 필요 없다, 이 말이지!
		  *  List<Integer> list = new LinkedList<>(set); // Set의 요소들을 LinkedList로 옮긴다.
		   Collections.sort(list); // LinkedList에 담긴 숫자들을 오름차순으로 정렬한다.
		   System.out.println(list); // 정렬된 리스트를 출력한다.
		 */
	}

}
