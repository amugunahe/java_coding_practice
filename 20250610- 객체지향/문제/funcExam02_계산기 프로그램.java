package com.functionex; // 이 코드가 속한 패키지(폴더) 이름이에요.

/* 문] 계산기 프로그램에서 +, -, *, /, % 등의 연산을 메소드를 이용하여
  프로그램을 구현하시오.
 
  plus(+), minus(-), multi(*), divi(/), per(%),
  disp(출력)
 
  첫번째 수:
  연산자: (+, -, /, /, %): -> 연산자가 아닌 경우 다시 받도록 한다.
  두번째 수:
 */

import java.io.*; // 입출력(Input/Output) 관련 기능을 사용하기 위해 필요합니다. (BufferedReader, System.in.read() 등)

public class funcExam02 { // funcExam02 라는 이름의 클래스를 정의합니다.

    // 1. plus() 메소드: 두 정수를 더하고 결과를 반환
    // 'public static': 어디서든 접근 가능하며, 객체 생성 없이 바로 호출할 수 있습니다.
    // 'int': 이 메소드가 int형 값을 반환한다는 의미입니다.
    // '(int a, int b)': int형 매개변수 `a`와 `b`를 입력으로 받습니다.
    public static int plus(int a, int b) {
        return a + b; // a와 b를 더한 결과를 반환합니다.
    }
    
    // 2. minus() 메소드: 두 정수를 빼고 결과를 반환
    public static int minus(int a, int b) {
        return a - b; // a에서 b를 뺀 결과를 반환합니다.
    }
    
    // 3. multi() 메소드: 두 정수를 곱하고 결과를 반환
    public static int multi(int a, int b) {
        return a * b; // a와 b를 곱한 결과를 반환합니다.
    }
    
    // 4. divi() 메소드: 두 정수를 나누고 결과를 반환 (정수 나눗셈)
    public static int divi(int a, int b) {
        // 주의: 정수 나눗셈은 소수점 이하를 버립니다. 예를 들어 10 / 3은 3이 됩니다.
        // 0으로 나누는 경우(b가 0일 경우) ArithmeticException이 발생할 수 있으니 실제 프로그램에서는 예외 처리가 필요해요.
        return a / b; // a를 b로 나눈 결과를 반환합니다.
    }
    
    // 5. per() 메소드: 두 정수의 나머지 값을 반환
    public static int per(int a, int b) {
        return a % b; // a를 b로 나눈 나머지 값을 반환합니다.
    }
    
    // 6. disp() 메소드: 계산 결과를 형식에 맞춰 출력 (반환값 없음)
    // 'void': 이 메소드는 반환하는 값이 없습니다. (대신 직접 화면에 출력합니다.)
    // '(int a, char b, int c, int d)': 첫 번째 수, 연산자, 두 번째 수, 결과 값을 매개변수로 받습니다.
    public static void disp(int a, char b, int c, int d) {
        System.out.println(); // 한 줄 띄움
        // 예: "10 + 5 = 15" 형식으로 출력
        System.out.println(a + " " + b + " " + c + " = " + d);
    }

    // 7. main 메소드: 프로그램의 실행 흐름을 제어
    public static void main(String[] args) throws IOException {
        
        // 사용자 입력을 효율적으로 읽어들이기 위한 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int su1, su2, res = 0; // 첫 번째 수, 두 번째 수, 결과 값을 저장할 변수들을 선언하고 `res`는 0으로 초기화
        char yon; // 연산자(+, -, *, /, %)를 저장할 변수
        
        System.out.print("첫번째 수: "); // 사용자에게 첫 번째 수를 입력하라는 메시지 출력
        // br.readLine(): 키보드로 입력된 한 줄을 읽어옵니다. (문자열 형태)
        // Integer.parseInt(): 읽어온 문자열을 정수(int)로 변환합니다.
        su1 = Integer.parseInt(br.readLine());
        
        // `do-while` 루프: 올바른 연산자가 입력될 때까지 반복
        do {
            System.out.print("연산자 입력: ");
            // `System.in.read()`: 키보드로부터 한 바이트(문자 1개)를 읽어옵니다.
            //                   입력 버퍼에 '\n' (엔터)와 같은 불필요한 문자가 남아있을 수 있어,
            //                   이후 `System.in.read()`를 두 번 더 호출하여 버퍼를 비워주는 부분이 있습니다.
            //                   (예: '+' 입력 후 엔터 누르면 '+', '\r', '\n' 세 바이트가 들어올 수 있음)
            yon = (char)System.in.read(); // 읽어온 바이트를 char로 형변환하여 `yon`에 저장
            System.in.read(); // 불필요한 캐리지 리턴(\r) 또는 라인 피드(\n) 문자를 버림
            System.in.read(); // 불필요한 라인 피드(\n) 문자를 버림 (혹은 \r을 버리는 경우도)
            
        } while (yon != '+' && yon != '-' && yon != '*' && yon != '/' && yon != '%');
        // `while` 조건: 입력받은 `yon`이 유효한 연산자가 아니라면 (즉, 위에 명시된 연산자 중 하나가 아니라면)
        //              다시 `do` 블록으로 돌아가 연산자를 재입력 받습니다.

        System.out.print("두번째 수: "); // 사용자에게 두 번째 수를 입력하라는 메시지 출력
        su2 = Integer.parseInt(br.readLine());
        
        // `switch` 문: 입력받은 연산자(`yon`)에 따라 다른 연산 메소드를 호출
        switch (yon) {
        case '+':
            res = plus(su1, su2); // `plus` 메소드 호출 후 결과값을 `res`에 저장
            break; // `switch` 문을 빠져나감
        case '-':
            res = minus(su1, su2); // `minus` 메소드 호출
            break;
        case '*':
            res = multi(su1, su2); // `multi` 메소드 호출
            break;
        case '/':
            res = divi(su1, su2); // `divi` 메소드 호출
            break;
        case '%':
            res = per(su1, su2); // `per` 메소드 호출
            break;
        // default: // 유효한 연산자만 받도록 do-while에서 처리했으므로 default는 필요 없음
        //     break;
        }
        
        // 출력 메소드 호출
        // 계산된 `su1`, `yon`, `su2`, `res` 값을 `disp` 메소드에 넘겨 최종 결과 출력
        disp(su1, yon, su2, res);
        
    }
}
