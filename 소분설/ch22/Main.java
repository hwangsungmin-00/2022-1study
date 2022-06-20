package hw.ch22;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import hw.ch22.Main;
import hw.ch22.command.Command;
import hw.ch22.command.MacroCommand;
import hw.ch22.drawer.ColorCommand;
import hw.ch22.drawer.DrawCanvas;
import hw.ch22.drawer.DrawCommand;

public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {
	    // 그리기 이력
	    private MacroCommand history = new MacroCommand();
	    //  그리기 영역
	    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
	    
	    
	    // undo 버튼                                  
	    private JButton undoButton  = new JButton("undo");    
	    // redo 버튼                                  
	    private JButton redoButton  = new JButton("redo");   
	    
	    // 제거 버튼
	    private JButton clearButton  = new JButton("clear");
	    // 빨간 버튼                                           
	    private JButton redButton  = new JButton("red");        
	    // 녹색 버튼                                           
	    private JButton greenButton  = new JButton("green");    
	    // 파란 버튼                                          
	    private JButton blueButton  = new JButton("blue");      

	    // 생성자
	    public Main(String title) {
	        super(title);
	        Command cmd11 = new ColorCommand(canvas, Color.red);
		    history.append(cmd11);

	        this.addWindowListener(this);
	        canvas.addMouseMotionListener(this);
	        clearButton.addActionListener(this);
	        undoButton.addActionListener(this);     
	        redoButton.addActionListener(this);     
	        redButton.addActionListener(this);      
	        greenButton.addActionListener(this);    
	        blueButton.addActionListener(this);     
	        

	        Box buttonBox = new Box(BoxLayout.X_AXIS);
	        buttonBox.add(clearButton);
	        buttonBox.add(undoButton);           
	        buttonBox.add(redoButton);           
	        buttonBox.add(redButton);   
	        buttonBox.add(greenButton); 
	        buttonBox.add(blueButton);  
	        Box mainBox = new Box(BoxLayout.Y_AXIS);
	        mainBox.add(buttonBox);
	        mainBox.add(canvas);
	        getContentPane().add(mainBox);

	        pack();
	        setVisible(true);
	    }
	    
	    Command cmd0 = new ColorCommand(canvas, Color.red);
	   
	    // ActionListener용
	    public void actionPerformed(ActionEvent e) {
	    	//history.append(cmd0);
	    	//Command cmd= new ColorCommand(canvas, Color.red);
	        if (e.getSource() == clearButton) {
	            history.clear();
	            history.append(cmd0);                              
	            canvas.repaint();
	        } else if (e.getSource() == undoButton) {       
	            history.undo();
	            canvas.repaint();                           
	        } else if (e.getSource() == redoButton) {       
	            history.redo();
	            canvas.repaint(); 
	        } else if (e.getSource() == redButton) {                
	            Command cmd = new ColorCommand(canvas, Color.red);  
	            history.append(cmd); 
	            history.append(cmd); 
	            cmd.execute();                                      
	        } else if (e.getSource() == greenButton) {              
	        	Command cmd = new ColorCommand(canvas, Color.green);
	            history.append(cmd);  
	            history.append(cmd); 
	            cmd.execute();                                      
	        } else if (e.getSource() == blueButton) {               
	        	Command cmd = new ColorCommand(canvas, Color.blue); 
	            history.append(cmd);  
	            history.append(cmd); 
	            cmd.execute();                                      
	        }
	    }

	    // MouseMotionListener용
	    public void mouseMoved(MouseEvent e) {
	    }
	    public void mouseDragged(MouseEvent e) {
	        Command cmd = new DrawCommand(canvas, e.getPoint());
	        history.append(cmd);
	        cmd.execute();
	    }

	    // WindowListener용
	    public void windowClosing(WindowEvent e) {
	        System.exit(0);
	    }
	    public void windowActivated(WindowEvent e) {}
	    public void windowClosed(WindowEvent e) {}
	    public void windowDeactivated(WindowEvent e) {}
	    public void windowDeiconified(WindowEvent e) {}
	    public void windowIconified(WindowEvent e) {}
	    public void windowOpened(WindowEvent e) {}

	    public static void main(String[] args) {
	        new Main("Command Pattern Sample");
	    }
	}
