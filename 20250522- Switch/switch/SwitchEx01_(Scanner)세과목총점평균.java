package com.switchex;


/*  switch~case 

- 다양한 처리문을 두고 조건값에 의해서 하나의 처리문이나 여러개의 처리문을 한번에 수행하는데 유용한 분기문이다.
- 조건은 정수형이나 문자형
- 실수형은 사용불가
- break문은 하나의 조건값마다 하나의 수행문만 필요할 경우 사용함, 단 break문이 없을 경우 모든 수행을 실행한다.
    
형식
switch(조건){
case 조건1:
수행문;
break;
case 조건2:
수행문;
break;
case 조건3:
수행문;
break;
default: => 위의 조건값중에 단 하나라도 일치하지 않을 경우 수행함
}

 문] 세과목을 임의의 점수를 입력받아 총점과 평균을 구하고
 평균을 이용하여 학점을 판정하는 프로그램을 구현하시오.
 단, 모든 수는 정수 처리하시오. 
 */

import java.util.*;

public class SwitchEx01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int kor, eng, mat, sum = 0;
		float avg = 0.0f;
		char grade = ' ';
		
		System.out.print("국어 입력: ");
		kor = sc.nextInt();
		
		System.out.print("영어 입력: ");
		eng = sc.nextInt();
		
		System.out.print("수학 입력: ");
		mat = sc.nextInt();
		
		sum = kor + eng + mat;	// 총점
		
		avg = sum / 3;	// 평균
		
		//System.out.println("총점: " + sum);
		System.out.println("평균: " + avg);
		
		switch ((int)(avg / 10)) {
		case 10:
		case 9:
			grade = 'A';   // 90~100
			break;
		case 8:
			grade = 'B';  // 80~89
			break;
		case 7:
			grade = 'C';  // 70~79
			break;
		case 6:
			grade = 'D';  // 60~69
			break;
		default:
			grade = 'F';  // 50~59
			break;
		}
		System.out.println("당신의 학점은 " + grade + " 입니다.");
	}
}
