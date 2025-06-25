package dowhileex;

/* 문] do ~while문을 이용하여 1에서 10까지 덧셈으로 표시하고 합계를 구하는 
 프로그램을 구현하시오. 
 
결과 
1+2+3+4+5+6+7+8+9+10 == 55 
*/


public class DoWhileEx03 {

	public static void main(String[] args) {
		
		int sum = 0; // 합계를 저장할 변수 (0으로 초기화 필수!)
		int i = 1;   // 1부터 더해나갈 숫자 (1로 초기화)
		
		// 핵심: do-while문으로 1부터 10까지 반복하면서 sum에 더한다.
		do { 
			sum += i; // 현재 i 값을 sum에 더한다.
			i++;      // i를 1 증가시킨다.
		} while (i <= 10); // i가 10보다 작거나 같을 때까지 반복
		
		System.out.println(sum); // 최종 합계만 출력
	}
}
