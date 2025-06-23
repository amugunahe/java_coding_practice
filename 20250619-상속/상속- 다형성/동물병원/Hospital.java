// Hospital.java 파일
package com.polymorphism;

public class Hospital {
    // injection 메소드: 'Animal' 타입의 객체를 매개변수로 받습니다.
    // 덕분에 Dog, Cat, Tiger 등 어떤 Animal의 자식 객체든 이 메소드에 전달할 수 있습니다.
    public void injection(Animal animal) {
        // animal.getName(): 다형성에 의해 전달된 실제 객체(Dog, Cat, Tiger)의 getName()이 호출됩니다.
        System.out.println(animal.getName() + "을(를) 치료하기 위해 주사를 놓았습니다.");

        // animal.scream(): 다형성에 의해 전달된 실제 객체의 오버라이딩된 scream() 메소드가 호출됩니다.
        System.out.println("주사를 맞은 " + animal.getName() + "의 반응: " + animal.scream());
        System.out.println("---"); // 각 주사 처리를 구분하는 줄
    }
}
