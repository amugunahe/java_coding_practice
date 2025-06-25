package dowhileex;

/* 문] 난수를 이용하여 1과 100 사이의 임의의 수를 변수에 저장하고, 
  이 값을 맞출때까지 반복하는 프로그램을 구현
 
 사용자가 입력한 값을 변수 input, 
 난수는 answer 변수에 저장
 두 값을 비교해서 같으면 반복문을 종료
 */

import java.util.*; // Scanner 쓰려면 필수 임포트

public class DoWhileEx01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 사용자 입력받을 준비 완료!

		// 변수 선언: input (사용자 입력), answer (정답 난수)
		int input = 0, answer = 0; 

		// 핵심 1: 1부터 100 사이의 랜덤(난수) 정수 생성
		// Math.random()은 0.0 이상 1.0 미만의 double 값을 반환.
		// * 100 하면 0.0 ~ 99.999...
		// (int)로 강제 형변환하면 0 ~ 99
		// + 1을 하면 1 ~ 100 사이의 정수가 됨.
		answer = (int) (Math.random() * 100) + 1; 
		// System.out.println(answer); // 이 줄은 개발 중에 정답 확인용으로 쓰는 거다. 나중에 지워도 됨.

		// 핵심 2: do-while문으로 사용자 입력받고 정답 맞출 때까지 반복
		do { 
			System.out.print("1 ~ 100 사이의 정수 입력: ");
			input = sc.nextInt(); // 사용자에게 숫자 입력받기

			// 핵심 3: 입력값과 정답 비교해서 힌트 주기
			if (input > answer) { // 입력값이 정답보다 크면
				System.out.println("더 작은 수를 입력하세요."); // 힌트 출력
			} else if (input < answer) { // 입력값이 정답보다 작으면
				System.out.println("더 큰 수를 입력하세요."); // 힌트 출력
			}
			// while 조건: input과 answer가 같지 않으면(정답이 아니면) 다시 do 블록 실행
		} while (input != answer); 

		// 반복문이 끝나면 (정답을 맞추면) 출력되는 메시지
		System.out.print(input + " 값과 " + answer + " 값이 같습니다.");
		System.out.println("정답입니다!!!");
        sc.close(); // Scanner 다 썼으면 자원 해제 필수!
	}
}
