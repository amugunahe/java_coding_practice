package com.arrayExam; // 이 코드 덩어리가 속한 폴더(패키지) 이름이다.

/*
  ArrayExam03 클래스: **'가변 배열(Ragged Array)'을 활용해서 학생마다 과목 수와 과목명을 존나게 다르게 처리하는 성적 프로그램이다!**
 
  핵심:
  - **문제:** 프로그램 실행 시 '명령줄 인자(Arguments)'로 '총 학생 수'만 입력받는다.
  그 후 각 학생별로 이름을 입력받고, **각 학생마다 '과목 수'를 따로 입력받아 그 수만큼 '과목명'과 '점수'를 입력받는다!**
 프로그램은 각 학생별 총점, 평균, 학점을 계산하고, 석차까지 매겨서 존나게 멋진 성적표를 출력한다!
 - **'run - run configurations - Arguments'**: 여기서 `main` 메소드의 `String[] args`로 전달될 값들을 설정한다.
  (예: `2` 이렇게 입력하면 `args[0]`에 "2" (학생 수)만 들어간다, 씨발!)
  - **`BufferedReader`:** 키보드 입력을 한 줄씩 읽어올 때 쓰는 존나 유용한 놈이다!
  - **`human` (총 학생 수):** 명령줄 인자의 첫 번째 값으로 받는다.
  - **`subject` 2차원 가변 배열:** `subject[학생번호]`마다 길이가 다른 `String` 배열을 가질 수 있다! (학생별 과목 수 달라짐!)
  - **`jumsu` 2차원 가변 배열:** `jumsu[학생번호]`마다 길이가 다른 `int` 배열을 가질 수 있다! (과목 수 + 총점 칸!)
  - **`avg`, `hak`, `rank` 배열:** 각 학생의 평균, 학점, 석차를 저장한다.
  - **`for` 문 및 중첩 `for` 문:** 이름, 과목명, 점수 입력, 계산, 출력을 모두 효율적으로 처리한다.
  - **평균 반올림 로직:** 소수점 셋째 자리에서 반올림해서 둘째 자리까지 존나 깔끔하게 만드는 로직이다!
  - **학점 계산 (`switch` 문):** 평균에 따라 학점을 존나게 똑똑하게 매긴다!
  - **석차 계산:** 모든 학생의 평균을 서로 비교해서 석차를 매긴다! (나보다 잘하는 놈 수 세기!)
 */

import java.io.*; // 'BufferedReader'랑 'IOException' 쓰려면 이 새끼들을 불러와야 한다, 씨발!

public class ArrayExam03 { // 'ArrayExam03'이라는 이름의 공개(public) 클래스를 선언한다.

