package com.ioex;


/*문제1) 숫자 하나를 입력받아 그 수가 1이면 "남성, 2이면 "여성"이라는 글자를 출력하는 프로그램, "
		"단 모든 조건을 삼항연산자로 처리하시오
*/
import java.io.*;

public class Test01 {
	public static void main(String[] args) throws IOException {
	
		int gender= 0;
		System.out.print("성별 입력(1:남성, 2:여성):");
		gender = System.in.read()-48;
		String str = (gender == 1? "남성":"여성");
		//System.out.println("당신은 "+ (gender ==1? "남성" : "여성")+ "입니다.");
		System.out.println("당신은 "+ str + "입니다.");
}
}
