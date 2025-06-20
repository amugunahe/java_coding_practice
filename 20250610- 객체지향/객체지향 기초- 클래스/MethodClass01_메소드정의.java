package com.objectex; // 이 코드가 속한 패키지(폴더) 이름이에요.

/* 메소드
  - 특정 작업을 수행하는 일련의 문장을 하나로 묶은 것을 의미함
  기본적으로 수학의 함수와 유사하다.
 
  Math.sqrt() -> 제곱근 -> 4.0을 입력하면 결과 -> 2.0
 
  메소드를 사용하는 이유
  1. 높은 재사용성
  2. 중복 코드를 제거
  3. 프로그램을 구조화
 */

import java.util.Scanner; // 사용자로부터 키보드 입력을 받기 위해 Scanner 클래스를 가져옵니다.

public class MethodClass01 { // MethodClass01 이라는 이름의 클래스를 정의합니다.

    // 1. static Scanner sc = new Scanner(System.in);
    // 'static' 키워드는 이 변수가 클래스에 속하며, 객체를 만들지 않고도 바로 사용할 수 있다는 뜻이에요.
    // 'Scanner'는 사용자 입력을 읽어들이는 도구예요. `sc`라는 이름으로 만들어서 프로그램 전체에서 사용할 수 있게 했어요.
    static Scanner sc = new Scanner(System.in);

    // 2. 배열을 출력하는 메소드: printArr
    // 'static' 키워드가 붙어있어 이 메소드도 객체 생성 없이 바로 호출할 수 있어요.
    // 'void'는 이 메소드가 어떤 값도 반환하지 않는다는 뜻이에요.
    // 'int[] numArr'는 이 메소드가 '정수형 배열' 하나를 입력(매개변수)으로 받는다는 뜻이에요.
    static void printArr(int[] numArr) {
        for (int i = 0; i < 10; i++) { // 배열의 첫 번째 요소부터 열 번째 요소까지 (총 10개) 반복합니다.
            System.out.print(numArr[i] + " "); // 각 요소를 출력하고 한 칸 띄웁니다.
        }
        System.out.println(); // 10개의 요소를 다 출력한 후 줄바꿈을 합니다.
    }

    // 3. 배열을 초기화하는 메소드: initArr
    // 이 메소드도 'static'이고, 'void' (반환값 없음)이며, '정수형 배열'을 매개변수로 받아요.
    static void initArr(int[] numArr) {

        for (int i = 0; i < 10; i++) { // 배열의 첫 번째 요소부터 열 번째 요소까지 반복합니다.
            // Math.random()은 0.0 이상 1.0 미만의 랜덤한 실수를 반환해요.
            // 여기에 10을 곱하면 0.0 이상 10.0 미만의 실수가 되죠.
            // (int)를 붙여 정수로 강제 형변환하면 0부터 9까지의 정수가 됩니다.
            numArr[i] = (int)(Math.random() * 10); // 배열의 각 요소에 0~9 사이의 랜덤한 정수를 채워 넣습니다.
        }
    }

    // 4. 메뉴를 보여주고 사용자 선택을 받는 메소드: showMenu
    // 이 메소드는 'int' 값을 반환해요. 즉, 사용자에게 받은 정수(메뉴 선택)를 돌려줍니다.
    static int showMenu() {
        System.out.print("메뉴선택: "); // "메뉴선택: "이라는 메시지를 출력합니다.
        int n = sc.nextInt(); // 사용자가 키보드로 입력한 정수를 읽어서 `n` 변수에 저장합니다.
        return n; // 저장된 `n` 값을 메소드를 호출한 곳으로 돌려줍니다.
    }

    // 5. 비어있는 메소드들 (구현 예정)
    // 이 메소드들은 현재 아무런 작업도 하지 않지만,
    // 나중에 프로그램 기능이 추가될 때 여기에 코드를 채워 넣을 수 있어요.
    // 이렇게 미리 메소드를 정의해두면 프로그램의 전체적인 구조를 미리 설계할 수 있죠.
    static void inputRecord() {} // 레코드를 입력하는 기능 (나중에 구현)
    static void updateRecord() {} // 레코드를 수정하는 기능 (나중에 구현)
    static void deleteRecord() {} // 레코드를 삭제하는 기능 (나중에 구현)
    static void listAllRecord() {} // 모든 레코드를 목록으로 보여주는 기능 (나중에 구현)
    static void searchRecord() {} // 레코드를 검색하는 기능 (나중에 구현)
    static void printRecord() {} // 레코드를 출력하는 기능 (나중에 구현)

    public static void main(String[] args) { // 프로그램의 시작점인 main 메소드입니다.

        int [] arr = new int[10]; // 10개의 정수를 저장할 수 있는 'arr'이라는 이름의 배열을 만듭니다.

        // 메소드 호출 예시
        // 배열을 초기화하는 메소드 호출
        // 참고: 원래 `initArr(arr);`인데 오타가 있네요. `intiArr(arr);`로 되어있어요.
        // 이대로 컴파일하면 `Cannot find symbol` 오류가 납니다. `initArr(arr);`로 수정해야 해요.
        // 저는 `initArr(arr);`라고 가정하고 설명할게요.
        initArr(arr); // `arr` 배열에 0~9 사이의 랜덤한 숫자 10개를 채워 넣습니다.

        // 배열을 출력하는 메소드 호출
        printArr(arr); // `arr` 배열의 내용을 화면에 출력합니다.
        printArr(arr); // 같은 배열을 또 출력합니다. (재사용성)
        printArr(arr); // 또 출력합니다. (재사용성)

        // switch 문을 이용한 메뉴 처리
        switch (showMenu()){ // showMenu() 메소드를 호출하여 사용자로부터 메뉴 선택을 받고, 그 반환값을 switch 문으로 처리합니다.
        case 1: inputRecord(); // 만약 showMenu()가 1을 반환하면 inputRecord() 메소드를 호출합니다.
                break; // 해당 case 실행 후 switch 문을 빠져나옵니다.
        case 2: updateRecord(); // 2를 반환하면 updateRecord() 호출
                break;
        case 3: deleteRecord(); // 3을 반환하면 deleteRecord() 호출
                break;
        case 4: listAllRecord(); // 4를 반환하면 listAllRecord() 호출
                break;
        case 5: searchRecord(); // 5를 반환하면 searchRecord() 호출
                break;
        case 6: printRecord(); // 6을 반환하면 printRecord() 호출
                break;
        default: System.out.println("잘못된 메뉴 선택입니다."); // 1~6이 아닌 다른 값을 반환하면 이 메시지를 출력합니다.
            }
        }
    }
