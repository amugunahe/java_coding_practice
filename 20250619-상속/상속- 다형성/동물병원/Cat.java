// Cat.java 파일
package com.polymorphism;

public class Cat extends Animal { // Animal 클래스를 상속받습니다.
    private String name; // 고양이의 이름을 저장할 필드

    // 생성자: Cat 객체가 생성될 때 이름("Cat")을 초기화하고, 울음소리를 설정합니다.
    public Cat() {
        this.name = getClass().getSimpleName(); // 클래스 이름을 이름으로 설정
    }

    // @Override: 부모 클래스(Animal)의 scream() 메소드를 재정의합니다.
    @Override
    public String scream() {
        return "야옹 야옹~~"; // Cat만의 울음소리
    }

    // @Override: 부모 클래스(Animal)의 getName() 메소드를 재정의합니다.
    @Override
    public String getName() {
        return name; // 고양이의 이름 반환
    }
}