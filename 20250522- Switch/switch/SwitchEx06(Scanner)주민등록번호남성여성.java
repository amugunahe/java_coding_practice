package com.switchex;

import java.util.Scanner;

public class SwitchEX06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // 사용자 입력 받기 위한 Scanner 객체 생성

        System.out.print("주민등록번호 전부 입력(예: 123456-1234567): "); // 주민등록번호 입력 요청
        String jumin = sc.nextLine(); // 주민등록번호 문자열로 입력받기

        // 주민등록번호 뒷자리 첫 번째 숫자(성별/출생년대 코드) 추출
        // 문자열은 0부터 시작하므로 8번째 문자는 인덱스 7
        char genderCode = jumin.charAt(7);

        String birthYearCentury; // 출생 년대를 저장할 변수
        String genderResult;     // 성별을 저장할 변수

        // 성별 코드를 기준으로 출생년대와 성별 판별
        switch (genderCode) {
            case '1':
                birthYearCentury = "1900년대";
                genderResult = "남성";
                break; // '1'은 1900년대 남성
            case '2':
                birthYearCentury = "1900년대";
                genderResult = "여성";
                break; // '2'는 1900년대 여성
            case '3':
                birthYearCentury = "2000년대";
                genderResult = "남성";
                break; // '3'은 2000년대 남성
            case '4':
                birthYearCentury = "2000년대";
                genderResult = "여성";
                break; // '4'는 2000년대 여성
            default: // 1, 2, 3, 4 이외의 숫자가 들어온 경우
                birthYearCentury = "알 수 없는 년대";
                genderResult = "알 수 없는 성별";
                System.out.println("잘못된 주민등록번호 형식입니다."); // 오류 메시지 출력
                sc.close(); // 잘못된 입력이므로 바로 Scanner 닫고 종료
                return; // main 메서드 종료
        }
        
        // 최종 결과 출력
        System.out.println(birthYearCentury + " 출생한 " + genderResult + "입니다.");

        sc.close(); // 사용이 끝난 Scanner 객체 닫기 (리소스 해제)
    }
}
