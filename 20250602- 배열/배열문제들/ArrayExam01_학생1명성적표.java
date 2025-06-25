package com.arrayExam; // 이 코드 덩어리가 속한 폴더(패키지) 이름이다.

/*
  ArrayExam01 클래스: **학생 한 명의 성적을 존나게 깔끔하게 처리하는 프로그램이다!**
 
  핵심:
  - **문제:** 프로그램 실행 시 '명령줄 인자(Arguments)'로 과목명들(`국어`, `영어`, `수학` 등)을 입력받는다.
  사용자는 입력된 과목명에 따라 점수를 입력하고, 프로그램은 총점, 평균, 학점을 계산해서 성적표를 출력한다.
  - **'run - run configurations - Arguments'**: 이 부분에서 `main` 메소드의 `String[] ar`로 전달될 값들을 설정한다.
  (예: `국어 영어 수학` 이렇게 입력하면 `ar` 배열에 "국어", "영어", "수학"이 들어간다, 씨발!)
  - **`BufferedReader`:** 키보드 입력을 한 줄씩 읽어올 때 쓰는 존나 유용한 놈이다!
  - **`ar.length` (명령줄 인자 수):** 입력된 과목의 개수를 알 수 있다.
  - **`if (ar.length == 0)`:** 과목이 하나도 입력 안 됐으면 프로그램 바로 종료! (존나 중요!)
  - **`subject` 배열:** 명령줄 인자로 받은 과목명들을 저장한다.
  - **`jumsu` 배열:** 각 과목 점수랑 **총점**을 저장한다. (배열 마지막 칸은 항상 총점 자리다!)
  - **`float avg`:** 평균은 소수점 나올 수 있으니 `float`으로 선언한다!
  - **평균 반올림 로직:** `avg = (int) ((avg + 0.005) * 100) / 1000.f;`
  -> 이거 소수점 셋째 자리에서 반올림해서 둘째 자리까지 존나 깔끔하게 만드는 로직이다!
  - **`switch` 문 (학점 계산):** 평균에 따라 학점(A, B, C, D, F)을 존나게 똑똑하게 매긴다!
  - **성적표 출력:** 이름, 과목별 점수, 총점, 평균, 학점을 표 형태로 존나게 깔끔하게 출력한다!
 */

import java.io.*; // 'BufferedReader'랑 'IOException' 쓰려면 이 새끼들을 불러와야 한다, 씨발!

public class ArrayExam01 { // 'ArrayExam01'이라는 이름의 공개(public) 클래스를 선언한다.

