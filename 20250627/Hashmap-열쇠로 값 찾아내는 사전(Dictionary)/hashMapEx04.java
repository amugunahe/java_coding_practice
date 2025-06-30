package com.listex; // 이 코드 파일이 속한 폴더(패키지) 이름이다.

import java.util.*; // 'HashMap', 'Set', 'Iterator', 'Map.Entry' 같은 클래스들을 다 가져온다.

public class HashMapEx04 { // 'HashMapEx04'라는 클래스 시작!

	// 전화번호부 전체를 담는 HashMap이다.
	// Map의 키는 String(그룹 이름), 값은 또 다른 HashMap이다.
	// 이 내부 HashMap은 다시 String(전화번호)을 키로, String(이름)을 값으로 가진다.
	static HashMap<String, HashMap<String, String>> phoneBook = new HashMap<>();

	public static void main(String[] args) { // 프로그램의 시작점, 메인 메소드다!
		// 전화번호 추가 예시들이다. addPhoneNo 메소드를 호출한다.
		addPhoneNo("친구", "가길동", "010-1111-1111");
		addPhoneNo("친구", "나길동", "010-2222-2222");
		addPhoneNo("친구", "다길동", "010-3333-3333");
		addPhoneNo("회사동료", "김대리", "010-4444-4444");
		// 김대리가 다른 번호로 또 추가된다. (전화번호가 다르므로 새로운 엔트리로 추가된다!)
		addPhoneNo("회사동료", "김대리", "010-5555-5555"); 
		addPhoneNo("회사동료", "홍대리", "010-6666-6666");
		addPhoneNo("회사동료", "이과장", "010-7777-7777");
		// 이 메소드는 아래에 정의된 오버로딩된 addPhoneNo(String name, String tel)을 호출한다.
		// "기타" 그룹에 "세탁"이라는 이름과 "010-8888-8888" 전화번호로 추가된다.
		addPhoneNo("세탁", "010-8888-8888"); 

		printList(); // 모든 전화번호부 내용을 출력하는 메소드를 호출한다.
	}

	/*
	  지정된 그룹에 사람의 이름과 전화번호를 추가하는 메소드다, 이 새끼야!
	  만약 그룹이 없으면 새로 만들어준다.
	  * @param groupName 그룹 이름 (예: "친구", "회사동료")
	  @param name 사람 이름 (예: "가길동", "김대리")
	  @param tel 전화번호 (예: "010-1111-1111") - 이게 내부 HashMap의 키가 된다!
	 */
	static void addPhoneNo(String groupName, String name, String tel) {
		// 먼저 addGroup 메소드를 호출해서 해당 groupName이 phoneBook에 있는지 확인한다.
		// 없으면 새 HashMap을 만들어서 추가해주고, 있으면 아무것도 안 한다.
		addGroup(groupName); 
		
		// phoneBook에서 groupName에 해당하는 HashMap(그룹)을 가져온다.
		// 이 HashMap은 해당 그룹의 전화번호들을 관리한다.
		HashMap<String, String> group = phoneBook.get(groupName);
		
		// 가져온 'group' HashMap에 전화번호(tel)를 키로, 이름(name)을 값으로 저장한다.
		// 여기서 기억할 건, 'tel'이 키이기 때문에 같은 전화번호로 또 추가하면 기존 값(이름)이 덮어씌워진다!
		group.put(tel, name); 
	}

	/*
	  전화번호부에 새로운 그룹을 추가하는 메소드다.
	  이미 존재하는 그룹이면 무시한다.
	  @param groupName 추가할 그룹 이름 (예: "가족")
	 */
	static void addGroup(String groupName) {
		// phoneBook에 해당 groupName이라는 키가 이미 있는지 확인한다.
		// '!'는 "없다면" 이라는 뜻이다.
		if (!phoneBook.containsKey(groupName)) {
			// 그룹이 없다면, 새로운 HashMap<String, String>을 만들어서 groupName을 키로 하여 phoneBook에 추가한다.
			// 이 새로운 HashMap이 나중에 해당 그룹의 연락처들을 담을 그릇이 된다.
			phoneBook.put(groupName, new HashMap<String, String>());
		}
	}

	/*
	  그룹을 지정하지 않고 전화번호를 추가할 때 사용하는 메소드 (오버로딩)다.
	  기본적으로 "기타" 그룹으로 추가한다.
	  @param name 사람 이름
	  @param tel 전화번호
	 */
	static void addPhoneNo(String name, String tel) {
		// 실제 작업은 위에 정의된 addPhoneNo(String groupName, String name, String tel) 메소드에게 넘긴다.
		// 그룹 이름은 "기타"로 고정시킨다.
		addPhoneNo("기타", name, tel);
	}

	/*
	  전화번호부의 모든 연락처를 그룹별로 분류해서 출력하는 메소드다
	 */
	static void printList() {
		// phoneBook (가장 큰 HashMap)의 모든 "엔트리" (키-값 쌍)를 Set 형태로 가져온다.
		// 여기서 각 엔트리는 (그룹 이름, 해당 그룹의 HashMap) 형태다.
		Set<Map.Entry<String, HashMap<String, String>>> entrySet = phoneBook.entrySet();
		Iterator<Map.Entry<String, HashMap<String, String>>> it = entrySet.iterator();

		// 외부 HashMap(phoneBook, 즉 그룹들)을 하나씩 돌면서 처리한다.
		while (it.hasNext()) {
			// 다음 엔트리 (그룹 이름과 그 그룹의 HashMap)를 가져온다.
			Map.Entry<String, HashMap<String, String>> entry = it.next();

			// 현재 그룹의 HashMap을 가져온다. (전화번호 - 이름 쌍을 담고 있다.)
			HashMap<String, String> groupMap = entry.getValue();
			
			// 현재 그룹 HashMap의 모든 엔트리 (전화번호-이름 쌍)를 Set 형태로 가져온다.
			Set<Map.Entry<String, String>> subEntrySet = groupMap.entrySet();
			Iterator<Map.Entry<String, String>> subIt = subEntrySet.iterator();
			
			// 그룹 이름과 해당 그룹에 몇 명의 연락처가 있는지 개수를 출력한다.
			System.out.println("*******" + entry.getKey() + "[" + subEntrySet.size() + "]");
			
			// 이제 내부 HashMap(각 그룹)을 돌면서 전화번호와 이름을 출력한다.
			while (subIt.hasNext()) {
				// 다음 서브 엔트리 (전화번호와 이름)를 가져온다.
				Map.Entry<String, String> subEntry = subIt.next();
				String telNo = subEntry.getKey();   // 전화번호는 키
				String name = subEntry.getValue(); // 이름은 값
				System.out.println(name + " " + telNo); // "이름 전화번호" 형식으로 출력
			}
			System.out.println(); // 각 그룹 출력이 끝나면 한 줄 띄워서 보기 좋게 한다.
		}
	}
}
