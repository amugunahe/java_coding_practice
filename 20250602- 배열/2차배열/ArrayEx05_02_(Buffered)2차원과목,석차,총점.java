package com.arraytwo;

import java.io.*;

public class ArrayEx05_02 {

public static void main(String[] args) throws IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	String[] subname = { "국어점수", "영어점수", "수학점수" };

	int sub[][] = new int[3][subname.length + 2];
	// 0: 첫번째 사람, 1: 두번째 사람, 2: 세번째 사람
	// sub[0]:국어점수, sub[1]: 영어점수, sub[2]:수학점수, sub[3]:총점, sub[4]:석차
	
	float[] avg = new float[3];

	for (int k = 0; k < sub.length; k++) {
		System.out.println(k + 1 + "번째 사람 ");
	
		for (int i = 0; i < sub[k].length - 2; i++) {
			do {
				System.out.print(subname[i] + ":");
				sub[k][i] = Integer.parseInt(br.readLine());
				// 각 과목별 점수 입력
			} while (sub[k][i] < 0 || sub[k][i] > 100);
			// 입력받은 과목의 총점을 구함
			// 총점
			sub[k][sub[k].length - 2] += sub[k][i];
		} // end for(i)
			// 평균:
		avg[k] = sub[k][sub[k].length - 2] / (float) (sub[k].length - 2);
		sub[k][sub[k].length - 1] = 1;

	} // end for(k)

	
	for(int k = 0; k<sub.length; k++){
	for(int i = 0; i<sub.length; i++) {
		if(sub[k][sub[k].length - 2]<sub[i][sub[i].length - 2]) {
			sub[k][sub[k].length - 1]++;
		}
	}
}

	for(int k = 0; k < sub.length; k++){
		System.out.println(k+1+"번째 사람 ");
		System.out.println("석차: " + sub[k][sub[k].length - 1] + "등");
		System.out.println("총점: " + sub[k][sub[k].length - 2]);
		System.out.printf("평균: %.2f%n", avg[k]);
	}
	
}
}
