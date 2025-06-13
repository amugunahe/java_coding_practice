package com.sungex;

/* Sung-> 인원수 입력받는 기능
    	  성적을 처리하는 기능 
    	  출력을 처리하는 기능 
    	  
    	  속성: 인원수, Record 배열(객체 배열)
    	  기능: 인원수 입력받는 기능
    	  	   이름, 과목점수, 데이터입력
    	  	   성적을 처리하는 기능 
    	  	   결과 출력을 처리하는 기능  
 */
import java.util.*;

public class Sung {
	
	// 주요 변수 선언 (속성 구성) 
	int inwon;  // 인원수
	Record[] re;  // Record 배열 (객체 배열) 
	
	
	/* 기능(메소드)
	  1. 인원수 입력
	 */
	public void set() {
		Scanner sc = new Scanner(System.in);
	
	do {
		System.out.print("인원수 입력(1 ~ 100): ");
		inwon = sc.nextInt();
	} while(inwon < 1 || inwon > 100);
	
	/* Record 클래스의 배열 변수를 inwon 만큼 생성한 것이다. 
	   그러나, 인스턴스를 생성한 것은 아니다. 
	*/
	re = new Record[inwon];
	
	
	}

	// 2. 데이터 입력 및 성적 계산 기능 
	public void input() {
		
		Scanner sc = new Scanner(System.in);
		
		String[] title = {"국어점수: ", "영어점수: ", "수학점수: "};
		
		for (int i = 0; i < inwon; i++) {
			// 인스턴스 생성
			re[i] = new Record();
			
			System.out.print(i + 1 + "번째 이름: ");
			re[i].name = sc.next();
			
		for (int j = 0; j < title.length; j++) {
			// 안내 메시지 출력
			System.out.print(title[j]);
			
			// 입력받은 점수를 배열에 저장
			re[i].score[j] = sc.nextInt();
			
			// 점수를 입력받아 총점 구함
			re[i].sum += re[i].score[j];
		}
		// 평균 구함
		re[i].avg = re[i].sum / 3.0;
		
	}
}
	
	// 3. 석차 계산 기능 
	public void ranking() {
		int i, j;
		
		// 모든 학생의 석차를 1로 초기화 
	for (i = 0; i < inwon; i++)
		re[i].rank = 1;
	
	// 석차 계산
	for (i = 0; i < inwon - 1; i++) {
		for (j = i + 1; j < inwon; j++) {
			if (re[i].avg > re[j].avg) {
				re[j].rank++;
			} else if (re[i].avg < re[j].avg) {
				re[i].rank++;			
			}
		}
	}
		
}
	
	// 4. 결과 출력(석차를 포함한 결과) 
	public void print() {
	ranking();	
	}
	
}
