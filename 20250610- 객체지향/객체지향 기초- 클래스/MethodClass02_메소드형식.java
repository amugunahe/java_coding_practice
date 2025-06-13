package com.objectex;

/* 메소드 형식
   접근 제한자  반환타입(형) 메소드 이름(자료형 변수명, 자료형 변수명)<- 선언부
   { <- 구현부
   메소드 호출시 수행되는 코드 
   }  
 */

public class MethodClass02 {

	// 메소드 정의 
	public int add(int x, int y) {  // 선언부
	
		int result;
		// result = x + y;                
	
		return result = x + y;	    // 구현부 
	}
	
	public String name(String na) {
		return ""; 	
	}
		
	int i;
	/* void: 아무것도 없음을 의미함 
	         반환값이 없는 경우 반환 타입으로 void를 적어야함
	*/

	void print99dan() {
	    for (int i = 1; i <= 9; i++) {
	        for (int j = 2; j <= 9; j++) {
	            System.out.print(j + "*" + i + "=" + (j * i) + " ");
	        }
	        System.out.println();
	    }
	    return;
	}

	/* return -값을 돌려주다.
	   - 작업을 수행한 결과인 반환값을 호출한 메소드로 전달하게 되는데
	   	 이 값의 타입은 반환 타입과 일치하거나 적어도 자동 형변환이 
	   	 가능한 것이어야함
	 */

	/* 지역변수 (Local variable) 
	   메소드 내에 선언된 변수들은 그 메소드 내에서만 사용할 수 있으므로 
	   서로 다른 메소드라면 같은 이름을 변수를 선언해도 된다.   
	 */
	
	/* 인자 (argument)와 매개변수 (parameter)
	  	- 메소드를 호출할 때 괄호()안에 지정해준 값들을 -> 인자 또는 인수라고함
	   	  인자의 개수와 순서는 호출된 메소드에 선언된 매개변수와 일치해야함
	   	  
	   	add(10, 2): 인자 -> int x, int y: 매개변수 
	 */
	
	public static void main(String[] args) {
		
		MethodClass02 m = new MethodClass02();
		// 메소드 호출
		// 메소드 이름(값1, 값2...);   메소드를 호출하는 방법
		m.print99dan();
		System.out.println(m.add(2, 3));
	}
}