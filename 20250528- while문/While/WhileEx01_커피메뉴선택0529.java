package dowhileex;

import java.util.*;

public class WhileEx01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int menu = 0;
		int num = 0;
		
		while(true) {
			
			
			System.out.println("1: 아메리카노");
			System.out.println("2: 카페라떼");
			System.out.println("3: 믹스 커피");
			
			System.out.print("원하는 커피를 선택하세요.(종료:0)=>");
			menu = sc.nextInt();
			if(menu==0) {
				System.out.println("프로그램을 종료합니다.");
			return;
			}else if(!(menu>=1 && menu<=3)) {
				System.out.println("메뉴를 잘못 선택하셨습니다.");
				continue;
			}
			System.out.println("선택하신 메뉴는 " + menu + "번 입니다.");
		}
	}

}
