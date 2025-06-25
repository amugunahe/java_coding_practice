package com.functionex; // 'com.functionex'는 이 자바 파일(클래스)이 속한 패키지 이름이다.
                         // 이전에 설명드렸던 'DicApp' 클래스와 같은 패키지에 있어야 서로를 쉽게 찾아 사용할 수 있다.

/*
  Song 클래스: **노래 한 곡의 정보를 존나게 깔끔하게 저장하는 설계도다!**
 
  핵심:
  - **목표:** 노래의 제목, 가수, 발표 년도, 국적을 필드로 가지고,
  두 가지 방법으로 객체를 만들 수 있게 한다 (기본 생성자, 모든 필드 초기화 생성자).
  그리고 'show()' 메소드로 노래 정보를 한 방에 출력한다!
  - **필드 (`title`, `artist`, `year`, `country`):** 노래의 각 정보를 저장하는 공간이다.
  `private`이라 이 클래스 안에서만 직접 건드릴 수 있다! (데이터 보호!)
  - **생성자 2개:**
  1. `Song()` (기본 생성자): 아무 매개변수 없이 객체만 만들 때 쓴다. (나중에 정보 채울 때!)
  2. `Song(String title, String artist, int year, String country)`: 객체 만들 때 모든 정보를 바로 때려박을 수 있다! (존나 편하다!)
  - **`show()` 메소드:** 객체 안에 저장된 노래 정보를 정해진 형식대로 출력해준다!
  - **`main()` 메소드:** ABBA의 "Dancing Queen" 정보를 가지고 `Song` 객체를 만들고 `show()`로 출력하는 예시를 보여준다!
 */

public class Song{ // 'Song'이라는 이름의 공개(public) 클래스를 선언한다. 이 클래스는 하나의 노래 정보를 담는 '설계도' 역할을 한다.

	// --- 멤버 변수 (필드) ---
	// 이들은 'Song' 클래스로 만들어지는 각각의 객체가 가질 노래 정보들을 저장하는 공간이다.
	// 'private' 접근 제어자는 이 변수들이 'Song' 클래스 내부에서만 접근 가능하도록 하여 데이터를 안전하게 보호한다. (존나 중요!)
	private String title;   // 노래의 제목을 저장할 문자열(String) 변수.
	private String artist;  // 가수 이름을 저장할 문자열(String) 변수.
	private int year;       // 노래가 발표된 년도를 저장할 정수(int) 변수.
	private String country; // 가수의 국적을 저장할 문자열(String) 변수.

	// --- 생성자(Constructor) #1: 모든 필드를 초기화하는 존나 편한 생성자! ---
	// 이 생성자는 'Song' 객체를 생성할 때 모든 노래 정보를 외부로부터 받아 멤버 변수들을 초기화한다.
	public Song(String title, String artist, int year, String country) { // 제목, 가수, 년도, 국적을 매개변수로 받는다.
		this.title = title;     // 매개변수 'title'의 값을 현재 객체의 'title' 멤버 변수에 저장한다. ('this.'는 현재 객체를 지칭! 존나 중요!)
		this.artist = artist;   // 매개변수 'artist'의 값을 현재 객체의 'artist' 멤버 변수에 저장한다.
		this.year = year;       // 매개변수 'year'의 값을 현재 객체의 'year' 멤버 변수에 저장한다.
		this.country = country; // 매개변수 'country'의 값을 현재 객체의 'country' 멤버 변수에 저장한다.
	}

	// --- 생성자(Constructor) #2: 기본 생성자 (매개변수 없음) ---
	// 이 생성자는 객체를 생성할 때 초기값을 지정하지 않고, 나중에 값을 설정할 수 있도록 한다.
	// (다른 생성자가 있을 경우 이렇게 명시적으로 정의해주어야 한다! 아니면 컴파일 에러난다, 씨발!)
	public Song() {
		// 이 생성자가 호출될 때 특별히 수행할 초기화 작업이 없으므로 내용이 비어있다. (그냥 객체만 깡통으로 만들 때!)
	}

	// --- 노래 정보 출력 메소드 ---
	// 이 메소드는 현재 'Song' 객체가 가지고 있는 노래 정보를 특정 형식으로 화면에 존나게 출력한다.
	public void show() { // 'show'라는 이름의 메소드를 선언한다. 이 메소드는 어떤 값도 반환하지 않는다(void).
		// `System.out.println()`을 사용하여 멤버 변수들의 값을 조합하여 출력한다.
		// '+' 연산자는 문자열과 다른 타입의 데이터를 연결하여 하나의 문자열로 만든다.
		System.out.println(year + "년 " + country + "국적의 " + artist + "가 부른 " + title);
	}

	// --- 메인 메소드(main method): 프로그램의 시작점 ---
	// 자바 프로그램을 실행하면 이 'main' 메소드부터 코드가 실행되기 시작한다.
	public static void main(String[] args) { // 'main' 메소드는 항상 'public static void'로 선언되어야 한다.
		// ★★★ 'Song' 클래스의 새로운 객체 's'를 존나게 생성한다! ★★★
		// 이 때, 모든 필드를 초기화하는 생성자를 호출하며 "Dancing Queen", "ABBA", 1978, "스웨덴" 값을 전달한다.
		// 이렇게 생성된 's' 객체는 해당 정보를 자신의 멤버 변수에 저장하게 된다.
		Song s = new Song("Dancing Queen", "ABBA", 1978, "스웨덴");

		// ★★★ 생성된 's' 객체의 'show()' 메소드를 호출하여 노래 정보를 화면에 출력한다! ★★★
		s.show();
	} // main 메소드 종료

} // Song 클래스 종료

/*
 * (아래 주석 처리된 부분은 이전 버전의 코드이거나 다른 클래스의 예시인 듯 하다.
 * 지금은 필요 없으니 그냥 냅뒀다, 씨발!)
 *
 * class Song {
 * int year;
 * String country;
 * String artist;
 * String title;
 *
 * public Song(int year, String country, String artist, String title) {
 * this.year = year;
 * this.country = country;
 * this.artist = artist;
 * this.title = title;
 * }
 *
 * Song() {
 *
 * }
 *
 * public void show(){
 * System.out.println(year + "년 " + country + "국적의 " + artist + "가 부른 " + title);
 * }
 *
 * }
 * public class funcExam05 {
 *
 * public static void main(String[] args) {
 *
 * Song mysong = new Song(1978, "스웨덴", "ABBA", "Dancing Queen");
 * mysong.show();
 * }
 * }
 */
