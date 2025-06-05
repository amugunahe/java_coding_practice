package com.loop;

import java.util.*;

public class WhileEx04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("계속 진행 하시겠습니까?(y/n)");
			char ch = sc.next().charAt(0);

			if (ch == 'n' || ch == 'N') {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				//return;
				//break;
				
			}
		}
	}
}
