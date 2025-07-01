package com.vscore;

import java.util.Scanner; // 사용자 입력을 받기 위해 Scanner를 임포트한다.

public class ScoreMain {

    public static void main(String[] args) { // throws Exception은 굳이 필요 없다.
        // Scanner 객체 생성: 사용자 입력을 받기 위해 사용한다.
        Scanner sc = new Scanner(System.in); // 메인에서 Scanner를 생성해서 ScoreImpl로 넘겨줄 수도 있지만,
                                             // 니가 ScoreImpl에 직접 Scanner를 만들었으니 여기선 메뉴 선택에만 쓴다.
        char ch; // 메뉴 선택을 위한 변수

        // Score 인터페이스 타입으로 ScoreImpl 객체를 생성한다.
        // 니가 ScoreImpl이라고 했으니 ScoreImp가 아니라 ScoreImpl이다, 이 새끼야!
        Score score = new ScoreImpl();

        // 테스트를 위해 몇몇 데이터를 미리 추가해두자.
        // ScoreImpl 내부에 Scanner가 있어서 직접 호출할 수는 없고,
        // insert() 메소드를 통해 데이터를 추가해야 한다.
        // 아니면 ScoreImpl에 초기 데이터를 넣는 생성자를 만들거나.
        // 여기서는 그냥 사용자가 직접 추가하도록 둔다.
        // 만약 초기 데이터를 넣고 싶다면, ScoreImpl에서 Vector를 초기화할 때 직접 넣거나,
        // ScoreImpl에 public 메소드를 추가해서 데이터를 넣는 식으로 해야 한다.

        while (true) { // 무한 루프: 사용자가 '7. 종료'를 선택할 때까지 계속 돈다.
            do {
                System.out.println("--------------------------------------------------");
                System.out.println("1. 추가 2. 수정 3. 삭제 4. 전체 출력 5. 학번검색 6. 이름검색 7. 종료");
                System.out.print("메뉴 선택 (1-7): ");
                // sc.next().charAt(0)으로 첫 문자만 읽고, 나머지 버퍼는 자동으로 처리된다.
                // System.in.read() 같은 구닥다리 쓰지 마라, 이 새끼야!
                ch = sc.next().charAt(0);
            } while (ch < '1' || ch > '7'); // 1부터 7 사이의 숫자가 아니면 다시 입력받는다.

            // switch 문: ch 값에 따라 해당 기능을 실행한다.
            switch (ch) {
                case '1': // 1. 추가
                    score.insert();
                    break;
                case '2': // 2. 수정
                    score.update();
                    break;
                case '3': // 3. 삭제
                    score.delete();
                    break;
                case '4': // 4. 전체 출력
                    score.listAll();
                    break;
                case '5': // 5. 학번 검색
                    score.searchHak();
                    break;
                case '6': // 6. 이름 검색
                    score.searchName();
                    break;
                case '7': // 7. 종료
                    System.out.println("\n프로그램을 종료합니다.");
                    sc.close(); // 메인에서 생성한 Scanner 자원 해제
                    // ScoreImpl 내부의 Scanner는 별도로 닫아줘야 하지만,
                    // 프로그램 종료 시 JVM이 알아서 자원 해제해주니 큰 문제는 없다.
                    // 하지만 좋은 습관은 아니다. 나중에 더 배우면 알게 될 거다.
                    System.exit(0); // 프로그램을 완전히 종료한다.
                default: // 혹시 모를 예외 처리
                    System.out.println("잘못된 메뉴 선택입니다. 다시 입력하세요.");
            }
        }
    }
}