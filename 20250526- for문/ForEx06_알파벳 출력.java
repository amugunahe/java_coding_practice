package com.loop;

public class ForEx06 {

	public static void main(String[] args) {
		
		// 1. char 변수 써서 'A'부터 'Z'까지 출력
		for (char ch = 'A'; ch <= 'Z'; ch++) { 
			System.out.print(ch + " "); // 알파벳 한 칸 띄어서 옆으로 쭉 출력
		}
		System.out.println(); // 한 줄 띄우고
		System.out.println(); // 또 한 줄 띄우기 (두 줄 띄운 거 확인)
		
		// 2. int 변수랑 아스키 코드 써서 'A'부터 'Z'까지 출력
		// 'A'의 아스키 코드는 65, 'Z'는 90이다.
		for (int ch = 65; ch <= 90; ch++) { 
			System.out.print((char) ch + " "); // 숫자를 char로 강제 형변환해서 알파벳으로 출력
		}
		System.out.println(); // 한 줄 띄우기
		
		// 3. 중첩 for문으로 알파벳 감소 삼각형 출력 (네가 의도한 패턴)
		for (char ch = 'A'; ch <= 'Z'; ch++) { // 바깥 for문: 'A'부터 'Z'까지 줄(행)을 반복
			for (char bb = ch; bb <= 'Z'; bb++) { // 안쪽 for문: 현재 줄에서 'ch'부터 'Z'까지 출력
				System.out.print(bb); // 알파벳 출력 (줄바꿈 없음)
			}
			System.out.println(); // 한 줄 출력 끝나면 다음 줄로
		}
	}
}
