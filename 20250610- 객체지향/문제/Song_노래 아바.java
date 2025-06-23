package com.functionex; // 'com.functionex'는 이 자바 파일(클래스)이 속한 패키지 이름입니다. 패키지는 관련 클래스들을 묶어서 관리하는 폴더와 같은 역할을 합니다.

/*
  노래 한 곡의 정보를 나타내는 Song 클래스를 작성합니다.
  이 클래스는 노래의 제목, 가수, 발표 년도, 국적 등의 필드를 가집니다.
 
  주요 기능:
  - 필드 구성: 제목(title), 가수(artist), 발표 년도(year), 국적(country).
  - 생성자 2개:
  1. 기본 생성자 (매개변수 없음)
  2. 모든 필드를 매개변수로 받아 초기화하는 생성자
  - 'show()' 메소드: 노래의 모든 정보를 형식에 맞춰 출력합니다.
 
  main() 메소드에서는 1978년 스웨덴 국적의 ABBA가 부른 "Dancing Queen" 노래를 Song 객체로 생성하고,
  show() 메소드를 이용하여 노래 정보를 "1978년 스웨덴 국적의 ABBA가 부른 Dancing Queen"과 같은 형식으로 출력합니다.
 */

public class Song{ // 'Song'이라는 이름의 공개(public) 클래스를 선언합니다. 이 클래스는 하나의 노래 정보를 담는 '설계도' 역할을 합니다.

	// --- 멤버 변수 (필드) ---
	// 이들은 'Song' 클래스로 만들어지는 각각의 객체가 가질 노래 정보들을 저장하는 공간입니다.
	// 'private' 접근 제어자는 이 변수들이 'Song' 클래스 내부에서만 접근 가능하도록 하여 데이터를 안전하게 보호합니다.
	private String title;   // 노래의 제목을 저장할 문자열(String) 변수
	private String artist;  // 가수 이름을 저장할 문자열(String) 변수
	private int year;       // 노래가 발표된 년도를 저장할 정수(int) 변수
	private String country; // 가수의 국적을 저장할 문자열(String) 변수

	// --- 생성자(Constructor) #1: 모든 필드를 초기화하는 생성자 ---
	// 이 생성자는 'Song' 객체를 생성할 때 모든 노래 정보를 외부로부터 받아 멤버 변수들을 초기화합니다.
	public Song(String title, String artist, int year, String country) { // 제목, 가수, 년도, 국적을 매개변수로 받습니다.
		this.title = title;     // 매개변수 'title'의 값을 현재 객체의 'title' 멤버 변수에 저장합니다. ('this.'는 현재 객체를 지칭)
		this.artist = artist;   // 매개변수 'artist'의 값을 현재 객체의 'artist' 멤버 변수에 저장합니다.
		this.year = year;       // 매개변수 'year'의 값을 현재 객체의 'year' 멤버 변수에 저장합니다.
		this.country = country; // 매개변수 'country'의 값을 현재 객체의 'country' 멤버 변수에 저장합니다.
	}

	// --- 생성자(Constructor) #2: 기본 생성자 (매개변수 없음) ---
	// 이 생성자는 객체를 생성할 때 초기값을 지정하지 않고, 나중에 값을 설정할 수 있도록 합니다.
	// (다른 생성자가 있을 경우 명시적으로 정의해주어야 합니다.)
	public Song() {
		// 이 생성자가 호출될 때 특별히 수행할 초기화 작업이 없으므로 내용이 비어있습니다.
	}

	// --- 노래 정보 출력 메서드 ---
	// 이 메서드는 현재 'Song' 객체가 가지고 있는 노래 정보를 특정 형식으로 화면에 출력합니다.
	public void show() { // 'show'라는 이름의 메서드를 선언합니다. 이 메서드는 어떤 값도 반환하지 않습니다(void).
		// System.out.println()을 사용하여 멤버 변수들의 값을 조합하여 출력합니다.
		// '+' 연산자는 문자열과 다른 타입의 데이터를 연결하여 하나의 문자열로 만듭니다.
		System.out.println(year + "년 " + country + "국적의 " + artist + "가 부른 " + title);
	}

	// --- 메인 메서드(main method): 프로그램의 시작점 ---
	// 자바 프로그램을 실행하면 이 'main' 메서드부터 코드가 실행되기 시작합니다.
	public static void main(String[] args) { // 'main' 메서드는 항상 'public static void'로 선언되어야 합니다.
		// 'Song' 클래스의 새로운 객체 's'를 생성합니다.
		// 이 때, 모든 필드를 초기화하는 생성자를 호출하며 "Dancing Queen", "ABBA", 1978, "스웨덴" 값을 전달합니다.
		// 이렇게 생성된 's' 객체는 해당 정보를 자신의 멤버 변수에 저장하게 됩니다.
		Song s = new Song("Dancing Queen", "ABBA", 1978, "스웨덴");

		// 생성된 's' 객체의 'show()' 메서드를 호출하여 노래 정보를 화면에 출력합니다.
		s.show();
	} // main 메서드 종료

} // Song 클래스 종료

/* class Song {
int year;
String country;
String artist;
String title;


public Song(int year, String country, String artist, String title) {
this.year = year;
this.country = country;
this.artist = artist;
this.title = title; 
}

Song() {

}

public void show(){
System.out.println(year + "년 " + country + "국적의 " + artist + "가 부른 " + title);
}

}
public class funcExam05 {

public static void main(String[] args) {
	
 Song mysong = new Song(1978, "스웨덴", "ABBA", "Dancing Queen");
 mysong.show();
}
}
*/
