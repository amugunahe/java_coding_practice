package com.overex; // 이 코드가 속한 패키지(폴더) 이름이에요.

class OverloadingEx { // OverloadingEx 라는 이름의 클래스를 정의합니다.

    // 1. 매개변수가 없는 print 메소드
    public void print() { // 메소드 이름: print, 매개변수: 없음
        System.out.println("인자 없는 메소드 ...."); // "인자 없는 메소드 ...."를 출력합니다.
    }

    /*
    public int print() {
        return;     // 오버로딩 아님, 메서드 이름 같고 매개변수도 없으므로 컴파일 오류
    }
    */
    // 이 주석 처리된 부분은 아주 중요한 포인트예요!
    // `public int print()`는 위에 있는 `public void print()`와 메소드 이름도 같고,
    // 매개변수도 똑같이 없어요. 반환 타입(void vs int)만 다르죠.
    // 자바는 메소드를 구분할 때 '반환 타입'을 보지 않아요!
    // 그래서 이 두 메소드는 자바 입장에서 '똑같은 메소드'로 보이기 때문에,
    // 동시에 존재할 수 없고 컴파일 오류가 납니다. 이것이 오버로딩의 중요한 조건 중 하나예요.

    // 2. short형 정수를 받는 print 메소드
    public void print(short val) { // 메소드 이름: print, 매개변수: short val
        System.out.println("short ...."); // "short ...."를 출력합니다.
    }

    // 3. int형 정수를 받는 print 메소드 (오버로딩!)
    public void print(int val) { // 메소드 이름: print, 매개변수: int val (short와 자료형 다름)
        System.out.println("int ...."); // "int ...."를 출력합니다.
    }

    // 4. long형 정수를 받는 print 메소드 (오버로딩!)
    public void print(long val) { // 메소드 이름: print, 매개변수: long val (int와 자료형 다름)
        System.out.println("long ...."); // "long ...."를 출력합니다.
    }

    // --- write 메소드들은 print 메소드들과는 이름이 다르기 때문에
    //     print 메소드들끼리만 오버로딩 관계이고, write 메소드들끼리만 오버로딩 관계예요. ---

    // 5. int형 정수를 받는 write 메소드
    public void write(int val) { // 메소드 이름: write, 매개변수: int val
        System.out.println("int"); // "int"를 출력합니다.
    }

    // 6. long형 정수를 받는 write 메소드 (오버로딩!)
    public void write(long val) { // 메소드 이름: write, 매개변수: long val (int와 자료형 다름)
        System.out.println("long"); // "long"을 출력합니다.
    }

    // 7. Long 객체(참조형)를 받는 write 메소드 (오버로딩!)
    public void write(Long val) { // 메소드 이름: write, 매개변수: Long val (위의 long과는 다른 '객체' 타입)
        System.out.println("Long"); // "Long"을 출력합니다.
    }
    // `long`은 8바이트 정수를 저장하는 '기본 자료형'이고,
    // `Long`은 `long` 기본 자료형을 감싸는 '래퍼(Wrapper) 클래스'라고 하는 '참조 자료형(객체)'이에요.
    // 서로 다른 자료형으로 간주되므로 오버로딩이 가능합니다.
}

public class OverloadingEx02 { // 프로그램을 실행하는 메인 클래스입니다.

    public static void main(String[] args) { // 프로그램의 시작점인 main 메소드입니다.

        OverloadingEx oe = new OverloadingEx(); // OverloadingEx 클래스의 객체(인스턴스)를 생성합니다.

        short s = 10;   // short 타입의 변수 s에 10을 저장
        Short ss = 10;  // Short (래퍼 클래스) 타입의 변수 ss에 10을 저장 (자동 박싱으로 short 10이 Short 객체로 변환)
        int i = 10;     // int 타입의 변수 i에 10을 저장
        long l = 10;    // long 타입의 변수 l에 10을 저장

        System.out.println("--- print 메소드 호출 결과 ---");
        oe.print();     // 매개변수가 없는 print() 메소드 호출
                        // 출력: "인자 없는 메소드 ...."

        oe.print(s);    // short 타입 변수 s로 print() 메소드 호출
                        // `print(short val)` 메소드가 정확히 일치하므로 해당 메소드 호출
                        // 출력: "short ...."

        oe.print(i);    // int 타입 변수 i로 print() 메소드 호출
                        // `print(int val)` 메소드가 정확히 일치하므로 해당 메소드 호출
                        // 출력: "int ...."

        oe.print(l);    // long 타입 변수 l로 print() 메소드 호출
                        // `print(long val)` 메소드가 정확히 일치하므로 해당 메소드 호출
                        // 출력: "long ...."

        System.out.println("--- write 메소드 호출 결과 ---");
        oe.write(s);    // short 타입 변수 s로 write() 메소드 호출
                        // `write(short val)` 메소드는 없어요!
                        // 이럴 때는 자바가 '자동 형변환(Widening Conversion)'을 시도해요.
                        // short는 int로, int는 long으로 '자동으로 커질 수' 있어요.
                        // `write(int val)`이 가장 가까운 오버로딩 메소드이므로 이 메소드가 호출돼요.
                        // 출력: "int"

        oe.write(ss);   // Short 객체 변수 ss로 write() 메소드 호출
                        // `write(Short val)` 메소드가 정확히 일치하므로 해당 메소드 호출
                        // (여기서 Short 객체는 기본 자료형 long으로 '언박싱'된 후 `write(long val)`로 가기보다는,
                        //  `write(Long val)`이라는 정확히 일치하는 객체 타입 메소드가 있으므로 그쪽으로 가요)
                        // 출력: "Long"

        oe.write(i);    // int 타입 변수 i로 write() 메소드 호출
                        // `write(int val)` 메소드가 정확히 일치하므로 해당 메소드 호출
                        // 출력: "int"

        oe.write(l);    // long 타입 변수 l로 write() 메소드 호출
                        // `write(long val)` 메소드가 정확히 일치하므로 해당 메소드 호출
                        // 출력: "long"
    }
}
