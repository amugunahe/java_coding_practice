package com.condition;

/*
 * 문] 두 정수를 입력 받아 큰 수를 알아맞히는 프로그램을 구현하시오. 
 * 
*/
import java.util.*;

public class IfEx08 {
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	int a, b, max=0;
	
	System.out.print("첫번째 정수: ");
	a = sc.nextInt();
	
	System.out.print("두번째 정수: ");
	b = sc.nextInt();
	
	if(a > b) {
		max = a;
		//System.out.print("첫번째 수 (" + a +")가 두번째 수 ("+ b +")보다 큰 수입니다.");
		System.out.print("첫번째 수 " + a + "가 두번째 수 " + b + "보다 크기 때문에 큰 수는 "+ max + "입니다.");
	}else{
		max = b;
		//System.out.print("첫번째 수 ("+a+")가 두번째 수 ("+ b +")보다 작은 수입니다.");
		System.out.print("첫번째 수 " + a + "가 두번째 수 "+ b + "보다 작기 때문에 큰 수는 "+ max + "입니다.");
	}
	}

}	
