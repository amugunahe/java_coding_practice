package com.loop;

public class ForEx05 {

	public static void main(String[] args) {
		
		// 바깥쪽 for문: 행(줄)을 제어한다. i는 1부터 9까지 증가.
		for (int i = 1; i <= 9; i++) { 
			// 안쪽 for문: 열(칸)을 제어한다. j는 1부터 9까지 증가.
			for (int j = 1; j <= 9; j++) { 
				// 핵심 로직: i와 j가 같을 때만 숫자를 출력한다. (대각선 조건)
				if (i == j) { // 현재 행(i)과 열(j)의 값이 같으면
					System.out.printf("[%d, %d]", i, j); // "[행, 열]" 형식으로 출력
				} else { // i와 j가 다르면
					System.out.printf("%8c",' '); // 8칸짜리 공백을 출력해서 간격 맞추기
				}
			}
			System.out.println(); // 한 줄 출력 끝나면 다음 줄로 이동
		}
	}
}
