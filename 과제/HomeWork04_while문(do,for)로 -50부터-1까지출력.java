package com.test;

public class HomeWork04 {

	public static void main(String[] args) {

		int i = -50; //초기값

		while (i <= 1) {
			System.out.printf("\t%d\t", i);
			i++;

			if (i % 5 == 0)
				System.out.println();
		}

	}

}
