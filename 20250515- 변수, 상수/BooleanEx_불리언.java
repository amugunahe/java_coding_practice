package com.variable; // 야, 이 코드가 여기 산다. 주소 박아놨으니까 딴 데서 헤매지 마라.

/* boolean: 자바에서 유일한 논리 자료형: 크기 1byte이지만
실제 사용은 1bit만 사용함
*/ // boolean은 '참' 아니면 '거짓'만 담는 유일한 논리형이다. 크기는 1바이트지만 실제론 1비트만 쓴다.

public class BooleanEx { // 야, BooleanEx 이름으로 프로그램 시작한다. 이 파일 이름이랑 똑같으니까 틀리면 뒤진다.

	public static void main(String[] args) { // 여기가 진짜 시작점이다. 무조건 여기부터 실행된다고 보면 됨.

		boolean b = true; // b라는 놈한테 '참' 아니면 '거짓'만 넣을 수 있는 자리 깔아줬고, 거기에 '참'을 박아 넣었다.
		System.out.println("변수 b의 값은: " + b); // b에 뭐 들어있는지 화면에 보여준다.
	}
}

