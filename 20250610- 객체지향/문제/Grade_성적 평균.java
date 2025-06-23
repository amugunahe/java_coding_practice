package com.functionex; // 'com.functionex'는 이 자바 파일(클래스)이 속한 패키지 이름입니다. 패키지는 관련 클래스들을 묶어서 관리하는 폴더와 같은 역할을 합니다.

import java.util.*; // 'java.util' 패키지 안에 있는 모든 유틸리티 클래스들을 가져와 사용하겠다는 의미입니다. 여기서는 사용자로부터 입력을 받기 위한 'Scanner' 클래스를 사용하기 위해 필요합니다.

/*
  Grade 클래스는 학생의 국어, 영어, 수학 점수를 저장하고 평균을 계산하는 기능을 제공합니다.
 
  이 클래스는 다음 요구사항을 만족하도록 작성되었습니다:
  - 세 과목의 점수(국어, 영어, 수학)를 멤버 변수로 가집니다.
  - 생성자를 통해 객체 생성 시 세 과목 점수를 초기화할 수 있습니다.
  - 'average()' 메서드를 통해 세 과목의 평균 점수를 계산하여 반환합니다.
 
  main 메서드에서는 사용자로부터 점수를 입력받아 Grade 객체를 생성하고 평균을 출력하는 예시를 보여줍니다.
 */

public class Grade { // 'Grade'라는 이름의 공개(public) 클래스를 선언합니다. 클래스는 객체를 만들기 위한 '설계도'와 같습니다.

    // --- 멤버 변수 (인스턴스 변수) ---
    // 이들은 'Grade' 클래스로 만들어지는 각각의 객체가 가질 점수들을 저장하는 공간입니다.
	int kor; // 국어 점수를 저장할 정수형 변수
	int eng; // 영어 점수를 저장할 정수형 변수
	int mat; // 수학 점수를 저장할 정수형 변수

    // --- 생성자(Constructor) ---
    // 'Grade' 객체가 생성될 때 호출되어 멤버 변수들을 초기화하는 특별한 메서드입니다.
	public Grade(int kor, int eng, int mat) { // 'kor', 'eng', 'mat' 세 개의 정수형 매개변수를 받습니다.
		this.kor = kor; // 매개변수로 받은 'kor' 값을 현재 객체의 'kor' 멤버 변수에 저장합니다. ('this.'는 현재 객체를 의미)
		this.eng = eng; // 매개변수로 받은 'eng' 값을 현재 객체의 'eng' 멤버 변수에 저장합니다.
		this.mat = mat; // 매개변수로 받은 'mat' 값을 현재 객체의 'mat' 멤버 변수에 저장합니다.
	}

    // --- 평균 계산 메서드 ---
    // 세 과목의 점수를 이용하여 평균을 계산하고 그 결과를 정수형으로 반환합니다.
    int average() { // 'average'라는 이름의 메서드를 선언합니다. 매개변수는 없습니다.
	    return (kor + eng + mat) / 3; // 'kor', 'eng', 'mat' 멤버 변수의 합을 3으로 나눈 값을 반환합니다. 정수 연산이므로 소수점 이하는 버려집니다.
    }

    // --- 메인 메서드(main method): 프로그램의 시작점 ---
    // 자바 프로그램을 실행하면 이 'main' 메서드부터 코드가 실행되기 시작합니다.
    public static void main(String[] args) { // 'main' 메서드는 항상 'public static void'로 선언됩니다.

		// Scanner 객체를 생성하여 사용자로부터 키보드 입력을 받을 준비를 합니다.
		Scanner sc = new Scanner(System.in);
	    
		// 사용자에게 점수 입력을 안내하는 메시지를 화면에 출력합니다.
		System.out.print("국어, 영어, 수학 순으로 3개의 점수 입력: ");

	 	// 사용자로부터 국어 점수를 정수형으로 입력받아 'kor' 지역 변수에 저장합니다.
	 	int kor = sc.nextInt();
	    
	 	// 사용자로부터 영어 점수를 정수형으로 입력받아 'eng' 지역 변수에 저장합니다.
	 	int eng = sc.nextInt();
	    
	 	// 사용자로부터 수학 점수를 정수형으로 입력받아 'mat' 지역 변수에 저장합니다.
	  	int mat = sc.nextInt();

	    // 'Grade' 클래스의 새로운 객체 'me'를 생성합니다.
	    // 이때 위에서 입력받은 'kor', 'eng', 'mat' 점수들을 생성자에 전달하여 객체를 초기화합니다.
	    // 즉, 'me' 객체는 입력된 점수들을 자신의 멤버 변수에 가지게 됩니다.
	    Grade me = new Grade(kor, eng, mat);

	    // 'me' 객체의 'average()' 메서드를 호출하여 평균 점수를 계산하고, 그 결과를 출력합니다.
	 	System.out.println("평균은 " + me.average());

	    // Scanner 객체를 닫아 자원을 해제합니다. (필수는 아니지만 좋은 습관입니다.)
	    sc.close();
	    
    } // main 메서드 종료
	
} // Grade 클래스 종료


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
