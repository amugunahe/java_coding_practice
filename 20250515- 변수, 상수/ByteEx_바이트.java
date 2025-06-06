package com.variable;

/* byte
 -1byte 자료형
  범위: 256 => -128~ 127
*/

public class ByteEx {

	public static void main(String[] args) {
		
		byte bb = 127;
		int a;
		
		a = (int)(bb + 1);
		System.out.println("a = " + a);
	}
}
