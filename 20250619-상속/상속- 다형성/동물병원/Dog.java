// Dog.java 파일
package com.polymorphism;

public class Dog extends Animal { // Animal 클래스를 상속받습니다.
    private String name; // 강아지의 이름을 저장할 필드

    // 생성자: Dog 객체가 생성될 때 이름("Dog")을 초기화합니다.
    public Dog() {
        this.name = getClass().getSimpleName(); // 클래스 이름을 이름으로 설정
    }

    // @Override: 부모 클래스(Animal)의 scream() 메소드를 재정의합니다.
    @Override
    public String scream() {
        return "멍멍 깨갱~~~"; // Dog만의 울음소리
    }

    // @Override: 부모 클래스(Animal)의 getName() 메소드를 재정의합니다.
    @Override
    public String getName() {
        return name; // 강아지의 이름 반환
    }
}