package com.functionex; // 이 클래스도 'ArrayUtil'이랑 같은 패키지(폴더)에 속한다, 씨발!
                         // 패키지는 관련 클래스들을 묶어 관리하는 폴더와 같은 개념이다.

/*
  StaticEx 클래스: **`ArrayUtil` 클래스의 'static' 메소드들을 존나게 활용하는 예제다!**
 
  핵심:
 - **문제:** 'ArrayUtil' 클래스에 있는 `concat()` 메소드(두 배열 합치기)랑 `print()` 메소드(배열 출력하기)를 써서
  두 개의 배열을 합치고 그 결과를 출력하는 것을 보여준다!
 - **`static` 메소드의 위엄:** 'ArrayUtil' 클래스의 메소드들이 `static`으로 선언되어 있어서,
  `ArrayUtil.concat()`이나 `ArrayUtil.print()`처럼 **객체 생성 없이 '클래스 이름.메소드이름()'으로 바로 호출할 수 있다!** (존나 편하다!)
 */

class StaticEx { // 'StaticEx'라는 이름의 클래스다. (이 파일 하나로 실행한다!)

    public static void main(String[] args) { // 이 메소드는 자바 프로그램이 시작될 때 가장 먼저 실행되는 곳이다.
                                             // 프로그램의 '입구'라고 생각하면 된다, 씨발!

        // 1. 첫 번째 정수형 배열 'array1'을 만든다.
        // {1, 5, 7, 9}라는 숫자들을 담고 있다.
        int[] array1 = { 1, 5, 7, 9 };

        // 2. 두 번째 정수형 배열 'array2'를 만든다.
        // {3, 6, -1, 100, 7}라는 숫자들을 담고 있다.
        int[] array2 = { 3, 6, -1, 100, 7 };

        // 3. 이제 'ArrayUtil' 클래스의 'concat' 메소드를 사용한다! (존나 중요!)
        // 'ArrayUtil.concat(array1, array2)'는 'array1'과 'array2'를 합쳐서 새로운 배열을 만들어준다.
        // 그리고 그 새롭게 합쳐진 배열을 'array3'이라는 변수에 저장한다.
        // 'array3' 안에는 {1, 5, 7, 9, 3, 6, -1, 100, 7} 이렇게 순서대로 숫자 존나게 들어가 있을 거다, 씨발!
        int[] array3 = ArrayUtil.concat(array1, array2);

        // 4. 다음으로, 'ArrayUtil' 클래스의 'print' 메소드를 사용해서 'array3'의 내용을 출력한다!
        // 'ArrayUtil.print(array3)'는 'array3'에 들어있는 숫자들을 화면에 존나게 보여주는 역할을 한다.
        System.out.print("합쳐진 배열의 결과: "); // 출력 메시지 추가!
        ArrayUtil.print(array3); // 출력 예상: 합쳐진 배열의 결과: [1 5 7 9 3 6 -1 100 7 ]
    }
}
