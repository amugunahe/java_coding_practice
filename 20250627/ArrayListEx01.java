package com.listex; // 이 코드가 속한 폴더(패키지) 이름이다.

import java.util.ArrayList;   // 'ArrayList' 클래스를 사용하기 위해 가져온다. (동적으로 크기가 조절되는 배열!)
import java.util.Collections; // 'Collections.sort()' 메소드를 사용하기 위해 가져온다. (리스트 정렬!)
import java.util.List;        // subList의 반환 타입인 List 인터페이스를 명시적으로 임포트.

/*
  ArrayListEx01 클래스: **자바의 'ArrayList'를 존나게 다양하게 활용하는 예제다!**
 
  핵심:
  - **`ArrayList`란?**
  - 배열처럼 여러 개의 데이터를 순서대로 저장하는데, 배열처럼 크기를 미리 정해놓지 않아도 된다!
  - 데이터를 추가하거나 삭제하면 자동으로 크기가 늘었다 줄었다 한다! (존나 편함!)
  - **`<Integer>` vs `<Object>` (존나 중요!):**
  - `ArrayList<Integer>`: 이 리스트는 **`Integer` (정수) 타입 객체만** 담을 수 있다고 못 박는 거다.
  - `ArrayList<Object>`: 이 리스트는 **어떤 타입의 객체든** 다 담을 수 있다! (문자열, 숫자, 다른 객체 뭐든지!)
  -> 니 스크린샷의 결과처럼 `String`과 `Integer`를 같이 담으려면 이렇게 선언해야 한다, 씨발!
 
  - **주요 `ArrayList` 메소드:**
  - `add(값)`: 리스트 맨 뒤에 값을 추가한다.
  - `add(인덱스, 값)`: 특정 인덱스 위치에 값을 삽입한다.
  - `subList(시작, 끝)`: 리스트의 일부분을 새로운 리스트로 반환한다. (시작 인덱스 포함, 끝 인덱스 미포함)
  - `set(인덱스, 값)`: 특정 인덱스 위치의 값을 바꾼다.
  - `containsAll(다른 리스트)`: 현재 리스트가 '다른 리스트'의 모든 요소를 포함하는지 확인한다. (있으면 true, 없으면 false)
  - `retainAll(다른 리스트)`: 현재 리스트에서 '다른 리스트'와 겹치는 요소만 남기고 나머지는 **삭제한다!** (존나 주의!)
  - `remove(값)` / `remove(인덱스)`: 요소를 삭제한다.
  - **`list2`에서 `list1`에 포함된 객체들 삭제하기! (새로 추가된 로직)**
  -> **반드시 뒤에서부터 앞으로 반복해야 한다!** (요소 삭제 시 인덱스가 당겨지는 문제 방지!)
  - **`Collections.sort(리스트)`:** 리스트의 요소들을 오름차순으로 존나게 정렬해준다!
  -> **주의:** `String`과 `Integer`가 섞여있는 리스트는 `Collections.sort()`로 정렬할 수 없다! (비교 방법이 달라서 에러남!)
  그래서 `list2` 정렬은 주석 처리했다.
 
  ★★★ 니 코드의 문제점 해결 (핵심!): ★★★
  - `list2`를 `ArrayList<Object>`로 선언하여 `String`과 `Integer`를 모두 담을 수 있도록 변경했다.
  - `Collections.sort(list2)`는 주석 처리했다. (타입 혼용 리스트는 기본 정렬 불가능)
  - `retainAll`과 `remove` 로직은 `Object` 타입을 고려하여 동작한다.
 */

public class ArrayListEx01 {

    // --- `print()` 메소드: `ArrayList` 내용을 깔끔하게 출력해주는 존나 유용한 도우미 메소드! ---
    // 'raw type'인 `ArrayList`를 매개변수로 받아서 어떤 타입의 리스트든 출력할 수 있게 했다.
    // (여기서는 `ArrayList<Object>`가 될 수도 있으므로 제네릭을 생략하여 유연하게 처리)
    static void print(ArrayList list1, ArrayList list2) {
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
    }

