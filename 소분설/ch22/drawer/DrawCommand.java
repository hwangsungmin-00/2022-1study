package hw.ch22.drawer;

import hw.ch22.command.Command;

import java.awt.Color;
import java.awt.Point;

public class DrawCommand implements Command {
    // �׸� �׸��� ���
    protected Drawable drawable;
    // �׸� �׸��� ��ġ
    private Point position;
    // ������
    public DrawCommand(Drawable drawable, Point position) {
    	//Command cmd= new ColorCommand(drawable, Color.red);
        this.drawable = drawable;
        this.position = position;
    }
    // ���� 
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
