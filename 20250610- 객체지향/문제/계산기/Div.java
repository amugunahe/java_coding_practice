package com.functionex; // 이 코드가 속한 폴더(패키지) 이름이다.

// --- Rect 클래스: 사각형 객체의 설계도 ---
// 사각형의 너비, 높이, 그리고 넓이를 계산하고 출력하는 기능을 담당한다.
class Rect {

	// 1. 멤버 변수 (속성)
	private int w, h; // ★★★ 중요! 'private'이라 이 클래스 안에서만 직접 쓴다. 너비(w), 높이(h) 저장. ★★★

	// 2. 사각형 넓이 계산 메서드
	public int area() { // 넓이 계산. 따로 입력값은 없다.
		return w * h; // 너비 * 높이 해서 넓이 반환.
	}

	// 3. 결과 출력 메서드
	public void write(int result) {
		System.out.println("결과: " + result); // 계산된 넓이 출력.
	}

	// 4. 너비, 높이 값 설정 메서드 (★★★ `this` 키워드 사용! ★★★)
	public void setData(int w, int h) { // 너비(w), 높이(h)를 외부에서 받아서 설정.
		this.w = w; // 'this.w'는 이 객체 멤버 변수 w, 그냥 'w'는 입력받은 w다. 이름 같을 때 헷갈리지 말라고 `this` 쓴다.
		this.h = h; // 'this.h'는 이 객체 멤버 변수 h, 그냥 'h'는 입력받은 h다.
	}

} // Rect 클래스 끝

// --- Sub 클래스: 뺄셈 객체의 설계도 ---
// 두 숫자 받아서 뺄셈 결과 계산 후 반환.
class Sub {
	// 1. 멤버 변수 (속성)
	private int a; // 첫 번째 숫자.
	private int b; // 두 번째 숫자.

	// 2. 값 설정 메서드
	public void setValue(int a, int b) { // 두 숫자 받아서 멤버 변수에 저장.
		this.a = a; // `this` 써서 멤버 변수 'a'에 입력 'a' 값 넣음.
		this.b = b; // `this` 써서 멤버 변수 'b'에 입력 'b' 값 넣음.
	}

	// 3. 뺄셈 계산 메서드
	public int calculate() { // 뺄셈 결과 반환.
		return a - b; // 'a'에서 'b' 뺀 값.
	}	
}

// --- Add 클래스: 덧셈 객체의 설계도 ---
// 두 숫자 받아서 덧셈 결과 계산 후 반환.
class Add {
	// 1. 멤버 변수 (속성)
	private int a; // 첫 번째 숫자.
	private int b; // 두 번째 숫자.

	// 2. 값 설정 메서드
	public void setValue(int a, int b) { // 두 숫자 받아서 멤버 변수에 저장.
		this.a = a; // `this` 써서 멤버 변수 'a'에 입력 'a' 값 넣음.
		this.b = b; // `this` 써서 멤버 변수 'b'에 입력 'b' 값 넣음.
	}

	// 3. 덧셈 계산 메서드
	public int calculate() { // 덧셈 결과 반환.
		return a + b; // 'a'와 'b' 더한 값.
	}
}

// --- Mul 클래스: 곱셈 객체의 설계도 ---
// 두 숫자 받아서 곱셈 결과 계산 후 반환.
class Mul {
	// 1. 멤버 변수 (속성)
	private int a; // 첫 번째 숫자.
	private int b; // 두 번째 숫자.

	// 2. 값 설정 메서드
	public void setValue(int a, int b) { // 두 숫자 받아서 멤버 변수에 저장.
		this.a = a; // `this` 써서 멤버 변수 'a'에 입력 'a' 값 넣음.
		this.b = b; // `this` 써서 멤버 변수 'b'에 입력 'b' 값 넣음.
	}

	// 3. 곱셈 계산 메서드
	public int calculate() { // 곱셈 결과 반환.
		return a * b; // 'a'와 'b' 곱한 값.
	}
}

// --- Div 클래스: 나눗셈 객체의 설계도 (★★★ try-catch로 0 나누기 막음! ★★★) ---
// 두 숫자 받아서 나눗셈 결과 계산 후 반환.
class Div {
	// 1. 멤버 변수 (속성)
	private int a; // 첫 번째 숫자.
	private int b; // 두 번째 숫자.
	
	// 2. 값 설정 메서드
	public void setValue(int a, int b) { // 두 숫자 받아서 멤버 변수에 저장.
		this.a = a; // `this` 써서 멤버 변수 'a'에 입력 'a' 값 넣음.
		this.b = b; // `this` 써서 멤버 변수 'b'에 입력 'b' 값 넣음.
	}
	
