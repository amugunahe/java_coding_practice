package com.arrayExam;

/* 문] 2차원 배열을 이용하여 여러명에 대한 성적 처리 프로그램을 구현하시오.
*/

import java.io.*;

public class ArrayExam02 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int human = Integer.parseInt(args[0]); // 사람수
		// System.out.println(human);

		String[] name = new String[human]; // 이름을 저장할 공간
		String[] subject = new String[args.length - 1]; // 과목명 초기화
		// System.out.println(subject.length);

		// 정수와 총점 처리 배열을 선언
		int[][] jumsu = new int[human][args.length]; // [2][4]
		// System.out.println(args.length);
		
		float[] avg = new float[human];
		char[] hak = new char[human];
		int[] rank = new int[human];
		
		// args 배열에 있는 과목명을 subject 배열에 저장
		for (int i = 0; i < args.length - 1; i++) {
			subject[i] = args[i + 1];
			}
		
		/* for (int i = 0; i < subject.length; i++) {
				System.out.println(subject[i]);
			}
		}
		*/
		
		// 사람 수만큼 학생 이름 입력받고, 학생별 점수 입력 받고, 학생별 총점을 구한다. 
		for (int i = 0; i < human; i++) {
			System.out.print(i + 1 + "번째 학생 이름:");
			name[i] = br.readLine();
			
			System.out.println(name[i] + "학생 점수 입력 ");
			
			// 과목 수만큼 점수 입력받고 총점 구함
			for (int j = 0; j < subject.length; j++) {
				System.out.print(subject[j] + "점수:");
				jumsu[i][j] = Integer.parseInt(br.readLine());  // 과목별 점수 입력
				
				jumsu[i][subject.length] += jumsu[i][j]; // 총점 
			}
		}
		// 평균 구하기
		for (int i = 0; i < human; i++ ) {
			avg[i] = (float)jumsu[i][subject.length] / subject.length; 
					
		// 소수점 셋째 자리에서 반올림해서 소수점 둘째 자리 까지 표시
			avg[i] = (int)((avg[i] + 0.005) * 100) / 100.f;
		}
		
		// 학점 계산
		for (int i = 0; i < human; i++) {
			
			switch ((int)(avg[i] / 10)) {
				case 10:
				case 9: hak[i] = 'A'; 
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
		// 석차 계산
		for (int i = 0; i < human; i++) {
			rank[i]++;
			for (int j = 0; j < human; j++) {
				if (avg[i] < avg[j]) {
					rank[i]++;
				}
			}
		}
		// 여기까지가 이름 입력 받고, 과목별 점수 입력 받고, 총점 구하고, 평균 구하고, 학점 구하고, 석차까지 계산완료 
		
		
		// 모든 결과 출력
		System.out.println("\t--------성적표 출력---------");
		System.out.print("이 름\t");
		for (int j = 0; j < subject.length; j++) {
			System.out.print(subject[j] + "\t");
		}
		System.out.println("총점\t평균\t학점\t석차");
		for (int i = 0; i < human; i++) {
			System.out.print(name[i] + "\t");

			for(int j = 0; j < subject.length + 1; j++) {
				System.out.print(jumsu[i][j] + "\t");
				}
			System.out.println(avg[i] + "\t" + hak[i] + "\t" + rank[i]);
			}
		}
}
