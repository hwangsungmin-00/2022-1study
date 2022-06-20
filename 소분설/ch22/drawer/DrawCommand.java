package hw.ch22.drawer;

import hw.ch22.command.Command;

import java.awt.Color;
import java.awt.Point;

public class DrawCommand implements Command {
    // 그림 그리는 대상
    protected Drawable drawable;
    // 그림 그리는 위치
    private Point position;
    // 생성자
    public DrawCommand(Drawable drawable, Point position) {
    	//Command cmd= new ColorCommand(drawable, Color.red);
        this.drawable = drawable;
        this.position = position;
    }
    // 실행 
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
