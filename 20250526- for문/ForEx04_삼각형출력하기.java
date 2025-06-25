package com.loop;

import java.util.Scanner; // 사용자 입력(Scanner) 쓰려면 이거 필수 임포트

public class ForEx04 {

	public static void main(String[] args) {
		
/* 노가다 방법
System.out.println("**********"); // 이렇게 일일이 찍으면 노가다.
System.out.println("**********"); // 라인 수 바뀌면 코드 다 바꿔야 함.
System.out.println("**********"); 
System.out.println("**********"); 
System.out.println("**********"); 
System.out.println("**********"); 
*/
		
		Scanner sc = new Scanner(System.in); // 사용자 입력받을 준비 완료!
		
		System.out.print("*을 입력할 라인 수 입력:"); // 몇 줄 찍을지 물어보는 메시지
		int line = sc.nextInt(); // 사용자가 입력한 정수를 'line' 변수에 저장. (핵심!)
		
		// 바깥쪽 for문: 줄(행)을 제어한다. 1부터 'line' 수까지 반복.
		for (int j = 1; j <= line; j++) { 
			// 안쪽 for문: 각 줄에 찍힐 별(*)의 개수를 제어한다.
			// 현재 줄 번호(j)만큼 별을 찍는다.
			for (int i = 1; i <= j; i++) { 
				System.out.print("*");	// 별(*) 하나 출력 (줄바꿈 없음)			
			}
			System.out.println(); // 한 줄의 별 출력이 끝나면 다음 줄로 이동
		}
        sc.close(); // Scanner 다 썼으면 자원 해제 필수!
	}
}
