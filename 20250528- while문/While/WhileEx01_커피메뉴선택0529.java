package dowhileex;

import java.util.*; // Scanner 쓰려면 이거 필수 임포트

public class WhileEx01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // 사용자 입력받을 준비 완료!
		
		int menu = 0; // 사용자가 선택할 메뉴 번호
		int num = 0;  // (이 변수는 현재 코드에서 사용되지 않음)
		
		// 핵심 1: `while(true)`는 무한 반복을 의미한다.
		// 이 반복문은 명시적인 종료 조건(`return` 또는 `break`)을 만나기 전까지 계속 실행된다.
		while (true) { 
			// 메뉴판 출력
			System.out.println("1: 아메리카노");
			System.out.println("2: 카페라떼");
			System.out.println("3: 믹스 커피");
			
			System.out.print("원하는 커피를 선택하세요.(종료:0)=>"); // 입력 안내 메시지
			menu = sc.nextInt(); // 사용자로부터 메뉴 번호 입력받기
			
			// 핵심 2: 메뉴 선택에 따른 조건 분기
			if (menu == 0) { // 사용자가 '0'을 입력하면 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				return; // ★ 중요: `main` 메소드를 종료시켜 프로그램 자체를 끝낸다. (System.exit(0)과 유사)
			} else if (!(menu >= 1 && menu <= 3)) { // 1, 2, 3이 아닌 다른 숫자 (잘못된 메뉴)
				// `!(menu >= 1 && menu <= 3)`는 `menu < 1 || menu > 3`과 같은 의미다.
				// 즉, 1보다 작거나 3보다 큰 경우.
				System.out.println("메뉴를 잘못 선택하셨습니다.");
				continue; // ★ 중요: `while`문의 현재 반복을 건너뛰고 다음 반복(메뉴 재출력 및 입력)으로 바로 넘어간다.
			}
			// 여기까지 왔다면 1, 2, 3 중 올바른 메뉴를 선택했다는 의미
			System.out.println("선택하신 메뉴는 " + menu + "번 입니다.");
		}
        // 이 코드에서는 `return` 때문에 여기에 도달할 일이 없지만,
        // 만약 `break`를 사용했다면 여기에 `sc.close()`를 넣어줘야 한다.
	}
}
