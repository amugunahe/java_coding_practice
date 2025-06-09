package dowhileex;

/* a~z까지 출력
*/

public class DoWhileEx04 {

	public static void main(String[] args) {

		char c = 'a';
		
		do {
			System.out.print(c + " ");
			c = (char) (c + 1);
		} while (c <= 'z');
	}
}
