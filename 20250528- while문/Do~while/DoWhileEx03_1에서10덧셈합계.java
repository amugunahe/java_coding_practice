package dowhileex;

/* 문] do ~while문을 이용하여 1에서 10까지 덧셈으로 표시하고 합계를 구하는 
 프로그램을 구현하시오. 
 
결과 
1+2+3+4+5+6+7+8+9+10 == 55 
*/


public class DoWhileEx03 {

	public static void main(String[] args) {
		
		int sum = 0;
		int i = 1;
		
		do {
			sum += i;
			i++;
		} while(i <= 10);
		System.out.println(sum);
	}
}
