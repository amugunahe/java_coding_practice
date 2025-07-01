package com.vscore;

import java.util.List; // List를 사용해야 하니까 임포트해라.

// Score 인터페이스: 점수 관리 기능들을 정의한다.
// 이 인터페이스를 구현하는 클래스는 이 메소드들을 반드시 구현해야 한다.
// 니가 ScoreImpl에서 쓰려는 메소드 이름에 맞춰서 다시 정의했다.
public interface Score {
    // 학생 정보 추가
    void insert();

    // 학생 정보 수정
    void update();

    // 학생 정보 삭제
    void delete();

    // 모든 학생 정보 출력
    void listAll();

    // 학번으로 학생 검색
    void searchHak();

    // 이름으로 학생 검색
    void searchName(); // searchNS) 이딴 거 쓰지 마라, 이 새끼야!
}