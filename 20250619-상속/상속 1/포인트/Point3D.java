package com.inher; // 이 코드는 'com.inher' 패키지에 속해 있음.

/*
 * ★ 오버라이딩 (Overriding) 조건 ★
 * - 자식 클래스에서 부모 클래스의 메서드와 '이름', '매개변수', '반환 타입'이 모두 같아야 함.
 * - 물려받은 메서드 내용을 자식 클래스에 맞게 고쳐 쓰는 거임.
 */

public class Point3D extends Point { // 'Point3D'는 'Point'를 ★상속(extends)★받음.
	// Point의 모든 변수(x, y)랑 메서드를 물려받음.

	int z; // 3차원 점의 z 좌표. Point3D에 새로 추가된 변수.

	// --- 생성자 ---

	// 1. 기본 생성자: x, y, z를 100, 200, 300으로 초기화함.
	public Point3D() {
		this(100, 200, 300); // ★중요: 아래 다른 생성자를 호출해서 x, y, z를 설정함. (생성자 호출 체인)
	}

	// 2. x, y, z를 받아서 3차원 점을 만드는 생성자
	public Point3D(int x, int y, int z) {

		super(x, y); // ★★★개중요★★★ 부모 클래스(Point)의 생성자를 호출해서 x, y를 초기화함.
		             // ★기억해라: 자식 생성자 호출 전에 부모 생성자가 먼저 호출돼야 함.

		this.z = z; // 입력받은 'z' 값을 현재 객체('this')의 'z' 변수에 저장.
	}

	// --- 메서드 ---

	@Override // ★★★필수★★★ 이 어노테이션은 "아래 메서드가 부모 클래스의 메서드를 재정의(Override)한 것이다"라고 알려줌.
	String getLocation() { // Point의 `getLocation()` 메서드를 ★재정의(오버라이딩)★함.
		return "x: " + x + ", y: " + y + ", z:" + z; // 3차원 좌표(x, y, z)를 문자열로 반환.
	}

	@Override // `toString()` 메서드 재정의. (모든 객체가 기본으로 가진 메서드)
	public String toString() { // Point3D 객체의 정보를 문자열로 반환함.
		return "x: " + x + ", y: " + y + ", z:" + z; // 객체를 출력할 때 이 문자열이 나타남.
	}

}
