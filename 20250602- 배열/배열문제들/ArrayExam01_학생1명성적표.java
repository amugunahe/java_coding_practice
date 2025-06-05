package com.arrayExam;

/*
 * 문] 1명의 학생에 대해 성적 처리 프로그램을 구현하시오.
 * 	  과목명1~~~~과목명n과 같이 함
 *
 *  // run - run configurations- Arguments
 *
 */
import java.io.*;

public class ArrayExam01 {

	public static void main(String[] ar) throws IOException {
		// String[] subject = {"국어", "영어", "수학"};

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		if (ar.length == 0) {
			System.out.println("배열에 저장된 값이 없습니다.");
			System.exit(0);
		} // ar.length == 과목수 value = 과목명

		System.out.print("이름: ");
		String name = br.readLine();

		String[] subject = new String[ar.length];

		// 과목명 = ar.length -> subject

		for (int i = 0; i < ar.length; i++) {
			subject[i] = ar[i];
		}
		int[] jumsu = new int[subject.length + 1]; // 총점이 들어갈 자리
		// 4 -> 0: 국어, 1: 영어, 2: 수학, 3: 총점

		// 점수 입력 받기
		for (int i = 0; i < jumsu.length - 1; i++) {
			System.out.print(subject[i] + "점수: ");
			jumsu[i] = Integer.parseInt(br.readLine());
			// 총점 -> 누적합계
			jumsu[jumsu.length - 1] += jumsu[i];
		}
		// System.out.println(jumsu[jumsu.length - 1]);
		float avg = jumsu[jumsu.length - 1] / (float) subject.length;
		// 소수점 3자리에서 반올림
		avg = (int) ((avg + 0.005) * 100) / 1000.f;
		// System.out.println(avg);

		char hak = 0;
		switch ((int) (avg / 10)) {
		case 10:
		case 9:
			hak = 'A';
			break;
		case 8:
			hak = 'B';
			break;
		case 7:
			hak = 'C';
			break;
		case 6:
			hak = 'D';
			break;
		default:
			hak = 'F';
			break;
		}
		System.out.println();
		System.out.println("*********성적표*********");
		System.out.print("이름\t");
		for (int i = 0; i < subject.length; i++) {
			System.out.print(subject[i] + "\t");
		}
		System.out.println("총점\t평균\t\t학점");
		System.out.print(name + "\t");
		for(int i = 0 ; i< subject.length+1; i++) {
		System.out.print(jumsu[i]+"\t");
		}
		System.out.println(avg+"\t\t"+hak);
		}	
	
	}


