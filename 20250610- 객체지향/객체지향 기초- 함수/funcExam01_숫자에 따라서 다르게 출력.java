package com.functionex; // 이 코드가 속한 패키지(폴더) 이름이에요.

/* 문] 1번을 누르면 두개의 숫자를 입력받아 그 중 큰 수를 출력하는 기능을 구현하고,
        aaa
    2번을 누르면 두 수를 입력받아 두 수 사이에 합계를 구하여 출력하는 기능을 구현하고,
        bbb
    3번을 누르면 세개의 수를 입력받아 큰 순서대로 나열하는 프로그램을 구현하시오.
        ccc
    4번을 누르면 종료
    finish
*/

import java.io.*; // 입출력(Input/Output) 관련 기능을 사용하기 위해 필요합니다. (BufferedReader 등)

public class funcExam01 { // funcExam01 이라는 이름의 클래스를 정의합니다.

    // 1. aaa() 메소드: 두 수 중 큰 수를 반환
    // 'public static': 어디서든 접근 가능하며, 객체 생성 없이 바로 호출할 수 있습니다.
    // 'int': 이 메소드가 int형 값을 반환한다는 의미입니다.
    // 'throws IOException': 이 메소드 안에서 입출력(키보드 입력 등) 작업 중 에러가 발생할 수 있으니,
    //                       이 메소드를 호출한 곳에서 그 에러를 처리해야 한다고 알려주는 것입니다.
    public static int aaa() throws IOException {
        
        // 사용자 입력을 효율적으로 읽어들이기 위한 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("첫번째 수: "); // 사용자에게 첫 번째 수를 입력하라는 메시지 출력
        // br.readLine(): 키보드로 입력된 한 줄을 읽어옵니다. (문자열 형태)
        // Integer.parseInt(): 읽어온 문자열을 정수(int)로 변환합니다.
        int a = Integer.parseInt(br.readLine());
        
        System.out.print("두번째 수: "); // 사용자에게 두 번째 수를 입력하라는 메시지 출력
        int b = Integer.parseInt(br.readLine());
        
        if (a > b) { // 만약 a가 b보다 크면
            return a; // a를 반환합니다.
        }
        return b; // 그렇지 않으면 (b가 a보다 크거나 같으면) b를 반환합니다.
    }
    
    // 2. bbb() 메소드: 두 수 사이의 합계 계산 및 출력
    // 'void': 이 메소드는 반환하는 값이 없습니다. (대신 직접 화면에 출력합니다.)
    public static void bbb() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("첫번째 수: ");
        int a = Integer.parseInt(br.readLine());
        
        System.out.print("두번째 수: ");
        int b = Integer.parseInt(br.readLine());
        
        int sum = 0; // 합계를 저장할 변수를 0으로 초기화합니다.
        
        // 두 수의 크기를 비교하여 `a`가 항상 작은 수가 되도록 교환합니다.
        // 이 부분은 비트 연산자 `^` (XOR)를 이용한 독특한 값 교환 방식입니다.
        // 예를 들어 a=10, b=5 일 때,
        // a = a ^ b; (10 ^ 5 = 15)  -> a는 15
        // b = a ^ b; (15 ^ 5 = 10)  -> b는 10
        // a = a ^ b; (15 ^ 10 = 5)  -> a는 5
        // 결과적으로 a와 b의 값이 서로 바뀌게 됩니다. (a=5, b=10)
        if (a > b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        
        // `a`부터 `b-1`까지의 합계를 계산합니다.
        // 예: a=5, b=10이면 5+6+7+8+9
        for (int i = a; i < b; i++) {
            sum += i; // sum = sum + i;
        }
        System.out.println(a + " ~ " + b + "사이의 합계: " + sum); // 결과 출력
    }
    
