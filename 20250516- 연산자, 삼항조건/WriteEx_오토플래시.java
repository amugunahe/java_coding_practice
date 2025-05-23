package ioex;

public class WriteEx {

	public static void main(String[] args) {
		/* write() 메소드: 화면 출력시 버퍼에 저장됨 
		 * System.out.flush(); 메소드 실행-> 버퍼에 저장되어 있는 내용을 비워라 
		 */
		System.out.write(65);
		System.out.flush();  //
		System.out.println();
		byte[] by = {'J','A','V','A'};
		System.out.write(by,0, 4); 
		//바이트 배열의 사용한 경우는 autoflush 기능이 내장되어있다 
	
	}

}
