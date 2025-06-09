package com.test;

import java.util.Scanner;

public class HomeWork03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력: ");
		int n = sc.nextInt();
		
		int i, j, k;  
		
		for (i = 1; i < 9; i += n) { // 단 묶음의 시작
			for (j = 1; j <= 9; j++) { // 각 단의 곱해지는 수
				for (k = 1; k <= n; k++) { // i로부터 몇번째 단인지 
					if (i + k <= 9)   // 9단을 넘지 않도록 제한 
						System.out.printf("%d * %d = %d\t\t", i + k, j, ((i + k) * j));
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}

/* Scanner sc = new Scanner(System.in); 
 
 int a, b, c;
 
 for (c = 1; c <= 3; c++) {  // 묶음 
 	for (b = 1; b <= 9; b++) { //  곱해지는 수 (행)
  		for (a = c * 3 - 1; a <= c * 3 + 1; a++) { // 단 (열) 
    				if (a < 10) 
				System.out.printf("%2d * %2d = %2d", a, b, b * a);
 				} System.out.println(); 
 		} System.out.println(); 
	} 
   } 
}
*/
