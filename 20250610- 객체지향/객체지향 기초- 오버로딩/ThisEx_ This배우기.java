package com.overex;

class Rect {
	
	private int w, h;
	
	public int area() {
		return w * h;
	}
	
	public void write(int result) {
		System.out.println("결과: " + result);
	}
	
	public void setData(int w, int h) {
		this.w = w;
		this.h = h;	
	}
		
}

public class ThisEx {

	public static void main(String[] args) {
		
	Rect r = new Rect();
	r.setData(10, 5);

	int a = r.area();
	r.write(a);	
	}

}
