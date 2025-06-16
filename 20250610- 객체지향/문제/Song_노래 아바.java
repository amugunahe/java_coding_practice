package com.functionex;

/* 노래 한곡을 나타내는 Song 클래스를 작성하시오.
필드의 구성은 다음과 같다. 

	노래의 제목 title
	가수 artist 
	노래가 발표된 년도 year 
	국적 country
	
	또한 Song 클래스 
	
	생성자 2개: 기본 생성자와 매개 변수로 모든 필드를 초기화 하는 생성자 
	노래 정보를 출력하는 show() 메소드
	main() 메소드에서 1978년 스웨덴 국적의 ABBA가 부른 "Dancing Queen"을 Song 객체로 생성하고 
	show() 메소드를 이용하여 노래의 정보를 다음과 같이 출력하시오.
	
	1978년 스웨덴 국적의 ABBA가 부른 Dancing Queen
*/

public class Song{
	
	private String title;
	private String artist;
	private int year;
	private String country;
	
public Song(String title, String artist, int year, String country) {
	this.title = title;
	this.artist = artist;
	this.year = year;
	this.country = country;
}

public Song() {
	
}
public void show() {
	System.out.println(year + "년 " + country + "국적의 " + artist + "가 부른 " + title);
}

public static void main(String[] args) {
	Song s = new Song("Dancing Queen", "ABBA", 1978, "스웨덴");
	s.show();
	}

}

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