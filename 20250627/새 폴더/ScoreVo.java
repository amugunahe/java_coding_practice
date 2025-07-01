package com.vscore;

// ScoreVo 클래스: 학생 한 명의 정보를 담는 객체다.
// Value Object (VO) 또는 Data Transfer Object (DTO)라고 부른다.
public class ScoreVo {
    private String hak;     // 학번
    private String name;    // 이름
    private String birth;   // 생년월일 (YYMMDD 형식으로 가정)
    private int kor;        // 국어 점수
    private int eng;        // 영어 점수
    private int mat;        // 수학 점수
    private int total;      // 총점 (자동 계산)
    private double ave;     // 평균 (자동 계산)

    // 기본 생성자: 객체만 만들 때 쓴다.
    public ScoreVo() {
    }

    // 모든 필드를 초기화하는 생성자다. (총점, 평균은 여기서 계산)
    public ScoreVo(String hak, String name, String birth, int kor, int eng, int mat) {
        this.hak = hak;
        this.name = name;
        this.birth = birth;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
        calculateTotalAndAverage(); // 총점과 평균을 계산한다.
    }

    // 총점과 평균을 계산하는 내부 메소드다.
    // 점수가 변경될 때마다 호출해서 최신 상태를 유지한다.
    private void calculateTotalAndAverage() {
        this.total = this.kor + this.eng + this.mat;
        this.ave = (double) this.total / 3.0; // 평균은 소수점까지 나오게 double로 계산한다.
    }

    // 각 필드에 대한 Getter 메소드들이다. (값을 가져올 때 쓴다)
    public String getHak() {
        return hak;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMat() {
        return mat;
    }

    public int getTotal() {
        return total;
    }

    public double getAve() {
        return ave;
    }

    // 각 필드에 대한 Setter 메소드들이다. (값을 설정할 때 쓴다)
    // 점수 관련 Setter는 점수 변경 시 총점/평균을 다시 계산하도록 했다.
    public void setHak(String hak) {
        this.hak = hak;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setKor(int kor) {
        this.kor = kor;
        calculateTotalAndAverage(); // 점수가 바뀌면 총점, 평균도 다시 계산한다.
    }

    public void setEng(int eng) {
        this.eng = eng;
        calculateTotalAndAverage(); // 점수가 바뀌면 총점, 평균도 다시 계산한다.
    }

    public void setMat(int mat) {
        this.mat = mat;
        calculateTotalAndAverage(); // 점수가 바뀌면 총점, 평균도 다시 계산한다.
    }

    // 객체의 내용을 문자열로 반환하는 메소드다.
    // System.out.println(scoreVo객체) 할 때 이 형식을 쓴다.
    @Override 
    public String toString() {
        // printf 형식으로 깔끔하게 정렬해서 출력한다.
        // %6.2f는 소수점 둘째 자리까지 출력하라는 의미다.
        return String.format("%7s%10s%7s%5d%5d%5d%5d%6.2f",
                             hak, name, birth, kor, eng, mat, total, ave);
    }
}