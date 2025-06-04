package com.arrayex;

/*
 * 문] 입력받은 인원수만큼 학생이름과 전화번호를 입력받고 
 * 입력받은 내용을 전체 출력하는 프로그램을 구현하시오.
 * 단, 배열로 작성하시오 
 * 
 * 입력 처리할 학생 수 : 3
 * 이름 전화번호 입력(1)[공백구분]: 가길동 010-1111-1111
 * 이름 전화번호 입력(2)[공백구분]: 나길동 010-2222-2222  
 * 이름 전화번호 입력(3)[공백구분]: 다길동 010-3333-3333
 * 
 * 전체 학생 수: 3
 * 이름 전화번호
 * 가길동 010-1111-1111
 * 나길동 010-2222-2222  
 * 다길동 010-3333-3333
 */
import java.util.*;

public class ArrayEx04 {

	public static void main(String[] args) {

		int n;

		Scanner sc = new Scanner(System.in);

		System.out.print("입력 처리할 학생 수:");
		n = sc.nextInt();

		// 학생이름을 저장할 배열 선언
		String[] name = new String[n];

		// 전화번호를 저장할 배열 선언
		String[] phone = new String[n];

		for (int i = 0; i < n; i++) {
			System.out.print("이름 전화번호 입력(" + (i + 1) + ")[공백구분]:");
			name[i] = sc.next();
			phone[i] = sc.next();
		}
		
		System.out.println("전체 학생 수: " + n + "명");
		System.out.println("이름\t전화번호");
		for(int i = 0; i < n; i++) {
			System.out.println(name[i]+ " "+ phone[i]);
		}
		

	}

}
