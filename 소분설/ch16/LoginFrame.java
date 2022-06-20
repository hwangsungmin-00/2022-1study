package hw.ch16;

import java.awt.Frame;
import java.awt.Label;
import java.awt.Color;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

// ������ ������ �ϴ� Ŭ����
public class LoginFrame extends Frame implements ActionListener, Mediator {
	private ColleagueCheckbox checkGuest;

	private ColleagueCheckbox checkLogin;
	
	private ColleagueCheckbox checkMember; //�߰�

	private ColleagueTextField textUser;

	private ColleagueTextField textPass;
	
	private ColleagueTextField textNumber; //�߰�

	private ColleagueButton buttonOk;

	private ColleagueButton buttonCancel;

	// ������
	// Colleague���� �����ؼ� ��ġ�� �Ŀ� ǥ�ø� �����Ѵ�.
	public LoginFrame(String title) {
		super(title);
		// ������ ����(setBackground( ) �̿�)
		setBackground(Color.lightGray);
		// ���̾ƿ� �Ŵ���: �������� �����ϴ� ���� ����� ��ġ�� �����Ѵ�.
		// �׸��� ���̾ƿ� �Ŵ����� ����ؼ� 4*2�� �׸��带 �����.
		// ��, ������ ������ 4�� 2���� ����
		setLayout(new GridLayout(5, 3)); //�߰�
		
		// Colleague���� ����
		createColleagues();
		
		// ������ Colleague���� ��ġ
		add(checkGuest);
		add(checkLogin);
		add(checkMember);//�߰�
		add(new Label("Username:"));
		add(textUser);
		add(new Label("")); //�߰�
		add(new Label("Password:"));
		add(textPass);
		add(new Label("")); //�߰�
		add(new Label("�ֹε�Ϲ�ȣ")); //�߰�
		add(textNumber); //�߰�
		add(new Label("")); //�߰�
		add(buttonOk);
		add(buttonCancel);
		add(new Label("")); //�߰�
		
		// �� üũ�ڽ� ��ȿ/��ȿ�� �ʱ�ȭ�Ѵ�.
		colleagueChanged(checkGuest);
		
		// ǥ��
		pack(); // ���Ե� ������Ʈ���� ���̾ƿ�(��ġ ����)�� �°� ������ ũ�⸦ �����Ѵ�.
		//show(); // �����츦 �����ش�.
		setVisible(true);
	}

	// Colleague���� �����Ѵ�.
	public void createColleagues() {
		// ����
		// Checkbox ���� 
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest", g, true);
		checkLogin = new ColleagueCheckbox("Login", g, false);
		checkMember = new ColleagueCheckbox("Member", g, false);
		
		textUser = new ColleagueTextField("", 10);
		textPass = new ColleagueTextField("", 10);
		textNumber = new ColleagueTextField("", 10);
		textPass.setEchoChar('*');
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		
		// Mediator�� �����Ѵ�. �� GUI ������Ʈ�� �����ڴ� ���� Ŭ���� �ڽ��̴�.
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		checkMember.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		textNumber.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		
		// Listener���� �����Ѵ�.
		checkGuest.addItemListener(checkGuest); // �ڽ��� �̺�Ʈ �����ʰ� �ȴ�
		checkLogin.addItemListener(checkLogin); // �ڽ��� �̺�Ʈ �����ʰ� �ȴ�
		checkMember.addItemListener(checkMember);
		textUser.addTextListener(textUser); // �ڽ��� �̺�Ʈ �����ʰ� �ȴ�
		textPass.addTextListener(textPass); // �ڽ��� �̺�Ʈ �����ʰ� �ȴ�
		textNumber.addTextListener(textNumber);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
	}

