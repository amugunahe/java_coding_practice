package com.ioex;

import java.io.*;


//문자 하나 이상일때를 문자열로 처리
/*
 * InputStreamReader is = new InputStreamReader(System.in);
 * BufferedReader br= new BufferedReader(is)
 *	 String name= br.readLine();
 * */
public class InputEx04 {

	public static void main(String[] arg) throws IOException {
		
		String name;
		String age;
		String address;
		String tel;
		
		
		//객체생성
		/*
		 * InputStreamReader is = new InputStreamReader(System.in); BufferedReader br =
		 * new BufferedReader(is);
		 */
		//입력처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이름 입력:");
		name= br.readLine();
		System.out.print("나이 입력:");
		age=br.readLine();
		System.out.print("주소 입력:");
		address=br.readLine();
		System.out.print("전번 입력:");
		tel=br.readLine();
		//출력처리
		
		System.out.println("나의 이름은"+ name+ "이고\n, 나이는"+ age+"세, 주소는" + address+"이며\n 전번은"+ tel+"입니다");
		
	}
}
