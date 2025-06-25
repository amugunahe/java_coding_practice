package com.functionex; // 'com.functionex'는 이 자바 파일(클래스)이 속한 패키지 이름이다. 
                         // 패키지는 관련된 클래스들을 묶어서 관리하는 폴더 같은 역할을 한다.

import java.io.*; // Java의 입출력(Input/Output) 관련 클래스들을 가져온다. 사용자로부터 키보드 입력을 받을 때 존나게 필요하다.

/*
  funcExam02 클래스: **사용자한테 연산이랑 숫자 입력받아서 존나게 계산해주는 콘솔 계산기다!**
  * 핵심:
  - **목표:** '+' (더하기), '-' (빼기), '*' (곱하기), '/' (나누기), '%' (나머지) 연산을
  각각 별도의 **메소드(method)**로 구현해서 코드를 존나게 깔끔하게 만들고 재활용성을 높였다!
  - **메소드 분리:** `plus()`, `minus()`, `multi()`, `divi()`, `per()`는 각 연산을 담당하고,
  `disp()`는 계산 결과를 깔끔하게 보여주는 역할을 한다.
  - **`BufferedReader`:** 키보드 입력을 한 줄씩 읽어올 때 쓰는 존나 유용한 놈이다!
  - **`System.in.read()`:** 문자 하나(바이트)를 읽어올 때 쓴다. (연산자 입력받을 때 썼다!)
  - **`Integer.parseInt()`:** 읽어온 문자열 숫자를 `int` 타입으로 바꿀 때 쓴다! (이거 안 하면 계산 못 한다, 씨발!)
  - **`do-while` 문:** 올바른 연산자(`+`, `-`, `*`, `/`, `%`)가 입력될 때까지 계속 다시 입력받게 한다! (존나 중요!)
  - **`switch` 문:** 입력된 연산자에 따라 알맞은 연산 메소드를 존나게 똑똑하게 골라 실행한다!
  - **`throws IOException`:** 입출력하다가 생길 수 있는 예외(에러)를 미리 알려주는 거다.
 */

public class funcExam02 { // 'funcExam02'라는 이름의 공개(public) 클래스를 선언한다. 자바 프로그램의 기본 실행 단위다.

    // 1. `plus()` 메소드: 두 정수를 더하고 결과를 반환한다.
    // 'public static': 어디서든 접근 가능하며, 객체 생성 없이 바로 호출할 수 있다. (존나 편하다!)
    // 'int': 이 메소드가 int형 값을 반환한다는 의미다.
    // '(int a, int b)': int형 매개변수 `a`와 `b`를 입력으로 받는다.
    public static int plus(int a, int b) {
        return a + b; // `a`와 `b`를 더한 결과를 반환한다.
    }
    
    // 2. `minus()` 메소드: 두 정수를 빼고 결과를 반환한다.
    public static int minus(int a, int b) {
        return a - b; // `a`에서 `b`를 뺀 결과를 반환한다.
    }
    
    // 3. `multi()` 메소드: 두 정수를 곱하고 결과를 반환한다.
    public static int multi(int a, int b) {
        return a * b; // `a`와 `b`를 곱한 결과를 반환한다.
    }
    
    // 4. `divi()` 메소드: 두 정수를 나누고 결과를 반환한다. (정수 나눗셈)
    public static int divi(int a, int b) {
        // ★★★ 주의: 정수 나눗셈은 소수점 이하를 버린다! (예: 10 / 3은 3이 된다!) ★★★
        // ★★★ 존나 중요! 0으로 나누는 경우(`b`가 0일 경우) `ArithmeticException`이 발생할 수 있으니 실제 프로그램에서는 예외 처리가 필수다! ★★★
        if (b == 0) { // 0으로 나누는 경우를 막는다!
            System.out.println("씨발! 0으로 나눌 수 없다!");
            return 0; // 예시로 0을 반환하지만, 실제로는 예외를 던지거나 다른 처리를 해야 한다.
        }
        return a / b; // `a`를 `b`로 나눈 결과를 반환한다.
    }
    
    // 5. `per()` 메소드: 두 정수의 나머지 값을 반환한다.
    public static int per(int a, int b) {
        // ★★★ 존나 중요! 0으로 나누는 경우(`b`가 0일 경우) `ArithmeticException`이 발생할 수 있으니 실제 프로그램에서는 예외 처리가 필수다! ★★★
        if (b == 0) { // 0으로 나누는 경우를 막는다!
            System.out.println("씨발! 0으로 나눈 나머지 계산은 할 수 없다!");
            return 0; // 예시로 0을 반환하지만, 실제로는 예외를 던지거나 다른 처리를 해야 한다.
        }
        return a % b; // `a`를 `b`로 나눈 나머지 값을 반환한다.
    }
    
