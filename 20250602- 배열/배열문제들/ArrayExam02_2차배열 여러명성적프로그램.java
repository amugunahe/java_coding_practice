package com.arrayExam; // 이 코드 덩어리가 속한 폴더(패키지) 이름이다.

/*
  ArrayExam02 클래스: **2차원 배열을 활용해서 여러 명의 학생 성적을 존나게 깔끔하게 처리하는 프로그램이다!**
 
  핵심:
  - **문제:** 프로그램 실행 시 '명령줄 인자(Arguments)'로 '총 학생 수'를 먼저 받고, 그 다음에 '과목명들'(`국어`, `영어`, `수학` 등)을 입력받는다.
  사용자는 각 학생의 이름을 입력하고, 이어서 각 과목 점수를 입력한다.
  프로그램은 각 학생별 총점, 평균, 학점, 그리고 석차까지 계산해서 존나게 멋진 성적표를 출력한다!
  - **'run - run configurations - Arguments'**: 여기서 `main` 메소드의 `String[] args`로 전달될 값들을 설정한다.
  (예: `3 국어 영어 수학` 이렇게 입력하면 `args[0]`에 "3"이, `args[1]`에 "국어", `args[2]`에 "영어", `args[3]`에 "수학"이 들어간다, 씨발!)
  - **`BufferedReader`:** 키보드 입력을 한 줄씩 읽어올 때 쓰는 존나 유용한 놈이다!
  - **`human` (총 학생 수):** 명령줄 인자의 첫 번째 값으로 받는다.
  - **`subject` 배열:** 명령줄 인자로 받은 과목명들을 저장한다.
  - **`jumsu` 2차원 배열:** `jumsu[학생번호][과목번호 또는 총점]` 형태로 점수를 저장한다.
  - `jumsu[i][subject.length]`는 `i`번째 학생의 총점 칸이다! (존나 중요!)
  - **`avg`, `hak`, `rank` 배열:** 각 학생의 평균, 학점, 석차를 따로따로 저장한다.
  - **`for` 문 및 중첩 `for` 문:** 이름, 점수 입력, 계산, 출력을 모두 효율적으로 처리한다.
  - **평균 반올림 로직:** 소수점 셋째 자리에서 반올림해서 둘째 자리까지 존나 깔끔하게 만드는 로직이다!
  - **학점 계산 (`switch` 문):** 평균에 따라 학점을 존나게 똑똑하게 매긴다!
  - **석차 계산:** 모든 학생의 평균을 서로 비교해서 석차를 매긴다! (나보다 잘하는 놈 수 세기!)
 */

import java.io.*; // 'BufferedReader'랑 'IOException' 쓰려면 이 새끼들을 불러와야 한다, 씨발!

public class ArrayExam02 { // 'ArrayExam02'이라는 이름의 공개(public) 클래스를 선언한다.

