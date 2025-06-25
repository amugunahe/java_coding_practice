package com.switchex; // 이 코드가 속한 패키지(폴더) 이름. 보통 관련 코드끼리 묶어둠.

/* switch~case
// switch-case 문에 대한 간단한 설명들임.
- 다양한 처리문을 두고 조건값에 의해서 하나의 처리문이나 여러개의 처리문을 한번에 수행하는데 유용한 분기문이다.
- 조건은 정수형이나 문자형 (실수형은 안 됨!)
- 실수형은 사용불가
- break문은 하나의 조건값마다 하나의 수행문만 필요할 경우 사용함, 단 break문이 없을 경우 모든 수행을 실행한다. (이걸 '폴스루'라고 함)

형식
switch(조건){ // 조건값에 따라 갈라지는 스위치 시작. 조건은 정수, 문자만 가능.
case 조건1:  // 조건값이 '조건1'이면 여기부터 실행.
수행문;      // 실행할 코드.
break;      // 여기서 멈추고 switch 밖으로 나감. 이거 없으면 다음 case도 실행됨.
case 조건2:
수행문;
break;
case 조건3:
수행문;
break;
default:   // 위에 어떤 case에도 해당 안 될 때 실행되는 곳. (선택 사항)
// 위의 조건값중에 단 하나라도 일치하지 않을 경우 수행함
}
*/

import java.util.*; // 사용자 입력을 받기 위한 Scanner 클래스를 쓰려고 import 함.

public class SwitchEx01 { // SwitchEx01 이라는 클래스 선언. 자바 코드는 클래스 안에 있어야 함.

	public static void main(String[] args) { // 프로그램이 처음 시작되는 지점. 자바가 여기서부터 코드를 읽기 시작함.

		Scanner sc = new Scanner(System.in); // 키보드 입력을 받기 위한 Scanner 객체 생성.

		int kor, eng, mat, sum = 0; // 국어, 영어, 수학 점수, 그리고 총점을 저장할 정수형 변수들을 선언하고 총점은 0으로 초기화.
		float avg = 0.0f; // 평균을 저장할 실수형 변수(float) 선언하고 0.0으로 초기화. 소수점 계산해야 해서 float 씀.
		char grade = ' '; // 학점을 저장할 문자형 변수(char) 선언하고 공백으로 초기화.

		System.out.print("국어 입력: "); // 사용자에게 국어 점수를 입력하라고 화면에 출력.
		kor = sc.nextInt(); // 사용자가 입력한 정수를 `kor` 변수에 저장.

		System.out.print("영어 입력: "); // 사용자에게 영어 점수를 입력하라고 화면에 출력.
		eng = sc.nextInt(); // 사용자가 입력한 정수를 `eng` 변수에 저장.

		System.out.print("수학 입력: "); // 사용자에게 수학 점수를 입력하라고 화면에 출력.
		mat = sc.nextInt(); // 사용자가 입력한 정수를 `mat` 변수에 저장.

		sum = kor + eng + mat;	// 세 과목 점수를 더해서 총점(`sum`) 계산.

		// 평균 계산: 정수끼리 나누면 소수점 버려지니까, `(float)`으로 `sum`을 실수로 만들어서 정확한 평균을 구함.
		avg = (float) sum / 3;

		// System.out.println("총점: " + sum); // 총점 출력 (현재 주석 처리되어 실행 안 됨).
		System.out.println("평균: " + avg); // 계산된 평균(`avg`)을 화면에 출력.

		// switch-case 문을 이용한 학점 판정.
		// `avg`를 10으로 나눈 몫을 정수형으로 변환(`(int)(avg / 10)`)해서 switch 조건으로 사용.
		// 예: 95점 -> 9, 83점 -> 8.
		switch ((int)(avg / 10)) {
			case 10: // 평균이 100점대 (avg/10이 10인 경우)
			case 9:  // 평균이 90점대 (avg/10이 9인 경우)
				grade = 'A'; // 학점을 'A'로 설정.
				break; // switch 문 종료.
			case 8:  // 평균이 80점대 (avg/10이 8인 경우)
				grade = 'B'; // 학점을 'B'로 설정.
				break; // switch 문 종료.
			case 7:  // 평균이 70점대 (avg/10이 7인 경우)
				grade = 'C'; // 학점을 'C'로 설정.
				break; // switch 문 종료.
			case 6:  // 평균이 60점대 (avg/10이 6인 경우)
				grade = 'D'; // 학점을 'D'로 설정.
				break; // switch 문 종료.
			default: // 위의 어떤 case에도 해당하지 않을 때 (60점 미만)
				grade = 'F'; // 학점을 'F'로 설정.
				break; // switch 문 종료.
		}
		System.out.println("당신의 학점은 " + grade + " 입니다."); // 최종 학점 출력.

		sc.close(); // Scanner 객체 사용이 끝났으니 닫아서 시스템 자원을 해제함. (중요한 습관!)
	}
}
