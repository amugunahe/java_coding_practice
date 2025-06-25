package com.functionex; // 이 코드가 속한 패키지(폴더) 이름이다. 
                         // 패키지는 관련 있는 클래스들을 묶어 관리하는 데 사용된다.
                         // 나중에 이 클래스를 사용할 때 'import com.functionex.ArrayUtil;'처럼 가져올 수 있다, 씨발!

/*
  ArrayUtil 클래스: **배열(Array)을 다루는 존나 유용한 기능들을 모아놓은 클래스다!**
 
  핵심:
  - **목표:** 배열을 연결하거나(concat), 배열 내용을 깔끔하게 출력하는(print) 등의 작업을 메소드로 제공한다.
  - **`static` 메소드:** 이 클래스의 모든 메소드는 `static`으로 선언되어 있다.
  -> **객체(인스턴스)를 만들 필요 없이 'ArrayUtil.메소드이름()' 형식으로 바로 호출할 수 있다!** (존나 편하다!)
  - **`concat()` 메소드:** 두 개의 `int` 배열을 받아서 하나로 합쳐진 새로운 `int` 배열을 반환한다.
  -> 배열의 길이를 미리 계산해서 새 배열을 만들고, `for` 루프로 요소들을 차례대로 복사한다! (알잘딱깔센 복사!)
  - **`print()` 메소드:** `int` 배열을 받아서 그 안에 있는 모든 요소들을 보기 좋은 형태로 화면에 출력한다.
 */

public class ArrayUtil { // 'ArrayUtil'이라는 이름의 공개(public) 클래스를 정의한다.
                         // 'public'은 이 클래스를 어디서든 접근할 수 있다는 의미이고,
                         // 'class'는 객체를 만들기 위한 설계도라고 생각할 수 있다.
                         // 여기서는 배열(Array)을 다루는 유틸리티(Util) 기능을 모아놓은 클래스다.

    // --- 1. `concat()` 메소드: 두 개의 정수 배열을 연결하여 새로운 배열을 반환한다! ---
    // 'public static': 어디서든 접근 가능하며, 객체 생성 없이 바로 호출할 수 있다. 유틸리티 메소드에서 존나 자주 쓰인다!
    // 'int[]': 이 메소드가 '정수형 배열'을 반환한다는 의미다.
    // 'concat': 메소드의 이름이다. 'concatenate(연결하다)'에서 따왔다.
    // '(int[] a, int[] b)': 이 메소드가 받게 될 입력 값(매개변수)이다. 첫 번째 정수 배열 `a`, 두 번째 정수 배열 `b`를 받는다.
	
