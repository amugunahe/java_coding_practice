package com.polymorphism;

/*
  TvTest 클래스: **다형성과 객체 형변환의 핵심 개념을 배우는 곳!**
  (여기엔 'main' 메소드는 없지만, 개념 정리는 존나 중요하다.)
 
  핵심 개념:
  1. **다형성**: 하나의 변수가 **여러 형태의 객체를 가리킬 수 있는 능력.** (존나 개사기 능력!)
  2. **업캐스팅**: **자식 객체를 부모 타입 변수로 취급하는 것.** (존나 안전함. 컴퓨터가 알아서 해줌.)
  3. **다운캐스팅**: **부모 타입 변수를 다시 자식 타입으로 되돌리는 것.** (★★★★★ 명시적으로 시켜야 함! 실제 객체 타입이랑 다르면 'ClassCastException'이라는 오류가 터진다! 존나 중요! ★★★★★)
 */

public class TvTest {

    // Tv v = new Tv(); // 'Tv' 객체 만들어서 'v'가 가리킨다. (지금은 주석 처리돼서 안 씀)

    // --- CaptionTv 객체 생성 (자식 객체를 자식 타입 변수가 가리킴) ---
    CaptionTv c = new CaptionTv();
    // 'c'는 'CaptionTv' 타입이라, 'CaptionTv'가 가진 모든 메소드/속성에 접근 가능하다.
    // (예: power(), channelUp() 같은 Tv 기능 + text, caption() 같은 CaptionTv 고유 기능)

    // --- ★★★ 존나 중요! 다형성과 업캐스팅 예시! ★★★ ---
    Tv v = new CaptionTv();
    // 'v'(Tv 타입)가 'CaptionTv' 객체를 가리킨다! 이게 바로 **다형성**이고 **업캐스팅**이다.
    // 'CaptionTv'는 'Tv'의 자식이라 이렇게 하는 게 존나 안전하고 가능함.

    // 'v' 변수는 'Tv' 타입으로 선언됐기 때문에, 비록 실제로는 'CaptionTv' 객체여도
    // 'Tv' 클래스에 정의된 메소드/속성(power, channel, power(), channelUp() 등)만 쓸 수 있다.
    // 'CaptionTv'만의 고유한 기능(text, caption() 등)은 'v'로는 직접 못 쓴다.
    // (마치 소방차를 '차'라고 부르면 물 뿌려! 라고 바로 못 시키는 것과 같다.)

    /*
      업캐스팅:
      - 자식 타입을 부모 타입으로 형변환하는 것. (예: `Car car = new FireEngine();`)
      - ★★★ 존나 안전해서 형변환 괄호(예: `(Car)`) 생략 가능! ★★★
     */

    /*
      다운캐스팅:
      - 부모 타입을 자식 타입으로 형변환하는 것. (예: `FireEngine fe = (FireEngine)car;`)
      - ★★★ 명시적 형변환(괄호 붙이기)이 무조건 필요함! ★★★
      - **실행 중에 실제 객체 타입이랑 다르면 'ClassCastException' 오류가 터진다!** (존나 중요한 함정!)
     */

    // 이 파일은 그냥 개념 설명용이라 여기서 바로 실행은 안 된다.
    // 아마 다른 파일('main' 메소드 있는 곳)에서 이걸 가져다 쓸 거다.
}
