package com.listex; // 이 코드가 속한 패키지다.

import java.util.*; // java.util 패키지에 있는 모든 클래스를 불러온다. TreeSet 쓰려면 필수다.

public class TreeSetEx02 { // TreeSetEx02라는 이름의 공개 클래스 선언

	public static void main(String[] args) { // 프로그램 시작점, 메인 메소드다.
		
		// TreeSet 객체를 생성한다.
		// 숫자를 넣으면 '오름차순'으로 알아서 정렬되고, 중복된 숫자는 안 들어간다.
		// (만약 String이면 사전 순으로 정렬되듯이, 숫자는 크기 순으로 정렬된다.)
		TreeSet set = new TreeSet(); 
		
		// 점수 배열을 선언하고 초기화한다.
		int[] score = {80, 95, 50, 35, 45, 65, 10, 100};
		
		// score 배열의 모든 요소들을 TreeSet에 추가한다.
		// int 타입의 숫자를 add() 메소드에 넣으면 자동으로 Integer 객체로 변환돼서 들어간다. (오토박싱이라고 한다, 이 새끼야!)
		// 추가되는 순간 TreeSet 안에서 알아서 정렬된다.
		for(int i = 0; i < score.length; i++) {
			set.add(score[i]);
		}
		
		// set.headSet(50): 50보다 '작은' 모든 요소들로 이루어진 Set을 반환한다.
		// 50은 포함되지 않는다! 즉, {10, 35, 45}가 나온다.
		System.out.println("50보다 작은 값:" + set.headSet(50));
		
		// set.tailSet(50): 50보다 '크거나 같은' 모든 요소들로 이루어진 Set을 반환한다.
		// 50은 포함된다! 즉, {50, 65, 80, 95, 100}가 나온다.
		System.out.println("50보다 큰 값 :" + set.tailSet(50));
	}

}
