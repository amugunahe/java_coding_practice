package dowhileex;

/*
 * 문] 숫자 1부터 계속 더해 나가서 몇까지 더 하면 합이 100을 넘는지를 알아보는 
 * 프로그램을 구현하시오.
 */

public class DoWhileEx06 {

	public static void main(String[] args) {

		int sum = 0;
		int i = 0;

		while (true) {
			if (sum > 100)
				break;
			i++;
			sum += i;
		}
		System.out.println("i= " + i + ", sum=" + sum);
	}

}
