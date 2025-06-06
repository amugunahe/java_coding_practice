package com.switchex;


import java.util.Scanner;

public class SwitchEx05_02_con {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가위(1), 바위(2), 보(3) 중 입력: ");
		int user = sc.nextInt();
		
		int com = (int)(Math.random() * 3) + 1;
		
		System.out.println(user);
		System.out.println(com);

		if (user - com == 2 || user - com == -1) { 
		System.out.println("컴퓨터가 이겼습니다 ");
		} else if (user - com == 1 || user - com == 2) {
		System.out.println("사용자가 이겼습니다.");
		} else if (user - com == 0) {
		System.out.println("비겼습니다.");}
	}
}
