package com.arrayExam;

/* 배열 복사
 배열은 한번 생성된 후 배열의 크기는 변경할 수 없음
 크기를 변경하고자 할때는 같은 자료형의 배열을 원하는 크기로 다시 생성한다.
 기존의 배열을 복사하면 복사가 완료된다. 
 
 System.arraycopy()메소드를 이용
 
 public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length){}

src -> 원본 배열
srcPos -> 원본 배열의 복사 위치
dest -> 복사할 배열
destpos -> 복사 시작위치
length -> 복사되는 배열의 인덱스 수
 */

public class ArrayCopyEx01 {

	public static void main(String[] args) {
		
		String[] src = {"Java", "DataBase", "Jsp", "Xml"}; // 원본 배열
		String[] dest = new String[6]; // 복사할 배열 
		dest[0] = "Spring";
		dest[1] = "Python";
		
		System.arraycopy(src, 0, dest, 2, 4);
		
		for (String temp : dest) {
			System.out.println("dest value:" + temp);
		}
		
	}

}
