package com.arraytwo;

/*
 * 문] 과목별 점수를 입력받아 총점과 평균
 * 
 */

import java.io.*;

public class ArrayEx04 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] subname = { "국어점수", "영어점수", "수학점수" };

		int sub[] = new int[subname.length + 1];
		// sub[0]:국어점수, sub[1]: 영어점수, sub[2]:수학점수, sub[3]:총점
		float avg = 0.0f;

		for (int i = 0; i < sub.length - 1; i++) {
			do {
				System.out.print(subname[i] + ":");
				sub[i] = Integer.parseInt(br.readLine());
				// 각 과목별 점수 입력
			} while (sub[i] < 0 || sub[i] > 100);
			// 입력받은 과목의 총점을 구함
			sub[sub.length - 1] += sub[i]; // sub[3]
		}
		avg = sub[sub.length - 1] / (float) (sub.length - 1);

		System.out.println(sub[sub.length - 1]);
		System.out.printf("평균: %.2f", avg);
	}

}