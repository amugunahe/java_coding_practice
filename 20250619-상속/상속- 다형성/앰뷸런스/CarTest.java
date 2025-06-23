package com.polymorphism; // 이 클래스가 속한 패키지 이름입니다.

/*
 * 이 'CarTest' 클래스는 'main' 메소드를 포함하여 자바 프로그램의 시작점 역할을 합니다.
 * 주로 '다형성'과 '객체 형변환'의 원리를 보여주기 위한 테스트 코드입니다.
 *
 * 핵심 내용:
 * 1. 상속 관계가 아닌 클래스 간의 형변환은 컴파일 시점에 불가능합니다.
 * 2. 상속 관계에 있는 클래스 간에는 '업캐스팅(Upcasting)'과 '다운캐스팅(Downcasting)'이 가능합니다.
 * - 업캐스팅 (자식 -> 부모): 안전하며 컴파일러가 자동으로 처리합니다. (명시적 형변환 생략 가능)
 * - 다운캐스팅 (부모 -> 자식): 명시적 형변환이 필요하며, 실행 시 실제 인스턴스의 타입과 다르면 'ClassCastException'이 발생합니다.
 */
public class CarTest {

	public static void main(String[] args) { // 프로그램의 시작점인 main 메소드입니다.
		FireEngine f;   // 'FireEngine' 타입의 참조 변수 'f' 선언
		Ambulance a;    // 'Ambulance' 타입의 참조 변수 'a' 선언

		// --- 상속 관계가 아닌 클래스 간의 형변환 시도 (컴파일 에러 발생) ---
		// 아래 두 줄은 주석 처리되어 있지만, 만약 주석을 풀고 컴파일한다면 **컴파일 에러가 발생**합니다.
		// 이유: 'Ambulance'와 'FireEngine'은 서로 직접적인 상속 관계가 없기 때문입니다.
		// 자바는 컴파일 시점에 참조 변수의 타입만으로 형변환 가능 여부를 판단합니다.
		// a = (Ambulance)f; // 'FireEngine' 객체를 'Ambulance' 타입으로 변환 시도 -> 컴파일 에러!
		// f = (FireEngine)a; // 'Ambulance' 객체를 'FireEngine' 타입으로 변환 시도 -> 컴파일 에러!
		// 주석: "에러 : 상속 관계가 클래스 간의 형변환은 불가능함" (정확한 설명입니다.)

		Car car = null; // 'Car' 타입의 참조 변수 'car' 선언 및 null로 초기화

		FireEngine fe = new FireEngine(); // **'FireEngine' 객체 생성 후 'fe'가 참조합니다.**
		FireEngine fe2 = null;   // 'FireEngine' 타입의 참조 변수 'fe2' 선언 및 null로 초기화

		fe.water(); // 'fe'는 'FireEngine' 객체를 참조하므로, 'water()' 메소드 호출 가능.
		            // 결과: "water ~~~~~" 출력

		// --- 업캐스팅 (Upcasting): 자식 타입 -> 부모 타입 ---
		// 'fe' (FireEngine 타입의 객체)를 'car' (Car 타입의 참조 변수)에 할당합니다.
		// 'FireEngine'이 'Car'를 상속받았으므로, 'FireEngine' 객체는 'Car' 타입으로 간주될 수 있습니다.
		// 이것을 '업캐스팅'이라고 하며, 항상 안전하고 명시적 형변환 '(Car)fe'를 생략할 수 있습니다.
		car = fe; // car = (Car)fe; 와 동일합니다. (컴파일러가 자동으로 형변환해 줌)
		          // 이제 'car' 변수는 '실제 FireEngine 객체'를 가리키고 있지만, 변수 타입은 'Car'입니다.

		// car = fe; = new FireEngine(); // 이 주석은 이전 라인 'car = fe;'가 실제로 어떤 객체를 참조하는지 설명하는 것으로 보입니다.

		// car.water(); // 이 코드를 실행하면 **컴파일 에러가 발생**합니다.
		              // 이유: 'car' 변수의 타입은 'Car'입니다. 'Car' 클래스에는 'water()' 메소드가 정의되어 있지 않습니다.
		              // 비록 'car'가 실제 'FireEngine' 객체를 가리키고 있어도, 컴파일러는 변수 타입만 보고 메소드 호출 가능 여부를 판단합니다.
		              // 주석: "컴파일 에러: Car 클래스의 참조변수로 water()메소들을 호출할 수 없다."

		// --- 다운캐스팅 (Downcasting): 부모 타입 -> 자식 타입 ---
		// 'car' (현재 'Car' 타입이지만, 실제로는 'FireEngine' 객체를 가리키고 있음)를
		// 'FireEngine' 타입인 'fe2' 변수에 할당하기 위해 명시적으로 '(FireEngine)'으로 형변환합니다.
		// 이는 '다운캐스팅'입니다. 이 경우 실제 'car'가 참조하는 객체가 'FireEngine'이므로 안전하게 성공합니다.
		fe2 = (FireEngine)car; // 성공적인 다운캐스팅! (원래 FireEngine이었던 객체를 다시 FireEngine 타입으로 되돌림)
		                      // 주석: "다운 캐스팅 --> 형변환 생략 가능" (다운캐스팅은 형변환 생략 불가능, 명시적 형변환이 필요합니다.)
		                      // 이 주석은 오류가 있으니 "다운 캐스팅 --> 형변환 **필요**"로 이해하시면 좋습니다.

		fe2.water(); // 이제 'fe2'는 'FireEngine' 타입이므로 'water()' 메소드를 호출할 수 있습니다.
		            // 결과: "water ~~~~~" 출력

		System.out.println("-------------------------------"); // 구분선 출력

		// Car c = new Car(); // 이전 코드에서 순수한 Car 객체를 생성하던 라인이 주석 처리되어 있습니다.

		// **핵심 변화**: 'Car' 타입의 변수 'c'에 **'FireEngine' 객체**를 할당합니다. (업캐스팅)
		// 이제 'c'는 '실제 FireEngine 객체'를 가리키고 있습니다.
		Car c = new FireEngine();
		Car c2 = null; // 'Car' 타입의 참조 변수 'c2' 선언 및 null로 초기화
		FireEngine fee = null; // 'FireEngine' 타입의 참조 변수 'fee' 선언 및 null로 초기화

		c.drive(); // 'c'는 'Car' 타입이므로 'drive()' 메소드 호출 가능. (실제 객체는 FireEngine이지만 Car 메소드를 호출)
		           // 결과: "drive,~~~~~" 출력

		// fee = c; // 이 코드를 실행하면 **컴파일 에러가 발생**합니다.
		           // 이유: 'c'는 'Car' 타입이고, 'fee'는 'FireEngine' 타입입니다.
		           // 'Car'는 'FireEngine'의 부모 클래스이므로, 부모 타입을 자식 타입에 바로 할당하는 것은 (다운캐스팅)
		           // 명시적 형변환 없이는 불가능합니다. (업캐스팅의 반대)
		           // 주석: "이렇게하면 에러가 남"

		// --- 다운캐스팅 (Downcasting): 'c'가 실제 FireEngine 객체이므로 성공! ---
		// 'c' (현재 'Car' 타입이지만, **실제로는 'FireEngine' 객체를 가리키고 있음**)를
		// 'FireEngine' 타입인 'fee' 변수에 할당하기 위해 명시적으로 '(FireEngine)'으로 형변환합니다.
		// 이 라인은 **컴파일 및 실행 시 모두 정상적으로 작동합니다.**
		// 이전 코드와 달리, 'c'가 'new Car()'가 아니라 'new FireEngine()'으로 생성되었기 때문에 성공합니다.
		fee = (FireEngine)c;
		// 주석: "컴파일은 에러 없음, 하지만 실행시 에러발생", "형변환 오류 발생"
		// -> **이 주석은 이 특정 코드 라인에서는 이제 맞지 않습니다!**
		//    이전 코드 (`Car c = new Car();` 였을 때)에는 맞았지만,
		//    `Car c = new FireEngine();`으로 바뀌면서 **이제 이 라인에서는 `ClassCastException`이 발생하지 않습니다.**
		//    'c'가 실제 'FireEngine' 객체를 참조하고 있으므로, 'FireEngine'으로 다운캐스팅하는 것이 유효합니다.

		// 이 아래 코드들은 이제 ClassCastException 없이 정상적으로 실행됩니다.
		fee.drive(); // 'fee'는 'FireEngine' 타입이므로 'drive()' 메소드 호출 가능.
		             // (FireEngine은 Car를 상속받았으므로 drive() 메소드를 가집니다.)
		             // 결과: "drive,~~~~~" 출력

		c2 = fee; // 'fee' (FireEngine 타입)를 'c2' (Car 타입)에 할당합니다. (업캐스팅)
		          // 'FireEngine'은 'Car'의 자식이므로, 업캐스팅은 안전하며 자동입니다.
		          // 이제 'c2'는 'fee'가 가리키던 'FireEngine' 객체를 참조하게 됩니다.

		c2.drive(); // 'c2'는 'Car' 타입이므로 'drive()' 메소드 호출 가능.
		            // 결과: "drive,~~~~~" 출력

	}
}