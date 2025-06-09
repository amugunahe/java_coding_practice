package com.exam;

/* 문] 사용자로부터 임의의 정수를 입력받아 1부터 입력 받은 수까지의 
전체의 합계, 짝수의 합계, 홀수의 합계를 각각 출력하는 프로그램을 구현하시오.
단, 10단위 출력하시오.

출력
정수 입력: 59
1~10까지의 합계: 
1~10까지의 짝수의 합계:
1~10까지의 홀수의 합계:

1~20까지의 합계: 
1~20까지의 짝수의 합계:
1~20까지의 홀수의 합계:

1~30까지의 합계: 
1~30까지의 짝수의 합계:
1~30까지의 홀수의 합계:

1~40까지의 합계: 
1~40까지의 짝수의 합계:
1~40까지의 홀수의 합계:

1~50까지의 합계: 
1~50까지의 짝수의 합계:
1~50까지의 홀수의 합계:

1~59까지의 합계: 
1~59까지의 짝수의 합계:
1~59까지의 홀수의 합계:
*/

import java.util.*;

public class ForEx02 {

	public static void main(String[] args) {
		
		int n;
		int sum;
		int even;
		int odd;
		sum = even = odd = 0;

		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력: ");
		n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			sum += i; // 전체의 합
			if (i % 2 == 0) {
				even += i; // 짝수의 합
			} else {
				odd += i; // 홀수의 합
			}
			if (i　% 10　==　0) {  //10단위
				System.out.println("1~　" + i + "까지의 전체의 합계: " + sum);
				System.out.println("1~" + i + "까지의 짝수 합계: " + even);
				System.out.println("1~" + i + "까지의 홀수 합계: " + odd);
			
			} else if (i == n) {  //전부
				System.out.println("1~" + i + "까지의 전체의 합계: " + sum);
				System.out.println("1~" + i + "까지의 짝수 합계: " + even);
				System.out.println("1~" + i + "까지의 홀수 합계: " + odd);
			}
		}
	}
}
