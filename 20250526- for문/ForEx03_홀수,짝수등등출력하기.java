package com.loop;

public class ForEx03 {

	public static void main(String[] args) {
		
		/* 주석 처리된 부분 설명:
		  int sum = 0; // 이 변수는 현재 코드에서 사용 안 됨.
		  * // for문 초기값, 조건식, 증감식에 여러 변수를 동시에 사용하는 예시 (콤마로 구분)
		  for (int i = 1, j = 10, k = 10; i <= 10; i++, j--, k--) {
		  System.out.println(i + " => " + j + " => " + k);
		  }
		  이건 for문의 유연성을 보여주는 좋은 예시지만,
		  지금 네가 짠 아래 코드랑은 상관 없다.
		 */
		
		// 헤더 출력: 각 컬럼의 제목을 탭(\t)으로 구분해서 출력한다.
		System.out.println("i\t 2 * i\t 2 * i - 1\t i * i\t 11 - i\t i % 3\t i / 3");
		// 헤더 아래 구분선 출력: 깔끔하게 표처럼 보이게 한다.
		System.out.println("---------------------------------------");
		
		// 핵심: 1부터 10까지 i를 증가시키면서 다양한 계산 결과를 한 줄에 출력
		for (int i = 1; i <= 10; i++) { // i는 1부터 10까지 1씩 증가하면서 반복
			// printf를 사용해서 각 계산 결과를 특정 형식에 맞춰 출력
			// %d: 정수 출력 형식 지정자
			// \t: 탭 (일정 간격 띄우기)
			// %n: 운영체제에 맞는 줄바꿈 문자 (println과 유사)
			System.out.printf("%d\t %d\t %d\t %d\t %d\t %d\t %d%n", i, 2 * i, 2 * i - 1, i * i, 11 - i, i % 3, i / 3);
		}
	}
}
