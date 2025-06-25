package com.innerex; // 이 코드가 속한 패키지 이름이다.

// 필요한 AWT 컴포넌트 및 이벤트 관련 클래스들을 존나게 불러온다!
import java.awt.*;   

// AWT의 기본 컴포넌트들 (Frame, TextField, FlowLayout 등)
import java.awt.event.*;    // AWT 이벤트 처리 관련 클래스들 (ActionEvent, ActionListener 등)

/*
  ActionEventEx 클래스: **AWT를 사용해서 간단한 액션 이벤트를 존나게 처리하는 예제다!**
 
  핵심:
  - **`Frame`을 상속받았다!** (창(윈도우)을 만들 수 있다!)
  - **`ActionListener` 인터페이스를 구현했다!** (액션 이벤트를 받아서 처리할 수 있게 해준다! 존나 중요!)
  - **`TextField`:** 사용자한테 텍스트 입력을 받을 수 있는 컴포넌트다.
  - **`actionPerformed()` 메소드:** 텍스트 필드에서 엔터 키를 누르거나, 버튼을 클릭하는 등
  '액션 이벤트'가 발생했을 때 이 메소드가 존나게 자동으로 호출된다!
  - **`e.getSource() == tf`:** 어떤 컴포넌트에서 이벤트가 발생했는지 확인하는 거다.
  - **`tf.getText()`:** 텍스트 필드에 입력된 문자열을 가져온다.
  - **`tf.setText("")`:** 텍스트 필드의 내용을 지운다.
 */

public class ActionEventEx extends Frame implements ActionListener { 

	private TextField tf; // 텍스트 필드 객체를 멤버 변수로 선언한다. (이 클래스 안에서 어디서든 쓸 수 있게!)
	
	// --- 생성자: 객체를 만들 때 초기화하는 부분! ---
	public ActionEventEx() { // ★★★ 오류 수정! ActionEventEx()P -> ActionEventEx() ★★★
		super("액션 이벤트!!_최종 수정"); // 부모 Frame 클래스의 생성자 호출! 창 제목을 설정한다.
		
		tf = new TextField(10); // 10글자 너비의 텍스트 필드를 생성한다.
		
		setLayout(new FlowLayout()); // 창의 레이아웃을 'FlowLayout'으로 설정한다. (컴포넌트들을 왼쪽에서 오른쪽으로 흐르듯이 배치)
		add(tf); // 텍스트 필드를 창에 추가한다.
		
		// ★★★ 텍스트 필드에 액션 리스너를 등록한다! (존나 중요!) ★★★
		// 'this'는 현재 'ActionEventEx' 객체 자신을 의미한다.
		// 텍스트 필드에서 액션 이벤트가 발생하면, 이 'ActionEventEx' 객체의 'actionPerformed' 메소드를 호출하라는 의미다!
		tf.addActionListener(this); // ★★★ 오류 수정! addActionListenr -> addActionListener! ★★★
		
		// 창의 크기를 설정한다.
		setSize(300, 300);
		// 창을 화면에 보이게 한다.
		setVisible(true);

		// ★★★ 창 닫기 버튼(X 버튼) 동작 추가! (존나 중요!) ★★★
		// 이거 없으면 창 닫아도 프로그램이 안 꺼진다, 씨발!
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 프로그램 강제 종료!
			}
		});
	}
	
	// --- 메인 메소드: 프로그램의 시작점! ---
	public static void main(String[] args) { // ★★★ 오류 수정! Strin[] args -> String[] args! ★★★
		new ActionEventEx(); // 'ActionEventEx' 객체를 생성한다. (이 순간 창이 뜨고 프로그램이 시작된다!)
	}
	
	// --- 액션 이벤트 처리 메소드! (인터페이스 구현!) ---
	// 'ActionListener' 인터페이스에 정의된 추상 메소드를 여기서 존나게 구현한다!
	// 텍스트 필드에 입력하고 엔터 치면 이 메소드가 호출된다!
	@Override
	public void actionPerformed(ActionEvent e) {
		// 이벤트가 발생한 소스가 'tf' (텍스트 필드)인지 확인한다.
		if(e.getSource() == tf) {
			String imsi = tf.getText(); // 텍스트 필드에 입력된 문자열을 'imsi'에 가져온다.
			System.out.println("메세지: " + imsi); // 콘솔에 메시지를 출력한다.
			tf.setText(""); // 텍스트 필드의 내용을 지운다. (다음 입력을 위해!)
		}
	}
}
