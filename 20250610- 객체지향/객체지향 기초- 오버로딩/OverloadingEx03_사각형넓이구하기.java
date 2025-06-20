package com.overex; // 이 코드가 속한 패키지(폴더) 이름이에요.

class Diagram { // Diagram 이라는 이름의 클래스를 정의합니다. 여기에 도형의 넓이를 계산하고 출력하는 메소드들이 있어요.

    // 1. 사각형의 넓이를 계산하는 area 메소드
    public int area(int w, int h) { // 메소드 이름: area, 매개변수: int형 너비(w), int형 높이(h)
        return w * h; // 너비와 높이를 곱한 값을 반환합니다. 반환 타입은 int 입니다. (사각형 넓이 공식)
    }

    // 2. 원의 넓이를 계산하는 area 메소드 (오버로딩!)
    public double area(double r) { // 메소드 이름: area (위와 같음), 매개변수: double형 반지름(r) (자료형과 개수가 다름!)
        return r * r * 3.141592; // 반지름 * 반지름 * 원주율(π)을 계산한 값을 반환합니다. 반환 타입은 double 입니다. (원 넓이 공식)
    }
    // 여기에서 두 `area` 메소드는 이름은 같지만, 매개변수의 개수(2개 vs 1개)와 자료형(int, int vs double)이 다르므로
    // 자바는 이들을 다른 메소드로 인식하고 오버로딩이 성공적으로 적용됩니다.

    // 3. int형 결과를 출력하는 write 메소드
    public void write(int result) { // 메소드 이름: write, 매개변수: int형 result
        System.out.println("사각형의 넓이: " + result); // "사각형의 넓이:"와 결과 값을 출력합니다.
    }

    // 4. double형 결과를 출력하는 write 메소드 (오버로딩!)
    public void write(double result) { // 메소드 이름: write (위와 같음), 매개변수: double형 result (자료형이 다름!)
        System.out.println("원 넓이: " + result); // "원 넓이:"와 결과 값을 출력합니다.
    }
    // 마찬가지로 두 `write` 메소드는 이름은 같지만, 매개변수의 자료형(int vs double)이 다르므로 오버로딩이 가능합니다.
}

public class OverloadingEx03 { // 프로그램을 실행하는 메인 클래스입니다.

    public static void main(String[] args) { // 프로그램의 시작점인 main 메소드입니다.

        Diagram d = new Diagram(); // Diagram 클래스의 객체(인스턴스)를 생성합니다.
                                   // 이제 d를 통해 Diagram 클래스 안에 있는 메소드들을 사용할 수 있어요.

        // 사각형 넓이 계산
        int rest = d.area(10, 5); // area 메소드 호출:
                                  // 매개변수가 int형 숫자 두 개 (10, 5)이므로
                                  // "public int area(int w, int h)" 메소드가 호출됩니다.
                                  // 계산 결과 (10 * 5 = 50)가 int형 변수 rest에 저장됩니다.

        // 원 넓이 계산
        double ci = d.area(10.5); // area 메소드 호출:
                                  // 매개변수가 double형 숫자 하나 (10.5)이므로
                                  // "public double area(double r)" 메소드가 호출됩니다.
                                  // 계산 결과 (10.5 * 10.5 * 3.141592)가 double형 변수 ci에 저장됩니다.

        // 결과 출력
        d.write(rest); // write 메소드 호출:
                       // 매개변수가 int형 변수 (rest에 50 저장)이므로
                       // "public void write(int result)" 메소드가 호출됩니다.
                       // 출력: "사각형의 넓이: 50"

        d.write(ci);   // write 메소드 호출:
                       // 매개변수가 double형 변수 (ci에 원 넓이 결과 저장)이므로
                       // "public void write(double result)" 메소드가 호출됩니다.
                       // 출력: "원 넓이: [계산된 원 넓이 값]"
    }
}