	// 3. 나눗셈 계산 메서드 (★★★ 0으로 나누면 에러 메시지 띄움! ★★★)
	public int calculate() {
		int res = 0; // 결과값을 저장할 변수. 0으로 초기화.
		
		try { // 여기 안의 코드를 실행하다가 문제가 생길 경우를 대비.
			res = a / b; // 'a'를 'b'로 나눈 값 (정수 나눗셈이라 소수점 버림).
		} catch (ArithmeticException e) { // 'ArithmeticException' (0으로 나눌 때 발생하는 에러)이 터지면
			System.out.println("0으로 나눌 수 없습니다."); // 이 메시지를 출력.
		}
		return res; // 계산 결과 반환 (0으로 나누면 catch 블록 실행 후 초기값 0 반환됨).
	}	
}

// --- Calc 클래스: 메인 계산기 프로그램 ---
// 사용자한테 두 숫자랑 연산자 받아서 계산하는 메인 프로그램.
import java.util.*; // Scanner 쓰려고 가져옴.

public class Calc { // 'Calc' 클래스 정의.

    public static void main(String[] args) { // 프로그램 시작점! 여기서부터 실행된다.

        // 1. 입력 도구 'Scanner' 준비
        Scanner sc = new Scanner(System.in);

        // 2. 입력 요청 메시지 출력
        System.out.print("두 정수와 연산자 입력: ");

        // 3. 숫자 2개, 연산자 1개 입력받기
        int a = sc.nextInt(); // 첫 번째 정수 'a'.
        int b = sc.nextInt(); // 두 번째 정수 'b'.
        char c = sc.next().charAt(0); // 연산자 'c'. 입력받은 문자열의 첫 글자만 쓴다. (예: "10 20 +" 입력 시, c는 '+')

        // 4. 연산자('c')에 따라 다른 계산 클래스 호출
        switch(c) {
        // 5. '+'인 경우: 덧셈 클래스 'Add' 사용
        case '+':
            Add add = new Add(); // Add 객체(덧셈 붕어빵) 만들기.
            add.setValue(a, b);  // Add 객체에 숫자 'a', 'b' 설정.
            System.out.println("결과: " + add.calculate()); // Add 객체로 덧셈 계산하고 결과 출력.
            break; // 여기서 스위치 종료.

        // 6. '-'인 경우: 뺄셈 클래스 'Sub' 사용
        case '-':
            Sub sub = new Sub(); // Sub 객체(뺄셈 붕어빵) 만들기.
            sub.setValue(a, b);  // Sub 객체에 숫자 'a', 'b' 설정.
            System.out.println("결과: " + sub.calculate()); // Sub 객체로 뺄셈 계산하고 결과 출력.
            break;

        // 7. '*'인 경우: 곱셈 클래스 'Mul' 사용
        case '*':
            Mul mul = new Mul(); // Mul 객체(곱셈 붕어빵) 만들기.
            mul.setValue(a, b);  // Mul 객체에 숫자 'a', 'b' 설정.
            System.out.println("결과: " + mul.calculate()); // Mul 객체로 곱셈 계산하고 결과 출력.
            break;

        // 8. '/'인 경우: 나눗셈 클래스 'Div' 사용 (★★★ 0으로 나누기 막는 거 존나 중요! ★★★)
        case '/':
            // 'Calc'에서도 0 나누기 체크하지만, 'Div' 내부에서도 예외 처리(try-catch)를 해서 더 튼튼하다.
            Div div = new Div(); // Div 객체(나눗셈 붕어빵) 만들기.
            div.setValue(a, b);  // Div 객체에 숫자 'a', 'b' 설정.
            System.out.println("결과: " + div.calculate()); // Div 객체로 나눗셈 계산하고 결과 출력.
            break;

        // 9. 알 수 없는 연산자인 경우:
        default:
            System.out.println("잘못된 연산자 입니다."); // 잘못된 연산자 입력 시 메시지 출력.
        }
        
        // 스캐너 다 썼으면 꼭 닫아라. (리소스 정리)
        sc.close();
    }
}

// --- ThisEx 클래스: 원본 Rect 예제를 위한 실행 시작점 ---
// Calc 클래스에 메인 함수가 있어서 이 ThisEx는 보통 직접 실행 안 된다.
// Rect 클래스 동작만 보고 싶으면 이 클래스를 직접 실행해라.
public class ThisEx {

	// 메인 메소드
	public static void main(String[] args) {

		// 1. Rect 객체('사각형' 객체) 만들기
		Rect r = new Rect();

		// 2. 사각형 너비, 높이 설정
		r.setData(10, 5); // Rect 객체 'r'의 w는 10, h는 5로 설정.

		// 3. 사각형 넓이 계산
		int areaResult = r.area(); // 'r' 객체로 넓이(50) 계산.

		// 4. 결과 출력
		r.write(areaResult); // "결과: 50" 출력.
	}
}
