// Tiger.java 파일
package com.polymorphism;

/*
  Tiger 클래스: 호랑이새끼! (Animal의 자식 클래스)
 
  핵심:
  - 'Animal'을 상속받아서 동물의 기본 특징을 물려받는다. (extends Animal)
  - 'scream()'과 'getName()' 메소드를 **지 맘대로 재정의(Override)한다.**
  ★★★★★ 이것도 다형성의 개 중요한 부분이다! ★★★★★
  (부모 기능 그대로 안 쓰고, 호랑이 울음소리로 바꾸는 거)
 */

public class Tiger extends Animal { // Animal 클래스를 상속받아서 동물이다!
    private String name; // 호랑이새끼 이름 저장용.

    // 생성자: Tiger 객체 만들 때 이름("Tiger")을 딱 정해준다.
    public Tiger() {
        this.name = getClass().getSimpleName(); // 이 클래스 이름(Tiger)을 그대로 이름으로 쓴다.
    }

    // @Override: 부모(Animal)의 scream()을 호랑이 울음소리로 바꾼다!
    @Override
    public String scream() {
        return "그르릉 어흥어흥~~"; // 호랑이새끼 특유의 울음소리.
    }

    // @Override: 부모(Animal)의 getName()을 호랑이 이름 반환으로 바꾼다!
    @Override
    public String getName() {
        return name; // 설정된 호랑이 이름(Tiger)을 반환.
    }
}
