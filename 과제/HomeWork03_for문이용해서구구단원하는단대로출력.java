package com.test;

import java.util.Scanner; // 사용자 입력을 받기 위해 Scanner 클래스를 임포트합니다.

public class HomeWork03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 사용자 입력을 위한 Scanner 객체를 생성합니다.
		
		System.out.print("단 입력: "); // 사용자에게 '단'을 입력하라는 메시지를 출력합니다.
		int n = sc.nextInt(); // 사용자로부터 정수(몇 단씩 묶을지)를 입력받아 n 변수에 저장합니다.
		
		// i: 시작 단을 제어하는 변수 (n개씩 건너뛰며 그룹의 시작 단을 지정)
		// j: 각 단의 곱해지는 수 (1부터 9까지)
		// k: 현재 그룹 내에서 몇 번째 단을 출력할지 제어하는 변수
		int i, j, k;  
		
		// 첫 번째 외부 for 루프: 구구단 그룹의 시작 단을 결정하며, n개씩 건너뛰며 반복합니다.
		// 예: n이 3이면 i는 1, 4, 7로 진행되어 1-3단, 4-6단, 7-9단 그룹을 처리합니다.
		for (i = 1; i < 9; i += n) { 
			// 두 번째 for 루프: 각 단의 곱해지는 수(1부터 9까지)를 제어합니다. (세로 줄)
			for (j = 1; j <= 9; j++) { 
				// 세 번째 for 루프: 한 행에 n개의 단을 출력하기 위해 현재 그룹 내의 단들을 반복합니다.
				for (k = 0; k < n; k++) { // k를 0부터 시작하여 i+k가 실제 단이 되도록 합니다.
					// 현재 계산하려는 단(i+k)이 9단 이하인 경우에만 출력합니다. (10단 이상은 출력하지 않음)
					if ((i + k) <= 9) {
						// %d * %d = %d 형태로 출력하고, \t\t (탭 2번)으로 단들 사이에 간격을 둡니다.
						System.out.printf("%d * %d = %d\t\t", (i + k), j, ((i + k) * j));
					}
				}
				System.out.println(); // 한 행(j에 해당하는 모든 단의 계산)이 끝나면 줄을 바꿉니다.
			}
			System.out.println(); // 한 그룹(i에 해당하는 모든 단)이 끝나면 추가로 줄을 바꿉니다. (그룹 간의 간격)
		}
		
		sc.close(); // Scanner 객체를 닫아 리소스를 해제합니다.
	}
}
