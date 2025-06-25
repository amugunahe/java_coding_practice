package com.loop;

import java.util.*; // Scanner 쓰려면 이거 필수 임포트

public class WhileEx04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력받을 준비 완료!

		// 핵심 1: `while(true)`는 무한 반복을 의미한다.
		// 이 반복문은 조건 없이 계속 돌다가, 안에서 `break`나 `return`, 또는 `System.exit()`를 만나면 멈춘다.
		while (true) { 
			System.out.print("계속 진행 하시겠습니까?(y/n)"); // 사용자에게 질문 출력
			
			// 핵심 2: 사용자 입력받기 (문자열로 받아서 첫 글자만 char로 뽑아냄)
			char ch = sc.next().charAt(0); 

			// 핵심 3: 입력받은 문자가 'n' 또는 'N'이면 프로그램 종료
			if (ch == 'n' || ch == 'N') { // 'n'이거나 'N'이면 참
				System.out.println("프로그램을 종료합니다."); // 종료 메시지 출력
				System.exit(0); // ★ 중요: JVM 자체를 종료시킨다. (가장 확실한 프로그램 종료 방법)
				
				// 아래 주석 처리된 부분은 프로그램 종료를 시도할 수 있는 다른 방법들:
				// return; // main 메소드를 종료시킨다. (결과적으로 프로그램 종료)
				// break;  // while 반복문만 종료시킨다. (main 메소드는 계속 실행될 수 있음)
			}
            // 'y'나 다른 문자가 입력되면, if문에 걸리지 않고 while(true) 때문에 다시 질문으로 돌아간다.
		}
        // 이 코드에서는 System.exit(0) 때문에 여기에 도달할 일이 없지만,
        // 만약 break를 사용했다면 여기에 sc.close()를 넣어줘야 한다.
	}
}