    // 6. `disp()` 메소드: 계산 결과를 형식에 맞춰 출력한다. (반환값 없음)
    // 'void': 이 메소드는 반환하는 값이 없다. (대신 직접 화면에 출력한다.)
    // '(int a, char b, int c, int d)': 첫 번째 수, 연산자, 두 번째 수, 결과 값을 매개변수로 받는다.
    public static void disp(int a, char b, int c, int d) {
        System.out.println(); // 한 줄 띄움. (깔끔하게 보이기 위함!)
        // 예: "10 + 5 = 15" 형식으로 출력한다.
        System.out.println(a + " " + b + " " + c + " = " + d + "다, 씨발!");
    }

    // 7. `main()` 메소드: 프로그램의 실행 흐름을 제어하는 존나 중요한 시작점이다!
    public static void main(String[] args) throws IOException { // 입출력 관련 예외가 생길 수 있으니 'throws IOException' 박아둔다!
        
        // ★★★ 사용자 입력을 효율적으로 읽어들이기 위한 객체 생성! ★★★
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int su1, su2, res = 0; // 첫 번째 수, 두 번째 수, 결과 값을 저장할 변수들을 선언하고 `res`는 0으로 초기화한다.
        char yon; // 연산자(+, -, *, /, %)를 저장할 변수.
        
        System.out.print("첫번째 수: "); // 사용자에게 첫 번째 수를 입력하라는 메시지 출력.
        // `br.readLine()`: 키보드로 입력된 한 줄을 읽어온다. (문자열 형태)
        // `Integer.parseInt()`: 읽어온 문자열을 정수(int)로 변환한다.
        su1 = Integer.parseInt(br.readLine());
        
        // ★★★ `do-while` 루프: 올바른 연산자가 입력될 때까지 존나게 반복한다! ★★★
        do {
            System.out.print("연산자 입력(+, -, *, /, %): "); // 연산자 입력 안내 메시지 출력.
            // `System.in.read()`: 키보드로부터 한 바이트(문자 1개)를 읽어온다.
            //                   입력 버퍼에 '\n' (엔터)와 같은 불필요한 문자가 남아있을 수 있어,
            //                   이후 `System.in.read()`를 두 번 더 호출하여 버퍼를 비워주는 부분이 있다.
            //                   (예: '+' 입력 후 엔터 누르면 '+', '\r', '\n' 세 바이트가 들어올 수 있음)
            yon = (char)System.in.read(); // 읽어온 바이트를 char로 형변환하여 `yon`에 저장.
            System.in.read(); // 불필요한 캐리지 리턴(\r) 또는 라인 피드(\n) 문자를 버림.
            System.in.read(); // 불필요한 라인 피드(\n) 문자를 버림 (혹은 \r을 버리는 경우도).
            
        } while (yon != '+' && yon != '-' && yon != '*' && yon != '/' && yon != '%');
        // `while` 조건: 입력받은 `yon`이 유효한 연산자(`+`, `-`, `*`, `/`, `%`)가 아니라면
        //              다시 `do` 블록으로 돌아가 연산자를 재입력 받는다.

        System.out.print("두번째 수: "); // 사용자에게 두 번째 수를 입력하라는 메시지 출력.
        su2 = Integer.parseInt(br.readLine());
        
        // ★★★ `switch` 문: 입력받은 연산자(`yon`)에 따라 다른 연산 메소드를 존나게 똑똑하게 호출한다! ★★★
        switch (yon) {
        case '+':
            res = plus(su1, su2); // `plus()` 메소드 호출 후 결과값을 `res`에 저장.
            break; // `switch` 문을 빠져나감.
        case '-':
            res = minus(su1, su2); // `minus()` 메소드 호출.
            break;
        case '*':
            res = multi(su1, su2); // `multi()` 메소드 호출.
            break;
        case '/':
            res = divi(su1, su2); // `divi()` 메소드 호출. (여기서 0으로 나누는 경우 예외 처리됨!)
            break;
        case '%':
            res = per(su1, su2); // `per()` 메소드 호출. (여기서 0으로 나눈 나머지 예외 처리됨!)
            break;
        // default: // 유효한 연산자만 받도록 do-while에서 처리했으므로 default는 필요 없다.
        //     break;
        }
        
        // ★★★ 최종 계산 결과 출력! ★★★
        // 계산된 `su1`, `yon`, `su2`, `res` 값을 `disp()` 메소드에 넘겨 최종 결과 출력.
        disp(su1, yon, su2, res);
        
    } // main 메소드 종료
} // funcExam02 클래스 종료
