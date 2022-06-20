package hw.ch16;

import java.awt.TextField;
import java.awt.Color;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;

// java.awt.event.TextListener 인터페이스도 구현함
// 텍스트 필드의 내용이 바뀌었을 때, TextEvent를 처리하는 textValueChanged 메소드를 제공한다.
public class ColleagueTextField extends TextField implements TextListener, Colleague {
	private Mediator mediator;

	public ColleagueTextField(String text, int columns) { // 생성자
		super(text, columns);
	}

	// 입력 인자로 들어온 Mediator를 멤버 변수인 mediator에 할당함
	public void setMediator(Mediator mediator) { 
		this.mediator = mediator;
	}

	// TextFiled 클래스에서 물려받은 setEnabled(boolean)를 호출하여 유효/무효를 설정한다.
	public void setColleagueEnabled(boolean enabled) { 
		setEnabled(enabled);
		// enabled가 true이면, 배경색을 흰색으로, enabled가 false이면 배경색을 회색으로 칠한다.
		// white, ligthGray: Color 클래스에 선언되어 있는 상수
		setBackground(enabled ? Color.white : Color.lightGray);
	}

	// TextListener 인터페이스에 정의되어 있는 메소드
	// TextField의 값이 바뀔 때마다, TextEvent가 발생되고, 이 메소드가 자동으로 호출된다.
	public void textValueChanged(TextEvent e) {
		mediator.colleagueChanged(this);  // 문자열이 변하면 Mediator에게 통지한다.
	}

	public void substring(int i) {
		// TODO Auto-generated method stub
		
	}

	public void substring(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public void setText() {
		// TODO Auto-generated method stub
		
	}
}
