package hw.ch20;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class BigCharGui extends Frame implements ActionListener {
	
	private JButton buttonShare = new JButton("공유해서 큰 문자 생성");      // 공유 버튼
    private JButton buttonNShare = new JButton("공유하지 않고 큰 문자 생성");  //안 공유 버튼
    
    private JTextField textInput = new JTextField(60);        // 입력
    private JTextField textUsage1 = new JTextField(20); //메모리 사용량1
    private JTextField textUsage2 = new JTextField(20); //메모리 사용량2
    private JTextArea textArea1 = new JTextArea(10, 30);
    private JScrollPane scroll1 = new JScrollPane(textArea1);
    private JTextArea textArea2 = new JTextArea(10, 30);
    private JScrollPane scroll2 = new JScrollPane(textArea2);
    

	public BigCharGui(String title) {
		super(title);
		setTitle("20200965 황성민");
		setSize(100, 100);
		setLayout(new BorderLayout());
		
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(0, 2));
		
		JPanel p2=new JPanel();
		//p2.setLayout(new GridLayout(3, 1));
		p2.add(buttonShare);
		p2.add(textUsage1);
		p2.add(scroll1);
		
		JPanel p3=new JPanel();
		//p3.setLayout(new GridLayout(3, 1));
		p3.add(buttonNShare);
		p3.add(textUsage2);
		p3.add(scroll2);
		
		p1.add(p2);
		p1.add(p3);
		
		add(textInput, BorderLayout.NORTH);
		add(p1, BorderLayout.CENTER);
		
		pack();
        show();
        
        buttonShare.addActionListener(this);
        buttonNShare.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//String k=textInput.getText();
		System.out.println("" + e);
        if (e.getSource() == buttonShare) {           // 공유 버튼
            testAllocation(true);
            
        } else if (e.getSource() == buttonNShare) {  // 안공유 버튼
        	testAllocation(false);
        }
        /*
        if (k.length() == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }
        */
	}
	
	private BigString[] bsarray = new BigString[1000];
	
	public void testAllocation(boolean shared) {
		String text="";
		
        for (int i = 0; i < bsarray.length; i++) {
            bsarray[i] = new BigString(textInput.getText(), shared);
            text=bsarray[i].print();
        }
        
        if(shared) {
        	textArea1.setFont(new Font("바탕체", Font.PLAIN, 15));
        	textArea1.setText("");
        	textArea1.setText(text);
        }
        else {
        	textArea2.setFont(new Font("바탕체", Font.PLAIN, 15));
        	textArea2.setText("");
        	textArea2.setText(text);
        }
        showMemory(shared);
    }
    public void showMemory(boolean shared) {
        Runtime.getRuntime().gc();
        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("사용 메모리 = " + used);
        if(shared) {
        	textUsage1.setText("사용 메모리 = " + used);
        }
        else {
        	textUsage2.setText("사용 메모리 = " + used);
        }
    }
}
