package com.loop;

/* 반복문 형식
for(초기 값; 조건식; 증감식){
반복 수행할 문장;
} 
*/

public class ForEx01 {

	public static void main(String[] args) {
		
		int i; // 반복에 사용할 변수 'i'를 선언. (for문 안에서 선언해도 됨)
 
		// 1. 1부터 100까지 "I can do it." 100번 출력
		for (i = 1; i <= 100; i++) { // i를 1로 시작해서 100까지 1씩 증가시키면서 반복
			System.out.println("I can do it."); // 반복할 내용
		}
		System.out.println(); // 한 줄 띄기 (깔끔하게 보라고)
		
		// 2. 10부터 1까지 숫자를 역순으로 출력
		for (i = 10; i >= 1; i--) { // i를 10으로 시작해서 1까지 1씩 감소시키면서 반복
			System.out.print(i + "\t"); // 숫자 출력하고 탭(tab)으로 간격 띄우기
		}
		System.out.println(); // 한 줄 띄기
		
		// 3. 1부터 시작해서 3을 곱하면서 10까지 출력 (1, 3, 9)
		for (i = 1; i <= 10; i *= 3) { // i를 1로 시작, 10까지 3배씩 증가시키면서 반복
			System.out.print(i + "\t"); // 숫자 출력하고 탭으로 간격 띄우기
		}
		System.out.println(); // 한 줄 띄기
		
		// 4. 1부터 시작해서 3을 더하면서 10까지 출력 (1, 4, 7, 10)
		for (i = 1; i <= 10; i += 3) { // i를 1로 시작, 10까지 3씩 증가시키면서 반복
			System.out.println(i + "\n"); // 숫자 출력하고 줄바꿈 (새로운 줄로)
		}
		
		/* 주석 처리된 부분에 대한 설명:
		  for문 초기값, 증감식을 비워두는 것도 가능은 함.
		  하지만 초보자 땐 헷갈리니까 웬만하면 다 채워서 쓰는 게 좋다.
		 */
	}
}
