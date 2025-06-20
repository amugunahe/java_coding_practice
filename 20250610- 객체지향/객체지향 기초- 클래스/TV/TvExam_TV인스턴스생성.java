package com.objectex; // 이 코드가 속한 패키지(폴더) 이름이에요.

// (Tv 클래스가 정의되어 있다고 가정합니다. 일반적으로 다음과 같이 생겼을 거예요.)
// class Tv {
//     private int channel; // 채널 값을 저장할 멤버 변수 (속성)
//
//     // channel 값을 설정하는 메소드 (행동)
//     public void setChannel(int ch) {
//         channel = ch;
//     }
//
//     // channel 값을 1 증가시키는 메소드 (행동)
//     public void channelUp() {
//         channel++;
//     }
//
//     // channel 값을 반환하는 메소드 (행동)
//     public int getChannel() {
//         return channel;
//     }
// }

public class TvExam { // TvExam 이라는 이름의 클래스를 정의합니다.

    public static void main(String[] args) { // 프로그램의 시작점인 main 메소드입니다.

        // 1. Tv 인스턴스를 참조하기 위한 참조 변수 t 선언
        // `Tv t;`는 'Tv 객체의 주소를 저장할 수 있는 `t`라는 이름의 변수를 만들겠다'는 뜻이에요.
        // 이 변수는 아직 어떤 객체도 가리키지 않고, 초기값으로 `null`을 가집니다.
        Tv t;
        
        // 2. Tv 인스턴스 생성
        // `t = new Tv();`
        // `new Tv()`: 메모리 공간을 할당받아 `Tv` 설계도에 따라 실제 `Tv` 객체 하나를 만듭니다.
        // `=`: 새로 생성된 `Tv` 객체가 있는 메모리의 '주소(참조값)'를 `t` 변수에 저장합니다.
        // 이제 `t`는 메모리에 있는 특정 `Tv` 객체를 '가리키게' 됩니다.
        t = new Tv();
        
        // (가상의 메모리 상태)
        // t 변수 ---------> [Tv 객체 (channel: 0 또는 초기 생성자에 의해 설정된 값)]

        // 3. Tv 인스턴스의 멤버 변수 channel의 값을 7로 설정
        // `t.setChannel(7);`
        // `t`가 가리키는 `Tv` 객체의 `setChannel()` 메소드를 호출합니다.
        // 이 메소드에 숫자 `7`을 인자로 전달하여, 객체 내부의 `channel` 값을 `7`로 변경합니다.
        t.setChannel(7);
        
        // (가상의 메모리 상태)
        // t 변수 ---------> [Tv 객체 (channel: 7)]

        // 4. Tv 인스턴스의 메소드 channelUp()을 호출
        // `t.channelUp();`
        // `t`가 가리키는 `Tv` 객체의 `channelUp()` 메소드를 호출합니다.
        // 이 메소드는 객체 내부의 `channel` 값을 1 증가시키는 기능을 수행합니다.
        t.channelUp(); // 메소드 호출 (channel이 7에서 8로 변경됩니다.)

        // (가상의 메모리 상태)
        // t 변수 ---------> [Tv 객체 (channel: 8)]
        
        // 5. 현재 채널 값 출력
        // `System.out.println("현재 채널은 " + t.getChannel() + " 입니다.");`
        // `t.getChannel()`: `t`가 가리키는 `Tv` 객체의 `getChannel()` 메소드를 호출하여
        //                    현재 `channel` 값을 반환받습니다. (이 시점에는 8)
        // `System.out.println()`: 반환된 값을 포함한 문자열을 화면에 출력합니다.
        System.out.println("현재 채널은 " + t.getChannel() + " 입니다." ); // 출력: "현재 채널은 8 입니다."
    }
}
