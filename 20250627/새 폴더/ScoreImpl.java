package com.vscore;

import java.util.Collections; // 정렬을 위해 임포트한다.
import java.util.Comparator;   // 정렬 기준을 위해 임포트한다.
import java.util.List;         // List 인터페이스를 사용하기 위해 임포트한다.
import java.util.Scanner;      // 사용자 입력을 위해 임포트한다.
import java.util.Vector;       // 니가 Vector를 썼으니 Vector를 그대로 쓴다.

// ScoreImpl 클래스: Score 인터페이스를 구현하는 실제 로직이다.
// Vector를 사용해서 학생 정보를 저장하고 관리한다.
public class ScoreImpl implements Score {

	
	// 1. ArrayList 사용 (가장 일반적이고 빠르다)
	// private List<ScoreVo> dataStore = new ArrayList<>();

	// 2. Vector 사용 (ArrayList랑 비슷하지만, 멀티스레드 환경에서 안전하다. 좀 느리다.)
	// private List<ScoreVo> dataStore = new Vector<>();

	// 3. Map 사용 (학번을 키로 써서 존나 빠르게 찾을 수 있다. 현재 활성화된 코드다.)
	// private Map<String, ScoreVo> dataStore = new HashMap<>();
	
	
	// private List<ScoreVO> vlist = new ArrayList<>();
    private Vector<ScoreVo> vlist = new Vector<>(); // 학생 정보를 저장할 Vector다.
    private Scanner sc = new Scanner(System.in);    // 사용자 입력을 받을 Scanner다.

    // 학번으로 학생 정보를 읽어오는 헬퍼 메소드다.
    // 이 메소드는 인터페이스에 없지만, 내부적으로 자주 쓰이니 만들었다.
    public ScoreVo readScore(String hak) {
        for (ScoreVo temp : vlist) {
            if (temp.getHak().equals(hak)) { // 학번이 일치하면 해당 ScoreVo 객체를 반환한다.
                return temp;
            }
        }
        return null; // 못 찾으면 null 반환.
    }

    @Override
    public void insert() {
        System.out.println("\n--- 학생 정보 추가 ---");
        String hak;
        System.out.print("학번: ");
        hak = sc.next();

        ScoreVo temp = readScore(hak); // 학번이 이미 존재하는지 확인한다.
        if (temp != null) { // 학번이 이미 존재한다면
            System.out.println("오류: 이미 등록된 학번입니다. (학번: " + hak + ")\n");
            return; // 추가 실패!
        }

        // 새로운 ScoreVo 객체를 생성하고 정보들을 입력받아 설정한다.
        ScoreVo vo = new ScoreVo();
        vo.setHak(hak); // 학번은 이미 받았으니 설정한다.

        System.out.print("이름: ");
        vo.setName(sc.next());
        System.out.print("생년 월일 (YYMMDD): ");
        vo.setBirth(sc.next());

        System.out.print("국어 점수: ");
        vo.setKor(sc.nextInt()); // 점수 입력 시 자동으로 총점, 평균이 계산된다.
        System.out.print("영어 점수: "); // System.out.println이 아니라 System.out.print다, 이 새끼야!
        vo.setEng(sc.nextInt());
        System.out.print("수학 점수: ");
        vo.setMat(sc.nextInt());

        vlist.add(vo); // Vector에 학생 정보를 추가한다.

        System.out.println("데이터 입력 완료.........\n");
    }

    @Override
    public void update() {
        System.out.println("\n--- 학생 정보 수정 ---");
        System.out.print("수정할 학생의 학번 입력: ");
        String hak = sc.next();

        ScoreVo existingVo = readScore(hak); // 학번으로 기존 학생을 찾는다.
        if (existingVo == null) {
            System.out.println("오류: 해당 학번의 학생이 존재하지 않습니다. (학번: " + hak + ")\n");
            return; // 수정 실패!
        }
        
    
        System.out.println("수정할 학생 정보 (현재: " + existingVo.toString() + ")");
        System.out.print("새 이름 입력 (현재: " + existingVo.getName() + "): ");
        existingVo.setName(sc.next()); // 이름 수정

        System.out.print("새 생년월일 입력 (현재: " + existingVo.getBirth() + "): ");
        existingVo.setBirth(sc.next()); // 생년월일 수정

        System.out.print("새 국어 점수 입력 (현재: " + existingVo.getKor() + "): ");
        existingVo.setKor(sc.nextInt()); // 국어 점수 수정 (총점/평균 자동 재계산)

        System.out.print("새 영어 점수 입력 (현재: " + existingVo.getEng() + "): ");
        existingVo.setEng(sc.nextInt()); // 영어 점수 수정

        System.out.print("새 수학 점수 입력 (현재: " + existingVo.getMat() + "): ");
        existingVo.setMat(sc.nextInt()); // 수학 점수 수정

        System.out.println("학생 정보가 성공적으로 수정되었습니다.\n");
    }

