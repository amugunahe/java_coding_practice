package com.inher;

/* 오버라이딩 조건
   자손 클래스에서 오버라이딩하는 메소드는 조상클래스의 메소드와 
   
   1. 이름이 같아야한다.
   2. 매개변수가 같아야한다.
   3. 반환타입이 같아야한다.
  
 */

public class Point3D extends Point {

	int z;

	public Point3D() {
		this(100, 200, 300);
	}

	public Point3D(int x, int y, int z) {
		
		super(x, y);
		
		this.z = z;

	}

	@Override
	String getLocation() { // 오버라이딩
		return "x: " + x + ", y: " + y + ", z:" + z;
	}

	@Override
	public String toString() {
		return "x: " + x + ", y: " + y + ", z:" + z;
	}

}
