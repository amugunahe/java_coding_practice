package com.ioex;

/* 숫자열(두자리 이상)입력 받기 
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * 
 * String imsi= br.readLine(); --> 문자열로 입력
 
 -> 문자열을 숫자열로 바꿔주는 메소드 
 * integer.parseInt(imsi);
 * integer -> Wrapper 클래스
 * 숫자를 문자열로 바꾸려면 String.valueOf(imsi);
 * 
 *  문자열을 숫자로
 *  String str = br.readLine();
 *  byte b = Byte.parseByte(str);
 *  short s = Short.parseShort(str);
 *  int i = Integer.parseInt(str);
 *  long l = Long.parseLong(str);
 *  float f = Float.parseFloat(str);
 *  double d = Double.parseDouble(str);
 */

import java.io.*;

// 각 과목을 점수를 입력 받으시오(국어, 영어, 수학)

public class InputEx05 {

	public static void main(String[] args) throws IOException {
		
	int kor, eng, mat; 
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	System.out.print("국어 점수: ");
	kor = Integer.parseInt(br.readLine());  // 문자열 ->정수로 변환한 후에 정수형 변수에 저장한다.
	
	System.out.print("영어 점수: ");
	eng = Integer.parseInt(br.readLine());

	System.out.print("수학 점수: ");
	mat = Integer.parseInt(br.readLine());
	
	int sum = kor + eng + mat;
	float avg = sum / (float)3.0;
	
	System.out.println("총점: "+ sum);
	System.out.printf("평균: %.2f\n", avg);
		
	float f;
	System.out.print("실수 입력: ");
	f = Float.parseFloat(br.readLine());
	}
}