    public static int[] concat(int[] a, int[] b) {
        // 배열 `a`와 `b`를 연결한 새로운 배열을 반환한다.

        // 1. 새로운 배열 생성:
        // 연결될 두 배열의 모든 요소를 담을 수 있는 새로운 배열 'arr'을 생성한다.
        // 새로운 배열의 크기는 첫 번째 배열 'a'의 길이와 두 번째 배열 'b'의 길이를 합한 값이다.
        // 예: a = {1, 2} (길이 2), b = {3, 4, 5} (길이 3) 이라면,
        //     'arr'은 총 2 + 3 = 5개의 요소를 저장할 수 있는 크기로 생성된다.
        int[] arr = new int[a.length + b.length];

        // 2. 배열 'a'의 내용을 새로운 배열 'arr'에 복사:
        // 첫 번째 배열 'a'의 모든 요소를 새로 만든 'arr' 배열의 시작 부분에 복사한다.
        // 'for' 반복문을 사용하여 'a'의 각 요소를 'arr'의 해당 위치에 하나씩 넣어준다.
        // 'i'는 'a' 배열의 인덱스(0부터 시작하는 위치)이자 'arr' 배열의 인덱스로 사용된다.
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i]; // 'a'의 i번째 요소를 'arr'의 i번째 위치에 복사한다.
        }
        // 예: a = {1, 2}
        //    - i=0: arr[0] = a[0] (arr[0] = 1)
        //    - i=1: arr[1] = a[1] (arr[1] = 2)
        //    -> 현재 arr은 {1, 2, ?, ?, ?} (나머지는 기본값인 0으로 채워져 있음)

        // 3. 배열 'b'의 내용을 새로운 배열 'arr'에 이어서 복사:
        // 두 번째 배열 'b'의 모든 요소를 'arr' 배열의 'a' 배열 내용 바로 뒤에 이어서 복사한다.
        // 여기서 중요한 것은 'arr' 배열에서의 올바른 위치(인덱스)를 계산하는 것이다.
        // 'b' 배열의 첫 번째 요소는 'arr' 배열에서 'a.length' 위치부터 시작해야 한다.
        for (int i = 0; i < b.length; i++) {
            // 'k' 변수를 사용하여 'b' 배열의 'i'번째 요소를 'arr' 배열의 어디에 넣을지 계산한다.
            // 'a.length'는 'a' 배열의 끝 위치를 의미하므로, 그 뒤에 'i'를 더하면
            // 'arr'에서 'b'의 요소가 들어갈 정확한 위치가 된다.
            // 예: a.length가 2인 경우
            //    - b의 첫 번째 요소 (i=0): k = 2 + 0 = 2. 즉, arr[2]에 b[0]을 넣는다.
            //    - b의 두 번째 요소 (i=1): k = 2 + 1 = 3. 즉, arr[3]에 b[1]을 넣는다.
            //    - ... 이런 식으로 이어간다.
            int k = a.length + i;
            arr[k] = b[i]; // 'b'의 i번째 요소를 계산된 'arr'의 k번째 위치에 복사한다.
        }
        // 예: a = {1, 2}, b = {3, 4, 5}
        //    - i=0: k=2, arr[2] = b[0] (arr[2] = 3)
        //    - i=1: k=3, arr[3] = b[1] (arr[3] = 4)
        //    - i=2: k=4, arr[4] = b[2] (arr[4] = 5)
        //    -> 최종 arr은 {1, 2, 3, 4, 5}가 된다! 존나 완벽하다!

        return arr; // 모든 요소 복사가 끝나면, 최종적으로 완성된 새로운 배열 'arr'을 반환한다.
    }

    // --- 2. `print()` 메소드: 주어진 정수 배열의 모든 요소를 화면에 보기 좋은 형태로 출력한다! ---
    // 'public static': 위 'concat' 메소드와 동일한 의미다.
    // 'void': 이 메소드는 어떤 값도 반환하지 않는다. 단순히 화면에 내용을 출력하는 '작업'만 수행한다.
    // 'print': 메소드의 이름이다.
    // '(int[] a)': 이 메소드가 출력할 대상인 정수형 배열 'a'를 매개변수로 받는다.
    public static void print(int[] a) {
        // 배열 출력 시작을 알리는 대괄호 '['를 출력한다.
        // 'System.out.print()'는 출력 후 줄을 바꾸지 않는다.
        System.out.print("[");

        // 배열 'a'의 모든 요소를 반복하며 출력한다.
        // 'i'는 배열의 인덱스(0부터 시작)다.
        // 'a.length'는 배열 'a'의 총 길이를 의미한다.
        // 반복문은 'i'가 0부터 시작해서 'a.length - 1'까지 실행된다 (배열의 마지막 인덱스).
        for (int i = 0; i < a.length; i++) {
            // 'a'의 현재 i번째 요소를 출력하고, 뒤에 공백 하나를 추가하여 숫자들을 구분한다.
            System.out.print(a[i] + " ");
        }

        // 배열 출력이 끝났음을 알리는 대괄호 ']'를 출력한다.
        System.out.println("]"); // 출력 후 줄 바꿈. (깔끔하게!)
    }

    // --- 3. 메인 메소드: `ArrayUtil` 클래스의 기능들을 테스트하는 시작점이다! ---
    public static void main(String[] args) {
        System.out.println("--- ArrayUtil 기능 테스트 시작! ---");

        // 테스트 배열들 생성
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6, 7};
        int[] arr3 = {8};
        int[] arrEmpty = {}; // 빈 배열도 테스트!

        System.out.print("첫 번째 배열: ");
        ArrayUtil.print(arr1); // arr1 출력: [1 2 3 ]

        System.out.print("두 번째 배열: ");
        ArrayUtil.print(arr2); // arr2 출력: [4 5 6 7 ]
        
        System.out.print("세 번째 배열: ");
        ArrayUtil.print(arr3); // arr3 출력: [8 ]

        System.out.print("빈 배열: ");
        ArrayUtil.print(arrEmpty); // arrEmpty 출력: []

        System.out.println("\n--- 배열 연결 테스트 (`concat`) ---");

        // arr1과 arr2 연결
        int[] concatResult1 = ArrayUtil.concat(arr1, arr2);
        System.out.print("arr1 + arr2 연결 결과: ");
        ArrayUtil.print(concatResult1); // 출력: [1 2 3 4 5 6 7 ]

        // arr2와 arr3 연결
        int[] concatResult2 = ArrayUtil.concat(arr2, arr3);
        System.out.print("arr2 + arr3 연결 결과: ");
        ArrayUtil.print(concatResult2); // 출력: [4 5 6 7 8 ]

        // arr1과 빈 배열 연결
        int[] concatResult3 = ArrayUtil.concat(arr1, arrEmpty);
        System.out.print("arr1 + 빈 배열 연결 결과: ");
        ArrayUtil.print(concatResult3); // 출력: [1 2 3 ]

        // 빈 배열과 arr1 연결
        int[] concatResult4 = ArrayUtil.concat(arrEmpty, arr1);
        System.out.print("빈 배열 + arr1 연결 결과: ");
        ArrayUtil.print(concatResult4); // 출력: [1 2 3 ]
        
        System.out.println("\n--- ArrayUtil 기능 테스트 끝! 존나 잘 돌아간다, 씨발! ---");
    }
}
