package com.objectex; // 이 코드는 'com.objectex' 패키지에 들어있어. 파일들을 종류별로 묶어두는 폴더라고 생각하면 됨.

/*
  MyMath 클래스: **수학 계산 기능을 제공하는 존나게 기본적인 클래스다!**
 
  핵심:
  - **객체 메소드 (`add`, `sub`, `mul`, `div`):**
  - 'static' 키워드가 안 붙어있다.
  - 이 메소드들은 `MyMath` 클래스의 **객체(인스턴스)를 만들어야만 호출할 수 있다!** (`new MyMath()`로 만든 놈!)
  - 각각 덧셈, 뺄셈, 곱셈, 나눗셈 연산을 수행하고 결과를 반환한다.
  - **`return`의 역할:** 메소드에서 계산된 최종 값을 호출한 쪽으로 돌려주는 역할을 한다.
  - **정수 나눗셈 주의:** `div` 메소드처럼 `int` 타입끼리 나누면 소수점 이하는 그냥 짤린다! (버림 처리됨)
 */

class MyMath { // 'MyMath'라는 이름의 클래스를 정의한다 이기. 여기선 수학 계산하는 메소드들을 모아둘 거야.

    // 1. 덧셈 메소드: add
    // 'int add(int a, int b)' : 이 메소드는 'int' 타입 값 두 개(a, b)를 받아서 'int' 타입의 결과값을 반환할 거라는 선언부임.
    int add(int a, int b) {
        int result = a + b; // 'a'랑 'b'를 더한 값을 'result'라는 변수에 저장한다.
        return result;      // 계산된 'result' 값을 이 메소드를 호출한 곳으로 돌려준다.
    }

    // 2. 뺄셈 메소드: sub
    // 'int sub(int a, int b)' : 'a'에서 'b'를 뺀 값을 'int' 타입으로 반환할 거라는 선언부.
    int sub(int a, int b) {
        int result = a - b; // 'a'에서 'b'를 뺀 값을 'result'에 저장.
        return result;      // 'result' 값을 반환.
    }

    // 3. 곱셈 메소드: mul
    // 'int mul(int a, int b)' : 'a'와 'b'를 곱한 값을 'int' 타입으로 반환할 거라는 선언부.
    int mul(int a, int b) {
        int result = a * b; // 'a'와 'b'를 곱한 값을 'result'에 저장.
        return result;      // 'result' 값을 반환.
    }

    // 4. 나눗셈 메소드: div
    // 'int div(int a, int b)' : 'a'를 'b'로 나눈 값을 'int' 타입으로 반환할 거라는 선언부.
    int div(int a, int b) {
        // **★중요: 여기서 정수(int)끼리 나누면 소수점 이하는 그냥 잘린다!**
        // 예를 들어, 10 / 3은 3.333...이 아니라 그냥 '3'이 됨.
        // 그리고 0으로 나누면 에러나니까, 실제 사용할 땐 0으로 나누는지 체크해야 한다, 씨발!
        if (b == 0) { // 나눗셈에서 분모가 0이면 에러나니까 미리 체크한다.
            System.out.println("씨발! 0으로 나눌 수 없다!");
            return 0; // 예시로 0을 반환하지만, 실제로는 에러 처리(예외 던지기)가 필요하다!
        }
        int result = a / b; // 'a'를 'b'로 나눈 값을 'result'에 저장.
        return result;      // 'result' 값을 반환.
    }
}

/*
  MyMathEx 클래스: **`MyMath` 클래스를 이용해서 실제 수학 계산을 돌려보는 메인 프로그램이다!**
 
  핵심:
  - **`main` 메소드:** 프로그램이 시작되는 존나게 중요한 지점이다. 무조건 여기서부터 코드가 실행된다!
  - **객체 생성:** `MyMath mm = new MyMath();`처럼 `new` 키워드를 써서 `MyMath` 클래스의 '실제 계산기' 객체(`mm`)를 만든다.
  - **객체 메소드 호출:** `mm.add(6, 7)`처럼 만든 객체(`mm`)를 통해서 그 객체 안에 있는 메소드들을 호출한다.
  - **`static` 메소드 호출:** `firstMethod()`처럼 `static`이 붙은 메소드는 객체 생성 없이 클래스 이름으로 바로 호출할 수 있다.
  (같은 클래스 안에 있으면 클래스 이름마저 생략 가능하다! 존나게 편함!)
 */

