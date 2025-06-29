package com.listex; // 이 코드가 속한 폴더(패키지) 이름이다.

/*
  MyData 클래스: **사람의 이름(name)과 나이(age) 정보를 존나게 저장하는 설계도다!**
 
  핵심:
  - **멤버 변수 (`name`, `age`):** 이 클래스로 만들어지는 'MyData' 객체들이 각각 가질 이름이랑 나이를 저장하는 공간이다.
  - **생성자(Constructor):** 객체를 만들 때(`new MyData(...)`) 멤버 변수들을 초기화하는 존나 특별한 메소드다!
  - **기본 생성자 (`MyData()`):** 아무 매개변수 없이 객체만 만들 때 쓴다. (이름은 `null`, 나이는 `0`으로 초기화!)
  - **매개변수 있는 생성자 (`MyData(String name, int age)`):** 객체 만들 때 이름이랑 나이를 바로 때려박을 수 있다! (존나 편하다!)
  - **`this.name = name;` (존나 중요!):** 매개변수(`name`)로 넘어온 값을 현재 객체의 '멤버 변수(`this.name`)'에 저장한다!
  - **`displayInfo()` 메소드:** 객체 안에 저장된 이름과 나이 정보를 정해진 형식대로 출력해준다!
 */

public class MyData { // 'MyData'라는 이름의 공개(public) 클래스를 선언한다.

	// --- 1. 멤버 변수 (필드) ---
	// 이 변수들은 'MyData' 클래스로 만들어지는 각각의 객체가 가질 '이름'과 '나이'를 저장하는 공간이다.
	// 이전에 니가 생성자 안에 넣었던 `public int age;`는 여기에 있어야 한다
	public String name; // 이름 저장용 문자열 변수.
	public int age;     // 나이 저장용 정수 변수.

	// --- 2. 생성자(Constructor) #1: 기본 생성자 (매개변수 없음) ---
	// 니가 `public Mydata() { ... }`이라고 쓰다가 놓쳤던 부분이다.
	// 아무 매개변수 없이 `MyData` 객체를 만들 때 호출된다.
	public MyData() {
		// 기본적으로 이름은 비워두고, 나이는 0으로 초기화한다.
		this.name = null; // 또는 ""
		this.age = 0;
		System.out.println("기본 생성자로 MyData 객체 생성됨!");
	}

	// --- 3. 생성자(Constructor) #2: 매개변수 있는 생성자 (이름과 나이를 받아서 초기화) ---
	// 니가 `public MyData(String name, int age)`라고 쓰다가 놓쳤던 부분이다.
	// 이 생성자는 이름(`name`)과 나이(`age`)를 매개변수로 받아서 멤버 변수들을 초기화한다.
	public MyData(String name, int age) {
		// ★★★ 존나 중요! 매개변수 값을 멤버 변수에 대입해야 한다! ★★★
		// 니 코드에서는 `name = ""; age = 0;` 이렇게 매개변수 자체를 초기화해서 아무 의미가 없었다.
		// `this.`를 붙여서 '현재 객체의 멤버 변수'임을 명확히 한다!
		this.name = name; // 매개변수 'name'의 값을 현재 객체의 'name' 멤버 변수에 저장.
		this.age = age;   // 매개변수 'age'의 값을 현재 객체의 'age' 멤버 변수에 저장.
		System.out.println("매개변수 있는 생성자로 MyData 객체 생성됨!");
	}

	// --- 4. 정보 출력 메소드 (`displayInfo`) ---
	// 이 메소드는 'MyData' 객체가 가지고 있는 이름과 나이 정보를 화면에 출력한다.
	public void displayInfo() {
		System.out.println("이름: " + this.name + ", 나이: " + this.age);
	}

	// --- 5. 메인 메소드(main method): 프로그램의 시작점 (테스트용) ---
	// 이 `main` 메소드 안에서 'MyData' 객체를 만들고, 메소드를 호출해서 테스트해본다.
	public static void main(String[] args) {
		System.out.println("--- MyData 클래스 테스트 시작! ---");

		// 1. 기본 생성자로 MyData 객체 생성 및 정보 출력
		MyData data1 = new MyData();
		data1.displayInfo(); // 이름: null, 나이: 0 출력 (기본값)
		System.out.println();

		// 2. 매개변수 있는 생성자로 MyData 객체 생성 및 정보 출력
		MyData data2 = new MyData("김철수", 25);
		data2.displayInfo(); // 이름: 김철수, 나이: 25 출력
		System.out.println();
		
		// 3. 멤버 변수 직접 변경 후 정보 출력
		MyData data3 = new MyData();
		data3.name = "이영희";
		data3.age = 30;
		System.out.println("수동으로 값 설정 후:");
		data3.displayInfo(); // 이름: 이영희, 나이: 30 출력
		
		System.out.println("\n--- MyData 클래스 테스트 종료! ---");
	}
}
