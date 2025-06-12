package com.objectex;

public class VariableEx {
	
	public void argsTest(String ...n) {  
		// ...: 내부적으로 배열화 작업을 자동으로 해줌
		
		for (int i = 0; i < n.length; i++) {
			System.out.println("n[" + i + "]:" + n[i]);
		}
		System.out.println("======================");
	}

	public static void main(String[] args) {
		
		VariableEx ve = new VariableEx();
		ve.argsTest("java", "DataBase");
		ve.argsTest("100", "200", "300", "400");
		ve.argsTest("100", "200", "300", "400", "100", "200", "300", "400") ;

	}

}
