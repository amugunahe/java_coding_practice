package com.functionex;

/* Grade 클래스를 작성하시오.
   세과목의 점수를 입력받아 Grade의 객체를 생성하고
   성적 평균을 출력하는 실행 메소드는 다음과 같다 
  
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
	System.out.print("국어, 영어, 수학 순으로 3개의 점수 입력: ");
  	int kor = sc.nextInt();
 	int eng = sc.nextInt();
  	int mat = sc.nextInt();
  
  Grade me = new Grade(kor, eng, mat);
 	System.out.println("평균은 " + me.average());
 }
 
 국어, 영어, 수학 순으로 3개의 점수 입력: 90, 85, 
 */

import java.util.*;

public class Grade {
	int kor;
	int eng;
	int mat;
	
	public Grade(int kor, int eng, int mat) {
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
int average() {
	return (kor + eng + mat) / 3;
}

public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("국어, 영어, 수학 순으로 3개의 점수 입력: ");
	  	int kor = sc.nextInt();
	 	int eng = sc.nextInt();
	  	int mat = sc.nextInt();
	  
	  Grade me = new Grade(kor, eng, mat);
	 	System.out.println("평균은 " + me.average());
	 }
}


/* import java.util.*; 

class Grade {
	int kor;
	int eng;
	int mat;
	double avg;
	
	Grade(int kor, int eng, int mat){
		this.kor = kor; 
		this.eng = eng;
		this.mat = mat;
	}
	
	double average() {
		 avg = (kor + eng + mat) / 3.0 ;
		 return avg;
		}
}

public class funcExam04 {

	 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 System.out.print("국어, 영어, 수학 순으로 3개의 점수 입력: ");
		 int kor = sc.nextInt();
		 int eng = sc.nextInt();
		 int mat = sc.nextInt();
		
		 Grade me = new Grade(kor, eng, mat);
		 System.out.println("평균은 " + me.average());
		 }
	}
*/ 