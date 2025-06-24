package com.polymorphism;

/*
  Ambulance 클래스: 구급차.
 
  핵심:
  - 'Car' 클래스를 상속받아야 **존나게 맞는데**, 여기선 아직 안 되어있다. (★★★★★ 존나 중요! ★★★★★)
  - 지금은 'siren()' 메소드 혼자만 가지고 있다.
  - 만약 'Car'를 상속받으면 'Car'의 'drive()', 'stop()' 메소드도 같이 쓸 수 있게 된다.
  그럼 진정한 '차'가 되는 거지, 씨발!
 */

public class Ambulance {

	// 사이렌 울리는 메소드.
	void silen(){
		System.out.println("siren!!~~~~~~");
	}
}
