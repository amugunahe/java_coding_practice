package com.objectex; // 이 코드는 'com.objectex' 패키지에 있다.

/*
  객체 배열 (존나 중요!)
  - 수많은 객체를 한 번에 관리할 때 쓴다.
  - ★핵심: 배열 안에 객체 자체가 아니라, '객체의 주소'가 저장된다. (참조 변수들의 배열임)
 
  Tv[] tvArr = new Tv[3]; // Tv 객체 주소 3개를 저장할 공간만 만드는 거. 이 시점에 실제 Tv 객체는 아직 없다.
 
  // 진짜 Tv 객체는 이렇게 만들어야 배열에 들어간다.
  tvArr[0] = new Tv();
  tvArr[1] = new Tv();
  tvArr[2] = new Tv();
 
  // 보통 반복문으로 한 번에 만든다.
  for (int i = 0; i < tvArr.length; i++) {
  tvArr[i] = new Tv(); // 여기서 실제 Tv 객체가 하나씩 생성돼서 배열 칸에 주소가 들어가는 거임.
  }
 */

// Tv 클래스 (코드에 직접 없으니 있다고 가정)
// class Tv {
//    int channel;
//    Tv() { channel = 0; }
//    void channelUp() { channel++; }
// }

public class TvExam03 { // Tv 객체 배열 가지고 노는 예제.

    public static void main(String[] args) { // 프로그램 시작점.

        // 1. 길이가 3인 Tv 객체 배열 선언만 함. (아직 Tv 객체는 없음!)
        // 각 칸은 지금 `null` 상태다.
        Tv[] tvArr = new Tv[3];
        
        // 2. ★핵심: 반복문 돌면서 실제 Tv 객체 만들고 배열에 할당. (여기서 Tv 객체들이 메모리에 생성됨!)
        for (int i = 0; i < tvArr.length; i++) {
            tvArr[i] = new Tv(); // 새로운 Tv 객체 만들어서 `tvArr[i]`에 그 객체의 주소를 넣음.
            tvArr[i].channel = i + 10; // 각 Tv 객체의 채널 값 설정.
        }

        // 3. 배열에 저장된 각 Tv 객체의 채널 올리고 값 확인.
        for (int i = 0; i < tvArr.length; i++) {
            tvArr[i].channelUp(); // 해당 Tv 객체의 채널을 1 올림.
            System.out.println("tvArr[" + i + "]:" + tvArr[i].channel); // 변경된 채널 값 출력.
            // 결과:
            // tvArr[0]:11 (원래 10이었는데 1 증가)
            // tvArr[1]:12 (원래 11이었는데 1 증가)
            // tvArr[2]:13 (원래 12였는데 1 증가)
        }
    }
}
