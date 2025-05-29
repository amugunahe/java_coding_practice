package dowhileex;

/*문]
  do~while문을 이용하여 아래와 같이 출력하도록 프로그램을 구현하시오.
  
   *****
   ****
   ***
   **
   * 
 */

public class DoWhileEx05 {

	public static void main(String[] args) {

		int i = 5;
		do {
			int j = 0;
			do {
				System.out.print("*");
				j++;
			} while (j < i);
			System.out.println();
			i--;
		} while (i > 0);
	}
}