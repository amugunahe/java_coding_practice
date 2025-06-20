package com.objectex; // 이 코드가 속한 패키지(폴더) 이름이에요.

// (Card 클래스가 정의되어 있다고 가정합니다.)
class Card {
    // 인스턴스 변수: 각 카드 객체마다 고유한 값을 가집니다.
    String kind; // 카드의 무늬 (예: "Heart", "Spade")
    int number;  // 카드의 숫자 (예: 7, 4)

    // 클래스 변수 (static 변수): 모든 Card 객체가 이 값을 공유합니다.
    static int width = 100;  // 카드의 기본 너비
    static int height = 250; // 카드의 기본 높이
}

public class CardExam { // CardExam 이라는 이름의 클래스를 정의합니다.

    public static void main(String[] args) { // 프로그램의 시작점인 main 메소드입니다.
        
        // 1. 클래스 변수에 직접 접근 (객체 생성 전에도 가능!)
        // Card 클래스의 width와 height는 static 변수이므로,
        // Card 객체를 만들지 않고도 '클래스 이름.변수이름' 형식으로 바로 접근할 수 있습니다.
        System.out.println("Card width: " + Card.width);    // 출력: Card width: 100
        System.out.println("Card.height: " + Card.height);  // 출력: Card.height: 250
        
        /* 주석 설명: 클래스 변수는 객체 생성없이 클래스 이름.변수로 직접 사용 가능하다. */
        
        // 2. 첫 번째 Card 객체(c1) 생성 및 인스턴스 변수 설정
        Card c1 = new Card(); // 새로운 Card 객체를 메모리에 만들고, 그 주소를 c1 변수에 저장합니다.
                              // c1은 자신만의 독립적인 `kind`와 `number`를 가집니다.
        c1.kind = "Heart";   // c1 객체의 `kind`를 "Heart"로 설정
        c1.number = 7;       // c1 객체의 `number`를 7로 설정
        
        // 3. 두 번째 Card 객체(c2) 생성 및 인스턴스 변수 설정
        Card c2 = new Card(); // 또 다른 새로운 Card 객체를 메모리에 만들고, 그 주소를 c2 변수에 저장합니다.
                              // c2는 c1과 독립적으로 자신만의 `kind`와 `number`를 가집니다.
        c2.kind = "Spade";   // c2 객체의 `kind`를 "Spade"로 설정
        c2.number = 4;       // c2 객체의 `number`를 4로 설정

        // (이 시점에서 메모리 상의 상황)
        // Card 클래스:
        //    static width = 100
        //    static height = 250
        //
        // c1 객체: (인스턴스)
        //    kind = "Heart"
        //    number = 7
        //
        // c2 객체: (인스턴스)
        //    kind = "Spade"
        //    number = 4
        //
        // *c1.width와 c2.width는 사실 Card.width와 같은 공간을 가리킴*


        // 4. c1과 c2의 인스턴스 변수 및 클래스 변수 값 출력
        // 인스턴스 변수는 각 객체에 따라 다르고, 클래스 변수는 모든 객체에서 동일하게 보입니다.
        System.out.println("c1은 " + c1.kind + ", " + c1.number +
                "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
        // 출력: c1은 Heart, 7이며, 크기는 (100, 250) <- c1은 static width, height를 가져옴
        System.out.println("c2은 " + c2.kind + ", " + c2.number +
                "이며, 크기는 (" + c2.width + ", " + c2.height + ")");
        // 출력: c2은 Spade, 4이며, 크기는 (100, 250) <- c2도 static width, height를 가져옴
        
        System.out.println();
        System.out.println("c1의 width와 height를 각각 50, 80으로 변경하시오.");

        // 5. 클래스 변수 값 변경 (인스턴스 참조 변수를 통해)
        // `c1.width = 50;`과 `c1.height = 80;`은 `Card.width = 50;`과 `Card.height = 80;`과 완전히 동일한 의미입니다.
        // 즉, `c1`이라는 객체를 통해 `Card` 클래스에 속한 `static` 변수의 값을 변경하는 것이므로,
        // 이 변경은 `Card` 클래스의 모든 인스턴스에 영향을 미칩니다.
        c1.width = 50;  // Card.width가 50으로 변경됨
        c1.height = 80; // Card.height가 80으로 변경됨
        
        // 다시 변경:
        c1.width = 150; // Card.width가 150으로 변경됨
        c1.height = 300; // Card.height가 300으로 변경됨

        // (이 시점에서 메모리 상의 상황)
        // Card 클래스:
        //    static width = 150 (값이 변경됨)
        //    static height = 300 (값이 변경됨)
        //
        // c1 객체: (인스턴스)
        //    kind = "Heart"
        //    number = 7
        //
        // c2 객체: (인스턴스)
        //    kind = "Spade"
        //    number = 4
        //
        // *c1.width와 c2.width는 이제 150, 300을 가리킴*


        // 6. 변경된 값 다시 출력 (클래스 변수의 변화 확인)
        // c1을 통해 변경했지만, c2를 통해서도 변경된 `width`와 `height` 값을 볼 수 있습니다.
        System.out.println("c1은 " + c1.kind + ", " + c1.number +
                "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
        // 출력: c1은 Heart, 7이며, 크기는 (150, 300)
        System.out.println("c2은 " + c2.kind + ", " + c2.number +
                "이며, 크기는 (" + c2.width + ", " + c2.height + ")");
        // 출력: c2은 Spade, 4이며, 크기는 (150, 300) <- c2도 변경된 width, height를 가져옴
        
        /* 주석 설명:
          인스턴스 변수는 인스턴스(객체)가 생성될때마다 생성되므로
          인스턴스 마다 각기 다른 값을 유지할 수 있지만,
         
          클래스 변수는 모든 인스턴스가 하나의 저장공간을 공유하므로
          항상 공통된 값을 갖는다.
         */
    }
}
