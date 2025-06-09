package com.loop;

public class ForEx06 {

	public static void main(String[] args) {
		
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch + " ");
		}
		System.out.println();
		System.out.println();
		
		for (int ch = 65; ch <= 90; ch++) {
			System.out.print((char) ch + " ");
		}
		System.out.println();
		
		for (char ch = 'A'; ch <='Z'; ch++) {
			for (char bb = ch; bb <= 'Z'; bb++) {
				System.out.print(bb);
			}
			System.out.println();
		}
	}
}
