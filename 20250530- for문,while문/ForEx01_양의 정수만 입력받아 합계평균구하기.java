package com.exam;

/*　문] 양의 정수만 입력받아 입력받은 정수의 합계와 평균을 구하시오.
단, 음수가 입력되면 합계와 평균을 출력하시오.

결과 
1 
2 
3 
4 
-5
지금까지의 합계와 평균은 2.2 입니다.
 */

import java.util.*;

public class ForEx01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n;
		int sum;
		int cnt;
		n = sum = cnt = 0;

		/*　for (; n >= 0;) { 
  		　　sum += n; 
　　　　　　　　　　　System.out.print("정수 입력:"); 
　		  　 n = sc.nextInt();
  　　　　　　　　　　cnt++; 
	   　　　　　}
		 */
		
	while(n　>=　0){
		sum　+=　n;
			System.out.print("정수 입력:");
			n = sc.nextInt();
			cnt++;
	}
		System.out.println("합계: " + sum);
		System.out.println("평균: " + sum / cnt);
	}
}
