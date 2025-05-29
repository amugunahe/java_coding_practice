package dowhileex;

public class DoWhileEx02 {

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			System.out.printf("i=%d ", i);

			int temp = i;
			do {

				if (temp % 10 % 3 == 0 && temp % 10 != 0) {
					// temp%10이 3의 배수인지 확인(0은 제외)
					// 97 temp%10=7, temp%3=1,
					System.out.print("짝");
				}
			} while ((temp /= 10) != 0);
			System.out.println();

		}

	}

}
