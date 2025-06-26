package com.excp; // 이 코드가 속한 폴더(패키지) 이름이다. (예외 처리 예제들을 모아두는 곳이다!)

// --- 사용자 정의 예외 클래스: InstallException (새로 추가됨!) ---
// '프로그램 설치 중 발생한 일반적인 예외'를 나타내는 존나 특별한 예외다!
// 이 예외는 다른 구체적인 예외(SpaceException, MemoryException)의 '원인(Cause)'을 포함할 수 있다.
class InstallException extends Exception {
	public InstallException(String msg) { // 생성자: 예외가 터질 때 메시지를 받아서 부모(Exception)에게 넘긴다.
		super(msg); // 부모 클래스(Exception)의 생성자를 호출해서 메시지를 저장한다.
	}
}

// --- 사용자 정의 예외 클래스: SpaceException ---
// 'Exception' 클래스를 상속받아서 만든, '설치 공간 부족' 상황을 위한 존나 특별한 예외다!
// 이렇게 자기만의 예외를 만들면 코드 읽기가 존나게 편해진다!
class SpaceException extends Exception {
	public SpaceException(String msg) { // 생성자: 예외가 터질 때 메시지를 받아서 부모(Exception)에게 넘긴다.
		super(msg); // 부모 클래스(Exception)의 생성자를 호출해서 메시지를 저장한다.
	}
}

// --- 사용자 정의 예외 클래스: MemoryException ---
// 'Exception' 클래스를 상속받아서 만든, '메모리 부족' 상황을 위한 존나 특별한 예외다!
class MemoryException extends Exception {
	public MemoryException(String msg) { // 생성자: 예외가 터질 때 메시지를 받아서 부모(Exception)에게 넘긴다.
		super(msg); // 부모 클래스(Exception)의 생성자를 호출해서 메시지를 저장한다.
	}
}

/*
 * ExceptionEx08 클래스: **'사용자 정의 예외'를 활용해서 프로그램 설치 중 발생할 수 있는 문제를 존나게 처리하는 예제다!**
 *
 * 핵심:
 * - **`InstallException` (새로 추가됨!):** 이제 설치와 관련된 모든 예외를 이놈 하나로 묶어서 관리할 수 있다!
 * - **`SpaceException`, `MemoryException`:** 니가 직접 만든 '사용자 정의 예외'다! (존나 똑똑함!)
 * - **`try-catch-finally` 블록 (복습이다, 씨발!):**
 * - `try`: 예외가 발생할 가능성이 있는 코드 (여기선 `startInstall()`, `copyFiles()`, 또는 `install()`)
 * - `catch (SpaceException se)`: 'SpaceException' 예외가 터지면 여기로 점프해서 처리한다.
 * - `catch (MemoryException me)`: 'MemoryException' 예외가 터지면 여기로 점프해서 처리한다.
 * - `catch (InstallException ie)`: 'InstallException' 예외를 잡는다. (이제 `main` 메소드에서는 이 예외를 잡는다!)
 * -> **다중 `catch` 블록을 써서 예외 종류별로 존나게 섬세하게 처리하는 거다!**
 * - `finally`: 예외가 터지든 안 터지든 **무조건 실행되는 블록!** (여기선 임시 파일 삭제)
 * - **`throws` 키워드:** 메소드가 어떤 예외를 던질 수 있다고 선언하는 거다.
 * - **`System.gc()`:** 'Garbage Collection'을 요청하는 거다. 메모리 정리해 달라고 부탁하는 건데, 실제로 바로 실행될지는 모른다!
 * - **`e.printStackTrace()`:** 예외가 어디서, 왜 터졌는지 존나게 자세히 출력해준다. (디버깅할 때 존나 유용!)
 * - **`ie.initCause(se);` (존나 중요!):** '예외 연결(Exception Chaining)'이다!
 * `InstallException`이라는 새로운 예외를 던지면서, 원래 무슨 예외(`SpaceException` 또는 `MemoryException`) 때문에
 * 이 예외가 발생했는지 '원인'을 알려주는 거다! 이렇게 하면 나중에 예외 추적하기가 존나게 편해진다!
 *
 * ★★★ `startInstall()` 메소드 로직의 함정 (존나 중요!): ★★★
 * - `if(!enoughSpace()) { throw new SpaceException("..."); }` : 공간이 없으면 `SpaceException`을 던진다.
 * - `if(enoughMemory()) { throw new MemoryException("..."); }` : 메모리가 '있으면' `MemoryException`을 던진다.
 * -> **원래 `enoughMemory()`는 '메모리가 충분한지'를 리턴해야 하므로, `false`일 때 `MemoryException`을 던지는 게 맞다!**
 * -> 니 코드의 `enoughMemory()`는 `true`를 반환하므로, 항상 `MemoryException`이 터지게 돼 있다, 씨발!
 * -> 실제로는 `if(!enoughMemory())` 처럼 `!`를 붙여서 '메모리가 충분하지 않으면' 예외를 던지도록 해야 한다.
 */

