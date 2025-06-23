package com.homework;

public class ConcertApp {

	public static void main(String[] args) {
		// "글로벌인 콘서트"라는 이름으로 Concert 객체 생성
		Concert con = new Concert("글로벌인 콘서트");
		con.run(); // 콘서트 예약 시스템 실행
	}
}