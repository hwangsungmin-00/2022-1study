package hw.ch22.drawer;

import hw.ch22.command.Command;
import java.awt.Color;

public class ColorCommand implements Command {
    // 그리는 대상
    protected Drawable drawable;
    // 그리는 색
    private Color color;
    // 생성자
    public ColorCommand(Drawable drawable, Color color) {
        this.drawable = drawable;
        this.color = color;
    }
    // 실행
    public void execute() {
        drawable.setColor(color);
    }
}
