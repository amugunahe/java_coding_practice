package com.operex; // 야, 이 코드가 여기 산다. 주소 박아놨으니까 딴 데서 헤매지 마라.

public class OperEx { // 야, OperEx 이름으로 프로그램 시작한다. 이 파일 이름이랑 똑같으니까 틀리면 뒤진다.

	public static void main(String[] args) { // 여기가 진짜 시작점이다. 무조건 여기부터 실행된다고 보면 됨.

		int x = 10; // x라는 정수(int) 변수에 10 넣었다.

		int y = ++x; // 이 줄이 존나 중요하다!
			 // ++x: x 값을 먼저 1 올리고, 그 올라간 값을 y에 박아 넣는 거임.
			 // x가 원래 10이었으니까,
			 // 1. x를 1 올림: x는 이제 11 됐다.
			 // 2. 올라간 x 값(11)을 y에 박음: y도 11 됐다.
			 // 쉽게 말해 '먼저 계산하고 나중에 대입'하는 거랑 비슷하다고 보면 됨.
			 // x++는 '먼저 대입하고 나중에 계산'하는 건데, 지금은 주석이니까 그냥 참고만 해라.

		System.out.println("x:" + x); // x에 뭐 들어있는지 화면에 보여준다. 지금 x는 11임.
		System.out.println("y:" + y); // y에 뭐 들어있는지 화면에 보여준다. 지금 y도 11임.
	}
}
