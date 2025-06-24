// HospitalMain.java 파일
package com.polymorphism;

/*
  HospitalMain 클래스: ★★★ 다형성 테스트의 존나게 중요한 메인 프로그램! ★★★
 
  핵심:
  - 'Hospital'에 모든 종류의 'Animal'을 (Dog, Cat, Tiger) 보낼 수 있음을 보여준다.
  - Animal 타입 변수 하나로 Dog, Cat, Tiger 객체를 모두 참조한다.
  이게 바로 **'다형성(Polymorphism)'이라는 개념의 개핵심**이다!
  - 'injection()' 메소드 호출할 때, 실제로는 Dog, Cat, Tiger 각자의
  'scream()'이나 'getName()'이 실행된다. (오버라이딩된 메소드 호출)
  덕분에 코드 존나 깔끔해지고 확장성도 미친다!
 */

public class HospitalMain {

    public static void main(String[] args) {
        Hospital h = new Hospital(); // 동물 병원 개원!

        // --- ★★★ 존나 중요! 다형성의 진정한 맛! ★★★
        // Animal 타입 변수 하나로 개, 고양이, 호랑이 새끼들을 다 가리킨다!
        Animal dog = new Dog();    // '개' 객체를 'Animal' 타입으로 본다.
        Animal cat = new Cat();    // '고양이' 객체를 'Animal' 타입으로 본다.
        Animal tiger = new Tiger(); // '호랑이' 객체를 'Animal' 타입으로 본다.

        // Hospital의 injection 메소드에 이 동물들을 하나씩 던져 넣는다.
        // 메소드 안에서는 각 동물의 실제 울음소리랑 이름이 나온다! (오버라이딩의 힘!)
        h.injection(dog);   // 개새끼 주사 놓기
        h.injection(cat);   // 고양이 주사 놓기
        h.injection(tiger); // 호랑이 주사 놓기
    }
}
