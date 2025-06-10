package com.objectex;

public class TvExam02 {

	public static void main(String[] args) {
		
		/* Tv t1; 
        t1 = new TV();
		 */	
		Tv t1 = new Tv(); // 위의 문자 한문장으로 가능
		Tv t2 = new Tv();
		System.out.println("t1의 채널 값은 " + t1.getChannel() + "입니다.");
		System.out.println("t2의 채널 값은 " + t2.getChannel() + "입니다.");
		
		t2 = t1;  // t1이 저장하고 있는 주소값을 t2에 저장함
		
		// tv 채널 세팅
		t1.setChannel(7);
		System.out.println("t1의 채널 값을 " + t1.getChannel() + "로 변경되었습니다.");
		
		System.out.println("t1의 채널 값은 " + t1.getChannel() + "입니다.");
		System.out.println("t2의 채널 값은 " + t2.getChannel() + "입니다.");
	}

}