public class MyMathEx { // 'MyMathEx'라는 이름의 클래스. 여기서 실제 프로그램을 돌려볼 거다.

    // ★★★ main 메소드: 여기가 프로그램의 시작점임! 무조건 여기서부터 코드가 실행된다. ★★★
    public static void main(String[] args) {

        // 1. MyMath 클래스의 객체(인스턴스) 생성
        // 'MyMath mm = new MyMath();' : 'MyMath' 클래스를 가지고 'mm'이라는 실제 '수학 계산기' 객체를 만드는 코드다.
        // 이렇게 객체를 만들어야 'MyMath' 클래스 안에 정의된 'add', 'sub' 같은 메소드들을 사용할 수 있다.
        MyMath mm = new MyMath();

        // 2. MyMath 객체의 메소드 호출 및 결과 저장
        // 'mm.add(6, 7)' : 'mm' 객체한테 'add' 메소드를 호출하라고 시키면서, 6과 7을 넘겨주는 거다.
        // 'add' 메소드가 6 + 7 = 13을 계산해서 int형으로 돌려주면, 그 13을 'r1'이라는 long 타입 변수에 저장한다.
        // **★참고: int형(13)이 long형(r1)으로 저장될 때는 자바가 알아서 바꿔주니까(자동 형변환) 문제 없다 **
        long r1 = mm.add(6, 7);
        long r2 = mm.sub(10, 2); // 'sub' 메소드 호출, 10 - 2 = 8 계산해서 'r2'에 저장.
        long r3 = mm.mul(2, 3); // 'mul' 메소드 호출, 2 * 3 = 6 계산해서 'r3'에 저장.
        long r4 = mm.div(10, 2); // 'div' 메소드 호출, 10 / 2 = 5 계산해서 'r4'에 저장.

        // 3. 계산 결과 출력
        // 'System.out.println()' : 괄호 안의 내용을 화면에 출력하라는 명령어다.
        System.out.println("--- MyMath 객체 메소드 호출 결과 ---");
        System.out.println("6 + 7 = " + mm.add(6, 7)); // 'mm.add(6, 7)'을 또 호출해서 나온 결과값 13을 바로 출력한다.
        System.out.println("r1 (6 + 7) = " + r1); // 변수 'r1'에 저장된 값 13을 출력.
        System.out.println("r2 (10 - 2) = " + r2); // 변수 'r2'에 저장된 값 8을 출력.
        System.out.println("r3 (2 * 3) = " + r3); // 변수 'r3'에 저장된 값 6을 출력.
        System.out.println("r4 (10 / 2) = " + r4); // 변수 'r4'에 저장된 값 5를 출력.
        System.out.println("r4 (10 / 0) = " + mm.div(10, 0)); // 0으로 나누는 경우 테스트 (에러 메시지 확인)

        // 4. ★★★ static 메소드 호출 (존나 중요!) ★★★
        // 'static' 메소드는 객체(`mm`처럼 `new`로 만든 거)를 만들 필요 없이, 클래스 이름으로 바로 호출할 수 있다.
        // 아니면 지금처럼 같은 클래스 안에 있으면 클래스 이름(`MyMathEx.firstMethod()`)도 생략하고 그냥 메소드 이름만 불러도 된다.
        System.out.println("\n--- Static 메소드 호출 테스트 ---");
        firstMethod(); // 'firstMethod()'를 호출하면, 얘가 다시 'secondMethod()'를 호출할 거다.
                        // 결과적으로 "secondMethod()..."가 화면에 출력될 거임.
    }

    // static 메소드: firstMethod
    // 'static void firstMethod()' : 이 메소드도 'static'이라서 'main' 메소드처럼 객체 없이 바로 호출된다.
    static void firstMethod() {
        secondMethod(); // 같은 'MyMathEx' 클래스 안에 있는 'static' 메소드인 'secondMethod()'를 호출.
                        // (원래는 'MyMathEx.secondMethod();' 라고 써야 하지만, 같은 클래스라 생략하는 거다.)
    }

    // static 메소드: secondMethod
    // 이 메소드도 'static'이다. 그냥 메시지를 출력하는 간단한 역할만 함.
    static void secondMethod() {
        System.out.println("secondMethod()... (이거 `static` 메소드다, 씨발!)"); // "secondMethod()..."라는 문장을 화면에 출력.
    }
}
