package com.functionex;

/* 문] 1번을 누르면 두개의 숫자를 입력받아 그 중 큰 수를 출력하는 기능을 구현하고, 
    	aaa
    2번을 누르면 두 수를 입력받아 두 수 사이에 합계를 구하여 출력하는 기능을 구현하고, 
		bbb
	3번을 누르면 세개의 수를 입력받아 큰 순서대로 나열하는 프로그램을 구현하시오. 
 		ccc
 	4번을 누르면 종료
 	finish
 */

import java.io.*;

public class funcExam01 {
	
	public static int aaa() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 수: ");
		int a = Integer.parseInt(br.readLine());
		
		System.out.print("두번째 수: ");
		int b = Integer.parseInt(br.readLine());
		
		if (a > b) {
			return a;
		}
		return b;
	}
	
	public static void bbb() throws IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 수: ");
		int a = Integer.parseInt(br.readLine());
		
		System.out.print("두번째 수: ");
		int b = Integer.parseInt(br.readLine());
		
		int sum = 0;
		
		if (a > b) {
			a = a ^ b;
			b = a ^ b;
			a = a ^ b;
		}
		
		for (int i = a; i < b; i++) {
			sum += i;
		}
		System.out.println(a + " ~ " + b + "사이의 합계: " + sum);
	}
	
	public static String ccc(int x, int y, int z) {
	
		if (y >= x && y >= z) {
			int imsi = x;
			x = y;
			y = imsi;	
			
		} else if(z >= x && z >= y) {
			int imsi = x;
			x = z;
			z = imsi;
		}
		if (z >= y) {
			int imsi = y;
			y = z;
			z = imsi;
		}
		
		String abc = x + ">=" + y + ">=" + z;
		
		return abc;
		
	}
	
	public static void finish() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}
	

	public static void main(String[] args) throws IOException {
	
	BufferedReader br =	new BufferedReader(new InputStreamReader(System.in));
		
	int x = 0;
	
	while (true) {
		System.out.print("1: 최대수 2: 사이 합 3: 수 나열 4: 종료 =>");
		x = Integer.parseInt(br.readLine());
		
		switch (x) {
		case 1:
			System.out.println("둘중 최대수는 " + aaa() + "입니다.");
			break; 
			
		case 2:
			bbb();
			break;
			
		case 3:
			System.out.println("첫번째 수: ");
			int firstSu = Integer.parseInt(br.readLine());
			System.out.println("두번째 수: ");
			int secondSu = Integer.parseInt(br.readLine());
			System.out.println("세번째 수: ");
			int thirdSu = Integer.parseInt(br.readLine());
			String str = ccc(firstSu, secondSu, thirdSu);
			System.out.println("큰 순으로 나열은 " + str);
			
			System.out.println();
			break;
			
		case 4:
			finish();
			break;
		default: 
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
		System.out.println();
	}
	// System.out.println("오늘도 열공하세요.");
		

	}

}
