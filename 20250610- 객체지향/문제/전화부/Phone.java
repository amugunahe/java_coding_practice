package com.functionex; // 'com.functionex'는 이 자바 파일(클래스)이 속한 패키지 이름이다.
                         // 패키지는 관련 클래스들을 묶어서 관리하는 폴더 같은 역할을 한다.
                         // 나중에 이 클래스를 사용할 때 'import com.functionex.Phone;'처럼 가져올 수 있다, 씨발!

/*
  Phone 클래스: **하나의 '전화번호 정보'를 존나게 깔끔하게 나타내는 설계도다!**
 
  핵심:
  - **목표:** 이름이랑 전화번호를 묶어서 관리하기 위한 틀을 제공한다.
  - **데이터 덩어리:** 연락처 앱에서 한 사람의 정보를 저장할 때 이 'Phone' 클래스의 객체를 만들어서 존나게 사용할 수 있다.
  - **필드 (`name`, `tel`):**
  - `name`: 전화번호 주인의 이름.
  - `tel`: 전화번호 자체. (숫자만 있어도 문자열로 저장하는 게 존나 편하다! 하이픈(-) 같은 문자도 들어갈 수 있으니까!)
  - **생성자:** `Phone` 객체를 만들 때(`new Phone(...)`) 이름과 전화번호를 바로 초기화할 수 있게 해준다!
  - **Getter 메소드 (`getName()`, `getTel()`):**
  - `private`으로 선언된 필드들(`name`, `tel`)의 값을 외부에서 읽어갈 수 있도록 해주는 메소드다.
  - 직접 변수에 접근하는 대신 메소드를 통해 접근하게 함으로써 데이터를 존나게 안전하게 관리할 수 있다! (캡슐화! 존나 중요!)
 */

public class Phone { // 'Phone'이라는 이름의 공개(public) 클래스를 선언한다.
                     // 이 클래스는 '전화번호 정보' 객체를 만들기 위한 '설계도' 또는 '틀'이다.

    // --- 멤버 변수 (필드) ---
    // 이들은 'Phone' 클래스로 만들어지는 각각의 객체가 가질 고유한 정보들을 저장하는 공간이다.
    // 'private' 접근 제어자는 이 변수들이 'Phone' 클래스 내부에서만 직접 접근 가능하도록 하여 데이터를 존나게 안전하게 보호한다.
	private String name; // 전화번호의 주인이 되는 '이름'을 저장할 문자열(String) 변수다.
	private String tel;  // '전화번호' 자체를 저장할 문자열(String) 변수다.

    // --- 생성자(Constructor) ---
    // 'Phone' 클래스의 생성자다.
    // 'Phone' 객체(예: 'Phone p = new Phone("홍길동", "010-1234-5678");'와 같이)가 생성될 때 자동으로 호출되며,
    // 객체가 만들어질 때 이름과 전화번호를 초기화하는 역할을 한다.
	public Phone(String name, String tel) { // 'Phone' 객체를 만들 때, 'name'과 'tel' 두 개의 문자열 값을 매개변수로 받는다.
		this.name = name; // 전달받은 'name' 매개변수 값을 현재 'Phone' 객체의 'name' 멤버 변수(필드)에 할당한다.
                          // 'this.name'은 이 객체 자신의 'name' 변수를 의미한다. (존나 중요!)
		this.tel = tel;   // 전달받은 'tel' 매개변수 값을 현재 'Phone' 객체의 'tel' 멤버 변수(필드)에 할당한다.
	}

    // --- Getter 메소드 ---
    // 'private'으로 선언된 멤버 변수('name'과 'tel')의 값을 외부에서 읽어갈 수 있도록 해주는 메소드들이다.
    // 직접 변수에 접근하는 대신 메소드를 통해 접근하게 함으로써 데이터를 존나게 안전하게 관리할 수 있다!
	public String getName() { // 이 메소드는 'name' 필드(이름)의 값을 문자열(String) 타입으로 반환한다.
		return name; // 현재 'Phone' 객체의 'name' 값을 반환한다.
	}

	public String getTel() { // 이 메소드는 'tel' 필드(전화번호)의 값을 문자열(String) 타입으로 반환한다.
		return tel; // 현재 'Phone' 객체의 'tel' 값을 반환한다.
	}

    // --- 메인 메소드(main method): 프로그램의 시작점 (테스트용) ---
    // 이 'Phone' 클래스를 어떻게 사용하는지 보여주기 위한 간단한 테스트 코드다!
    public static void main(String[] args) {
        System.out.println("--- Phone 클래스 테스트 시작! ---");

        // 'Phone' 객체 p1 생성: "철수"의 전화번호 "010-1111-2222"를 가진다.
        Phone p1 = new Phone("철수", "010-1111-2222");

        // 'Getter' 메소드를 사용해서 p1 객체의 이름과 전화번호를 존나게 가져와 출력한다.
        System.out.println("이름: " + p1.getName() + ", 전화번호: " + p1.getTel());

        // 'Phone' 객체 p2 생성: "영희"의 전화번호 "010-3333-4444"를 가진다.
        Phone p2 = new Phone("영희", "010-3333-4444");

        // p2 객체의 이름과 전화번호를 가져와 출력한다.
        System.out.println("이름: " + p2.getName() + ", 전화번호: " + p2.getTel());

        System.out.println("--- Phone 클래스 테스트 종료! ---");
    }

} // Phone 클래스 종료
