package com.inher; // 이 코드는 'com.inher' 패키지에 속해 있음. (Point 클래스와 같은 패키지다!)

/*
  Point3D 클래스: **2차원 점 'Point'를 상속받아 만든 존나게 강력한 '3차원 점' 설계도다!**
 
  핵심:
  - **`extends Point`:** 'Point3D'는 'Point' 클래스를 ★상속(extends)★받는다! (존나 중요!)
  -> 'Point'가 가진 모든 변수(`x`, `y`)랑 메소드(`getXY()`, `getLocation()`)를 물려받는다!
  - **`int z;`:** 3차원 점을 표현하기 위해 'z' 좌표를 새로 추가했다!
  - **생성자 2개:**
  1. **`Point3D()` (기본 생성자):** 아무 매개변수 없이 객체만 만들 때 쓴다. (x, y, z를 기본값 100, 200, 300으로 초기화!)
  - **`this(100, 200, 300);`:** ★★★ 존나 중요! 이 새끼는 **같은 클래스 안에 있는 다른 생성자를 호출하는 거다!** (생성자 호출 체인!)
  2. **`Point3D(int x, int y, int z)`:** x, y, z 좌표를 입력받아서 3차원 점을 만드는 존나 편한 생성자다.
  - **`super(x, y);`:** ★★★ 개중요! **부모 클래스(`Point`)의 생성자를 호출하는 거다!**
  - 자식 클래스의 생성자가 호출되기 전에, 부모 클래스의 생성자가 무조건 먼저 호출돼야 한다! (안 하면 에러난다, 씨발!)
  - 이걸 통해서 물려받은 `x`, `y` 좌표를 부모 생성자에서 초기화한다.
  - **메소드 오버라이딩 (Overriding)!**
  - **`getLocation()`:** 'Point'가 가지고 있던 `getLocation()` 메소드를 'Point3D'에 맞게 새로 고쳐 썼다! (z 좌표까지 포함!)
  - **`toString()`:** 모든 자바 객체가 기본으로 가진 `toString()` 메소드도 재정의해서 'Point3D' 객체의 정보를 존나게 깔끔하게 보여준다!
 */

/*
  ★ 오버라이딩 (Overriding) 조건 ★
  - 자식 클래스에서 부모 클래스의 메서드와 '이름', '매개변수', '반환 타입'이 모두 같아야 함.
  - 물려받은 메서드 내용을 자식 클래스에 맞게 고쳐 쓰는 거임.
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

    // ★★★ 실행 예시 (`main` 메소드 추가): 이 코드를 어떻게 돌리는지 보여준다! ★★★
    public static void main(String[] args) {
        // 1. 기본 생성자로 Point3D 객체 생성 (100, 200, 300)
        Point3D p3d_default = new Point3D();
        System.out.println("기본 Point3D 좌표 (toString): " + p3d_default); // toString() 호출
        System.out.println("기본 Point3D 위치 (getLocation): " + p3d_default.getLocation()); // getLocation() 호출

        // 2. 특정 좌표로 Point3D 객체 생성 (1, 2, 3)
        Point3D p3d_custom = new Point3D(1, 2, 3);
        System.out.println("커스텀 Point3D 좌표 (toString): " + p3d_custom);
        System.out.println("커스텀 Point3D 위치 (getLocation): " + p3d_custom.getLocation());

        // 3. 업캐스팅 예시 (존나 중요!)
        // Point3D 객체를 부모 타입인 Point 변수로 참조할 수 있다.
        Point p_upcasted = new Point3D(7, 8, 9);
        // 이때 p_upcasted.getLocation()을 호출하면, 실제 객체가 Point3D이므로
        // Point3D의 오버라이딩된 getLocation()이 실행된다! (이게 다형성이다, 씨발!)
        System.out.println("업캐스팅된 Point의 위치: " + p_upcasted.getLocation()); // z는 없어도 출력은 Point3D 방식대로!

        // p_upcasted.z 에 직접 접근은 불가능 (부모 타입으로 참조했기 때문)
        // System.out.println(p_upcasted.z); // 컴파일 오류!

        // 다운캐스팅 예시
        // 부모 타입으로 참조된 객체를 다시 자식 타입으로 변환 (강제 형 변환)
        Point3D p_downcasted = (Point3D) p_upcasted;
        System.out.println("다운캐스팅된 Point3D의 z: " + p_downcasted.z); // 이제 z에 접근 가능!
    }
}