	// ★★★ 프로그램 시작점 (메인 메소드) ★★★
	// `String[] args`는 '명령줄 인자(Command Line Arguments)'를 받는 배열이다.
	// 프로그램 실행 시 `java ArrayExam03 2` 이런 식으로 '학생 수'만 넘겨준다!
	public static void main(String[] args) throws IOException { // 입출력 오류 생길 수 있으니 'throws IOException' 박아둔다!

		// ★★★ 사용자 입력받을 준비! (BufferedReader 버전!) ★★★
		// 'BufferedReader' 객체를 만들어서 시스템 입력(키보드)을 한 줄씩 읽어들인다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// ★★★ 명령줄 인자 검증 (최소한 학생 수라도 입력했는지 확인!) ★★★
		if (args.length == 0) {
			System.out.println("명령줄 인자가 없습니다. (예: java ArrayExam03 2)");
			System.exit(0); // 프로그램 강제 종료!
		}
		
		// ★★★ 총 학생 수를 명령줄 인자에서 가져온다! ★★★
		// `args[0]`은 총 학생 수를 나타낸다. 문자열이므로 `Integer.parseInt()`로 숫자로 바꿔준다!
		int human = Integer.parseInt(args[0]); // 첫 번째 명령줄 인자(학생 수)를 `human` 변수에 저장한다.
		
		// ★★★ 학생 이름들을 저장할 배열 선언! ★★★
		String[] name = new String[human]; // `human` 수만큼의 String 배열을 만들어서 학생 이름을 저장한다.
		
		// ★★★ 과목명들을 저장할 2차원 '가변 배열' 선언! ★★★
		// 각 행(학생)마다 과목 수가 다를 수 있으니, 열 길이는 나중에 설정한다!
		String[][] subject = new String[human][]; // `subject[학생번호][과목명]`
		
		// ★★★ 점수(과목별 + 총점)를 저장할 2차원 '가변 배열' 선언! ★★★
		// 각 행(학생)마다 과목 수가 다를 수 있으니, 열 길이는 나중에 설정한다! (총점 칸까지 포함!)
		int[][] jumsu = new int[human][]; // `jumsu[학생번호][과목점수 또는 총점]`
		
		float[] avg = new float[human]; // 각 학생의 평균을 저장할 `float` 배열.
		char[] hak = new char[human]; // 각 학생의 학점을 저장할 `char` 배열.
		int[] rank = new int[human];  // 각 학생의 석차를 저장할 `int` 배열.
	
		// --- 각 학생별 이름, 과목 수, 과목명, 점수 입력받기! (존나 복잡한 중첩 for 문!) ---
		// ★★★ 바깥쪽 `for` 문 (`i`): 각 학생(`human` 수만큼)을 순회한다! ★★★
		for (int i = 0; i < human; i++) {
			System.out.println("\n--- " + (i + 1) + "번째 학생 정보 입력 ---");
			System.out.print("이름: ");
			name[i] = br.readLine(); // 학생 이름을 입력받아 `name` 배열에 저장.
			
			System.out.print("과목 수: "); // 각 학생마다 과목 수를 입력받는다! (존나 유동적!)
			int imsi = Integer.parseInt(br.readLine()); // 입력받은 과목 수를 `imsi`에 저장.

			// ★★★ 현재 학생의 과목명 배열 길이 설정! ★★★
			subject[i] = new String[imsi]; // `imsi` 수만큼의 과목명을 저장할 `String` 배열을 만든다.
			
			// --- 현재 학생의 과목명 입력받기! ---
			for (int j = 0; j < subject[i].length; j++) {
				System.out.print((j + 1) + "번째 과목: ");
				subject[i][j] = br.readLine(); // 과목명을 입력받아 `subject` 가변 배열에 저장.
			}
			
			// ★★★ 현재 학생의 점수 배열 길이 설정! (과목 수 + 총점 칸!) ★★★
			jumsu[i] = new int[imsi + 1]; // `imsi` 수만큼의 과목 점수 + 총점 칸 1개.
			
			// --- 현재 학생의 각 과목 점수 입력 및 총점 누적! ---
			// `subject[i].length`는 현재 학생의 과목 수를 의미한다!
			for (int j = 0; j < subject[i].length; j++) {
				System.out.print(subject[i][j] + "과목 점수: ");
				jumsu[i][j] = Integer.parseInt(br.readLine()); // 과목별 점수를 입력받아 `jumsu` 가변 배열에 저장.
				jumsu[i][jumsu[i].length - 1] += jumsu[i][j]; // 입력받은 점수를 현재 학생의 총점 칸에 누적!
			}
		} // --- 모든 학생의 정보 입력 끝 ---
		
		// --- 각 학생별 평균 구하기! ---
		for (int i = 0; i < human; i++ ) {
			// 총점(`jumsu[i][jumsu[i].length - 1]`)을 현재 학생의 과목 수(`subject[i].length`)로 나눠서 평균 구한다!
			// `(float)`으로 형 변환해야 소수점까지 제대로 나온다, 씨발!
			avg[i] = jumsu[i][jumsu[i].length - 1] / (float)subject[i].length;
					
		    // ★★★ 평균 반올림 계산: 소수점 셋째 자리에서 반올림해서 소수점 둘째 자리까지 표시! ★★★
			avg[i] = (int)((avg[i] + 0.005) * 100) / 100.0f; 
		}
		
		// --- 각 학생별 학점 계산! (`switch` 문 활용) ---
		for (int i = 0; i < human; i++) {
			switch ((int)(avg[i] / 10)) { 
				case 10:
				case 9: hak[i] = 'A'; // 100점대 또는 90점대는 'A' 학점!
				break;
				case 8: hak[i] = 'B'; 
				break;
				case 7: hak[i] = 'C'; 
				break;
				case 6: hak[i] = 'D'; 
				break;
				default: hak[i] = 'F'; 
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
				// 만약 내 평균(`avg[i]`)이 다른 학생(`avg[j]`)의 평균보다 낮으면,
				// 내 석차(`rank[i]`)를 1 증가시킨다! (나보다 잘하는 놈이 한 명 늘었다는 뜻!)
				if (avg[i] < avg[j]) {
					rank[i]++; // 석차 1 증가!
				}
			}	
		}
		// --- 여기까지 모든 계산 끝 ---
		
		// --- 모든 결과 출력! (존나 멋진 성적표!) ---
		for (int i = 0; i < human; i++) {
			System.out.println("\n\t-------" + name[i] + " 학생 성적표 출력---------"); // 학생 이름 포함된 헤더!
			System.out.print("이름\t"); // '이름' 헤더 출력 후 탭.

			// --- 과목명 헤더 출력! (학생별로 다를 수 있다!) ---
			for(int j = 0; j < subject[i].length; j++) {
				System.out.print(subject[i][j] + "\t"); // 각 과목명 출력 후 탭.
			}
			System.out.println("총점\t평균\t학점\t석차"); // 총점, 평균, 학점, 석차 헤더 출력 후 줄 바꿈.
			
			System.out.print(name[i] + "\t"); // 학생 이름 출력 후 탭.
			
			// --- 각 과목 점수와 총점 출력! (학생별로 길이가 다를 수 있다!) ---
			// `jumsu[i].length`는 현재 학생의 '과목 수 + 총점 칸'을 의미한다!
			for(int j = 0; j < jumsu[i].length; j++) {
				System.out.print(jumsu[i][j] + "\t"); // 각 점수(및 총점) 출력 후 탭.
			}
			// 최종 평균, 학점, 석차 출력!
			// `printf`를 써서 평균을 소수점 둘째 자리까지 깔끔하게 출력한다!
			System.out.printf("%.2f\t%c\t%d%n", avg[i], hak[i], rank[i]); // 평균, 학점, 석차 출력.
		}

        // ★★★ BufferedReader 닫기! (존나 중요!) ★★★
		br.close(); // 다 쓴 `BufferedReader`는 꼭 닫아줘야 한다!
	}
}
