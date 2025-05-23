package com.condition;

import java.util.*;
public class IfExTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int buy;
		buy = sc.nextInt();
		if(buy >= 100000) {
			System.out.println("15% 할인");
		}else if (buy>10000 && buy <100000) {
		System.out.println("10% 할인");
		} else if (buy > 10000) {
			System.out.println("5% 할인");
		}else { 
			System.out.println("할인 없음");
		}
	}
}

