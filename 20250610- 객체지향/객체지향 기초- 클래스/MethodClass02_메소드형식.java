package com.objectex; // 이 코드가 속한 패키지(폴더) 이름이에요.

/* 메소드 형식
   접근 제한자 반환타입(형) 메소드 이름(자료형 변수명, 자료형 변수명) // <- 선언부
   { // <- 구현부
   메소드 호출시 수행되는 코드
   }
*/

public class MethodClass02 { // MethodClass02 라는 이름의 클래스를 정의합니다.

    // 1. 숫자 두 개를 더하는 메소드: add
    // 선언부: public (어디서든 접근 가능), int (정수형 값 반환), add (메소드 이름), (int x, int y) (int형 x와 y를 매개변수로 받음)
    public int add(int x, int y) { // 선언부
        int result; // 'result'는 이 메소드 안에서만 사용되는 '지역 변수'예요.
                    // 메소드가 실행될 때 만들어지고, 메소드가 끝나면 사라집니다.

        // result = x + y; // x와 y를 더한 값을 result에 저장합니다.
                           // 이 줄은 아래 return 문에서 바로 계산하므로 생략 가능해요.

        return result = x + y; // 구현부
                               // 1. x + y를 계산한 값을 result 변수에 저장하고
                               // 2. 그 result 값을 메소드를 호출한 곳으로 '반환(return)'합니다.
                               // 반환 타입이 int이므로 int형 값을 돌려줘야 합니다.
    }

    // 2. 이름을 받아 처리하는 메소드 (현재는 비어있음): name
    // 선언부: public, String (문자열 값 반환), name (메소드 이름), (String na) (String형 na를 매개변수로 받음)
    public String name(String na) {
        return ""; // 현재는 아무 내용도 없이 빈 문자열을 반환합니다. 나중에 기능을 추가할 수 있어요.
    }

    // `int i;` 이 변수는 클래스의 멤버 변수입니다. 메소드 안의 지역 변수와는 별개로 존재해요.
    int i; // 이 i는 아래 print99dan() 메소드 안의 for문의 i와는 다릅니다.

    /* void: 아무것도 없음을 의미함
             반환값이 없는 경우 반환 타입으로 void를 적어야함
    */

    // 3. 구구단을 출력하는 메소드: print99dan
    // 선언부: void (반환값 없음), print99dan (메소드 이름), () (매개변수 없음)
    void print99dan() { // 접근 제한자가 생략되어 있어 같은 패키지 안에서만 접근 가능합니다. (default 접근 제한자)
        for (int i = 1; i <= 9; i++) { // 첫 번째 for문: 1단부터 9단까지 (i는 단수를 나타냄)
            for (int j = 2; j <= 9; j++) { // 두 번째 for문: 각 단의 2부터 9까지 곱셈 (j는 곱해지는 수를 나타냄)
                // 예: j=2, i=1일 때 "2*1=2 " 출력
                System.out.print(j + "*" + i + "=" + (j * i) + " ");
            }
            System.out.println(); // 한 단이 끝나면 줄바꿈을 합니다.
        }
        return; // void 메소드에서는 `return;`을 써도 되고 생략해도 됩니다.
                // 메소드의 실행을 이 지점에서 종료하라는 의미예요.
    }

    /* return -값을 돌려주다.
       - 작업을 수행한 결과인 반환값을 호출한 메소드로 전달하게 되는데
         이 값의 타입은 반환 타입과 일치하거나 적어도 자동 형변환이
         가능한 것이어야함
    */

    /* 지역변수 (Local variable)
       메소드 내에 선언된 변수들은 그 메소드 내에서만 사용할 수 있으므로
       서로 다른 메소드라면 같은 이름을 변수를 선언해도 된다.
    */
    // 예를 들어, `add` 메소드의 `result` 변수와 `print99dan` 메소드의 `i`, `j` 변수는
    // 각자의 메소드 안에서만 유효해요. 다른 메소드에서는 이 변수들을 사용할 수 없어요.

    /* 인자 (argument)와 매개변수 (parameter)
       - 메소드를 호출할 때 괄호()안에 지정해준 값들을 -> 인자 또는 인수라고함
         인자의 개수와 순서는 호출된 메소드에 선언된 매개변수와 일치해야함

       add(10, 2): 인자 -> int x, int y: 매개변수
    */
    // `add(10, 2)`에서 `10`과 `2`는 **인자(Arguments)**라고 부르고,
    // `public int add(int x, int y)`에서 `int x`, `int y`는 **매개변수(Parameters)**라고 불러요.
    // 인자로 넘겨준 값(10, 2)이 매개변수(x, y)에 각각 복사되어 메소드 안에서 사용됩니다.

    public static void main(String[] args) { // 프로그램의 시작점인 main 메소드입니다.

        // MethodClass02 클래스의 객체(인스턴스) 생성
        // 'static'이 붙지 않은 메소드(`add`, `name`, `print99dan`)를 호출하려면
        // 이렇게 해당 클래스의 객체를 먼저 만들어야 해요.
        MethodClass02 m = new MethodClass02();

        // 1. print99dan 메소드 호출
        m.print99dan(); // m 객체의 print99dan() 메소드를 호출합니다.
                        // 이 메소드는 반환값이 없으므로 그냥 호출만 하면 됩니다.
                        // 구구단이 화면에 출력될 거예요.

        // 2. add 메소드 호출
        // System.out.println(m.add(2, 3));
        // m 객체의 add(2, 3) 메소드를 호출합니다.
        // 이때 2와 3은 '인자'가 되고, add 메소드의 '매개변수' x와 y에 각각 2와 3이 대입됩니다.
        // add 메소드는 2+3=5를 계산해서 '5'라는 int 값을 반환합니다.
        // System.out.println()은 그 반환된 값 5를 화면에 출력합니다.
        System.out.println(m.add(2, 3)); // 출력: 5
    }
}