	// ★★★ 프로그램 시작점 (메인 메소드) ★★★
	// `String[] args`는 '명령줄 인자(Command Line Arguments)'를 받는 배열이다.
	// 프로그램 실행 시 `java ArrayExam02 3 국어 영어 수학` 이런 식으로 '학생 수'와 '과목명들'을 넘겨줄 수 있다!
	public static void main(String[] args) throws IOException { // 입출력 오류 생길 수 있으니 'throws IOException' 박아둔다!

		// ★★★ 사용자 입력받을 준비! (BufferedReader 버전!) ★★★
		// 'BufferedReader' 객체를 만들어서 시스템 입력(키보드)을 한 줄씩 읽어들인다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// ★★★ 명령줄 인자 검증 (최소한 학생 수라도 입력했는지 확인!) ★★★
		if (args.length == 0) {
			System.out.println("명령줄 인자가 없습니다. (예: java ArrayExam02 3 국어 영어 수학)");
			System.exit(0); // 프로그램 강제 종료!
		}
		
		// ★★★ 총 학생 수와 과목명들을 명령줄 인자에서 가져온다! ★★★
		// `args[0]`은 총 학생 수를 나타낸다. 문자열이므로 `Integer.parseInt()`로 숫자로 바꿔준다!
		int human = Integer.parseInt(args[0]); // 첫 번째 명령줄 인자(학생 수)를 `human` 변수에 저장한다.
		// System.out.println(human); // (디버깅용 주석 처리된 코드)

		// ★★★ 학생 이름들을 저장할 배열 선언! ★★★
		String[] name = new String[human]; // `human` 수만큼의 String 배열을 만들어서 학생 이름을 저장한다.

		// ★★★ 과목명들을 저장할 배열 선언! ★★★
		// `args.length - 1`은 총 명령줄 인자에서 '학생 수'를 뺀 나머지, 즉 과목명의 개수다!
		String[] subject = new String[args.length - 1]; // 나머지 인자들(과목명)을 저장할 String 배열이다.
		// System.out.println(subject.length); // (디버깅용 주석 처리된 코드)

		// ★★★ 점수(과목별 + 총점)를 저장할 2차원 배열 선언! ★★★
		// `human` (학생 수)만큼의 행, 그리고 `args.length` (총 인자 수 = 학생수1 + 과목수)만큼의 열을 가진다.
		// `jumsu[i][0]~jumsu[i][subject.length-1]`은 각 과목 점수, `jumsu[i][subject.length]`는 총점 칸이 된다!
		int[][] jumsu = new int[human][args.length]; // `jumsu[학생][과목점수]`, 마지막 열은 총점.
		// System.out.println(args.length); // (디버깅용 주석 처리된 코드)
		
		float[] avg = new float[human]; // 각 학생의 평균을 저장할 `float` 배열.
		char[] hak = new char[human]; // 각 학생의 학점을 저장할 `char` 배열.
		int[] rank = new int[human];  // 각 학생의 석차를 저장할 `int` 배열. (기본값 0으로 초기화됨)
		
		// --- `args` 배열에 있는 과목명들을 `subject` 배열에 복사! ---
		// `args[0]`은 학생 수이므로, `args[1]`부터 `subject` 배열의 0번 인덱스에 복사한다!
		for (int i = 0; i < args.length - 1; i++) {
			subject[i] = args[i + 1];
		}
		
		/* (이전 디버깅용 주석 처리된 코드)
		for (int i = 0; i < subject.length; i++) {
				System.out.println(subject[i]);
			}
		}
		*/
		
		// --- 학생 수만큼 학생 이름 입력받고, 학생별 점수 입력 받고, 학생별 총점 구하기! (이중 for 문!) ---
		// ★★★ 바깥쪽 `for` 문 (`i`): 각 학생(`human` 수만큼)을 순회한다! ★★★
		for (int i = 0; i < human; i++) {
			System.out.print((i + 1) + "번째 학생 이름: "); // 몇 번째 학생인지 표시하며 이름 입력 안내.
			name[i] = br.readLine(); // 학생 이름을 입력받아 `name` 배열에 저장.
			
			System.out.println(name[i] + " 학생 점수 입력 "); // 현재 학생의 점수 입력을 안내.
			
			// ★★★ 안쪽 `for` 문 (`j`): 각 학생의 과목(`subject.length`만큼) 점수를 입력받고 총점 구함! ★★★
			for (int j = 0; j < subject.length; j++) {
				System.out.print(subject[j] + "점수: "); // 어떤 과목 점수를 입력할지 메시지 출력.
				jumsu[i][j] = Integer.parseInt(br.readLine());  // 과목별 점수를 입력받아 `int`로 변환하여 `jumsu` 2차원 배열에 저장.
				
				// ★★★ 입력받은 과목 점수를 해당 학생의 총점 칸에 누적! ★★★
				// `jumsu[i][subject.length]`는 현재 `i`번째 학생의 총점 칸이다!
				jumsu[i][subject.length] += jumsu[i][j]; // `subject.length`는 과목의 개수이자 총점 칸의 인덱스.
			}
		}

		// --- 각 학생별 평균 구하기! ---
		for (int i = 0; i < human; i++ ) {
			// 총점(`jumsu[i][subject.length]`)을 과목 수(`subject.length`)로 나눠서 평균 구한다!
			// `(float)`으로 형 변환해야 소수점까지 제대로 나온다, 씨발!
			avg[i] = (float)jumsu[i][subject.length] / subject.length;
					
		    // ★★★ 평균 반올림 계산: 소수점 셋째 자리에서 반올림해서 소수점 둘째 자리까지 표시! ★★★
			avg[i] = (int)((avg[i] + 0.005) * 100) / 100.0f; // 100.f 대신 100.0f를 써서 float 나눗셈을 명확히 한다.
		}
		
		// --- 각 학생별 학점 계산! (`switch` 문 활용) ---
		for (int i = 0; i < human; i++) {
			switch ((int)(avg[i] / 10)) { // 평균을 10으로 나눈 정수 값(예: 90점대 -> 9)으로 판단한다!
				case 10:
				case 9: hak[i] = 'A'; // 100점대 또는 90점대는 'A' 학점!
				break;
				case 8: hak[i] = 'B'; // 80점대는 'B' 학점!
				break;
				case 7: hak[i] = 'C'; // 70점대는 'C' 학점!
				break;
				case 6: hak[i] = 'D'; // 60점대는 'D' 학점!
				break;
				default: hak[i] = 'F'; // 60점 미만은 'F' 학점!
				break;
			}
		}

		// --- 각 학생별 석차 계산! (존나게 중요! 이중 for 문!) ---
		// 모든 학생의 석차를 일단 1등으로 초기화!
		for (int i = 0; i < human; i++) {
			rank[i] = 1; // 기본적으로 자기 자신이 1등이라고 가정한다.
		}

		// ★★★ 바깥쪽 `for` 문 (`i`): 자기 자신의 평균과 비교할 학생(`i`)을 선택한다! ★★★
		for (int i = 0; i < human; i++) {
			// ★★★ 안쪽 `for` 문 (`j`): 다른 학생(`j`)들의 평균을 불러와서 비교한다! ★★★
			for (int j = 0; j < human; j++) {
				// ★★★ 비교 로직! ★★★
				// 만약 내 평균(`avg[i]`)이 다른 학생(`avg[j]`)의 평균보다 낮으면,
				// 내 석차(`rank[i]`)를 1 증가시킨다! (나보다 잘하는 놈이 한 명 늘었다는 뜻!)
				if (avg[i] < avg[j]) {
					rank[i]++; // 석차 1 증가!
				}
			}
		}
		// 여기까지가 이름 입력 받고, 과목별 점수 입력 받고, 총점 구하고, 평균 구하고, 학점 구하고, 석차까지 계산 완료!
		
		// --- 모든 결과 출력! (존나 멋진 성적표!) ---
		System.out.println("\n\t--------성적표 출력---------");
		System.out.print("이 름\t"); // '이름' 헤더 출력 후 탭.

		// --- 과목명 헤더 출력! ---
		for (int j = 0; j < subject.length; j++) {
			System.out.print(subject[j] + "\t"); // 각 과목명 출력 후 탭.
		}
		System.out.println("총점\t평균\t학점\t석차"); // 총점, 평균, 학점, 석차 헤더 출력 후 줄 바꿈.

		// --- 각 학생별 최종 정보 출력! ---
		for (int i = 0; i < human; i++) {
			System.out.print(name[i] + "\t"); // 학생 이름 출력 후 탭.

			// 각 과목 점수와 총점 출력!
			// `subject.length + 1`은 과목 수 + 총점 칸까지 다 돌기 위함이다!
			for(int j = 0; j < subject.length + 1; j++) {
				System.out.print(jumsu[i][j] + "\t"); // 각 점수(및 총점) 출력 후 탭.
			}
			// 최종 평균, 학점, 석차 출력!
			// `avg[i]`는 `%.2f`로 소수점 둘째 자리까지 깔끔하게 출력된다.
			// `hak[i]`와 `rank[i]`는 해당 값 그대로 출력.
			System.out.printf("%.2f\t%c\t%d%n", avg[i], hak[i], rank[i]); // 평균, 학점, 석차 출력.
		}

        // ★★★ BufferedReader 닫기! (존나 중요!) ★★★
		br.close(); // 다 쓴 `BufferedReader`는 꼭 닫아줘야 한다!
	}
}
