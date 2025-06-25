package dowhileex;

public class DoWhileEx02 {

	public static void main(String[] args) {
		
		// 바깥쪽 for문: 1부터 100까지의 숫자를 하나씩 처리 (총 100번 반복)
		for (int i = 1; i <= 100; i++) { 
			System.out.printf("i = %d ", i); // 현재 숫자 i를 출력

			int temp = i; // ★ 핵심1: 현재 숫자 i를 temp 변수에 복사 (원본 i를 건드리지 않기 위해)

			// 안쪽 do-while문: temp 변수의 각 자리수를 검사한다.
			// 최소 한 번은 실행하고, temp가 0이 될 때까지 반복
			do {
				// ★ 핵심2: 현재 자리수가 3의 배수(0 제외)인지 확인
				// temp % 10: temp의 '일의 자리' 숫자를 구한다. (예: 97 % 10 = 7)
				// % 3 == 0: 그 숫자가 3의 배수인지 확인한다. (예: 7 % 3 = 1 -> 3의 배수 아님)
				// temp % 10 != 0: 0은 3의 배수지만 '짝'으로 치지 않기 위해 0이 아님을 확인.
				if (temp % 10 % 3 == 0 && temp % 10 != 0) { 
					System.out.print("짝"); // 조건 맞으면 "짝" 출력
				}
				// ★ 핵심3: temp를 10으로 나눠서 다음 자리수를 일의 자리로 가져온다.
				// temp /= 10; 는 temp = temp / 10; 와 같다.
				// (예: 97 -> 9, 9 -> 0)
			} while ((temp /= 10) != 0); // temp가 0이 아니면 계속 반복 (모든 자리수를 확인할 때까지)
			System.out.println(); // 한 숫자에 대한 처리 끝나면 다음 줄로
		}
	}
}