	// colleague�� ���°� ��ȭ���� ��, ȣ��Ǵ� �޼ҵ�
	// Colleague�κ����� ������ ����, ������ ������ �ľ��Ͽ� �� Colleague�� ��ȿ/��ȿ�� �����Ѵ�.
	// colleague�� ���� ��ȭ�� ���� �ش� colleague�� ���¸� 
	// ��� ��ȭ��ų ���ΰ��� ���� ������ ������ �ִ�.
	public void colleagueChanged(Colleague c) {
		// ���º�ȭ�� �߻��� ���� checkGuest�� checkLogin�̸�...
		if (c == checkGuest || c == checkLogin || c==checkMember) {
			if (checkGuest.getState()) { // checkGuest�� üũ�Ǿ��ٸ�...
				textUser.setColleagueEnabled(false);
				textPass.setColleagueEnabled(false);
				buttonOk.setColleagueEnabled(true);
			} else if(checkLogin.getState()){ // checkLogin�� üũ�Ǿ��ٸ�...
				textUser.setColleagueEnabled(true);
				//buttonOk.setColleagueEnabled(false);
				userpassChanged();  // user name �̳� password �ؽ�Ʈ�ʵ尡 �ٲ� ���̹Ƿ�...
			}
			else {
				textUser.setColleagueEnabled(true);
				textPass.setColleagueEnabled(false);
				textNumber.setColleagueEnabled(false);
				//buttonOk.setColleagueEnabled(false);
					userpassChanged();
				
				
				
			}
		}
		// ���º�ȭ�� �߻��� ���� textUser�� textPass�̸�...
		else if (c == textUser || c == textPass || c==textNumber) {
			userpassChanged();
		} else {
			System.out.println("colleagueChanged:unknown colleague = " + c);
		}
	}

	// TextField ���� ��ȭ�� ���� ��ư Ȱ��ȭ/��Ȱ��ȭ�Ѵ�.
	private void userpassChanged() {
		if (textUser.getText().length() >0) { // textUser�� ���� �� �ִٸ�...
			textPass.setColleagueEnabled(true); // textPass�� ��ȿȭ ��Ų��.
			if (textUser.getText().length() >0 && textPass.getText().length() >0) { // textPass�� ���� �� �ִٸ�...
				//buttonOk.setColleagueEnabled(true); // buttonOk�� ��ȿȭ��Ų��.
				userNumberChanged();
			} else {
				buttonOk.setColleagueEnabled(false); // textPass�� ���� �� ���� �ʴٸ�...
			}
		} else { // textUser�� ���� �� ���� �ʴٸ�... textPass�� buttonOk�� ��ȿȭ��Ų��.
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);
		}
		
	}
	
	private void userNumberChanged() {
		char arr[]=textNumber.getText().toCharArray();
		for(int i=0; i<arr.length; i++) {
			if(Character.isDigit(arr[i]) == true) {
				//buttonOk.setColleagueEnabled(true); // buttonOk�� ��ȿȭ��Ų��.
			}
			else {
				//buttonOk.setColleagueEnabled(false);
				
				JOptionPane.showMessageDialog(null, "���ڸ� �Է����� ������", "���", JOptionPane.WARNING_MESSAGE);
				//textNumber.getText().toString().substring(0, textNumber.getText().length()-1);
				textNumber.setText(textNumber.getText().toString().substring(0, textNumber.getText().length()-1));
				textNumber.setCaretPosition(textNumber.getText().toString().length());
			}
		}
		if (textPass.getText().length() > 0) { // textUser�� ���� �� �ִٸ�...
			textNumber.setColleagueEnabled(true); // textPass�� ��ȿȭ ��Ų��.
			if (textUser.getText().length() >0 && textPass.getText().length() >0 && textNumber.getText().length() == 13) { // textPass�� ���� �� �ִٸ�...
				buttonOk.setColleagueEnabled(true);
			} else {
				buttonOk.setColleagueEnabled(false); // textPass�� ���� �� ���� �ʴٸ�...
			}
		} else { // textUser�� ���� �� ���� �ʴٸ�... textPass�� buttonOk�� ��ȿȭ��Ų��.
			textNumber.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);
		}
	}

	// OK, Cancel ��ư�� �������� �� ����Ǵ� �޼ҵ�
	public void actionPerformed(ActionEvent e) { // ��ư�� ��������
		System.out.println("" + e); // �߻��� �̺�Ʈ�� ���� ������ ȭ�鿡 ����ϰ�
		System.exit(0); // ���α׷��� �����Ѵ�.
	}
}
