package com.overex; // 이 코드가 속한 패키지 이름입니다.

/*
  [생성자 설명]
  - 인스턴스(객체)가 생성될 때 자동으로 호출되는 인스턴스 초기화 메서드입니다.
  - 주로 인스턴스 변수(필드)들을 초기화하는 데 사용됩니다.
  - 생성자의 조건:
  1. 클래스 이름과 동일해야 합니다.
  2. 리턴값이 없습니다 (void를 붙이지 않습니다).
 */

class Data1 {
    int value; // 이 클래스에는 명시적으로 생성자를 정의하지 않았습니다.
               // 이런 경우 자바 컴파일러가 아무런 작업도 하지 않는 '기본 생성자(Default Constructor)'를 자동으로 추가해줍니다.
               // 예: public Data1() {}
}

class Data2 {
    int value;

    public Data2(int x) { // 이 클래스에는 매개변수가 있는 생성자를 명시적으로 정의했습니다.
                          // 이렇게 사용자가 생성자를 하나라도 정의하면, 컴파일러는 기본 생성자를 자동으로 추가해주지 않습니다.
                          // 따라서 Data2 객체는 반드시 매개변수와 함께 `new Data2(값)` 형태로 생성해야 합니다.
        value = x; // 매개변수 x로 받은 값을 인스턴스 변수 value에 저장하여 초기화합니다.
    }
}

public class ConstructorEx01 { // 'ConstructorEx01'이라는 이름의 클래스를 정의합니다.

    private int n; // 이 클래스의 인스턴스 변수(필드)입니다. 'private'은 이 클래스 내에서만 접근 가능함을 의미합니다.

    // 1. 기본 생성자 (매개변수가 없는 생성자)
    public ConstructorEx01() {
        // 객체가 `new ConstructorEx01()`처럼 생성될 때 이 생성자가 호출됩니다.
        n = 10; // 인스턴스 변수 'n'의 값을 10으로 초기화합니다.
    }
    
    // 2. 생성자 오버로딩 (int 타입 매개변수)
    // 매개변수가 다른(타입 또는 개수) 여러 개의 생성자를 정의하는 것을 '생성자 오버로딩'이라고 합니다.
    // 이는 객체를 다양한 방식으로 초기화할 수 있게 해줍니다.
    public ConstructorEx01(int n) { // int 타입의 매개변수 'n'을 받습니다.
        // `this.n = n;`
        // - `this.n`: 현재 객체(인스턴스)의 인스턴스 변수 'n'을 의미합니다.
        // - `n`: 매개변수로 전달받은 'n'을 의미합니다.
        // 매개변수 이름과 인스턴스 변수 이름이 같을 때, `this`를 사용하여 인스턴스 변수를 명확하게 구분합니다.
        this.n = n; // 매개변수로 받은 'n' 값을 인스턴스 변수 'n'에 저장하여 초기화합니다.
    }
    
    // 3. 생성자 오버로딩 (long 타입 매개변수)
    public ConstructorEx01(long n) { // long 타입의 매개변수 'n'을 받습니다.
        // `this.n = (int)n;`
        // - long 타입은 int 타입보다 표현 범위가 넓기 때문에, long 값을 int 변수에 직접 저장하면 '오버플로우'나 '데이터 손실'이 발생할 수 있습니다.
        // - `(int)n`: 이를 방지하기 위해 long 타입의 'n'을 명시적으로 int 타입으로 '형 변환(Type Casting)'하여 저장합니다.
        this.n = (int)n;
    }
    
    // 4. 생성자 오버로딩 (short 타입 매개변수)
    public ConstructorEx01(short s) { // short 타입의 매개변수 's'를 받습니다.
        // `this.n = s;`
        // - short 타입은 int 타입보다 표현 범위가 좁기 때문에, short 값을 int 변수에 저장할 때는 명시적인 형 변환 없이도 자동으로 확장됩니다.
        //   이를 '자동 형 변환(Implicit Type Conversion)'이라고 합니다.
        this.n = s;
    }
    
    // 현재 객체의 'n' 값을 출력하는 메서드
    public void write() {
        System.out.println("n: " + n);
    }

    // ★★★ 프로그램의 시작점 ★★★
    public static void main(String[] args) {
        // Data1 객체 생성: 명시적 생성자가 없으므로 컴파일러가 제공한 기본 생성자가 사용됩니다.
        Data1 d1 = new Data1(); // d1.value는 0으로 자동 초기화됩니다. (int의 기본값)

        // Data2 객체 생성: 매개변수 있는 생성자가 정의되어 있으므로 반드시 값을 전달해야 합니다.
        Data2 d2 = new Data2(10); // d2.value는 10으로 초기화됩니다.

        // ConstructorEx01 객체 생성 (기본 생성자 호출)
        ConstructorEx01 c = new ConstructorEx01(); // 매개변수 없이 객체를 생성하므로, 'n'이 10으로 초기화되는 기본 생성자가 호출됩니다.
        c.write(); // 출력: n: 10

        // ConstructorEx01 객체 생성 (int 매개변수 생성자 호출)
        ConstructorEx01 c2 = new ConstructorEx01(20); // 'n'이 20으로 초기화됩니다.
        c2.write(); // 출력: n: 20

        // ConstructorEx01 객체 생성 (long 매개변수 생성자 호출)
        ConstructorEx01 c3 = new ConstructorEx01(30L); // 30L은 long 타입 리터럴입니다. 'n'이 30으로 초기화됩니다.
        c3.write(); // 출력: n: 30

        // ConstructorEx01 객체 생성 (short 매개변수 생성자 호출)
        short
