package com.functionex;

/*
 이름(name), 전화번호(tel), 필드와 생성자 등을 가진 phone 클래스를 작성하고, 아래와 같이 실행되도록 phonebook 클래스를 작성하시오.
검색 search() 

인원수: 3
이름과 전화번호(이름과 번호는 빈칸없이 입력): 가길동 111-1111
이름과 전화번호(이름과 번호는 빈칸없이 입력): 나길동 222-2222
이름과 전화번호(이름과 번호는 빈칸없이 입력): 다길동 333-3333
저장되었습니다.

검색할 이름: 홍길동
홍길동이 없습니다.
검색할 이름: 다길동
다길동의 번호는 333-3333 입니다.
// 그만 을 입력하면 프로그램을 종료
검색할 이름: 그만 
 */


import java.util.*;


public class PhoneBook {

	private Scanner sc;

	private Phone[] p;

	public PhoneBook() {
		sc = new Scanner(System.in);
	}

	public void input() {
		
		System.out.print("인원수: ");
		int n = sc.nextInt();

		p = new Phone[n]; // n명을 저장할 배열을 선언

		for (int i = 0; i < p.length; i++) {
			System.out.print("이름과 전화번호(이름과 번호는 빈칸없이 입력):");
			String name = sc.next();
			String tel = sc.next();
			p[i] = new Phone(name, tel);
		}
		System.out.println("저장되었습니다.");
	}

	public void read() {

	}

	public String search(String name) {

		for (int i = 0; i < p.length; i++) {
			// phone 클래스에 저장된 이름과 내가 검색하고자하는 이름이 같으면
			if (p[i].getName().equals(name)) {
				// 이름으로 검색한 전화번호를 반환
				return p[i].getTel();
			}
		}
		return null;
	}

	public void run() {
		input();

		while (true) {
			System.out.print("검색할 이름: ");
			String name = sc.next();
			if (name.equals("그만")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			String tel = search(name);
			if (tel == null) {
				System.out.println(name + "이 없습니다.");
			} else {
				System.out.println(name + "의 전화번호는 " + tel + " 입니다.");
			}

		}
	}

	public static void main(String[] args) {
		// phoneBook pe = new PhoneBook();
		new PhoneBook().run();
	}
}
