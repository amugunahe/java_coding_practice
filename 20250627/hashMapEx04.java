package com.listex;

import java.util.*;

public class hashMapEx04 {

	static HashMap phoneBook = new HashMap();

	public static void main(String[] args) {
		addPhoneNo("친구", "가길동", "010-1111-1111");
		addPhoneNo("친구", "나길동", "010-2222-2222");
		addPhoneNo("친구", "다길동", "010-3333-3333");
		addPhoneNo("회사동료", "김대리", "010-4444-4444");
		addPhoneNo("회사동료", "김대리", "010-5555-5555");
		addPhoneNo("회사동료", "홍대리", "010-6666-6666");
		addPhoneNo("회사동료", "이과장", "010-7777-7777");
		addPhoneNo("세탁", "010-8888-8888");

		printList();
	}

	// 그룹에 전화번호를 추가하는 메소드
	static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);
		HashMap group = (HashMap) phoneBook.get(groupName);
		group.put(tel, name); // 이름은 중복될 수 있으나 전화번호를 key로 저장함
	}

	// 그룹을 추가하는 메소드
	static void addGroup(String groupName) {
		if (!phoneBook.containsKey(groupName))
			phoneBook.put(groupName, new HashMap());
	}

	// 전화번호 추가 메소드
	static void addPhoneNo(String name, String tel) {
		addPhoneNo("기타", name, tel);
	}

	// 전화번호를 전체 출력하는 메소드
	static void printList() {
		Set set = phoneBook.entrySet();
		Iterator it = set.iterator();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();

			Set subSet = ((HashMap) e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();
			System.out.println("*******" + e.getKey() + "[" + subSet.size() + "]");
			while (subIt.hasNext()) {
				Map.Entry subE = (Map.Entry) subIt.next();
				String telNo = (String) subE.getKey();
				String name = (String) subE.getValue();
				System.out.println(name + " " + telNo);
			}

		}
	}
}
