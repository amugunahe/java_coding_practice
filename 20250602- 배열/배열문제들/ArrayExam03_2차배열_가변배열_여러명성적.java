package com.arrayExam;

/* 문] 가변배열을 이용하여 학생마다 과목명을 다르게 하여 성적 처리하는 프로그램을 구현.
*/

import java.io.*;

public class ArrayExam03 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int human = Integer.parseInt(args[0]); // 사람 수를 받음
		
		String[] name = new String[human]; // 이름을 저장할 공간
		
		String[][] subject = new String[human][]; 

		int[][] jumsu = new int[human][]; 
		
		float[] avg = new float[human];
		char[] hak = new char[human];
		int[] rank = new int[human];
	
		for (int i = 0; i < human; i++) {
			System.out.print("이름: ");
			name[i] = br.readLine();
			
			System.out.print("과목 수: ");
			int imsi = Integer.parseInt(br.readLine());
			subject[i] = new String[imsi];
			
			for (int j = 0; j < subject[i].length; j++) {
				System.out.print((j + 1) + "번째 과목: ");
				subject[i][j] = br.readLine();
			}
			
			jumsu[i] = new int[imsi + 1];
			for (int j = 0; j < subject[i].length; j++) {
				System.out.print(subject[i][j] + "과목 점수: ");
				jumsu[i][j] = Integer.parseInt(br.readLine()); // 과목 점수
				jumsu[i][jumsu[i].length - 1] += jumsu[i][j]; // 총점
			}
		} // 입력 작업 끝
		
		// 평균 구하기 
		for (int i = 0; i < human; i++ ) {
			avg[i] = jumsu[i][jumsu[i].length - 1] / (float)subject[i].length; 
					
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
					rank[i] = 1;
					for (int j = 0; j < human; j++) {
						if (avg[i] < avg[j]) {
							rank[i]++;
						}
					}	
				}
					// 모든 결과 출력
				for (int i = 0; i < human; i++) {
						System.out.println("\t-------" + name[i] + "학생 성적표 출력---------");
						System.out.print("이름\t");
						for(int j = 0; j < subject[i].length; j++) {
							System.out.print(subject[i][j] + "\t");
						}
						System.out.println("총점\t평균\t학점\t석차");
						
						System.out.print(name[i] + "\t");
						
						for(int j = 0; j < jumsu[i].length; j++) {
							System.out.print(jumsu[i][j] + "\t");
							}
						System.out.println(avg[i] + "\t" + hak[i] + "\t" + rank[i]);
						}
					}
				}
	
