package com.inher; // 이 파일, 'com.inher'라는 폴더에 짱박혀 있음.

public class PointTest { // 'PointTest'라는 이름의 설계도. 여기서 코드 실행 테스트할 거임.

	public static void main(String[] args) { // ★★★ 여기가 프로그램 시작점임. 무조건 여기부터 봄. ★★★
		// 'main' 메서드 안에 있는 코드들이 실행될 거임.
		// 'public static void'는 걍 신경 꺼. 중요한 건 여기가 시작이라는 것만 알면 됨.
		// 'String[] args'는 외부에서 뭐 받아올 때 쓰는 건데, 여기선 안 씀.

		Point3D p3 = new Point3D(); // 1. 'Point3D'라는 설계도로 'p3'라는 새끼를 하나 만듦.
						// 'new' 보이면 '새로운 거 만드네?' 생각하면 됨.
						// 'p3'는 만들어지자마자 x, y, z 좌표가 각각 100, 200, 300으로 세팅됨. (Point3D 생성자 확인해봐라)

		System.out.println(p3.getLocation()); // 2. 'p3'한테 "야, 니 위치 어딘지 불러봐!" 시키는 거임.
											// 'getLocation()'은 'Point3D'에서 지 입맛대로 **고쳐 쓴(오버라이딩)** 메서드임.
											// 그래서 x, y, z 좌표 다 나옴.
	}
}
