package dowhileex;

/*
 * 문]
 * 국어, 영어, 수학 정수를 입력받아 총점과 평균을 구하고.
 * 학점을 판정하는 프로그램을 구현하시오.
 * 단, do~while문 사용
 * 점수의 범위는 100점을 벗어나지 못함
 */
import java.util.*;

public class DoWhileEx07 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int kor, eng, mat, sum = 0;
		char c, hak;
		double avg = 0;

		do {
			System.out.print("국어 점수: ");
			kor = sc.nextInt();
			if (kor > 100)
			System.out.println("다시 입력하세요.");
		} while (kor < 0 || kor > 100);

		do {
			System.out.print("영어 점수: ");
			eng = sc.nextInt();
			if (eng > 100)
				System.out.println("다시 입력하세요.");
		} while (eng < 0 || eng > 100);

		do {
			System.out.print("수학 점수: ");
			mat = sc.nextInt();
			if (mat > 100)
				System.out.println("다시 입력하세요.");
		} while (mat < 0 || mat > 100);

		sum = kor + eng + mat;
		avg = sum / 3.0;
		
		switch((int)(avg/10)){
		case 10:
		case 9:
			hak='A';
			break;
		case 8:
			hak='B';
			break;
		case 7:
			hak='C';
			break;
		case 6:
			hak='D';
			break;
		default:
			hak='F';
	
		}

		System.out.println("총점: " + sum);
		System.out.printf("평균: %.3f\n", avg);
		System.out.println("학점: "+ hak);
	}
}