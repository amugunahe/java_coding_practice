package com.objectex; // 이 코드가 속한 패키지(폴더) 이름이에요.

public class VariableEx { // VariableEx 라는 이름의 클래스를 정의합니다.

    // 1. 가변 인자를 받는 메소드: argsTest
    // 'public'은 다른 클래스에서도 이 메소드를 호출할 수 있다는 뜻이에요.
    // 'void'는 이 메소드가 반환하는 값이 없다는 뜻이에요.
    // 'String ...n'이 바로 '가변 인자' 선언 부분이에요.
    // 이는 'String 타입의 인자를 0개 이상 받을 수 있다'는 뜻이며,
    // 이 인자들은 메소드 내부에서 'String[] n'이라는 배열처럼 사용될 거예요.
    public void argsTest(String ...n) { // ...: 내부적으로 배열화 작업을 자동으로 해줌
        
        for (int i = 0; i < n.length; i++) { // n.length는 가변 인자로 전달받은 요소들의 개수(배열의 길이)예요.
                                            // 배열의 각 요소를 순서대로 반복합니다.
            System.out.println("n[" + i + "]:" + n[i]); // 배열의 인덱스와 해당 값을 출력합니다.
        }
        System.out.println("======================"); // 구분을 위한 줄을 출력합니다.
    }

    // 2. main 메소드: 프로그램의 시작점
    public static void main(String[] args) {
        
        // VariableEx 클래스의 객체(인스턴스) 생성
        // argsTest 메소드가 'static'이 아니므로, 이 클래스의 객체를 먼저 만들어야 메소드를 호출할 수 있어요.
        VariableEx ve = new VariableEx();

        // 3. argsTest 메소드 호출 예시
        // 3-1. 인자 2개 전달
        ve.argsTest("java", "DataBase"); // "java"와 "DataBase" 두 개의 문자열을 인자로 넘겨줍니다.
                                        // argsTest 메소드 안에서는 이 두 문자열이 String[] n 배열의 요소로 저장됩니다.
                                        // n[0]은 "java", n[1]은 "DataBase"가 됩니다.

        // 3-2. 인자 4개 전달
        ve.argsTest("100", "200", "300", "400"); // 4개의 문자열을 인자로 넘겨줍니다.
                                                // argsTest 메소드 안에서는 이 4개의 문자열이 String[] n 배열의 요소로 저장됩니다.
                                                // n
