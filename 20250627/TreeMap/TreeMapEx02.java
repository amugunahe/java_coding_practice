package com.listex;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

// Sung 클래스 정의: 학생의 이름과 국어, 영어, 수학 점수를 저장하는 클래스다.
class Sung {
    // private 필드: 외부에서 직접 접근 못하게 막아놨다.
    private String name;
    private int kor, eng, mat; // 국어, 영어, 수학 점수
    // private int tot; // 총점은 그때그때 계산하는 게 좋으니 필드로 두지 않는 게 일반적이다.

    // 생성자: Sung 객체를 만들 때 이름과 점수들을 초기화한다.
    // 생성자는 클래스 안에 있어야 한다, 이 새끼야!
    public Sung(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat; // 수학 점수도 초기화해야지! 니가 빼먹었잖아!
    }

    // 총점을 계산해서 반환하는 메소드다.
    // 이 메소드도 클래스 안에 있어야 한다!
    public int getTot() {
        return kor + eng + mat;
    }

    // private 필드에 접근하려면 public getter 메소드를 만들어야 한다, 이 새끼야!
    public String getName() {
        return name;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMat() {
        return mat;
    }
}

// TreeMapEx02 메인 클래스다.
public class TreeMapEx02 {

    public static void main(String[] args) {
        // TreeMap 생성: 키는 String (학번 같은 거), 값은 Sung 객체다.
        // TreeMap은 키를 기준으로 자동 정렬된다. (오름차순)
        TreeMap<String, Sung> map = new TreeMap<String, Sung>();

        // 데이터 추가: put 메소드로 키-값 쌍을 넣는다.
        // "3333" 키는 두 번 들어가는데, 나중에 넣은 "호호호"로 덮어씌워진다.
        map.put("3333", new Sung("김말자", 80, 80, 70));
        map.put("2222", new Sung("이순신", 100, 100, 100));
        map.put("1111", new Sung("후후후", 90, 80, 80));
        map.put("4444", new Sung("히히히", 90, 90, 90));
        map.put("3333", new Sung("호호호", 70, 80, 70)); // "김말자"가 "호호호"로 바뀐다.

        // System.out.println(map); // 이 주석 풀면 map 객체의 toString() 결과가 출력된다.

        String key;
        // map의 모든 키를 Set 형태로 가져온다. (정렬된 순서대로)
        Set<String> set = map.keySet();
        // Set을 순회하기 위한 Iterator를 얻는다.
        Iterator<String> it = set.iterator();

        // 결과 출력 헤더: 깔끔하게 보이게 미리 찍어준다.
        System.out.printf("%7s%10s %5s%5s%5s%5s%n", "학번", "이름", "국어", "영어", "수학", "총점");
        System.out.println("--------------------------------------------------");

        // Iterator를 사용해서 모든 엔트리를 순회한다.
        while (it.hasNext()) {
            key = it.next(); // 다음 키를 가져온다.
            Sung data = map.get(key); // 해당 키에 매핑된 Sung 객체를 가져온다.

            // printf를 사용해서 형식을 맞춰 출력한다.
            // %7s: 문자열 7칸 오른쪽 정렬
            // %10s: 문자열 10칸 오른쪽 정렬
            // %5d: 정수 5칸 오른쪽 정렬
            System.out.printf("%7s%10s %5d%5d%5d%5d%n",
                    key, data.getName(), data.getKor(), data.getEng(),
                    data.getMat(), data.getTot()); // getter 메소드 써야지!
        }
    }
}