public class ExceptionEx08 {

	// ★★★ 메인 메소드: 프로그램의 시작점! (이제 `install()` 메소드를 호출한다!) ★★★
	public static void main(String[] args) {
		System.out.println("--- 프로그램 설치 시작 ---");
		try { // ★★★ 이제 `install()` 메소드에서 던져지는 'InstallException'을 여기서 잡는다! ★★★
			System.out.println("설치 준비 중...");
			install(); // 새로 추가된 `install()` 메소드를 호출한다! (여기서 내부적으로 예외가 터지고 다시 던져질 수 있다!)
			System.out.println("설치 완료!"); // `install()`에서 예외가 안 터졌을 때만 이 메시지가 나온다.
		} catch (InstallException ie) { // ★★★ `install()` 메소드에서 던져진 'InstallException'을 여기서 잡는다! ★★★
			System.out.println("에러 메시지: " + ie.getMessage()); // 예외 메시지 출력 (예: "설치중 예외 발생!!!!")
			ie.printStackTrace(); // 예외의 자세한 스택 트레이스 출력 (여기서 `initCause()`로 연결된 원래 예외까지 다 나온다! 존나 중요!)
			
			// 'getCause()'로 원래 예외(원인)를 가져올 수 있다!
			if (ie.getCause() instanceof SpaceException) {
				System.out.println("원인: 설치할 공간이 부족합니다. 공간을 확보한 후에 다시 설치하시기 바랍니다.");
			} else if (ie.getCause() instanceof MemoryException) {
				System.out.println("원인: 메모리가 부족합니다. 메모리를 확보한 후에 다시 설치하시길 바랍니다.");
				System.gc(); // 메모리 부족이면 GC 요청
			} else {
				System.out.println("원인 불명의 설치 예외가 발생했습니다.");
			}
		} finally { // ★★★ 예외 발생 여부와 상관없이 무조건 실행되는 블록! (메인 메소드의 finally!) ★★★
			deleteTempFiles(); // 임시 파일 삭제하는 메소드 호출. (뒷정리!)
		}
		System.out.println("--- 프로그램 설치 종료 ---");
	}

	// ★★★ 새로 추가된 `install()` 메소드: 설치 과정을 캡슐화하고 예외를 다시 던진다! ★★★
	// 이 메소드 안에서 `startInstall()`과 `copyFiles()`를 호출하고,
	// 여기서 발생하는 구체적인 예외(`SpaceException`, `MemoryException`)를 잡아서
	// 더 일반적인 `InstallException`으로 '예외를 연결하여 다시 던진다! (존나 중요!)
	static void install() throws InstallException { // 이 메소드는 'InstallException'을 던질 수 있다고 선언했다.

		try {
			startInstall(); // 여기서 `SpaceException`이나 `MemoryException`이 터질 수 있다.
			copyFiles();    // 파일 복사 메소드 호출
		} catch (SpaceException se) { // `SpaceException`이 터지면 여기서 잡는다.
			InstallException ie = new InstallException("설치 중 예외 발생!!!!"); // 새로운 'InstallException' 객체 생성.
			ie.initCause(se); // ★★★ 존나 중요! 'se'(`SpaceException`)를 이 'ie'의 '원인'으로 등록한다! ★★★
			throw ie; // 새로운 'InstallException'을 다시 던진다! (이 예외는 `main` 메소드에서 잡히게 된다.)
		} catch (MemoryException me) { // `MemoryException`이 터지면 여기서 잡는다.
			InstallException ie = new InstallException("설치 중 예외 발생!!!!"); // 새로운 'InstallException' 객체 생성.
			ie.initCause(me); // ★★★ 존나 중요! 'me'(`MemoryException`)를 이 'ie'의 '원인'으로 등록한다! ★★★
			throw ie; // 새로운 'InstallException'을 다시 던진다!
		} finally { // 이 `install()` 메소드의 `finally` 블록이다!
			deleteTempFiles(); // 임시 파일 삭제 (이 `install()` 메소드 안에서 예외가 터지든 안 터지든 무조건 실행!)
		}
	}

