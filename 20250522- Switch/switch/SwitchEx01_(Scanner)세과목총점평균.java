package com.switchex;

/* switch~case

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

		Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위한 Scanner 객체 생성

		int kor, eng, mat, sum = 0; // 국어, 영어, 수학 점수 및 총점 변수 선언 및 초기화
		float avg = 0.0f; // 평균 점수 변수 선언 및 초기화 (소수점 계산을 위해 float 사용)
		char grade = ' '; // 학점 변수 선언 및 초기화

		System.out.print("국어 입력: "); // 국어 점수 입력 요청
		kor = sc.nextInt(); // 국어 점수 입력받아 저장

		System.out.print("영어 입력: "); // 영어 점수 입력 요청
		eng = sc.nextInt(); // 영어 점수 입력받아 저장

		System.out.print("수학 입력: "); // 수학 점수 입력 요청
		mat = sc.nextInt(); // 수학 점수 입력받아 저장

		sum = kor + eng + mat; // 세 과목의 총점 계산

		// 평균 계산: 정수 나눗셈 방지를 위해 sum을 float으로 형변환하여 계산
		avg = (float) sum / 3;

		// System.out.println("총점: " + sum); // 총점은 주석 처리되어 있으므로 출력 안 함
		System.out.println("평균: " + avg); // 평균 출력

		// switch-case 문을 이용한 학점 판정
		// 평균을 10으로 나눈 정수 몫을 기준으로 학점을 판정
		switch ((int) (avg / 10)) { // (int)(avg / 10)는 90~100점은 9 또는 10, 80점대는 8 등으로 변환됨
			case 10: // 100점의 경우 (avg/10이 10)
			case 9:  // 90점대의 경우 (avg/10이 9)
				grade = 'A'; // A학점 부여
				break; // switch 문 종료
			case 8:  // 80점대의 경우
				grade = 'B'; // B학점 부여
				break; // switch 문 종료
			case 7:  // 70점대의 경우
				grade = 'C'; // C학점 부여
				break; // switch 문 종료
			case 6:  // 60점대의 경우
				grade = 'D'; // D학점 부여
				break; // switch 문 종료
			default: // 그 외 (60점 미만)
				grade = 'F'; // F학점 부여
				break; // switch 문 종료
		}
		System.out.println("당신의 학점은 " + grade + " 입니다."); // 최종 학점 출력

		sc.close(); // 사용이 끝난 Scanner 객체 닫기 (리소스 해제)
	}
}
