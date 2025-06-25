package dowhileex;

/* 문] do~while문을 이용하여 아래와 같이 출력하도록 프로그램을 구현하시오.
  
*****
****
***
**
* 
*/

public class DoWhileEx05 {

	public static void main(String[] args) {

		int i = 5; // ★ 핵심1: 바깥 do-while문의 반복 횟수(줄 수)와 각 줄의 시작 별 개수를 결정

		// 바깥 do-while문: 줄(행)을 제어한다. i는 5부터 시작해서 1씩 감소하며 반복.
		do {
			int j = 0; // ★ 핵심2: 안쪽 do-while문의 별 개수를 세는 변수 (매 줄마다 0으로 초기화)
			
			// 안쪽 do-while문: 각 줄에 찍힐 별(*)의 개수를 제어한다.
			// j는 0부터 시작해서 i보다 작을 때까지 반복 (결국 i개만큼 별을 찍음)
			do {
				System.out.print("*"); // 별(*) 하나 출력 (줄바꿈 없음)
				j++; // j를 1 증가시킨다.
			} while (j < i); // j가 i보다 작을 때까지 반복 (즉, i개만큼 별을 찍는다)
			
			System.out.println(); // 한 줄의 별 출력이 끝나면 다음 줄로 이동
			i--; // i를 1 감소시킨다. (다음 줄에는 별이 하나 줄어든다)
		} while (i > 0); // i가 0보다 클 때까지 반복 (i가 1일 때까지 별 찍고 끝남)
	}
}
