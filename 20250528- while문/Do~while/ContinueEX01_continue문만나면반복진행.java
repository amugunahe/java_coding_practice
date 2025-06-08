package dowhileex;

/* continue문은 반복이 진행되는 도중에 Continue문을 만나면 반복문을 끝으로 
  이동하여 다음 반복을 계속 진행함 

  문] 1과 10 사이의 숫자를 출력하되, 3의 배수인 것은 제외로 한다.
  위와 같은 결과를 출력하기 위한 프로그램을 구현하시오. 
 */

public class ContinueEX01 {

	public static void main(String[] args) {
		
		for(int i = 0; i <= 10; i++) {
			if(i % 3 == 0)
				continue;  // 반복문을 끝내지 않고 계속 반복 수행
			System.out.print(i + " ");
		}
	}
}
