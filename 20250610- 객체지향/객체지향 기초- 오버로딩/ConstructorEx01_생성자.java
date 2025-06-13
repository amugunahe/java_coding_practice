package com.overex;

/* 생성자 설명
  - 인스턴스가 생성될 때 호출되는 인스턴스 초기화 메소드
  - 인스턴스 변수 초기화용
  - 생성자의 조건
    1. 클래스 이름과 동일해야 함
    2. 리턴값이 없음 (void 안 붙임)
*/

class Data1 {
    int value; // 기본 생성자 자동 생성됨
}

class Data2 {
    int value;

    public Data2(int x) { // 매개변수 있는 생성자
        value = x;
    }
}

public class ConstructorEx01 {
   
	private int n;

    // 생성자 정의
    public ConstructorEx01() {
        n = 10;
    }
    
    public ConstructorEx01(int n) {
        this.n = n;
    }
    
    public ConstructorEx01(long n) {
       this.n = (int)n;   // long가지고 n에 넣으면 overflow가 발생해서 형태변환을 해줘야함 
    }
    
    public ConstructorEx01(short s) {
       this.n = s;
    }
    

    public void write() {
        System.out.println("n: " + n);
    }

    public static void main(String[] args) {
        Data1 d1 = new Data1();        // 기본 생성자 사용
        Data2 d2 = new Data2(10);      // 매개변수 있는 생성자 사용

        ConstructorEx01 c = new ConstructorEx01();  // 생성자 호출 괄호 필요
        c.write(); // 출력: n: 10
    }
}

