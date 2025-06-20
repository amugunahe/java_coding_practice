package com.objectex; // 이 코드가 속한 패키지(폴더) 이름이에요.

public class ReferenceParamEx02 { // ReferenceParamEx02 라는 이름의 클래스를 정의합니다.

    // 1. 배열의 각 요소를 1씩 증가시키는 메소드: increase
    // 'public'은 다른 클래스에서도 이 메소드를 호출할 수 있다는 뜻이에요.
    // 'void'는 이 메소드가 반환하는 값이 없다는 뜻이에요.
    // 'int[] n'는 이 메소드가 '정수형 배열' 하나를 매개변수로 받는다는 뜻이에요.
    // 여기서 `n`은 '참조형 매개변수'입니다. main 메소드에서 전달받은 `int` 배열의 '주소'를 복사해와요.
    public void increase(int[] n) {
        for (int i = 0; i < n.length; i++) // 배열 `n`의 길이만큼 반복합니다. (n.length는 배열의 크기)
            n[i]++; // `n[i]`의 값을 1 증가시킵니다. (예: 100 -> 101, 800 -> 801, 1000 -> 1001)
                    // 매개변수 `n`은 main 메소드의 `ref`와 같은 배열을 가리키고 있으므로,
                    // 이 변경 사항은 main 메소드의 `ref` 배열에 직접 적용됩니다.
    }
    
    // 2. main 메소드: 프로그램의 시작점
    // 'static' 메소드이므로 객체 생성 없이 바로 실행됩니다.
    public static void main(String[] args) {
        
        // 1. int형 배열 선언 및 초기화
        int[] ref = {100, 800, 1000}; // `ref`라는 이름의 정수형 배열을 만들고, 초기 값 100, 800, 1000을 저장합니다.
                                     // `ref` 변수에는 이 배열이 저장된 메모리 '주소'가 담겨 있습니다.
        
        // 2. ReferenceParamEx02 클래스의 객체(인스턴스) 생성
        ReferenceParamEx02 rp = new ReferenceParamEx02(); // `increase` 메소드가 `static`이 아니기 때문에,
                                                        // 이 클래스의 객체를 먼저 만들어야 메소드를 호출할 수 있어요.
        
        // 3. increase 메소드 호출
        // rp.increase(ref); // rp 객체의 increase 메소드를 호출하면서 `ref` 배열 (정확히는 배열의 주소)을 매개변수로 넘겨줍니다.
                          // increase 메소드의 매개변수 `n`은 `ref`와 동일한 배열을 가리키게 됩니다.
        rp.increase(ref);
        
        // 4. increase 메소드 호출 후 배열 값 확인
        for (int i = 0; i < ref.length; i++) { // `ref` 배열의 길이만큼 반복하면서 각 요소의 값을 출력합니다.
            // increase 메소드에서 `ref` 배열의 각 요소가 1씩 증가했으므로,
            // 여기서는 변경된 값이 출력될 거예요.
            System.out.println("ref[" + i + "]:" + ref[i]);
        }
    }
}
