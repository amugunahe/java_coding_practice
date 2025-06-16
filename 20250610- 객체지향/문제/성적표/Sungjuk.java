package com.sungex;

/* 문]  학생별로 국어, 영어, 수학 점수를 입력받아 총점, 평균, 석차를 계산하는 프로그램을 구현
클래스, 메소드, 배열 활용 

클래스 구성

1. Record -> 속성만 존재하는 클래스

2. Sung-> 인원수 입력받는 기능
    		성적을 처리하는 기능 
    		출력을 처리하는 기능 

3. Sungjuk -> 실행 클래스 
*/

public class Sungjuk {

	public static void main(String[] args) {
		
		Sung s = new Sung();
		s.set(); 
		s.input();
		s.print();
	}

}
