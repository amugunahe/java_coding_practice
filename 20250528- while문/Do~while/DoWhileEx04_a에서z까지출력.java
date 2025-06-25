package dowhileex;

// a~z까지 출력

public class DoWhileEx04 {

	public static void main(String[] args) {

		char c = 'a'; // ★ 핵심: 'a'부터 시작하는 char 변수 선언

		// do-while문: 최소 한 번은 실행하고, 'c'가 'z'보다 작거나 같을 때까지 반복
		do {
			System.out.print(c + " "); // 현재 'c' 값을 출력하고 한 칸 띄운다. (예: "a ")
			c = (char) (c + 1);       // ★ 핵심: 'c'를 다음 알파벳으로 1 증가시킨다.
                                      // 'char'에 숫자를 더하면 int가 되므로 다시 char로 강제 형변환
		} while (c <= 'z'); // 'c'가 'z'를 넘어서면 반복 종료
	}
}