    // 3. ccc() 메소드: 세 수를 큰 순서대로 정렬하여 문자열로 반환
    // 'String': 이 메소드가 문자열(String) 값을 반환합니다.
    // '(int x, int y, int z)': int형 변수 x, y, z 세 개를 매개변수로 받습니다.
    public static String ccc(int x, int y, int z) {
    
        // 가장 큰 수를 x 위치에 놓기
        // y가 x보다 크거나 같고, y가 z보다 크거나 같으면 (y가 가장 크면)
        if (y >= x && y >= z) {
            int imsi = x; // 임시 변수에 x 값 저장
            x = y;        // x에 y 값 복사
            y = imsi;     // y에 임시 변수에 저장된 원래 x 값 복사 (x와 y 교환)
            
        } else if(z >= x && z >= y) { // 그렇지 않고 z가 x보다 크거나 같고, z가 y보다 크거나 같으면 (z가 가장 크면)
            int imsi = x; // 임시 변수에 x 값 저장
            x = z;        // x에 z 값 복사
            z = imsi;     // z에 임시 변수에 저장된 원래 x 값 복사 (x와 z 교환)
        }
        // 이 시점에서 x는 셋 중 가장 큰 값입니다.

        // 남은 y와 z를 비교하여 y가 더 큰 수가 되도록 정렬합니다.
        // z가 y보다 크거나 같으면 (y와 z를 교환)
        if (z >= y) {
            int imsi = y;
            y = z;
            z = imsi;
        }
        // 이 시점에서 x >= y >= z 순서로 정렬이 완료됩니다.
        
        // 정렬된 수를 문자열 형태로 만듭니다. (예: "100>=80>=50")
        String abc = x + ">=" + y + ">=" + z;
        
        return abc; // 문자열 반환
    }
    
    // 4. finish() 메소드: 프로그램 종료
    public static void finish() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0); // 프로그램을 강제로 종료하는 명령입니다. 0은 정상 종료를 의미해요.
    }
    
    // 5. main 메소드: 프로그램의 실행 흐름을 제어
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int x = 0; // 사용자 메뉴 선택을 저장할 변수
        
        while (true) { // 무한 반복문입니다. 사용자가 '4번 종료'를 선택하기 전까지 계속 메뉴를 보여줍니다.
            System.out.print("1: 최대수 2: 사이 합 3: 수 나열 4: 종료 =>"); // 메뉴 옵션 출력
            x = Integer.parseInt(br.readLine()); // 사용자로부터 메뉴 선택 번호를 입력받아 정수로 변환
            
            switch (x) { // 입력받은 x 값에 따라 다른 작업을 수행하는 switch 문입니다.
            case 1:
                // aaa() 메소드를 호출하고 반환된 최댓값을 출력합니다.
                System.out.println("둘중 최대수는 " + aaa() + "입니다.");
                break; // 현재 switch 문을 빠져나갑니다.
            case 2:
                bbb(); // bbb() 메소드를 호출합니다. (bbb 메소드 안에서 합계를 계산하고 출력까지 합니다.)
                break;
            case 3:
                // 사용자에게 세 개의 수를 입력받습니다.
                System.out.print("첫번째 수: "); // `print`는 줄바꿈을 하지 않아요.
                int firstSu = Integer.parseInt(br.readLine());
                    
                System.out.print("두번째 수: ");
                int secondSu = Integer.parseInt(br.readLine());
                    
                System.out.print("세번째 수: ");
                int thirdSu = Integer.parseInt(br.readLine());
                    
                // ccc() 메소드를 호출하여 세 수를 정렬한 문자열을 반환받고 저장합니다.
                String str = ccc(firstSu, secondSu, thirdSu);
                System.out.println("큰 순으로 나열은 " + str); // 정렬된 결과 출력
                
                System.out.println(); // 추가적인 줄바꿈
                break;
                
            case 4:
                finish(); // finish() 메소드를 호출하여 프로그램을 종료합니다.
                          // System.exit(0) 때문에 이 이후의 코드는 실행되지 않습니다.
                break;
            default: // 1, 2, 3, 4가 아닌 다른 숫자를 입력했을 경우
                System.out.println("잘못 입력하셨습니다."); // 오류 메시지 출력
                break;
            }
            System.out.println(); // 각 메뉴 실행 후 한 칸 띄우기
        }
        // System.out.println("오늘도 열공하세요."); // finish() 메소드 때문에 이 줄은 실행되지 않습니다.
    }
}
