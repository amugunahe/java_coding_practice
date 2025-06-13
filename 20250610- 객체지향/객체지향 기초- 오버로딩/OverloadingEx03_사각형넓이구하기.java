package com.overex;

class Diagram {
    public int area(int w, int h) {
        return w * h;   // 사각형의 넓이
    }

    public double area(double r) {
        return r * r * 3.141592;   // 원의 넓이
    }

    public void write(int result) {
        System.out.println("사각형의 넓이: " + result);
    }

    public void write(double result) {
        System.out.println("원 넓이: " + result);
    }
}

public class OverloadingEx03 {

    public static void main(String[] args) {
        Diagram d = new Diagram();
        int rest = d.area(10, 5);
        double ci = d.area(10.5);

        d.write(rest);
        d.write(ci);
    }
}