	// ★★★ 설치 시작 메소드: 공간/메모리 부족 시 예외 던진다! ★★★
	// 이 메소드는 `SpaceException`이나 `MemoryException`을 던질 수 있다고 선언했다.
	static void startInstall() throws SpaceException, MemoryException {
		System.out.println("공간 및 메모리 확인 중...");
		if(!enoughSpace()) { // ★★★ 설치할 공간이 '부족하면' (`enoughSpace()`가 `false`면) ★★★
			System.out.println("공간 부족 감지!");
			throw new SpaceException("설치할 공간이 부족하다, 씨발!"); // 'SpaceException' 예외를 던진다!
		}
		// ★★★ 니 코드의 이 부분은 논리 오류가 있다, 씨발! ★★★
		// `enoughMemory()`가 `true` (메모리 충분)일 때 `MemoryException`을 던지고 있다!
		// 아마 `!enoughMemory()` (메모리 부족)일 때 던지려던 거겠지?
		// 현재 `enoughMemory()`는 항상 `true`를 반환하므로, 항상 `MemoryException`이 터지게 돼 있다.
		if(enoughMemory()) { // ★★★ 현재 이 조건은 '메모리가 충분하면' 이라는 뜻이다! ★★★
			System.out.println("메모리 부족 감지! (로직 오류 가능성: 현재 enoughMemory()가 true를 반환함)");
			throw new MemoryException("메모리가 부족하다, 씨발!"); // 'MemoryException' 예외를 던진다!
		}
		System.out.println("공간 및 메모리 충분하다!");
	}
	
	// ★★★ 파일 복사 메소드 (지금은 비어있음) ★★★
	static void copyFiles() {
		System.out.println("파일 복사 중...");
		// 실제 파일 복사 로직이 여기에 들어간다.
		// 이 과정에서도 `IOException` 같은 예외가 터질 수 있다.
	}

	// ★★★ 임시 파일 삭제 메소드 (지금은 비어있음) ★★★
	// (이 메소드는 `main` 메소드의 `finally`에서도 호출되고, `install()` 메소드의 `finally`에서도 호출된다.)
	static void deleteTempFiles() {
		System.out.println("임시 파일 삭제 중...");
		// 임시 파일 삭제 로직이 여기에 들어간다.
	}

	// ★★★ 설치에 필요한 공간이 충분한지 확인하는 메소드 (지금은 항상 `false`를 반환) ★★★
	static boolean enoughSpace() {
		// 실제로는 디스크 여유 공간을 확인하는 복잡한 로직이 들어갈 거다.
		// 여기서는 테스트를 위해 항상 '공간 부족'(`false`)을 반환하도록 했다.
		return false; // 항상 공간이 부족하다고 가정!
	}
	
	// ★★★ 설치에 필요한 메모리가 충분한지 확인하는 메소드 (지금은 항상 `true`를 반환) ★★★
	static boolean enoughMemory() {
		// 실제로는 시스템 메모리 상태를 확인하는 복잡한 로직이 들어갈 거다.
		// 여기서는 테스트를 위해 항상 '메모리 충분'(`true`)을 반환하도록 했다.
		return true; // 항상 메모리가 충분하다고 가정!
	}
}