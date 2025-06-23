package com.functionex; // 이 클래스도 ArrayUtil과 같은 패키지(폴더)에 속해 있어요.

/* 문 7] 두개의 static 메소드를 가진 ArrayUtil 클래스를 만들어라
다음 코드의 실행 결과를 참고하여 concat()와 print()를 작성하여 ArrayUtil 클래스를 완성하시오
*/

class StaticEx { // 'StaticEx'라는 이름의 클래스입니다.

    public static void main(String[] args) { // 이 메서드는 자바 프로그램이 시작될 때 가장 먼저 실행되는 곳이에요.
                                             // 프로그램의 '입구'라고 생각하시면 됩니다.

        // 1. 첫 번째 정수형 배열 'array1'을 만듭니다.
        //    {1, 5, 7, 9}라는 숫자들을 담고 있습니다.
	    
        int[] array1 = { 1, 5, 7, 9 };

        // 2. 두 번째 정수형 배열 'array2'를 만듭니다.
        //    {3, 6, -1, 100, 7}라는 숫자들을 담고 있습니다.
	    
        int[] array2 = { 3, 6, -1, 100, 7 };

        // 3. 이제 여러분이 만든 'ArrayUtil' 클래스의 'concat' 메서드를 사용합니다.
        //    'ArrayUtil.concat(array1, array2)'는 'array1'과 'array2'를 합쳐서 새로운 배열을 만들어줍니다.
        //    그리고 그 새롭게 합쳐진 배열을 'array3'이라는 변수에 저장합니다.
        //    'array3' 안에는 {1, 5, 7, 9, 3, 6, -1, 100, 7} 이렇게 순서대로 숫자들이 들어가 있을 거예요.
	    
        int[] array3 = ArrayUtil.concat(array1, array2);

        // 4. 다음으로, 'ArrayUtil' 클래스의 'print' 메서드를 사용해서 'array3'의 내용을 출력합니다.
        //    'ArrayUtil.print(array3)'는 'array3'에 들어있는 숫자들을 화면에 보여주는 역할을 합니다.
	    
        ArrayUtil.print(array3);
    }
}
