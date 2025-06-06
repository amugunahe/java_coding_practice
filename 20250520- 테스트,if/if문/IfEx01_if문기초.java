package com.condition;

/* 제어문의 종류
 * 1. 분기문(비교조건문) -> if, switch문
    -주어진 조건의 결과에 따라 실행 문장을 다르게 하여 전혀 다른 
    결과를 얻기 위해 사용하는 제어문
    
   2. 반복문: 특정한 문장을 정해진 규칙에 따라 반복 처리하기위한 제어문
        	for, while, do~while
   
   3. break문: 반복문 내에서 쓰이며 반복문을 빠져나갈때 사용하는 제어문
   
   4. continue문: 현재 수행되는 반복 회차를 포기하고 다음 회차로 이동하는 것을 의미함 
 */

public class IfEx01 {

	public static void main(String[] args) {
		
		int a = 10;
		
		if(a == 10) {  //조건이 참일 때 => 조건이 맞는 문장이 하나 이상일 경우는 {}을 정해주어야함 
			System.out.println("a는 10값과 같습니다.");
		}else { //조건 거짓일 때 
			System.out.println("a는 10값과 같지 않습니다.");
		}
	}
}
