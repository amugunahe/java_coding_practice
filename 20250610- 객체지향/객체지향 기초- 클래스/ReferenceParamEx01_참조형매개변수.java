package com.objectex; // 이 코드가 속한 패키지(폴더) 이름이에요.

class Data { // Data라는 이름의 클래스를 정의합니다.
    int x; // int형 멤버 변수 x를 가지고 있어요.
           // 이 x는 Data 클래스의 객체가 만들어질 때마다 자신만의 고유한 x를 가지게 돼요.
}

public class ReferenceParamEx01 { // ReferenceParamEx01 이라는 이름의 클래스를 정의합니다.

    // 1. change 메소드 정의
    // 'static'은 객체 생성 없이 바로 호출할 수 있다는 뜻이에요.
    // 'void'는 이 메소드가 반환하는 값이 없다는 뜻이에요.
    // 'Data d'는 이 메소드가 'Data 클래스의 객체 하나'를 매개변수로 받는다는 뜻이에요.
    // 여기서 `d`는 '참조형 매개변수'입니다. main 메소드에서 전달받은 `Data` 객체의 '주소'를 복사해와요.
    static void change(Data d) { // Data d: 참조형 매개변수
        
        d.x = 1000; // 매개변수 `d`가 가리키는 객체의 `x` 값을 1000으로 변경합니다.
                    // 매개변수 `d`는 main 메소드에서 만든 `Data` 객체와 같은 주소를 참조하고 있으므로,
                    // 결국 main 메소드에 있는 그 객체 자체의 `x` 값이 바뀌게 되는 거예요.
        
        System.out.println("change() : x =>" + d.x); // change 메소드 안에서 변경된 `d.x` 값을 출력합니다.
                                                    // 출력: "change() : x => 1000"
    }
    
    public static void main(String[] args) { // 프로그램의 시작점인 main 메소드입니다.
        
        // 1. Data 클래스의 객체(인스턴스) 생성
        Data d = new Data(); // 'new Data()'는 Data 클래스를 바탕으로 실제 'Data' 객체를 메모리에 만드세요! 라는 명령이에요.
                             // 이렇게 만들어진 객체를 'd'라는 변수가 가리키게 됩니다. (변수 d에는 객체의 메모리 주소가 저장돼요.)
        
        // 2. 객체 d의 x 값 초기화
        d.x = 10; // d가 가리키는 객체의 멤버 변수 `x`에 10을 저장합니다.
        
        System.out.println("main(): x =>" + d.x); // main 메소드에서 현재 `d.x` 값을 출력합니다.
                                                  // 출력: "main(): x => 10"

        // 3. change() 메소드 호출
        // change(d); // change 메소드를 호출하면서 `d` 변수(즉, Data 객체의 메모리 주소)를 매개변수로 넘겨줍니다.
        // 여기서 중요한 점: `d` 변수 자체의 값(주소)이 change 메소드의 매개변수 `d`에 '복사'됩니다.
        // 즉, `main`의 `d`와 `change`의 `d`는 '다른 변수'이지만, '같은 객체'를 가리키게 됩니다.
        
        change(d); // change 메소드에 x의 값을 1000으로 변경 (주소 복사이므로 원본 객체의 값이 변경됩니다!)
        
        // 4. change() 메소드 호출 후 main 메소드에서 x 값 확인
        System.out.println("main(): x =>" + d.x); // change 메소드 호출 후 main 메소드에서 다시 `d.x` 값을 출력합니다.
                                                  // change 메소드 안에서 `d.x`의 값이 1000으로 변경되었으므로,
                                                  // main 메소드에서 보더라도 `d.x` 값은 1000이 되어 있습니다.
                                                  // 출력: "main(): x => 1000"
    
    }
}