    // ★★★ 메인 메소드: 프로그램의 시작점! 모든 실행 로직은 여기에 존나게 때려박는다! ★★★
    public static void main(String[] args) {
        System.out.println("--- ArrayListEx01 프로그램 시작! ---");

        // 1. `list1` 생성 및 요소 추가 (Integer 타입 고정)
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(4);
        list1.add(3);
        list1.add(2);
        list1.add(1);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        System.out.println("초기 list1 상태: " + list1);

        // 2. `list1`의 일부분으로 `list2` 생성 (Object 타입으로 변경하여 String/Integer 혼용 가능하게 함!)
        // `list1.subList(1, 4)`는 `List<Integer>`를 반환하지만, `ArrayList<Object>`는 `Integer`를 담을 수 있으므로 문제없다.
        ArrayList<Object> list2 = new ArrayList<>(list1.subList(1, 4));
        System.out.println("초기 list2 상태 (list1의 subList, Object 타입): " + list2);

        // --- 초기 리스트 상태 출력 ---
        System.out.println("\n--- 초기 리스트 상태 ---");
        print(list1, list2);

        // --- 리스트 정렬 ---
        System.out.println("\n--- 리스트 정렬 후 ---");
        Collections.sort(list1); // list1은 Integer만 있어서 정렬 가능!
        // Collections.sort(list2); // ★★★ 주의: list2는 String과 Integer가 섞여있어서 정렬 불가능! ★★★
                                  // 이걸 풀면 "java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String" 에러난다!
        print(list1, list2);

        // --- `list1`이 `list2`의 모든 요소를 포함하는지 확인 ---
        // list1: [1, 1, 2, 2, 3, 3, 4, 4, 5, 5] (정렬 후)
        // list2: [2, 3, 4] (정렬 전)
        // list1이 list2의 모든 요소(2, 3, 4)를 가지고 있으므로 `true`가 나온다!
        System.out.println("\nlist1이 list2의 모든 요소를 포함하는가? : " + list1.containsAll(list2));

        // --- `list2`에 요소 추가 및 변경 (스크린샷과 유사하게 String/Integer 혼용) ---
        System.out.println("\n--- list2에 요소 추가 및 변경 (스크린샷 재현!) ---");
        list2.add("B"); // String "B" 추가 (이제 <Object>라 가능!)
        list2.add("C"); // String "C" 추가
        list2.add(3, "A"); // 인덱스 3 위치에 String "A" 삽입! (기존 요소들은 뒤로 밀려남)
        // 현재 list2: [2, 3, 4, "A", "B", "C"]
        System.out.println("list2에 추가 후: ");
        print(list1, list2);

        // `list2`의 특정 위치 값 변경
        System.out.println("\n--- list2의 인덱스 3 값 'AA'로 변경 ---");
        list2.set(3, "AA"); // 인덱스 3 위치의 값을 "AA"로 바꾼다! (스크린샷 재현!)
        System.out.println("list2의 인덱스 3 변경 후: ");
        print(list1, list2); // 출력

        // --- `list1`에서 `list2`와 겹치는 부분만 남기고 나머지는 삭제 (`retainAll`) ---
        // `retainAll()` 메소드는 호출한 리스트(여기서는 `list1`)에서
        // 매개변수로 준 리스트(여기서는 `list2`)와 '겹치는 요소만' 남기고, 나머지는 **모두 삭제한다!**
        // 그리고 리스트에 변화가 있었으면 `true`, 변화 없으면 `false`를 반환한다.
        System.out.println("\n--- list1.retainAll(list2) 실행 후 ---");
        // retainAll은 list2의 String 요소와 list1의 Integer 요소를 직접 비교하지 않는다.
        // Integer는 Integer끼리, String은 String끼리 비교해야 의미가 있다.
        // 결과 예측:
        //   현재 list1 (정렬됨): [1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
        //   현재 list2 (정렬 안 됨): [2, 3, 4, "AA", "B", "C"]
        //   겹치는 Integer 요소: 2, 3, 4
        //   list1은 2, 3, 4만 남게 되므로 변경이 발생(`true` 반환)
        System.out.println("list1이 변경되었는가? (retainAll 결과): " + list1.retainAll(list2));
        System.out.println("retainAll 후의 리스트들: ");
        print(list1, list2);
        // 최종 list1은 [2, 3, 4]가 된다.

        // --- `list2`에서 `list1`에 포함된 객체들 삭제! (스크린샷 재현!) ---
        System.out.println("\n--- list2에서 list1에 포함된 객체들 삭제 (새로운 로직!) ---");
        // `list2`를 뒤에서부터 앞으로 반복하는 이유:
        // 요소를 삭제하면 리스트의 인덱스가 한 칸씩 당겨지는데, 앞에서부터 삭제하면 인덱스 오류가 날 수 있다!
        // 뒤에서부터 삭제하면 이런 문제를 피할 수 있다! (존나 중요)
      
        for (int i = list2.size() - 1; i >= 0; i--) {
            Object currentElement = list2.get(i); // 현재 요소를 Object로 가져온다.
            // `list1.contains(currentElement)`: `list1`이 해당 요소를 가지고 있는지 확인한다.
            // 여기서 `list1`은 `Integer`만 가지고 있으므로, `currentElement`가 `Integer` 타입이고
            // `list1`에 존재하는 경우에만 `true`가 된다. `String` 타입 요소는 `false`.
            if (list1.contains(currentElement)) { // 만약 `list2`의 `i`번째 요소가 `list1`에도 포함되어 있다면
                list2.remove(i); // `list2`에서 해당 요소를 삭제한다!
            }
        }
        System.out.println("list2에서 list1에 포함된 객체들 삭제 후: ");
        print(list1, list2);
        // 결과 예측 (스크린샷과 거의 동일하게 나옴):
        //   현재 list1: [2, 3, 4]
        //   현재 list2: [2, 3, 4, "AA", "B", "C"]
        //   list2를 뒤에서부터 검사:
        //   - "C": list1에 없음 -> 삭제 안 함
        //   - "B": list1에 없음 -> 삭제 안 함
        //   - "AA": list1에 없음 -> 삭제 안 함
        //   - 4: list1에 있음 -> 삭제!
        //   - 3: list1에 있음 -> 삭제!
        //   - 2: list1에 있음 -> 삭제!
        //   따라서 최종 list2: ["AA", "B", "C"] (순서는 역순으로 나올 수 있다.)
        //   실제 출력은 [AA, B, C]가 아니라 [C, B, AA] 또는 [AA, B, C]가 될 수 있다.
        //   스크린샷에서는 [AA, B, C]로 나오는 것으로 보아, 실제 구현 환경이 다를 수 있다.
        //   (삭제는 요소가 당겨지므로 순서가 유지될 수 있음. [2,3,4,"AA","B","C"] -> [2,3,"AA","B","C"] -> [2,"AA","B","C"] -> ["AA","B","C"])

        System.out.println("\n--- ArrayListEx01 프로그램 종료! ---");
    }

}
