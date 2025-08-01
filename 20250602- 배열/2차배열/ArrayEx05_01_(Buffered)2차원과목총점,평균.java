package com.arraytwo; // 이 코드가 속한 폴더(패키지) 이름이다.

/* ArrayEx05_01 클래스: **여러 명의 과목 점수를 입력받아서 총점이랑 평균을 존나게 계산하는 예제!**

  핵심:
  - **문제:** 여러 학생(여기선 3명)의 국어, 영어, 수학 점수를 각각 입력받고,
  각 학생별 총점과 평균을 계산해서 출력한다!
  - **2차원 배열 `sub` 활용:** `sub[학생번호][과목번호]` 형태로 점수를 저장하고,
  각 학생의 마지막 칸은 총점 저장용으로 쓴다! (이게 존나 편하다!)
  
  - **`BufferedReader`:** 키보드 입력을 한 줄씩 읽어올 때 쓰는 존나 유용한 놈이다!
  - **`do-while` 문:** 점수가 0점 미만이거나 100점 초과면 다시 입력받게 하는 **존나 중요한 유효성 검사**를 할 때 쓴다!
  - **중첩 `for` 문:**
  - 바깥쪽 `for` 문 (`k`): 각 학생(사람)을 돌면서 처리한다!
  - 안쪽 `for` 문 (`i`): 각 학생의 과목 점수를 입력받고 총점을 계산한다!
  - **`printf()` 메소드:** 평균처럼 소수점 자리수 맞춰서 존나 깔끔하게 출력할 때 쓴다!
 */

import java.io.*; // 'BufferedReader'랑 'IOException' 쓰려면 이 새끼들을 불러와야 한다, 씨발!

public class ArrayEx05_01 {

    public static void main(String[] args) throws IOException { // 입출력 오류 생길 수 있으니 'throws IOException' 박아둔다!

       
        // ★★★ 사용자 입력받을 준비! (BufferedReader 버전!) ★★★
        // 'BufferedReader' 객체를 만들어서 시스템 입력(키보드)을 한 줄씩 읽어들인다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ★★★ 과목 이름 배열! ★★★
        // 사용자한테 어떤 점수를 입력받을지 알려줄 때 쓸 과목 이름들을 저장한다.
        String[] subname = { "국어점수", "영어점수", "수학점수" };

        // ★★★ 과목 점수 및 총점 저장 2차원 배열! ★★★
        // `new int[3][subname.length + 1]`은 3명의 학생(행), 각 과목(3개) + 총점(1개) = 총 4개의 열을 가진다.

        // 즉, 3행 4열짜리 2차원 배열이다!
        // sub[k][0]: k번째 학생의 국어점수
        // sub[k][1]: k번째 학생의 영어점수
        // sub[k][2]: k번째 학생의 수학점수
        // sub[k][3]: k번째 학생의 총점 (sub[k][sub[k].length - 1]에 해당!)

        int sub[][] = new int[3][subname.length + 1]; 

        // ★★★ 각 학생별 평균 저장 배열! ★★★

        // 학생 수(3명)만큼의 평균값을 저장할 `float` 배열을 만든다.

        float[] avg = new float[3];

        // --- 각 학생별 점수 입력 및 총점/평균 계산! (이중 for 문!) ---
        // ★★★ 바깥쪽 `for` 문: 학생(`k`)을 순회한다! (총 3명의 학생!) ★★★

        for (int k = 0; k < sub.length; k++) { // `k`는 학생 인덱스 (0, 1, 2)

            System.out.println("\n--- " + (k + 1) + "번째 학생 점수 입력 ---"); // 몇 번째 학생인지 알려준다.



            // ★★★ 안쪽 `for` 문: 각 학생의 과목(`i`) 점수를 입력받는다! (총점 칸 빼고!) ★★★
            // `sub[k].length - 1`은 현재 학생의 과목 수(3)를 의미한다! (총점 칸은 제외!)

            for (int i = 0; i < sub[k].length - 1; i++) {
                // ★★★ `do-while` 문으로 점수 유효성 검사! (존나 중요!) ★★★
                // 점수가 0점 미만이거나 100점 초과면 다시 입력받게 한다!

                do {
                   System.out.print(subname[i] + ":"); // 어떤 과목 점수를 입력할지 메시지 출력.

                    // ★★★ 각 과목별 점수 입력 및 형 변환! ★★★
                    // `br.readLine()`으로 읽은 문자열을 `Integer.parseInt()`로 숫자로 바꾼다!

                    sub[k][i] = Integer.parseInt(br.readLine()); 

                } while (sub[k][i] < 0 || sub[k][i] > 100); // 점수가 0~100 범위를 벗어나면 계속 반복!

                // ★★★ 입력받은 과목 점수를 해당 학생의 총점 칸에 누적! ★★★
                // `sub[k][sub[k].length - 1]`은 현재 `k`번째 학생의 총점 칸이다!
                sub[k][sub[k].length - 1] += sub[k][i]; // (예: sub[0][3], sub[1][3], sub[2][3]에 총점 누적!)
            } // end for(i)- 안쪽 for문 끝

         
            // --- 각 학생별 평균 계산! ---
            // 총점(`sub[k][sub[k].length - 1]`)을 과목 수(`sub[k].length - 1`)로 나눠서 평균을 구한다!
            // `(float)`으로 형 변환해야 소수점까지 제대로 나온다, 씨발!

            avg[k] = sub[k][sub[k].length - 1] / (float) (sub[k].length - 1);

        } // end for(k)- 바깥쪽 for문 끝
	    
        // --- 모든 학생의 총점과 평균 출력! ---
        System.out.println("\n--- 학생별 결과 ---");

        for (int k = 0; k < sub.length; k++) {

            System.out.println((k + 1) + "번째 학생 총점: " + sub[k][sub[k].length - 1]); // 각 학생의 총점 출력.
            System.out.printf((k + 1) + "번째 학생 평균: %.2f%n", avg[k]); // 각 학생의 평균을 소수점 두 자리까지 출력!

        }
       br.close();

    }
}
