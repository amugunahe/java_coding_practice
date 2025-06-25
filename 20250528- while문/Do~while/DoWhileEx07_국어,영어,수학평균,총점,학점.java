package dowhileex;

/* 문] 국어, 영어, 수학 정수를 입력받아 총점과 평균을 구하고.
 학점을 판정하는 프로그램을 구현하시오.
단, do~while문 사용
점수의 범위는 100점을 벗어나지 못함
*/

import java.util.*; // Scanner 쓰려면 이거 필수!

public class DoWhileEx07 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력받을 준비 완료!
		
		// 변수 선언: 국영수 점수, 총점, 학점(char), 평균(double)
		int kor, eng, mat, sum = 0;
		char hak; // 학점은 문자 하나니까 char로 선언
		double avg = 0; // 평균은 소수점 나올 수 있으니 double로 선언

		// 핵심 1: do-while문으로 국어 점수 입력받고 유효성 검사
		// 최소 한 번은 실행하고, 조건(0 미만 또는 100 초과)이 참이면 다시 입력받음.
		do { 
			System.out.print("국어 점수: ");
			kor = sc.nextInt(); // 국어 점수 입력
			if (kor > 100 || kor < 0) // 0~100점 범위 벗어나면
				System.out.println("점수는 0점에서 100점 사이로 다시 입력하세요."); // 메시지 출력
		} while (kor < 0 || kor > 100); // 조건이 참이면(범위 벗어나면) 다시 do 블록 실행

		// 영어 점수도 국어랑 똑같은 방식으로 유효성 검사
		do { 
			System.out.print("영어 점수: ");
			eng = sc.nextInt();
			if (eng > 100 || eng < 0)
				System.out.println("점수는 0점에서 100점 사이로 다시 입력하세요.");
		} while (eng < 0 || eng > 100);

		// 수학 점수도 국어랑 똑같은 방식으로 유효성 검사
		do { 
			System.out.print("수학 점수: ");
			mat = sc.nextInt();
			if (mat > 100 || mat < 0)
				System.out.println("점수는 0점에서 100점 사이로 다시 입력하세요.");
		} while (mat < 0 || mat > 100);

		// 총점과 평균 계산
		sum = kor + eng + mat; // 세 과목 점수 합산
		avg = sum / 3.0; // 총점을 3.0으로 나누면 실수(double) 나눗셈이 돼서 소수점까지 정확하게 나옴. (핵심)
		
		// 핵심 2: switch-case문으로 학점 판정
		// (int)(avg / 10)은 평균을 10으로 나눈 몫을 정수로 만든다. (예: 95.x -> 9, 83.x -> 8)
		switch ((int)(avg / 10)) { 
		case 10: // 평균이 100점일 경우
		case 9: // 평균이 90점대일 경우
			hak = 'A'; // 학점 A
			break; // switch문 탈출 (없으면 다음 case로 넘어감)
		case 8: // 평균이 80점대일 경우
			hak = 'B'; // 학점 B
			break;
		case 7: // 평균이 70점대일 경우
			hak = 'C'; // 학점 C
			break;
		case 6: // 평균이 60점대일 경우
			hak = 'D'; // 학점 D
			break;
		default: // 그 외 (0~59점)
			hak = 'F'; // 학점 F
		}

		// 최종 결과 출력
		System.out.println("총점: " + sum);
		System.out.printf("평균: %.3f\n", avg); // printf로 평균을 소수점 셋째 자리까지 출력
		System.out.println("학점: "+ hak);

        sc.close(); // Scanner 다 썼으면 자원 해제 필수!
	}
}
