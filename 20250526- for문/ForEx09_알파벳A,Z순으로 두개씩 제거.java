package com.loop;

/* 문] 
 * 중첩 for문을 이용하여 다음과 같이 출력 되도록 구현하시오.
 
ABCDEFGHIJKLMNOPQRSTUVWXYZ
 BCDEFGHIJKLMNOPQRSTUVWXY
  CDEFGHIJKLMNOPQRSTUVWX
   DEFGHIJKLMNOPQRSTUVW
    EFGHIJKLMNOPQRSTUV
     FGHIJKLMNOPQRSTU
      GHIJKLMNOPQRST
       HIJKLMNOPQRS
        IJKLMNOPQR
         JKLMNOPQ
          KLMNOP
           LMNO
            MN
             
*/

public class ForEx09 {

	public static void main(String[] args) {

		for (char a = 'A'; a <= 'Z'; a++) {
			for (int c = 0; c < a - 65; c++) {
				System.out.print(" ");
			}
			for (int b = a; b <= 'Z' - (a - 65); b++) {
				System.out.print((char) b);
			}
			System.out.println();
		}
	}

}
