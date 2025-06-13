package com.overex;

class OverloadingEx {
    public void print() {
        System.out.println("인자 없는 메소드 ....");
    }

    /*
    public int print() {
        return;   // 오버로딩 아님, 메서드 이름 같고 매개변수도 없으므로 컴파일 오류
    }
    */

    public void print(short val) {
        System.out.println("short ....");
    }

    public void print(int val) {
        System.out.println("int ....");
    }

    public void print(long val) {
        System.out.println("long ....");
    }

    public void write(int val) {
        System.out.println("int");
    }

    public void write(long val) {
        System.out.println("long");
    }

    public void write(Long val) {
        System.out.println("Long");
    }   // 참조형(Long 객체)이 들어가서 오버로딩 가능
}

public class OverloadingEx02 {
	
    public static void main(String[] args) {
    	
        OverloadingEx oe = new OverloadingEx();

        short s = 10;
        Short ss = 10;
        int i = 10;
        long l = 10;

        oe.print();
        oe.print(s);
        oe.print(i);
        oe.print(l);

        oe.write(s);
        oe.write(ss);
        oe.write(i);
        oe.write(l);
    }
}
