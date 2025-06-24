// Cat.java 파일
package com.polymorphism;

/*
  Cat 클래스: 고양이! (Animal의 자식 클래스)
 
  핵심:
  - 'Animal'을 상속받아서 동물의 기본 특징을 물려받는다. (extends Animal)
  - 'scream()'과 'getName()' 메소드를 **지 맘대로 재정의(Override)한다.**
  ★★★★★ 이게 바로 다형성의 꽃이자 존나 중요한 부분이다! ★★★★★
  (부모가 가진 기능을 자식 클래스에서 자기식대로 바꾸는 거)
 */

public class Cat extends Animal { // Animal 클래스를 상속받아서 동물이다!
    
    private String name; // 고양이 이름 저장용.

    // 생성자: Cat 객체 만들 때 이름("Cat")을 딱 정해준다.
    public Cat() {
        this.name = getClass().getSimpleName(); // 이 클래스 이름(Cat)을 그대로 이름으로 쓴다.
    }

    // @Override: 부모(Animal)의 scream()을 고양이 울음소리로 바꾼다!
    @Override
    public String scream() {
        return "야옹 야옹~~"; // 고양이 특유의 울음소리.
    }

    // @Override: 부모(Animal)의 getName()을 고양이 이름 반환으로 바꾼다!
    @Override
    public String getName() {
        return name; // 설정된 고양이 이름(Cat)을 반환.
    }
}
