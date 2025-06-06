package com.condition;

/*문] 
 사용자로부터 임의의 정수를 입력받아 입력받은 정수가 
 2의 배수인지, 3의 배수인지, 2와 3의 배수인지, 2와 3의 배수가 아닌지를
 판정하는 프로그램을 구현하시오. 
 */
 
import java.util.*;

public class IfEx05 {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
		
		int a;  // 임의의 정수를 저장할 변수
		
		System.out.print("정수 입력:");
		a = sc.nextInt();
		
		if(a % 2 == 0 && a % 3 == 0)
			System.out.println("2와 3의 배수입니다.");
		 else if (a % 2 == 0) 
			System.out.println("2의 배수입니다");
			else if (a % 3 == 0)
				System.out.println("3의 배수입니다.");
			else 
				System.out.println("2와 3의 배수가 아닙니다.");
		}
}
