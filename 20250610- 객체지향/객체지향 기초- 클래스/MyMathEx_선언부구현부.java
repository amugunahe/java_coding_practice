package com.objectex; // 이 코드가 속한 패키지(폴더) 이름이에요.

class MyMath { // MyMath라는 이름의 클래스를 정의합니다. 수학 계산 관련 메소드를 담을 거예요.

    // 1. 덧셈 메소드: add
    int add(int a, int b) // 선언부 (int형 a와 b를 받아 int형 값 반환)
    {
        int result = a + b; // 구현부: a와 b를 더한 값을 result에 저장
        return result;      // result 값을 반환
    }

    // 2. 뺄셈 메소드: sub
    int sub(int a, int b) // 선언부 (int형 a와 b를 받아 int형 값 반환)
    {
        int result = a - b; // 구현부: a에서 b를 뺀 값을 result에 저장
        return result;      // result 값을 반환
    }

    // 3. 곱셈 메소드: mul
    int mul(int a, int b) // 선언부 (int형 a와 b를 받아 int형 값 반환)
    {
        int result = a * b; // 구현부: a와 b를 곱한 값을 result에 저장
        return result;      // result 값을 반환
    }

    // 4. 나눗셈 메소드: div
    int div(int a, int b) // 선언부 (int형 a와 b를 받아 int형 값 반환)
    {
        int result = a / b; // 구현부: a를 b로 나눈 값을 result에 저장
                            // (주의: 정수 나눗셈은 소수점 이하를 버립니다. 예를 들어 10 / 3은 3이 됩니다.)
        return result;      // result 값을 반환
    }
}


public class MyMathEx { // MyMathEx 라는 이름의 클래스를 정의합니다. 여기서 프로그램을 실행해요.

    public static void main(String[] args) { // 프로그램의 시작점인 main 메소드입니다.

        // 1. MyMath 클래스의 객체(인스턴스) 생성
        MyMath mm = new MyMath(); // 'new MyMath()'는 MyMath 클래스를 바탕으로 실제 '수학 계산기' 객체를 메모리에 만드세요! 라는 명령이에요.
                                  // 이렇게 만들어진 객체를 'mm'이라는 변수가 가리키게 됩니다.
                                  // 이제 'mm'을 통해 MyMath 클래스 안에 있는 메소드들을 사용할 수 있어요.

        // 2. MyMath 객체의 메소드 호출 및 결과 저장
        long r1 = mm.add(6, 7); // mm 객체의 add 메소드를 호출합니다. 인자 6과 7을 넘겨줍니다.
                                // add 메소드는 6 + 7 = 13을 계산하고 int형으로 반환합니다.
                                // 이 13을 long 타입 변수 r1에 저장합니다. (int가 long으로 자동 형변환됩니다.)
        long r2 = mm.sub(10, 2); // mm 객체의 sub 메소드를 호출합니다. 인자 10과 2를 넘겨줍니다.
                                // sub 메소드는 10 - 2 = 8을 계산하고 int형으로 반환합니다.
                                // 이 8을 long 타입 변수 r2에 저장합니다.
        long r3 = mm.mul(2, 3); // mm 객체의 mul 메소드를 호출합니다. 인자 2와 3을 넘겨줍니다.
                                // mul 메소드는 2 * 3 = 6을 계산하고 int형으로 반환합니다.
                                // 이 6을 long 타입 변수 r3에 저장합니다.
        long r4 = mm.div(10, 2); // mm 객체의 div 메소드를 호출합니다. 인자 10과 2를 넘겨줍니다.
                                // div 메소드는 10 / 2 = 5를 계산하고 int형으로 반환합니다.
                                // 이 5를 long 타입 변수 r4에 저장합니다.

        // 3. 계산 결과 출력
        System.out.println(mm.add(6, 7)); // mm.add(6, 7)을 다시 호출하여 반환된 값 13을 바로 출력합니다.
        System.out.println(r1); // 변수 r1에 저장된 값 13을 출력합니다.
        System.out.println(r2); // 변수 r2에 저장된 값 8을 출력합니다.
        System.out.println(r3); // 변수 r3에 저장된 값 6을 출력합니다.
        System.out.println(r4); // 변수 r4에 저장된 값 5를 출력합니다.

        // 4. static 메소드 호출 (중요!)
        // 'static' 메소드는 객체를 만들지 않고도 클래스 이름으로 바로 호출할 수 있어요.
        // `main` 메소드도 `static`이므로, 같은 클래스 안에 있는 다른 `static` 메소드들은
        // 클래스 이름 없이 바로 호출할 수 있습니다.
        firstMethod(); // firstMethod() 메소드를 호출합니다.
                       // firstMethod() 안에서는 다시 secondMethod()를 호출합니다.
                       // 결국 "secondMethod()..."가 출력될 거예요.
    }

    // static 메소드: firstMethod
    // 이 메소드는 'static'으로 선언되어 있어서 `main` 메소드처럼 객체 생성 없이 바로 호출될 수 있어요.
    static void firstMethod() {
        secondMethod(); // 같은 클래스 내의 다른 static 메소드인 secondMethod()를 호출합니다.
                        // (여기서 `MyMathEx.secondMethod();` 라고 써도 되지만, 보통 생략해요.)
    }

    // static 메소드: secondMethod
    // 이 메소드도 'static'으로 선언되어 있어요.
    static void secondMethod() {
        System.out.println("secondMethod()..."); // "secondMethod()..."라는 문자열을 출력합니다.
    }
}
