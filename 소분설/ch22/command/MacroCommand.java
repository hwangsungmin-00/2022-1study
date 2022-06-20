package hw.ch22.command;

import java.util.Stack;
import java.util.Iterator;

public class MacroCommand implements Command {
    // ����� ����
    private Stack commands = new Stack();
    private Stack commandsForRedo = new Stack();
    // ����
    public void execute() {
        Iterator it = commands.iterator();
        while (it.hasNext()) {
            ((Command)it.next()).execute();
        }
        
    }

    // �߰�
    public void append(Command cmd) {
        if (cmd != this) {
            commands.push(cmd);
        }
    }
    // ������ ����� ����
    public void undo() {
        if (!commands.empty()) {
            commandsForRedo.push(commands.pop());
            commands.pop();
        }
    }
    
    
    public void redo() {
    	if (!commandsForRedo.empty()) {
            commands.push(commandsForRedo.pop());//�̰� �׷���ߵǴµ� ������
        }else {
        	System.out.print("stack�������");
        }
    }
    // ���� ����
    public void clear() {
        commands.clear();
    }
}
