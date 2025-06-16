package com.functionex;
/* 한달의 할일을 표현하는 MonthSchedule 
  MonthSchedule 클래스에는 Day 객체 배열과 적절한 필드, 메소드를 작성하고 메뉴를 실행하여 구현하시오 
 
 생성자, input(), view(), finish(), run() 메소드를 만들고 
 main()에서 run()메소드를 호출하여 실행하시오. 
 
 
 이번달 스케쥴 관리 프로그램 
 할일(입력:1, 보기:2. 종료:3) => 1
 날짜(1 ~ 3): 1
 할일(빈칸없이 입력): 자바공부
 
 할일(입력:1, 보기:2, 종료:3) => 2
 날짜(1 ~ 30): 1
 1일의 할일은 자바공부 입니다
 
 할일(입력:1 ,보기:2, 종료:3) => 3
 프로그램을 종료합니다. 
 */

import java.util.*;

public class MonthSchedule {
	
	private int nDays;
	private Day[] days;
	private Scanner sc;
	
	public MonthSchedule(int nDays) {
		this.nDays = nDays;
		this.days = new Day[nDays];
		for(int i = 0; i < days.length; i++) {
			days[i] = new Day();
		}
		sc = new Scanner(System.in); 
	}
		
	public void input() {
	System.out.print("날짜(1 ~ 30): ");
	int day = sc.nextInt();
	
	System.out.print("할일(빈칸없이 입력): ");
	String work = sc.next();
	day--;
	
	if(day < 0 || day > nDays) {
		System.out.println("잘못 입력 하셨습니다/");
	return;
	}
	days[day].set(work);
	}

	
	public void view() {
		System.out.print("날짜(1 ~ 30): ");
		int day = sc.nextInt();
		day--;
		
		if(day < 0 || day > nDays) {
			System.out.println("잘못 입력 하셨습니다/");
		return;
		}
		System.out.println((day + 1) + "일의 할일은: ");
		days[day].show();
		
	}
	
	public void finish() {
	System.out.println("프로그램을 종료합니다.");	
	System.exit(0);
	}
	
	public void run() {
	System.out.println("이번달 스케줄 관리 프로그램");
	
	while(true) {
	System.out.print("할일(입력:1, 보기:2, 종료:3) >> ");
		int menu = sc.nextInt();
		switch(menu) {
		case 1: input(); 
		break;
		case 2: view();
		break;
		case 3: finish();
		break;
		default: 
			System.out.println("메뉴에 없습니다.");
		}
		System.out.println();
		}
	}
	public static void main(String[] args) {
		MonthSchedule me = new MonthSchedule(30);
		me.run();
 
	}
}
