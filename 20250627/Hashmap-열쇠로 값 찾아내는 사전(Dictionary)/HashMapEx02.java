package com.listex; // 이 코드 파일이 속한 폴더(패키지) 이름이다.

import java.util.*; // 'HashMap', 'Scanner' 같은 유용한 클래스들을 다 가져온다.

public class HashMapEx02 { // 'HashMapEx02'라는 클래스 시작!

	public static void main(String[] args) { // 프로그램의 시작점, 메인 메소드다!
		// HashMap을 만든다. <키, 값> 형태로 <아이디, 비밀번호>를 저장할 거다.
		HashMap<String, String> map = new HashMap<>();
		
		// 미리 몇 개의 아이디와 비밀번호를 HashMap에 저장해둔다.
		map.put("myId", "1234"); // "myId"라는 아이디에 "1234" 비밀번호
		map.put("asdf", "1111"); // "asdf"라는 아이디에 "1111" 비밀번호
		// map.put("asdf", "1234"); // 이 새끼야, 여기 봐라! "asdf"라는 키는 이미 있지?
		                           // 이러면 위의 "1111"은 사라지고 "1234"로 덮어씌워진다.
		                           // HashMap은 키가 중복될 수 없다는 걸 다시 한번 명심해라!
		map.put("asdf", "1234"); // 이전 "asdf":"1111"을 덮어쓰고 "asdf":"1234"가 된다.


		// 사용자 입력을 받기 위한 Scanner 객체를 만든다.
		Scanner sc = new Scanner(System.in);
		
		// 무한 반복 루프! 올바른 아이디/비밀번호를 입력할 때까지 계속 로그인 시도할 거다.
		while(true) { 
			System.out.println("id와 password를 입력해주세요.");
			System.out.print("id:");
			String id = sc.nextLine().trim(); // 사용자가 입력한 아이디를 읽고 앞뒤 공백 제거
			System.out.print("password:");
			String password = sc.nextLine().trim(); // 사용자가 입력한 비밀번호를 읽고 앞뒤 공백 제거
		
			System.out.println(); // 한 줄 띄우기
			
			// ***** 여기부터 중요! 로그인 로직이다! *****
			
			// 1. 입력한 id가 HashMap의 키(등록된 아이디) 중에 있는지 확인한다.
			// map.containsKey(id)는 해당 id가 존재하면 true, 없으면 false를 반환한다.
			// "!map.containsKey(id)"는 "id가 존재하지 않으면" 이라는 뜻이다.
			if(!map.containsKey(id)) { // 만약 입력한 ID가 HashMap에 없다면
				System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
				continue; // 현재 반복을 중단하고 다시 while 루프의 처음으로 돌아간다. (다시 입력받음)
			} 
			
			// 2. id는 존재하는데, 이제 입력한 password가 해당 id의 비밀번호와 일치하는지 확인한다.
			// map.get(id)로 해당 id에 저장된 비밀번호(값)를 가져온다.
			// 가져온 비밀번호와 사용자가 입력한 password가 같은지 equals()로 비교한다.
			// !map.get(id).equals(password)는 "비밀번호가 일치하지 않으면" 이라는 뜻이다.
			// (아까 네 코드에 괄호 하나 빠진 거 고쳤다, 이 새끼야!)
			if(!map.get(id).equals(password)) { 
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해 주세요.");
				// continue; // 여기서는 continue를 안 써도 된다. while 루프의 끝에 도달하면 자연스럽게 다시 시작되니까.
			} else { // id도 있고 비밀번호도 일치하면
				System.out.println("id와 비밀번호가 일치합니다.");
				break; // 무한 루프를 빠져나간다. 로그인 성공!
			}
		
		} // while 루프 끝
		
		sc.close(); // Scanner 다 썼으면 닫아주는 게 예의다.
	} // main 메소드 끝
} // HashMapEx02 클래스 끝
