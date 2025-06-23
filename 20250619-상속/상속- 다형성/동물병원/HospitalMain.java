// HospitalMain.java 파일
package com.polymorphism;

public class HospitalMain { // 이 파일의 유일한 public 클래스이며, 파일 이름과 정확히 일치해야 합니다.

    public static void main(String[] args) {
        Hospital h = new Hospital(); // 병원 객체 생성

        // Animal 타입의 참조 변수로 Dog, Cat, Tiger 객체를 생성합니다.
        // 이것이 바로 '다형성(Polymorphism)'의 핵심 예시입니다.
        Animal dog = new Dog();    // Dog 객체 생성 및 Animal 타입으로 참조
        Animal cat = new Cat();    // Cat 객체 생성 및 Animal 타입으로 참조
        Animal tiger = new Tiger(); // Tiger 객체 생성 및 Animal 타입으로 참조

        // Hospital 객체의 injection 메소드를 호출하면서 다양한 Animal 타입 객체를 전달합니다.
        // injection 메소드 내부에서는 전달된 실제 객체(Dog, Cat, Tiger)의
        // 오버라이딩된 getName()과 scream() 메소드가 자동으로 호출됩니다.
        h.injection(dog);
        h.injection(cat);
        h.injection(tiger);
    }
}