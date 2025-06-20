package com.overex; // 이 코드가 속한 패키지(폴더) 이름이에요.

/* 오버로딩 (Overloading)
   - 한 클래스 내에 같은 이름의 메소드를 여러개 정의하는 것을 의미함
   하나의 메소드 이름으로 여러 기능을 구현하기 때문에 붙여진 이름임

   오버로딩의 조건
   1. 메소드 이름이 같아야 한다.
   2. 매개변수의 개수 또는 자료명이 달라야한다.

    int add(int a, int b){}
    long add(int x, int y)  // 매개변수가 같아서 안됨 (위에 설명했듯이 반환 타입만 다르면 안돼요!)

    long add(long x, int y) // 이거는 됨 (매개변수의 자료형이 다르죠? int, int vs long, int)
*/

class FunctionEx { // FunctionEx 이라는 이름의 클래스를 정의합니다. 여기에 오버로딩된 메소드들이 있어요.

    // 1. int형 정수 두 개를 받아서 더하는 메소드
    int add(int a, int b) { // 메소드 이름: add, 매개변수: int a, int b (둘 다 int 타입)
        System.out.println("int, int"); // 이 메소드가 실행될 때 "int, int"를 출력합니다.
        return a + b; // 두 정수를 더한 값을 반환합니다. 반환 타입은 int 입니다.
    }

    // 2. int형 정수 하나와 long형 정수 하나를 받아서 더하는 메소드 (오버로딩!)
    long add(int a, long b) { // 메소드 이름: add (위와 같음), 매개변수: int a, long b (자료형이 다름!)
        System.out.println("int, long"); // "int, long"을 출력합니다.
        return a + b; // 두 수를 더한 값을 반환합니다. long 타입으로 반환합니다 (더 큰 자료형에 맞춰요).
    }

    // 3. long형 정수 하나와 int형 정수 하나를 받아서 더하는 메소드 (오버로딩!)
    long add(long a, int b) { // 메소드 이름: add (위와 같음), 매개변수: long a, int b (자료형 순서가 다름!)
        System.out.println("long, int"); // "long, int"를 출력합니다.
        return a + b; // 두 수를 더한 값을 반환합니다. long 타입으로 반환합니다.
    }

    // 4. long형 정수 두 개를 받아서 더하는 메소드 (오버로딩!)
    long add(long a, long b) { // 메소드 이름: add (위와 같음), 매개변수: long a, long b (자료형이 다름!)
        System.out.println("long, long"); // "long, long"을 출력합니다.
        return a + b; // 두 long 정수를 더한 값을 반환합니다. long 타입으로 반환합니다.
    }

    // 5. int형 배열을 받아서 배열 안의 모든 요소를 더하는 메소드 (오버로딩!)
    int add(int[] a) { // 메소드 이름: add (위와 같음), 매개변수: int 배열 (매개변수의 개수와 타입이 완전히 다름!)

        int res = 0; // 결과를 저장할 변수를 0으로 초기화합니다.
        for (int i = 0; i <a.length; i++) { // 배열의 길이만큼 반복합니다.
            res += a[i]; // 배열의 각 요소를 res에 더합니다.
        }
        return res; // 모든 요소의 합을 반환합니다.
    }
}

public class OverloadingEx01 { // 프로그램을 실행하는 메인 클래스입니다.

    public static void main(String[] args) { // 프로그램의 시작점인 main 메소드입니다.

        // 메소드 호출
        FunctionEx fe = new FunctionEx(); // FunctionEx 클래스의 객체(인스턴스)를 생성합니다.
                                         // 이제 fe를 통해 FunctionEx 안에 있는 메소드들을 사용할 수 있어요.

        System.out.println(fe.add(3, 3)); // add 메소드 호출:
                                         // 매개변수가 둘 다 int형 숫자 (3, 3)이므로
                                         // "int add(int a, int b)" 메소드가 호출됩니다.
                                         // 결과: "int, int" 출력 후 6 (3+3) 출력

        System.out.println(fe.add(3L, 3)); // add 메소드 호출:
                                          // 첫 번째 매개변수가 long형 (3L), 두 번째가 int형 (3)이므로
                                          // "long add(long a, int b)" 메소드가 호출됩니다.
                                          // 결과: "long, int" 출력 후 6 (3+3) 출력 (long 타입으로 계산)

        System.out.println(fe.add(3, 3L)); // add 메소드 호출:
                                          // 첫 번째 매개변수가 int형 (3), 두 번째가 long형 (3L)이므로
                                          // "long add(int a, long b)" 메소드가 호출됩니다.
                                          // 결과: "int, long" 출력 후 6 (3+3) 출력 (long 타입으로 계산)

        System.out.println(fe.add(3L, 3L)); // add 메소드 호출:
                                           // 매개변수가 둘 다 long형 (3L, 3L)이므로
                                           // "long add(long a, long b)" 메소드가 호출됩니다.
                                           // 결과: "long, long" 출력 후 6 (3+3) 출력 (long 타입으로 계산)

        int[] a = {100, 200, 300}; // int형 배열을 생성하고 값들을 초기화합니다.
        System.out.println(fe.add(a)); // add 메소드 호출:
                                       // 매개변수가 int 배열 (a)이므로
                                       // "int add(int[] a)" 메소드가 호출됩니다.
                                       // 결과: 100 + 200 + 300 = 600 출력
    }
}
