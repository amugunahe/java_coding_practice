package com.functionex; // 이 코드가 속한 패키지(폴더)를 정의합니다.

import java.util.*; // 'java.util' 패키지 안에 있는 모든 클래스를 가져와서 사용하겠다는 의미입니다.
                    // 특히, 사용자로부터 입력을 받기 위한 'Scanner' 클래스가 이 패키지 안에 있어요.

public class Calc { // 'Calc'라는 이름의 클래스를 정의합니다. 'Calculator'의 줄임말인 것 같네요!

    public static void main(String[] args) { // 프로그램의 시작점인 'main' 메서드입니다.
                                             // 자바 프로그램은 여기서부터 실행됩니다.

        // 1. 사용자 입력을 위한 'Scanner' 객체 생성:
        //    'Scanner'는 사용자로부터 키보드 입력을 받을 때 사용하는 도구예요.
        //    'new Scanner(System.in)'은 키보드 입력을 처리할 수 있는 스캐너를 만듭니다.
        Scanner sc = new Scanner(System.in);

        // 2. 사용자에게 메시지를 출력하여 입력을 요청합니다.
        System.out.print("두정수와 연산자 입력: ");

        // 3. 사용자로부터 두 개의 정수와 하나의 문자를 입력받습니다.
        //    'sc.nextInt()'는 사용자로부터 다음 정수 값을 입력받아 'a' 변수에 저장합니다.
        int a = sc.nextInt();
        //    'sc.nextInt()'는 다음 정수 값을 입력받아 'b' 변수에 저장합니다.
        int b = sc.nextInt();
        //    'sc.next().charAt(0)'는 사용자로부터 다음 단어(문자열)를 입력받고,
        //    그 단어의 첫 번째 문자(charAt(0))를 가져와 'c' 변수에 저장합니다.
        //    예: 사용자가 "10 20 +"를 입력하면, a=10, b=20, c='+'가 됩니다.
        char c = sc.next().charAt(0);

        // 4. 'switch-case' 문을 사용하여 입력받은 연산자('c')에 따라 다른 동작을 수행합니다.
        //    'switch'는 하나의 변수 값에 따라 여러 경우 중 하나를 선택하여 실행할 때 유용해요.
        switch(c) {
        // 5. 'c'의 값이 '+'인 경우:
        case '+':
            // 'Add' 클래스의 객체를 생성합니다. (덧셈을 수행할 'Add' 붕어빵을 만듭니다.)
            Add add = new Add();
            // 생성된 'add' 객체에 두 정수 'a'와 'b'를 설정합니다.
            add.setValue(a, b);
            // 'add' 객체의 'calculate()' 메서드를 호출하여 덧셈 결과를 얻고 출력합니다.
            System.out.println("결과: " + add.calculate());
            break; // 해당 'case'의 실행이 끝나면 'switch' 문을 빠져나옵니다.

        // 6. 'c'의 값이 '-'인 경우:
        case '-':
            // 'Sub' 클래스의 객체를 생성합니다. (뺄셈을 수행할 'Sub' 붕어빵을 만듭니다.)
            // (참고: Sub 클래스도 Add 클래스처럼 정의되어 있다고 가정합니다.)
            Sub sub = new Sub();
            // 'sub' 객체에 두 정수 'a'와 'b'를 설정합니다.
            sub.setValue(a, b);
            // 'sub' 객체의 'calculate()' 메서드를 호출하여 뺄셈 결과를 얻고 출력합니다.
            System.out.println("결과: " + sub.calculate());
            break;

        // 7. 'c'의 값이 '*'인 경우:
        case '*':
            // 'Mul' 클래스의 객체를 생성합니다. (곱셈을 수행할 'Mul' 붕어빵을 만듭니다.)
            // (참고: Mul 클래스도 Add 클래스처럼 정의되어 있다고 가정합니다.)
            Mul mul = new Mul();
            // 'mul' 객체에 두 정수 'a'와 'b'를 설정합니다.
            mul.setValue(a, b);
            // 'mul' 객체의 'calculate()' 메서드를 호출하여 곱셈 결과를 얻고 출력합니다.
            System.out.println("결과: " + mul.calculate());
            break;

        // 8. 'c'의 값이 '/'인 경우:
        case '/':
            // 'Div' 클래스의 객체를 생성합니다. (나눗셈을 수행할 'Div' 붕어빵을 만듭니다.)
            // (참고: Div 클래스도 Add 클래스처럼 정의되어 있다고 가정합니다.)
            Div div = new Div();
            // 'div' 객체에 두 정수 'a'와 'b'를 설정합니다.
            div.setValue(a, b);
            // 'div' 객체의 'calculate()' 메서드를 호출하여 나눗셈 결과를 얻고 출력합니다.
            System.out.println("결과: " + div.calculate());
            break;

        // 9. 위 'case'들 중 어떤 것에도 해당하지 않는 경우:
        default:
            // 잘못된 연산자를 입력했을 때 메시지를 출력합니다.
            System.out.println("잘못된 연산자 입니다.");
        }
        
        // 스캐너 사용이 끝났으면 닫아주는 것이 좋습니다. (선택 사항이지만 좋은 습관)
        sc.close();
    }
}
