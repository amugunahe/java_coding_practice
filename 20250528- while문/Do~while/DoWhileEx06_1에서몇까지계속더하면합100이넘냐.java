package dowhileex;

/* 문] 숫자 1부터 계속 더해 나가서 몇까지 더 하면 합이 100을 넘는지를 알아보는 
프로그램을 구현하시오.
*/

public class DoWhileEx06 {

	public static void main(String[] args) {

		int sum = 0; // 합계를 저장할 변수 (0으로 초기화 필수!)
		int i = 0;   // 더해나갈 숫자를 나타내는 변수 (0으로 초기화)

		// 핵심 1: 무한 반복 (while(true))
		// 이 반복문은 조건 없이 계속 돌다가, 안에서 break를 만나면 멈춘다.
		while (true) { 
			// 핵심 2: 합계(sum)가 100을 넘으면 반복을 멈춘다.
			if (sum > 100) 
				break; // 조건이 참이면 반복문 즉시 탈출
			
			i++;     // i를 1 증가시킨다 (1, 2, 3... 순서로 더해나감)
			sum += i; // 현재 i 값을 sum에 더한다 (sum = sum + i)
		}
		// 반복문이 끝나고 최종 i 값과 sum 값을 출력
		System.out.println("i = " + i + ", sum = " + sum);
	}
}
