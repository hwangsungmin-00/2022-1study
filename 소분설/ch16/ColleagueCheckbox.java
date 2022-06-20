package hw.ch16;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ColleagueCheckbox extends Checkbox implements ItemListener,
		Colleague {
	private Mediator mediator;

	public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) { // 생성자
		super(caption, group, state);
	}

	public void setMediator(Mediator mediator) { // Mediator를 보관
		this.mediator = mediator;
	}

	// “카운셀러가 내리는 지시”에 해당함
	public void setColleagueEnabled(boolean enabled) { 
		setEnabled(enabled);
	}

	// 라디오버튼의 상태가 바뀌었을 때, ItemEvent가 발생되고, 
	// 등록된 ItemListener의 이 메소드가 자동으로 호출된다.
	public void itemStateChanged(ItemEvent e) {
		mediator.colleagueChanged(this);  // 상태가 변하면 Mediator에게 통지한다.
	}
}
