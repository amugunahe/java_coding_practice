package com.objectex;

/* 객체 배열
 - 수 많은 객체를 다뤄야할때 배열로 처리하는 방식 -> 객체 배열
    객체 배열안에 객체가 저장되는 것은 아니고, 객체의 주소가 저장된다.
    객체 배열은 참조변수들을 하나로 묶은 참조변수 배열인것임
 
  TV t1, t2, t3; //객체선언 -> 참조변수선언
 
  객체배열
    TV[] tvArr = new TV[3]; //위랑 동일
  -> 길이가 3인 객체배열을 생성했다
  
  	// 객체를 생성해서 배열의 각 요소에 저장
  	TvArr[0] = new Tv[];
  	TvArr[1] = new Tv[];
  	TvArr[2] = new Tv[];
	
	Tv[] tvArr = {new Tv(), new Tv(), newTv()};
	
	Tv[] tvArr = new Tv[100];
	for (int i = 0; i < tvArray.length; i++) {
	tvArr[i] = new Tv();
	}
	
	클래스 - 사용자 정의 타입(자료형)

 */

public class TvExam03 {

	public static void main(String[] args) {
	
		// 길이가 3인 Tv 객체 배열 선언
		Tv[] tvArr = new Tv[3];
		
		// Tv 객체를 생성해서 배열에 값을 저장함
		for (int i = 0; i < tvArr.length; i++) {
			tvArr[i] = new Tv();
			tvArr[i].channel = i + 10;
		}
		
		for (int i = 0; i < tvArr.length; i++) {
			tvArr[i].channelUp();
			System.out.println("tvArr[" + i + "]:" + tvArr[i].channel);
		}
	}
}
