// Hospital.java 파일
package com.polymorphism;

/*
  Hospital 클래스: 동물병원!
 
  핵심:
  - 'injection' 메소드가 **'Animal' 타입의 객체를 매개변수로 받는다.**
  - ★★★★★ 이게 바로 다형성의 **존나게 중요한 장점!** ★★★★★
  'Animal'을 상속받은 모든 자식들 (Cat, Dog, 나중에 만들 Tiger 등)을
  이 메소드 하나로 다 치료(처리)할 수 있다는 거다.
  각 동물마다 따로 메소드 만들 필요가 없음! 존나 개꿀!
  - 'animal.getName()'이나 'animal.scream()' 호출하면,
  실제로 넘어온 **Cat이나 Dog 객체의 오버라이딩된 메소드가 실행된다.**
  (이게 바로 다형성의 핵심 동작 원리다!)
 */

public class Hospital {
    // injection 메소드: 어떤 'Animal'이든 데려와라! 다 치료해줄게!
    
    public void injection(Animal animal) {
        // 동물 이름 출력: 실제 객체(Cat이면 Cat, Dog면 Dog)의 이름이 나온다.
        System.out.println(animal.getName() + "을(를) 치료하기 위해 주사를 놓았습니다.");

        // 주사 맞은 동물의 반응 출력: 실제 객체의 울음소리가 나온다.
        System.out.println("주사를 맞은 " + animal.getName() + "의 반응: " + animal.scream());
        System.out.println("---"); // 주사 한 번 끝날 때마다 구분선 쫙!
    }
}