	// ★★★ 프로그램 시작점 (메인 메소드) ★★★
	// `String[] ar`는 '명령줄 인자(Command Line Arguments)'를 받는 배열이다.
	// 프로그램 실행 시 `java ArrayExam01 국어 영어 수학` 이런 식으로 과목명을 넘겨줄 수 있다!
	public static void main(String[] ar) throws IOException { // 입출력 오류 생길 수 있으니 'throws IOException' 박아둔다!
		
		// (이전 주석 처리된 코드. 여기서는 사용하지 않는다.)
		// String[] subject = {"국어", "영어", "수학"};

		// ★★★ 사용자 입력받을 준비! (BufferedReader 버전!) ★★★
		// 'BufferedReader' 객체를 만들어서 시스템 입력(키보드)을 한 줄씩 읽어들인다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// ★★★ 명령줄 인자(과목명)가 없는 경우 프로그램 종료! (존나 중요!) ★★★
		// 만약 'ar' 배열의 길이가 0이면 (즉, 과목명이 하나도 입력되지 않았으면)
		if (ar.length == 0) {
			System.out.println("배열에 저장된 과목명이 없습니다. (예: java ArrayExam01 국어 영어 수학)"); // 에러 메시지 뱉어라!
			System.exit(0); // 프로그램 강제 종료! (0은 정상 종료를 의미)
		} // 'ar.length'는 명령줄 인자의 개수(즉, 과목 수), 'value'는 각 과목명이다.

		// --- 학생 이름 입력받기 ---
		System.out.print("이름: "); // 사용자에게 이름을 입력하라고 화면에 띄우기.
		String name = br.readLine(); // 사용자가 입력한 이름을 'name' 변수에 저장.

		// ★★★ 명령줄 인자로 받은 과목명들을 저장할 배열 생성! ★★★
		// 'ar.length' (명령줄 인자의 개수, 즉 과목 수)만큼의 크기를 가진 String 배열 'subject'를 만든다.
		String[] subject = new String[ar.length];

		// --- 과목명 복사! (명령줄 인자 -> subject 배열) ---
		// 'ar' 배열(명령줄 인자)에 있는 과목명들을 'subject' 배열로 복사한다.
		for (int i = 0; i < ar.length; i++) {
			subject[i] = ar[i];
		}

		// ★★★ 점수 및 총점 저장 배열 생성! ★★★
		// 'subject.length' (과목 수)에 '1'을 더해서 마지막 칸은 총점(`jumsu[jumsu.length - 1]`) 자리로 만든다!
		int[] jumsu = new int[subject.length + 1]; 
		// (예: 과목이 3개면 배열 크기는 4가 되고, `jumsu[0]`~`jumsu[2]`는 과목 점수, `jumsu[3]`은 총점)

		// --- 각 과목 점수 입력받기 및 총점 누적! ---
		// `jumsu.length - 1` (배열의 마지막 칸, 즉 총점 칸 빼고)까지 돌면서 각 과목 점수를 입력받는다.
		for (int i = 0; i < jumsu.length - 1; i++) {
			System.out.print(subject[i] + "점수: "); // 어떤 과목 점수를 입력할지 메시지 출력.
			jumsu[i] = Integer.parseInt(br.readLine()); // 사용자 입력 문자열을 정수(int)로 바꿔서 저장.
			
			// ★★★ 입력받은 과목 점수를 총점 칸에 누적! ★★★
			// `jumsu[jumsu.length - 1]`은 총점 칸이다! 여기에 계속 더한다!
			jumsu[jumsu.length - 1] += jumsu[i]; 
		}

		// (총점 출력 부분은 주석 처리되어 있었지만, 필요하다면 사용할 수 있다.)
		// System.out.println(jumsu[jumsu.length - 1]);

		// --- 평균 계산! ---
		// 총점(`jumsu[jumsu.length - 1]`)을 과목 수(`subject.length`)로 나눠서 평균을 구한다!
		// `(float)subject.length`로 형 변환해야 소수점까지 제대로 나온다, 씨발!
		float avg = jumsu[jumsu.length - 1] / (float) subject.length;
		
		// ★★★ 평균 반올림 계산: 소수점 3자리에서 반올림해서 2째 자리까지 표기! (존나 깔끔하다!) ★★★
		// (avg + 0.005): 셋째 자리에서 반올림하기 위해 0.005를 더한다.
		// * 100: 소수점 둘째 자리까지 유지하기 위해 100을 곱한다.
		// (int): 정수로 형 변환하여 소수점 이하를 버린다. (반올림 효과)
		// / 1000.f: 다시 1000.0으로 나누어 원래 소수점 위치로 돌려놓는다. (.f는 float 타입임을 명시)
		avg = (int) ((avg + 0.005) * 100) / 1000.f; 
		// (평균 출력 부분은 주석 처리되어 있었지만, 필요하다면 사용할 수 있다.)
		// System.out.println(avg);

		// --- 학점 계산! (Switch 문 활용) ---
		char hak = 0; // 학점을 저장할 char 변수.
		switch ((int) (avg / 10)) { // 평균을 10으로 나눈 정수 값(예: 90점대 -> 9, 80점대 -> 8)으로 판단한다!
		case 10: // 100점대 (나누기 10 하면 10)
		case 9:  // 90점대 (나누기 10 하면 9)
			hak = 'A'; // 'A' 학점!
			break; // 스위치문 탈출.
		case 8: // 80점대
			hak = 'B'; // 'B' 학점!
			break;
		case 7: // 70점대
			hak = 'C'; // 'C' 학점!
			break;
		case 6: // 60점대
			hak = 'D'; // 'D' 학점!
			break;
		default: // 60점 미만
			hak = 'F'; // 'F' 학점! (재수강해라, 씨발!)
			break;
		}
		
		System.out.println(); // 출력 전에 빈 줄 하나.
		System.out.println("*********성적표*********"); // 성적표 헤더.
		System.out.print("이름\t"); // 이름 출력 후 탭.
		
		// --- 과목명 헤더 출력! ---
		for (int i = 0; i < subject.length; i++) {
			System.out.print(subject[i] + "\t"); // 각 과목명 출력 후 탭.
		}
		System.out.println("총점\t평균\t\t학점"); // 총점, 평균, 학점 헤더 출력 후 줄 바꿈.
		
		// --- 학생 정보 및 성적 출력! ---
		System.out.print(name + "\t"); // 학생 이름 출력 후 탭.
		
		// 각 과목 점수와 총점 출력!
		// `subject.length + 1`은 과목 수 + 총점 칸까지 다 돌기 위함이다!
		for (int i = 0 ; i < subject.length + 1; i++) {
		    System.out.print(jumsu[i] + "\t"); // 각 점수(및 총점) 출력 후 탭.
		}
		// 최종 평균과 학점 출력! (평균은 탭 두 번으로 간격 맞춤!)
		System.out.println(avg + "\t\t" + hak);

        // ★★★ BufferedReader 닫기! (존나 중요!) ★★★
		br.close(); // 다 쓴 `BufferedReader`는 꼭 닫아줘야 한다!
	}	
}
