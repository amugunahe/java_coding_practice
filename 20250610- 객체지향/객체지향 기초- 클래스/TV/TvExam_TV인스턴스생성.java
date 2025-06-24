package com.objectex; // 이 코드는 'com.objectex' 패키지에 있다.

// Tv 클래스 (코드에 직접 없으니 있다고 가정)
// class Tv {
//    private int channel; // Tv의 채널 값을 저장하는 변수 (속성).
//
//    public void setChannel(int ch) { // 채널 값을 설정하는 메소드 (행동).
//        channel = ch;
//    }
//
//    public void channelUp() { // 채널 값을 1 증가시키는 메소드 (행동).
//        channel++;
//    }
//
//    public int getChannel() { // 현재 채널 값을 돌려주는 메소드 (행동).
//        return channel;
//    }
// }

public class TvExam { // Tv 객체를 다루는 예제 클래스.

    public static void main(String[] args) { // ★★★ 프로그램 시작점. ★★★

        // 1. Tv 객체를 가리킬 't'라는 변수를 선언.
        // 이 변수는 아직 아무 객체도 가리키지 않고, 초기값은 `null`이다.
        Tv t;
        
        // 2. ★핵심: 'new Tv()'로 실제 Tv 객체를 메모리에 생성하고, 그 객체의 주소를 't' 변수에 저장.
        // 이제 't'는 하나의 진짜 Tv 객체를 가리키게 된다.
        t = new Tv();
        
        // 3. 't'가 가리키는 Tv 객체의 채널을 7로 설정.
        t.setChannel(7);
        
        // 4. 't'가 가리키는 Tv 객체의 채널을 1 증가시킴. (채널이 7에서 8이 된다.)
        t.channelUp();

        // 5. 't'가 가리키는 Tv 객체의 현재 채널 값을 가져와서 출력.
        System.out.println("현재 채널은 " + t.getChannel() + " 입니다." ); // 결과: "현재 채널은 8 입니다."
    }
}