    @Override
    public void delete() {
        System.out.println("\n--- 학생 정보 삭제 ---");
        System.out.print("삭제할 학생의 학번 입력: ");
        String hak = sc.next();

        ScoreVo existingVo = readScore(hak); // 학번으로 학생을 찾는다.
        if (existingVo == null) {
            System.out.println("오류: 해당 학번의 학생이 존재하지 않습니다. (학번: " + hak + ")\n");
            return; // 삭제 실패!
        }

        vlist.remove(existingVo); // Vector에서 해당 객체를 삭제한다.
        System.out.println("학생 정보가 성공적으로 삭제되었습니다.\n");
    }

    @Override
    public void listAll() {
        System.out.println("\n--- 전체 학생 정보 출력 ---");
        if (vlist.isEmpty()) {
            System.out.println("등록된 학생 정보가 없습니다.\n");
            return;
        }

        // 학번 순으로 정렬해서 출력하자. Vector는 Collections.sort로 정렬한다.
        // Comparator를 사용해서 학번(String) 기준으로 정렬한다.
        Collections.sort(vlist, new Comparator<ScoreVo>() {
            @Override
            public int compare(ScoreVo o1, ScoreVo o2) {
                return o1.getHak().compareTo(o2.getHak()); // String 비교는 compareTo를 쓴다.
            }
        });

        // 헤더 출력 (ScoreVo의 toString() 형식에 맞춰서)
        System.out.printf("%7s%10s%7s%5s%5s%5s%5s%6s%n", "학번", "이름", "생년월일", "국어", "영어", "수학", "총점", "평균");
        System.out.println("------------------------------------------------------------------");
        for (ScoreVo vo : vlist) { // visit.iterator() 이딴 거 쓰지 마라, 이 새끼야! vlist다!
            System.out.println(vo.toString()); // ScoreVo의 toString() 메소드를 사용한다.
        }
        System.out.println("------------------------------------------------------------------\n");
    }

    @Override
    public void searchHak() {
        System.out.println("\n--- 학번으로 학생 검색 ---");
        System.out.print("검색할 학번 입력: ");
        String hak = sc.next();

        ScoreVo foundVo = readScore(hak); // 학번으로 학생을 찾는다.
        if (foundVo != null) {
            System.out.println("--- 검색 결과 ---");
            System.out.printf("%7s%10s%7s%5s%5s%5s%5s%6s%n", "학번", "이름", "생년월일", "국어", "영어", "수학", "총점", "평균");
            System.out.println("------------------------------------------------------------------");
            System.out.println(foundVo.toString());
            System.out.println("------------------------------------------------------------------\n");
        } else {
            System.out.println("오류: 해당 학번의 학생을 찾을 수 없습니다. (학번: " + hak + ")\n");
        }
    }

    @Override
    public void searchName() {
        System.out.println("\n--- 이름으로 학생 검색 ---");
        System.out.print("검색할 이름 입력: ");
        String name = sc.next();

        List<ScoreVo> foundList = new Vector<>(); // 검색된 학생들을 담을 리스트다.
        for (ScoreVo vo : vlist) {
            if (vo.getName().startsWith(name)) { // 이름이 일치하면 리스트에 추가한다.
                foundList.add(vo);
            }
        }

        if (foundList.isEmpty()) {
            System.out.println("오류: 해당 이름의 학생을 찾을 수 없습니다. (이름: " + name + ")\n");
        } else {
            System.out.println("--- 검색 결과 (이름: " + name + ") ---");
            System.out.printf("%7s%10s%7s%5s%5s%5s%5s%6s%n", "학번", "이름", "생년월일", "국어", "영어", "수학", "총점", "평균");
            System.out.println("------------------------------------------------------------------");
            // 검색된 학생들을 학번 순으로 정렬해서 출력한다.
            Collections.sort(foundList, new Comparator<ScoreVo>() {
                @Override
                public int compare(ScoreVo o1, ScoreVo o2) {
                    return o1.getHak().compareTo(o2.getHak());
                }
            });
            for (ScoreVo vo : foundList) {
                System.out.println(vo.toString());
            }
            System.out.println("------------------------------------------------------------------\n");
        }
    }
}
