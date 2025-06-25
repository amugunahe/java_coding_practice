package com.loop;

// while문을 이용하여 구구단 출력

public class WhileEx05 {

	public static void main(String[] args) {

		int i = 2, j; // i는 단수 (2단, 3단...), j는 곱해지는 수 (1, 2, 3...)
		
		// 바깥쪽 while문: 단수를 제어한다 (2단부터 9단까지)
		while (i <= 9) { // i가 9보다 작거나 같을 때까지 반복
			j = 1; // ★ 핵심: 안쪽 while문이 시작될 때마다 j를 1로 다시 초기화해야 한다.
                   // 이거 없으면 j가 계속 9보다 커져서 안쪽 while문이 한 번밖에 안 돈다.
			
			// 안쪽 while문: 각 단의 곱셈을 제어한다 (x1부터 x9까지)
			while (j <= 9) { // j가 9보다 작거나 같을 때까지 반복
				// %d: 정수 출력, %n: 운영체제에 맞는 줄바꿈
				System.out.printf("%d * %d = %d%n", i, j, i * j); // 구구단 곱셈 결과 출력
				j++; // j를 1 증가시킨다 (다음 곱셈으로 이동: x1 -> x2)
			}
			i++; // i를 1 증가시킨다 (다음 단으로 이동: 2단 -> 3단)
			System.out.println(); // 한 단의 출력이 끝나면 다음 단과 구분되도록 한 줄 띄우기
		}
	}
}
