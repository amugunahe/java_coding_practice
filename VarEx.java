package com.variable;


class AA{
int a;
}

public class VarEx {

	public static void main(String[] args) {
	AA a; //클래스
	a= new AA();
	a.a=10;
	
	int[]aa= new int[3]; //배열
	aa[0]=10;
	aa[1]=10;
	aa[2]=10;
	
	for(int i=0; i< aa.length; i++) {
		System.out.println(aa[i]);
	}

	}

}
