package com.objectex; // 이 코드가 속한 패키지(폴더) 이름이에요.

/* 객체 배열
  - 수 많은 객체를 다뤄야할때 배열로 처리하는 방식 -> 객체 배열
  객체 배열안에 객체가 저장되는 것은 아니고, 객체의 주소가 저장된다.
  객체 배열은 참조변수들을 하나로 묶은 참조변수 배열인것임
 
  TV t1, t2, t3; //객체선언 -> 참조변수선언 (세 개의 Tv 참조변수 선언)
 
  객체배열
  TV[] tvArr = new TV[3]; //위랑 동일 (세 개의 Tv 참조변수를 묶은 배열 선언)
  -> 길이가 3인 객체배열을 생성했다
 
   // 객체를 생성해서 배열의 각 요소에 저장
   TvArr[0] = new Tv[]; // 이 부분은 TvArr[0] = new Tv(); 의 오타인 것 같습니다.
   TvArr[1] = new Tv[];
   TvArr[2] = new Tv[];
 
 	Tv[] tvArr = {new Tv(), new Tv(), newTv()}; // 배열 선언과 동시에 객체 생성 및 초기화

 	Tv[] tvArr = new Tv[100]; // 100개짜리 Tv 참조변수 배열 선언
 	for (int i = 0; i < tvArray.length; i++) { // 반복문을 이용한 객체 생성 및 배열 저장
 	tvArr[i] = new Tv();
 	}
 
 	클래스 - 사용자 정의 타입(자료형)
 */

// (Tv 클래스가 정의되어 있다고 가정합니다. 일반적으로 다음과 같이 생겼을 거예요.)
// class Tv {
//     int channel; // 채널 값을 저장할 인스턴스 변수
//     Tv() { // 생성자 (객체 생성 시 호출)
//         channel = 0; // 초기 채널 값 설정
//     }
//     void channelUp() { // 채널을 1 증가시키는 메소드
//         channel++;
//     }
//     void channelDown() { // 채널을 1 감소시키는 메소드 (예시)
//         channel--;
//     }
// }

public class TvExam03 { // TvExam03 이라는 이름의 클래스를 정의합니다.

    public static void main(String[] args) { // 프로그램의 시작점인 main 메소드입니다.
    
        // 1. 길이가 3인 Tv 객체 배열 선언
        // `Tv[] tvArr = new Tv[3];`
        // 이 코드를 실행하면, `tvArr`이라는 이름의 배열이 메모리에 생성됩니다.
        // 이 배열은 Tv 객체의 '주소'를 3개 저장할 수 있는 공간이에요.
        // 하지만 **이 시점에는 아직 실제 Tv 객체가 만들어진 것이 아닙니다.**
        // 각 `tvArr[0]`, `tvArr[1]`, `tvArr[2]` 요소들은 초기값으로 `null` (아무것도 가리키지 않음)을 가지고 있습니다.
        Tv[] tvArr = new Tv[3];
        
        // (가상의 메모리 상태)
        // tvArr 변수 ----> [ null | null | null ] (배열의 각 요소는 아직 Tv 객체를 가리키지 않음)

        // 2. Tv 객체를 생성해서 배열의 각 요소에 저장 (매우 중요!)
        // 이 `for` 반복문 안에서 비로소 실제 `Tv` 객체들이 생성됩니다.
        for (int i = 0; i < tvArr.length; i++) {
            // `tvArr[i] = new Tv();`
            // `new Tv()`를 호출하여 새로운 Tv 객체를 메모리에 만듭니다.
            // 그리고 이 객체의 '주소'를 `tvArr[i]` (배열의 각 위치)에 저장합니다.
            tvArr[i] = new Tv(); // 각 배열 요소가 독립적인 Tv 객체를 가리키게 됩니다.

            // `tvArr[i].channel = i + 10;`
            // `tvArr[i]`가 가리키는 Tv 객체의 `channel` 멤버 변수에 값을 할당합니다.
            // i가 0일 때: tvArr[0] 객체의 channel은 10
            // i가 1일 때: tvArr[1] 객체의 channel은 11
            // i가 2일 때: tvArr[2] 객체의 channel은 12
            tvArr[i].channel = i + 10;
        }

        // (가상의 메모리 상태)
        // tvArr 변 ----> [ 주소A | 주소B | 주소C ]
        //                 |       |       |
        //                 V       V       V
        //               [Tv 객체 A (channel: 10)]
        //               [Tv 객체 B (channel: 11)]
        //               [Tv 객체 C (channel: 12)]
        
        // 3. 배열에 저장된 각 Tv 객체의 메소드 호출 및 값 확인
        for (int i = 0; i < tvArr.length; i++) {
            // `tvArr[i].channelUp();`
            // `tvArr[i]`가 가리키는 Tv 객체의 `channelUp()` 메소드를 호출합니다.
            // 이 메소드는 해당 객체의 `channel` 값을 1 증가시킵니다.
            // i가 0일 때: tvArr[0]의 channel (10)이 11로 증가
            // i가 1일 때: tvArr[1]의 channel (11)이 12로 증가
            // i가 2일 때: tvArr[2]의 channel (12)이 13으로 증가
            tvArr[i].channelUp();

            // 변경된 채널 값을 출력합니다.
            System.out.println("tvArr[" + i + "]:" + tvArr[i].channel);
        }
    }
}
