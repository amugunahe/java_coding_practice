package com.listex; // 이 파일이 속한 패키지 이름

import java.util.LinkedList; // 큐 만들 때 쓰는 놈
import java.util.ListIterator; // 리스트 돌릴 때 쓰는 놈
import java.util.Queue; // 큐 기능 쓸 때 쓰는 놈
import java.util.Scanner; // 사용자 입력 받을 때 쓰는 놈

/*
  핵심 요약:
  - 이 코드는 니가 친 명령어를 큐에 저장해서 **최근 기록을 관리하는 예제**다.
  - **큐는 먼저 들어간 놈이 먼저 나오는 FIFO 방식**이다. (First-In, First-Out)
  - 명령어 'q' 치면 프로그램 꺼지고, 'help' 치면 기능 알려주고, 'history' 치면 최근 명령어 보여줌.
  - **큐에 정해진 개수(MAX_SIZE)보다 많이 쌓이면 제일 오래된 건 자동으로 지워진다.**
 
  QueueEx01 클래스: 명령어 히스토리 관리하는 거
  - 니가 친 명령어를 큐(Queue)에 때려 박아서 최근 기록 보는 예제임.
  - **중요:** Queue는 FIFO (First-In, First-Out) 구조로, 먼저 들어간 놈이 먼저 나오는 거다.
 
  핵심 요소:
  - `q`: 명령어들 저장하는 큐 (**중요:** LinkedList로 만듦. 큐 기능을 쉽게 쓸 수 있음)
  - `MAX_SIZE`: 큐에 최대 몇 개까지 저장할지 정하는 거 (여기선 5개)
 
  주요 기능:
  - `help`: 도움말 보여줌
  - `q` (또는 `Q`): 프로그램 꺼버림
  - `history`: 최근에 친 명령어 MAX_SIZE개 보여줌
  - 그 외 입력: 그냥 명령어 보여주고 히스토리에 박아둠
 */

public class QueueEx01 {

	static Queue q = new LinkedList(); // 명령어 때려 박는 큐
	static final int MAX_SIZE = 5; // **중요:** 최대 5개까지 저장함
	
	public static void main(String[] args) {

		System.out.println("help 치면 무슨 기능이 있는지 알려줍니다.");
		
		// **중요:** 무한 루프: 'q' 입력 시 종료됨.
		while(true) { 
			
			System.out.print(">>"); // 입력 대기
			try {
				Scanner sc = new Scanner(System.in); // 입력 받는 스캐너
				String input = sc.nextLine().trim(); // 한 줄 읽고 앞뒤 공백 제거
				
				if("".equals(input)) { // **중요:** 입력 없으면 그냥 다음 루프로 넘어감
					continue;
				}
		
				if(input.equalsIgnoreCase("q")) { // **중요:** 'q' 치면 프로그램 종료.
					System.out.println("프로그램 끝낸다.");
					System.exit(0); 
				} 
				else if(input.equalsIgnoreCase("help")) { // 'help' 치면 도움말 보여줌
					System.out.println("help - 도움말을 보여줍니다.");
					System.out.println("q 또는 Q - 프로그램을 종료합니다");
					System.out.println("history - 최근에 친 명령어 " + MAX_SIZE + " 개 보여줍니다.");
				} 
				else if(input.equalsIgnoreCase("history")) { // 'history' 치면 기록 보여줌
					save(input); // 'history' 명령어 이것도 기록에 남겨야지
						
					int i = 0;
					// **중요:** LinkedList로 캐스팅해야 리스트 순회(ListIterator) 쓸 수 있음.
					// Queue 인터페이스 자체는 listIterator를 제공하지 않기 때문.
					LinkedList temp = (LinkedList)q; 
					ListIterator it = temp.listIterator(); 
					
					while(it.hasNext()) { // 다음 요소 있을 때까지 반복
						System.out.println(++i + "." + it.next()); // 번호 붙여서 명령어 보여줌
					}
				} 
				else { // 그 외 나머지 입력들
					save(input); // 명령어 큐에 저장함
					System.out.println(input); // 명령어 그대로 보여줌
				}
			} catch(Exception e) { // 혹시 에러 나면
				System.out.println("입력 오류다. 다시 해봐라!!");
				e.printStackTrace(); // 에러 내용 자세히 보여줌 (개발용)
			}
		} 
	} 
	
	// 명령어 큐에 저장하는 기능
	public static void save(String input) {
		if(!"".equals(input)) { // 입력이 비어있지 않으면 큐에 박음
			q.offer(input); // 큐의 맨 끝에 데이터 추가
		}
		// **중요:** 큐 크기가 정한 MAX_SIZE를 넘어가면 제일 오래된 거 삭제 (FIFO 유지)
		if(q.size() > MAX_SIZE) { 
			q.remove(); // 큐의 맨 앞에서 데이터 삭제 (가장 오래된 것)
		}
	}
	
}
