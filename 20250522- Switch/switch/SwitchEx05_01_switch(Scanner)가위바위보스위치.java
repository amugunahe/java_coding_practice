package com.switchex;

/* 문] 컴퓨터와 사용자가 가위바위보를 하는 게임
사용자로부터 1(가위) 2(바위) 3(보)중 하나를 입력받고 
컴퓨터는 1, 2, 3 중에서 하나를 임의의 수를 선택하면 된다.
   
 임의의 수를(난수) => Math.random() 을 사용해서 추출함.
   
random() => 0.0 ~ 1.0 사이의 실수(double)를 반환해야함
  
0.0 <= Math.random() < 1.0
   
1과 3사이의 정수를 구한다면 
난수를 구하는 식
1째 단계: 0.0 * 3 <= Math.random() * 3 < 1.0 * 3
   
2째 단계: (int)0.0 <= (int)Math.random() * 3 < (int)3.0
 
3째 단계:  0 <= (int)Math.random() * 3 < 3 
   
4째 단계:  0 + 1 <= (int)(Math.random() * 3) + 1 < 3 + 1
1~3
*/

import java.util.*;

public class SwitchEx05_01_switch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가위(1), 바위(2), 보(3) 중 입력: ");
		int user = sc.nextInt();
		
		int com = (int)(Math.random() * 3) + 1;
		
		System.out.println(user);
		System.out.println(com);

		switch (user - com) {
		case 1: case -2:
			System.out.println("사용자가 이겼습니다");
		break;
		case 2: case -1: 
			System.out.println("컴퓨터가 이겼습니다");
		break;
		case 0:
			System.out.println("무승부 입니다.");
		break;
		}
	}
}
